import com.tencent.commonsdk.util.notification.NotificationLimiter;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.qphone.base.util.QLog;

public class befu
  implements NotificationLimiter
{
  public boolean shouldNotify()
  {
    if (afun.a().a()) {
      if (QLog.isColorLevel()) {
        QLog.i("NotificationLimiterImpl", 2, "MINI PROC FORE");
      }
    }
    do
    {
      return false;
      if (!MiniChatActivity.a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("NotificationLimiterImpl", 2, "MiniMsgActForeGround");
    return false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     befu
 * JD-Core Version:    0.7.0.1
 */