package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

public class RC4EncryptedFileSystem
  extends WrapperFileSystem<FileSystem>
{
  public static final Parcelable.Creator<RC4EncryptedFileSystem> CREATOR = new RC4EncryptedFileSystem.1();
  private static final String TAG = "MicroMsg.RC4EncryptedFileSystem";
  private static final int VERSION = 2;
  private final String mId;
  private volatile Key mKey;
  private final FileSystemManager.KeyGen mKeyGen;
  private final boolean mRegenerateFree;
  
  private RC4EncryptedFileSystem(Parcel paramParcel)
  {
    super(paramParcel);
    VFSUtils.checkFileSystemVersion(paramParcel, RC4EncryptedFileSystem.class, 2);
    this.mKeyGen = FileSystemManager.getKeyGenerator();
    this.mId = paramParcel.readString();
    paramParcel = this.mKeyGen;
    if (paramParcel != null)
    {
      this.mKey = paramParcel.generate(this.mId, FileSystemManager.instance().staticEnvironment());
      boolean bool;
      if (this.mKey != null) {
        bool = true;
      } else {
        bool = false;
      }
      this.mRegenerateFree = bool;
      return;
    }
    throw new RuntimeException("Set global generator by calling setGlobalKeyGenerator(...) before initializing FileSystem objects.");
  }
  
  public RC4EncryptedFileSystem(FileSystem paramFileSystem, String paramString)
  {
    super(paramFileSystem);
    this.mKeyGen = FileSystemManager.getKeyGenerator();
    this.mId = paramString;
    paramFileSystem = this.mKeyGen;
    if (paramFileSystem != null)
    {
      this.mKey = paramFileSystem.generate(this.mId, FileSystemManager.instance().staticEnvironment());
      boolean bool;
      if (this.mKey != null) {
        bool = true;
      } else {
        bool = false;
      }
      this.mRegenerateFree = bool;
      return;
    }
    throw new RuntimeException("Set global generator by calling setKeyGenerator(...) before initializing FileSystem objects.");
  }
  
  public RC4EncryptedFileSystem(String paramString1, String paramString2)
  {
    this(new NativeFileSystem(paramString1), paramString2);
  }
  
  public int capabilityFlags()
  {
    return this.mFS.capabilityFlags() & 0xFFFFFFED;
  }
  
  public void configure(Map<String, String> paramMap)
  {
    super.configure(paramMap);
    if (!this.mRegenerateFree) {
      this.mKey = this.mKeyGen.generate(this.mId, paramMap);
    }
  }
  
  protected long copyFileImpl(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    if ((paramFileSystem instanceof RC4EncryptedFileSystem))
    {
      RC4EncryptedFileSystem localRC4EncryptedFileSystem = (RC4EncryptedFileSystem)paramFileSystem;
      if ((localRC4EncryptedFileSystem.mKeyGen == this.mKeyGen) && (localRC4EncryptedFileSystem.mId.equals(this.mId)) && (localRC4EncryptedFileSystem.mKey.equals(this.mKey)) && ((this.mFS instanceof AbstractFileSystem))) {
        return ((AbstractFileSystem)this.mFS).copyFileImpl(paramString1, localRC4EncryptedFileSystem.mFS, paramString2);
      }
    }
    return super.copyFileImpl(paramString1, paramFileSystem, paramString2);
  }
  
  protected boolean moveFileImpl(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    if ((paramFileSystem instanceof RC4EncryptedFileSystem))
    {
      RC4EncryptedFileSystem localRC4EncryptedFileSystem = (RC4EncryptedFileSystem)paramFileSystem;
      if ((localRC4EncryptedFileSystem.mKeyGen == this.mKeyGen) && (localRC4EncryptedFileSystem.mId.equals(this.mId)) && (localRC4EncryptedFileSystem.mKey.equals(this.mKey)) && ((this.mFS instanceof AbstractFileSystem))) {
        return ((AbstractFileSystem)this.mFS).moveFileImpl(paramString1, localRC4EncryptedFileSystem.mFS, paramString2);
      }
    }
    return super.moveFileImpl(paramString1, paramFileSystem, paramString2);
  }
  
  public InputStream openRead(String paramString)
  {
    Object localObject = this.mKey;
    if (localObject != null) {
      try
      {
        Cipher localCipher = Cipher.getInstance("RC4");
        localCipher.init(2, (Key)localObject);
        paramString = new CipherInputStream(this.mFS.openRead(paramString), localCipher);
        return paramString;
      }
      catch (GeneralSecurityException paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to initialize cipher: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        throw ((FileNotFoundException)new FileNotFoundException(((StringBuilder)localObject).toString()).initCause(paramString));
      }
    }
    throw new FileNotFoundException("Key is not initialized.");
  }
  
  public OutputStream openWrite(String paramString, boolean paramBoolean)
  {
    Object localObject = this.mKey;
    if (localObject != null)
    {
      if (!paramBoolean) {
        try
        {
          Cipher localCipher = Cipher.getInstance("RC4");
          localCipher.init(1, (Key)localObject);
          paramString = new CipherOutputStream(this.mFS.openWrite(paramString, false), localCipher);
          return paramString;
        }
        catch (GeneralSecurityException paramString)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Failed to initialize cipher: ");
          ((StringBuilder)localObject).append(paramString.getMessage());
          throw ((FileNotFoundException)new FileNotFoundException(((StringBuilder)localObject).toString()).initCause(paramString));
        }
      }
      throw new FileNotFoundException("Appending encrypted files is not supported.");
    }
    throw new FileNotFoundException("Key is not initialized.");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RC4 [");
    localStringBuilder.append(this.mFS.toString());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    VFSUtils.writeFileSystemVersion(paramParcel, RC4EncryptedFileSystem.class, 2);
    paramParcel.writeString(this.mId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.RC4EncryptedFileSystem
 * JD-Core Version:    0.7.0.1
 */