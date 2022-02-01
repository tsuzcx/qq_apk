package com.tencent.biz.pubaccount.Advertisement.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView;
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      PublicAccountAdvertisementActivity.a(this.a);
      PublicAccountAdvertisementActivity.c(this.a);
      PublicAccountAdvertisementActivity.b(this.a);
      AdvertisementRecentUserManager.a().a(this.a.getAppInterface(), 4, PublicAccountAdvertisementActivity.a(this.a));
      PublicAccountAdvertisementActivity.a(this.a).setVisibility(8);
      this.a.finish();
      continue;
      if ((PublicAccountAdvertisementActivity.c(this.a)) && (PublicAccountAdvertisementActivity.a(this.a) != null))
      {
        PublicAccountAdvertisementActivity.a(this.a).setCurrentPage(1);
        PublicAccountAdvertisementActivity.b(this.a, 1);
        continue;
        this.a.b();
        continue;
        ReportController.b(null, "dc00898", "", PublicAccountAdvertisementActivity.a(this.a).a.a, "0X8009032", "0X8009032", 0, 0, PublicAccountAdvertisementActivity.a(this.a).a.c, "", "", PublicAccountAdvertisementActivity.a(this.a).a.b);
        PublicAccountAdvertisementActivity.d(this.a);
        continue;
        PublicAccountAdvertisementActivity.a(this.a, 2);
        continue;
        PublicAccountAdvertisementActivity.a(this.a, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity.3
 * JD-Core Version:    0.7.0.1
 */