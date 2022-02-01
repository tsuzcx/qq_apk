import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class atai
  implements atbl
{
  atai(atag paramatag) {}
  
  public void a(int paramInt, aswv paramaswv, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, "onMatchingResult, result = " + paramInt + " nickName : " + paramString1);
      if (paramaswv != null) {
        QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, " info：" + paramaswv.toString());
      }
    }
    if ((atag.a(this.a) == null) || (atag.a(this.a).get() == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendLimitChatManager", 2, "onMatchingResult, listener = null");
      }
    }
    while (this.a.a() != 2) {
      return;
    }
    if ((paramInt != 0) || (paramaswv == null)) {
      this.a.a().a(104);
    }
    for (;;)
    {
      ((atal)atag.a(this.a).get()).a(paramInt, paramaswv, paramString1, paramString2);
      return;
      atag.a(this.a, paramaswv.a());
      this.a.a = paramString1;
      this.a.a().a(105);
      if (!atag.a(this.a))
      {
        QQNotificationManager.getInstance().createLimitChatNotificationChannel();
        atag.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atai
 * JD-Core Version:    0.7.0.1
 */