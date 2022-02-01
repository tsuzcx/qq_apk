package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuBehaviour;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.report.RIJVideoReportManager;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule.UserLevelCallBack;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelRequestModule.UserLevelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

class RIJVideoHandleClick$6$1
  implements RIJUserLevelModule.UserLevelCallBack
{
  RIJVideoHandleClick$6$1(RIJVideoHandleClick.6 param6, BaseArticleInfo paramBaseArticleInfo, View paramView) {}
  
  public void a(RIJUserLevelRequestModule.UserLevelInfo paramUserLevelInfo)
  {
    boolean bool = true;
    if (BiuBehaviour.a() == 1) {}
    for (;;)
    {
      RIJVideoReportManager.a(false, bool, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (Activity)RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick$6.a).a().a(), RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick$6.a).a().b(), RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick$6.a).a().a(), RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick$6.a).a().a());
      VideoHandler.a(this.jdField_a_of_type_AndroidViewView);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.6.1
 * JD-Core Version:    0.7.0.1
 */