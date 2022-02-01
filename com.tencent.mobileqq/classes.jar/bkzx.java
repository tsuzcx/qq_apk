import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.util.VipARUtils.3;
import cooperation.vip.ar.util.VipARUtils.4;
import cooperation.vip.ar.util.VipARUtils.5;
import java.io.File;

public class bkzx
{
  private static long jdField_a_of_type_Long;
  private static bkzx jdField_a_of_type_Bkzx;
  private static String jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "vip_tar_engine.jar", "https://d3g.qq.com/sngapp/app/update/20191114160352_6351/vip_tar_engine.jar");
  private static long jdField_b_of_type_Long;
  private static String jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "vip_tar_engine_md5", "3c4cd9ff849e9b6576ffa6d8fe60bcaa");
  private static String c = QzoneConfig.getInstance().getConfig("QZoneSetting", "libTar.so", "https://d3g.qq.com/sngapp/app/update/20191106212848_5780/libTAR.so");
  private static String d = QzoneConfig.getInstance().getConfig("QZoneSetting", "lib_tar_so_md5", "3a0222c4b9d441a4cf4a3ac620f5dfbc");
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  
  public static bkzx a()
  {
    if (jdField_a_of_type_Bkzx == null) {}
    try
    {
      if (jdField_a_of_type_Bkzx == null) {
        jdField_a_of_type_Bkzx = new bkzx();
      }
      return jdField_a_of_type_Bkzx;
    }
    finally {}
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a("vip_ar_gift", paramString1, paramString2, 0);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ThreadManager.executeOnSubThread(new VipARUtils.5(paramString1, paramString2, paramString3, paramInt));
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = true;
    jdField_b_of_type_Long = System.currentTimeMillis();
    QLog.i("VipARPreDownload", 1, " offest = " + (jdField_b_of_type_Long - jdField_a_of_type_Long));
    if (jdField_b_of_type_Long - jdField_a_of_type_Long > paramInt) {}
    for (;;)
    {
      jdField_a_of_type_Long = jdField_b_of_type_Long;
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      String str = Build.MODEL;
      if ((str == null) || (str.length() == 0))
      {
        QZLog.i("VipARUtils", 1, "buildModel is empty");
        return false;
      }
      QZLog.d("VipARUtils", 1, " current device buildModel is '" + str + "'");
      if ((paramString == null) || (paramString.length() == 0)) {
        break label144;
      }
      str = "," + str + ",";
      if (("," + paramString + ",").contains(str))
      {
        QZLog.i("VipARUtils", 1, "device in black list");
        return true;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    return false;
    label144:
    return false;
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    paramString1 = LocalMultiProcConfig.getString(paramString1, null);
    if (TextUtils.isEmpty(paramString1)) {}
    while (!paramString1.equalsIgnoreCase(paramString2)) {
      return true;
    }
    return false;
  }
  
  private void c()
  {
    QZLog.i("VipARUtils", "loadTarEngineJarModule");
    if (c())
    {
      QZLog.i("VipARUtils", 4, new Object[] { "tarEngineJarPath =", QzoneModuleManager.getInstance().getModuleFilePath("vip_tar_engine.jar") });
      this.jdField_a_of_type_Boolean = QzoneModuleManager.getInstance().loadModule("vip_tar_engine.jar", getClass().getClassLoader(), true, true);
      if (this.jdField_a_of_type_Boolean) {
        QZLog.i("VipARUtils", "loadTarEngineJarModule success");
      }
    }
    else
    {
      return;
    }
    QZLog.i("VipARUtils", "loadTarEngineJarModule fail");
  }
  
  private static boolean c()
  {
    String str = QzoneModuleManager.getInstance().getModuleFilePath("vip_tar_engine.jar");
    QZLog.i("VipARUtils", 4, new Object[] { "isTarEngineJarExit path = ", str });
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return new File(str).exists();
  }
  
  private void d()
  {
    QZLog.i("VipARUtils", "loadTarEngineSoModule");
    String str;
    if (d()) {
      str = QzoneModuleManager.getInstance().getModuleFilePath("libTar.so");
    }
    try
    {
      System.load(str);
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_b_of_type_Boolean)
      {
        QZLog.i("VipARUtils", "loadTarEngineSoModule success");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_b_of_type_Boolean = false;
        QZLog.i("VipARUtils", 4, new Object[] { "loadTarEngineSoModule =", str });
      }
      QZLog.i("VipARUtils", "loadTarEngineSoModule fail");
    }
  }
  
  private static boolean d()
  {
    String str = QzoneModuleManager.getInstance().getModuleFilePath("libTar.so");
    QZLog.i("VipARUtils", 4, new Object[] { "isTarEngineSoExit path = ", str });
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return new File(str).exists();
  }
  
  public void a()
  {
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new VipARUtils.3(this));
  }
  
  public void a(blac paramblac)
  {
    if (paramblac == null) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramblac.a(this.jdField_a_of_type_Boolean);
      return;
    }
    if ((b("VipARUtils_JAR_md5", jdField_b_of_type_JavaLangString)) || (!c())) {}
    for (int i = 1; i == 0; i = 0)
    {
      c();
      paramblac.a(this.jdField_a_of_type_Boolean);
      return;
    }
    QzoneModuleManager.getInstance().downloadModule("vip_tar_engine.jar", new bkzy(this, paramblac));
  }
  
  public void b()
  {
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new VipARUtils.4(this));
  }
  
  public void b(blac paramblac)
  {
    if (paramblac == null) {
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      paramblac.a(this.jdField_b_of_type_Boolean);
      return;
    }
    if ((b("VipARUtils_SO_md5", d)) || (!d())) {}
    for (int i = 1; i == 0; i = 0)
    {
      d();
      paramblac.a(this.jdField_b_of_type_Boolean);
      return;
    }
    QzoneModuleManager.getInstance().downloadModule("libTar.so", new bkzz(this, paramblac));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzx
 * JD-Core Version:    0.7.0.1
 */