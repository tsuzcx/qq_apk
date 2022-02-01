package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class BBannerHelper$OnCloseClickDelegate
  implements View.OnClickListener
{
  private BBannerHelper.MessageToShowBanner jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public BBannerHelper$OnCloseClickDelegate(BBannerHelper.MessageToShowBanner paramMessageToShowBanner, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner = paramMessageToShowBanner;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner.jdField_a_of_type_JavaLangString + " on close");
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1000);
    localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$IBannerInteract.onClose();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper.OnCloseClickDelegate
 * JD-Core Version:    0.7.0.1
 */