import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class amon
  extends anav
{
  public void a()
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = BaseApplicationImpl.sApplication;
    boolean bool1;
    if (i > 10)
    {
      i = 4;
      localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("screen_shot", i).getString("currentactivity", null);
      if ((BaseActivity2.topActivity != null) && (BaseActivity2.topActivity.getClass().getName().equals(localObject)))
      {
        bool1 = SettingCloneUtil.readValue(BaseApplicationImpl.sApplication, null, BaseApplicationImpl.sApplication.getString(2131694546), "qqsetting_screenshot_key", false);
        boolean bool2 = bfrw.a(BaseApplication.getContext());
        if ((bool1) && (bool2))
        {
          if (BaseActivity2.topActivity.screenShot == null)
          {
            if (!BaseActivity2.topActivity.isPause) {
              break label164;
            }
            localObject = BaseActivity2.topActivity.getApplicationContext();
            label118:
            BaseActivity2.topActivity.screenShot = new ScreenShot((Context)localObject, BaseActivity2.topActivity.getWindow());
          }
          bool1 = BaseActivity2.topActivity.screenShot.b();
          if (!bool1) {
            break label172;
          }
          ScreenShot.a("BaseActivity2 is showing");
        }
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label164:
      localObject = BaseActivity2.topActivity;
      break label118;
      label172:
      if (!BaseActivity2.topActivity.screenShot.c()) {
        BaseActivity2.access$000(BaseActivity2.topActivity);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("BaseActivity", 2, "snapshot activate " + bool1);
        return;
        if ((!bgbw.g) && (Build.VERSION.SDK_INT < 11)) {
          bgbt.a().a(BaseActivity2.topActivity.getWindow());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amon
 * JD-Core Version:    0.7.0.1
 */