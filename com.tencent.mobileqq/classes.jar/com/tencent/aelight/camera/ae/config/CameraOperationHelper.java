package com.tencent.aelight.camera.ae.config;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;

public class CameraOperationHelper
{
  private static MutableLiveData<Boolean> a = new MutableLiveData();
  private static MutableLiveData<Boolean> b = new MutableLiveData();
  private static MutableLiveData<Boolean> c = new MutableLiveData();
  
  public static MutableLiveData<Boolean> a()
  {
    return a;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCameraConfig", "", 4);
    if (!TextUtils.isEmpty(paramContext)) {
      return paramContext;
    }
    return "";
  }
  
  public static MutableLiveData<Boolean> b()
  {
    return b;
  }
  
  /* Error */
  public static String b(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokevirtual 56	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   8: ldc 58
    //   10: invokevirtual 64	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   13: astore_0
    //   14: aload_0
    //   15: astore_1
    //   16: aload_0
    //   17: astore_2
    //   18: aload_0
    //   19: invokestatic 69	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   22: astore_3
    //   23: aload_3
    //   24: astore_1
    //   25: aload_0
    //   26: ifnull +46 -> 72
    //   29: aload_0
    //   30: invokevirtual 74	java/io/InputStream:close	()V
    //   33: aload_3
    //   34: areturn
    //   35: astore_0
    //   36: aload_0
    //   37: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   40: aload_3
    //   41: areturn
    //   42: astore_0
    //   43: goto +31 -> 74
    //   46: astore_0
    //   47: aload_2
    //   48: astore_1
    //   49: aload_0
    //   50: invokevirtual 78	java/lang/Throwable:printStackTrace	()V
    //   53: aload_2
    //   54: ifnull +15 -> 69
    //   57: aload_2
    //   58: invokevirtual 74	java/io/InputStream:close	()V
    //   61: goto +8 -> 69
    //   64: astore_0
    //   65: aload_0
    //   66: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   69: ldc 37
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: aload_1
    //   75: ifnull +15 -> 90
    //   78: aload_1
    //   79: invokevirtual 74	java/io/InputStream:close	()V
    //   82: goto +8 -> 90
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   90: aload_0
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramContext	Context
    //   3	76	1	localObject	Object
    //   85	2	1	localIOException	java.io.IOException
    //   1	57	2	localContext	Context
    //   22	19	3	str	String
    // Exception table:
    //   from	to	target	type
    //   29	33	35	java/io/IOException
    //   4	14	42	finally
    //   18	23	42	finally
    //   49	53	42	finally
    //   4	14	46	java/lang/Throwable
    //   18	23	46	java/lang/Throwable
    //   57	61	64	java/io/IOException
    //   78	82	85	java/io/IOException
  }
  
  public static MutableLiveData<Boolean> c()
  {
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.config.CameraOperationHelper
 * JD-Core Version:    0.7.0.1
 */