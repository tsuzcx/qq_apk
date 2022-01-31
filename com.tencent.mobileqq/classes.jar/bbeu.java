import QQWalletPay.RespCheckChangePwdAuth;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class bbeu
  extends Handler
{
  private bbeu(bbeg parambbeg) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    if (bbeg.a(this.a) != null)
    {
      bbeg.a(this.a).a();
      bbeg.a(this.a).removeObserver(bbeg.a(this.a));
    }
    if (paramMessage.arg1 != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "msf return error ");
      }
      bbeg.a(this.a, 1);
      return;
    }
    if ((paramMessage.obj instanceof RespCheckChangePwdAuth))
    {
      paramMessage = (RespCheckChangePwdAuth)paramMessage.obj;
      if (paramMessage.retCode == 0)
      {
        bbeg.b(this.a);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "server return error, errorCode: " + paramMessage.retCode + " errorMsg: " + paramMessage.retMsg);
      }
    }
    bbeg.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbeu
 * JD-Core Version:    0.7.0.1
 */