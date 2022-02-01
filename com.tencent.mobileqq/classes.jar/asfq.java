import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class asfq
  extends WtloginObserver
{
  asfq(asfo paramasfo) {}
  
  public void OnCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EquipLockWebImpl", 2, "OnCheckDevLockSms ret=" + paramInt);
    }
    if (paramInt == 0)
    {
      asfo.c(this.a, true);
      if (asfo.a(this.a) != null)
      {
        paramWUserSigInfo = (QQAppInterface)asfo.a(this.a).get();
        if ((paramWUserSigInfo != null) && (asfr.a().a(paramWUserSigInfo))) {}
      }
      else
      {
        asfo.a(this.a, false);
        asfo.b(this.a, false);
      }
      return;
    }
    asfo.a(this.a, false);
    asfo.c(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfq
 * JD-Core Version:    0.7.0.1
 */