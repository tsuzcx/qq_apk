package com.tencent.biz.pubaccount.readinjoy;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DailyDynamicHeaderViewController$2
  implements View.OnClickListener
{
  DailyDynamicHeaderViewController$2(DailyDynamicHeaderViewController paramDailyDynamicHeaderViewController) {}
  
  public void onClick(View paramView)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramView.getContext(), "/pubaccount/detail");
    localActivityURIRequest.extra().putString("uin", String.valueOf(3434959637L));
    localActivityURIRequest.extra().putInt("uintype", 1008);
    localActivityURIRequest.extra().putInt("source", 121);
    QRoute.startUri(localActivityURIRequest, null);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009941", "0X8009941", 0, 0, "", "", "", "", false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderViewController.2
 * JD-Core Version:    0.7.0.1
 */