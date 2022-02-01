import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class askm
  implements aslo
{
  askm(askk paramaskk) {}
  
  public void a(int paramInt, ashh paramashh, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, "onMatchingResult, result = " + paramInt + " nickName : " + paramString1);
      if (paramashh != null) {
        QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, " info：" + paramashh.toString());
      }
    }
    if ((askk.a(this.a) == null) || (askk.a(this.a).get() == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendLimitChatManager", 2, "onMatchingResult, listener = null");
      }
    }
    while (this.a.a() != 2) {
      return;
    }
    if ((paramInt != 0) || (paramashh == null)) {
      this.a.a().a(104);
    }
    for (;;)
    {
      ((askp)askk.a(this.a).get()).a(paramInt, paramashh, paramString1, paramString2);
      return;
      askk.a(this.a, paramashh.a());
      this.a.a = paramString1;
      this.a.a().a(105);
      if (!askk.a(this.a))
      {
        QQNotificationManager.getInstance().createLimitChatNotificationChannel();
        askk.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askm
 * JD-Core Version:    0.7.0.1
 */