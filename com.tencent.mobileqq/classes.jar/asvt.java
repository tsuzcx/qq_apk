import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;

public class asvt
  extends BroadcastReceiver
{
  public asvt(QQPlayerService paramQQPlayerService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QQPlayerService.c(this.a)) {
      if (QLog.isColorLevel()) {
        QLog.i("QQPlayerService", 2, "received broadcast after service destroy");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "QQPlayerBroadcastReceiverReceiver onReceive,action:" + paramIntent.getAction());
      }
    } while ((!"com.tencent.mobileqq.intent.logout".equals(paramIntent.getAction())) && (!"qqplayer_exit_action".equals(paramIntent.getAction())));
    if ((paramIntent.getBooleanExtra("musicplayer.isDelFileOnDonwloadThreadOver", false)) && (this.a.a != null)) {
      this.a.a.b = true;
    }
    QQPlayerService.c(this.a.getApplicationContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asvt
 * JD-Core Version:    0.7.0.1
 */