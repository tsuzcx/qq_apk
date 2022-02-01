package com.tencent.biz.pubaccount.readinjoyAd.ad.handlers;

import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoyAnimBaseManager.OnRefreshPullDistanceListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADExposureManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class AdHandler$1
  implements ReadInJoyAnimBaseManager.OnRefreshPullDistanceListener
{
  AdHandler$1(AdHandler paramAdHandler, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (RIJQQAppInterfaceUtil.b() != null)
    {
      ReadInjoyADExposureManager localReadInjoyADExposureManager = (ReadInjoyADExposureManager)RIJQQAppInterfaceUtil.b().getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER);
      if (localReadInjoyADExposureManager != null) {
        localReadInjoyADExposureManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(), true, paramInt1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdHandler.1
 * JD-Core Version:    0.7.0.1
 */