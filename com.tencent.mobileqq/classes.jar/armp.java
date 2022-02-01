import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class armp
  implements arnt
{
  armp(armn paramarmn) {}
  
  public void a(int paramInt, ariy paramariy, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, "onMatchingResult, result = " + paramInt + " nickName : " + paramString1);
      if (paramariy != null) {
        QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, " info：" + paramariy.toString());
      }
    }
    if ((armn.a(this.a) == null) || (armn.a(this.a).get() == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendLimitChatManager", 2, "onMatchingResult, listener = null");
      }
    }
    while (this.a.a() != 2) {
      return;
    }
    if ((paramInt != 0) || (paramariy == null)) {
      this.a.a().a(104);
    }
    for (;;)
    {
      ((arms)armn.a(this.a).get()).a(paramInt, paramariy, paramString1, paramString2);
      return;
      armn.a(this.a, paramariy.a());
      this.a.a = paramString1;
      this.a.a().a(105);
      if (!armn.a(this.a))
      {
        QQNotificationManager.getInstance().createLimitChatNotificationChannel();
        armn.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     armp
 * JD-Core Version:    0.7.0.1
 */