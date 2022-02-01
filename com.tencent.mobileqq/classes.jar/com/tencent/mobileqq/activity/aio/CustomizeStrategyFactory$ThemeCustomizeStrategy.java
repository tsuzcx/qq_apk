package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.activity.aio.qwallet.elem.BaseRedPkgElem;
import com.tencent.mobileqq.activity.aio.qwallet.elem.ThemeRedPkgElem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;

class CustomizeStrategyFactory$ThemeCustomizeStrategy
  implements CustomizeStrategyFactory.HBCustomizeStrategy
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IPreloadService jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService = null;
  
  public CustomizeStrategyFactory$ThemeCustomizeStrategy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService = ((IPreloadService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPreloadService.class, ""));
    }
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo == null) {
      return;
    }
    ThreadManager.post(new CustomizeStrategyFactory.ThemeCustomizeStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, BaseRedPkgElem paramBaseRedPkgElem)
  {
    if ((paramRedPacketInfo != null) && ((paramBaseRedPkgElem instanceof ThemeRedPkgElem))) {
      paramRedPacketInfo.background = ((ThemeRedPkgElem)paramBaseRedPkgElem).b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.ThemeCustomizeStrategy
 * JD-Core Version:    0.7.0.1
 */