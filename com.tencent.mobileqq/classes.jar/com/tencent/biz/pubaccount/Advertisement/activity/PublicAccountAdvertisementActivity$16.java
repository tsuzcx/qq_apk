package com.tencent.biz.pubaccount.Advertisement.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class PublicAccountAdvertisementActivity$16
  implements View.OnClickListener
{
  PublicAccountAdvertisementActivity$16(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountAdvertisementActivity", 2, "action cancel");
    }
    ReportController.a(null, "dc00898", "", PublicAccountAdvertisementActivity.a(this.a).a.a, "0X80090FD", "0X80090FD", 0, 0, PublicAccountAdvertisementActivity.a(this.a).a.c, "", "", PublicAccountAdvertisementActivity.a(this.a).a.b);
    if ((PublicAccountAdvertisementActivity.a(this.a) != null) && (PublicAccountAdvertisementActivity.a(this.a).isShowing())) {
      PublicAccountAdvertisementActivity.a(this.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity.16
 * JD-Core Version:    0.7.0.1
 */