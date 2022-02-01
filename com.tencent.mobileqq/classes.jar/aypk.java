import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class aypk
  extends aniz
{
  aypk(aypj paramaypj) {}
  
  protected void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    super.onGetDetailInfo(paramBoolean, paramString, paramCard);
    boolean bool;
    int i;
    if ((paramString != null) && (paramString.equals(aypj.a(this.a).getCurrentAccountUin())))
    {
      bool = true;
      if ((paramCard == null) || (paramCard.lBirthday == aypj.a(this.a))) {
        break label290;
      }
      i = 1;
      label53:
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, new Object[] { "onGetDetailInfo: invoked. [constellation] ", " isSuccess: ", Boolean.valueOf(paramBoolean), " uin: ", paramString, " mSelfCurrentBirthday: ", Long.valueOf(aypj.a(this.a)), " isSelfUin: ", Boolean.valueOf(bool) });
      }
      if ((i == 0) || (aypj.a(this.a).getExtOnlineStatus() != 1040L) || (!bool)) {
        break label296;
      }
      paramString = aypj.a(this.a).getCurrentAccountUin();
      str1 = aysh.a(aypj.a(this.a), paramString);
      paramBoolean = TextUtils.isEmpty(str1);
      if (paramBoolean)
      {
        str2 = aysh.b(aypj.a(this.a), paramString);
        ayph.a(aypj.a(this.a), str2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, new Object[] { "sendBussinessInfoRegisterPush: invoked. [constellation] (拉取资料回调中，如果运势为空，才执行运势拉取) ", " emptyTrend: ", Boolean.valueOf(paramBoolean), " uin: ", paramString, " trend: ", str1 });
      }
      aypj.a(this.a, paramCard.lBirthday);
    }
    label290:
    label296:
    while (!QLog.isColorLevel())
    {
      String str1;
      String str2;
      return;
      bool = false;
      break;
      i = 0;
      break label53;
    }
    QLog.d("OnlineStatusManager", 2, new Object[] { "onGetDetailInfo: invoked.[constellation]  no need fetch", " mApp.getExtOnlineStatus(): ", Long.valueOf(aypj.a(this.a).getExtOnlineStatus()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypk
 * JD-Core Version:    0.7.0.1
 */