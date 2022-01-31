import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.io.File;

public class awlw
{
  private static awlx jdField_a_of_type_Awlx;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static final String jdField_a_of_type_JavaLangString = Environment.getDataDirectory() + "/data/" + "com.tencent.mobileqq" + "/app_lib/qq_filter/";
  private static boolean jdField_a_of_type_Boolean;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "qq.android.native.short.video.filter.const", "qq.android.native.short.video.filter.const.v1", "qq.android.native.short.video.filter.const.v2", "qq.android.native.short.video.filter.const.v3", "qq.android.native.short.video.filter.const.v4", "qq.android.native.short.video.filter.const.v665", "qq.android.native.short.video.filter.const.v700" };
  private static final String jdField_b_of_type_JavaLangString;
  private static boolean jdField_b_of_type_Boolean;
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "qq.android.native.short.video.filter.var", "qq.android.native.short.video.filter.var.v1", "qq.android.native.short.video.filter.var.v2", "qq.android.native.short.video.filter.var.v3", "qq.android.native.short.video.filter.var.v665" };
  private static boolean jdField_c_of_type_Boolean;
  private static final String[] jdField_c_of_type_ArrayOfJavaLangString = { "qq.android.native.short.video.x86", "qq.android.native.short.video", "qq.android.native.short.video.v658", "qq.android.native.short.video.v660", "qq.android.native.short.video.v665", "qq.android.native.short.video.v670", "qq.android.native.short.video.v700" };
  private static boolean d;
  private static boolean e;
  private static boolean f;
  
  static
  {
    bedt.a();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_Awlx = new awlx();
    jdField_b_of_type_JavaLangString = ajed.aU + "early";
  }
  
  public static int a()
  {
    int i;
    if (f()) {
      if (b(BaseApplicationImpl.getContext())) {
        i = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterSoLoad", 2, "getQmcfSoState:" + i);
      }
      return i;
      i = 2;
      continue;
      i = 0;
    }
  }
  
  public static int a(Context paramContext)
  {
    int i;
    if (c()) {
      if (a(paramContext)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterSoLoad", 2, "getFilterSoState " + i);
      }
      return i;
      i = 2;
      continue;
      i = 0;
    }
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return jdField_a_of_type_JavaLangString;
    }
    paramContext = paramContext.getFilesDir();
    if (paramContext != null) {
      return paramContext.getParent() + "/app_lib/qq_filter/";
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String a(Context paramContext, int[] paramArrayOfInt)
  {
    paramArrayOfInt = awdu.a();
    if (paramArrayOfInt.equals("Pendant000_0"))
    {
      VideoEnvironment.a("PtvFilterSoLoad", "getSVFilterSoPath:pathVersion=Pendant000_0", null);
      return null;
    }
    return a(paramContext) + paramArrayOfInt + File.separator;
  }
  
  public static void a()
  {
    int k = 0;
    Object localObject = new File(jdField_b_of_type_JavaLangString);
    if (!((File)localObject).exists()) {}
    for (;;)
    {
      return;
      localObject = ((File)localObject).getAbsolutePath() + File.separator;
      int i = 0;
      File localFile;
      while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        localFile = new File((String)localObject + jdField_a_of_type_ArrayOfJavaLangString[i]);
        if (localFile.exists()) {
          localFile.delete();
        }
        i += 1;
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= jdField_b_of_type_ArrayOfJavaLangString.length) {
          break;
        }
        localFile = new File((String)localObject + jdField_b_of_type_ArrayOfJavaLangString[i]);
        if (localFile.exists()) {
          localFile.delete();
        }
        i += 1;
      }
      while (j < jdField_c_of_type_ArrayOfJavaLangString.length)
      {
        localFile = new File((String)localObject + jdField_c_of_type_ArrayOfJavaLangString[j]);
        if (localFile.exists()) {
          localFile.delete();
        }
        j += 1;
      }
    }
  }
  
  public static boolean a()
  {
    try
    {
      if (!FeatureManager.isBasicFeaturesFunctionReady())
      {
        bgxr.a();
        bool = FeatureManager.loadBasicFeatures();
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterSoLoad", 2, "SoLoader.loadSvFilterSo success:" + bool);
        }
      }
      boolean bool = FeatureManager.isBasicFeaturesFunctionReady();
      return bool;
    }
    finally {}
  }
  
  public static boolean a(Context paramContext)
  {
    return awly.a(paramContext);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    try
    {
      boolean bool = a(paramQQAppInterface, paramContext, null);
      return bool;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  /* Error */
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, awgj paramawgj)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: invokestatic 146	awlw:c	()Z
    //   9: istore 5
    //   11: iload 5
    //   13: ifeq +72 -> 85
    //   16: invokestatic 226	awgh:a	()Lawgh;
    //   19: iconst_0
    //   20: aload_2
    //   21: invokevirtual 229	awgh:b	(ILawgj;)V
    //   24: aload_0
    //   25: invokestatic 234	awez:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   28: pop
    //   29: aload_1
    //   30: invokestatic 148	awlw:a	(Landroid/content/Context;)Z
    //   33: istore_3
    //   34: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +43 -> 80
    //   40: ldc 135
    //   42: iconst_2
    //   43: new 19	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   50: ldc 236
    //   52: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: iload_3
    //   56: invokevirtual 214	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   59: ldc 238
    //   61: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: iload 5
    //   66: invokevirtual 214	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   69: ldc 240
    //   71: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 243	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: ldc 2
    //   82: monitorexit
    //   83: iload_3
    //   84: ireturn
    //   85: iload 4
    //   87: istore_3
    //   88: aload_2
    //   89: ifnull -55 -> 34
    //   92: aload_2
    //   93: iconst_0
    //   94: iconst_0
    //   95: iconst_m1
    //   96: invokeinterface 248 4 0
    //   101: iload 4
    //   103: istore_3
    //   104: goto -70 -> 34
    //   107: astore_0
    //   108: ldc 2
    //   110: monitorexit
    //   111: aload_0
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	paramQQAppInterface	QQAppInterface
    //   0	113	1	paramContext	Context
    //   0	113	2	paramawgj	awgj
    //   33	71	3	bool1	boolean
    //   1	101	4	bool2	boolean
    //   9	56	5	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   6	11	107	finally
    //   16	34	107	finally
    //   34	80	107	finally
    //   92	101	107	finally
  }
  
  public static boolean a(String paramString)
  {
    return awly.a(paramString);
  }
  
  public static String b(Context paramContext)
  {
    return awdu.a(paramContext);
  }
  
  public static void b()
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      ThreadManager.post(new PtvFilterSoLoad.1(), 5, null, false);
    }
  }
  
  public static boolean b()
  {
    return FeatureManager.Features.FACE_DETECT.isAllSoVersionOk();
  }
  
  public static boolean b(Context paramContext)
  {
    return awly.b(paramContext);
  }
  
  public static String c(Context paramContext)
  {
    int[] arrayOfInt = new int[1];
    String str = a(paramContext, arrayOfInt);
    if (str != null) {}
    for (paramContext = str;; paramContext = "null")
    {
      VideoEnvironment.a("PtvFilterSoLoad", "getSVFilterSoPath:errCode=" + arrayOfInt[0] + ",pathLog=" + paramContext, null);
      return str;
    }
  }
  
  public static boolean c()
  {
    int i;
    if ((awii.e(awii.w)) || (awii.b()))
    {
      i = 1;
      if (i == 0) {
        break label28;
      }
    }
    for (;;)
    {
      return false;
      i = 0;
      break;
      label28:
      boolean bool = lbk.e();
      try
      {
        Class localClass = Class.forName("android.opengl.EGL14");
        if ((!bool) || (localClass == null) || (Build.VERSION.SDK_INT < 17)) {
          continue;
        }
        return true;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
  }
  
  public static String d(Context paramContext)
  {
    paramContext = awed.a();
    if (paramContext.equals("artfilter000_0"))
    {
      VideoEnvironment.a("PtvFilterSoLoad", "getValidArtFilterPath:pathVersion=artfilter000_0", null);
      return null;
    }
    return awed.b() + paramContext + File.separator;
  }
  
  public static boolean d()
  {
    return awdu.a();
  }
  
  public static String e(Context paramContext)
  {
    paramContext = awfn.a();
    if (paramContext.equals("Tracking000_0"))
    {
      VideoEnvironment.a("PtvFilterSoLoad", "getTrackingBasePath:pathVersion=Tracking000_0", null);
      return null;
    }
    return awfn.b() + paramContext + File.separator;
  }
  
  public static boolean e()
  {
    boolean bool1 = awly.a();
    boolean bool2 = VideoEnvironment.e();
    return (bool1) && (bool2);
  }
  
  public static boolean f()
  {
    if (Build.VERSION.SDK_INT < 21) {}
    while (!QmcfManager.getInstance().isQmcfSupported()) {
      return false;
    }
    return true;
  }
  
  public static boolean g()
  {
    boolean bool4 = false;
    if (jdField_b_of_type_Boolean) {
      return d;
    }
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 21)
    {
      bool1 = true;
      if (aweq.b()) {
        break label126;
      }
    }
    label126:
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool5 = awll.i();
      boolean bool3 = bool4;
      if (bool1)
      {
        bool3 = bool4;
        if (bool2)
        {
          bool3 = bool4;
          if (bool5) {
            bool3 = true;
          }
        }
      }
      d = bool3;
      jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("PtvFilterSoLoad", 2, "isSupportPortarit sdkSupport:" + bool1 + ", whiteList:" + bool2 + ", switchOpen:" + bool5);
      }
      return d;
      bool1 = false;
      break;
    }
  }
  
  public static boolean h()
  {
    boolean bool3 = false;
    if (jdField_c_of_type_Boolean) {
      return e;
    }
    boolean bool4 = awll.k();
    if (!awii.d()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool5 = j();
      boolean bool2 = bool3;
      if (bool4)
      {
        bool2 = bool3;
        if (bool1)
        {
          bool2 = bool3;
          if (bool5) {
            bool2 = true;
          }
        }
      }
      e = bool2;
      jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("PtvFilterSoLoad", 2, "isSupportARParticle switchOpen:" + bool4 + ", notInBlackList:" + bool1 + ", hasGyroscope:" + bool5 + ", isSupportARParticle:" + e);
      }
      return e;
    }
  }
  
  public static boolean i()
  {
    f = true;
    return f;
  }
  
  private static boolean j()
  {
    return BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.gyroscope");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awlw
 * JD-Core Version:    0.7.0.1
 */