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
    long l = System.currentTimeMillis() - this.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("请求播放页（推荐)耗时：");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("毫秒");
    WSLog.a("weishi-beacon", ((StringBuilder)localObject).toString());
    WsBeaconReportPresenter.a().a(l, paramWeishiTask.g, "chat_page", this.b);
    if (!paramWeishiTask.b())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSVerticalDataManager.java][onTaskResponse] failed code:");
      ((StringBuilder)localObject).append(paramWeishiTask.d);
      ((StringBuilder)localObject).append(", msg:");
      ((StringBuilder)localObject).append(paramWeishiTask.c);
      WSLog.d("WSArkCardDataManagerLog", ((StringBuilder)localObject).toString());
      localObject = this.c;
      if (localObject != null) {
        ((IFetchDataRspListener)localObject).a(paramWeishiTask.d, paramWeishiTask.c, this.b, this.d);
      }
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.g, paramWeishiTask.d, paramWeishiTask.c);
      return;
    }
    if ((paramWeishiTask.m instanceof stGetPersonalFeedListRsp))
    {
      stGetPersonalFeedListRsp localstGetPersonalFeedListRsp = (stGetPersonalFeedListRsp)paramWeishiTask.m;
      localObject = new WSArkCardDataManager.ExtParams();
      if (this.b)
      {
        WSArkCardDataManager.a(this.e, localstGetPersonalFeedListRsp, this.c);
        WSArkCardDataManager.a(this.e, localstGetPersonalFeedListRsp, (WSArkCardDataManager.ExtParams)localObject);
      }
      WSArkCardDataManager.a(this.e, localstGetPersonalFeedListRsp.attach_info);
      WSArkCardDataManager.a(this.e, localstGetPersonalFeedListRsp.is_finished);
      ArrayList localArrayList = localstGetPersonalFeedListRsp.feeds;
      List localList = WSVerticalDataUtil.a(localArrayList, WSArkCardDataManager.a(this.e));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSVerticalDataManager.java][onTaskResponse] itemDataList size:");
      localStringBuilder.append(localList.size());
      localStringBuilder.append(", isFirst = ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", mAttachInfo = ");
      localStringBuilder.append(WSArkCardDataManager.b(this.e));
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
      if (paramWeishiTask.n != null) {
        WSRecommendReportManager.a().a(localstGetPersonalFeedListRsp.traceId, paramWeishiTask.n.a);
      }
      paramWeishiTask = this.c;
      if (paramWeishiTask != null) {
        paramWeishiTask.a(localList, this.d, this.b, localObject);
      }
    }
    else
    {
      WSLog.d("WSArkCardDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] task.mResultBean instanceof stSimpleGetFeedListRsp: false!");
      localObject = this.c;
      if (localObject != null) {
        ((IFetchDataRspListener)localObject).a(paramWeishiTask.e, paramWeishiTask.c, this.b, this.d);
      }
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.g, -1, "数据无法解析或为空");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSArkCardDataManager.1
 * JD-Core Version:    0.7.0.1
 */