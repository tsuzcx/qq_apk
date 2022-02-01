package com.tencent.biz.pubaccount.weishi_new.commercial;

import UserGrowth.stFeedOpInfo;
import UserGrowth.stGetFeedIconOpRsp;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.report.WSRecommendReportManager;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

class WSWidgetDataManager$1
  implements IWeishiServiceListener
{
  WSWidgetDataManager$1(WSWidgetDataManager paramWSWidgetDataManager, long paramLong, WSVerticalItemData paramWSVerticalItemData, WSWidgetDataManager.OnDataCallback paramOnDataCallback) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    WSLog.a("WSWidgetDataManager", "[onTaskResponse] success:" + paramWeishiTask.a());
    if ((!paramWeishiTask.a()) || (!(paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stGetFeedIconOpRsp))) {
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString);
    }
    do
    {
      return;
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, "", false);
      stGetFeedIconOpRsp localstGetFeedIconOpRsp = (stGetFeedIconOpRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
      stFeedOpInfo localstFeedOpInfo = localstGetFeedIconOpRsp.opInfo;
      paramWeishiTask = paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetRspHeaderBean;
      if ((paramWeishiTask != null) && (localstFeedOpInfo.iconType != 255) && (localstFeedOpInfo.iconType != 0)) {
        WSRecommendReportManager.a().a(localstFeedOpInfo.traceId, paramWeishiTask.a);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData.a().opInfo = localstFeedOpInfo;
      WSLog.a("WSWidgetDataManager", "[onTaskResponse] " + localstFeedOpInfo.toString());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData.a(WSWidgetDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSWidgetDataManager, localstGetFeedIconOpRsp));
    } while (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSWidgetDataManager$OnDataCallback == null);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSWidgetDataManager$OnDataCallback.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.commercial.WSWidgetDataManager.1
 * JD-Core Version:    0.7.0.1
 */