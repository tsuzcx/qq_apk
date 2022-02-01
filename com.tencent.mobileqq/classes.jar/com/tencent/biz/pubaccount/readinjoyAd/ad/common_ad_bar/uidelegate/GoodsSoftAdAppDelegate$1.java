package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GoodsSoftAdAppDelegate$1
  implements View.OnClickListener
{
  GoodsSoftAdAppDelegate$1(GoodsSoftAdAppDelegate paramGoodsSoftAdAppDelegate) {}
  
  public void onClick(View paramView)
  {
    GoodsSoftAdAppDelegate.a(this.a, AdClickPos.SoftAdComponent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GoodsSoftAdAppDelegate.1
 * JD-Core Version:    0.7.0.1
 */