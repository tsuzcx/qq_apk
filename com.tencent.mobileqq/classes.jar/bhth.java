import com.tencent.commonsdk.util.notification.NotificationLimiter;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.qphone.base.util.QLog;

public class bhth
  implements NotificationLimiter
{
  private boolean a(int paramInt)
  {
    return (paramInt == 241) || (paramInt == 244) || (paramInt == 242) || (paramInt == 243);
  }
  
  public boolean shouldNotify(int paramInt)
  {
    if (a(paramInt)) {
      return true;
    }
    boolean bool1;
    if (aijf.a().a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("NotificationLimiterImpl", 2, "MINI PROC FORE");
      }
      bool1 = false;
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (bool1) {
        if (babd.a(paramInt)) {
          break label105;
        }
      }
      label105:
      for (bool2 = true;; bool2 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NotificationLimiterImpl", 2, String.format("studymode_fightNotificationLimiterImpl ,shouldNotify1 = %b,", new Object[] { Boolean.valueOf(bool2) }));
        }
        return bool2;
        if (!MiniChatActivity.a()) {
          break label110;
        }
        if (QLog.isColorLevel()) {
          QLog.i("NotificationLimiterImpl", 2, "MiniMsgActForeGround");
        }
        bool1 = false;
        break;
      }
      label110:
      bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhth
 * JD-Core Version:    0.7.0.1
 */