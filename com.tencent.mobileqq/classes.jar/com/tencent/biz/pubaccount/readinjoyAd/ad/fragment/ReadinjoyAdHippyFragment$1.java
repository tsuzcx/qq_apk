package com.tencent.biz.pubaccount.readinjoyAd.ad.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadinjoyAdHippyFragment$1
  implements View.OnClickListener
{
  ReadinjoyAdHippyFragment$1(ReadinjoyAdHippyFragment paramReadinjoyAdHippyFragment) {}
  
  public void onClick(View paramView)
  {
    ReadinjoyAdHippyFragment.a(this.a).d();
    ReadinjoyAdHippyFragment.a(this.a);
    ReadinjoyAdHippyFragment.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdHippyFragment.1
 * JD-Core Version:    0.7.0.1
 */