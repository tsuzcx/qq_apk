import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.agent.TroopAbilityUtils.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class bjpo
{
  public static void a(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    Object localObject = new StringBuilder().append("onThirdAppJoinAppFinished activity is null: ");
    boolean bool;
    if (paramActivity == null)
    {
      bool = true;
      QLog.i("TroopAbility.Utils", 1, bool);
      if ((paramActivity != null) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
        break label59;
      }
    }
    label186:
    for (;;)
    {
      return;
      bool = false;
      break;
      label59:
      paramIntent = paramIntent.getExtras();
      if (paramIntent.getBoolean("fromThirdAppByOpenSDK"))
      {
        String str1 = paramIntent.getString("appid");
        paramIntent.getString("app_name");
        String str2 = paramIntent.getString("pkg_name");
        int i = paramIntent.getInt("action");
        if (i == 1)
        {
          paramIntent = "bindGroup";
          localObject = anzj.a(2131713909);
        }
        for (;;)
        {
          if (paramActivity.isFinishing()) {
            break label186;
          }
          ThreadManager.getUIHandler().postDelayed(new TroopAbilityUtils.1(paramActivity, paramBoolean, str1, paramIntent, str2, (String)localObject), 300L);
          return;
          if (i == 2)
          {
            paramIntent = "bindGroup";
            localObject = anzj.a(2131713910);
          }
          else
          {
            if (i != 3) {
              break;
            }
            paramIntent = "joinGroup";
            localObject = anzj.a(2131713921);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjpo
 * JD-Core Version:    0.7.0.1
 */