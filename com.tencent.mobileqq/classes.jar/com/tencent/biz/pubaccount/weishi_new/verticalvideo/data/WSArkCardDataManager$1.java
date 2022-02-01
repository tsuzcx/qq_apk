package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stGetPersonalFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.report.WSRecommendReportManager;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;
import java.util.List;

class WSArkCardDataManager$1
  implements IWeishiServiceListener
{
  WSArkCardDataManager$1(WSArkCardDataManager paramWSArkCardDataManager, long paramLong, boolean paramBoolean1, IVerticalRspListener paramIVerticalRspListener, boolean paramBoolean2) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    WSLog.a("weishi-beacon", "请求播放页（推荐)耗时：" + l + "毫秒");
    WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, "chat_page", this.jdField_a_of_type_Boolean);
    if (!paramWeishiTask.a())
    {
      WSLog.d("WSArkCardDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] failed code:" + paramWeishiTask.jdField_a_of_type_Int + ", msg:" + paramWeishiTask.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener.a(paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
      }
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString);
      return;
    }
    if ((paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stGetPersonalFeedListRsp))
    {
      stGetPersonalFeedListRsp localstGetPersonalFeedListRsp = (stGetPersonalFeedListRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
      WSArkCardDataManager.ExtParams localExtParams = new WSArkCardDataManager.ExtParams();
      if (this.jdField_a_of_type_Boolean)
      {
        WSArkCardDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSArkCardDataManager, localstGetPersonalFeedListRsp, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener);
        WSArkCardDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSArkCardDataManager, localstGetPersonalFeedListRsp, localExtParams);
      }
      WSArkCardDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSArkCardDataManager, localstGetPersonalFeedListRsp.attach_info);
      WSArkCardDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSArkCardDataManager, localstGetPersonalFeedListRsp.is_finished);
      ArrayList localArrayList = localstGetPersonalFeedListRsp.feeds;
      List localList = WSVerticalDataUtil.a(localArrayList, WSArkCardDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSArkCardDataManager));
      StringBuilder localStringBuilder = new StringBuilder().append("[WSVerticalDataManager.java][onTaskResponse] itemDataList size:").append(localList.size()).append(", isFirst = ").append(this.jdField_a_of_type_Boolean).append(", mAttachInfo = ").append(WSArkCardDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSArkCardDataManager)).append(", isFinish = ").append(localstGetPersonalFeedListRsp.is_finished).append(", size = ");
      if (localArrayList != null) {}
      for (int i = localArrayList.size();; i = 0)
      {
        WSLog.e("WSArkCardDataManagerLog", i);
        if (paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetRspHeaderBean != null) {
          WSRecommendReportManager.a().a(localstGetPersonalFeedListRsp.traceId, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetRspHeaderBean.a);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener.a(localList, this.b, this.jdField_a_of_type_Boolean, localExtParams);
        return;
      }
    }
    WSLog.d("WSArkCardDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] task.mResultBean instanceof stSimpleGetFeedListRsp: false!");
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener.a(paramWeishiTask.b, paramWeishiTask.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
    }
    WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, -1, "数据无法解析或为空");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSArkCardDataManager.1
 * JD-Core Version:    0.7.0.1
 */