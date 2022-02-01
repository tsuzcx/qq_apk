package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.activity.aio.qwallet.elem.BaseRedPkgElem;
import com.tencent.mobileqq.activity.aio.qwallet.elem.PanelRedPkgElem;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;

class CustomizeStrategyFactory$PanelStrategy
  implements CustomizeStrategyFactory.HBCustomizeStrategy
{
  QWalletConfigManager jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  IPreloadService jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService = null;
  
  CustomizeStrategyFactory$PanelStrategy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService = ((IPreloadService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPreloadService.class, ""));
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager = ((QWalletConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER));
    }
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    ThreadManager.post(new CustomizeStrategyFactory.PanelStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, BaseRedPkgElem paramBaseRedPkgElem)
  {
    if ((paramRedPacketInfo != null) && ((paramBaseRedPkgElem instanceof PanelRedPkgElem)))
    {
      paramBaseRedPkgElem = (PanelRedPkgElem)paramBaseRedPkgElem;
      paramRedPacketInfo.icon = paramBaseRedPkgElem.a;
      paramRedPacketInfo.resPath = paramBaseRedPkgElem.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.PanelStrategy
 * JD-Core Version:    0.7.0.1
 */