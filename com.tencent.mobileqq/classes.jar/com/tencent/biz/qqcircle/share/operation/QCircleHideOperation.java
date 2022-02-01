package com.tencent.biz.qqcircle.share.operation;

import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.requests.QCircleSetUnCareRequest;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation.Builder;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleRight.SetCircleUnCareRsp;

public class QCircleHideOperation
  extends QCircleBaseShareOperation
{
  public QCircleHideOperation(QCircleBaseShareOperation.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(paramStFeed.id.get(), 3));
    if (s() == 4)
    {
      b(paramStFeed.poster.id.get());
      return;
    }
    w();
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed)
  {
    int i;
    if (f().c != null) {
      i = f().c.mDataPosition;
    } else {
      i = -1;
    }
    paramStFeed = QCirclePluginReportUtil.b(paramStFeed).setToUin(paramStFeed.poster.id.get()).setActionType(65).setSubActionType(s()).setIndex(i).setExt3(String.valueOf(paramStFeed.createTime));
    if (a(57)) {
      i = h();
    } else {
      i = g();
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(paramStFeed.setPageId(i)));
    a("hidden", null);
  }
  
  private void b(String paramString)
  {
    VSDispatchObserver.onVSRspCallBack localonVSRspCallBack = u();
    VSNetworkHelper.getInstance().sendRequest(new QCircleSetUnCareRequest(paramString, 1, 0, null), localonVSRspCallBack);
  }
  
  private VSDispatchObserver.onVSRspCallBack<QQCircleRight.SetCircleUnCareRsp> u()
  {
    return new QCircleHideOperation.1(this);
  }
  
  private void v()
  {
    QCircleToast.a(QCircleToast.c, 2131895815, 0);
  }
  
  private void w()
  {
    if (t()) {
      QCircleToast.a(QCircleToast.d, 2131895690, 0);
    }
  }
  
  private FeedCloudMeta.StFeed x()
  {
    if (f().b.isRecomFd.get())
    {
      FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
      localStFeed.id.set(f().b.recomForward.id.get());
      localStFeed.poster.set(f().b.recomForward.poster.get());
      return localStFeed;
    }
    return f().b;
  }
  
  public void a()
  {
    if ((f() != null) && (f().b != null) && (i() != null))
    {
      FeedCloudMeta.StFeed localStFeed = x();
      b(localStFeed);
      a(localStFeed);
      return;
    }
    a("QCircleHideShare");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.operation.QCircleHideOperation
 * JD-Core Version:    0.7.0.1
 */