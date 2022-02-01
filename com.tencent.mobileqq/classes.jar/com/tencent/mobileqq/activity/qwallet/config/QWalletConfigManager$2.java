package com.tencent.mobileqq.activity.qwallet.config;

import Wallet.RspWalletConfig;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

class QWalletConfigManager$2
  implements BusinessObserver
{
  QWalletConfigManager$2(QWalletConfigManager paramQWalletConfigManager, long paramLong, QWalletConfigManager.ConfigListener paramConfigListener, WeakReference paramWeakReference) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt != 10) || (!paramBoolean)) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigManager", 2, "fail get rsp:" + this.jdField_a_of_type_Long);
      }
      QWalletConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager, -1L);
      return;
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
    paramBundle = (RspWalletConfig)paramBundle.getSerializable("rsp");
    if (QLog.isColorLevel()) {
      QLog.d("QWalletConfigManager", 2, "RspWalletConfig|" + paramBundle);
    }
    QWalletConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager).handleRsp(paramBundle, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager$ConfigListener, (QWalletConfigManager)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    QWalletConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager.2
 * JD-Core Version:    0.7.0.1
 */