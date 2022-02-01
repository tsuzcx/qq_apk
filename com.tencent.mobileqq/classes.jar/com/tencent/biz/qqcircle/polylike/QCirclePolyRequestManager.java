package com.tencent.biz.qqcircle.polylike;

import android.view.View;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.event.QCircleFuelAnimationEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoLikeRsp;
import java.lang.ref.WeakReference;
import qqcircle.QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData;
import qqcircle.QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiRspData;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;
import qqcircle.QQCircleFeedBase.StRewardData;

public class QCirclePolyRequestManager
  implements ReportBean<QCircleReportBean>
{
  private static String a = "QCirclePolyRequestManager";
  private volatile boolean b = true;
  private volatile boolean c = false;
  private QCircleExtraTypeInfo d;
  private ReportBean<QCircleReportBean> e;
  private QCircleReportBean f;
  private WeakReference<View> g;
  private WeakReference<QCirclePolyLikeAniView> h;
  private WeakReference<View> i;
  
  private void a(int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(paramQCircleExtraTypeInfo.mFeed.poster.id.get()).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setPageId(b()).setfpageid(c()));
      return;
    }
    paramQCircleExtraTypeInfo = new StringBuilder();
    paramQCircleExtraTypeInfo.append("QCircleReportHelper_");
    paramQCircleExtraTypeInfo.append(a);
    paramQCircleExtraTypeInfo = paramQCircleExtraTypeInfo.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("extraTypeInfo is null or lost feed,actionType:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",subActionType:");
    localStringBuilder.append(paramInt2);
    QLog.e(paramQCircleExtraTypeInfo, 1, localStringBuilder.toString());
  }
  
  private void a(int paramInt, FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramInt == 0)
    {
      f();
      return;
    }
    if (paramInt == 1)
    {
      e();
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFuelAnimationEvent());
      return;
    }
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StPolyLike paramStPolyLike1, QQCircleFeedBase.StPolyLike paramStPolyLike2, int paramInt, boolean paramBoolean)
  {
    this.c = false;
    this.b = false;
    FeedCloudMeta.StLike localStLike = QCirclePluginUtil.a(paramStFeed.likeInfo);
    QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData localStDoLikeReqDoPolyLikeBusiReqData = new QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData();
    localStDoLikeReqDoPolyLikeBusiReqData.polyLikeInfo.set(paramStPolyLike2);
    if ((paramStPolyLike2.articleType.get() != 0) || (paramStPolyLike1.articleType.get() != 1)) {
      localStDoLikeReqDoPolyLikeBusiReqData.curPolyLikeInfo.set(paramStPolyLike1);
    }
    VSNetworkHelper.getInstance().sendRequest(new QCircleDoLikeRequest(paramStFeed, paramInt, localStLike, localStDoLikeReqDoPolyLikeBusiReqData, g(), paramBoolean), new QCirclePolyRequestManager.3(this, paramInt, paramStFeed, paramStPolyLike1, paramStPolyLike2));
  }
  
  private void a(FeedCloudWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    if (paramStDoLikeRsp != null)
    {
      QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiRspData localStDoLikeReqDoPolyLikeBusiRspData = new QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiRspData();
      try
      {
        localStDoLikeReqDoPolyLikeBusiRspData.mergeFrom(paramStDoLikeRsp.busiRspData.get().toByteArray());
        if (localStDoLikeReqDoPolyLikeBusiRspData.rewardData.myMoney.get() >= 0L)
        {
          QCirclePolyLikeInfoManger.a().a((float)localStDoLikeReqDoPolyLikeBusiRspData.rewardData.myMoney.get());
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramStDoLikeRsp)
      {
        paramStDoLikeRsp.printStackTrace();
      }
    }
  }
  
  private void e()
  {
    if (g())
    {
      a(36, 3, this.d);
      return;
    }
    Object localObject1 = this.d;
    if (localObject1 != null) {
      localObject1 = ((QCircleExtraTypeInfo)localObject1).mFeed;
    } else {
      localObject1 = null;
    }
    Object localObject2 = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject1).setActionType(36).setSubActionType(3);
    localObject1 = this.d;
    if ((localObject1 != null) && (((QCircleExtraTypeInfo)localObject1).mFeed != null)) {
      localObject1 = this.d.mFeed.poster.id.get();
    } else {
      localObject1 = "";
    }
    localObject1 = ((QCircleLpReportDc05501.DataBuilder)localObject2).setToUin((String)localObject1);
    localObject2 = this.d;
    int j;
    if (localObject2 != null) {
      j = ((QCircleExtraTypeInfo)localObject2).mDataPosition;
    } else {
      j = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject1).setIndex(j).setPageId(b())));
  }
  
  private void f()
  {
    if (g())
    {
      a(39, 2, this.d);
      return;
    }
    Object localObject1 = this.d;
    if (localObject1 != null) {
      localObject1 = ((QCircleExtraTypeInfo)localObject1).mFeed;
    } else {
      localObject1 = null;
    }
    Object localObject2 = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject1).setActionType(39).setSubActionType(2);
    localObject1 = this.d;
    if ((localObject1 != null) && (((QCircleExtraTypeInfo)localObject1).mFeed != null)) {
      localObject1 = this.d.mFeed.poster.id.get();
    } else {
      localObject1 = "";
    }
    localObject1 = ((QCircleLpReportDc05501.DataBuilder)localObject2).setToUin((String)localObject1);
    localObject2 = this.d;
    int j;
    if (localObject2 != null) {
      j = ((QCircleExtraTypeInfo)localObject2).mDataPosition;
    } else {
      j = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject1).setIndex(j).setPageId(b())));
  }
  
  private boolean g()
  {
    return QCircleReportBean.isContentDetailPage(b());
  }
  
  public QCircleReportBean a()
  {
    return QCircleReportBean.getReportBean(a, this.f);
  }
  
  public void a(QCircleExtraTypeInfo paramQCircleExtraTypeInfo, View paramView1, View paramView2, QCirclePolyLikeAniView paramQCirclePolyLikeAniView)
  {
    this.d = paramQCircleExtraTypeInfo;
    this.g = new WeakReference(paramView1);
    this.h = new WeakReference(paramQCirclePolyLikeAniView);
    this.i = new WeakReference(paramView2);
  }
  
  public void a(ReportBean<QCircleReportBean> paramReportBean)
  {
    this.e = paramReportBean;
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.f = QCircleReportBean.setReportBean(a, paramQCircleReportBean);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt, QQCircleFeedBase.StPolyLike paramStPolyLike1, QQCircleFeedBase.StPolyLike paramStPolyLike2)
  {
    QQCircleFeedBase.StLikeBusiData localStLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
    Object localObject1;
    try
    {
      localObject1 = new QQCircleFeedBase.StLikeBusiData();
      try
      {
        ((QQCircleFeedBase.StLikeBusiData)localObject1).mergeFrom(paramStFeed.likeInfo.busiData.get().toByteArray());
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1) {}
      Object localObject2;
      localObject2.printStackTrace();
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
    {
      localObject1 = localInvalidProtocolBufferMicroException1;
      localObject2 = localInvalidProtocolBufferMicroException2;
    }
    int k = paramStFeed.likeInfo.count.get();
    if (paramInt == 21) {}
    int j;
    do
    {
      j = k + 1;
      break;
      j = k;
      if (paramInt != 1) {
        break;
      }
      j = k;
    } while (!QCirclePluginUtil.a(paramStPolyLike2, (QQCircleFeedBase.StLikeBusiData)localObject1));
    paramStFeed.likeInfo.count.set(j);
    paramStFeed.likeInfo.status.set(paramInt);
    SimpleEventBus.getInstance().dispatchEvent(new QCirclePolyPraiseUpdateEvent(paramStFeed.id.get(), paramStPolyLike1, paramStPolyLike2, paramInt, j));
    QCircleFeedDataCenter.a().a(new FeedBlockData(paramStFeed), true);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    if (!HostNetworkUtils.isNetworkAvailable())
    {
      QCircleToast.a(HardCodeUtil.a(2131892107), 0);
      return;
    }
    if (!this.b) {
      return;
    }
    int j;
    boolean bool;
    try
    {
      localObject = new QQCircleFeedBase.StLikeBusiData();
      ((QQCircleFeedBase.StLikeBusiData)localObject).mergeFrom(paramStFeed.likeInfo.busiData.get().toByteArray());
      localObject = ((QQCircleFeedBase.StLikeBusiData)localObject).curPolyLikeInfo;
      if (paramStPolyLike.articleType.get() == 0)
      {
        j = 1;
      }
      else
      {
        if (paramStPolyLike.articleType.get() != 1) {
          break label199;
        }
        j = 21;
        bool = true;
        a(paramStFeed, (QQCircleFeedBase.StPolyLike)localObject, paramStPolyLike, j, bool);
        paramStPolyLike = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" request type:");
        ((StringBuilder)localObject).append(j);
        QLog.d(paramStPolyLike, 4, ((StringBuilder)localObject).toString());
        a(j, paramStFeed);
        return;
      }
    }
    catch (Exception paramStFeed)
    {
      paramStPolyLike = a;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" request type:");
      ((StringBuilder)localObject).append(paramStFeed);
      QLog.d(paramStPolyLike, 4, ((StringBuilder)localObject).toString());
      return;
    }
    for (;;)
    {
      bool = false;
      break;
      label199:
      j = -1;
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StPolyLike paramStPolyLike, int paramInt)
  {
    ((QCirclePolyLikeAniView)this.h.get()).a(paramStPolyLike, (View)this.g.get(), (View)this.i.get(), g(), new QCirclePolyRequestManager.2(this, paramStFeed, paramInt, paramStPolyLike), true);
  }
  
  public void a(QQCircleFeedBase.StPolyLike paramStPolyLike1, View paramView, int paramInt, int[] paramArrayOfInt, FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StPolyLike paramStPolyLike2)
  {
    ((QCirclePolyLikeAniView)this.h.get()).a(paramStPolyLike1, paramView, (View)this.g.get(), (View)this.i.get(), paramArrayOfInt, g(), new QCirclePolyRequestManager.1(this, paramStFeed, paramInt, paramStPolyLike2, paramStPolyLike1));
  }
  
  protected int b()
  {
    Object localObject = this.f;
    if (localObject != null) {
      return QCircleReportBean.getPageId(a, (QCircleReportBean)localObject);
    }
    localObject = this.e;
    if (localObject != null) {
      return QCircleReportBean.getPageId(a, (QCircleReportBean)((ReportBean)localObject).getReportBean());
    }
    return 0;
  }
  
  protected int c()
  {
    Object localObject = this.f;
    if (localObject != null) {
      return QCircleReportBean.getParentPageId(a, (QCircleReportBean)localObject);
    }
    localObject = this.e;
    if (localObject != null) {
      return QCircleReportBean.getParentPageId(a, (QCircleReportBean)((ReportBean)localObject).getReportBean());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyRequestManager
 * JD-Core Version:    0.7.0.1
 */