import android.content.SharedPreferences;
import android.text.TextUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QzoneHardwareRestriction;
import java.io.File;

public class bgex
{
  public static final String a;
  public static final boolean a;
  public static final String b;
  private static boolean b;
  private static boolean c;
  private static boolean d;
  
  static
  {
    boolean bool = true;
    jdField_a_of_type_JavaLangString = bgex.class.getSimpleName();
    jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "animatedWebpMD5", "4c8590a921c2722051416111dfd57122");
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "ENABLE_ANIMATED_WEBP", 1) == 1) {}
    for (;;)
    {
      jdField_a_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  public static boolean a()
  {
    if (!c) {
      if ((!jdField_a_of_type_Boolean) || (jdField_b_of_type_Boolean) || (!QzoneHardwareRestriction.meetHardwareRestriction(2, 1))) {
        break label40;
      }
    }
    label40:
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      c = true;
      return d;
    }
  }
  
  public static boolean b()
  {
    if (!a())
    {
      QZLog.i(jdField_a_of_type_JavaLangString, "enable animtedWebp false");
      return false;
    }
    if ((!e()) && (c())) {
      return d();
    }
    QzoneModuleManager.getInstance().downloadModule("animatedWebp.so", new bgey());
    return false;
  }
  
  public static boolean c()
  {
    String str = QzoneModuleManager.getInstance().getModuleFilePath("animatedWebp.so");
    if (TextUtils.isEmpty(str))
    {
      QZLog.i(jdField_a_of_type_JavaLangString, "isWebp SO path not exit");
      return false;
    }
    boolean bool = new File(str).exists();
    QZLog.i(jdField_a_of_type_JavaLangString, "isWebp SO path exit : " + bool);
    return bool;
  }
  
  private static boolean d()
  {
    try
    {
      String str = QzoneModuleManager.getInstance().getModuleFilePath("animatedWebp.so");
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      System.load(str);
      return true;
    }
    catch (Throwable localThrowable)
    {
      jdField_b_of_type_Boolean = true;
      QZLog.e(jdField_a_of_type_JavaLangString, "load webp so fail", localThrowable);
    }
    return false;
  }
  
  private static boolean e()
  {
    String str = bcgc.a().getString("PREFERENCE_SO_MD5_KEY", null);
    if (TextUtils.isEmpty(str)) {}
    while (!str.equalsIgnoreCase(jdField_b_of_type_JavaLangString)) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgex
 * JD-Core Version:    0.7.0.1
 */