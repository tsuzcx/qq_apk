import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class aoer
  extends WtloginObserver
{
  aoer(aoep paramaoep) {}
  
  public void OnCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EquipLockWebImpl", 2, "OnCheckDevLockSms ret=" + paramInt);
    }
    if (paramInt == 0)
    {
      aoep.c(this.a, true);
      if (aoep.a(this.a) != null)
      {
        paramWUserSigInfo = (QQAppInterface)aoep.a(this.a).get();
        if ((paramWUserSigInfo != null) && (aoes.a().a(paramWUserSigInfo))) {}
      }
      else
      {
        aoep.a(this.a, false);
        aoep.b(this.a, false);
      }
      return;
    }
    aoep.a(this.a, false);
    aoep.c(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoer
 * JD-Core Version:    0.7.0.1
 */