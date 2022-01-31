import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class apwt
  extends WtloginObserver
{
  apwt(apwr paramapwr) {}
  
  public void OnCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EquipLockWebImpl", 2, "OnCheckDevLockSms ret=" + paramInt);
    }
    if (paramInt == 0)
    {
      apwr.c(this.a, true);
      if (apwr.a(this.a) != null)
      {
        paramWUserSigInfo = (QQAppInterface)apwr.a(this.a).get();
        if ((paramWUserSigInfo != null) && (apwu.a().a(paramWUserSigInfo))) {}
      }
      else
      {
        apwr.a(this.a, false);
        apwr.b(this.a, false);
      }
      return;
    }
    apwr.a(this.a, false);
    apwr.c(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apwt
 * JD-Core Version:    0.7.0.1
 */