package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuBehaviour;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.report.RIJVideoReportManager;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule.UserLevelCallBack;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelRequestModule.UserLevelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

class RIJVideoHandleClick$3
  implements RIJUserLevelModule.UserLevelCallBack
{
  RIJVideoHandleClick$3(RIJVideoHandleClick paramRIJVideoHandleClick, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void a(RIJUserLevelRequestModule.UserLevelInfo paramUserLevelInfo)
  {
    if (BiuBehaviour.b() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      RIJVideoReportManager.a(true, bool, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (Activity)RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick).a().a(), RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick).a().b(), RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick).a().a(), RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick).a().a());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.3
 * JD-Core Version:    0.7.0.1
 */