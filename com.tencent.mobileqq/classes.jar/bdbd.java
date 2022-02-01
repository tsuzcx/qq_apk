import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class bdbd
{
  Handler jdField_a_of_type_AndroidOsHandler = new bdbf(this, Looper.getMainLooper());
  bdbm jdField_a_of_type_Bdbm;
  bdbp jdField_a_of_type_Bdbp = new bdbe(this);
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<bdbg> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public bdbd(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_Bdbm = ((bdbm)paramAppRuntime.getManager(185));
  }
  
  public int a()
  {
    int i = 2;
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("NightModeLogic", 2, "switchRightViewImage status: juhua");
      }
      i = 0;
    }
    do
    {
      return i;
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime))
      {
        if (QLog.isColorLevel()) {
          QLog.i("NightModeLogic", 2, "switchRightViewImage status: sun");
        }
        return 1;
      }
    } while (!QLog.isColorLevel());
    QLog.i("NightModeLogic", 2, "switchRightViewImage status: moon");
    return 2;
  }
  
  public void a()
  {
    this.jdField_a_of_type_MqqAppAppRuntime = null;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bdbg localbdbg = (bdbg)localIterator.next();
      if (1 == paramInt) {
        localbdbg.b(paramBundle);
      } else if (-2 == paramInt) {
        localbdbg.a(paramBundle);
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      QLog.e("NightModeLogic", 1, "startNightMode Err mRuntime == null");
    }
    boolean bool;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NightModeLogic", 2, "startNightMode, isNightMode=" + ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime) + ", nowThemeId=" + ThemeUtil.getCurrentThemeId() + ", userThemeId=" + ThemeUtil.getUserCurrentThemeId(this.jdField_a_of_type_MqqAppAppRuntime) + ", mRuntime=" + this.jdField_a_of_type_MqqAppAppRuntime);
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      bool = b();
    } while (!QLog.isColorLevel());
    QLog.i("NightModeLogic", 2, "startNightMode result=" + bool);
  }
  
  public void a(bdbg parambdbg, boolean paramBoolean)
  {
    if (parambdbg != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambdbg);
      if (paramBoolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(parambdbg);
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  public boolean a()
  {
    boolean bool = ThemeSwitcher.a();
    QLog.e("NightModeLogic", 1, "isDownloadOrSwtich: " + bool);
    return bool;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bdbm.c();
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)) {
      ((bbyj)((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getBusinessHandler(154)).c();
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NightModeLogic", 2, "setupNightTheme");
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime == null)
    {
      QLog.e("NightModeLogic", 1, "setupNightTheme Err mRuntime == null");
      return false;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("start_status", 1);
    a(1, (Bundle)localObject);
    boolean bool1 = ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_MqqAppAppRuntime, false, null);
    boolean bool2 = bbyp.b();
    if (!bool1) {
      if (bool2)
      {
        localObject = "2920";
        bcef.b((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 0, 0, "1", "", "", "");
        VasWebviewUtil.reportVasStatus("Setting_tab", "Night_mode", "0", 0, 0);
      }
    }
    for (;;)
    {
      QLog.d("NightModeLogic", 1, "setupNightTheme themeID=" + (String)localObject);
      ThemeSwitcher.a((String)localObject, "202", this.jdField_a_of_type_Bdbp);
      return true;
      localObject = "1103";
      break;
      if (!bool2) {
        break label176;
      }
      localObject = bbyp.a(bbyp.d());
    }
    label176:
    Bundle localBundle = bdbo.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    localObject = localBundle.getString("themeID");
    QLog.d("NightModeLogic", 1, "setupNightTheme, pre themeID=" + (String)localObject + ",version=" + localBundle.getString("version"));
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      bcef.b((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 0, 0, "0", "", "", "");
      break;
      localObject = "1000";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbd
 * JD-Core Version:    0.7.0.1
 */