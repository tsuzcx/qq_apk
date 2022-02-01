package com.tencent.mobileqq.activity.aio.qwallet;

import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils.AnsyListener;

class QQWalletHbItemUtils$1
  implements QwUtils.AnsyListener
{
  QQWalletHbItemUtils$1(QQWalletHbItemUtils paramQQWalletHbItemUtils) {}
  
  public void a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs.length <= 0) || (paramVarArgs[0] == null))
    {
      QLog.i(QQWalletHbItemUtils.a, 2, "error get pskey...");
      return;
    }
    QQWalletHbItemUtils.a(this.a, paramVarArgs[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.QQWalletHbItemUtils.1
 * JD-Core Version:    0.7.0.1
 */