package com.tencent.component.network.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.module.base.QDLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import pky;
import pkz;

public class FileUtils
{
  private static final int ASSET_SPLIT_BASE = 0;
  private static final int BUFFER_SIZE = 8192;
  private static final int BUFFER_SIZE_MMAP = 8388608;
  public static final FileUtils.AssetFileComparator SIMPLE_ASSET_COMPARATOR = new pkz();
  public static final FileUtils.FileComparator SIMPLE_COMPARATOR = new pky();
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
    //   16: invokevirtual 73	com/tencent/component/network/utils/BytesBufferPool:a	()Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;
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
    //   51: invokevirtual 88	com/tencent/component/network/utils/BytesBufferPool:a	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   54: iconst_0
    //   55: ifeq -44 -> 11
    //   58: new 90	java/lang/NullPointerException
    //   61: dup
    //   62: invokespecial 91	java/lang/NullPointerException:<init>	()V
    //   65: athrow
    //   66: astore_0
    //   67: iconst_0
    //   68: ireturn
    //   69: new 93	java/io/FileInputStream
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 96	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   77: astore 4
    //   79: aload 4
    //   81: astore_0
    //   82: aload 4
    //   84: aload 5
    //   86: getfield 101	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:a	[B
    //   89: iconst_0
    //   90: aload 5
    //   92: getfield 101	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:a	[B
    //   95: arraylength
    //   96: invokevirtual 107	java/io/InputStream:read	([BII)I
    //   99: istore_2
    //   100: iload_2
    //   101: ifle +78 -> 179
    //   104: aload 4
    //   106: astore_0
    //   107: aload_1
    //   108: aload 5
    //   110: getfield 101	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:a	[B
    //   113: iconst_0
    //   114: iload_2
    //   115: invokevirtual 113	java/io/OutputStream:write	([BII)V
    //   118: goto -39 -> 79
    //   121: astore_0
    //   122: aload 4
    //   124: astore_1
    //   125: aload_0
    //   126: astore 4
    //   128: aload_1
    //   129: astore_0
    //   130: ldc 19
    //   132: ldc 115
    //   134: aload 4
    //   136: invokestatic 121	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   139: pop
    //   140: getstatic 42	com/tencent/component/network/utils/FileUtils:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   143: aload 5
    //   145: invokevirtual 88	com/tencent/component/network/utils/BytesBufferPool:a	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   148: aload_1
    //   149: ifnull -138 -> 11
    //   152: aload_1
    //   153: invokevirtual 122	java/io/InputStream:close	()V
    //   156: iconst_0
    //   157: ireturn
    //   158: astore_1
    //   159: aconst_null
    //   160: astore_0
    //   161: getstatic 42	com/tencent/component/network/utils/FileUtils:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   164: aload 5
    //   166: invokevirtual 88	com/tencent/component/network/utils/BytesBufferPool:a	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   169: aload_0
    //   170: ifnull +7 -> 177
    //   173: aload_0
    //   174: invokevirtual 122	java/io/InputStream:close	()V
    //   177: aload_1
    //   178: athrow
    //   179: getstatic 42	com/tencent/component/network/utils/FileUtils:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   182: aload 5
    //   184: invokevirtual 88	com/tencent/component/network/utils/BytesBufferPool:a	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   187: aload 4
    //   189: ifnull +8 -> 197
    //   192: aload 4
    //   194: invokevirtual 122	java/io/InputStream:close	()V
    //   197: iconst_1
    //   198: ireturn
    //   199: astore_0
    //   200: goto -23 -> 177
    //   203: astore_0
    //   204: goto -7 -> 197
    //   207: astore_1
    //   208: goto -47 -> 161
    //   211: astore 4
    //   213: aconst_null
    //   214: astore_1
    //   215: goto -87 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramString	String
    //   0	218	1	paramOutputStream	java.io.OutputStream
    //   99	16	2	i	int
    //   41	2	3	bool	boolean
    //   77	116	4	localObject	Object
    //   211	1	4	localThrowable	Throwable
    //   19	164	5	localBytesBuffer	BytesBufferPool.BytesBuffer
    // Exception table:
    //   from	to	target	type
    //   58	66	66	java/lang/Throwable
    //   152	156	66	java/lang/Throwable
    //   82	100	121	java/lang/Throwable
    //   107	118	121	java/lang/Throwable
    //   21	42	158	finally
    //   69	79	158	finally
    //   173	177	199	java/lang/Throwable
    //   192	197	203	java/lang/Throwable
    //   82	100	207	finally
    //   107	118	207	finally
    //   130	140	207	finally
    //   21	42	211	java/lang/Throwable
    //   69	79	211	java/lang/Throwable
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
    //   1: invokevirtual 163	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: astore 5
    //   6: aload 5
    //   8: aload_1
    //   9: invokevirtual 169	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   12: invokevirtual 175	android/content/res/AssetFileDescriptor:getLength	()J
    //   15: lstore_3
    //   16: lload_3
    //   17: lreturn
    //   18: astore_0
    //   19: aconst_null
    //   20: astore_0
    //   21: aload 5
    //   23: aload_1
    //   24: invokevirtual 179	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   27: astore_1
    //   28: aload_1
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual 183	java/io/InputStream:available	()I
    //   34: istore_2
    //   35: iload_2
    //   36: i2l
    //   37: lstore_3
    //   38: aload_0
    //   39: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   42: lload_3
    //   43: lreturn
    //   44: astore_0
    //   45: aconst_null
    //   46: astore 5
    //   48: aload_0
    //   49: astore_1
    //   50: aload 5
    //   52: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   55: aload_1
    //   56: athrow
    //   57: astore_1
    //   58: aload_0
    //   59: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   62: ldc2_w 186
    //   65: lreturn
    //   66: astore_1
    //   67: aload_0
    //   68: astore 5
    //   70: goto -20 -> 50
    //   73: astore_1
    //   74: goto -16 -> 58
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
    //   21	28	44	finally
    //   21	28	57	java/io/IOException
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
    //   7: invokestatic 195	com/tencent/component/network/utils/FileUtils:isEmpty	(Ljava/lang/String;)Z
    //   10: ifne +10 -> 20
    //   13: aload_2
    //   14: invokestatic 195	com/tencent/component/network/utils/FileUtils:isEmpty	(Ljava/lang/String;)Z
    //   17: ifeq +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: invokevirtual 163	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
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
    //   55: invokeinterface 200 4 0
    //   60: istore 5
    //   62: iload 5
    //   64: ifeq +13 -> 77
    //   67: aconst_null
    //   68: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   71: aconst_null
    //   72: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   75: iconst_1
    //   76: ireturn
    //   77: aload 8
    //   79: invokevirtual 203	java/io/File:isDirectory	()Z
    //   82: ifeq +8 -> 90
    //   85: aload 8
    //   87: invokestatic 205	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   90: aload 8
    //   92: invokevirtual 209	java/io/File:getParentFile	()Ljava/io/File;
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 85	java/io/File:isFile	()Z
    //   100: ifeq +7 -> 107
    //   103: aload_0
    //   104: invokestatic 205	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   107: aload_0
    //   108: invokevirtual 82	java/io/File:exists	()Z
    //   111: ifne +24 -> 135
    //   114: aload_0
    //   115: invokevirtual 212	java/io/File:mkdirs	()Z
    //   118: istore 5
    //   120: iload 5
    //   122: ifne +13 -> 135
    //   125: aconst_null
    //   126: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   129: aconst_null
    //   130: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   133: iconst_0
    //   134: ireturn
    //   135: aload 9
    //   137: aload_1
    //   138: invokevirtual 179	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   141: astore_0
    //   142: new 214	java/io/BufferedOutputStream
    //   145: dup
    //   146: new 216	java/io/FileOutputStream
    //   149: dup
    //   150: aload 8
    //   152: invokespecial 217	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   155: invokespecial 220	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   158: astore_1
    //   159: sipush 1024
    //   162: newarray byte
    //   164: astore_2
    //   165: aload_0
    //   166: aload_2
    //   167: invokevirtual 223	java/io/InputStream:read	([B)I
    //   170: istore 4
    //   172: iload 4
    //   174: ifle +58 -> 232
    //   177: aload_1
    //   178: aload_2
    //   179: iconst_0
    //   180: iload 4
    //   182: invokevirtual 113	java/io/OutputStream:write	([BII)V
    //   185: goto -20 -> 165
    //   188: astore_3
    //   189: aload_1
    //   190: astore_2
    //   191: aload_3
    //   192: astore_1
    //   193: ldc 19
    //   195: ldc 225
    //   197: aload_1
    //   198: invokestatic 231	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   201: aload 8
    //   203: invokestatic 205	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   206: aload_0
    //   207: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   210: aload_2
    //   211: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   214: iconst_0
    //   215: ireturn
    //   216: astore_1
    //   217: aconst_null
    //   218: astore_0
    //   219: aload 7
    //   221: astore_2
    //   222: aload_0
    //   223: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   226: aload_2
    //   227: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   230: aload_1
    //   231: athrow
    //   232: aload_0
    //   233: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   236: aload_1
    //   237: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   240: iconst_1
    //   241: ireturn
    //   242: astore_1
    //   243: aload 7
    //   245: astore_2
    //   246: goto -24 -> 222
    //   249: astore_3
    //   250: aload_1
    //   251: astore_2
    //   252: aload_3
    //   253: astore_1
    //   254: goto -32 -> 222
    //   257: astore_1
    //   258: goto -36 -> 222
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
    //   38	46	216	finally
    //   50	62	216	finally
    //   77	90	216	finally
    //   90	107	216	finally
    //   107	120	216	finally
    //   135	142	216	finally
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
    //   22: invokeinterface 237 2 0
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
    //   51: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   54: aconst_null
    //   55: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
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
    //   74: invokeinterface 241 3 0
    //   79: istore 5
    //   81: iload 5
    //   83: ifeq +13 -> 96
    //   86: aconst_null
    //   87: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   90: aconst_null
    //   91: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   94: iconst_1
    //   95: ireturn
    //   96: aload_1
    //   97: invokestatic 205	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   100: aload_1
    //   101: invokevirtual 209	java/io/File:getParentFile	()Ljava/io/File;
    //   104: astore_2
    //   105: aload_2
    //   106: invokevirtual 85	java/io/File:isFile	()Z
    //   109: ifeq +7 -> 116
    //   112: aload_2
    //   113: invokestatic 205	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   116: aload_2
    //   117: invokevirtual 82	java/io/File:exists	()Z
    //   120: ifne +24 -> 144
    //   123: aload_2
    //   124: invokevirtual 212	java/io/File:mkdirs	()Z
    //   127: istore 5
    //   129: iload 5
    //   131: ifne +13 -> 144
    //   134: aconst_null
    //   135: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   138: aconst_null
    //   139: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   142: iconst_0
    //   143: ireturn
    //   144: new 93	java/io/FileInputStream
    //   147: dup
    //   148: aload_0
    //   149: invokespecial 96	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   152: invokevirtual 245	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   155: astore_0
    //   156: new 216	java/io/FileOutputStream
    //   159: dup
    //   160: aload_1
    //   161: invokespecial 217	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   164: invokevirtual 246	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   167: astore_2
    //   168: aload_0
    //   169: invokevirtual 251	java/nio/channels/FileChannel:size	()J
    //   172: lstore 6
    //   174: lload 6
    //   176: ldc2_w 252
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
    //   197: invokevirtual 251	java/nio/channels/FileChannel:size	()J
    //   200: lcmp
    //   201: ifge +41 -> 242
    //   204: aload_2
    //   205: aload_0
    //   206: lload 6
    //   208: aload_0
    //   209: invokevirtual 251	java/nio/channels/FileChannel:size	()J
    //   212: lload 6
    //   214: lsub
    //   215: ldc2_w 254
    //   218: invokestatic 261	java/lang/Math:min	(JJ)J
    //   221: invokevirtual 265	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
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
    //   243: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   246: aload_2
    //   247: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   250: iconst_1
    //   251: ireturn
    //   252: astore_3
    //   253: aload_1
    //   254: invokestatic 205	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   257: aload_0
    //   258: lconst_0
    //   259: invokevirtual 269	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   262: pop
    //   263: aload_2
    //   264: lconst_0
    //   265: invokevirtual 269	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   268: pop
    //   269: sipush 8192
    //   272: invokestatic 275	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   275: astore_3
    //   276: aload_0
    //   277: aload_3
    //   278: invokevirtual 278	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   281: ifle +56 -> 337
    //   284: aload_3
    //   285: invokevirtual 282	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   288: pop
    //   289: aload_2
    //   290: aload_3
    //   291: invokevirtual 284	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   294: pop
    //   295: aload_3
    //   296: invokevirtual 288	java/nio/ByteBuffer:compact	()Ljava/nio/ByteBuffer;
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
    //   316: ldc_w 290
    //   319: aload_3
    //   320: invokestatic 231	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   323: aload_1
    //   324: invokestatic 205	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   327: aload_2
    //   328: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   331: aload_0
    //   332: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   335: iconst_0
    //   336: ireturn
    //   337: aload_0
    //   338: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   341: aload_2
    //   342: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   345: iconst_1
    //   346: ireturn
    //   347: astore_1
    //   348: aconst_null
    //   349: astore_0
    //   350: aload 10
    //   352: astore_2
    //   353: aload_0
    //   354: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   357: aload_2
    //   358: invokestatic 185	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
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
      QDLog.d("FileUtils", "Rename: null parameter");
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
        QDLog.d("FileUtils", "Fail to rename file," + paramFile1.toString());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */