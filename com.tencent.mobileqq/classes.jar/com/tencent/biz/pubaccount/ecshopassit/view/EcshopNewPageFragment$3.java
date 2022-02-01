package com.tencent.biz.pubaccount.ecshopassit.view;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EcshopNewPageFragment$3
  implements View.OnClickListener
{
  EcshopNewPageFragment$3(EcshopNewPageFragment paramEcshopNewPageFragment) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.getActivity().finish();
      continue;
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.a.getActivity(), "/pubaccount/detail");
      localActivityURIRequest.extra().putString("uin", "3046055438");
      localActivityURIRequest.extra().putInt("source", 5);
      QRoute.startUri(localActivityURIRequest, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment.3
 * JD-Core Version:    0.7.0.1
 */