import android.content.Intent;
import com.tencent.commonsdk.util.notification.NotificationReportController;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.QLog;

public class awzy
{
  static NotificationReportController a;
  
  public static int a(String paramString, int paramInt, Intent paramIntent)
  {
    int j = 0;
    int i = -1;
    if (paramIntent != null) {}
    for (boolean bool = paramIntent.getBooleanExtra("key_notifycation_oneway_message", false);; bool = false)
    {
      if (paramInt == 1008) {
        i = 267;
      }
      for (;;)
      {
        if (QLog.isDevelopLevel())
        {
          paramString = new StringBuilder().append("getNotifyID: ").append(i).append(", for uin: ").append(paramString).append(" and type: ").append(paramInt).append("  intent: ");
          paramInt = j;
          if (paramIntent != null) {
            paramInt = 1;
          }
          QLog.d("MsgPushReportHelper", 4, paramInt);
        }
        return i;
        if ((bool) && (paramInt == 1010)) {
          i = 272;
        } else if (((bool) && (paramInt == 1001)) || (paramInt == 10002)) {
          i = 268;
        } else if ((paramIntent != null) && (paramIntent.getBooleanExtra("qav_notify_flag", false))) {
          i = 236;
        } else if (paramInt == 3001) {
          i = 271;
        } else if ((paramInt == 1037) || (paramInt == 1044) || (paramInt == 1045)) {
          i = 266;
        } else if ((paramIntent != null) && (paramIntent.getBooleanExtra("activepull_push_flag", false))) {
          i = 269;
        } else if (paramInt == 1030)
        {
          if (paramIntent != null) {
            i = paramIntent.getIntExtra("campus_notice_id", 0);
          }
        }
        else if ((paramInt == 1035) || (paramInt == 1041) || (paramInt == 1042))
        {
          if (paramIntent != null) {
            i = paramIntent.getIntExtra("param_notifyid", 0);
          }
        }
        else if (paramInt == 1012) {
          i = 240;
        } else if (paramInt == 7225) {
          i = 526;
        } else if (paramInt == 10007) {
          i = 527;
        } else {
          i = 265;
        }
      }
    }
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    if (a != null) {
      a.report(3, paramInt1, paramString, paramInt2);
    }
  }
  
  public static void a(Intent paramIntent)
  {
    if (paramIntent != null) {}
    try
    {
      int i = paramIntent.getIntExtra("param_notifyid", 0);
      String str = paramIntent.getStringExtra("param_fromuin");
      int j = paramIntent.getIntExtra("param_uinType", 0);
      paramIntent.removeExtra("param_notifyid");
      paramIntent.removeExtra("param_fromuin");
      paramIntent.removeExtra("param_uinType");
      if ((QQNotificationManager.getInstance().isIdValid("MsgPushReportHelper", i)) && (a != null)) {
        a.report(2, i, str, j);
      }
      return;
    }
    catch (Throwable paramIntent)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MsgPushReportHelper", 2, paramIntent, new Object[0]);
    }
  }
  
  public static void a(NotificationReportController paramNotificationReportController)
  {
    a = paramNotificationReportController;
  }
  
  public static void b(int paramInt1, String paramString, int paramInt2)
  {
    if (a != null) {
      a.report(4, paramInt1, paramString, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awzy
 * JD-Core Version:    0.7.0.1
 */