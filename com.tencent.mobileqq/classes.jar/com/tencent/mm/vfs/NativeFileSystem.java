package com.tencent.mm.vfs;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Map;

public class NativeFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<NativeFileSystem> CREATOR = new NativeFileSystem.2();
  private static final long DEFAULT_BLOCK_SIZE = 4096L;
  private static final String TAG = "VFS.NativeFileSystem";
  private static final int VERSION = 2;
  private final String mBasePath;
  private boolean mBasePathCreateSuccess;
  private boolean mBasePathCreated;
  private boolean mHasMacro;
  private final boolean mMacroFree;
  private volatile String mRealBasePath;
  
  protected NativeFileSystem(Parcel paramParcel)
  {
    VFSUtils.checkFileSystemVersion(paramParcel, NativeFileSystem.class, 2);
    boolean bool;
    if (paramParcel.readInt() == 1)
    {
      bool = true;
      this.mHasMacro = bool;
      paramParcel = paramParcel.readString();
      if (paramParcel != null) {
        break label77;
      }
    }
    label77:
    for (paramParcel = "";; paramParcel = VFSUtils.normalizePathSimple(paramParcel))
    {
      this.mBasePath = paramParcel;
      if (!this.mBasePath.isEmpty()) {
        break label85;
      }
      this.mRealBasePath = this.mBasePath;
      this.mMacroFree = true;
      this.mBasePathCreated = true;
      return;
      bool = false;
      break;
    }
    label85:
    paramParcel = this.mBasePath;
    if (this.mHasMacro) {
      paramParcel = VFSUtils.macroResolve(this.mBasePath, FileSystemManager.instance().staticEnvironment());
    }
    if (paramParcel != null) {
      ensureBasePath(paramParcel);
    }
    for (this.mMacroFree = true;; this.mMacroFree = false)
    {
      this.mBasePathCreated = false;
      return;
      this.mRealBasePath = null;
    }
  }
  
  public NativeFileSystem(String paramString)
  {
    this(paramString, true);
  }
  
  public NativeFileSystem(String paramString, boolean paramBoolean)
  {
    this.mBasePath = VFSUtils.normalizePathSimple(paramString);
    this.mHasMacro = paramBoolean;
    if (this.mBasePath.isEmpty())
    {
      this.mRealBasePath = this.mBasePath;
      this.mMacroFree = true;
      this.mBasePathCreated = true;
      return;
    }
    paramString = this.mBasePath;
    if (paramBoolean) {
      paramString = VFSUtils.macroResolve(this.mBasePath, FileSystemManager.instance().staticEnvironment());
    }
    if (paramString != null) {
      ensureBasePath(paramString);
    }
    for (this.mMacroFree = true;; this.mMacroFree = false)
    {
      this.mBasePathCreated = false;
      return;
      this.mRealBasePath = null;
    }
  }
  
  /* Error */
  private static long channelCopy(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: aload_2
    //   5: invokeinterface 110 2 0
    //   10: astore_1
    //   11: new 112	java/io/FileOutputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 114	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   19: invokevirtual 118	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   22: astore_2
    //   23: getstatic 123	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 23
    //   28: if_icmple +25 -> 53
    //   31: aload_2
    //   32: aload_1
    //   33: lconst_0
    //   34: ldc2_w 124
    //   37: invokevirtual 131	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   40: lstore 4
    //   42: aload_2
    //   43: invokestatic 135	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   46: aload_1
    //   47: invokestatic 135	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   50: lload 4
    //   52: lreturn
    //   53: sipush 8192
    //   56: invokestatic 141	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   59: astore_0
    //   60: lconst_0
    //   61: lstore 4
    //   63: aload_1
    //   64: aload_0
    //   65: invokeinterface 147 2 0
    //   70: istore_3
    //   71: iload_3
    //   72: ifge +14 -> 86
    //   75: aload_2
    //   76: invokestatic 135	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   79: aload_1
    //   80: invokestatic 135	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   83: lload 4
    //   85: lreturn
    //   86: aload_0
    //   87: invokevirtual 151	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   90: pop
    //   91: lload 4
    //   93: aload_2
    //   94: aload_0
    //   95: invokevirtual 154	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   98: i2l
    //   99: ladd
    //   100: lstore 4
    //   102: aload_0
    //   103: invokevirtual 157	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   106: pop
    //   107: goto -44 -> 63
    //   110: astore_0
    //   111: aload_2
    //   112: invokestatic 135	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   115: aload_1
    //   116: invokestatic 135	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   119: aload_0
    //   120: athrow
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_1
    //   124: aload 6
    //   126: astore_2
    //   127: goto -16 -> 111
    //   130: astore_0
    //   131: aload 6
    //   133: astore_2
    //   134: goto -23 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramString1	String
    //   0	137	1	paramFileSystem	FileSystem
    //   0	137	2	paramString2	String
    //   70	2	3	i	int
    //   40	61	4	l	long
    //   1	131	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	42	110	finally
    //   53	60	110	finally
    //   63	71	110	finally
    //   86	107	110	finally
    //   3	11	121	finally
    //   11	23	130	finally
  }
  
  private void ensureBasePath(String paramString)
  {
    File localFile;
    if (this.mHasMacro) {
      localFile = new File(paramString);
    }
    for (;;)
    {
      try
      {
        paramString = localFile.getCanonicalFile();
        if ((!paramString.isDirectory()) && (paramString.exists()))
        {
          QLog.e("VFS.NativeFileSystem", 1, "Base directory exists but is not a directory, delete and proceed.Base path: " + paramString.getPath());
          paramString.delete();
        }
        this.mRealBasePath = paramString.getPath();
        if (QLog.isColorLevel()) {
          QLog.i("VFS.NativeFileSystem", 2, "Real path resolved: " + this.mBasePath + " => " + this.mRealBasePath);
        }
        return;
      }
      catch (IOException paramString)
      {
        paramString = localFile.getAbsoluteFile();
        continue;
      }
      this.mRealBasePath = paramString;
    }
  }
  
  private static int modeToMode(String paramString)
  {
    if ("r".equals(paramString)) {
      return 268435456;
    }
    if (("w".equals(paramString)) || ("wt".equals(paramString))) {
      return 738197504;
    }
    if ("wa".equals(paramString)) {
      return 704643072;
    }
    if ("rw".equals(paramString)) {
      return 939524096;
    }
    if ("rwt".equals(paramString)) {
      return 1006632960;
    }
    throw new IllegalArgumentException("Invalid mode: " + paramString);
  }
  
  private static boolean recursiveDelete(File paramFile, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      bool1 = bool2;
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.isDirectory()) {
          bool2 &= recursiveDelete(localFile, false);
        }
        for (;;)
        {
          i += 1;
          break;
          bool2 &= localFile.delete();
        }
      }
    }
    bool2 = bool1;
    if (!paramBoolean) {
      bool2 = bool1 & paramFile.delete();
    }
    return bool2;
  }
  
  private FileSystem.FileEntry toFileEntry(File paramFile)
  {
    String str1 = this.mRealBasePath;
    if (!paramFile.getPath().startsWith(str1)) {
      throw new RuntimeException("Illegal file: " + paramFile + " (base: " + str1 + ")");
    }
    if (paramFile.getPath().length() == str1.length()) {}
    String str2;
    int i;
    for (str1 = "";; str1 = paramFile.getPath().substring(i + 1))
    {
      str2 = paramFile.getName();
      if (Build.VERSION.SDK_INT < 21) {
        break;
      }
      return NativeFileSystem.Compat21.toFileEntry(paramFile, this, str1, str2);
      i = str1.length();
    }
    if (!paramFile.exists()) {
      return null;
    }
    boolean bool = paramFile.isDirectory();
    long l = paramFile.length();
    return new FileSystem.FileEntry(this, str1, str2, l, 0xFFFFF000 & 4096L + l - 1L, paramFile.lastModified(), bool);
  }
  
  public String basePath()
  {
    return this.mRealBasePath;
  }
  
  public int capabilityFlags()
  {
    return 31;
  }
  
  public void configure(Map<String, String> paramMap)
  {
    String str1;
    if (!this.mMacroFree)
    {
      String str2 = this.mRealBasePath;
      str1 = this.mBasePath;
      if (this.mHasMacro) {
        str1 = VFSUtils.macroResolve(this.mBasePath, paramMap);
      }
      if ((str1 == null) || (str1.equals(str2))) {
        break label56;
      }
      ensureBasePath(str1);
      this.mBasePathCreated = false;
    }
    label56:
    while (str1 != null) {
      return;
    }
    this.mRealBasePath = null;
    this.mBasePathCreated = false;
  }
  
  protected long copyFileImpl(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    String str = realPath(paramString1, true);
    if (str == null) {
      throw new IOException("Invalid path: " + paramString1);
    }
    return channelCopy(str, paramFileSystem, paramString2);
  }
  
  public boolean delete(String paramString)
  {
    paramString = realPath(paramString, false);
    if (paramString == null) {
      return false;
    }
    return new File(paramString).delete();
  }
  
  public boolean deleteDir(String paramString, boolean paramBoolean)
  {
    if ((paramString.isEmpty()) || (paramString.equals("/"))) {}
    for (boolean bool = true;; bool = false)
    {
      paramString = new File(realPath(paramString, false));
      if (paramString.isDirectory()) {
        break;
      }
      return false;
    }
    if (paramBoolean) {}
    for (paramBoolean = recursiveDelete(paramString, bool);; paramBoolean = paramString.delete()) {
      return paramBoolean;
    }
  }
  
  public boolean exists(String paramString)
  {
    boolean bool2 = false;
    paramString = realPath(paramString, false);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (new File(paramString).exists()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public FileSystem.FsStat fileSystemStat(String paramString)
  {
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    for (;;)
    {
      try
      {
        paramString = new StatFs(realPath((String)localObject, false));
        localObject = new FileSystem.FsStat();
        if (Build.VERSION.SDK_INT >= 18)
        {
          ((FileSystem.FsStat)localObject).blockSize = paramString.getBlockSizeLong();
          ((FileSystem.FsStat)localObject).availableBlocks = paramString.getAvailableBlocksLong();
          ((FileSystem.FsStat)localObject).totalBlocks = paramString.getBlockCountLong();
          ((FileSystem.FsStat)localObject).availableSpace = (((FileSystem.FsStat)localObject).availableBlocks * ((FileSystem.FsStat)localObject).blockSize);
          ((FileSystem.FsStat)localObject).totalSpace = (((FileSystem.FsStat)localObject).totalBlocks * ((FileSystem.FsStat)localObject).blockSize);
          return localObject;
        }
      }
      catch (RuntimeException paramString)
      {
        return null;
      }
      ((FileSystem.FsStat)localObject).blockSize = paramString.getBlockSize();
      ((FileSystem.FsStat)localObject).availableBlocks = paramString.getAvailableBlocks();
      ((FileSystem.FsStat)localObject).totalBlocks = paramString.getBlockCount();
    }
  }
  
  public Iterable<FileSystem.FileEntry> list(String paramString, boolean paramBoolean)
  {
    paramString = new File(realPath(paramString, false));
    if (!paramString.isDirectory()) {
      return null;
    }
    return new NativeFileSystem.1(this, paramString, paramBoolean);
  }
  
  public boolean mkdirs(String paramString)
  {
    boolean bool = true;
    paramString = realPath(paramString, true);
    if (paramString == null) {
      bool = false;
    }
    do
    {
      return bool;
      if ((!this.mBasePathCreateSuccess) || (!TextUtils.equals(paramString, this.mRealBasePath))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VFS.NativeFileSystem", 2, "mkdirs is called! basePath has been created!");
    return true;
    return new File(paramString).mkdirs();
  }
  
  protected boolean moveFileImpl(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramFileSystem.capabilityFlags() & 0x2) != 0)
    {
      paramFileSystem = paramFileSystem.realPath(paramString2, false);
      paramString1 = realPath(paramString1, true);
      bool1 = bool2;
      if (paramFileSystem != null)
      {
        bool1 = bool2;
        if (paramString1 != null)
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label68;
          }
          bool1 = NativeFileSystem.Compat21.rename(paramFileSystem, paramString1);
        }
      }
    }
    return bool1;
    label68:
    return new File(paramFileSystem).renameTo(new File(paramString1));
  }
  
  public ParcelFileDescriptor openParcelFd(String paramString1, String paramString2)
  {
    String str = realPath(paramString1, true);
    if (str == null) {
      throw new FileNotFoundException("Invalid path: " + paramString1);
    }
    return ParcelFileDescriptor.open(new File(str), modeToMode(paramString2));
  }
  
  public InputStream openRead(String paramString)
  {
    String str = realPath(paramString, false);
    if (str == null) {
      throw new FileNotFoundException("Invalid path: " + paramString);
    }
    return new NativeFileSystem.SeekableFileInputStream(str);
  }
  
  public ReadableByteChannel openReadChannel(String paramString)
  {
    String str = realPath(paramString, false);
    if (str == null) {
      throw new FileNotFoundException("Invalid path: " + paramString);
    }
    return new FileInputStream(str).getChannel();
  }
  
  public ByteChannel openReadWriteChannel(String paramString)
  {
    String str = realPath(paramString, true);
    if (str == null) {
      throw new FileNotFoundException("Invalid path: " + paramString);
    }
    return new RandomAccessFile(str, "rw").getChannel();
  }
  
  public OutputStream openWrite(String paramString, boolean paramBoolean)
  {
    String str = realPath(paramString, true);
    if (str == null) {
      throw new FileNotFoundException("Invalid path: " + paramString);
    }
    return new FileOutputStream(str, paramBoolean);
  }
  
  public WritableByteChannel openWriteChannel(String paramString, boolean paramBoolean)
  {
    String str = realPath(paramString, true);
    if (str == null) {
      throw new FileNotFoundException("Invalid path: " + paramString);
    }
    return new FileOutputStream(str, paramBoolean).getChannel();
  }
  
  public String realPath(String paramString, boolean paramBoolean)
  {
    String str = this.mRealBasePath;
    if (str == null) {
      throw new IllegalStateException("Base path cannot be resolved: " + this.mBasePath);
    }
    if ((paramBoolean) && (!this.mBasePathCreated))
    {
      this.mBasePathCreateSuccess = new File(this.mRealBasePath).mkdirs();
      this.mBasePathCreated = true;
    }
    if (paramString.isEmpty()) {
      return str;
    }
    return str + '/' + paramString;
  }
  
  public boolean setModifiedTime(String paramString, long paramLong)
  {
    return new File(realPath(paramString, true)).setLastModified(paramLong);
  }
  
  public FileSystem.FileEntry stat(String paramString)
  {
    return toFileEntry(new File(realPath(paramString, false)));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Native [");
    if (this.mRealBasePath == null) {}
    for (String str = this.mBasePath;; str = this.mRealBasePath) {
      return str + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    VFSUtils.writeFileSystemVersion(paramParcel, NativeFileSystem.class, 2);
    if (this.mHasMacro) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.mBasePath);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.NativeFileSystem
 * JD-Core Version:    0.7.0.1
 */