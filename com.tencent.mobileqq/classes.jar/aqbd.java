import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aqbd
  implements aqca
{
  aqbd(aqbb paramaqbb) {}
  
  public void a(int paramInt, apyc paramapyc, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, "onMatchingResult, result = " + paramInt + " nickName : " + paramString1);
      if (paramapyc != null) {
        QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, " info：" + paramapyc.toString());
      }
    }
    if ((aqbb.a(this.a) == null) || (aqbb.a(this.a).get() == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendLimitChatManager", 2, "onMatchingResult, listener = null");
      }
    }
    while (this.a.a() != 2) {
      return;
    }
    if ((paramInt != 0) || (paramapyc == null)) {
      this.a.a().a(104);
    }
    for (;;)
    {
      ((aqbg)aqbb.a(this.a).get()).a(paramInt, paramapyc, paramString1, paramString2);
      return;
      aqbb.a(this.a, paramapyc.a());
      this.a.a = paramString1;
      this.a.a().a(105);
      if (!aqbb.a(this.a))
      {
        QQNotificationManager.getInstance().createLimitChatNotificationChannel();
        aqbb.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbd
 * JD-Core Version:    0.7.0.1
 */