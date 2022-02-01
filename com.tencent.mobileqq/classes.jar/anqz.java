import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;

public class anqz
  extends BroadcastReceiver
{
  private anqz(BaseActivity2 paramBaseActivity2) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
    {
      BaseActivity2.mAppForground = false;
      GesturePWDUtils.setAppForground(paramContext, BaseActivity2.mAppForground);
    }
    while (!paramIntent.getAction().equals("android.intent.action.SCREEN_ON")) {
      return;
    }
    BaseActivity2.mAppForground = GesturePWDUtils.isAppOnForegroundByTasks(paramContext);
    GesturePWDUtils.setAppForground(paramContext, BaseActivity2.mAppForground);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anqz
 * JD-Core Version:    0.7.0.1
 */