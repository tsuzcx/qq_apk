package com.tencent.mobileqq.activity.qwallet;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

class QWalletGdtAdManager$1
  implements GdtAdLoader.Listener
{
  QWalletGdtAdManager$1(QWalletGdtAdManager paramQWalletGdtAdManager, long paramLong, BaseChatPie paramBaseChatPie) {}
  
  public void onResponse(GdtAdLoader paramGdtAdLoader)
  {
    try
    {
      QWalletGdtAdManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletGdtAdManager, null);
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse :" + paramGdtAdLoader + ",cost:" + (NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long));
      }
      if ((paramGdtAdLoader == null) || (paramGdtAdLoader.a() == null) || (paramGdtAdLoader.a().a == null) || (!paramGdtAdLoader.a().a.ret.has()) || (paramGdtAdLoader.a().a.ret.get() != 0))
      {
        QWalletGdtAdManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletGdtAdManager, paramGdtAdLoader);
        QWalletGdtAdManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletGdtAdManager);
        return;
      }
      paramGdtAdLoader = paramGdtAdLoader.a().a;
      if ((!paramGdtAdLoader.pos_ads_info.has()) || (paramGdtAdLoader.pos_ads_info.size() <= 0) || (!((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.pos_ads_info.get(0)).ret.has()) || (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.pos_ads_info.get(0)).ret.get() != 0) || (!((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.pos_ads_info.get(0)).ads_info.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse : getAdInfo is null");
        }
        QWalletGdtAdManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletGdtAdManager);
        return;
      }
    }
    catch (Throwable paramGdtAdLoader)
    {
      QLog.e("QWalletGdtAdManager", 1, paramGdtAdLoader, new Object[0]);
      return;
    }
    if ((!QWalletGdtAdManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletGdtAdManager)) && (QWalletGdtAdManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletGdtAdManager) == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse but mPvFlag is 1,will not display ad");
      }
      QWalletGdtAdManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletGdtAdManager);
      return;
    }
    QWalletGdtAdManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletGdtAdManager, new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.pos_ads_info.get(0)).ads_info.get(0)));
    QWalletGdtAdManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletGdtAdManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    if (QWalletGdtAdManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletGdtAdManager)) {
      GdtPreLoader.a().a(QWalletGdtAdManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletGdtAdManager));
    }
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse : notifyDataSetChanged,mHasTailMsg:" + QWalletGdtAdManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletGdtAdManager));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletGdtAdManager.1
 * JD-Core Version:    0.7.0.1
 */