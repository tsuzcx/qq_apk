import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class azzt
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = a(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousRedPointUtils", 2, String.format("checkToCleanSettingMeRedPointGuide showRedPoint=%s", new Object[] { Boolean.valueOf(bool) }));
    }
    if ((bool) && (paramQQAppInterface != null))
    {
      Object localObject = paramQQAppInterface.getApp();
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      localObject = PreferenceManager.getDefaultSharedPreferences((Context)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("anonymous_setting_me_red_point_guide_" + paramQQAppInterface, false);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  private static boolean a()
  {
    boolean bool = "8.4.8".equals("8.4.10");
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousRedPointUtils", 2, String.format("checkRedPointValidVersion valid=%s", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    String str;
    boolean bool1;
    boolean bool2;
    if ((paramQQAppInterface != null) && (a()))
    {
      BaseApplication localBaseApplication = paramQQAppInterface.getApp();
      str = paramQQAppInterface.getCurrentAccountUin();
      paramQQAppInterface = (azzr)paramQQAppInterface.getManager(QQManagerFactory.ANONYMOUS_ANSWER_MANAGER);
      if (paramQQAppInterface != null)
      {
        bool1 = paramQQAppInterface.a();
        if (bool1)
        {
          bool2 = PreferenceManager.getDefaultSharedPreferences(localBaseApplication).getBoolean("anonymous_setting_me_red_point_guide_" + str, true);
          paramQQAppInterface = str;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AnonymousRedPointUtils", 2, String.format("showSettingMeRedPointGuide uin=%s enable=%s show=%s", new Object[] { paramQQAppInterface, Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      return bool2;
      bool2 = false;
      paramQQAppInterface = str;
      continue;
      bool1 = false;
      break;
      paramQQAppInterface = null;
      bool2 = false;
      bool1 = false;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      Object localObject = paramQQAppInterface.getApp();
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      localObject = PreferenceManager.getDefaultSharedPreferences((Context)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("anonymous_profile_red_point_guide_" + paramQQAppInterface, false);
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel()) {
        QLog.d("AnonymousRedPointUtils", 2, String.format("cleanProfileRedPointGuide uin=%s", new Object[] { paramQQAppInterface }));
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = null;
    boolean bool;
    if ((paramQQAppInterface != null) && (a()))
    {
      localBaseApplication = paramQQAppInterface.getApp();
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      bool = PreferenceManager.getDefaultSharedPreferences(localBaseApplication).getBoolean("anonymous_profile_red_point_guide_" + paramQQAppInterface, true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AnonymousRedPointUtils", 2, String.format("showProfileRedPointGuide uin=%s show=%s", new Object[] { paramQQAppInterface, Boolean.valueOf(bool) }));
      }
      return bool;
      bool = false;
      paramQQAppInterface = localBaseApplication;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azzt
 * JD-Core Version:    0.7.0.1
 */