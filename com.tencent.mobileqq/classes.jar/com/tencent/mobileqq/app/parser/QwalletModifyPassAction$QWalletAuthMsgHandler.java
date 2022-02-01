package com.tencent.mobileqq.app.parser;

import QQWalletPay.RespCheckChangePwdAuth;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletAuthObserver;
import com.tencent.qphone.base.util.QLog;

class QwalletModifyPassAction$QWalletAuthMsgHandler
  extends Handler
{
  private QwalletModifyPassAction$QWalletAuthMsgHandler(QwalletModifyPassAction paramQwalletModifyPassAction) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    if (QwalletModifyPassAction.a(this.a) != null)
    {
      QwalletModifyPassAction.a(this.a).a();
      this.a.a.removeObserver(QwalletModifyPassAction.a(this.a));
    }
    if (paramMessage.arg1 != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QwalletModifyPassAction", 2, "msf return error ");
      }
      QwalletModifyPassAction.a(this.a, 1);
      return;
    }
    if ((paramMessage.obj instanceof RespCheckChangePwdAuth))
    {
      paramMessage = (RespCheckChangePwdAuth)paramMessage.obj;
      if (paramMessage.retCode == 0)
      {
        QwalletModifyPassAction.b(this.a);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QwalletModifyPassAction", 2, "server return error, errorCode: " + paramMessage.retCode + " errorMsg: " + paramMessage.retMsg);
      }
    }
    QwalletModifyPassAction.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QwalletModifyPassAction.QWalletAuthMsgHandler
 * JD-Core Version:    0.7.0.1
 */