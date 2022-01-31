import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
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

public class axlc
{
  private static axld jdField_a_of_type_Axld = new axld();
  private static final Object jdField_a_of_type_JavaLangObject;
  private static final String jdField_a_of_type_JavaLangString = ajsf.aW + "early";
  private static boolean jdField_a_of_type_Boolean;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "qq.android.native.short.video.filter.const", "qq.android.native.short.video.filter.const.v1", "qq.android.native.short.video.filter.const.v2", "qq.android.native.short.video.filter.const.v3", "qq.android.native.short.video.filter.const.v4", "qq.android.native.short.video.filter.const.v665", "qq.android.native.short.video.filter.const.v700" };
  private static boolean jdField_b_of_type_Boolean;
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "qq.android.native.short.video.filter.var", "qq.android.native.short.video.filter.var.v1", "qq.android.native.short.video.filter.var.v2", "qq.android.native.short.video.filter.var.v3", "qq.android.native.short.video.filter.var.v665" };
  private static boolean jdField_c_of_type_Boolean;
  private static final String[] jdField_c_of_type_ArrayOfJavaLangString = { "qq.android.native.short.video.x86", "qq.android.native.short.video", "qq.android.native.short.video.v658", "qq.android.native.short.video.v660", "qq.android.native.short.video.v665", "qq.android.native.short.video.v670", "qq.android.native.short.video.v700" };
  private static boolean d;
  private static boolean e;
  private static boolean f;
  
  static
  {
    bflj.a();
    jdField_a_of_type_JavaLangObject = new Object();
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
    return biie.jdField_a_of_type_JavaLangString;
  }
  
  public static String a(Context paramContext, int[] paramArrayOfInt)
  {
    paramArrayOfInt = axdc.a();
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
    Object localObject = new File(jdField_a_of_type_JavaLangString);
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
        biht.a();
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
    return axle.a(paramContext);
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
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, birb parambirb)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: invokestatic 129	axlc:c	()Z
    //   9: istore 5
    //   11: iload 5
    //   13: ifeq +64 -> 77
    //   16: aload_0
    //   17: invokestatic 204	axeh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   20: pop
    //   21: aload_1
    //   22: invokestatic 131	axlc:a	(Landroid/content/Context;)Z
    //   25: istore_3
    //   26: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +43 -> 72
    //   32: ldc 118
    //   34: iconst_2
    //   35: new 33	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   42: ldc 206
    //   44: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload_3
    //   48: invokevirtual 192	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: ldc 208
    //   53: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload 5
    //   58: invokevirtual 192	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   61: ldc 210
    //   63: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 213	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: ldc 2
    //   74: monitorexit
    //   75: iload_3
    //   76: ireturn
    //   77: iload 4
    //   79: istore_3
    //   80: aload_2
    //   81: ifnull -55 -> 26
    //   84: aload_2
    //   85: iconst_0
    //   86: iconst_0
    //   87: iconst_m1
    //   88: invokeinterface 218 4 0
    //   93: iload 4
    //   95: istore_3
    //   96: goto -70 -> 26
    //   99: astore_0
    //   100: ldc 2
    //   102: monitorexit
    //   103: aload_0
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramQQAppInterface	QQAppInterface
    //   0	105	1	paramContext	Context
    //   0	105	2	parambirb	birb
    //   25	71	3	bool1	boolean
    //   1	93	4	bool2	boolean
    //   9	48	5	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   6	11	99	finally
    //   16	26	99	finally
    //   26	72	99	finally
    //   84	93	99	finally
  }
  
  public static boolean a(String paramString)
  {
    return axle.a(paramString);
  }
  
  public static String b(Context paramContext)
  {
    return biie.b;
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
    return axle.b(paramContext);
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
    if ((axho.e(axho.w)) || (axho.b()))
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
      boolean bool = lmb.e();
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
    paramContext = axdl.a();
    if (paramContext.equals("artfilter000_0"))
    {
      VideoEnvironment.a("PtvFilterSoLoad", "getValidArtFilterPath:pathVersion=artfilter000_0", null);
      return null;
    }
    return axdl.b() + paramContext + File.separator;
  }
  
  public static boolean d()
  {
    return axdc.a();
  }
  
  public static String e(Context paramContext)
  {
    paramContext = axev.a();
    if (paramContext.equals("Tracking000_0"))
    {
      VideoEnvironment.a("PtvFilterSoLoad", "getTrackingBasePath:pathVersion=Tracking000_0", null);
      return null;
    }
    return axev.b() + paramContext + File.separator;
  }
  
  public static boolean e()
  {
    boolean bool1 = axle.a();
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
      if (axdy.b()) {
        break label126;
      }
    }
    label126:
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool5 = axkr.i();
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
    boolean bool4 = axkr.k();
    if (!axho.d()) {}
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
 * Qualified Name:     axlc
 * JD-Core Version:    0.7.0.1
 */