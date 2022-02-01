import QQWalletPay.RespCheckChangePwdAuth;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aovt
  extends Handler
{
  private aovt(aovq paramaovq) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    if (aovq.a(this.a) != null)
    {
      aovq.a(this.a).a();
      this.a.a.removeObserver(aovq.a(this.a));
    }
    if (paramMessage.arg1 != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QwalletModifyPassAction", 2, "msf return error ");
      }
      aovq.a(this.a, 1);
      return;
    }
    if ((paramMessage.obj instanceof RespCheckChangePwdAuth))
    {
      paramMessage = (RespCheckChangePwdAuth)paramMessage.obj;
      if (paramMessage.retCode == 0)
      {
        aovq.b(this.a);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QwalletModifyPassAction", 2, "server return error, errorCode: " + paramMessage.retCode + " errorMsg: " + paramMessage.retMsg);
      }
    }
    aovq.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aovt
 * JD-Core Version:    0.7.0.1
 */