import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aqfm
  implements aqgj
{
  aqfm(aqfk paramaqfk) {}
  
  public void a(int paramInt, aqcl paramaqcl, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, "onMatchingResult, result = " + paramInt + " nickName : " + paramString1);
      if (paramaqcl != null) {
        QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, " info：" + paramaqcl.toString());
      }
    }
    if ((aqfk.a(this.a) == null) || (aqfk.a(this.a).get() == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendLimitChatManager", 2, "onMatchingResult, listener = null");
      }
    }
    while (this.a.a() != 2) {
      return;
    }
    if ((paramInt != 0) || (paramaqcl == null)) {
      this.a.a().a(104);
    }
    for (;;)
    {
      ((aqfp)aqfk.a(this.a).get()).a(paramInt, paramaqcl, paramString1, paramString2);
      return;
      aqfk.a(this.a, paramaqcl.a());
      this.a.a = paramString1;
      this.a.a().a(105);
      if (!aqfk.a(this.a))
      {
        QQNotificationManager.getInstance().createLimitChatNotificationChannel();
        aqfk.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqfm
 * JD-Core Version:    0.7.0.1
 */