package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoyAdBrandOptimizationView$1
  implements View.OnClickListener
{
  ReadInJoyAdBrandOptimizationView$1(ReadInJoyAdBrandOptimizationView paramReadInJoyAdBrandOptimizationView) {}
  
  public void onClick(View paramView)
  {
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(ReadInJoyAdBrandOptimizationView.a(this.a), 1000, null);
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).doActionAndReport((Activity)ReadInJoyAdBrandOptimizationView.b(this.a), ReadInJoyAdBrandOptimizationView.a(this.a), ReadInJoyAdBrandOptimizationView.c(this.a).u(), ReadInJoyAdBrandOptimizationView.c(this.a).m(), false, ReadInJoyAdSwitchUtil.e(ReadInJoyAdBrandOptimizationView.a(this.a)), new AdJumpParams());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBrandOptimizationView.1
 * JD-Core Version:    0.7.0.1
 */