import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aoiz
  implements aojt
{
  aoiz(aoix paramaoix) {}
  
  public void a(int paramInt, aofp paramaofp, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, "onMatchingResult, result = " + paramInt + " nickName : " + paramString1);
      if (paramaofp != null) {
        QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, " info：" + paramaofp.toString());
      }
    }
    if ((aoix.a(this.a) == null) || (aoix.a(this.a).get() == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendLimitChatManager", 2, "onMatchingResult, listener = null");
      }
    }
    while (this.a.a() != 2) {
      return;
    }
    if ((paramInt != 0) || (paramaofp == null)) {
      this.a.a().a(104);
    }
    for (;;)
    {
      ((aoja)aoix.a(this.a).get()).a(paramInt, paramaofp, paramString1, paramString2);
      return;
      aoix.a(this.a, paramaofp.a());
      this.a.a = paramString1;
      this.a.a().a(105);
      if (!aoix.a(this.a))
      {
        QQNotificationManager.getInstance().createLimitChatNotificationChannel();
        aoix.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoiz
 * JD-Core Version:    0.7.0.1
 */