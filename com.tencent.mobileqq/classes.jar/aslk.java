import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class aslk
  extends WtloginObserver
{
  aslk(asli paramasli) {}
  
  public void onCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EquipLockWebImpl", 2, "OnCheckDevLockSms ret=" + paramInt);
    }
    if (paramInt == 0)
    {
      asli.c(this.a, true);
      if (asli.a(this.a) != null)
      {
        paramWUserSigInfo = (QQAppInterface)asli.a(this.a).get();
        if ((paramWUserSigInfo != null) && (asll.a().a(paramWUserSigInfo))) {}
      }
      else
      {
        asli.a(this.a, false);
        asli.b(this.a, false);
      }
      return;
    }
    asli.a(this.a, false);
    asli.c(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslk
 * JD-Core Version:    0.7.0.1
 */