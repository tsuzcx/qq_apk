package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.mobileqq.qroute.QRoute;

class RIJVideoHandleClick$9$1
  implements Runnable
{
  RIJVideoHandleClick$9$1(RIJVideoHandleClick.9 param9, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void run()
  {
    String str = new VideoR5.Builder(null, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID).a((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID).N((int)RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick$9.a).a().a()).R(0).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008E28", "0X8008E28", 0, 0, "", "", "", str, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.9.1
 * JD-Core Version:    0.7.0.1
 */