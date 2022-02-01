package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.recent.bannerprocessor.TimUpgradeBannerProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;

class Conversation$UICallBack$5
  implements Runnable
{
  Conversation$UICallBack$5(Conversation.UICallBack paramUICallBack) {}
  
  public void run()
  {
    UpgradeTIMWrapper localUpgradeTIMWrapper = UpgradeTIMWrapper.a(this.a.a.a());
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, new Object[] { "UpgradeTIMWrapper MSG_TIM_UPGRADE_BAR_SHOW, tips on: ", Boolean.valueOf(localUpgradeTIMWrapper.a()) });
    }
    if (!localUpgradeTIMWrapper.a())
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(TimUpgradeBannerProcessor.a, 3000, 0L, true);
      return;
    }
    if (PackageUtil.a(((QQAppInterface)this.a.a.jdField_a_of_type_MqqAppAppRuntime).getApp(), "com.tencent.tim"))
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(TimUpgradeBannerProcessor.a, 3000, 0L, true);
      return;
    }
    if ((!UpgradeTIMWrapper.b()) && (Conversation.a(this.a.a) == null)) {
      this.a.a.b(new Conversation.UICallBack.5.1(this, localUpgradeTIMWrapper));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.UICallBack.5
 * JD-Core Version:    0.7.0.1
 */