package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADExposureManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class RIJOnScrollListener$1
  implements Runnable
{
  RIJOnScrollListener$1(RIJOnScrollListener paramRIJOnScrollListener) {}
  
  public void run()
  {
    if ((((ReadInjoyADExposureManager)RIJQQAppInterfaceUtil.b().getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER)).a(this.this$0.a.a().a(), (Activity)this.this$0.a.a().a())) && (this.this$0.a.a().a() != null)) {
      this.this$0.a.a().a().a(this.this$0.a.a().a(), (Activity)this.this$0.a.a().a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJOnScrollListener.1
 * JD-Core Version:    0.7.0.1
 */