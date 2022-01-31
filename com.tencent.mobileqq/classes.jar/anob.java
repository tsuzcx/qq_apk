import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class anob
  extends WtloginObserver
{
  anob(annz paramannz) {}
  
  public void OnCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EquipLockWebImpl", 2, "OnCheckDevLockSms ret=" + paramInt);
    }
    if (paramInt == 0)
    {
      annz.c(this.a, true);
      if (annz.a(this.a) != null)
      {
        paramWUserSigInfo = (QQAppInterface)annz.a(this.a).get();
        if ((paramWUserSigInfo != null) && (anoc.a().a(paramWUserSigInfo))) {}
      }
      else
      {
        annz.a(this.a, false);
        annz.b(this.a, false);
      }
      return;
    }
    annz.a(this.a, false);
    annz.c(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anob
 * JD-Core Version:    0.7.0.1
 */