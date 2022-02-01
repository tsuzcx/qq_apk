import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class asqv
  implements asrz
{
  asqv(asqt paramasqt) {}
  
  public void a(int paramInt, asne paramasne, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, "onMatchingResult, result = " + paramInt + " nickName : " + paramString1);
      if (paramasne != null) {
        QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, " info：" + paramasne.toString());
      }
    }
    if ((asqt.a(this.a) == null) || (asqt.a(this.a).get() == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendLimitChatManager", 2, "onMatchingResult, listener = null");
      }
    }
    while (this.a.a() != 2) {
      return;
    }
    if ((paramInt != 0) || (paramasne == null)) {
      this.a.a().a(104);
    }
    for (;;)
    {
      ((asqy)asqt.a(this.a).get()).a(paramInt, paramasne, paramString1, paramString2);
      return;
      asqt.a(this.a, paramasne.a());
      this.a.a = paramString1;
      this.a.a().a(105);
      if (!asqt.a(this.a))
      {
        QQNotificationManager.getInstance().createLimitChatNotificationChannel();
        asqt.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqv
 * JD-Core Version:    0.7.0.1
 */