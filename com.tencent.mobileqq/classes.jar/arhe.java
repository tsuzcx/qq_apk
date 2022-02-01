import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class arhe
  extends WtloginObserver
{
  arhe(arhc paramarhc) {}
  
  public void onCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EquipLockWebImpl", 2, "OnCheckDevLockSms ret=" + paramInt);
    }
    if (paramInt == 0)
    {
      arhc.c(this.a, true);
      if (arhc.a(this.a) != null)
      {
        paramWUserSigInfo = (QQAppInterface)arhc.a(this.a).get();
        if ((paramWUserSigInfo != null) && (arhf.a().a(paramWUserSigInfo))) {}
      }
      else
      {
        arhc.a(this.a, false);
        arhc.b(this.a, false);
      }
      return;
    }
    arhc.a(this.a, false);
    arhc.c(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arhe
 * JD-Core Version:    0.7.0.1
 */