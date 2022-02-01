import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class beid
{
  Handler jdField_a_of_type_AndroidOsHandler = new beif(this, Looper.getMainLooper());
  beim jdField_a_of_type_Beim;
  beip jdField_a_of_type_Beip = new beie(this);
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<beig> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public beid(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_Beim = ((beim)paramAppRuntime.getManager(QQManagerFactory.THEME_MANAGER));
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
      beig localbeig = (beig)localIterator.next();
      if (1 == paramInt) {
        localbeig.b(paramBundle);
      } else if (-2 == paramInt) {
        localbeig.a(paramBundle);
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
  
  public void a(beig parambeig, boolean paramBoolean)
  {
    if (parambeig != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambeig);
      if (paramBoolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(parambeig);
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
    this.jdField_a_of_type_Beim.c();
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)) {
      ((bdfe)((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).c();
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
    boolean bool2 = bdfk.b();
    if (!bool1) {
      if (bool2)
      {
        localObject = "2920";
        bdla.b((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 0, 0, "1", "", "", "");
        VasWebviewUtil.reportVasStatus("Setting_tab", "Night_mode", "0", 0, 0);
      }
    }
    for (;;)
    {
      QLog.d("NightModeLogic", 1, "setupNightTheme themeID=" + (String)localObject);
      ThemeSwitcher.a((String)localObject, "202", this.jdField_a_of_type_Beip);
      return true;
      localObject = "1103";
      break;
      if (!bool2) {
        break label176;
      }
      localObject = bdfk.a(bdfk.d());
    }
    label176:
    Bundle localBundle = beio.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    localObject = localBundle.getString("themeID");
    QLog.d("NightModeLogic", 1, "setupNightTheme, pre themeID=" + (String)localObject + ",version=" + localBundle.getString("version"));
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      bdla.b((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 0, 0, "0", "", "", "");
      break;
      localObject = "1000";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beid
 * JD-Core Version:    0.7.0.1
 */