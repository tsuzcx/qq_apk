package com.tencent.biz.pubaccount.readinjoy.viola;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ViolaFragment$5
  implements View.OnClickListener
{
  ViolaFragment$5(ViolaFragment paramViolaFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.mViolaUiDelegate.d();
    this.a.reloadPage();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment.5
 * JD-Core Version:    0.7.0.1
 */