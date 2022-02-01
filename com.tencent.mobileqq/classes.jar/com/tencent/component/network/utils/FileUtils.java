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
    //   4: ifne +196 -> 200
    //   7: aload_1
    //   8: ifnonnull +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aconst_null
    //   14: astore 4
    //   16: aconst_null
    //   17: astore 5
    //   19: getstatic 42	com/tencent/component/network/utils/FileUtils:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   22: invokevirtual 73	com/tencent/component/network/utils/BytesBufferPool:get	()Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;
    //   25: astore 6
    //   27: aload 5
    //   29: astore_3
    //   30: new 75	java/io/File
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore_0
    //   39: aload 5
    //   41: astore_3
    //   42: aload_0
    //   43: invokevirtual 82	java/io/File:exists	()Z
    //   46: ifeq +89 -> 135
    //   49: aload 5
    //   51: astore_3
    //   52: aload_0
    //   53: invokevirtual 85	java/io/File:isFile	()Z
    //   56: ifne +6 -> 62
    //   59: goto +76 -> 135
    //   62: aload 5
    //   64: astore_3
    //   65: new 87	java/io/FileInputStream
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   73: astore_0
    //   74: aload_0
    //   75: aload 6
    //   77: getfield 96	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   80: iconst_0
    //   81: aload 6
    //   83: getfield 96	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   86: arraylength
    //   87: invokevirtual 102	java/io/InputStream:read	([BII)I
    //   90: istore_2
    //   91: iload_2
    //   92: ifle +17 -> 109
    //   95: aload_1
    //   96: aload 6
    //   98: getfield 96	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   101: iconst_0
    //   102: iload_2
    //   103: invokevirtual 108	java/io/OutputStream:write	([BII)V
    //   106: goto -32 -> 74
    //   109: getstatic 42	com/tencent/component/network/utils/FileUtils:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   112: aload 6
    //   114: invokevirtual 112	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   117: aload_0
    //   118: invokevirtual 113	java/io/InputStream:close	()V
    //   121: iconst_1
    //   122: ireturn
    //   123: astore_1
    //   124: aload_0
    //   125: astore_3
    //   126: aload_1
    //   127: astore_0
    //   128: goto +54 -> 182
    //   131: astore_1
    //   132: goto +21 -> 153
    //   135: getstatic 42	com/tencent/component/network/utils/FileUtils:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   138: aload 6
    //   140: invokevirtual 112	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   143: iconst_0
    //   144: ireturn
    //   145: astore_0
    //   146: goto +36 -> 182
    //   149: astore_1
    //   150: aload 4
    //   152: astore_0
    //   153: aload_0
    //   154: astore_3
    //   155: ldc 19
    //   157: ldc 115
    //   159: aload_1
    //   160: invokestatic 121	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   163: pop
    //   164: getstatic 42	com/tencent/component/network/utils/FileUtils:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   167: aload 6
    //   169: invokevirtual 112	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   172: aload_0
    //   173: ifnull +7 -> 180
    //   176: aload_0
    //   177: invokevirtual 113	java/io/InputStream:close	()V
    //   180: iconst_0
    //   181: ireturn
    //   182: getstatic 42	com/tencent/component/network/utils/FileUtils:sBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   185: aload 6
    //   187: invokevirtual 112	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   190: aload_3
    //   191: ifnull +7 -> 198
    //   194: aload_3
    //   195: invokevirtual 113	java/io/InputStream:close	()V
    //   198: aload_0
    //   199: athrow
    //   200: iconst_0
    //   201: ireturn
    //   202: astore_0
    //   203: goto -82 -> 121
    //   206: astore_0
    //   207: iconst_0
    //   208: ireturn
    //   209: astore_1
    //   210: goto -12 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramString	String
    //   0	213	1	paramOutputStream	java.io.OutputStream
    //   90	13	2	i	int
    //   29	166	3	localObject1	Object
    //   14	137	4	localObject2	Object
    //   17	46	5	localObject3	Object
    //   25	161	6	localBytesBuffer	BytesBufferPool.BytesBuffer
    // Exception table:
    //   from	to	target	type
    //   74	91	123	finally
    //   95	106	123	finally
    //   74	91	131	java/lang/Throwable
    //   95	106	131	java/lang/Throwable
    //   30	39	145	finally
    //   42	49	145	finally
    //   52	59	145	finally
    //   65	74	145	finally
    //   155	164	145	finally
    //   30	39	149	java/lang/Throwable
    //   42	49	149	java/lang/Throwable
    //   52	59	149	java/lang/Throwable
    //   65	74	149	java/lang/Throwable
    //   117	121	202	java/lang/Throwable
    //   176	180	206	java/lang/Throwable
    //   194	198	209	java/lang/Throwable
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
    if (paramFile1 != null)
    {
      if (paramFile2 == null) {
        return false;
      }
      if (!paramFile1.exists()) {
        return false;
      }
      if (paramFile1.isFile()) {
        return performCopyFile(paramFile1, paramFile2, paramFileFilter, paramFileComparator);
      }
      paramFile1 = paramFile1.listFiles();
      if (paramFile1 == null) {
        return false;
      }
      int j = paramFile1.length;
      int i = 0;
      boolean bool = true;
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
    return false;
  }
  
  public static void delete(File paramFile)
  {
    delete(paramFile, false);
  }
  
  public static void delete(File paramFile, boolean paramBoolean)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return;
      }
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile == null) {
        return;
      }
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        delete(arrayOfFile[i], paramBoolean);
        i += 1;
      }
      if (!paramBoolean) {
        paramFile.delete();
      }
    }
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
    //   1: invokevirtual 162	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: astore 6
    //   6: aload 6
    //   8: aload_1
    //   9: invokevirtual 168	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   12: invokevirtual 174	android/content/res/AssetFileDescriptor:getLength	()J
    //   15: lstore_3
    //   16: lload_3
    //   17: lreturn
    //   18: aconst_null
    //   19: astore 5
    //   21: aconst_null
    //   22: astore_0
    //   23: aload 6
    //   25: aload_1
    //   26: invokevirtual 178	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: astore_1
    //   30: aload_1
    //   31: astore_0
    //   32: aload_1
    //   33: astore 5
    //   35: aload_1
    //   36: invokevirtual 182	java/io/InputStream:available	()I
    //   39: istore_2
    //   40: iload_2
    //   41: i2l
    //   42: lstore_3
    //   43: aload_1
    //   44: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   47: lload_3
    //   48: lreturn
    //   49: astore_1
    //   50: aload_0
    //   51: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   54: aload_1
    //   55: athrow
    //   56: aload 5
    //   58: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   61: ldc2_w 185
    //   64: lreturn
    //   65: astore_0
    //   66: goto -48 -> 18
    //   69: astore_0
    //   70: goto -14 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramContext	Context
    //   0	73	1	paramString	String
    //   39	2	2	i	int
    //   15	33	3	l	long
    //   19	38	5	str	String
    //   4	20	6	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   23	30	49	finally
    //   35	40	49	finally
    //   6	16	65	java/io/IOException
    //   23	30	69	java/io/IOException
    //   35	40	69	java/io/IOException
  }
  
  private static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  /* Error */
  private static boolean performCopyAssetsFile(Context paramContext, String paramString1, String paramString2, FileUtils.AssetFileComparator paramAssetFileComparator)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 194	com/tencent/component/network/utils/FileUtils:isEmpty	(Ljava/lang/String;)Z
    //   4: ifne +271 -> 275
    //   7: aload_2
    //   8: invokestatic 194	com/tencent/component/network/utils/FileUtils:isEmpty	(Ljava/lang/String;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: invokevirtual 162	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   20: astore 8
    //   22: new 75	java/io/File
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore 7
    //   32: aconst_null
    //   33: astore_2
    //   34: aconst_null
    //   35: astore 6
    //   37: aload 7
    //   39: invokevirtual 82	java/io/File:exists	()Z
    //   42: ifeq +47 -> 89
    //   45: aload_3
    //   46: ifnull +30 -> 76
    //   49: aload_3
    //   50: aload_0
    //   51: aload_1
    //   52: aload 7
    //   54: invokeinterface 200 4 0
    //   59: istore 5
    //   61: iload 5
    //   63: ifeq +13 -> 76
    //   66: aconst_null
    //   67: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   70: aconst_null
    //   71: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   74: iconst_1
    //   75: ireturn
    //   76: aload 7
    //   78: invokevirtual 203	java/io/File:isDirectory	()Z
    //   81: ifeq +8 -> 89
    //   84: aload 7
    //   86: invokestatic 205	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   89: aload 7
    //   91: invokevirtual 209	java/io/File:getParentFile	()Ljava/io/File;
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 85	java/io/File:isFile	()Z
    //   99: ifeq +7 -> 106
    //   102: aload_0
    //   103: invokestatic 205	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   106: aload_0
    //   107: invokevirtual 82	java/io/File:exists	()Z
    //   110: ifne +24 -> 134
    //   113: aload_0
    //   114: invokevirtual 212	java/io/File:mkdirs	()Z
    //   117: istore 5
    //   119: iload 5
    //   121: ifne +13 -> 134
    //   124: aconst_null
    //   125: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   128: aconst_null
    //   129: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   132: iconst_0
    //   133: ireturn
    //   134: aload 8
    //   136: aload_1
    //   137: invokevirtual 178	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   140: astore_0
    //   141: new 214	java/io/BufferedOutputStream
    //   144: dup
    //   145: new 216	java/io/FileOutputStream
    //   148: dup
    //   149: aload 7
    //   151: invokespecial 217	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   154: invokespecial 220	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   157: astore_3
    //   158: sipush 1024
    //   161: newarray byte
    //   163: astore_1
    //   164: aload_0
    //   165: aload_1
    //   166: invokevirtual 223	java/io/InputStream:read	([B)I
    //   169: istore 4
    //   171: iload 4
    //   173: ifle +14 -> 187
    //   176: aload_3
    //   177: aload_1
    //   178: iconst_0
    //   179: iload 4
    //   181: invokevirtual 108	java/io/OutputStream:write	([BII)V
    //   184: goto -20 -> 164
    //   187: aload_0
    //   188: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   191: aload_3
    //   192: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   195: iconst_1
    //   196: ireturn
    //   197: astore_1
    //   198: aload_3
    //   199: astore_2
    //   200: goto +65 -> 265
    //   203: astore_2
    //   204: aload_3
    //   205: astore_1
    //   206: goto +31 -> 237
    //   209: astore_1
    //   210: aconst_null
    //   211: astore_2
    //   212: goto +53 -> 265
    //   215: astore_2
    //   216: aconst_null
    //   217: astore_1
    //   218: goto +19 -> 237
    //   221: astore_1
    //   222: aconst_null
    //   223: astore_3
    //   224: aload_2
    //   225: astore_0
    //   226: aload_3
    //   227: astore_2
    //   228: goto +37 -> 265
    //   231: astore_2
    //   232: aconst_null
    //   233: astore_1
    //   234: aload 6
    //   236: astore_0
    //   237: ldc 19
    //   239: ldc 225
    //   241: aload_2
    //   242: invokestatic 231	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   245: aload 7
    //   247: invokestatic 205	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   250: aload_0
    //   251: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   254: aload_1
    //   255: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   258: iconst_0
    //   259: ireturn
    //   260: astore_3
    //   261: aload_1
    //   262: astore_2
    //   263: aload_3
    //   264: astore_1
    //   265: aload_0
    //   266: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   269: aload_2
    //   270: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   273: aload_1
    //   274: athrow
    //   275: iconst_0
    //   276: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	paramContext	Context
    //   0	277	1	paramString1	String
    //   0	277	2	paramString2	String
    //   0	277	3	paramAssetFileComparator	FileUtils.AssetFileComparator
    //   169	11	4	i	int
    //   59	61	5	bool	boolean
    //   35	200	6	localObject	Object
    //   30	216	7	localFile	File
    //   20	115	8	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   158	164	197	finally
    //   164	171	197	finally
    //   176	184	197	finally
    //   158	164	203	java/lang/Throwable
    //   164	171	203	java/lang/Throwable
    //   176	184	203	java/lang/Throwable
    //   141	158	209	finally
    //   141	158	215	java/lang/Throwable
    //   37	45	221	finally
    //   49	61	221	finally
    //   76	89	221	finally
    //   89	106	221	finally
    //   106	119	221	finally
    //   134	141	221	finally
    //   37	45	231	java/lang/Throwable
    //   49	61	231	java/lang/Throwable
    //   76	89	231	java/lang/Throwable
    //   89	106	231	java/lang/Throwable
    //   106	119	231	java/lang/Throwable
    //   134	141	231	java/lang/Throwable
    //   237	250	260	finally
  }
  
  /* Error */
  private static boolean performCopyFile(File paramFile1, File paramFile2, FileFilter paramFileFilter, FileUtils.FileComparator paramFileComparator)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +445 -> 446
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_2
    //   11: ifnull +15 -> 26
    //   14: aload_2
    //   15: aload_0
    //   16: invokeinterface 237 2 0
    //   21: ifne +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: aconst_null
    //   27: astore 13
    //   29: aconst_null
    //   30: astore 12
    //   32: aconst_null
    //   33: astore 11
    //   35: aconst_null
    //   36: astore_2
    //   37: aconst_null
    //   38: astore 10
    //   40: aload_0
    //   41: invokevirtual 82	java/io/File:exists	()Z
    //   44: ifeq +338 -> 382
    //   47: aload_0
    //   48: invokevirtual 85	java/io/File:isFile	()Z
    //   51: ifne +6 -> 57
    //   54: goto +328 -> 382
    //   57: aload_1
    //   58: invokevirtual 82	java/io/File:exists	()Z
    //   61: ifeq +39 -> 100
    //   64: aload_3
    //   65: ifnull +31 -> 96
    //   68: aload_3
    //   69: aload_0
    //   70: aload_1
    //   71: invokeinterface 241 3 0
    //   76: istore 5
    //   78: iload 5
    //   80: ifeq +16 -> 96
    //   83: aconst_null
    //   84: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   87: aload 10
    //   89: astore_2
    //   90: aload_2
    //   91: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   94: iconst_1
    //   95: ireturn
    //   96: aload_1
    //   97: invokestatic 205	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   100: aload_1
    //   101: invokevirtual 209	java/io/File:getParentFile	()Ljava/io/File;
    //   104: astore_3
    //   105: aload_3
    //   106: invokevirtual 85	java/io/File:isFile	()Z
    //   109: ifeq +7 -> 116
    //   112: aload_3
    //   113: invokestatic 205	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   116: aload_3
    //   117: invokevirtual 82	java/io/File:exists	()Z
    //   120: ifne +24 -> 144
    //   123: aload_3
    //   124: invokevirtual 212	java/io/File:mkdirs	()Z
    //   127: istore 5
    //   129: iload 5
    //   131: ifne +13 -> 144
    //   134: aconst_null
    //   135: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   138: aconst_null
    //   139: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   142: iconst_0
    //   143: ireturn
    //   144: new 87	java/io/FileInputStream
    //   147: dup
    //   148: aload_0
    //   149: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   152: invokevirtual 245	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   155: astore 10
    //   157: aload 13
    //   159: astore_0
    //   160: aload 12
    //   162: astore_3
    //   163: new 216	java/io/FileOutputStream
    //   166: dup
    //   167: aload_1
    //   168: invokespecial 217	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   171: invokevirtual 246	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   174: astore_2
    //   175: aload_2
    //   176: astore_0
    //   177: aload_2
    //   178: astore_3
    //   179: aload 10
    //   181: invokevirtual 251	java/nio/channels/FileChannel:size	()J
    //   184: lstore 6
    //   186: lload 6
    //   188: ldc2_w 252
    //   191: lcmp
    //   192: ifgt +9 -> 201
    //   195: iconst_1
    //   196: istore 4
    //   198: goto +6 -> 204
    //   201: iconst_0
    //   202: istore 4
    //   204: iload 4
    //   206: ifeq +92 -> 298
    //   209: lconst_0
    //   210: lstore 6
    //   212: aload_2
    //   213: astore_0
    //   214: lload 6
    //   216: aload 10
    //   218: invokevirtual 251	java/nio/channels/FileChannel:size	()J
    //   221: lcmp
    //   222: ifge +39 -> 261
    //   225: aload_2
    //   226: astore_0
    //   227: aload_2
    //   228: aload 10
    //   230: lload 6
    //   232: aload 10
    //   234: invokevirtual 251	java/nio/channels/FileChannel:size	()J
    //   237: lload 6
    //   239: lsub
    //   240: ldc2_w 254
    //   243: invokestatic 261	java/lang/Math:min	(JJ)J
    //   246: invokevirtual 265	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   249: lstore 8
    //   251: lload 6
    //   253: lload 8
    //   255: ladd
    //   256: lstore 6
    //   258: goto -46 -> 212
    //   261: aload 10
    //   263: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   266: goto -176 -> 90
    //   269: aload_2
    //   270: astore_0
    //   271: aload_2
    //   272: astore_3
    //   273: aload_1
    //   274: invokestatic 205	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   277: aload_2
    //   278: astore_0
    //   279: aload_2
    //   280: astore_3
    //   281: aload 10
    //   283: lconst_0
    //   284: invokevirtual 269	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   287: pop
    //   288: aload_2
    //   289: astore_0
    //   290: aload_2
    //   291: astore_3
    //   292: aload_2
    //   293: lconst_0
    //   294: invokevirtual 269	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   297: pop
    //   298: aload_2
    //   299: astore_0
    //   300: aload_2
    //   301: astore_3
    //   302: sipush 8192
    //   305: invokestatic 275	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   308: astore 11
    //   310: aload_2
    //   311: astore_0
    //   312: aload_2
    //   313: astore_3
    //   314: aload 10
    //   316: aload 11
    //   318: invokevirtual 278	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   321: ifle -60 -> 261
    //   324: aload_2
    //   325: astore_0
    //   326: aload_2
    //   327: astore_3
    //   328: aload 11
    //   330: invokevirtual 282	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   333: pop
    //   334: aload_2
    //   335: astore_0
    //   336: aload_2
    //   337: astore_3
    //   338: aload_2
    //   339: aload 11
    //   341: invokevirtual 284	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   344: pop
    //   345: aload_2
    //   346: astore_0
    //   347: aload_2
    //   348: astore_3
    //   349: aload 11
    //   351: invokevirtual 288	java/nio/ByteBuffer:compact	()Ljava/nio/ByteBuffer;
    //   354: pop
    //   355: goto -45 -> 310
    //   358: astore_3
    //   359: aload_0
    //   360: astore_2
    //   361: aload 10
    //   363: astore_1
    //   364: aload_3
    //   365: astore_0
    //   366: goto +70 -> 436
    //   369: astore 11
    //   371: aload_3
    //   372: astore_2
    //   373: aload 10
    //   375: astore_0
    //   376: aload 11
    //   378: astore_3
    //   379: goto +29 -> 408
    //   382: aconst_null
    //   383: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   386: aconst_null
    //   387: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   390: iconst_0
    //   391: ireturn
    //   392: astore_0
    //   393: aconst_null
    //   394: astore_3
    //   395: aload_2
    //   396: astore_1
    //   397: aload_3
    //   398: astore_2
    //   399: goto +37 -> 436
    //   402: astore_3
    //   403: aconst_null
    //   404: astore_2
    //   405: aload 11
    //   407: astore_0
    //   408: ldc 19
    //   410: ldc_w 290
    //   413: aload_3
    //   414: invokestatic 231	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   417: aload_1
    //   418: invokestatic 205	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   421: aload_0
    //   422: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   425: aload_2
    //   426: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   429: iconst_0
    //   430: ireturn
    //   431: astore_3
    //   432: aload_0
    //   433: astore_1
    //   434: aload_3
    //   435: astore_0
    //   436: aload_1
    //   437: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   440: aload_2
    //   441: invokestatic 184	com/tencent/component/network/utils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   444: aload_0
    //   445: athrow
    //   446: iconst_0
    //   447: ireturn
    //   448: astore_0
    //   449: goto -180 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	452	0	paramFile1	File
    //   0	452	1	paramFile2	File
    //   0	452	2	paramFileFilter	FileFilter
    //   0	452	3	paramFileComparator	FileUtils.FileComparator
    //   196	9	4	i	int
    //   76	54	5	bool	boolean
    //   184	73	6	l1	long
    //   249	5	8	l2	long
    //   38	336	10	localFileChannel	java.nio.channels.FileChannel
    //   33	317	11	localByteBuffer	java.nio.ByteBuffer
    //   369	37	11	localThrowable	Throwable
    //   30	131	12	localObject1	Object
    //   27	131	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   163	175	358	finally
    //   179	186	358	finally
    //   214	225	358	finally
    //   227	251	358	finally
    //   273	277	358	finally
    //   281	288	358	finally
    //   292	298	358	finally
    //   302	310	358	finally
    //   314	324	358	finally
    //   328	334	358	finally
    //   338	345	358	finally
    //   349	355	358	finally
    //   163	175	369	java/lang/Throwable
    //   179	186	369	java/lang/Throwable
    //   273	277	369	java/lang/Throwable
    //   281	288	369	java/lang/Throwable
    //   292	298	369	java/lang/Throwable
    //   302	310	369	java/lang/Throwable
    //   314	324	369	java/lang/Throwable
    //   328	334	369	java/lang/Throwable
    //   338	345	369	java/lang/Throwable
    //   349	355	369	java/lang/Throwable
    //   40	54	392	finally
    //   57	64	392	finally
    //   68	78	392	finally
    //   96	100	392	finally
    //   100	116	392	finally
    //   116	129	392	finally
    //   144	157	392	finally
    //   40	54	402	java/lang/Throwable
    //   57	64	402	java/lang/Throwable
    //   68	78	402	java/lang/Throwable
    //   96	100	402	java/lang/Throwable
    //   100	116	402	java/lang/Throwable
    //   116	129	402	java/lang/Throwable
    //   144	157	402	java/lang/Throwable
    //   408	421	431	finally
    //   214	225	448	java/lang/Throwable
    //   227	251	448	java/lang/Throwable
  }
  
  public static boolean rename(File paramFile1, File paramFile2)
  {
    if ((paramFile1 != null) && (paramFile2 != null)) {
      try
      {
        paramFile1 = paramFile1.getPath();
        if (paramFile1.equals(paramFile2.getPath())) {
          return true;
        }
        if (paramFile2.exists()) {
          return false;
        }
        boolean bool = new File(paramFile1).renameTo(paramFile2);
        return bool;
      }
      catch (SecurityException paramFile1)
      {
        paramFile2 = new StringBuilder();
        paramFile2.append("Fail to rename file,");
        paramFile2.append(paramFile1.toString());
        QDLog.e("FileUtils", paramFile2.toString());
        return false;
      }
    }
    QDLog.e("FileUtils", "Rename: null parameter");
    return false;
  }
  
  /* Error */
  public static boolean unGzip(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: ifnull +254 -> 258
    //   7: aload_0
    //   8: invokevirtual 82	java/io/File:exists	()Z
    //   11: ifne +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 6
    //   22: aload_1
    //   23: invokevirtual 82	java/io/File:exists	()Z
    //   26: ifeq +7 -> 33
    //   29: aload_1
    //   30: invokestatic 205	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   33: new 323	java/util/zip/GZIPInputStream
    //   36: dup
    //   37: new 87	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: invokespecial 326	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_0
    //   49: new 214	java/io/BufferedOutputStream
    //   52: dup
    //   53: new 216	java/io/FileOutputStream
    //   56: dup
    //   57: aload_1
    //   58: invokespecial 217	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: invokespecial 220	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   64: astore_1
    //   65: ldc_w 327
    //   68: newarray byte
    //   70: astore 5
    //   72: aload_0
    //   73: aload 5
    //   75: invokevirtual 328	java/util/zip/GZIPInputStream:read	([B)I
    //   78: istore_2
    //   79: iload_2
    //   80: iconst_m1
    //   81: if_icmpeq +14 -> 95
    //   84: aload_1
    //   85: aload 5
    //   87: iconst_0
    //   88: iload_2
    //   89: invokevirtual 329	java/io/BufferedOutputStream:write	([BII)V
    //   92: goto -20 -> 72
    //   95: aload_1
    //   96: invokevirtual 332	java/io/BufferedOutputStream:flush	()V
    //   99: iconst_1
    //   100: istore 4
    //   102: iload 4
    //   104: istore_3
    //   105: aload_0
    //   106: invokevirtual 333	java/util/zip/GZIPInputStream:close	()V
    //   109: iload 4
    //   111: istore_3
    //   112: aload_1
    //   113: invokevirtual 334	java/io/BufferedOutputStream:close	()V
    //   116: iconst_1
    //   117: ireturn
    //   118: astore_0
    //   119: ldc 19
    //   121: ldc_w 336
    //   124: aload_0
    //   125: invokestatic 231	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: iload_3
    //   129: ireturn
    //   130: astore 6
    //   132: aload_1
    //   133: astore 5
    //   135: aload 6
    //   137: astore_1
    //   138: goto +85 -> 223
    //   141: astore 5
    //   143: goto +38 -> 181
    //   146: astore_1
    //   147: aconst_null
    //   148: astore 5
    //   150: goto +73 -> 223
    //   153: astore 5
    //   155: aconst_null
    //   156: astore_1
    //   157: goto +24 -> 181
    //   160: astore_1
    //   161: aconst_null
    //   162: astore 6
    //   164: aload 5
    //   166: astore_0
    //   167: aload 6
    //   169: astore 5
    //   171: goto +52 -> 223
    //   174: astore 5
    //   176: aconst_null
    //   177: astore_1
    //   178: aload 6
    //   180: astore_0
    //   181: ldc 19
    //   183: ldc_w 338
    //   186: aload 5
    //   188: invokestatic 231	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   191: aload_0
    //   192: ifnull +10 -> 202
    //   195: iload 4
    //   197: istore_3
    //   198: aload_0
    //   199: invokevirtual 333	java/util/zip/GZIPInputStream:close	()V
    //   202: aload_1
    //   203: ifnull +10 -> 213
    //   206: iload 4
    //   208: istore_3
    //   209: aload_1
    //   210: invokevirtual 334	java/io/BufferedOutputStream:close	()V
    //   213: iconst_0
    //   214: ireturn
    //   215: astore 6
    //   217: aload_1
    //   218: astore 5
    //   220: aload 6
    //   222: astore_1
    //   223: aload_0
    //   224: ifnull +10 -> 234
    //   227: aload_0
    //   228: invokevirtual 333	java/util/zip/GZIPInputStream:close	()V
    //   231: goto +3 -> 234
    //   234: aload 5
    //   236: ifnull +20 -> 256
    //   239: aload 5
    //   241: invokevirtual 334	java/io/BufferedOutputStream:close	()V
    //   244: goto +12 -> 256
    //   247: ldc 19
    //   249: ldc_w 336
    //   252: aload_0
    //   253: invokestatic 231	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   256: aload_1
    //   257: athrow
    //   258: iconst_0
    //   259: ireturn
    //   260: astore_0
    //   261: goto -14 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramFile1	File
    //   0	264	1	paramFile2	File
    //   78	11	2	i	int
    //   104	105	3	bool1	boolean
    //   1	206	4	bool2	boolean
    //   17	117	5	localObject1	Object
    //   141	1	5	localThrowable1	Throwable
    //   148	1	5	localObject2	Object
    //   153	12	5	localThrowable2	Throwable
    //   169	1	5	localObject3	Object
    //   174	13	5	localThrowable3	Throwable
    //   218	22	5	localFile	File
    //   20	1	6	localObject4	Object
    //   130	6	6	localObject5	Object
    //   162	17	6	localObject6	Object
    //   215	6	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   105	109	118	java/lang/Throwable
    //   112	116	118	java/lang/Throwable
    //   198	202	118	java/lang/Throwable
    //   209	213	118	java/lang/Throwable
    //   65	72	130	finally
    //   72	79	130	finally
    //   84	92	130	finally
    //   95	99	130	finally
    //   65	72	141	java/lang/Throwable
    //   72	79	141	java/lang/Throwable
    //   84	92	141	java/lang/Throwable
    //   95	99	141	java/lang/Throwable
    //   49	65	146	finally
    //   49	65	153	java/lang/Throwable
    //   22	33	160	finally
    //   33	49	160	finally
    //   22	33	174	java/lang/Throwable
    //   33	49	174	java/lang/Throwable
    //   181	191	215	finally
    //   227	231	260	java/lang/Throwable
    //   239	244	260	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */