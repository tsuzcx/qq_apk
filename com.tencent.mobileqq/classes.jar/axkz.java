import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.DarkModeManager.3;
import com.tencent.mobileqq.theme.DarkModeManager.6;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class axkz
{
  private static boolean a;
  private static boolean b;
  
  private static SharedPreferences a()
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = BaseApplicationImpl.getApplication();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((BaseApplicationImpl)localObject3).getRuntime();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((AppRuntime)localObject3).getApplication().getSharedPreferences("DarkModeManagerdark_mode_ui", 4);
        }
      }
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DarkModeManager", 2, "getSharedPreferences error!: ", localThrowable);
    }
    return null;
  }
  
  private static void a()
  {
    if (awnu.b()) {}
    for (String str = "2920";; str = "1103")
    {
      QLog.d("DarkModeManager", 1, "switchToNightMode themeID=" + str);
      ThemeSwitcher.a(str, "202", null);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString, axle paramaxle)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      QLog.e("DarkModeManager", 2, "showThemeDarkModeTips error!: ");
      return;
    }
    paramActivity = babr.a(paramActivity, 0, null, paramActivity.getString(2131653537), paramActivity.getString(2131625035), paramActivity.getString(2131625463), new axlc(paramaxle), new axld(paramaxle));
    paramActivity.show();
    paramActivity.setCancelable(false);
    a("0X800A5C9");
  }
  
  public static void a(axmg paramaxmg)
  {
    if (b()) {
      if ((BaseApplicationImpl.getApplication().getApplicationContext().getResources().getConfiguration().uiMode & 0x30) == 32)
      {
        bool1 = true;
        bool2 = ThemeUtil.isNowThemeIsNight(null, false, null);
        if (QLog.isColorLevel()) {
          QLog.d("DarkModeManager", 2, "updateDarkModeStatus isNightMode  = " + bool2 + ", isDarkMode = " + bool1);
        }
        b(bool1, bool2, paramaxmg);
      }
    }
    while ((!b) || (BaseApplicationImpl.isCurrentVersionFirstLaunch)) {
      for (;;)
      {
        boolean bool2;
        return;
        boolean bool1 = false;
      }
    }
    d();
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "report() called with: key = [" + paramString + "]");
    }
    awqx.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      a("0X800A3E8");
    }
    SharedPreferences localSharedPreferences;
    for (;;)
    {
      a = paramBoolean;
      localSharedPreferences = a();
      if (localSharedPreferences != null) {
        break;
      }
      return;
      a("0X800A3E7");
    }
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "updateModeStatus isOpened  = " + a);
    }
    localSharedPreferences.edit().putBoolean("dark_switch_key", a).apply();
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing()))
    {
      QLog.e("DarkModeManager", 2, "showDarkModeTips error!: ");
      return;
    }
    String str = localBaseActivity.getString(2131653540);
    if (!paramBoolean1) {
      str = localBaseActivity.getString(2131653536);
    }
    paramString1 = babr.a(localBaseActivity, 0, null, str, localBaseActivity.getString(2131625035), localBaseActivity.getString(2131625463), new axla(paramBoolean1, paramBoolean2), new axlb(paramString1, paramString2));
    paramString1.show();
    paramString1.setCancelable(false);
    c();
    a("0X800A5B4");
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 29;
  }
  
  public static boolean a(Activity paramActivity, String paramString, axle paramaxle)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {}
    while (!b()) {
      return false;
    }
    boolean bool2;
    label40:
    boolean bool1;
    if ((paramActivity.getResources().getConfiguration().uiMode & 0x30) == 32)
    {
      bool2 = true;
      bool1 = ThemeUtil.isNowThemeIsNight(null, false, paramString);
      if (TextUtils.isEmpty(paramString))
      {
        if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
          break label136;
        }
        bool1 = true;
      }
      label65:
      if (bool2 == bool1) {
        break label139;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DarkModeManager", 2, "userSetThemeAction isNightMode  = " + bool1 + ", isDarkMode = " + bool2);
      }
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label141;
      }
      a(paramActivity, paramString, paramaxle);
    }
    for (;;)
    {
      return true;
      bool2 = false;
      break label40;
      label136:
      bool1 = false;
      break label65;
      label139:
      break;
      label141:
      ThreadManager.getUIHandler().post(new DarkModeManager.6(paramActivity, paramString, paramaxle));
    }
  }
  
  public static boolean a(String paramString)
  {
    if (b()) {
      if ((BaseApplicationImpl.getApplication().getApplicationContext().getResources().getConfiguration().uiMode & 0x30) != 32) {
        break label85;
      }
    }
    label85:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = ThemeUtil.isNowThemeIsNight(null, false, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("DarkModeManager", 2, "updateDarkModeStatus isNightMode  = " + bool2 + ", isDarkMode = " + bool1);
      }
      if (bool1 != bool2) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (a())
    {
      localBaseActivity = BaseActivity.sTopActivity;
      if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {}
    }
    while (!QLog.isColorLevel())
    {
      boolean bool1;
      boolean bool2;
      do
      {
        do
        {
          BaseActivity localBaseActivity;
          return false;
          if ((localBaseActivity.getResources().getConfiguration().uiMode & 0x30) != 32) {
            break;
          }
          bool1 = true;
          bool2 = ThemeUtil.isNowThemeIsNight(null, false, null);
          if (QLog.isColorLevel()) {
            QLog.d("DarkModeManager", 2, "afterDownloadRoamTheme isNightMode  = " + bool2 + ", isDarkMode = " + bool1 + ", isCurrentVersionFirstLaunch = " + BaseApplicationImpl.isCurrentVersionFirstLaunch);
          }
        } while (bool1 == bool2);
        if ((!d()) && (ambz.e()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("DarkModeManager", 2, "afterDownloadRoamTheme dialog will show!");
          }
          if (Looper.getMainLooper() == Looper.myLooper()) {
            a(bool1, bool2, paramString1, paramString2);
          }
          for (;;)
          {
            return true;
            bool1 = false;
            break;
            ThreadManager.getUIHandler().post(new DarkModeManager.3(bool1, bool2, paramString1, paramString2));
          }
        }
      } while (!b());
      b(bool1, bool2, null);
      if (QLog.isColorLevel()) {
        QLog.d("DarkModeManager", 2, "afterDownloadRoamTheme iscalled! switch is opened, so switch theme!");
      }
      return true;
    }
    QLog.d("DarkModeManager", 2, "afterDownloadRoamTheme iscalled! the system version is lower 29! so do not dialog!");
    return false;
  }
  
  @Nullable
  private static QQAppInterface b()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
  }
  
  private static void b()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null)
    {
      a = localSharedPreferences.getBoolean("dark_switch_key", false);
      return;
    }
    a = true;
  }
  
  private static void b(axmg paramaxmg)
  {
    Object localObject;
    if (awnu.b())
    {
      int i = awnu.d();
      localObject = awnp.b[i];
    }
    for (;;)
    {
      QLog.d("DarkModeManager", 1, "closedNightMode is called, will set themeID=" + (String)localObject);
      ThemeSwitcher.a((String)localObject, "202", paramaxmg);
      return;
      localObject = axmf.a(b());
      String str = ((Bundle)localObject).getString("themeID");
      QLog.d("DarkModeManager", 1, "closedNightMode, pre themeID=" + str + ",version=" + ((Bundle)localObject).getString("version"));
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "1000";
      }
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  private static void b(boolean paramBoolean1, boolean paramBoolean2, axmg paramaxmg)
  {
    if ((paramBoolean1) && (!paramBoolean2)) {
      a();
    }
    while ((paramBoolean1) || (!paramBoolean2)) {
      return;
    }
    b(paramaxmg);
  }
  
  public static boolean b()
  {
    return (a()) && (c());
  }
  
  private static void c()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "setShownPromtFlag is called!");
    }
    localSharedPreferences.edit().putBoolean("dialog_has_shown_key", true).apply();
  }
  
  public static boolean c()
  {
    
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "getDarkModeSwitch isOpened  = " + a);
    }
    return a;
  }
  
  private static void d()
  {
    a("1000", "204");
  }
  
  private static boolean d()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("dialog_has_shown_key", false);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axkz
 * JD-Core Version:    0.7.0.1
 */