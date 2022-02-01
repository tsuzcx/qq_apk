package com.tencent.biz.pubaccount.Advertisement.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountAdvertisementActivity$3
  implements View.OnClickListener
{
  PublicAccountAdvertisementActivity$3(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131449533: 
      if ((PublicAccountAdvertisementActivity.f(this.a)) && (PublicAccountAdvertisementActivity.j(this.a) != null))
      {
        PublicAccountAdvertisementActivity.j(this.a).setCurrentPage(1);
        PublicAccountAdvertisementActivity.b(this.a, 1);
      }
      break;
    case 2131449524: 
      this.a.c();
      break;
    case 2131449502: 
      PublicAccountAdvertisementActivity.a(this.a);
      PublicAccountAdvertisementActivity.g(this.a);
      PublicAccountAdvertisementActivity.b(this.a);
      AdvertisementRecentUserManager.a().a((AppInterface)this.a.getAppRuntime(), 4, PublicAccountAdvertisementActivity.h(this.a));
      PublicAccountAdvertisementActivity.i(this.a).setVisibility(8);
      this.a.finish();
      break;
    case 2131438862: 
      PublicAccountAdvertisementActivity.c(this.a, 2);
      break;
    case 2131427742: 
      ReportController.b(null, "dc00898", "", PublicAccountAdvertisementActivity.h(this.a).g.a, "0X8009032", "0X8009032", 0, 0, PublicAccountAdvertisementActivity.h(this.a).g.c, "", "", PublicAccountAdvertisementActivity.h(this.a).g.b);
      PublicAccountAdvertisementActivity.k(this.a);
      break;
    case 2131427732: 
      PublicAccountAdvertisementActivity.c(this.a, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity.3
 * JD-Core Version:    0.7.0.1
 */