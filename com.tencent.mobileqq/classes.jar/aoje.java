import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aoje
  implements aojy
{
  aoje(aojc paramaojc) {}
  
  public void a(int paramInt, aofu paramaofu, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, "onMatchingResult, result = " + paramInt + " nickName : " + paramString1);
      if (paramaofu != null) {
        QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, " info：" + paramaofu.toString());
      }
    }
    if ((aojc.a(this.a) == null) || (aojc.a(this.a).get() == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendLimitChatManager", 2, "onMatchingResult, listener = null");
      }
    }
    while (this.a.a() != 2) {
      return;
    }
    if ((paramInt != 0) || (paramaofu == null)) {
      this.a.a().a(104);
    }
    for (;;)
    {
      ((aojf)aojc.a(this.a).get()).a(paramInt, paramaofu, paramString1, paramString2);
      return;
      aojc.a(this.a, paramaofu.a());
      this.a.a = paramString1;
      this.a.a().a(105);
      if (!aojc.a(this.a))
      {
        QQNotificationManager.getInstance().createLimitChatNotificationChannel();
        aojc.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoje
 * JD-Core Version:    0.7.0.1
 */