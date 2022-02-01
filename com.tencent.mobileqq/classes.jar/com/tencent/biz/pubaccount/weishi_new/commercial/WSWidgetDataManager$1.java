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
    long l = System.currentTimeMillis() - this.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onTaskResponse] success:");
    ((StringBuilder)localObject).append(paramWeishiTask.b());
    WSLog.a("WSWidgetDataManager", ((StringBuilder)localObject).toString());
    if ((paramWeishiTask.b()) && ((paramWeishiTask.m instanceof stGetFeedIconOpRsp)))
    {
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.g, "", false);
      localObject = (stGetFeedIconOpRsp)paramWeishiTask.m;
      stFeedOpInfo localstFeedOpInfo = ((stGetFeedIconOpRsp)localObject).opInfo;
      paramWeishiTask = paramWeishiTask.n;
      if ((paramWeishiTask != null) && (localstFeedOpInfo.iconType != 255) && (localstFeedOpInfo.iconType != 0)) {
        WSRecommendReportManager.a().a(localstFeedOpInfo.traceId, paramWeishiTask.a);
      }
      this.b.b().opInfo = localstFeedOpInfo;
      paramWeishiTask = new StringBuilder();
      paramWeishiTask.append("[onTaskResponse] ");
      paramWeishiTask.append(localstFeedOpInfo.toString());
      WSLog.a("WSWidgetDataManager", paramWeishiTask.toString());
      this.b.a(WSWidgetDataManager.a(this.d, (stGetFeedIconOpRsp)localObject));
      paramWeishiTask = this.c;
      if (paramWeishiTask != null) {
        paramWeishiTask.a(this.b);
      }
      return;
    }
    WsBeaconReportPresenter.a().a(l, paramWeishiTask.g, paramWeishiTask.d, paramWeishiTask.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.commercial.WSWidgetDataManager.1
 * JD-Core Version:    0.7.0.1
 */