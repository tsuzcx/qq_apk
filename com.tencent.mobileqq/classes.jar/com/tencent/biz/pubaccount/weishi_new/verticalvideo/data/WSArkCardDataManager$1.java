package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stGetPersonalFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
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
  WSArkCardDataManager$1(WSArkCardDataManager paramWSArkCardDataManager, long paramLong, boolean paramBoolean1, IFetchDataRspListener paramIFetchDataRspListener, boolean paramBoolean2) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("请求播放页（推荐)耗时：");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("毫秒");
    WSLog.a("weishi-beacon", ((StringBuilder)localObject).toString());
    WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, "chat_page", this.jdField_a_of_type_Boolean);
    if (!paramWeishiTask.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSVerticalDataManager.java][onTaskResponse] failed code:");
      ((StringBuilder)localObject).append(paramWeishiTask.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", msg:");
      ((StringBuilder)localObject).append(paramWeishiTask.jdField_a_of_type_JavaLangString);
      WSLog.d("WSArkCardDataManagerLog", ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener;
      if (localObject != null) {
        ((IFetchDataRspListener)localObject).a(paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
      }
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString);
      return;
    }
    if ((paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stGetPersonalFeedListRsp))
    {
      stGetPersonalFeedListRsp localstGetPersonalFeedListRsp = (stGetPersonalFeedListRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
      localObject = new WSArkCardDataManager.ExtParams();
      if (this.jdField_a_of_type_Boolean)
      {
        WSArkCardDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSArkCardDataManager, localstGetPersonalFeedListRsp, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener);
        WSArkCardDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSArkCardDataManager, localstGetPersonalFeedListRsp, (WSArkCardDataManager.ExtParams)localObject);
      }
      WSArkCardDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSArkCardDataManager, localstGetPersonalFeedListRsp.attach_info);
      WSArkCardDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSArkCardDataManager, localstGetPersonalFeedListRsp.is_finished);
      ArrayList localArrayList = localstGetPersonalFeedListRsp.feeds;
      List localList = WSVerticalDataUtil.a(localArrayList, WSArkCardDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSArkCardDataManager));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSVerticalDataManager.java][onTaskResponse] itemDataList size:");
      localStringBuilder.append(localList.size());
      localStringBuilder.append(", isFirst = ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(", mAttachInfo = ");
      localStringBuilder.append(WSArkCardDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSArkCardDataManager));
      localStringBuilder.append(", isFinish = ");
      localStringBuilder.append(localstGetPersonalFeedListRsp.is_finished);
      localStringBuilder.append(", size = ");
      int i;
      if (localArrayList != null) {
        i = localArrayList.size();
      } else {
        i = 0;
      }
      localStringBuilder.append(i);
      WSLog.e("WSArkCardDataManagerLog", localStringBuilder.toString());
      if (paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetRspHeaderBean != null) {
        WSRecommendReportManager.a().a(localstGetPersonalFeedListRsp.traceId, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetRspHeaderBean.a);
      }
      paramWeishiTask = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener;
      if (paramWeishiTask != null) {
        paramWeishiTask.a(localList, this.b, this.jdField_a_of_type_Boolean, localObject);
      }
    }
    else
    {
      WSLog.d("WSArkCardDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] task.mResultBean instanceof stSimpleGetFeedListRsp: false!");
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener;
      if (localObject != null) {
        ((IFetchDataRspListener)localObject).a(paramWeishiTask.b, paramWeishiTask.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
      }
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, -1, "数据无法解析或为空");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSArkCardDataManager.1
 * JD-Core Version:    0.7.0.1
 */