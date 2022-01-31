import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class aoem
  extends WtloginObserver
{
  aoem(aoek paramaoek) {}
  
  public void OnCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EquipLockWebImpl", 2, "OnCheckDevLockSms ret=" + paramInt);
    }
    if (paramInt == 0)
    {
      aoek.c(this.a, true);
      if (aoek.a(this.a) != null)
      {
        paramWUserSigInfo = (QQAppInterface)aoek.a(this.a).get();
        if ((paramWUserSigInfo != null) && (aoen.a().a(paramWUserSigInfo))) {}
      }
      else
      {
        aoek.a(this.a, false);
        aoek.b(this.a, false);
      }
      return;
    }
    aoek.a(this.a, false);
    aoek.c(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoem
 * JD-Core Version:    0.7.0.1
 */