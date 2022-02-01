package com.tencent.biz.pubaccount.api.impl;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountBrowserImpl$2
  implements View.OnClickListener
{
  PublicAccountBrowserImpl$2(PublicAccountBrowserImpl paramPublicAccountBrowserImpl) {}
  
  public void onClick(View paramView)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.a.getApplicationContext(), "/pubaccount/detail");
    localActivityURIRequest.extra().putString("uin", this.a.publicUin);
    localActivityURIRequest.extra().putString("uinname", this.a.publicUin);
    localActivityURIRequest.extra().putString("uintype", this.a.publicUinName);
    localActivityURIRequest.setFlags(67108864);
    QRoute.startUri(localActivityURIRequest, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.2
 * JD-Core Version:    0.7.0.1
 */