package com.tencent.biz.pubaccount.weishi_new.data;

import UserGrowth.stFollowFeedsRsp;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSRecommendReportManager;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;

class WSFeedDataManager$1
  implements IWeishiServiceListener
{
  WSFeedDataManager$1(WSFeedDataManager paramWSFeedDataManager, boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt, WSFeedDataManager.OnDataReceivedListener paramOnDataReceivedListener) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.b)) {}
    long l;
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = paramWeishiTask.a();
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      WSFeedDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSFeedDataManager, paramWeishiTask, l, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSFeedDataManager$OnDataReceivedListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSFeedDataManager$OnDataReceivedListener.a(this.jdField_a_of_type_Boolean, this.b, bool2, paramWeishiTask.jdField_a_of_type_JavaLangObject);
      }
      if (bool2) {
        break;
      }
      WSLog.d("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] task fail, code: " + paramWeishiTask.jdField_a_of_type_Int + ", msg: " + paramWeishiTask.jdField_a_of_type_JavaLangString);
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString);
      return;
    }
    if (!(paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stFollowFeedsRsp))
    {
      WSLog.d("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] data error: " + paramWeishiTask.jdField_a_of_type_JavaLangObject);
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, -1, "数据无法解析或为空");
      return;
    }
    stFollowFeedsRsp localstFollowFeedsRsp = (stFollowFeedsRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSFeedDataManager.jdField_a_of_type_JavaLangString = localstFollowFeedsRsp.attatch_info;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSFeedDataManager.jdField_a_of_type_Int = localstFollowFeedsRsp.cache_size;
    if (paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetRspHeaderBean != null) {
      WSRecommendReportManager.a().a(localstFollowFeedsRsp.trace_id, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetRspHeaderBean.a);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSFeedDataManager.b = localstFollowFeedsRsp.feeds_source;
      WSFollowBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSFeedDataManager.b);
    }
    if (WSFeedUtils.a(localstFollowFeedsRsp.feeds))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[WSFeedDataManager.java][onTaskResponse] data empty: ");
      if (localstFollowFeedsRsp.feeds == null) {}
      for (paramWeishiTask = "null";; paramWeishiTask = "size = 0")
      {
        WSLog.e("FollowRequest", paramWeishiTask);
        return;
      }
    }
    WSLog.e("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] data received, size: " + localstFollowFeedsRsp.feeds.size());
    WSFeedDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSFeedDataManager, localstFollowFeedsRsp.feeds, bool1, this.jdField_a_of_type_Int, localstFollowFeedsRsp.is_finished, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSFeedDataManager$OnDataReceivedListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager.1
 * JD-Core Version:    0.7.0.1
 */