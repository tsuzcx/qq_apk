package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher.ItemShowCallback;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;

class FastWebActivity$23
  implements ItemShowDispatcher.ItemShowCallback
{
  FastWebActivity$23(FastWebActivity paramFastWebActivity, BaseData paramBaseData) {}
  
  public int a()
  {
    return AdReqFreshManager.a().a();
  }
  
  public BaseData a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData;
  }
  
  public void a()
  {
    FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
  }
  
  public void b() {}
  
  public void c()
  {
    if (AdData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData))
    {
      AdData localAdData = (AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData;
      if (localAdData.a != null)
      {
        AdReqFreshManager.a().a(Long.valueOf(localAdData.a.mAdAid));
        AdExposeFreshManager.a().a("RIJAdRefreshSceneNativeArticle", localAdData.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.23
 * JD-Core Version:    0.7.0.1
 */