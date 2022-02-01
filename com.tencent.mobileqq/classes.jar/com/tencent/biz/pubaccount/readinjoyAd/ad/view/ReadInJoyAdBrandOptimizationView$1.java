package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyAdBrandOptimizationView$1
  implements View.OnClickListener
{
  ReadInJoyAdBrandOptimizationView$1(ReadInJoyAdBrandOptimizationView paramReadInJoyAdBrandOptimizationView) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyAdUtils.a(ReadInJoyAdBrandOptimizationView.a(this.a), 1000, null);
    ReadinJoyActionUtil.a((Activity)ReadInJoyAdBrandOptimizationView.a(this.a), ReadInJoyAdBrandOptimizationView.a(this.a), ReadInJoyAdBrandOptimizationView.a(this.a).a(), ReadInJoyAdBrandOptimizationView.a(this.a).e(), false, ReadInJoyAdSwitchUtil.b(ReadInJoyAdBrandOptimizationView.a(this.a)), new AdJumpParams());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBrandOptimizationView.1
 * JD-Core Version:    0.7.0.1
 */