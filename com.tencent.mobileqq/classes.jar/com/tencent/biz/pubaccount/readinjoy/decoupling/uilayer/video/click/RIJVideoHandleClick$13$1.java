package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click;

import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoShareListener;

class RIJVideoHandleClick$13$1
  extends VideoShareListener
{
  RIJVideoHandleClick$13$1(RIJVideoHandleClick.13 param13, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramBoolean3)
    {
      if (paramBoolean4)
      {
        RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick$13.a).a().a().c();
        RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick$13.a).a().a().a(ReportConstants.VideoEndType.SLIDE_LEAVE);
      }
    }
    else
    {
      if (paramBoolean1) {
        break label145;
      }
      RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick$13.a).a().f(false);
    }
    for (;;)
    {
      if ((paramBoolean2) && (RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick$13.a).a().a() != null)) {
        RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick$13.a).a().a().a(2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, 0L);
      }
      return;
      RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick$13.a).a().a().b(2);
      break;
      label145:
      if (RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick$13.a).a().b())
      {
        RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick$13.a).a().a().c();
        RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick$13.a).a().f(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.13.1
 * JD-Core Version:    0.7.0.1
 */