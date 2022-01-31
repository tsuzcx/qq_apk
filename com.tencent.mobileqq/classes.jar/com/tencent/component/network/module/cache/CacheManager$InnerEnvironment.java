package com.tencent.component.network.module.cache;

import android.os.Environment;
import java.io.File;

class CacheManager$InnerEnvironment
{
  private static final String EXTEND_SUFFIX = "-ext";
  private static final File EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY = new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data");
  private static final String TAG = "InnerEnvironment";
  
  /* Error */
  public static File getExternalCacheDir(android.content.Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifne +16 -> 17
    //   4: invokestatic 46	com/tencent/component/network/utils/PlatformUtil:version	()I
    //   7: bipush 8
    //   9: if_icmplt +8 -> 17
    //   12: aload_0
    //   13: invokevirtual 50	android/content/Context:getExternalCacheDir	()Ljava/io/File;
    //   16: areturn
    //   17: ldc 2
    //   19: monitorenter
    //   20: new 52	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   27: aload_0
    //   28: invokevirtual 57	android/content/Context:getPackageName	()Ljava/lang/String;
    //   31: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: astore_2
    //   35: iload_1
    //   36: ifeq +68 -> 104
    //   39: ldc 8
    //   41: astore_0
    //   42: aload_2
    //   43: aload_0
    //   44: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 68	com/tencent/component/network/module/cache/CacheManager$InnerEnvironment:getExternalStorageAppCacheDirectory	(Ljava/lang/String;)Ljava/io/File;
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 72	java/io/File:exists	()Z
    //   58: istore_1
    //   59: iload_1
    //   60: ifne +62 -> 122
    //   63: new 17	java/io/File
    //   66: dup
    //   67: invokestatic 75	com/tencent/component/network/module/cache/CacheManager$InnerEnvironment:getExternalStorageAndroidDataDir	()Ljava/io/File;
    //   70: ldc 77
    //   72: invokespecial 29	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   75: invokevirtual 80	java/io/File:createNewFile	()Z
    //   78: pop
    //   79: aload_0
    //   80: invokevirtual 83	java/io/File:mkdirs	()Z
    //   83: ifne +39 -> 122
    //   86: ldc 13
    //   88: ldc 85
    //   90: invokestatic 91	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: ldc 2
    //   95: monitorexit
    //   96: aconst_null
    //   97: areturn
    //   98: astore_0
    //   99: ldc 2
    //   101: monitorexit
    //   102: aload_0
    //   103: athrow
    //   104: ldc 93
    //   106: astore_0
    //   107: goto -65 -> 42
    //   110: astore_2
    //   111: ldc 13
    //   113: ldc 93
    //   115: aload_2
    //   116: invokestatic 97	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   119: goto -40 -> 79
    //   122: ldc 2
    //   124: monitorexit
    //   125: aload_0
    //   126: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramContext	android.content.Context
    //   0	127	1	paramBoolean	boolean
    //   34	9	2	localStringBuilder	java.lang.StringBuilder
    //   110	6	2	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   20	35	98	finally
    //   42	59	98	finally
    //   63	79	98	finally
    //   79	96	98	finally
    //   99	102	98	finally
    //   111	119	98	finally
    //   122	125	98	finally
    //   63	79	110	java/io/IOException
  }
  
  /* Error */
  public static File getExternalFilesDir(android.content.Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifne +17 -> 18
    //   4: invokestatic 46	com/tencent/component/network/utils/PlatformUtil:version	()I
    //   7: bipush 8
    //   9: if_icmplt +9 -> 18
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual 101	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   17: areturn
    //   18: ldc 2
    //   20: monitorenter
    //   21: new 52	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   28: aload_0
    //   29: invokevirtual 57	android/content/Context:getPackageName	()Ljava/lang/String;
    //   32: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: astore_3
    //   36: iload_2
    //   37: ifeq +69 -> 106
    //   40: ldc 8
    //   42: astore_0
    //   43: aload_3
    //   44: aload_0
    //   45: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 104	com/tencent/component/network/module/cache/CacheManager$InnerEnvironment:getExternalStorageAppFilesDirectory	(Ljava/lang/String;)Ljava/io/File;
    //   54: astore_0
    //   55: aload_0
    //   56: invokevirtual 72	java/io/File:exists	()Z
    //   59: istore_2
    //   60: iload_2
    //   61: ifne +51 -> 112
    //   64: new 17	java/io/File
    //   67: dup
    //   68: invokestatic 75	com/tencent/component/network/module/cache/CacheManager$InnerEnvironment:getExternalStorageAndroidDataDir	()Ljava/io/File;
    //   71: ldc 77
    //   73: invokespecial 29	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   76: invokevirtual 80	java/io/File:createNewFile	()Z
    //   79: pop
    //   80: aload_0
    //   81: invokevirtual 83	java/io/File:mkdirs	()Z
    //   84: ifne +28 -> 112
    //   87: ldc 13
    //   89: ldc 106
    //   91: invokestatic 111	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   94: pop
    //   95: ldc 2
    //   97: monitorexit
    //   98: aconst_null
    //   99: areturn
    //   100: astore_0
    //   101: ldc 2
    //   103: monitorexit
    //   104: aload_0
    //   105: athrow
    //   106: ldc 93
    //   108: astore_0
    //   109: goto -66 -> 43
    //   112: aload_1
    //   113: ifnonnull +8 -> 121
    //   116: ldc 2
    //   118: monitorexit
    //   119: aload_0
    //   120: areturn
    //   121: new 17	java/io/File
    //   124: dup
    //   125: aload_0
    //   126: aload_1
    //   127: invokespecial 29	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   130: astore_0
    //   131: aload_0
    //   132: invokevirtual 72	java/io/File:exists	()Z
    //   135: ifne +40 -> 175
    //   138: aload_0
    //   139: invokevirtual 83	java/io/File:mkdirs	()Z
    //   142: ifne +33 -> 175
    //   145: ldc 13
    //   147: new 52	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   154: ldc 113
    //   156: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_0
    //   160: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 111	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   169: pop
    //   170: ldc 2
    //   172: monitorexit
    //   173: aconst_null
    //   174: areturn
    //   175: ldc 2
    //   177: monitorexit
    //   178: aload_0
    //   179: areturn
    //   180: astore_3
    //   181: goto -101 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramContext	android.content.Context
    //   0	184	1	paramString	String
    //   0	184	2	paramBoolean	boolean
    //   35	9	3	localStringBuilder	java.lang.StringBuilder
    //   180	1	3	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   21	36	100	finally
    //   43	60	100	finally
    //   64	80	100	finally
    //   80	98	100	finally
    //   101	104	100	finally
    //   116	119	100	finally
    //   121	173	100	finally
    //   175	178	100	finally
    //   64	80	180	java/io/IOException
  }
  
  public static File getExternalStorageAndroidDataDir()
  {
    return EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY;
  }
  
  public static File getExternalStorageAppCacheDirectory(String paramString)
  {
    return new File(new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY, paramString), "cache");
  }
  
  public static File getExternalStorageAppFilesDirectory(String paramString)
  {
    return new File(new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY, paramString), "files");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.cache.CacheManager.InnerEnvironment
 * JD-Core Version:    0.7.0.1
 */