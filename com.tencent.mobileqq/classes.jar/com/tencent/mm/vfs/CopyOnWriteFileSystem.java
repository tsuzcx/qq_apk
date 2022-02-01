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
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 14
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 13
    //   12: ldc 96
    //   14: istore_3
    //   15: new 98	java/io/RandomAccessFile
    //   18: dup
    //   19: aload_0
    //   20: ldc 100
    //   22: invokespecial 103	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: astore 10
    //   27: getstatic 108	android/os/Build$VERSION:SDK_INT	I
    //   30: bipush 21
    //   32: if_icmplt +13 -> 45
    //   35: aload 10
    //   37: invokestatic 114	com/tencent/mm/vfs/CopyOnWriteFileSystem$Compat21:getINode	(Ljava/io/RandomAccessFile;)J
    //   40: lstore 4
    //   42: goto +25 -> 67
    //   45: aload_0
    //   46: invokevirtual 120	java/lang/String:hashCode	()I
    //   49: i2l
    //   50: lstore 4
    //   52: aload_0
    //   53: invokevirtual 123	java/lang/String:length	()I
    //   56: istore_2
    //   57: lload 4
    //   59: iload_2
    //   60: i2l
    //   61: bipush 32
    //   63: lshl
    //   64: lor
    //   65: lstore 4
    //   67: aload 13
    //   69: astore 12
    //   71: iload_3
    //   72: istore_2
    //   73: aload 14
    //   75: astore_0
    //   76: aload 10
    //   78: astore 11
    //   80: lload 4
    //   82: lstore 6
    //   84: lload 4
    //   86: invokestatic 129	com/tencent/mm/vfs/CopyOnWriteFileSystem$INodeLock:lock	(J)V
    //   89: aload 13
    //   91: astore 12
    //   93: iload_3
    //   94: istore_2
    //   95: aload 14
    //   97: astore_0
    //   98: aload 10
    //   100: astore 11
    //   102: lload 4
    //   104: lstore 6
    //   106: aload 10
    //   108: invokevirtual 133	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   111: invokevirtual 138	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   114: astore 13
    //   116: aload 13
    //   118: astore 12
    //   120: iload_3
    //   121: istore_2
    //   122: aload 13
    //   124: astore_0
    //   125: aload 10
    //   127: astore 11
    //   129: lload 4
    //   131: lstore 6
    //   133: aload 10
    //   135: invokevirtual 133	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   138: invokevirtual 141	java/nio/channels/FileChannel:size	()J
    //   141: lstore 8
    //   143: lload 8
    //   145: l2i
    //   146: istore_2
    //   147: iload_1
    //   148: ifne +37 -> 185
    //   151: aload 13
    //   153: ifnull +11 -> 164
    //   156: aload 13
    //   158: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   161: goto +3 -> 164
    //   164: lload 4
    //   166: ldc2_w 147
    //   169: lcmp
    //   170: ifeq +8 -> 178
    //   173: lload 4
    //   175: invokestatic 151	com/tencent/mm/vfs/CopyOnWriteFileSystem$INodeLock:unlock	(J)V
    //   178: aload 10
    //   180: invokestatic 155	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   183: iload_2
    //   184: ireturn
    //   185: iload_2
    //   186: iload_1
    //   187: iadd
    //   188: istore_1
    //   189: iload_1
    //   190: ifgt +9 -> 199
    //   193: lconst_0
    //   194: lstore 8
    //   196: goto +7 -> 203
    //   199: iload_1
    //   200: i2l
    //   201: lstore 8
    //   203: aload 13
    //   205: astore 12
    //   207: iload_1
    //   208: istore_2
    //   209: aload 13
    //   211: astore_0
    //   212: aload 10
    //   214: astore 11
    //   216: lload 4
    //   218: lstore 6
    //   220: aload 10
    //   222: lload 8
    //   224: invokevirtual 158	java/io/RandomAccessFile:setLength	(J)V
    //   227: aload 13
    //   229: ifnull +11 -> 240
    //   232: aload 13
    //   234: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   237: goto +3 -> 240
    //   240: lload 4
    //   242: ldc2_w 147
    //   245: lcmp
    //   246: ifeq +8 -> 254
    //   249: lload 4
    //   251: invokestatic 151	com/tencent/mm/vfs/CopyOnWriteFileSystem$INodeLock:unlock	(J)V
    //   254: aload 10
    //   256: invokestatic 155	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   259: iload_1
    //   260: ireturn
    //   261: astore 13
    //   263: goto +40 -> 303
    //   266: astore_0
    //   267: goto +11 -> 278
    //   270: astore_0
    //   271: goto +22 -> 293
    //   274: astore_0
    //   275: aconst_null
    //   276: astore 10
    //   278: ldc2_w 147
    //   281: lstore 6
    //   283: aload_0
    //   284: astore 12
    //   286: goto +81 -> 367
    //   289: astore_0
    //   290: aconst_null
    //   291: astore 10
    //   293: ldc2_w 147
    //   296: lstore 4
    //   298: aload_0
    //   299: astore 13
    //   301: iload_3
    //   302: istore_2
    //   303: aload 12
    //   305: astore_0
    //   306: aload 10
    //   308: astore 11
    //   310: lload 4
    //   312: lstore 6
    //   314: ldc 22
    //   316: iconst_1
    //   317: ldc 160
    //   319: aload 13
    //   321: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   324: aload 12
    //   326: ifnull +11 -> 337
    //   329: aload 12
    //   331: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   334: goto +3 -> 337
    //   337: lload 4
    //   339: ldc2_w 147
    //   342: lcmp
    //   343: ifeq +8 -> 351
    //   346: lload 4
    //   348: invokestatic 151	com/tencent/mm/vfs/CopyOnWriteFileSystem$INodeLock:unlock	(J)V
    //   351: aload 10
    //   353: invokestatic 155	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   356: iload_2
    //   357: ireturn
    //   358: astore 12
    //   360: aload 11
    //   362: astore 10
    //   364: aload_0
    //   365: astore 11
    //   367: aload 11
    //   369: ifnull +11 -> 380
    //   372: aload 11
    //   374: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   377: goto +3 -> 380
    //   380: lload 6
    //   382: ldc2_w 147
    //   385: lcmp
    //   386: ifeq +8 -> 394
    //   389: lload 6
    //   391: invokestatic 151	com/tencent/mm/vfs/CopyOnWriteFileSystem$INodeLock:unlock	(J)V
    //   394: aload 10
    //   396: invokestatic 155	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   399: aload 12
    //   401: athrow
    //   402: astore_0
    //   403: goto -239 -> 164
    //   406: astore_0
    //   407: goto -167 -> 240
    //   410: astore_0
    //   411: goto -74 -> 337
    //   414: astore_0
    //   415: goto -35 -> 380
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	paramString	String
    //   0	418	1	paramInt	int
    //   56	301	2	i	int
    //   14	288	3	j	int
    //   40	307	4	l1	long
    //   82	308	6	l2	long
    //   141	82	8	l3	long
    //   25	370	10	localObject1	Object
    //   7	366	11	localObject2	Object
    //   1	329	12	localObject3	Object
    //   358	42	12	localObject4	Object
    //   10	223	13	localFileLock	java.nio.channels.FileLock
    //   261	1	13	localIOException	IOException
    //   299	21	13	str	String
    //   4	92	14	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   84	89	261	java/io/IOException
    //   106	116	261	java/io/IOException
    //   133	143	261	java/io/IOException
    //   220	227	261	java/io/IOException
    //   27	42	266	finally
    //   45	57	266	finally
    //   27	42	270	java/io/IOException
    //   45	57	270	java/io/IOException
    //   15	27	274	finally
    //   15	27	289	java/io/IOException
    //   84	89	358	finally
    //   106	116	358	finally
    //   133	143	358	finally
    //   220	227	358	finally
    //   314	324	358	finally
    //   156	161	402	java/io/IOException
    //   232	237	406	java/io/IOException
    //   329	334	410	java/io/IOException
    //   372	377	414	java/io/IOException
  }
  
  private static void copyFile(String paramString1, String paramString2)
  {
    try
    {
      FileChannel localFileChannel = new FileOutputStream(paramString2).getChannel();
      localObject = new FileInputStream(paramString1).getChannel();
      localFileChannel.transferFrom((ReadableByteChannel)localObject, 0L, ((FileChannel)localObject).size());
      return;
    }
    catch (IOException localIOException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to copy file: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" -> ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.e("VFS.CopyOnWriteFileSystem", 1, ((StringBuilder)localObject).toString(), localIOException);
    }
  }
  
  private FileSystem.FileEntry cowStat(FileSystem.FileEntry paramFileEntry)
  {
    String str = pathWithoutSuffix(paramFileEntry.relPath);
    Object localObject = resolveCowLink(str);
    if (localObject == null) {
      return null;
    }
    paramFileEntry = pathWithoutSuffix(paramFileEntry.name);
    if (Build.VERSION.SDK_INT >= 21) {
      return CopyOnWriteFileSystem.Compat21.toFileEntry((String)localObject, this, str, paramFileEntry);
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      return null;
    }
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
    //   0: aload_0
    //   1: getfield 49	com/tencent/mm/vfs/CopyOnWriteFileSystem:mCowPath	Ljava/lang/String;
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 183	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   16: astore 4
    //   18: aload 4
    //   20: aload_0
    //   21: getfield 249	com/tencent/mm/vfs/CopyOnWriteFileSystem:mFS	Lcom/tencent/mm/vfs/FileSystem;
    //   24: checkcast 251	com/tencent/mm/vfs/NativeFileSystem
    //   27: aload_1
    //   28: iconst_0
    //   29: invokevirtual 255	com/tencent/mm/vfs/NativeFileSystem:realPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   32: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 4
    //   38: sipush 8203
    //   41: invokevirtual 258	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 4
    //   47: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore 6
    //   52: new 175	java/io/FileInputStream
    //   55: dup
    //   56: aload 6
    //   58: invokespecial 176	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   61: astore 4
    //   63: aload 4
    //   65: astore_1
    //   66: sipush 4096
    //   69: newarray byte
    //   71: astore 5
    //   73: iconst_0
    //   74: istore_2
    //   75: iload_2
    //   76: sipush 4096
    //   79: if_icmpge +32 -> 111
    //   82: aload 4
    //   84: astore_1
    //   85: aload 4
    //   87: aload 5
    //   89: iload_2
    //   90: aload 5
    //   92: arraylength
    //   93: iload_2
    //   94: isub
    //   95: invokevirtual 262	java/io/FileInputStream:read	([BII)I
    //   98: istore_3
    //   99: iload_3
    //   100: iconst_m1
    //   101: if_icmpeq +10 -> 111
    //   104: iload_2
    //   105: iload_3
    //   106: iadd
    //   107: istore_2
    //   108: goto -33 -> 75
    //   111: aload 4
    //   113: astore_1
    //   114: new 116	java/lang/String
    //   117: dup
    //   118: aload 5
    //   120: iconst_0
    //   121: iload_2
    //   122: invokespecial 265	java/lang/String:<init>	([BII)V
    //   125: astore 5
    //   127: aload 4
    //   129: invokestatic 155	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   132: aload 5
    //   134: areturn
    //   135: astore 5
    //   137: goto +15 -> 152
    //   140: astore 4
    //   142: aconst_null
    //   143: astore_1
    //   144: goto +68 -> 212
    //   147: astore 5
    //   149: aconst_null
    //   150: astore 4
    //   152: aload 4
    //   154: astore_1
    //   155: new 183	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   162: astore 7
    //   164: aload 4
    //   166: astore_1
    //   167: aload 7
    //   169: ldc_w 267
    //   172: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 4
    //   178: astore_1
    //   179: aload 7
    //   181: aload 6
    //   183: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 4
    //   189: astore_1
    //   190: ldc 22
    //   192: iconst_1
    //   193: aload 7
    //   195: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: aload 5
    //   200: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   203: aload 4
    //   205: invokestatic 155	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   208: aconst_null
    //   209: areturn
    //   210: astore 4
    //   212: aload_1
    //   213: invokestatic 155	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   216: aload 4
    //   218: athrow
    //   219: aconst_null
    //   220: astore 4
    //   222: aload 4
    //   224: invokestatic 155	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   227: aconst_null
    //   228: areturn
    //   229: astore_1
    //   230: goto -11 -> 219
    //   233: astore_1
    //   234: goto -12 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	CopyOnWriteFileSystem
    //   0	237	1	paramString	String
    //   74	48	2	i	int
    //   98	9	3	j	int
    //   16	112	4	localObject1	Object
    //   140	1	4	localObject2	Object
    //   150	54	4	localCloseable1	java.io.Closeable
    //   210	7	4	localObject3	Object
    //   220	3	4	localCloseable2	java.io.Closeable
    //   71	62	5	localObject4	Object
    //   135	1	5	localIOException1	IOException
    //   147	52	5	localIOException2	IOException
    //   50	132	6	str	String
    //   162	32	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   66	73	135	java/io/IOException
    //   85	99	135	java/io/IOException
    //   114	127	135	java/io/IOException
    //   52	63	140	finally
    //   52	63	147	java/io/IOException
    //   66	73	210	finally
    //   85	99	210	finally
    //   114	127	210	finally
    //   155	164	210	finally
    //   167	176	210	finally
    //   179	187	210	finally
    //   190	203	210	finally
    //   52	63	229	java/io/FileNotFoundException
    //   66	73	233	java/io/FileNotFoundException
    //   85	99	233	java/io/FileNotFoundException
    //   114	127	233	java/io/FileNotFoundException
  }
  
  private boolean unlinkCow(String paramString, boolean paramBoolean)
  {
    String str = resolveCowLink(paramString);
    if (str == null) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append('‌');
    localObject = ((StringBuilder)localObject).toString();
    int i = addRef((String)localObject, -1);
    if (!paramBoolean)
    {
      if (i == 0)
      {
        new File(str).delete();
        new File((String)localObject).delete();
        return true;
      }
    }
    else
    {
      paramString = ((NativeFileSystem)this.mFS).realPath(paramString, true);
      if (i == 0)
      {
        if (!new File(str).renameTo(new File(paramString)))
        {
          copyFile(str, paramString);
          new File(str).delete();
        }
        new File((String)localObject).delete();
        return true;
      }
      copyFile(str, paramString);
    }
    return true;
  }
  
  public int batchDelete(List<String> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext()) {
      if (delete((String)paramList.next())) {
        i += 1;
      }
    }
    return i;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(???);
      localStringBuilder.append('/');
      localStringBuilder.append(".cow/");
      ??? = localStringBuilder.toString();
      if (???.equals(((NativeFileSystem)this.mFS).realPath(".cow/", false)))
      {
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
      else
      {
        ??? = new StringBuilder();
        ???.append("realPath is illegal with filesystem: ");
        ???.append(((NativeFileSystem)this.mFS).toString());
        throw new RuntimeException(???.toString());
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
        if (localObject != null)
        {
          delete(paramString1);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append('‌');
          addRef(localStringBuilder.toString(), 1);
          localObject = (NativeFileSystem)this.mFS;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1);
          localStringBuilder.append('​');
          paramString1 = localStringBuilder.toString();
          paramFileSystem = paramFileSystem.mFS;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString2);
          localStringBuilder.append('​');
          return ((NativeFileSystem)localObject).copyFileImpl(paramString1, paramFileSystem, localStringBuilder.toString());
        }
        paramString1 = new StringBuilder();
        paramString1.append("File not found: ");
        paramString1.append(paramString2);
        throw new FileNotFoundException(paramString1.toString());
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
    if (!((NativeFileSystem)this.mFS).exists(paramString))
    {
      NativeFileSystem localNativeFileSystem = (NativeFileSystem)this.mFS;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append('​');
      if (!localNativeFileSystem.exists(localStringBuilder.toString())) {
        return false;
      }
    }
    return true;
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
      Object localObject = ((NativeFileSystem)this.mFS).openRead(paramString);
      if (localObject != null) {
        return localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Filesystem returns null for path: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", FS: ");
      ((StringBuilder)localObject).append(((NativeFileSystem)this.mFS).toString());
      throw new FileNotFoundException(((StringBuilder)localObject).toString());
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
    String str = ((NativeFileSystem)this.mFS).realPath(paramString, paramBoolean);
    if (!paramBoolean)
    {
      if (new File(str).exists()) {
        return str;
      }
      paramString = resolveCowLink(paramString);
      if (new File(paramString).exists()) {
        return paramString;
      }
    }
    return str;
  }
  
  public boolean setModifiedTime(String paramString, long paramLong)
  {
    if (((NativeFileSystem)this.mFS).setModifiedTime(paramString, paramLong)) {
      return true;
    }
    NativeFileSystem localNativeFileSystem = (NativeFileSystem)this.mFS;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append('​');
    return localNativeFileSystem.setModifiedTime(localStringBuilder.toString(), paramLong);
  }
  
  public FileSystem.FileEntry stat(String paramString)
  {
    Object localObject = ((NativeFileSystem)this.mFS).stat(paramString);
    if (localObject != null) {
      return localObject;
    }
    localObject = (NativeFileSystem)this.mFS;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append('​');
    paramString = ((NativeFileSystem)localObject).stat(localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.CopyOnWriteFileSystem
 * JD-Core Version:    0.7.0.1
 */