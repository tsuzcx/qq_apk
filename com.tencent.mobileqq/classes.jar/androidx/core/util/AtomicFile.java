package androidx.core.util;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile
{
  private final File mBackupName;
  private final File mBaseName;
  
  public AtomicFile(@NonNull File paramFile)
  {
    this.mBaseName = paramFile;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile.getPath());
    localStringBuilder.append(".bak");
    this.mBackupName = new File(localStringBuilder.toString());
  }
  
  private static boolean sync(@NonNull FileOutputStream paramFileOutputStream)
  {
    try
    {
      paramFileOutputStream.getFD().sync();
      return true;
    }
    catch (IOException paramFileOutputStream)
    {
      label9:
      break label9;
    }
    return false;
  }
  
  public void delete()
  {
    this.mBaseName.delete();
    this.mBackupName.delete();
  }
  
  public void failWrite(@Nullable FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null)
    {
      sync(paramFileOutputStream);
      try
      {
        paramFileOutputStream.close();
        this.mBaseName.delete();
        this.mBackupName.renameTo(this.mBaseName);
        return;
      }
      catch (IOException paramFileOutputStream)
      {
        Log.w("AtomicFile", "failWrite: Got exception:", paramFileOutputStream);
      }
    }
  }
  
  public void finishWrite(@Nullable FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null)
    {
      sync(paramFileOutputStream);
      try
      {
        paramFileOutputStream.close();
        this.mBackupName.delete();
        return;
      }
      catch (IOException paramFileOutputStream)
      {
        Log.w("AtomicFile", "finishWrite: Got exception:", paramFileOutputStream);
      }
    }
  }
  
  @NonNull
  public File getBaseFile()
  {
    return this.mBaseName;
  }
  
  @NonNull
  public FileInputStream openRead()
  {
    if (this.mBackupName.exists())
    {
      this.mBaseName.delete();
      this.mBackupName.renameTo(this.mBaseName);
    }
    return new FileInputStream(this.mBaseName);
  }
  
  @NonNull
  public byte[] readFully()
  {
    FileInputStream localFileInputStream = openRead();
    try
    {
      Object localObject1 = new byte[localFileInputStream.available()];
      int i = 0;
      for (;;)
      {
        int j = localFileInputStream.read((byte[])localObject1, i, localObject1.length - i);
        if (j <= 0)
        {
          localFileInputStream.close();
          return localObject1;
        }
        j = i + j;
        int k = localFileInputStream.available();
        i = j;
        if (k > localObject1.length - j)
        {
          byte[] arrayOfByte = new byte[k + j];
          System.arraycopy(localObject1, 0, arrayOfByte, 0, j);
          localObject1 = arrayOfByte;
          i = j;
        }
      }
      throw localObject2;
    }
    finally
    {
      localFileInputStream.close();
    }
    for (;;) {}
  }
  
  @NonNull
  public FileOutputStream startWrite()
  {
    if (this.mBaseName.exists()) {
      if (!this.mBackupName.exists())
      {
        if (!this.mBaseName.renameTo(this.mBackupName))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Couldn't rename file ");
          ((StringBuilder)localObject).append(this.mBaseName);
          ((StringBuilder)localObject).append(" to backup file ");
          ((StringBuilder)localObject).append(this.mBackupName);
          Log.w("AtomicFile", ((StringBuilder)localObject).toString());
        }
      }
      else {
        this.mBaseName.delete();
      }
    }
    try
    {
      localObject = new FileOutputStream(this.mBaseName);
      return localObject;
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      label109:
      break label109;
    }
    if (this.mBaseName.getParentFile().mkdirs()) {}
    try
    {
      localObject = new FileOutputStream(this.mBaseName);
      return localObject;
    }
    catch (FileNotFoundException localFileNotFoundException2)
    {
      label136:
      break label136;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Couldn't create ");
    ((StringBuilder)localObject).append(this.mBaseName);
    throw new IOException(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Couldn't create directory ");
    ((StringBuilder)localObject).append(this.mBaseName);
    throw new IOException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.util.AtomicFile
 * JD-Core Version:    0.7.0.1
 */