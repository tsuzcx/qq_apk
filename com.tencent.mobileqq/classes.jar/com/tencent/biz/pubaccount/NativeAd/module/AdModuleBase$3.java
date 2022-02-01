package com.tencent.biz.pubaccount.NativeAd.module;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AdModuleBase$3
  implements View.OnClickListener
{
  AdModuleBase$3(AdModuleBase paramAdModuleBase) {}
  
  public void onClick(View paramView)
  {
    this.a.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase.3
 * JD-Core Version:    0.7.0.1
 */