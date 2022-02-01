package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyViolaChannelFragment$1
  implements View.OnClickListener
{
  ReadInJoyViolaChannelFragment$1(ReadInJoyViolaChannelFragment paramReadInJoyViolaChannelFragment) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyViolaChannelFragment.a(this.a).d();
    ReadInJoyViolaChannelFragment.a(this.a);
    ReadInJoyViolaChannelFragment.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment.1
 * JD-Core Version:    0.7.0.1
 */