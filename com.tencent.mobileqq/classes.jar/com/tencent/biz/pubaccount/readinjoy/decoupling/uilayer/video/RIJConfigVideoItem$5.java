package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class RIJConfigVideoItem$5
  implements View.OnClickListener
{
  RIJConfigVideoItem$5(String paramString) {}
  
  public void onClick(View paramView)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009BE2", "0X8009BE2", 0, 0, "", "", "", this.a, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJConfigVideoItem.5
 * JD-Core Version:    0.7.0.1
 */