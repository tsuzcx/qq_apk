import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.qphone.base.util.QLog;

public class auxs
  extends BroadcastReceiver
{
  private auxs(JefsClass paramJefsClass) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!BaseApplicationImpl.processName.equals(paramIntent.getStringExtra("key_process_id"))) {
      if (QLog.isColorLevel()) {
        QLog.d("TeleScreen|JefsClass", 2, "is not current process");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TeleScreen|JefsClass", 2, "start");
      }
      if ("com.tencent.mobileqq.telescreen.action_run".equals(paramIntent.getAction()))
      {
        JefsClass.a(this.a, paramIntent.getIntExtra("key_id", 0), paramIntent.getIntExtra("key_callback_id", 0));
        return;
      }
    } while (!"com.tencent.mobileqq.telescreen.action_remove".equals(paramIntent.getAction()));
    JefsClass.b(this.a, paramIntent.getIntExtra("key_id", 0), paramIntent.getIntExtra("key_callback_id", 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxs
 * JD-Core Version:    0.7.0.1
 */