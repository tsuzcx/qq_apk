package com.tencent.biz.pubaccount.NativeAd.fragment;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyNativeAdFragment$10
  implements View.OnClickListener
{
  ReadInJoyNativeAdFragment$10(ReadInJoyNativeAdFragment paramReadInJoyNativeAdFragment) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyNativeAdFragment.a(this.a).dismiss();
    ReadInJoyNativeAdFragment.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment.10
 * JD-Core Version:    0.7.0.1
 */