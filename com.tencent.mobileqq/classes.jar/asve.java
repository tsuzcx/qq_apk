import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class asve
  extends WtloginObserver
{
  asve(asvc paramasvc) {}
  
  public void onCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EquipLockWebImpl", 2, "OnCheckDevLockSms ret=" + paramInt);
    }
    if (paramInt == 0)
    {
      asvc.c(this.a, true);
      if (asvc.a(this.a) != null)
      {
        paramWUserSigInfo = (QQAppInterface)asvc.a(this.a).get();
        if ((paramWUserSigInfo != null) && (asvf.a().a(paramWUserSigInfo))) {}
      }
      else
      {
        asvc.a(this.a, false);
        asvc.b(this.a, false);
      }
      return;
    }
    asvc.a(this.a, false);
    asvc.c(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asve
 * JD-Core Version:    0.7.0.1
 */