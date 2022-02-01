package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DonDisturbBannerProcessor$2
  implements View.OnClickListener
{
  DonDisturbBannerProcessor$2(DonDisturbBannerProcessor paramDonDisturbBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    if (DonDisturbBannerProcessor.d(this.a).getAppRuntime() != null)
    {
      ((CardHandler)((AppInterface)DonDisturbBannerProcessor.e(this.a).getAppRuntime()).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(0, "", "not_disturb_from_conversation");
      ReportController.b(DonDisturbBannerProcessor.f(this.a).getAppRuntime(), "CliOper", "", "", "0X8009EBA", "0X8009EBA", 0, 1, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.DonDisturbBannerProcessor.2
 * JD-Core Version:    0.7.0.1
 */