import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class azeo
  extends azem
{
  public boolean a(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    if (paramBaseActivity == null)
    {
      azep.a(this.g, this.f, 100);
      return false;
    }
    Intent localIntent = new Intent(paramBaseActivity, SplashActivity.class);
    if (this.f.equals("contact")) {
      localIntent.putExtra("tab_index", MainFragment.d);
    }
    for (;;)
    {
      localIntent.putExtra("fragment_id", 1);
      localIntent.setFlags(67108864);
      azep.a(this, paramBoolean, localIntent);
      QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant QAssistantConfigItem.Jump item_server = " + this.c + "|" + paramBaseActivity.getClass().toString());
      paramBaseActivity.startActivity(localIntent);
      return true;
      if (this.f.equals("leba")) {
        localIntent.putExtra("tab_index", MainFragment.e);
      } else {
        localIntent.putExtra("tab_index", MainFragment.b);
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    azeu.a("HelloQQWake", "QAssistantConfigMainItem RealJump");
    if (FrameHelperActivity.b())
    {
      azeu.a("HelloQQWake", "QAssistantConfigMainItem isDrawerFrameOpenOrMoving");
      FrameHelperActivity.c(true);
      FrameHelperActivity.t();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azeo
 * JD-Core Version:    0.7.0.1
 */