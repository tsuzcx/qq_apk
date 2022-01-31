import com.tencent.commonsdk.util.notification.NotificationLimiter;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.qphone.base.util.QLog;

public class bfno
  implements NotificationLimiter
{
  private boolean a(int paramInt)
  {
    return (paramInt == 241) || (paramInt == 244) || (paramInt == 242) || (paramInt == 243);
  }
  
  public boolean shouldNotify(int paramInt)
  {
    boolean bool2 = false;
    if (a(paramInt)) {
      return true;
    }
    boolean bool1;
    if (aggn.a().a())
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i("NotificationLimiterImpl", 2, "MINI PROC FORE");
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      if (MiniChatActivity.a())
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.i("NotificationLimiterImpl", 2, "MiniMsgActForeGround");
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfno
 * JD-Core Version:    0.7.0.1
 */