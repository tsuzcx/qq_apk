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
    if (paramParcel.readInt() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.mHasMacro = bool;
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {
      paramParcel = "";
    } else {
      paramParcel = VFSUtils.normalizePathSimple(paramParcel);
    }
    this.mBasePath = paramParcel;
    if (this.mBasePath.isEmpty())
    {
      this.mRealBasePath = this.mBasePath;
      this.mMacroFree = true;
      this.mBasePathCreated = true;
      return;
    }
    String str = this.mBasePath;
    paramParcel = str;
    if (this.mHasMacro) {
      paramParcel = VFSUtils.macroResolve(str, FileSystemManager.instance().staticEnvironment());
    }
    if (paramParcel != null)
    {
      ensureBasePath(paramParcel);
      this.mMacroFree = true;
    }
    else
    {
      this.mRealBasePath = null;
      this.mMacroFree = false;
    }
    this.mBasePathCreated = false;
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
    String str = this.mBasePath;
    paramString = str;
    if (paramBoolean) {
      paramString = VFSUtils.macroResolve(str, FileSystemManager.instance().staticEnvironment());
    }
    if (paramString != null)
    {
      ensureBasePath(paramString);
      this.mMacroFree = true;
    }
    else
    {
      this.mRealBasePath = null;
      this.mMacroFree = false;
    }
    this.mBasePathCreated = false;
  }
  
  /* Error */
  private static long channelCopy(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: invokeinterface 110 2 0
    //   7: astore_2
    //   8: new 112	java/io/FileOutputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 114	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   16: invokevirtual 118	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   19: astore_0
    //   20: getstatic 123	android/os/Build$VERSION:SDK_INT	I
    //   23: bipush 23
    //   25: if_icmple +23 -> 48
    //   28: aload_0
    //   29: aload_2
    //   30: lconst_0
    //   31: ldc2_w 124
    //   34: invokevirtual 131	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   37: lstore_3
    //   38: aload_0
    //   39: invokestatic 135	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   42: aload_2
    //   43: invokestatic 135	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   46: lload_3
    //   47: lreturn
    //   48: lconst_0
    //   49: lstore_3
    //   50: sipush 8192
    //   53: invokestatic 141	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   56: astore_1
    //   57: aload_2
    //   58: aload_1
    //   59: invokeinterface 147 2 0
    //   64: ifge +6 -> 70
    //   67: goto -29 -> 38
    //   70: aload_1
    //   71: invokevirtual 151	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   74: pop
    //   75: lload_3
    //   76: aload_0
    //   77: aload_1
    //   78: invokevirtual 154	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   81: i2l
    //   82: ladd
    //   83: lstore_3
    //   84: aload_1
    //   85: invokevirtual 157	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   88: pop
    //   89: goto -32 -> 57
    //   92: astore_1
    //   93: goto +14 -> 107
    //   96: astore_1
    //   97: aconst_null
    //   98: astore_0
    //   99: goto +8 -> 107
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: astore_2
    //   107: aload_0
    //   108: invokestatic 135	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   111: aload_2
    //   112: invokestatic 135	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   115: goto +5 -> 120
    //   118: aload_1
    //   119: athrow
    //   120: goto -2 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramString1	String
    //   0	123	1	paramFileSystem	FileSystem
    //   0	123	2	paramString2	String
    //   37	47	3	l	long
    // Exception table:
    //   from	to	target	type
    //   20	38	92	finally
    //   50	57	92	finally
    //   57	67	92	finally
    //   70	89	92	finally
    //   8	20	96	finally
    //   0	8	102	finally
  }
  
  private void ensureBasePath(String paramString)
  {
    Object localObject;
    if (this.mHasMacro) {
      localObject = new File(paramString);
    }
    try
    {
      paramString = ((File)localObject).getCanonicalFile();
    }
    catch (IOException paramString)
    {
      label24:
      break label24;
    }
    paramString = ((File)localObject).getAbsoluteFile();
    if ((!paramString.isDirectory()) && (paramString.exists()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Base directory exists but is not a directory, delete and proceed.Base path: ");
      ((StringBuilder)localObject).append(paramString.getPath());
      QLog.e("VFS.NativeFileSystem", 1, ((StringBuilder)localObject).toString());
      paramString.delete();
    }
    this.mRealBasePath = paramString.getPath();
    break label98;
    this.mRealBasePath = paramString;
    label98:
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("Real path resolved: ");
      paramString.append(this.mBasePath);
      paramString.append(" => ");
      paramString.append(this.mRealBasePath);
      QLog.i("VFS.NativeFileSystem", 2, paramString.toString());
    }
  }
  
  private static int modeToMode(String paramString)
  {
    if ("r".equals(paramString)) {
      return 268435456;
    }
    if ((!"w".equals(paramString)) && (!"wt".equals(paramString)))
    {
      if ("wa".equals(paramString)) {
        return 704643072;
      }
      if ("rw".equals(paramString)) {
        return 939524096;
      }
      if ("rwt".equals(paramString)) {
        return 1006632960;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid mode: ");
      localStringBuilder.append(paramString);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return 738197504;
  }
  
  private static boolean recursiveDelete(File paramFile, boolean paramBoolean)
  {
    File[] arrayOfFile = paramFile.listFiles();
    boolean bool1 = true;
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      bool1 = true;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.isDirectory()) {
          bool2 = recursiveDelete(localFile, false);
        } else {
          bool2 = localFile.delete();
        }
        bool1 &= bool2;
        i += 1;
      }
    }
    boolean bool2 = bool1;
    if (!paramBoolean) {
      bool2 = bool1 & paramFile.delete();
    }
    return bool2;
  }
  
  private FileSystem.FileEntry toFileEntry(File paramFile)
  {
    String str = this.mRealBasePath;
    if (paramFile.getPath().startsWith(str))
    {
      if (paramFile.getPath().length() == str.length())
      {
        str = "";
      }
      else
      {
        int i = str.length();
        str = paramFile.getPath().substring(i + 1);
      }
      localObject = paramFile.getName();
      if (Build.VERSION.SDK_INT >= 21) {
        return NativeFileSystem.Compat21.toFileEntry(paramFile, this, str, (String)localObject);
      }
      if (!paramFile.exists()) {
        return null;
      }
      boolean bool = paramFile.isDirectory();
      long l = paramFile.length();
      return new FileSystem.FileEntry(this, str, (String)localObject, l, 0xFFFFF000 & 4096L + l - 1L, paramFile.lastModified(), bool);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Illegal file: ");
    ((StringBuilder)localObject).append(paramFile);
    ((StringBuilder)localObject).append(" (base: ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(")");
    throw new RuntimeException(((StringBuilder)localObject).toString());
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
    if (!this.mMacroFree)
    {
      String str3 = this.mRealBasePath;
      String str2 = this.mBasePath;
      String str1 = str2;
      if (this.mHasMacro) {
        str1 = VFSUtils.macroResolve(str2, paramMap);
      }
      if ((str1 != null) && (!str1.equals(str3)))
      {
        ensureBasePath(str1);
        this.mBasePathCreated = false;
        return;
      }
      if (str1 == null)
      {
        this.mRealBasePath = null;
        this.mBasePathCreated = false;
      }
    }
  }
  
  protected long copyFileImpl(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    String str = realPath(paramString1, true);
    if (str != null) {
      return channelCopy(str, paramFileSystem, paramString2);
    }
    paramFileSystem = new StringBuilder();
    paramFileSystem.append("Invalid path: ");
    paramFileSystem.append(paramString1);
    throw new IOException(paramFileSystem.toString());
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
    boolean bool;
    if ((!paramString.isEmpty()) && (!paramString.equals("/"))) {
      bool = false;
    } else {
      bool = true;
    }
    paramString = new File(realPath(paramString, false));
    if (!paramString.isDirectory()) {
      return false;
    }
    if (paramBoolean) {
      return recursiveDelete(paramString, bool);
    }
    return paramString.delete();
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
    try
    {
      paramString = new StatFs(realPath((String)localObject, false));
      localObject = new FileSystem.FsStat();
      if (Build.VERSION.SDK_INT >= 18)
      {
        ((FileSystem.FsStat)localObject).blockSize = paramString.getBlockSizeLong();
        ((FileSystem.FsStat)localObject).availableBlocks = paramString.getAvailableBlocksLong();
        ((FileSystem.FsStat)localObject).totalBlocks = paramString.getBlockCountLong();
      }
      else
      {
        ((FileSystem.FsStat)localObject).blockSize = paramString.getBlockSize();
        ((FileSystem.FsStat)localObject).availableBlocks = paramString.getAvailableBlocks();
        ((FileSystem.FsStat)localObject).totalBlocks = paramString.getBlockCount();
      }
      ((FileSystem.FsStat)localObject).availableSpace = (((FileSystem.FsStat)localObject).availableBlocks * ((FileSystem.FsStat)localObject).blockSize);
      ((FileSystem.FsStat)localObject).totalSpace = (((FileSystem.FsStat)localObject).totalBlocks * ((FileSystem.FsStat)localObject).blockSize);
      return localObject;
    }
    catch (RuntimeException paramString)
    {
      label121:
      break label121;
    }
    return null;
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
    paramString = realPath(paramString, true);
    if (paramString == null) {
      return false;
    }
    if ((this.mBasePathCreateSuccess) && (TextUtils.equals(paramString, this.mRealBasePath)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VFS.NativeFileSystem", 2, "mkdirs is called! basePath has been created!");
      }
      return true;
    }
    return new File(paramString).mkdirs();
  }
  
  protected boolean moveFileImpl(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    if ((paramFileSystem.capabilityFlags() & 0x2) != 0)
    {
      paramFileSystem = paramFileSystem.realPath(paramString2, false);
      paramString1 = realPath(paramString1, true);
      if ((paramFileSystem != null) && (paramString1 != null))
      {
        if (Build.VERSION.SDK_INT >= 21) {
          return NativeFileSystem.Compat21.rename(paramFileSystem, paramString1);
        }
        return new File(paramFileSystem).renameTo(new File(paramString1));
      }
    }
    return false;
  }
  
  public ParcelFileDescriptor openParcelFd(String paramString1, String paramString2)
  {
    String str = realPath(paramString1, true);
    if (str != null) {
      return ParcelFileDescriptor.open(new File(str), modeToMode(paramString2));
    }
    paramString2 = new StringBuilder();
    paramString2.append("Invalid path: ");
    paramString2.append(paramString1);
    throw new FileNotFoundException(paramString2.toString());
  }
  
  public InputStream openRead(String paramString)
  {
    Object localObject = realPath(paramString, false);
    if (localObject != null) {
      return new NativeFileSystem.SeekableFileInputStream((String)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid path: ");
    ((StringBuilder)localObject).append(paramString);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public ReadableByteChannel openReadChannel(String paramString)
  {
    Object localObject = realPath(paramString, false);
    if (localObject != null) {
      return new FileInputStream((String)localObject).getChannel();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid path: ");
    ((StringBuilder)localObject).append(paramString);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public ByteChannel openReadWriteChannel(String paramString)
  {
    Object localObject = realPath(paramString, true);
    if (localObject != null) {
      return new RandomAccessFile((String)localObject, "rw").getChannel();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid path: ");
    ((StringBuilder)localObject).append(paramString);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public OutputStream openWrite(String paramString, boolean paramBoolean)
  {
    Object localObject = realPath(paramString, true);
    if (localObject != null) {
      return new FileOutputStream((String)localObject, paramBoolean);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid path: ");
    ((StringBuilder)localObject).append(paramString);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public WritableByteChannel openWriteChannel(String paramString, boolean paramBoolean)
  {
    Object localObject = realPath(paramString, true);
    if (localObject != null) {
      return new FileOutputStream((String)localObject, paramBoolean).getChannel();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid path: ");
    ((StringBuilder)localObject).append(paramString);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public String realPath(String paramString, boolean paramBoolean)
  {
    String str = this.mRealBasePath;
    if (str != null)
    {
      if ((paramBoolean) && (!this.mBasePathCreated))
      {
        this.mBasePathCreateSuccess = new File(this.mRealBasePath).mkdirs();
        this.mBasePathCreated = true;
      }
      if (paramString.isEmpty()) {
        return str;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append('/');
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    paramString = new StringBuilder();
    paramString.append("Base path cannot be resolved: ");
    paramString.append(this.mBasePath);
    throw new IllegalStateException(paramString.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Native [");
    String str;
    if (this.mRealBasePath == null) {
      str = this.mBasePath;
    } else {
      str = this.mRealBasePath;
    }
    localStringBuilder.append(str);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.NativeFileSystem
 * JD-Core Version:    0.7.0.1
 */