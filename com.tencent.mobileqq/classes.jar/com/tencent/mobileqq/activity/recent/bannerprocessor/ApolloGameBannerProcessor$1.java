package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ApolloGameBannerProcessor$1
  implements View.OnClickListener
{
  ApolloGameBannerProcessor$1(ApolloGameBannerProcessor paramApolloGameBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    CmGameMainManager localCmGameMainManager = CmGameMainManager.a();
    if (localCmGameMainManager != null)
    {
      localCmGameMainManager.a(ApolloGameBannerProcessor.a(this.a));
      localCmGameMainManager.a();
      CmGameMainManager.i();
    }
    ReportController.a(ApolloGameBannerProcessor.b(this.a).getAppRuntime(), "dc00898", "", "", "0X8009EE3", "0X8009EE3", 10, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ApolloGameBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */