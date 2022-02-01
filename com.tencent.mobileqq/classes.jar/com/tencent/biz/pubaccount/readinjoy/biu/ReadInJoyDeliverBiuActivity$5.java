package com.tencent.biz.pubaccount.readinjoy.biu;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyDeliverBiuActivity$5
  implements View.OnClickListener
{
  ReadInJoyDeliverBiuActivity$5(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ReadInJoyDeliverBiuActivity.e(this.a)) && ((!ReadInJoyDeliverBiuActivity.f(this.a)) || (ReadInJoyDeliverBiuActivity.m(this.a) != -1))) {
      this.a.e(ReadInJoyDeliverBiuActivity.n(this.a));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.finish();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008661", "0X8008661", 0, 0, ReadInJoyDeliverBiuActivity.n(this.a) + "", "", "", ReadInJoyBaseDeliverActivity.a(), false);
      ReadInJoyDeliverBiuActivity.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity.5
 * JD-Core Version:    0.7.0.1
 */