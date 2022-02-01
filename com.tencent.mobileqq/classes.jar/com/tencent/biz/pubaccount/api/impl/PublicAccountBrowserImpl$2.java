package com.tencent.biz.pubaccount.api.impl;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;

class PublicAccountBrowserImpl$2
  implements View.OnClickListener
{
  PublicAccountBrowserImpl$2(PublicAccountBrowserImpl paramPublicAccountBrowserImpl) {}
  
  public void onClick(View paramView)
  {
    paramView = new ActivityURIRequest(this.a.getApplicationContext(), "/pubaccount/detail");
    paramView.extra().putString("uin", this.a.publicUin);
    paramView.extra().putString("uinname", this.a.publicUin);
    paramView.extra().putString("uintype", this.a.publicUinName);
    paramView.setFlags(67108864);
    QRoute.startUri(paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.2
 * JD-Core Version:    0.7.0.1
 */