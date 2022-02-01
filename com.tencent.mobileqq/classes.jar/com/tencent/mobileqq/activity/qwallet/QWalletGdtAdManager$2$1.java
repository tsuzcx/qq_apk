package com.tencent.mobileqq.activity.qwallet;

import android.os.Bundle;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.qqwallet.QWalletPubAdReport.QueryRsp;

class QWalletGdtAdManager$2$1
  implements BusinessObserver
{
  QWalletGdtAdManager$2$1(QWalletGdtAdManager.2 param2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletGdtAdManager", 2, "onReceive:type:" + paramInt + ",isSuccess:" + paramBoolean + ",bundle:" + paramBundle + ",cost:" + (NetConnInfoCenter.getServerTimeMillis() - this.a.jdField_a_of_type_Long));
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if ((paramBundle != null) && (paramBoolean))
      {
        QWalletPubAdReport.QueryRsp localQueryRsp = new QWalletPubAdReport.QueryRsp();
        localQueryRsp.mergeFrom(paramBundle);
        paramInt = localQueryRsp.ret.get();
        if (paramInt == 0)
        {
          QWalletGdtAdManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletGdtAdManager, localQueryRsp.pv_flag.get());
          QWalletGdtAdManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletGdtAdManager, localQueryRsp);
          if (QLog.isColorLevel()) {
            QLog.i("QWalletGdtAdManager", 2, "doReqAdsControl onReceive: retCode:" + localQueryRsp.ret.get() + ",msg:" + localQueryRsp.msg.get());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("QWalletGdtAdManager", 2, "onReceive fail,retCode:" + paramInt);
          return;
        }
      }
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
      QLog.e("QWalletGdtAdManager", 1, "onReceive fail exception:" + paramBundle.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletGdtAdManager.2.1
 * JD-Core Version:    0.7.0.1
 */