import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ansn
  implements anth
{
  ansn(ansl paramansl) {}
  
  public void a(int paramInt, anpe paramanpe, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, "onMatchingResult, result = " + paramInt + " nickName : " + paramString1);
      if (paramanpe != null) {
        QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, " info：" + paramanpe.toString());
      }
    }
    if ((ansl.a(this.a) == null) || (ansl.a(this.a).get() == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendLimitChatManager", 2, "onMatchingResult, listener = null");
      }
    }
    while (this.a.a() != 2) {
      return;
    }
    if ((paramInt != 0) || (paramanpe == null)) {
      this.a.a().b(104);
    }
    for (;;)
    {
      ((anso)ansl.a(this.a).get()).a(paramInt, paramanpe, paramString1, paramString2);
      return;
      ansl.a(this.a, paramanpe.a());
      this.a.a = paramString1;
      this.a.a().b(105);
      if (!ansl.a(this.a))
      {
        QQNotificationManager.getInstance().createLimitChatNotificationChannel();
        ansl.a(this.a, true);
      }
      this.a.a(paramanpe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ansn
 * JD-Core Version:    0.7.0.1
 */