package com.tencent.mobileqq.activity.qwallet;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils.AnsyListener;
import mqq.app.NewIntent;
import tencent.im.qqwallet.QWalletPubAdReport.ReportReq;

class QWalletGdtAdManager$3
  implements QwUtils.AnsyListener
{
  QWalletGdtAdManager$3(QWalletGdtAdManager paramQWalletGdtAdManager, int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public void a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs.length <= 0) || (paramVarArgs[0] == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager", 2, "get getPskeyAsync success");
    }
    paramVarArgs = QWalletGdtAdManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletGdtAdManager, paramVarArgs[0], this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext);
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), GdtAdServlet.class);
    localNewIntent.putExtra("cmd", "ReportSvc.Statistics");
    localNewIntent.putExtra("data", WupUtil.a(paramVarArgs.toByteArray()));
    localNewIntent.setObserver(new QWalletGdtAdManager.3.1(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletGdtAdManager.3
 * JD-Core Version:    0.7.0.1
 */