import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aoer
  extends BroadcastReceiver
{
  public aoer(QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.l) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.broadcast", 2, "qqHeadBroadcastReceiver onReceive, app isReleased");
      }
    }
    while ((paramIntent == null) || (!"com.tencent.qqhead.getheadreq".equals(paramIntent.getAction()))) {
      return;
    }
    QQAppInterface.a(this.a, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoer
 * JD-Core Version:    0.7.0.1
 */