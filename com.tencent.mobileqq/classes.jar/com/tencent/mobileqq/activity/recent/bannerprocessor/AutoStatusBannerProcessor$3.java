package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AutoStatusBannerProcessor$3
  implements View.OnClickListener
{
  AutoStatusBannerProcessor$3(AutoStatusBannerProcessor paramAutoStatusBannerProcessor, AutoStatusItem paramAutoStatusItem) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = AutoStatusManager.a((QQAppInterface)AutoStatusBannerProcessor.d(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorAutoStatusBannerProcessor).getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigAutoStatusItem.a);
    AutoStatusBannerProcessor.e(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorAutoStatusBannerProcessor).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.AutoStatusBannerProcessor.3
 * JD-Core Version:    0.7.0.1
 */