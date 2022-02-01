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
    boolean bool1;
    if ((!this.jdField_a_of_type_Boolean) && (!this.b)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool2 = paramWeishiTask.a();
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    WSFeedDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSFeedDataManager, paramWeishiTask, l, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSFeedDataManager$OnDataReceivedListener;
    if (localObject != null) {
      ((WSFeedDataManager.OnDataReceivedListener)localObject).a(this.jdField_a_of_type_Boolean, this.b, bool2, paramWeishiTask.jdField_a_of_type_JavaLangObject);
    }
    if (!bool2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSFeedDataManager.java][onTaskResponse] task fail, code: ");
      ((StringBuilder)localObject).append(paramWeishiTask.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", msg: ");
      ((StringBuilder)localObject).append(paramWeishiTask.jdField_a_of_type_JavaLangString);
      WSLog.d("FollowRequest", ((StringBuilder)localObject).toString());
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString);
      return;
    }
    if (!(paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stFollowFeedsRsp))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSFeedDataManager.java][onTaskResponse] data error: ");
      ((StringBuilder)localObject).append(paramWeishiTask.jdField_a_of_type_JavaLangObject);
      WSLog.d("FollowRequest", ((StringBuilder)localObject).toString());
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSFeedDataManager.java][onTaskResponse] data empty: ");
      if (localstFollowFeedsRsp.feeds == null) {
        paramWeishiTask = "null";
      } else {
        paramWeishiTask = "size = 0";
      }
      ((StringBuilder)localObject).append(paramWeishiTask);
      WSLog.e("FollowRequest", ((StringBuilder)localObject).toString());
      return;
    }
    paramWeishiTask = new StringBuilder();
    paramWeishiTask.append("[WSFeedDataManager.java][onTaskResponse] data received, size: ");
    paramWeishiTask.append(localstFollowFeedsRsp.feeds.size());
    WSLog.e("FollowRequest", paramWeishiTask.toString());
    WSFeedDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSFeedDataManager, localstFollowFeedsRsp.feeds, bool1, this.jdField_a_of_type_Int, localstFollowFeedsRsp.is_finished, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSFeedDataManager$OnDataReceivedListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager.1
 * JD-Core Version:    0.7.0.1
 */