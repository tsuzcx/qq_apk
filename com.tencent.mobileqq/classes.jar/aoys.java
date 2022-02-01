import QQWalletPay.RespCheckChangePwdAuth;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aoys
  extends Handler
{
  private aoys(aoyp paramaoyp) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    if (aoyp.a(this.a) != null)
    {
      aoyp.a(this.a).a();
      this.a.a.removeObserver(aoyp.a(this.a));
    }
    if (paramMessage.arg1 != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QwalletModifyPassAction", 2, "msf return error ");
      }
      aoyp.a(this.a, 1);
      return;
    }
    if ((paramMessage.obj instanceof RespCheckChangePwdAuth))
    {
      paramMessage = (RespCheckChangePwdAuth)paramMessage.obj;
      if (paramMessage.retCode == 0)
      {
        aoyp.b(this.a);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QwalletModifyPassAction", 2, "server return error, errorCode: " + paramMessage.retCode + " errorMsg: " + paramMessage.retMsg);
      }
    }
    aoyp.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoys
 * JD-Core Version:    0.7.0.1
 */