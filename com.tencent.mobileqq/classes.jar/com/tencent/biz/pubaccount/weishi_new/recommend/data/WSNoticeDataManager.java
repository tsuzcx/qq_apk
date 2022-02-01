package com.tencent.biz.pubaccount.weishi_new.recommend.data;

import UserGrowth.stNotificationRsp;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.report.WSRecommendReportManager;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.request.NotificationRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class WSNoticeDataManager
{
  private void a(WeishiTask paramWeishiTask, IWSNoticeRspListener paramIWSNoticeRspListener, long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[WSNoticeDataManager.java][handleOnTaskResponse] resultCode:");
    ((StringBuilder)localObject1).append(paramWeishiTask.e);
    ((StringBuilder)localObject1).append(", resultBean:");
    ((StringBuilder)localObject1).append(paramWeishiTask.m);
    ((StringBuilder)localObject1).append(", thread:");
    ((StringBuilder)localObject1).append(Thread.currentThread().getName());
    WSLog.e("WSNoticeDataManagerLog", ((StringBuilder)localObject1).toString());
    paramLong = System.currentTimeMillis() - paramLong;
    if (!paramWeishiTask.b())
    {
      WsBeaconReportPresenter.a().a(paramLong, paramWeishiTask.g, paramWeishiTask.d, paramWeishiTask.c);
      if (paramIWSNoticeRspListener != null) {
        paramIWSNoticeRspListener.a(paramWeishiTask.d, paramWeishiTask.c);
      }
      return;
    }
    if (!(paramWeishiTask.m instanceof stNotificationRsp))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[WSNoticeDataManager.java][handleOnTaskResponse] task.mResultBean instanceof stNotificationRsp: false! error:");
      ((StringBuilder)localObject1).append(paramWeishiTask.e);
      ((StringBuilder)localObject1).append(", errorMsg:");
      ((StringBuilder)localObject1).append(paramWeishiTask.c);
      WSLog.d("WSNoticeDataManagerLog", ((StringBuilder)localObject1).toString());
      WsBeaconReportPresenter.a().a(paramLong, paramWeishiTask.g, -1, "数据无法解析或为空");
      if (paramIWSNoticeRspListener != null) {
        paramIWSNoticeRspListener.a(paramWeishiTask.e, paramWeishiTask.c);
      }
      return;
    }
    WsBeaconReportPresenter.a().a(paramLong, paramWeishiTask.g, "feeds", true);
    localObject1 = (stNotificationRsp)paramWeishiTask.m;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[WSNoticeDataManager.java][handleOnTaskResponse] type:");
    ((StringBuilder)localObject2).append(((stNotificationRsp)localObject1).type);
    ((StringBuilder)localObject2).append(", text:");
    ((StringBuilder)localObject2).append(((stNotificationRsp)localObject1).text);
    ((StringBuilder)localObject2).append(", h5Url:");
    ((StringBuilder)localObject2).append(((stNotificationRsp)localObject1).h5Url);
    ((StringBuilder)localObject2).append(", schema:");
    ((StringBuilder)localObject2).append(((stNotificationRsp)localObject1).scheme_url);
    WSLog.e("WSNoticeDataManagerLog", ((StringBuilder)localObject2).toString());
    localObject2 = paramWeishiTask.n;
    if (localObject2 != null) {
      WSRecommendReportManager.a().a(((stNotificationRsp)localObject1).trace_id, ((RspHeaderBean)localObject2).a);
    }
    if (((stNotificationRsp)localObject1).type > 0)
    {
      if (paramIWSNoticeRspListener != null) {
        paramIWSNoticeRspListener.a((stNotificationRsp)localObject1, (RspHeaderBean)localObject2);
      }
    }
    else if (paramIWSNoticeRspListener != null) {
      paramIWSNoticeRspListener.a(paramWeishiTask.e, paramWeishiTask.c);
    }
  }
  
  public void a(String paramString, IWSNoticeRspListener paramIWSNoticeRspListener)
  {
    long l = System.currentTimeMillis();
    paramString = new WeishiTask(new NotificationRequest(paramString), null, new WSNoticeDataManager.1(this, paramIWSNoticeRspListener, l), 2001);
    WeishiBusinessLooper.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.data.WSNoticeDataManager
 * JD-Core Version:    0.7.0.1
 */