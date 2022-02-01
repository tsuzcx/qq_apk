package com.tencent.biz.qqcircle.polylike;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class QCirclePolyLikeFrameLayout
  extends FrameLayout
  implements View.OnClickListener, ReportBean<QCircleReportBean>, SimpleEventReceiver
{
  static final ConcurrentHashMap<String, QCirclePolyPraiseUpdateEvent> a = new ConcurrentHashMap();
  private FeedCloudMeta.StFeed b = new FeedCloudMeta.StFeed();
  private QQCircleFeedBase.StLikeBusiData c;
  private FrameLayout d;
  private URLImageView e;
  private ImageView f;
  private QQCircleFeedBase.StPolyLike g;
  private QCirclePolyLikeAniView h;
  private List<QQCircleFeedBase.StPolyLike> i;
  private boolean j;
  private QCirclePolyLikePopWindow k;
  private QCircleExtraTypeInfo l;
  private QCirclePolyLikeFrameLayout.OnClickHookListener m;
  private QCircleReportBean n;
  private ReportBean<QCircleReportBean> o;
  private int p;
  private boolean q;
  private boolean r = false;
  
  static {}
  
  public QCirclePolyLikeFrameLayout(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public QCirclePolyLikeFrameLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public QCirclePolyLikeFrameLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.b.likeInfo.count.set(paramInt2);
    if (this.b.likeInfo.status != null) {
      this.b.likeInfo.status.set(paramInt1);
    }
    Object localObject2 = new QQCircleFeedBase.StLikeBusiData();
    try
    {
      localObject1 = new QQCircleFeedBase.StLikeBusiData();
      try
      {
        ((QQCircleFeedBase.StLikeBusiData)localObject1).mergeFrom(this.b.likeInfo.busiData.get().toByteArray());
        localObject2 = new ArrayList();
        Iterator localIterator = ((QQCircleFeedBase.StLikeBusiData)localObject1).likeIDs.get().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if ((TextUtils.equals(str, "206008")) || (TextUtils.equals(str, "205993"))) {
            ((List)localObject2).add(str);
          }
        }
        if (paramInt1 != 0) {
          ((List)localObject2).add("6");
        }
        ((QQCircleFeedBase.StLikeBusiData)localObject1).likeIDs.set((List)localObject2);
        this.c = ((QQCircleFeedBase.StLikeBusiData)localObject1);
        this.b.likeInfo.busiData.set(ByteStringMicro.copyFrom(((QQCircleFeedBase.StLikeBusiData)localObject1).toByteArray()));
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1) {}
      Object localObject3;
      localObject3.printStackTrace();
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
    {
      localObject1 = localInvalidProtocolBufferMicroException1;
      localObject3 = localInvalidProtocolBufferMicroException2;
    }
    if (this.d == null) {
      return;
    }
    Object localObject1 = ((QQCircleFeedBase.StLikeBusiData)localObject1).likeIDs.get();
    if (((List)localObject1).size() > 0)
    {
      if (((List)localObject1).contains("6"))
      {
        this.g = QCirclePolyLikeManager.a("6");
        this.q = true;
      }
      else
      {
        this.g = QCirclePolyLikeManager.a((String)((List)localObject1).get(0));
        this.q = false;
      }
      localObject1 = new Option().setLoadingDrawable(getPraiseDrawable()).setRequestHeight(this.e.getHeight()).setRequestWidth(this.e.getWidth()).setUrl(this.g.polyIconUrl.get()).setTargetView(this.e);
      QCircleFeedPicLoader.g().loadImage((Option)localObject1, null);
      this.e.setVisibility(0);
      this.f.setVisibility(4);
      this.d.setBackgroundDrawable(getUnPraiseDrawable());
      return;
    }
    this.g = null;
    this.f.setVisibility(0);
    this.e.setVisibility(4);
    this.d.setBackgroundDrawable(getPraiseDrawable());
    this.q = false;
  }
  
  private void a(QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    Object localObject = this.g;
    if ((localObject != null) && (paramStPolyLike != null) && (!((QQCircleFeedBase.StPolyLike)localObject).polyLikeID.get().equals(paramStPolyLike.polyLikeID.get())))
    {
      localObject = new QQCircleFeedBase.StLikeBusiData();
      ((QQCircleFeedBase.StLikeBusiData)localObject).curPolyLikeInfo.set(paramStPolyLike);
      try
      {
        this.c = new QQCircleFeedBase.StLikeBusiData();
        this.c.mergeFrom(this.b.likeInfo.busiData.get().toByteArray());
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      ((QQCircleFeedBase.StLikeBusiData)localObject).polyLikeInfo.set(this.c.polyLikeInfo.get());
      if ((paramStPolyLike.articleType.get() == 1) || (this.c.rewardstatus.get() == 1)) {
        ((QQCircleFeedBase.StLikeBusiData)localObject).rewardstatus.set(1);
      }
      if (!this.c.likeIDs.get().contains(paramStPolyLike.polyLikeID.get())) {
        this.c.likeIDs.get().add(paramStPolyLike.polyLikeID.get());
      }
      ((QQCircleFeedBase.StLikeBusiData)localObject).likeIDs.addAll(new ArrayList(this.c.likeIDs.get()));
      this.b.likeInfo.busiData.set(ByteStringMicro.copyFrom(((QQCircleFeedBase.StLikeBusiData)localObject).toByteArray()));
    }
    this.g = paramStPolyLike;
    localObject = this.g;
    if ((localObject != null) && (!TextUtils.isEmpty(((QQCircleFeedBase.StPolyLike)localObject).polyLikeID.get())))
    {
      paramStPolyLike = new Option().setLoadingDrawable(getPraiseDrawable()).setRequestHeight(this.e.getHeight()).setRequestWidth(this.e.getWidth()).setUrl(paramStPolyLike.polyIconUrl.get()).setTargetView(this.e);
      QCircleFeedPicLoader.g().loadImage(paramStPolyLike, null);
      this.e.setVisibility(0);
      this.f.setVisibility(4);
      paramStPolyLike = this.d;
      if (paramStPolyLike != null) {
        paramStPolyLike.setBackgroundDrawable(getUnPraiseDrawable());
      }
      this.q = QCirclePolyLikeManager.b(this.g.polyLikeID.get());
      return;
    }
    this.f.setVisibility(0);
    this.e.setVisibility(4);
    paramStPolyLike = this.d;
    if (paramStPolyLike != null) {
      paramStPolyLike.setBackgroundDrawable(getPraiseDrawable());
    }
    this.q = false;
  }
  
  private void c()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131626906, this, true);
    if (localView != null)
    {
      this.d = ((FrameLayout)localView.findViewById(2131441768));
      this.e = ((URLImageView)localView.findViewById(2131441787));
      this.f = ((ImageView)localView.findViewById(2131441795));
      setOnClickListener(this);
      this.k = new QCirclePolyLikePopWindow((Activity)getContext());
    }
  }
  
  public void a()
  {
    this.i = QCirclePolyLikeInfoManger.a().b();
    if (this.i.isEmpty()) {
      return;
    }
    if (!this.k.isShowing())
    {
      this.k.a(this.f, this.e, this.j, this.h, this.b, this.i, this.l);
      this.k.a(getReportBean());
      this.k.a();
      QCirclePolyLikeFrameLayout.OnClickHookListener localOnClickHookListener = this.m;
      if (localOnClickHookListener != null) {
        localOnClickHookListener.a();
      }
    }
  }
  
  public boolean b()
  {
    return this.q;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePolyPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  public FeedCloudMeta.StFeed getFeedData()
  {
    return this.b;
  }
  
  public View getPolyEndView()
  {
    return this.e;
  }
  
  public Drawable getPraiseDrawable()
  {
    if (this.j) {
      return QCircleSkinHelper.getInstance().getDrawable(2130845067);
    }
    return QCircleSkinHelper.getInstance().getDrawable(2130845305);
  }
  
  public QCircleReportBean getReportBean()
  {
    Object localObject = this.n;
    if (localObject != null) {
      return QCircleReportBean.getReportBean("QCirclePolyLikeFrameLayout", (QCircleReportBean)localObject).clone();
    }
    localObject = this.o;
    if (localObject != null) {
      return QCircleReportBean.getReportBean("QCirclePolyLikeFrameLayout", (QCircleReportBean)((ReportBean)localObject).getReportBean()).clone();
    }
    return new QCircleReportBean();
  }
  
  public Drawable getUnPraiseDrawable()
  {
    if (this.j) {
      return QCircleSkinHelper.getInstance().getDrawable(2130845067);
    }
    return QCircleSkinHelper.getInstance().getDrawable(2130845306);
  }
  
  public View getZanView()
  {
    return this.f;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
    if (a.containsKey(this.b.id.get())) {
      onReceiveEvent((SimpleBaseEvent)a.get(this.b.id.get()));
    }
  }
  
  @QCircleFeedClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(s, this, this, paramView);
    a(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    a.remove(this.b.id.get());
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    RFThreadManager.getUIHandler().post(new QCirclePolyLikeFrameLayout.1(this, paramSimpleBaseEvent));
  }
  
  public void setAniView(QCirclePolyLikeAniView paramQCirclePolyLikeAniView)
  {
    this.h = paramQCirclePolyLikeAniView;
  }
  
  public void setExtraTypeInfo(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    this.l = paramQCircleExtraTypeInfo;
  }
  
  public void setFeedData(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed != null) && (paramStFeed.likeInfo.get() != null))
    {
      this.b = paramStFeed;
      this.r = QCirclePolyLikeManager.c(this.b);
      try
      {
        paramStFeed = (FeedCloudMeta.StLike)paramStFeed.likeInfo.get();
        this.c = new QQCircleFeedBase.StLikeBusiData();
        this.c.mergeFrom(paramStFeed.busiData.get().toByteArray());
        this.d.setBackgroundDrawable(getPraiseDrawable());
        if (this.r)
        {
          a(QCirclePolyLikeManager.a(this.c));
          return;
        }
        a(this.c.curPolyLikeInfo);
        return;
      }
      catch (Exception paramStFeed)
      {
        QLog.e("QCirclePraise_", 1, "[setFeedData] error: ", paramStFeed);
      }
    }
  }
  
  public void setIsContentDetail(boolean paramBoolean)
  {
    this.j = paramBoolean;
    int i1;
    int i2;
    if (this.j)
    {
      i1 = ViewUtils.a(46.0F);
      i2 = ViewUtils.a(24.0F);
      this.f.getLayoutParams().width = i2;
      this.f.getLayoutParams().height = i2;
      localObject = this.f;
      ((ImageView)localObject).setLayoutParams(((ImageView)localObject).getLayoutParams());
      this.f.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845388));
      this.d.getLayoutParams().width = i1;
      this.d.getLayoutParams().height = i1;
      localObject = this.d;
      ((FrameLayout)localObject).setLayoutParams(((FrameLayout)localObject).getLayoutParams());
      this.e.getLayoutParams().width = i2;
      this.e.getLayoutParams().height = i2;
      localObject = this.e;
      ((URLImageView)localObject).setLayoutParams(((URLImageView)localObject).getLayoutParams());
    }
    else
    {
      i1 = ViewUtils.a(46.0F);
      i2 = ViewUtils.a(24.0F);
      this.f.getLayoutParams().width = i2;
      this.f.getLayoutParams().height = i2;
      localObject = this.f;
      ((ImageView)localObject).setLayoutParams(((ImageView)localObject).getLayoutParams());
      this.d.getLayoutParams().width = i1;
      this.d.getLayoutParams().height = i1;
      localObject = this.d;
      ((FrameLayout)localObject).setLayoutParams(((FrameLayout)localObject).getLayoutParams());
      this.e.getLayoutParams().width = i2;
      this.e.getLayoutParams().height = i2;
      localObject = this.e;
      ((URLImageView)localObject).setLayoutParams(((URLImageView)localObject).getLayoutParams());
    }
    Object localObject = getPraiseDrawable();
    if (localObject != null) {
      this.d.setBackgroundDrawable((Drawable)localObject);
    }
  }
  
  public void setOnClickHookListener(QCirclePolyLikeFrameLayout.OnClickHookListener paramOnClickHookListener)
  {
    this.m = paramOnClickHookListener;
    QCirclePolyLikePopWindow localQCirclePolyLikePopWindow = this.k;
    if (localQCirclePolyLikePopWindow != null) {
      localQCirclePolyLikePopWindow.a(paramOnClickHookListener);
    }
  }
  
  public void setPushPageType(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    this.n = QCircleReportBean.setReportBean("QCirclePolyLikeFrameLayout", paramQCircleReportBean);
    paramQCircleReportBean = this.k;
    if (paramQCircleReportBean != null) {
      paramQCircleReportBean.a(this.n);
    }
  }
  
  public void setReportBeanAgent(ReportBean<QCircleReportBean> paramReportBean)
  {
    this.o = paramReportBean;
    QCirclePolyLikePopWindow localQCirclePolyLikePopWindow = this.k;
    if (localQCirclePolyLikePopWindow != null) {
      localQCirclePolyLikePopWindow.a(paramReportBean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFrameLayout
 * JD-Core Version:    0.7.0.1
 */