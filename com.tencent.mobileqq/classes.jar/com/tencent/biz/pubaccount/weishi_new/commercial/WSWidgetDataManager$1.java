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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onTaskResponse] success:");
    ((StringBuilder)localObject).append(paramWeishiTask.a());
    WSLog.a("WSWidgetDataManager", ((StringBuilder)localObject).toString());
    if ((paramWeishiTask.a()) && ((paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stGetFeedIconOpRsp)))
    {
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, "", false);
      localObject = (stGetFeedIconOpRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
      stFeedOpInfo localstFeedOpInfo = ((stGetFeedIconOpRsp)localObject).opInfo;
      paramWeishiTask = paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetRspHeaderBean;
      if ((paramWeishiTask != null) && (localstFeedOpInfo.iconType != 255) && (localstFeedOpInfo.iconType != 0)) {
        WSRecommendReportManager.a().a(localstFeedOpInfo.traceId, paramWeishiTask.a);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData.a().opInfo = localstFeedOpInfo;
      paramWeishiTask = new StringBuilder();
      paramWeishiTask.append("[onTaskResponse] ");
      paramWeishiTask.append(localstFeedOpInfo.toString());
      WSLog.a("WSWidgetDataManager", paramWeishiTask.toString());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData.a(WSWidgetDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSWidgetDataManager, (stGetFeedIconOpRsp)localObject));
      paramWeishiTask = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSWidgetDataManager$OnDataCallback;
      if (paramWeishiTask != null) {
        paramWeishiTask.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData);
      }
      return;
    }
    WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.commercial.WSWidgetDataManager.1
 * JD-Core Version:    0.7.0.1
 */