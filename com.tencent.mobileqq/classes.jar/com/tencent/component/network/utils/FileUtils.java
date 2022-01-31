package com.tencent.component.network.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.module.base.QDLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;

public class FileUtils
{
  private static final int ASSET_SPLIT_BASE = 0;
  private static final int BUFFER_SIZE = 8192;
  private static final int BUFFER_SIZE_MMAP = 8388608;
  public static final FileUtils.AssetFileComparator SIMPLE_ASSET_COMPARATOR = new FileUtils.2();
  public static final FileUtils.FileComparator SIMPLE_COMPARATOR = new FileUtils.1();
  private static final String TAG = "FileUtils";
  private static final BytesBufferPool sBytesBufferPool = new BytesBufferPool(2, 8192);
  
  private static void closeSilently(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2)
  {
    return copyAssets(paramContext, paramString1, paramString2, SIMPLE_ASSET_COMPARATOR);
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2, FileUtils.AssetFileComparator paramAssetFileComparator)
  {
    return performCopyAssetsFile(paramContext, paramString1, paramString2, paramAssetFileComparator);
  }
  
  /* Error */
  public static boolean copyFile(String paramString, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: getstatic 42	com/tencent/component/network/utils/FileUtils:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   16: invokevirtual 73	com/tencent/component/network/utils/BytesBufferPool:get	()Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;
    //   19: astore 5
    //   21: new 75	java/io/File
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual 82	java/io/File:exists	()Z
    //   34: ifeq +12 -> 46
    //   37: aload_0
    //   38: invokevirtual 85	java/io/File:isFile	()Z
    //   41: istore_3
    //   42: iload_3
    //   43: ifne +26 -> 69
    //   46: getstatic 42	com/tencent/component/network/utils/FileUtils:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   49: aload 5
    //   51: invokevirtual 89	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   54: iconst_0
    //   55: ifeq -44 -> 11
    //   58: new 91	java/lang/NullPointerException
    //   61: dup
    //   62: invokespecial 92	java/lang/NullPointerException:<init>	()V
    //   65: athrow
    //   66: astore_0
    //   67: iconst_0
    //   68: ireturn
    //   69: new 94	java/io/FileInputStream
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   77: astore 4
    //   79: aload 4
    //   81: astore_0
    //   82: aload 4
    //   84: aload 5
    //   86: getfield 103	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   89: iconst_0
    //   90: aload 5
    //   92: getfield 103	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   95: arraylength
    //   96: invokevirtual 109	java/io/InputStream:read	([BII)I
    //   99: istore_2
    //   100: iload_2
    //   101: ifle +60 -> 161
    //   104: aload 4
    //   106: astore_0
    //   107: aload_1
    //   108: aload 5
    //   110: getfield 103	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   113: iconst_0
    //   114: iload_2
    //   115: invokevirtual 115	java/io/OutputStream:write	([BII)V
    //   118: goto -39 -> 79
    //   121: astore_0
    //   122: aload 4
    //   124: astore_1
    //   125: aload_0
    //   126: astore 4
    //   128: aload_1
    //   129: astore_0
    //   130: ldc 19
    //   132: ldc 117
    //   134: aload 4
    //   136: invokestatic 123	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   139: pop
    //   140: getstatic 42	com/tencent/component/network/utils/FileUtils:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   143: aload 5
    //   145: invokevirtual 89	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   148: aload_1
    //   149: ifnull -138 -> 11
    //   152: aload_1
    //   153: invokevirtual 124	java/io/InputStream:close	()V
    //   156: iconst_0
    //   157: ireturn
    //   158: astore_0
    //   159: iconst_0
    //   160: ireturn
    //   161: getstatic 42	com/tencent/component/network/utils/FileUtils:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   164: aload 5
    //   166: invokevirtual 89	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   169: aload 4
    //   171: ifnull +8 -> 179
    //   174: aload 4
    //   176: invokevirtual 124	java/io/InputStream:close	()V
    //   179: iconst_1
    //   180: ireturn
    //   181: astore_1
    //   182: aconst_null
    //   183: astore_0
    //   184: getstatic 42	com/tencent/component/network/utils/FileUtils:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   187: aload 5
    //   189: invokevirtual 89	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   192: aload_0
    //   193: ifnull +7 -> 200
    //   196: aload_0
    //   197: invokevirtual 124	java/io/InputStream:close	()V
    //   200: aload_1
    //   201: athrow
    //   202: astore_0
    //   203: goto -24 -> 179
    //   206: astore_0
    //   207: goto -7 -> 200
    //   210: astore_1
    //   211: goto -27 -> 184
    //   214: astore 4
    //   216: aconst_null
    //   217: astore_1
    //   218: goto -90 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	paramString	String
    //   0	221	1	paramOutputStream	java.io.OutputStream
    //   99	16	2	i	int
    //   41	2	3	bool	boolean
    //   77	98	4	localObject	Object
    //   214	1	4	localThrowable	Throwable
    //   19	169	5	localBytesBuffer	BytesBufferPool.BytesBuffer
    // Exception table:
    //   from	to	target	type
    //   58	66	66	java/lang/Throwable
    //   82	100	121	java/lang/Throwable
    //   107	118	121	java/lang/Throwable
    //   152	156	158	java/lang/Throwable
    //   21	42	181	finally
    //   69	79	181	finally
    //   174	179	202	java/lang/Throwable
    //   196	200	206	java/lang/Throwable
    //   82	100	210	finally
    //   107	118	210	finally
    //   130	140	210	finally
    //   21	42	214	java/lang/Throwable
    //   69	79	214	java/lang/Throwable
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2)
  {
    return copyFiles(paramFile1, paramFile2, null);
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2, FileFilter paramFileFilter)
  {
    return copyFiles(paramFile1, paramFile2, paramFileFilter, SIMPLE_COMPARATOR);
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2, FileFilter paramFileFilter, FileUtils.FileComparator paramFileComparator)
  {
    if ((paramFile1 == null) || (paramFile2 == null)) {}
    do
    {
      do
      {
        return false;
      } while (!paramFile1.exists());
      if (paramFile1.isFile()) {
        return performCopyFile(paramFile1, paramFile2, paramFileFilter, paramFileComparator);
      }
      paramFile1 = paramFile1.listFiles();
    } while (paramFile1 == null);
    boolean bool = true;
    int j = paramFile1.length;
    int i = 0;
    while (i < j)
    {
      paramFileComparator = paramFile1[i];
      if (!copyFiles(paramFileComparator, new File(paramFile2, paramFileComparator.getName()), paramFileFilter)) {
        bool = false;
      }
      i += 1;
    }
    return bool;
  }
  
  public static void delete(File paramFile)
  {
    delete(paramFile, false);
  }
  
  public static void delete(File paramFile, boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        return;
        if (paramFile.isFile())
        {
          paramFile.delete();
          return;
        }
        arrayOfFile = paramFile.listFiles();
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        delete(arrayOfFile[i], paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramFile.delete();
  }
  
  public static void delete(String paramString)
  {
    delete(paramString, false);
  }
  
  public static void delete(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    delete(new File(paramString), paramBoolean);
  }
  
  /* Error */
  public static long getAssetLength(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 165	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: astore 5
    //   6: aload 5
    //   8: aload_1
    //   9: invokevirtual 171	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   12: invokevirtual 177	android/content/res/AssetFileDescriptor:getLength	()J
    //   15: lstore_3
    //   16: lload_3
    //   17: lreturn
    //   18: astore_0
    //   19: aconst_null
    //   20: astore_0
    //   21: aload 5
    //   23: aload_1
    //   24: invokevirtual 181	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   27: astore_1
    //   28: aload_1
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual 185	java/io/InputStream:available	()I
    //   34: istore_2
    //   35: iload_2
    //   36: i2l
    //   37: lstore_3
    //   38: aload_0
    //   39: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   42: lload_3
    //   43: lreturn
    //   44: astore_1
    //   45: aload_0
    //   46: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   49: ldc2_w 188
    //   52: lreturn
    //   53: astore_0
    //   54: aconst_null
    //   55: astore 5
    //   57: aload_0
    //   58: astore_1
    //   59: aload 5
    //   61: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   64: aload_1
    //   65: athrow
    //   66: astore_1
    //   67: aload_0
    //   68: astore 5
    //   70: goto -11 -> 59
    //   73: astore_1
    //   74: goto -29 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramContext	Context
    //   0	77	1	paramString	String
    //   34	2	2	i	int
    //   15	28	3	l	long
    //   4	65	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	16	18	java/io/IOException
    //   21	28	44	java/io/IOException
    //   21	28	53	finally
    //   30	35	66	finally
    //   30	35	73	java/io/IOException
  }
  
  private static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  /* Error */
  private static boolean performCopyAssetsFile(Context paramContext, String paramString1, String paramString2, FileUtils.AssetFileComparator paramAssetFileComparator)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_1
    //   7: invokestatic 197	com/tencent/component/network/utils/FileUtils:isEmpty	(Ljava/lang/String;)Z
    //   10: ifne +10 -> 20
    //   13: aload_2
    //   14: invokestatic 197	com/tencent/component/network/utils/FileUtils:isEmpty	(Ljava/lang/String;)Z
    //   17: ifeq +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: invokevirtual 165	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   26: astore 9
    //   28: new 75	java/io/File
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 8
    //   38: aload 8
    //   40: invokevirtual 82	java/io/File:exists	()Z
    //   43: ifeq +47 -> 90
    //   46: aload_3
    //   47: ifnull +30 -> 77
    //   50: aload_3
    //   51: aload_0
    //   52: aload_1
    //   53: aload 8
    //   55: invokeinterface 203 4 0
    //   60: istore 5
    //   62: iload 5
    //   64: ifeq +13 -> 77
    //   67: aconst_null
    //   68: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   71: aconst_null
    //   72: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   75: iconst_1
    //   76: ireturn
    //   77: aload 8
    //   79: invokevirtual 206	java/io/File:isDirectory	()Z
    //   82: ifeq +8 -> 90
    //   85: aload 8
    //   87: invokestatic 208	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   90: aload 8
    //   92: invokevirtual 212	java/io/File:getParentFile	()Ljava/io/File;
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 85	java/io/File:isFile	()Z
    //   100: ifeq +7 -> 107
    //   103: aload_0
    //   104: invokestatic 208	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   107: aload_0
    //   108: invokevirtual 82	java/io/File:exists	()Z
    //   111: ifne +24 -> 135
    //   114: aload_0
    //   115: invokevirtual 215	java/io/File:mkdirs	()Z
    //   118: istore 5
    //   120: iload 5
    //   122: ifne +13 -> 135
    //   125: aconst_null
    //   126: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   129: aconst_null
    //   130: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   133: iconst_0
    //   134: ireturn
    //   135: aload 9
    //   137: aload_1
    //   138: invokevirtual 181	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   141: astore_0
    //   142: new 217	java/io/BufferedOutputStream
    //   145: dup
    //   146: new 219	java/io/FileOutputStream
    //   149: dup
    //   150: aload 8
    //   152: invokespecial 220	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   155: invokespecial 223	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   158: astore_1
    //   159: sipush 1024
    //   162: newarray byte
    //   164: astore_2
    //   165: aload_0
    //   166: aload_2
    //   167: invokevirtual 226	java/io/InputStream:read	([B)I
    //   170: istore 4
    //   172: iload 4
    //   174: ifle +42 -> 216
    //   177: aload_1
    //   178: aload_2
    //   179: iconst_0
    //   180: iload 4
    //   182: invokevirtual 115	java/io/OutputStream:write	([BII)V
    //   185: goto -20 -> 165
    //   188: astore_3
    //   189: aload_1
    //   190: astore_2
    //   191: aload_3
    //   192: astore_1
    //   193: ldc 19
    //   195: ldc 228
    //   197: aload_1
    //   198: invokestatic 234	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   201: aload 8
    //   203: invokestatic 208	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   206: aload_0
    //   207: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   210: aload_2
    //   211: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   214: iconst_0
    //   215: ireturn
    //   216: aload_0
    //   217: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   220: aload_1
    //   221: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   224: iconst_1
    //   225: ireturn
    //   226: astore_1
    //   227: aconst_null
    //   228: astore_0
    //   229: aload 7
    //   231: astore_2
    //   232: aload_0
    //   233: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   236: aload_2
    //   237: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   240: aload_1
    //   241: athrow
    //   242: astore_1
    //   243: aload 7
    //   245: astore_2
    //   246: goto -14 -> 232
    //   249: astore_3
    //   250: aload_1
    //   251: astore_2
    //   252: aload_3
    //   253: astore_1
    //   254: goto -22 -> 232
    //   257: astore_1
    //   258: goto -26 -> 232
    //   261: astore_1
    //   262: aconst_null
    //   263: astore_0
    //   264: aload 6
    //   266: astore_2
    //   267: goto -74 -> 193
    //   270: astore_1
    //   271: aload 6
    //   273: astore_2
    //   274: goto -81 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	paramContext	Context
    //   0	277	1	paramString1	String
    //   0	277	2	paramString2	String
    //   0	277	3	paramAssetFileComparator	FileUtils.AssetFileComparator
    //   170	11	4	i	int
    //   60	61	5	bool	boolean
    //   4	268	6	localObject1	Object
    //   1	243	7	localObject2	Object
    //   36	166	8	localFile	File
    //   26	110	9	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   159	165	188	java/lang/Throwable
    //   165	172	188	java/lang/Throwable
    //   177	185	188	java/lang/Throwable
    //   38	46	226	finally
    //   50	62	226	finally
    //   77	90	226	finally
    //   90	107	226	finally
    //   107	120	226	finally
    //   135	142	226	finally
    //   142	159	242	finally
    //   159	165	249	finally
    //   165	172	249	finally
    //   177	185	249	finally
    //   193	206	257	finally
    //   38	46	261	java/lang/Throwable
    //   50	62	261	java/lang/Throwable
    //   77	90	261	java/lang/Throwable
    //   90	107	261	java/lang/Throwable
    //   107	120	261	java/lang/Throwable
    //   135	142	261	java/lang/Throwable
    //   142	159	270	java/lang/Throwable
  }
  
  /* Error */
  private static boolean performCopyFile(File paramFile1, File paramFile2, FileFilter paramFileFilter, FileUtils.FileComparator paramFileComparator)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: aload_0
    //   7: ifnull +7 -> 14
    //   10: aload_1
    //   11: ifnonnull +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_2
    //   17: ifnull +15 -> 32
    //   20: aload_2
    //   21: aload_0
    //   22: invokeinterface 240 2 0
    //   27: ifne +5 -> 32
    //   30: iconst_0
    //   31: ireturn
    //   32: aload_0
    //   33: invokevirtual 82	java/io/File:exists	()Z
    //   36: ifeq +14 -> 50
    //   39: aload_0
    //   40: invokevirtual 85	java/io/File:isFile	()Z
    //   43: istore 5
    //   45: iload 5
    //   47: ifne +13 -> 60
    //   50: aconst_null
    //   51: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   54: aconst_null
    //   55: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   58: iconst_0
    //   59: ireturn
    //   60: aload_1
    //   61: invokevirtual 82	java/io/File:exists	()Z
    //   64: ifeq +36 -> 100
    //   67: aload_3
    //   68: ifnull +28 -> 96
    //   71: aload_3
    //   72: aload_0
    //   73: aload_1
    //   74: invokeinterface 244 3 0
    //   79: istore 5
    //   81: iload 5
    //   83: ifeq +13 -> 96
    //   86: aconst_null
    //   87: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   90: aconst_null
    //   91: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   94: iconst_1
    //   95: ireturn
    //   96: aload_1
    //   97: invokestatic 208	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   100: aload_1
    //   101: invokevirtual 212	java/io/File:getParentFile	()Ljava/io/File;
    //   104: astore_2
    //   105: aload_2
    //   106: invokevirtual 85	java/io/File:isFile	()Z
    //   109: ifeq +7 -> 116
    //   112: aload_2
    //   113: invokestatic 208	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   116: aload_2
    //   117: invokevirtual 82	java/io/File:exists	()Z
    //   120: ifne +24 -> 144
    //   123: aload_2
    //   124: invokevirtual 215	java/io/File:mkdirs	()Z
    //   127: istore 5
    //   129: iload 5
    //   131: ifne +13 -> 144
    //   134: aconst_null
    //   135: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   138: aconst_null
    //   139: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   142: iconst_0
    //   143: ireturn
    //   144: new 94	java/io/FileInputStream
    //   147: dup
    //   148: aload_0
    //   149: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   152: invokevirtual 248	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   155: astore_0
    //   156: new 219	java/io/FileOutputStream
    //   159: dup
    //   160: aload_1
    //   161: invokespecial 220	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   164: invokevirtual 249	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   167: astore_2
    //   168: aload_0
    //   169: invokevirtual 254	java/nio/channels/FileChannel:size	()J
    //   172: lstore 6
    //   174: lload 6
    //   176: ldc2_w 255
    //   179: lcmp
    //   180: ifgt +56 -> 236
    //   183: iconst_1
    //   184: istore 4
    //   186: iload 4
    //   188: ifeq +81 -> 269
    //   191: lconst_0
    //   192: lstore 6
    //   194: lload 6
    //   196: aload_0
    //   197: invokevirtual 254	java/nio/channels/FileChannel:size	()J
    //   200: lcmp
    //   201: ifge +41 -> 242
    //   204: aload_2
    //   205: aload_0
    //   206: lload 6
    //   208: aload_0
    //   209: invokevirtual 254	java/nio/channels/FileChannel:size	()J
    //   212: lload 6
    //   214: lsub
    //   215: ldc2_w 257
    //   218: invokestatic 264	java/lang/Math:min	(JJ)J
    //   221: invokevirtual 268	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   224: lstore 8
    //   226: lload 6
    //   228: lload 8
    //   230: ladd
    //   231: lstore 6
    //   233: goto -39 -> 194
    //   236: iconst_0
    //   237: istore 4
    //   239: goto -53 -> 186
    //   242: aload_0
    //   243: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   246: aload_2
    //   247: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   250: iconst_1
    //   251: ireturn
    //   252: astore_3
    //   253: aload_1
    //   254: invokestatic 208	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   257: aload_0
    //   258: lconst_0
    //   259: invokevirtual 272	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   262: pop
    //   263: aload_2
    //   264: lconst_0
    //   265: invokevirtual 272	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   268: pop
    //   269: sipush 8192
    //   272: invokestatic 278	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   275: astore_3
    //   276: aload_0
    //   277: aload_3
    //   278: invokevirtual 281	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   281: ifle +56 -> 337
    //   284: aload_3
    //   285: invokevirtual 285	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   288: pop
    //   289: aload_2
    //   290: aload_3
    //   291: invokevirtual 287	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   294: pop
    //   295: aload_3
    //   296: invokevirtual 291	java/nio/ByteBuffer:compact	()Ljava/nio/ByteBuffer;
    //   299: pop
    //   300: goto -24 -> 276
    //   303: astore 10
    //   305: aload_2
    //   306: astore_3
    //   307: aload_0
    //   308: astore_2
    //   309: aload_3
    //   310: astore_0
    //   311: aload 10
    //   313: astore_3
    //   314: ldc 19
    //   316: ldc_w 293
    //   319: aload_3
    //   320: invokestatic 234	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   323: aload_1
    //   324: invokestatic 208	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   327: aload_2
    //   328: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   331: aload_0
    //   332: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   335: iconst_0
    //   336: ireturn
    //   337: aload_0
    //   338: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   341: aload_2
    //   342: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   345: iconst_1
    //   346: ireturn
    //   347: astore_1
    //   348: aconst_null
    //   349: astore_0
    //   350: aload 10
    //   352: astore_2
    //   353: aload_0
    //   354: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   357: aload_2
    //   358: invokestatic 187	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   361: aload_1
    //   362: athrow
    //   363: astore_1
    //   364: aload 10
    //   366: astore_2
    //   367: goto -14 -> 353
    //   370: astore_1
    //   371: goto -18 -> 353
    //   374: astore_1
    //   375: aload_0
    //   376: astore_3
    //   377: aload_2
    //   378: astore_0
    //   379: aload_3
    //   380: astore_2
    //   381: goto -28 -> 353
    //   384: astore_3
    //   385: aconst_null
    //   386: astore_0
    //   387: aload 11
    //   389: astore_2
    //   390: goto -76 -> 314
    //   393: astore_3
    //   394: aload_0
    //   395: astore_2
    //   396: aconst_null
    //   397: astore_0
    //   398: goto -84 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	401	0	paramFile1	File
    //   0	401	1	paramFile2	File
    //   0	401	2	paramFileFilter	FileFilter
    //   0	401	3	paramFileComparator	FileUtils.FileComparator
    //   184	54	4	i	int
    //   43	87	5	bool	boolean
    //   172	60	6	l1	long
    //   224	5	8	l2	long
    //   1	1	10	localObject1	Object
    //   303	62	10	localThrowable	Throwable
    //   4	384	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   194	226	252	java/lang/Throwable
    //   168	174	303	java/lang/Throwable
    //   253	269	303	java/lang/Throwable
    //   269	276	303	java/lang/Throwable
    //   276	300	303	java/lang/Throwable
    //   32	45	347	finally
    //   60	67	347	finally
    //   71	81	347	finally
    //   96	100	347	finally
    //   100	116	347	finally
    //   116	129	347	finally
    //   144	156	347	finally
    //   156	168	363	finally
    //   168	174	370	finally
    //   194	226	370	finally
    //   253	269	370	finally
    //   269	276	370	finally
    //   276	300	370	finally
    //   314	327	374	finally
    //   32	45	384	java/lang/Throwable
    //   60	67	384	java/lang/Throwable
    //   71	81	384	java/lang/Throwable
    //   96	100	384	java/lang/Throwable
    //   100	116	384	java/lang/Throwable
    //   116	129	384	java/lang/Throwable
    //   144	156	384	java/lang/Throwable
    //   156	168	393	java/lang/Throwable
  }
  
  public static boolean rename(File paramFile1, File paramFile2)
  {
    if ((paramFile1 == null) || (paramFile2 == null)) {
      QDLog.e("FileUtils", "Rename: null parameter");
    }
    for (;;)
    {
      return false;
      try
      {
        paramFile1 = paramFile1.getPath();
        if (paramFile1.equals(paramFile2.getPath())) {
          return true;
        }
        if (!paramFile2.exists())
        {
          boolean bool = new File(paramFile1).renameTo(paramFile2);
          return bool;
        }
      }
      catch (SecurityException paramFile1)
      {
        QDLog.e("FileUtils", "Fail to rename file," + paramFile1.toString());
      }
    }
    return false;
  }
  
  /* Error */
  public static boolean unGzip(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore 4
    //   9: iload 4
    //   11: istore_3
    //   12: aload_0
    //   13: ifnull +13 -> 26
    //   16: aload_0
    //   17: invokevirtual 82	java/io/File:exists	()Z
    //   20: ifne +8 -> 28
    //   23: iload 4
    //   25: istore_3
    //   26: iload_3
    //   27: ireturn
    //   28: aload_1
    //   29: invokevirtual 82	java/io/File:exists	()Z
    //   32: ifeq +7 -> 39
    //   35: aload_1
    //   36: invokestatic 208	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   39: new 326	java/util/zip/GZIPInputStream
    //   42: dup
    //   43: new 94	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: invokespecial 329	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   54: astore 5
    //   56: new 217	java/io/BufferedOutputStream
    //   59: dup
    //   60: new 219	java/io/FileOutputStream
    //   63: dup
    //   64: aload_1
    //   65: invokespecial 220	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   68: invokespecial 223	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   71: astore_0
    //   72: ldc_w 330
    //   75: newarray byte
    //   77: astore_1
    //   78: aload 5
    //   80: aload_1
    //   81: invokevirtual 331	java/util/zip/GZIPInputStream:read	([B)I
    //   84: istore_2
    //   85: iload_2
    //   86: iconst_m1
    //   87: if_icmpeq +67 -> 154
    //   90: aload_0
    //   91: aload_1
    //   92: iconst_0
    //   93: iload_2
    //   94: invokevirtual 332	java/io/BufferedOutputStream:write	([BII)V
    //   97: goto -19 -> 78
    //   100: astore 6
    //   102: aload_0
    //   103: astore_1
    //   104: aload 5
    //   106: astore_0
    //   107: aload 6
    //   109: astore 5
    //   111: ldc 19
    //   113: ldc_w 334
    //   116: aload 5
    //   118: invokestatic 234	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   121: aload_0
    //   122: ifnull +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 335	java/util/zip/GZIPInputStream:close	()V
    //   129: iload 4
    //   131: istore_3
    //   132: aload_1
    //   133: ifnull -107 -> 26
    //   136: aload_1
    //   137: invokevirtual 336	java/io/BufferedOutputStream:close	()V
    //   140: iconst_0
    //   141: ireturn
    //   142: astore_0
    //   143: ldc 19
    //   145: ldc_w 338
    //   148: aload_0
    //   149: invokestatic 234	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   152: iconst_0
    //   153: ireturn
    //   154: aload_0
    //   155: invokevirtual 341	java/io/BufferedOutputStream:flush	()V
    //   158: iconst_1
    //   159: istore_3
    //   160: aload 5
    //   162: ifnull +8 -> 170
    //   165: aload 5
    //   167: invokevirtual 335	java/util/zip/GZIPInputStream:close	()V
    //   170: aload_0
    //   171: ifnull -145 -> 26
    //   174: aload_0
    //   175: invokevirtual 336	java/io/BufferedOutputStream:close	()V
    //   178: iconst_1
    //   179: ireturn
    //   180: astore_0
    //   181: ldc 19
    //   183: ldc_w 338
    //   186: aload_0
    //   187: invokestatic 234	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   190: iconst_1
    //   191: ireturn
    //   192: astore_0
    //   193: aconst_null
    //   194: astore 5
    //   196: aload 7
    //   198: astore_1
    //   199: aload 5
    //   201: ifnull +8 -> 209
    //   204: aload 5
    //   206: invokevirtual 335	java/util/zip/GZIPInputStream:close	()V
    //   209: aload_1
    //   210: ifnull +7 -> 217
    //   213: aload_1
    //   214: invokevirtual 336	java/io/BufferedOutputStream:close	()V
    //   217: aload_0
    //   218: athrow
    //   219: astore_1
    //   220: ldc 19
    //   222: ldc_w 338
    //   225: aload_1
    //   226: invokestatic 234	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   229: goto -12 -> 217
    //   232: astore_0
    //   233: aload 7
    //   235: astore_1
    //   236: goto -37 -> 199
    //   239: astore 6
    //   241: aload_0
    //   242: astore_1
    //   243: aload 6
    //   245: astore_0
    //   246: goto -47 -> 199
    //   249: astore 6
    //   251: aload_0
    //   252: astore 5
    //   254: aload 6
    //   256: astore_0
    //   257: goto -58 -> 199
    //   260: astore 5
    //   262: aconst_null
    //   263: astore_0
    //   264: aload 6
    //   266: astore_1
    //   267: goto -156 -> 111
    //   270: astore_1
    //   271: aload 5
    //   273: astore_0
    //   274: aload_1
    //   275: astore 5
    //   277: aload 6
    //   279: astore_1
    //   280: goto -169 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramFile1	File
    //   0	283	1	paramFile2	File
    //   84	10	2	i	int
    //   11	149	3	bool1	boolean
    //   7	123	4	bool2	boolean
    //   54	199	5	localObject1	Object
    //   260	12	5	localThrowable1	Throwable
    //   275	1	5	localFile	File
    //   4	1	6	localObject2	Object
    //   100	8	6	localThrowable2	Throwable
    //   239	5	6	localObject3	Object
    //   249	29	6	localObject4	Object
    //   1	233	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   72	78	100	java/lang/Throwable
    //   78	85	100	java/lang/Throwable
    //   90	97	100	java/lang/Throwable
    //   154	158	100	java/lang/Throwable
    //   125	129	142	java/lang/Throwable
    //   136	140	142	java/lang/Throwable
    //   165	170	180	java/lang/Throwable
    //   174	178	180	java/lang/Throwable
    //   28	39	192	finally
    //   39	56	192	finally
    //   204	209	219	java/lang/Throwable
    //   213	217	219	java/lang/Throwable
    //   56	72	232	finally
    //   72	78	239	finally
    //   78	85	239	finally
    //   90	97	239	finally
    //   154	158	239	finally
    //   111	121	249	finally
    //   28	39	260	java/lang/Throwable
    //   39	56	260	java/lang/Throwable
    //   56	72	270	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */