import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class aqbc
  extends WtloginObserver
{
  aqbc(aqba paramaqba) {}
  
  public void OnCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EquipLockWebImpl", 2, "OnCheckDevLockSms ret=" + paramInt);
    }
    if (paramInt == 0)
    {
      aqba.c(this.a, true);
      if (aqba.a(this.a) != null)
      {
        paramWUserSigInfo = (QQAppInterface)aqba.a(this.a).get();
        if ((paramWUserSigInfo != null) && (aqbd.a().a(paramWUserSigInfo))) {}
      }
      else
      {
        aqba.a(this.a, false);
        aqba.b(this.a, false);
      }
      return;
    }
    aqba.a(this.a, false);
    aqba.c(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbc
 * JD-Core Version:    0.7.0.1
 */