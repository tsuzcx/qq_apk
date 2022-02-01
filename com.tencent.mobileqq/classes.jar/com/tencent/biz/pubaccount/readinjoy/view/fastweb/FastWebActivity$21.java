package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher.AdPostionReportManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher.ItemShowCallback;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;

class FastWebActivity$21
  implements ItemShowDispatcher.ItemShowCallback
{
  FastWebActivity$21(FastWebActivity paramFastWebActivity, int paramInt, BaseData paramBaseData) {}
  
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
    Object localObject = FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity).a(this.jdField_a_of_type_Int);
    if (localObject != null)
    {
      ReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.app, (AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, ((ItemShowDispatcher.AdPostionReportManager)localObject).jdField_a_of_type_Float, ((ItemShowDispatcher.AdPostionReportManager)localObject).jdField_a_of_type_Long, false);
      localObject = "bottomAd";
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.d) {
        break label125;
      }
      localObject = "innerAd";
    }
    for (;;)
    {
      ReadInJoyAdLog.a("REPORT_LINK", "onShow50percentOneSecond:on fast web ad expose report : type = " + (String)localObject + " title = " + ((AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData).b);
      return;
      NativeAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.app, (AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, false);
      break;
      label125:
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData instanceof RecommendAdData)) {
        localObject = "recommendAd";
      }
    }
  }
  
  public void b()
  {
    Object localObject = FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity).a(this.jdField_a_of_type_Int);
    if (localObject != null)
    {
      ReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.app, (AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, ((ItemShowDispatcher.AdPostionReportManager)localObject).jdField_a_of_type_Float, ((ItemShowDispatcher.AdPostionReportManager)localObject).jdField_a_of_type_Long, true);
      localObject = "bottomAd";
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.d) {
        break label125;
      }
      localObject = "innerAd";
    }
    for (;;)
    {
      ReadInJoyAdLog.a("REPORT_LINK", "onShow1percent:on fast web ad expose report : type = " + (String)localObject + " title = " + ((AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData).b);
      return;
      NativeAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.app, (AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, true);
      break;
      label125:
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData instanceof RecommendAdData)) {
        localObject = "recommendAd";
      }
    }
  }
  
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.21
 * JD-Core Version:    0.7.0.1
 */