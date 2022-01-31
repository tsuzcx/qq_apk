package com.tencent.mm.vfs;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CopyOnWriteFileSystem
  extends WrapperFileSystem<NativeFileSystem>
  implements Handler.Callback
{
  private static final String COW_DIR = ".cow/";
  private static final char COW_LINK = '​';
  private static final char COW_REFCOUNT = '‌';
  public static final Parcelable.Creator<CopyOnWriteFileSystem> CREATOR = new CopyOnWriteFileSystem.1();
  private static final String TAG = "VFS.CopyOnWriteFileSystem";
  private static final int VERSION = 1;
  private volatile String mCowPath = null;
  private final HashSet<String> mCreatedDir = new HashSet();
  private final HashSet<String> mFlushCache = new HashSet();
  private final Handler mFlushHandler;
  private final long mThreshold;
  
  protected CopyOnWriteFileSystem(Parcel paramParcel)
  {
    super(paramParcel);
    VFSUtils.checkFileSystemVersion(paramParcel, CopyOnWriteFileSystem.class, 1);
    this.mThreshold = paramParcel.readLong();
    this.mFlushHandler = new Handler(FileSystemManager.instance().maintenanceLooper(), this);
  }
  
  public CopyOnWriteFileSystem(NativeFileSystem paramNativeFileSystem, long paramLong)
  {
    super(paramNativeFileSystem);
    this.mThreshold = paramLong;
    this.mFlushHandler = new Handler(FileSystemManager.instance().maintenanceLooper(), this);
  }
  
  /* Error */
  private static int addRef(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: new 97	java/io/RandomAccessFile
    //   6: dup
    //   7: aload_0
    //   8: ldc 99
    //   10: invokespecial 102	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: astore 10
    //   15: getstatic 107	android/os/Build$VERSION:SDK_INT	I
    //   18: bipush 21
    //   20: if_icmplt +83 -> 103
    //   23: aload 10
    //   25: invokestatic 113	com/tencent/mm/vfs/CopyOnWriteFileSystem$Compat21:getINode	(Ljava/io/RandomAccessFile;)J
    //   28: lstore_3
    //   29: lload_3
    //   30: invokestatic 119	com/tencent/mm/vfs/CopyOnWriteFileSystem$INodeLock:lock	(J)V
    //   33: aload 10
    //   35: invokevirtual 123	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   38: invokevirtual 128	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   41: astore_0
    //   42: aload_0
    //   43: astore 9
    //   45: aload 9
    //   47: astore 12
    //   49: aload 10
    //   51: astore 11
    //   53: lload_3
    //   54: lstore 5
    //   56: aload 10
    //   58: invokevirtual 123	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   61: invokevirtual 131	java/nio/channels/FileChannel:size	()J
    //   64: lstore 7
    //   66: lload 7
    //   68: l2i
    //   69: istore_2
    //   70: iload_1
    //   71: ifne +54 -> 125
    //   74: aload 9
    //   76: ifnull +8 -> 84
    //   79: aload 9
    //   81: invokevirtual 136	java/nio/channels/FileLock:release	()V
    //   84: lload_3
    //   85: ldc2_w 137
    //   88: lcmp
    //   89: ifeq +7 -> 96
    //   92: lload_3
    //   93: invokestatic 141	com/tencent/mm/vfs/CopyOnWriteFileSystem$INodeLock:unlock	(J)V
    //   96: aload 10
    //   98: invokestatic 145	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   101: iload_2
    //   102: ireturn
    //   103: aload_0
    //   104: invokevirtual 151	java/lang/String:hashCode	()I
    //   107: i2l
    //   108: lstore_3
    //   109: aload_0
    //   110: invokevirtual 154	java/lang/String:length	()I
    //   113: istore_2
    //   114: lload_3
    //   115: iload_2
    //   116: i2l
    //   117: bipush 32
    //   119: lshl
    //   120: lor
    //   121: lstore_3
    //   122: goto -93 -> 29
    //   125: iload_2
    //   126: iload_1
    //   127: iadd
    //   128: istore_1
    //   129: iload_1
    //   130: ifgt +53 -> 183
    //   133: lconst_0
    //   134: lstore 7
    //   136: aload 9
    //   138: astore 12
    //   140: aload 10
    //   142: astore 11
    //   144: lload_3
    //   145: lstore 5
    //   147: aload 10
    //   149: lload 7
    //   151: invokevirtual 157	java/io/RandomAccessFile:setLength	(J)V
    //   154: aload 9
    //   156: ifnull +8 -> 164
    //   159: aload 9
    //   161: invokevirtual 136	java/nio/channels/FileLock:release	()V
    //   164: lload_3
    //   165: ldc2_w 137
    //   168: lcmp
    //   169: ifeq +7 -> 176
    //   172: lload_3
    //   173: invokestatic 141	com/tencent/mm/vfs/CopyOnWriteFileSystem$INodeLock:unlock	(J)V
    //   176: aload 10
    //   178: invokestatic 145	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   181: iload_1
    //   182: ireturn
    //   183: iload_1
    //   184: i2l
    //   185: lstore 7
    //   187: goto -51 -> 136
    //   190: astore_0
    //   191: aconst_null
    //   192: astore 9
    //   194: ldc2_w 137
    //   197: lstore_3
    //   198: aconst_null
    //   199: astore 10
    //   201: ldc 158
    //   203: istore_1
    //   204: aload 9
    //   206: astore 12
    //   208: aload 10
    //   210: astore 11
    //   212: lload_3
    //   213: lstore 5
    //   215: ldc 22
    //   217: iconst_1
    //   218: ldc 160
    //   220: aload_0
    //   221: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   224: aload 9
    //   226: ifnull +8 -> 234
    //   229: aload 9
    //   231: invokevirtual 136	java/nio/channels/FileLock:release	()V
    //   234: lload_3
    //   235: ldc2_w 137
    //   238: lcmp
    //   239: ifeq +7 -> 246
    //   242: lload_3
    //   243: invokestatic 141	com/tencent/mm/vfs/CopyOnWriteFileSystem$INodeLock:unlock	(J)V
    //   246: aload 10
    //   248: invokestatic 145	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   251: iload_1
    //   252: ireturn
    //   253: astore_0
    //   254: ldc2_w 137
    //   257: lstore_3
    //   258: aconst_null
    //   259: astore 10
    //   261: aload 9
    //   263: ifnull +8 -> 271
    //   266: aload 9
    //   268: invokevirtual 136	java/nio/channels/FileLock:release	()V
    //   271: lload_3
    //   272: ldc2_w 137
    //   275: lcmp
    //   276: ifeq +7 -> 283
    //   279: lload_3
    //   280: invokestatic 141	com/tencent/mm/vfs/CopyOnWriteFileSystem$INodeLock:unlock	(J)V
    //   283: aload 10
    //   285: invokestatic 145	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   288: aload_0
    //   289: athrow
    //   290: astore_0
    //   291: goto -207 -> 84
    //   294: astore_0
    //   295: goto -131 -> 164
    //   298: astore_0
    //   299: goto -65 -> 234
    //   302: astore 9
    //   304: goto -33 -> 271
    //   307: astore_0
    //   308: ldc2_w 137
    //   311: lstore_3
    //   312: goto -51 -> 261
    //   315: astore_0
    //   316: goto -55 -> 261
    //   319: astore_0
    //   320: aload 12
    //   322: astore 9
    //   324: aload 11
    //   326: astore 10
    //   328: lload 5
    //   330: lstore_3
    //   331: goto -70 -> 261
    //   334: astore_0
    //   335: aconst_null
    //   336: astore 9
    //   338: ldc2_w 137
    //   341: lstore_3
    //   342: ldc 158
    //   344: istore_1
    //   345: goto -141 -> 204
    //   348: astore_0
    //   349: aconst_null
    //   350: astore 9
    //   352: ldc 158
    //   354: istore_1
    //   355: goto -151 -> 204
    //   358: astore_0
    //   359: ldc 158
    //   361: istore_1
    //   362: goto -158 -> 204
    //   365: astore_0
    //   366: goto -162 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	paramString	String
    //   0	369	1	paramInt	int
    //   69	59	2	i	int
    //   28	314	3	l1	long
    //   54	275	5	l2	long
    //   64	122	7	l3	long
    //   1	266	9	str1	String
    //   302	1	9	localIOException	IOException
    //   322	29	9	localObject1	Object
    //   13	314	10	localObject2	Object
    //   51	274	11	localObject3	Object
    //   47	274	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   3	15	190	java/io/IOException
    //   3	15	253	finally
    //   79	84	290	java/io/IOException
    //   159	164	294	java/io/IOException
    //   229	234	298	java/io/IOException
    //   266	271	302	java/io/IOException
    //   15	29	307	finally
    //   103	114	307	finally
    //   29	42	315	finally
    //   56	66	319	finally
    //   147	154	319	finally
    //   215	224	319	finally
    //   15	29	334	java/io/IOException
    //   103	114	334	java/io/IOException
    //   29	42	348	java/io/IOException
    //   56	66	358	java/io/IOException
    //   147	154	365	java/io/IOException
  }
  
  private static void copyFile(String paramString1, String paramString2)
  {
    try
    {
      FileChannel localFileChannel1 = new FileOutputStream(paramString2).getChannel();
      FileChannel localFileChannel2 = new FileInputStream(paramString1).getChannel();
      localFileChannel1.transferFrom(localFileChannel2, 0L, localFileChannel2.size());
      return;
    }
    catch (IOException localIOException)
    {
      QLog.e("VFS.CopyOnWriteFileSystem", 1, "Failed to copy file: " + paramString1 + " -> " + paramString2, localIOException);
    }
  }
  
  private FileSystem.FileEntry cowStat(FileSystem.FileEntry paramFileEntry)
  {
    String str = pathWithoutSuffix(paramFileEntry.relPath);
    Object localObject = resolveCowLink(str);
    if (localObject == null) {}
    do
    {
      return null;
      paramFileEntry = pathWithoutSuffix(paramFileEntry.name);
      if (Build.VERSION.SDK_INT >= 21) {
        return CopyOnWriteFileSystem.Compat21.toFileEntry((String)localObject, this, str, paramFileEntry);
      }
      localObject = new File((String)localObject);
    } while (!((File)localObject).exists());
    boolean bool = ((File)localObject).isDirectory();
    long l = ((File)localObject).length();
    return new FileSystem.FileEntry(this, str, paramFileEntry, l, 0xFFFFF000 & 4096L + l - 1L, ((File)localObject).lastModified(), bool);
  }
  
  private static String pathWithoutSuffix(String paramString)
  {
    return paramString.substring(0, paramString.length() - 1);
  }
  
  /* Error */
  private String resolveCowLink(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 49	com/tencent/mm/vfs/CopyOnWriteFileSystem:mCowPath	Ljava/lang/String;
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 183	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   18: aload_0
    //   19: getfield 249	com/tencent/mm/vfs/CopyOnWriteFileSystem:mFS	Lcom/tencent/mm/vfs/FileSystem;
    //   22: checkcast 251	com/tencent/mm/vfs/NativeFileSystem
    //   25: aload_1
    //   26: iconst_0
    //   27: invokevirtual 255	com/tencent/mm/vfs/NativeFileSystem:realPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   30: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: sipush 8203
    //   36: invokevirtual 258	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   39: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 6
    //   44: new 175	java/io/FileInputStream
    //   47: dup
    //   48: aload 6
    //   50: invokespecial 176	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   53: astore 4
    //   55: aload 4
    //   57: astore_1
    //   58: sipush 4096
    //   61: newarray byte
    //   63: astore 5
    //   65: iload_2
    //   66: sipush 4096
    //   69: if_icmpge +32 -> 101
    //   72: aload 4
    //   74: astore_1
    //   75: aload 4
    //   77: aload 5
    //   79: iload_2
    //   80: aload 5
    //   82: arraylength
    //   83: iload_2
    //   84: isub
    //   85: invokevirtual 262	java/io/FileInputStream:read	([BII)I
    //   88: istore_3
    //   89: iload_3
    //   90: iconst_m1
    //   91: if_icmpeq +10 -> 101
    //   94: iload_3
    //   95: iload_2
    //   96: iadd
    //   97: istore_2
    //   98: goto -33 -> 65
    //   101: aload 4
    //   103: astore_1
    //   104: new 147	java/lang/String
    //   107: dup
    //   108: aload 5
    //   110: iconst_0
    //   111: iload_2
    //   112: invokespecial 265	java/lang/String:<init>	([BII)V
    //   115: astore 5
    //   117: aload 4
    //   119: invokestatic 145	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   122: aload 5
    //   124: areturn
    //   125: astore_1
    //   126: aconst_null
    //   127: astore_1
    //   128: aload_1
    //   129: invokestatic 145	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   132: aconst_null
    //   133: areturn
    //   134: astore 5
    //   136: aconst_null
    //   137: astore 4
    //   139: aload 4
    //   141: astore_1
    //   142: ldc 22
    //   144: iconst_1
    //   145: new 183	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 267
    //   155: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload 6
    //   160: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: aload 5
    //   168: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   171: aload 4
    //   173: invokestatic 145	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   176: aconst_null
    //   177: areturn
    //   178: astore 4
    //   180: aconst_null
    //   181: astore_1
    //   182: aload_1
    //   183: invokestatic 145	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   186: aload 4
    //   188: athrow
    //   189: astore 4
    //   191: goto -9 -> 182
    //   194: astore 5
    //   196: goto -57 -> 139
    //   199: astore_1
    //   200: aload 4
    //   202: astore_1
    //   203: goto -75 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	CopyOnWriteFileSystem
    //   0	206	1	paramString	String
    //   1	111	2	i	int
    //   88	9	3	j	int
    //   53	119	4	localFileInputStream	FileInputStream
    //   178	9	4	localObject1	Object
    //   189	12	4	localObject2	Object
    //   63	60	5	localObject3	Object
    //   134	33	5	localIOException1	IOException
    //   194	1	5	localIOException2	IOException
    //   42	117	6	str	String
    // Exception table:
    //   from	to	target	type
    //   44	55	125	java/io/FileNotFoundException
    //   44	55	134	java/io/IOException
    //   44	55	178	finally
    //   58	65	189	finally
    //   75	89	189	finally
    //   104	117	189	finally
    //   142	171	189	finally
    //   58	65	194	java/io/IOException
    //   75	89	194	java/io/IOException
    //   104	117	194	java/io/IOException
    //   58	65	199	java/io/FileNotFoundException
    //   75	89	199	java/io/FileNotFoundException
    //   104	117	199	java/io/FileNotFoundException
  }
  
  private boolean unlinkCow(String paramString, boolean paramBoolean)
  {
    String str1 = resolveCowLink(paramString);
    if (str1 == null) {
      return false;
    }
    String str2 = str1 + '‌';
    int i = addRef(str2, -1);
    if (!paramBoolean) {
      if (i == 0)
      {
        new File(str1).delete();
        new File(str2).delete();
      }
    }
    for (;;)
    {
      return true;
      paramString = ((NativeFileSystem)this.mFS).realPath(paramString, true);
      if (i == 0)
      {
        if (!new File(str1).renameTo(new File(paramString)))
        {
          copyFile(str1, paramString);
          new File(str1).delete();
        }
        new File(str2).delete();
      }
      else
      {
        copyFile(str1, paramString);
      }
    }
  }
  
  public int batchDelete(List<String> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      if (!delete((String)paramList.next())) {
        break label43;
      }
      i += 1;
    }
    label43:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public int capabilityFlags()
  {
    return ((NativeFileSystem)this.mFS).capabilityFlags();
  }
  
  public void configure(Map<String, String> arg1)
  {
    ((NativeFileSystem)this.mFS).configure(???);
    ??? = ((NativeFileSystem)this.mFS).basePath();
    if (??? != null)
    {
      ??? = ??? + '/' + ".cow/";
      if (!???.equals(((NativeFileSystem)this.mFS).realPath(".cow/", false))) {
        throw new RuntimeException("realPath is illegal with filesystem: " + ((NativeFileSystem)this.mFS).toString());
      }
      if (!???.equals(this.mCowPath))
      {
        this.mCowPath = ???;
        new File(this.mCowPath).mkdirs();
        synchronized (this.mCreatedDir)
        {
          this.mCreatedDir.clear();
          return;
        }
      }
    }
  }
  
  protected long copyFileImpl(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    if ((paramFileSystem instanceof CopyOnWriteFileSystem))
    {
      paramFileSystem = (CopyOnWriteFileSystem)paramFileSystem;
      Object localObject = ((NativeFileSystem)paramFileSystem.mFS).stat(paramString2);
      if (localObject == null)
      {
        localObject = paramFileSystem.resolveCowLink(paramString2);
        if (localObject == null) {
          throw new FileNotFoundException("File not found: " + paramString2);
        }
        delete(paramString1);
        addRef((String)localObject + '‌', 1);
        return ((NativeFileSystem)this.mFS).copyFileImpl(paramString1 + '​', paramFileSystem.mFS, paramString2 + '​');
      }
      if (((FileSystem.FileEntry)localObject).size >= this.mThreshold) {
        return -1L;
      }
      return ((NativeFileSystem)this.mFS).copyFileImpl(paramString1, paramFileSystem.mFS, paramString2);
    }
    return ((NativeFileSystem)this.mFS).copyFileImpl(paramString1, paramFileSystem, paramString2);
  }
  
  public boolean delete(String paramString)
  {
    boolean bool = unlinkCow(paramString, false);
    return ((NativeFileSystem)this.mFS).delete(paramString) | bool;
  }
  
  public boolean deleteDir(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean exists(String paramString)
  {
    return (((NativeFileSystem)this.mFS).exists(paramString)) || (((NativeFileSystem)this.mFS).exists(paramString + '​'));
  }
  
  public FileSystem.FsStat fileSystemStat(String paramString)
  {
    return ((NativeFileSystem)this.mFS).fileSystemStat(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public Iterable<FileSystem.FileEntry> list(String paramString, boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
  }
  
  protected boolean moveFileImpl(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    return false;
  }
  
  public InputStream openRead(String paramString)
  {
    try
    {
      InputStream localInputStream = ((NativeFileSystem)this.mFS).openRead(paramString);
      if (localInputStream != null) {
        return localInputStream;
      }
      throw new FileNotFoundException("Filesystem returns null for path: " + paramString + ", FS: " + ((NativeFileSystem)this.mFS).toString());
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      paramString = resolveCowLink(paramString);
      if (paramString != null) {
        return new NativeFileSystem.SeekableFileInputStream(paramString);
      }
      throw localFileNotFoundException;
    }
  }
  
  public ReadableByteChannel openReadChannel(String paramString)
  {
    paramString = openRead(paramString);
    if ((paramString instanceof FileInputStream)) {
      return ((FileInputStream)paramString).getChannel();
    }
    return Channels.newChannel(paramString);
  }
  
  public ByteChannel openReadWriteChannel(String paramString)
  {
    unlinkCow(paramString, true);
    return ((NativeFileSystem)this.mFS).openReadWriteChannel(paramString);
  }
  
  public OutputStream openWrite(String paramString, boolean paramBoolean)
  {
    unlinkCow(paramString, paramBoolean);
    return ((NativeFileSystem)this.mFS).openWrite(paramString, paramBoolean);
  }
  
  public WritableByteChannel openWriteChannel(String paramString, boolean paramBoolean)
  {
    paramString = openWrite(paramString, paramBoolean);
    if ((paramString instanceof FileOutputStream)) {
      return ((FileOutputStream)paramString).getChannel();
    }
    return Channels.newChannel(paramString);
  }
  
  public String realPath(String paramString, boolean paramBoolean)
  {
    String str1 = ((NativeFileSystem)this.mFS).realPath(paramString, paramBoolean);
    if ((paramBoolean) || (new File(str1).exists())) {
      paramString = str1;
    }
    String str2;
    do
    {
      return paramString;
      str2 = resolveCowLink(paramString);
      paramString = str2;
    } while (new File(str2).exists());
    return str1;
  }
  
  public boolean setModifiedTime(String paramString, long paramLong)
  {
    if (((NativeFileSystem)this.mFS).setModifiedTime(paramString, paramLong)) {
      return true;
    }
    return ((NativeFileSystem)this.mFS).setModifiedTime(paramString + '​', paramLong);
  }
  
  public FileSystem.FileEntry stat(String paramString)
  {
    FileSystem.FileEntry localFileEntry = ((NativeFileSystem)this.mFS).stat(paramString);
    if (localFileEntry != null) {
      return localFileEntry;
    }
    paramString = ((NativeFileSystem)this.mFS).stat(paramString + '​');
    if (paramString == null) {
      return null;
    }
    return cowStat(paramString);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    VFSUtils.writeFileSystemVersion(paramParcel, CopyOnWriteFileSystem.class, 1);
    paramParcel.writeLong(this.mThreshold);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.CopyOnWriteFileSystem
 * JD-Core Version:    0.7.0.1
 */