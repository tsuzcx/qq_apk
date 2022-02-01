package com.tencent.component.network.module.cache;

import android.content.Context;
import android.os.Environment;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.PlatformUtil;
import java.io.File;
import java.io.IOException;

class CacheManager$InnerEnvironment
{
  private static final String EXTEND_SUFFIX = "-ext";
  private static final File EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY = new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data");
  private static final String TAG = "InnerEnvironment";
  
  public static File getExternalCacheDir(Context paramContext, boolean paramBoolean)
  {
    if ((!paramBoolean) && (PlatformUtil.version() >= 8)) {
      return paramContext.getExternalCacheDir();
    }
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext.getPackageName());
        if (paramBoolean)
        {
          paramContext = "-ext";
          localStringBuilder.append(paramContext);
          paramContext = getExternalStorageAppCacheDirectory(localStringBuilder.toString());
          paramBoolean = paramContext.exists();
          if (!paramBoolean)
          {
            try
            {
              new File(getExternalStorageAndroidDataDir(), ".nomedia").createNewFile();
            }
            catch (IOException localIOException)
            {
              QDLog.e("InnerEnvironment", "", localIOException);
            }
            if (!paramContext.mkdirs())
            {
              QDLog.w("InnerEnvironment", "Unable to create external cache directory");
              return null;
            }
          }
          return paramContext;
        }
      }
      finally {}
      paramContext = "";
    }
  }
  
  /* Error */
  public static File getExternalFilesDir(Context paramContext, String paramString, boolean paramBoolean)
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
    //   28: astore_3
    //   29: aload_3
    //   30: aload_0
    //   31: invokevirtual 57	android/content/Context:getPackageName	()Ljava/lang/String;
    //   34: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: iload_2
    //   39: ifeq +152 -> 191
    //   42: ldc 8
    //   44: astore_0
    //   45: goto +3 -> 48
    //   48: aload_3
    //   49: aload_0
    //   50: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 104	com/tencent/component/network/module/cache/CacheManager$InnerEnvironment:getExternalStorageAppFilesDirectory	(Ljava/lang/String;)Ljava/io/File;
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 72	java/io/File:exists	()Z
    //   66: istore_2
    //   67: iload_2
    //   68: ifne +39 -> 107
    //   71: new 17	java/io/File
    //   74: dup
    //   75: invokestatic 75	com/tencent/component/network/module/cache/CacheManager$InnerEnvironment:getExternalStorageAndroidDataDir	()Ljava/io/File;
    //   78: ldc 77
    //   80: invokespecial 29	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   83: invokevirtual 80	java/io/File:createNewFile	()Z
    //   86: pop
    //   87: aload_0
    //   88: invokevirtual 91	java/io/File:mkdirs	()Z
    //   91: ifne +16 -> 107
    //   94: ldc 13
    //   96: ldc 106
    //   98: invokestatic 111	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   101: pop
    //   102: ldc 2
    //   104: monitorexit
    //   105: aconst_null
    //   106: areturn
    //   107: aload_1
    //   108: ifnonnull +8 -> 116
    //   111: ldc 2
    //   113: monitorexit
    //   114: aload_0
    //   115: areturn
    //   116: new 17	java/io/File
    //   119: dup
    //   120: aload_0
    //   121: aload_1
    //   122: invokespecial 29	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   125: astore_0
    //   126: aload_0
    //   127: invokevirtual 72	java/io/File:exists	()Z
    //   130: ifne +46 -> 176
    //   133: aload_0
    //   134: invokevirtual 91	java/io/File:mkdirs	()Z
    //   137: ifne +39 -> 176
    //   140: new 52	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   147: astore_1
    //   148: aload_1
    //   149: ldc 113
    //   151: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_1
    //   156: aload_0
    //   157: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: ldc 13
    //   163: aload_1
    //   164: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 111	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   170: pop
    //   171: ldc 2
    //   173: monitorexit
    //   174: aconst_null
    //   175: areturn
    //   176: ldc 2
    //   178: monitorexit
    //   179: aload_0
    //   180: areturn
    //   181: astore_0
    //   182: ldc 2
    //   184: monitorexit
    //   185: aload_0
    //   186: athrow
    //   187: astore_3
    //   188: goto -101 -> 87
    //   191: ldc 82
    //   193: astore_0
    //   194: goto -146 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramContext	Context
    //   0	197	1	paramString	String
    //   0	197	2	paramBoolean	boolean
    //   28	27	3	localStringBuilder	StringBuilder
    //   187	1	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   21	38	181	finally
    //   48	67	181	finally
    //   71	87	181	finally
    //   87	105	181	finally
    //   111	114	181	finally
    //   116	174	181	finally
    //   176	179	181	finally
    //   182	185	181	finally
    //   71	87	187	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.module.cache.CacheManager.InnerEnvironment
 * JD-Core Version:    0.7.0.1
 */