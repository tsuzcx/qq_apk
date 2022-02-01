package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stSimpleGetFeedDetailRsp;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import java.util.ArrayList;
import java.util.List;

class WSVerticalForMsgFeedPresenter$1
  implements IWeishiServiceListener
{
  WSVerticalForMsgFeedPresenter$1(WSVerticalForMsgFeedPresenter paramWSVerticalForMsgFeedPresenter, long paramLong, IFetchDataRspListener paramIFetchDataRspListener) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    long l = System.currentTimeMillis() - this.a;
    WsBeaconReportPresenter.a().a(l, paramWeishiTask.g, "fullscreen_videoplay", true);
    Object localObject;
    if (!paramWeishiTask.b())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GetFeedDetailRequest onTaskResponse failed code:");
      ((StringBuilder)localObject).append(paramWeishiTask.d);
      ((StringBuilder)localObject).append(", msg:");
      ((StringBuilder)localObject).append(paramWeishiTask.c);
      WSLog.d("WSVerticalForMsgFeedPresenter", ((StringBuilder)localObject).toString());
      localObject = this.b;
      if (localObject != null) {
        ((IFetchDataRspListener)localObject).a(paramWeishiTask.d, paramWeishiTask.c, true, false);
      }
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.g, paramWeishiTask.d, paramWeishiTask.c);
      return;
    }
    if ((paramWeishiTask.m instanceof stSimpleGetFeedDetailRsp))
    {
      paramWeishiTask = ((stSimpleGetFeedDetailRsp)paramWeishiTask.m).feed;
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramWeishiTask);
      paramWeishiTask = WSVerticalDataUtil.a((List)localObject);
      localObject = this.b;
      if (localObject != null) {
        ((IFetchDataRspListener)localObject).a(paramWeishiTask, true, true, null);
      }
    }
    else
    {
      localObject = this.b;
      if (localObject != null) {
        ((IFetchDataRspListener)localObject).a(paramWeishiTask.e, paramWeishiTask.c, true, false);
      }
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.g, -1, "数据无法解析或为空");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForMsgFeedPresenter.1
 * JD-Core Version:    0.7.0.1
 */