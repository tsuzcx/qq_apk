package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stSimpleGetFeedDetailRsp;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import java.util.ArrayList;
import java.util.List;

class WSVerticalForMiniAppPresenter$1
  implements IWeishiServiceListener
{
  WSVerticalForMiniAppPresenter$1(WSVerticalForMiniAppPresenter paramWSVerticalForMiniAppPresenter, long paramLong, IFetchDataRspListener paramIFetchDataRspListener) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    long l = System.currentTimeMillis() - this.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("小程序播放页请求耗时：");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("毫秒");
    WSLog.a("weishi-beacon", ((StringBuilder)localObject).toString());
    WsBeaconReportPresenter.a().a(l, paramWeishiTask.g, "fullscreen_videoplay", true);
    if (!paramWeishiTask.b())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GetFeedDetailRequest onTaskResponse failed code:");
      ((StringBuilder)localObject).append(paramWeishiTask.d);
      ((StringBuilder)localObject).append(", msg:");
      ((StringBuilder)localObject).append(paramWeishiTask.c);
      WSLog.d("WSVerticalForMiniAppPresenter", ((StringBuilder)localObject).toString());
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
      localObject = WSVerticalDataUtil.a((List)localObject);
      WSVerticalPageContract.View localView = this.c.z();
      if ((localView != null) && (localView.b() != null) && (localView.b().b() != null))
      {
        this.c.a((WSVerticalItemData)localView.b().getItem(0), paramWeishiTask);
        paramWeishiTask = localView.b().b().c;
        if ((paramWeishiTask instanceof AbsWSVideoItemView)) {
          ((AbsWSVideoItemView)paramWeishiTask).b((WSVerticalItemData)((List)localObject).get(0));
        }
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
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForMiniAppPresenter.1
 * JD-Core Version:    0.7.0.1
 */