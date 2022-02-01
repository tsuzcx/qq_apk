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
    if ((!this.a) && (!this.b)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool2 = paramWeishiTask.b();
    long l = System.currentTimeMillis() - this.c;
    WSFeedDataManager.a(this.f, paramWeishiTask, l, this.d, this.a);
    Object localObject = this.e;
    if (localObject != null) {
      ((WSFeedDataManager.OnDataReceivedListener)localObject).a(this.a, this.b, bool2, paramWeishiTask.m);
    }
    if (!bool2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSFeedDataManager.java][onTaskResponse] task fail, code: ");
      ((StringBuilder)localObject).append(paramWeishiTask.d);
      ((StringBuilder)localObject).append(", msg: ");
      ((StringBuilder)localObject).append(paramWeishiTask.c);
      WSLog.d("FollowRequest", ((StringBuilder)localObject).toString());
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.g, paramWeishiTask.d, paramWeishiTask.c);
      return;
    }
    if (!(paramWeishiTask.m instanceof stFollowFeedsRsp))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSFeedDataManager.java][onTaskResponse] data error: ");
      ((StringBuilder)localObject).append(paramWeishiTask.m);
      WSLog.d("FollowRequest", ((StringBuilder)localObject).toString());
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.g, -1, "数据无法解析或为空");
      return;
    }
    stFollowFeedsRsp localstFollowFeedsRsp = (stFollowFeedsRsp)paramWeishiTask.m;
    this.f.c = localstFollowFeedsRsp.attatch_info;
    this.f.e = localstFollowFeedsRsp.cache_size;
    if (paramWeishiTask.n != null) {
      WSRecommendReportManager.a().a(localstFollowFeedsRsp.trace_id, paramWeishiTask.n.a);
    }
    if (this.a)
    {
      this.f.d = localstFollowFeedsRsp.feeds_source;
      WSFollowBeaconReport.a(this.f.d);
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
    WSFeedDataManager.a(this.f, localstFollowFeedsRsp.feeds, bool1, this.d, localstFollowFeedsRsp.is_finished, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager.1
 * JD-Core Version:    0.7.0.1
 */