import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class azcu
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = null;
    if (paramIntent != null) {
      paramContext = paramIntent.getAction();
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] ScreenBroadcastReceiver ACTION_SCREEN_OFF");
      }
      paramContext = (azbv)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.ONLINE_STATUS_MANAGER);
      if (paramContext != null) {
        paramContext.a().d("screenOff");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azcu
 * JD-Core Version:    0.7.0.1
 */