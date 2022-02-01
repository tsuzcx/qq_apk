package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.events.QCircleDoublePraiseAnimationEvent;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeManager;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase.StLikeBusiData;

public class QCircleDoublePraiseView
  extends FrameLayout
  implements ReportBean<QCircleReportBean>, SimpleEventReceiver
{
  private boolean a = false;
  private AnimationSet b;
  private FeedCloudMeta.StFeed c;
  private int d;
  private ImageView e;
  private int f;
  private QCircleReportBean g;
  private int h;
  private boolean i = false;
  private ViewGroup j;
  private QCircleDoublePraiseView.IAnimationEndHandler k;
  
  public QCircleDoublePraiseView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleDoublePraiseView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleDoublePraiseView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  public QCircleDoublePraiseView(Context paramContext, @Nullable AttributeSet paramAttributeSet, ViewGroup paramViewGroup)
  {
    this(paramContext, null);
    this.j = paramViewGroup;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if (((FeedCloudMeta.StFeed)localObject).likeInfo == null) {
        return;
      }
      this.c.likeInfo.count.set(paramInt2);
      new QQCircleFeedBase.StLikeBusiData();
      try
      {
        localObject = new QQCircleFeedBase.StLikeBusiData();
        ((QQCircleFeedBase.StLikeBusiData)localObject).mergeFrom(this.c.likeInfo.busiData.get().toByteArray());
        if (paramInt1 == 0)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = ((QQCircleFeedBase.StLikeBusiData)localObject).likeIDs.get().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if ((TextUtils.equals(str, "206008")) || (TextUtils.equals(str, "205993"))) {
              localArrayList.add(str);
            }
          }
          ((QQCircleFeedBase.StLikeBusiData)localObject).likeIDs.set(localArrayList);
        }
        else
        {
          if (((QQCircleFeedBase.StLikeBusiData)localObject).likeIDs.get().contains("6")) {
            return;
          }
          ((QQCircleFeedBase.StLikeBusiData)localObject).likeIDs.add("6");
        }
        this.c.likeInfo.busiData.set(ByteStringMicro.copyFrom(((QQCircleFeedBase.StLikeBusiData)localObject).toByteArray()));
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
  
  private void b()
  {
    LayoutInflater.from(getContext()).inflate(2131626984, this);
    this.e = ((ImageView)findViewById(2131441610));
  }
  
  private void c()
  {
    Object localObject = this.c;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (FeedCloudMeta.StLike)((FeedCloudMeta.StFeed)localObject).likeInfo.get();
    }
    if (localObject == null)
    {
      QLog.d("QCircleDoublePraiseView", 1, "[doLike] like obj is null.");
      return;
    }
    if (((FeedCloudMeta.StLike)localObject).status.get() == 1)
    {
      QLog.d("QCircleDoublePraiseView", 1, "[doLike] current is like status.");
      return;
    }
    QCirclePolyLikeManager.a(this.c, true);
  }
  
  private void d()
  {
    if (e())
    {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(this.c)).setActionType(69).setSubActionType(2).setPosition(this.f).setPlayScene(2).setPageId(getPageId()).setfpageid(getParentPageId()));
      return;
    }
    FeedCloudMeta.StFeed localStFeed = this.c;
    if (localStFeed != null) {
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(localStFeed).setToUin(this.c.poster.id.get())).setActionType(69).setSubActionType(2).setIndex(this.f).setPageId(getPageId()));
    }
  }
  
  private boolean e()
  {
    return QCircleReportBean.isContentDetailPage(getPageId());
  }
  
  private void setUpOpenCancelLike(FeedCloudMeta.StFeed paramStFeed)
  {
    this.i = QCirclePolyLikeManager.c(paramStFeed);
  }
  
  public void a()
  {
    if (this.a)
    {
      QLog.d("QCircleDoublePraiseView", 1, "mIsInAnimation");
      return;
    }
    this.b = ((AnimationSet)AnimationUtils.loadAnimation(getContext(), 2130772330));
    this.b.setAnimationListener(new QCircleDoublePraiseView.1(this));
    this.e.setVisibility(0);
    this.e.startAnimation(this.b);
    c();
    d();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleDoublePraiseAnimationEvent.class);
    localArrayList.add(QCirclePolyPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  protected int getPageId()
  {
    return QCircleReportBean.getPageId("QCircleDoublePraiseView", this.g);
  }
  
  protected int getParentPageId()
  {
    return QCircleReportBean.getParentPageId("QCircleDoublePraiseView", this.g);
  }
  
  public QCircleReportBean getReportBean()
  {
    return QCircleReportBean.getReportBean("QCircleDoublePraiseView", this.g);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
    QLog.d("QCircleDoublePraiseView", 1, "registerReceiver");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    ImageView localImageView = this.e;
    if (localImageView != null)
    {
      localImageView.setVisibility(8);
      this.a = false;
    }
    QLog.d("QCircleDoublePraiseView", 1, "unRegisterReceiver");
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleDoublePraiseAnimationEvent))
    {
      paramSimpleBaseEvent = (QCircleDoublePraiseAnimationEvent)paramSimpleBaseEvent;
      if ((this.c != null) && (paramSimpleBaseEvent.mTargetFeedId.equals(this.c.id.get())) && (paramSimpleBaseEvent.mPageType == this.d))
      {
        this.f = paramSimpleBaseEvent.mFeedPos;
        a();
        paramSimpleBaseEvent = new StringBuilder();
        paramSimpleBaseEvent.append("ReceiveEvent cur id:");
        paramSimpleBaseEvent.append(this.c.id.get());
        paramSimpleBaseEvent.append(" pageType:");
        paramSimpleBaseEvent.append(this.d);
        QLog.d("QCircleDoublePraiseView", 1, paramSimpleBaseEvent.toString());
        return;
      }
      QLog.d("QCircleDoublePraiseView", 1, "id or pagetype not right");
      return;
    }
    if (((paramSimpleBaseEvent instanceof QCirclePolyPraiseUpdateEvent)) && (QCirclePolyLikeManager.c(this.c)))
    {
      paramSimpleBaseEvent = (QCirclePolyPraiseUpdateEvent)paramSimpleBaseEvent;
      FeedCloudMeta.StFeed localStFeed = this.c;
      if ((localStFeed != null) && (TextUtils.equals(localStFeed.id.get(), paramSimpleBaseEvent.mTargetFeedId))) {
        a(paramSimpleBaseEvent.mPraisedStatus, paramSimpleBaseEvent.mPraisedNum);
      }
    }
  }
  
  public void setAnimationEndHandler(QCircleDoublePraiseView.IAnimationEndHandler paramIAnimationEndHandler)
  {
    this.k = paramIAnimationEndHandler;
  }
  
  public void setFeed(FeedCloudMeta.StFeed paramStFeed)
  {
    setFeed(paramStFeed, 0);
  }
  
  public void setFeed(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    this.c = paramStFeed;
    this.h = paramInt;
    paramStFeed = this.e;
    if (paramStFeed != null)
    {
      paramStFeed.setVisibility(8);
      this.a = false;
    }
    setUpOpenCancelLike(this.c);
  }
  
  public void setPageType(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    this.g = QCircleReportBean.setReportBean("QCircleDoublePraiseView", paramQCircleReportBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView
 * JD-Core Version:    0.7.0.1
 */