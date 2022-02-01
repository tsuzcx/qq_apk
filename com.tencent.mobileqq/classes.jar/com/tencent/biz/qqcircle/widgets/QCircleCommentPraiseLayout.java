package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import java.util.ArrayList;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

public class QCircleCommentPraiseLayout
  extends LinearLayout
  implements View.OnClickListener, ReportBean<QCircleReportBean>, SimpleEventReceiver
{
  private int a;
  private boolean b = true;
  private TextView c;
  private ImageView d;
  private FeedCloudMeta.StFeed e;
  private FeedCloudMeta.StComment f;
  private FeedCloudMeta.StReply g;
  private boolean h;
  private QCircleCommentPraiseLayout.OnClickHookListener i;
  private int j = 2130845389;
  private int k = 2130845391;
  private QCircleReportBean l;
  
  static {}
  
  public QCircleCommentPraiseLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QCircleCommentPraiseLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QCircleCommentPraiseLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setOrientation(0);
    setGravity(16);
    this.c = new TextView(getContext());
    this.c.setTextSize(1, 12.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = ViewUtils.a(3.0F);
    localLayoutParams.gravity = 16;
    localLayoutParams.bottomMargin = ViewUtils.a(0.5F);
    addView(this.c, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.a(20.0F), ViewUtils.a(20.0F));
    localLayoutParams.gravity = 16;
    this.d = new ImageView(getContext());
    addView(this.d, localLayoutParams);
    this.d.setOnClickListener(this);
    setTouchDelegate(this.d, 30);
  }
  
  private void b()
  {
    try
    {
      this.d.setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(this.k));
      this.d.setVisibility(0);
      this.c.setTextColor(QCircleSkinHelper.getInstance().getColor(2131167084));
      return;
    }
    catch (Exception localException)
    {
      label42:
      break label42;
    }
    QLog.e("QCircleCommentPraiseLay", 1, "showLikeView setBackgroundDrawable error");
  }
  
  private void c()
  {
    try
    {
      this.d.setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(this.j));
      this.d.setVisibility(0);
      this.c.setTextColor(QCircleSkinHelper.getInstance().getColor(2131167085));
      return;
    }
    catch (Exception localException)
    {
      label42:
      break label42;
    }
    QLog.e("QCircleCommentPraiseLay", 1, "showUnLikeView setBackgroundDrawable error");
  }
  
  private boolean d()
  {
    return QCircleReportBean.isContentDetailPage(QCircleReportBean.getPageId("QCircleCommentPraiseLay", this.l));
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramInt == 1) {
      b();
    } else if (paramInt == 0) {
      c();
    }
    if (this.h)
    {
      if (paramLong == 0L)
      {
        this.c.setVisibility(4);
        return;
      }
      this.c.setVisibility(0);
      this.c.setText(QCirclePluginUtil.d(paramLong));
      return;
    }
    this.c.setVisibility(4);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  public FeedCloudMeta.StFeed getFeedData()
  {
    return this.e;
  }
  
  public QCircleReportBean getReportBean()
  {
    return QCircleReportBean.getReportBean("QCircleCommentPraiseLay", this.l);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  @QCircleFeedClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(m, this, this, paramView);
    a(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent)) && (this.e != null))
    {
      paramSimpleBaseEvent = (QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent;
      if (TextUtils.equals(paramSimpleBaseEvent.mFeedId, this.e.id.get()))
      {
        FeedCloudMeta.StComment localStComment;
        if ((this.a == 1) && (paramSimpleBaseEvent.mType == 1))
        {
          localStComment = this.f;
          if ((localStComment != null) && (TextUtils.equals(localStComment.id.get(), paramSimpleBaseEvent.mCommentId)))
          {
            this.f.likeInfo.status.set(paramSimpleBaseEvent.mPraisedStatus);
            this.f.likeInfo.count.set(paramSimpleBaseEvent.mPraisedNum);
            a(paramSimpleBaseEvent.mPraisedStatus, paramSimpleBaseEvent.mPraisedNum);
            return;
          }
        }
        if ((this.a == 2) && (paramSimpleBaseEvent.mType == 2))
        {
          localStComment = this.f;
          if ((localStComment != null) && (this.g != null) && (TextUtils.equals(localStComment.id.get(), paramSimpleBaseEvent.mCommentId)) && (TextUtils.equals(this.g.id.get(), paramSimpleBaseEvent.mReplyId)))
          {
            this.g.likeInfo.status.set(paramSimpleBaseEvent.mPraisedStatus);
            this.g.likeInfo.count.set(paramSimpleBaseEvent.mPraisedNum);
            a(paramSimpleBaseEvent.mPraisedStatus, paramSimpleBaseEvent.mPraisedNum);
          }
        }
      }
    }
  }
  
  public void setData(int paramInt, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    setData(paramInt, paramStFeed, paramStComment, paramStReply, false);
  }
  
  public void setData(int paramInt, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, boolean paramBoolean)
  {
    setVisibility(8);
    if (paramStFeed == null) {
      return;
    }
    this.a = paramInt;
    this.e = paramStFeed;
    this.f = paramStComment;
    this.g = paramStReply;
    this.h = paramBoolean;
    paramInt = this.a;
    if (paramInt == 1)
    {
      paramStFeed = this.f;
      if (paramStFeed != null)
      {
        a(paramStFeed.likeInfo.status.get(), this.f.likeInfo.count.get());
        setVisibility(0);
      }
    }
    else if (paramInt == 2)
    {
      paramStFeed = this.g;
      if (paramStFeed != null)
      {
        a(paramStFeed.likeInfo.status.get(), this.g.likeInfo.count.get());
        setVisibility(0);
      }
    }
  }
  
  public void setOnClickHookListener(QCircleCommentPraiseLayout.OnClickHookListener paramOnClickHookListener)
  {
    this.i = paramOnClickHookListener;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    this.l = QCircleReportBean.setReportBean("QCircleCommentPraiseLay", paramQCircleReportBean);
  }
  
  public void setTouchDelegate(View paramView, int paramInt)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      View localView = (View)paramView.getParent();
      localView.post(new QCircleCommentPraiseLayout.2(this, paramView, paramInt, localView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout
 * JD-Core Version:    0.7.0.1
 */