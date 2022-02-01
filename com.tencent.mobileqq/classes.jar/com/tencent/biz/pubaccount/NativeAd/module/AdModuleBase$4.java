package com.tencent.biz.pubaccount.NativeAd.module;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AdModuleBase$4
  implements View.OnClickListener
{
  AdModuleBase$4(AdModuleBase paramAdModuleBase) {}
  
  public void onClick(View paramView)
  {
    this.a.a.dismiss();
    AdModuleBase.c(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase.4
 * JD-Core Version:    0.7.0.1
 */