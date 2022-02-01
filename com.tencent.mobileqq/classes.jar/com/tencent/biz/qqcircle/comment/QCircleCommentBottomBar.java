package com.tencent.biz.qqcircle.comment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleUndoPushUpdateEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFrameLayout;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.part.ExtraInfoInterface;
import com.tencent.biz.qqcircle.richframework.sender.iml.req.QCirclePushReportReqInterceptor;
import com.tencent.biz.qqcircle.utils.QCircleProtoUtil;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCirclePraiseTextView;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.cooperation.config.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;

public class QCircleCommentBottomBar
  extends QCircleBaseWidgetView<FeedCloudMeta.StFeed>
  implements View.OnClickListener, ExtraInfoInterface, SimpleEventReceiver
{
  private LinearLayout a;
  private QCircleRecommendImageView b;
  private QCirclePolyLikeFrameLayout c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private QCirclePraiseTextView g;
  private FeedCloudMeta.StFeed h;
  private FeedCloudMeta.StComment i;
  private FeedCloudMeta.StReply j;
  private View.OnClickListener k;
  private TextView l;
  private QCircleExtraTypeInfo m;
  private View n;
  private boolean o;
  private boolean p = false;
  
  public QCircleCommentBottomBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleCommentBottomBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleCommentBottomBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (paramStReply != null)
    {
      if (paramStReply.postUser != null)
      {
        paramStReply = String.format(getContext().getString(2131889232), new Object[] { paramStReply.postUser.nick.get() });
        paramStComment = paramStReply;
        if (paramStReply.length() > 10)
        {
          paramStComment = paramStReply.substring(0, 10);
          paramStReply = new StringBuilder();
          paramStReply.append(paramStComment);
          paramStReply.append("...");
          paramStComment = paramStReply.toString();
        }
        return paramStComment;
      }
    }
    else if ((paramStComment != null) && (paramStComment.postUser != null))
    {
      paramStReply = String.format(getContext().getString(2131889232), new Object[] { paramStComment.postUser.nick.get() });
      paramStComment = paramStReply;
      if (paramStReply.length() > 10)
      {
        paramStComment = paramStReply.substring(0, 10);
        paramStReply = new StringBuilder();
        paramStReply.append(paramStComment);
        paramStReply.append("...");
        paramStComment = paramStReply.toString();
      }
      return paramStComment;
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(paramQCircleExtraTypeInfo.mFeed.poster.id.get()).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setPageId(getPageId()).setfpageid(getParentPageId()));
      return;
    }
    paramQCircleExtraTypeInfo = new StringBuilder();
    paramQCircleExtraTypeInfo.append("reportToLpDc05507 extraTypeInfo is null or lost feed,actionType:");
    paramQCircleExtraTypeInfo.append(paramInt1);
    paramQCircleExtraTypeInfo.append(",subActionType:");
    paramQCircleExtraTypeInfo.append(paramInt2);
    QLog.e("QCircleReportHelper_QCircleCommentBottomBar", 1, paramQCircleExtraTypeInfo.toString());
  }
  
  private void a(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    int i1 = paramQCircleCommentUpdateEvent.eventStatus;
    if ((i1 != 1) && (i1 != 3) && (i1 != 4) && (i1 != 5) && (i1 != 6)) {
      return;
    }
    a(paramQCircleCommentUpdateEvent.commentTotalNum);
  }
  
  private void a(QCirclePushUpdateEvent paramQCirclePushUpdateEvent)
  {
    if ((this.h != null) && (paramQCirclePushUpdateEvent.mTargetFeedId.equals(this.h.id.get())))
    {
      Object localObject = new QQCircleFeedBase.StFeedBusiReqData();
      try
      {
        ((QQCircleFeedBase.StFeedBusiReqData)localObject).mergeFrom(this.h.busiData.get().toByteArray());
        if (((QQCircleFeedBase.StFeedBusiReqData)localObject).pushList != null)
        {
          QCircleProtoUtil.a(((QQCircleFeedBase.StFeedBusiReqData)localObject).pushList, paramQCirclePushUpdateEvent.mAllPushTimes);
          b(((QQCircleFeedBase.StFeedBusiReqData)localObject).pushList.totalClickCount.get());
          this.h.busiData.set(ByteStringMicro.copyFrom(((QQCircleFeedBase.StFeedBusiReqData)localObject).toByteArray()));
          return;
        }
      }
      catch (Exception paramQCirclePushUpdateEvent)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("receiveEvent error");
        ((StringBuilder)localObject).append(paramQCirclePushUpdateEvent.getMessage());
        QLog.e("QCircleCommentBottomBar", 1, ((StringBuilder)localObject).toString());
        paramQCirclePushUpdateEvent.printStackTrace();
        return;
      }
      catch (InvalidProtocolBufferMicroException paramQCirclePushUpdateEvent)
      {
        paramQCirclePushUpdateEvent.printStackTrace();
      }
    }
  }
  
  private void a(QCircleUndoPushUpdateEvent paramQCircleUndoPushUpdateEvent)
  {
    if ((this.h != null) && (paramQCircleUndoPushUpdateEvent.mTargetFeedId.equals(this.h.id.get())))
    {
      paramQCircleUndoPushUpdateEvent = new QQCircleFeedBase.StFeedBusiReqData();
      try
      {
        paramQCircleUndoPushUpdateEvent.mergeFrom(this.h.busiData.get().toByteArray());
        if (paramQCircleUndoPushUpdateEvent.pushList != null)
        {
          QCircleProtoUtil.a(paramQCircleUndoPushUpdateEvent.pushList);
          b(paramQCircleUndoPushUpdateEvent.pushList.totalClickCount.get());
          this.h.busiData.set(ByteStringMicro.copyFrom(paramQCircleUndoPushUpdateEvent.toByteArray()));
          return;
        }
      }
      catch (Exception paramQCircleUndoPushUpdateEvent)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("receiveEvent error");
        localStringBuilder.append(paramQCircleUndoPushUpdateEvent.getMessage());
        QLog.e("QCircleCommentBottomBar", 1, localStringBuilder.toString());
        paramQCircleUndoPushUpdateEvent.printStackTrace();
        return;
      }
      catch (InvalidProtocolBufferMicroException paramQCircleUndoPushUpdateEvent)
      {
        paramQCircleUndoPushUpdateEvent.printStackTrace();
      }
    }
  }
  
  private void a(QCircleRecommendImageView paramQCircleRecommendImageView)
  {
    if (paramQCircleRecommendImageView == null) {
      return;
    }
    QCirclePushReportReqInterceptor localQCirclePushReportReqInterceptor = new QCirclePushReportReqInterceptor();
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = this.m;
    if ((localQCircleExtraTypeInfo != null) && (localQCircleExtraTypeInfo.mFeed != null))
    {
      if (h()) {
        localQCirclePushReportReqInterceptor.a(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(this.m.mFeed)).setActionType(34).setSubActionType(2).setToUin(this.m.mFeed.poster.id.get()).setPosition(this.m.mDataPosition).setPlayScene(this.m.mPlayScene).setPageId(getPageId()).setfpageid(getParentPageId()));
      } else {
        localQCirclePushReportReqInterceptor.a(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(this.m.mFeed).setActionType(34).setSubActionType(2).setToUin(this.m.mFeed.poster.id.get()).setIndex(this.m.mDataPosition).setPageId(getPageId())));
      }
      paramQCircleRecommendImageView.setPushReportReqInterceptor(localQCirclePushReportReqInterceptor);
    }
  }
  
  private void c()
  {
    Object localObject = SharePreferenceUtils.a(getContext(), "key_sp_content_detail_is_show_push_spin");
    int i1;
    if (((String)localObject).equals("")) {
      i1 = 0;
    } else {
      i1 = Integer.parseInt((String)localObject);
    }
    if (i1 != 0)
    {
      d();
      return;
    }
    localObject = this.n;
    if (localObject != null) {
      ((View)localObject).startAnimation(getDefaultRotateAnimation());
    }
    localObject = this.b;
    if (localObject != null) {
      ((QCircleRecommendImageView)localObject).setPushAnimationListener(new QCircleCommentBottomBar.1(this));
    }
    SharePreferenceUtils.a(getContext(), "key_sp_content_detail_is_show_push_spin", "1");
  }
  
  private void d()
  {
    View localView = this.n;
    if (localView != null)
    {
      localView.clearAnimation();
      ((FrameLayout)this.n.getParent()).removeView(this.n);
      this.n = null;
    }
  }
  
  private void e()
  {
    QCircleInitBean localQCircleInitBean = (QCircleInitBean)((Activity)getContext()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
    if ((localQCircleInitBean != null) && (this.c != null))
    {
      QCirclePolyLikeAniView localQCirclePolyLikeAniView = getPolymorphicAniView();
      if ((localQCirclePolyLikeAniView != null) && (!this.o))
      {
        this.o = true;
        localQCirclePolyLikeAniView.a(localQCircleInitBean.getPolyLike(), this.c.getZanView(), this.c.getPolyEndView(), true, null, false);
      }
    }
  }
  
  private void f()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void g()
  {
    this.i = null;
    this.j = null;
    a(getContext().getString(2131895697));
  }
  
  private RotateAnimation getClickRotateAnimation()
  {
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(800L);
    localRotateAnimation.setInterpolator(new AccelerateInterpolator());
    localRotateAnimation.setAnimationListener(new QCircleCommentBottomBar.2(this));
    return localRotateAnimation;
  }
  
  private RotateAnimation getDefaultRotateAnimation()
  {
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(3000L);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    localRotateAnimation.setRepeatCount(-1);
    return localRotateAnimation;
  }
  
  private QCircleInitBean getInitBean()
  {
    return (QCircleInitBean)((Activity)getContext()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
  }
  
  private boolean h()
  {
    return QCircleReportBean.isContentDetailPage(getPageId());
  }
  
  public void a()
  {
    TextView localTextView = this.e;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    if (paramInt > 0)
    {
      RFWTypefaceUtil.a((TextView)localObject, false);
      this.f.setText(QCirclePluginUtil.d(paramInt));
    }
    else
    {
      ((TextView)localObject).setTypeface(Typeface.DEFAULT);
      this.f.setText(getResources().getString(2131895652));
    }
    localObject = this.h;
    if (localObject != null) {
      ((FeedCloudMeta.StFeed)localObject).commentCount.set(paramInt);
    }
  }
  
  protected void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    if (this.p) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bindData:");
    if (paramStFeed == null) {
      localObject = "feed == null";
    } else {
      localObject = paramStFeed.toString();
    }
    localStringBuilder.append((String)localObject);
    QLog.d("QCircleCommentBottomBar", 2, localStringBuilder.toString());
    if (paramStFeed == null) {
      return;
    }
    this.h = paramStFeed;
    Object localObject = this.c;
    if (localObject != null)
    {
      ((QCirclePolyLikeFrameLayout)localObject).setAniView(getPolymorphicAniView());
      this.c.setFeedData(paramStFeed);
      this.c.setPushPageType(2);
    }
    localObject = this.g;
    if (localObject != null) {
      ((QCirclePraiseTextView)localObject).setFeedData(paramStFeed);
    }
    a(paramStFeed.commentCount.get());
    if (this.a != null)
    {
      localObject = this.b;
      if (localObject != null) {
        ((QCircleRecommendImageView)localObject).setFeedData(new FeedBlockData(paramStFeed), 2);
      }
      if (QCirclePluginUtil.d(paramStFeed.poster.id.get()))
      {
        this.a.setVisibility(8);
      }
      else
      {
        this.a.setVisibility(0);
        setPushData(paramStFeed);
      }
    }
    if (((getInteractor() instanceof QCircleInteractor)) && (getBusiInfo() != null))
    {
      paramStFeed = new QCircleCommentInfo();
      paramStFeed.b = this.h;
      paramStFeed.c = this.m;
      ((QCircleInteractor)getInteractor()).a("comment_panel_show", paramStFeed);
    }
    e();
    this.p = true;
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.e;
    if (localTextView == null) {
      return;
    }
    localTextView.setText(paramString);
  }
  
  public void b(int paramInt)
  {
    TextView localTextView = this.l;
    if (localTextView == null) {
      return;
    }
    if (paramInt > 0)
    {
      RFWTypefaceUtil.a(localTextView, false);
      this.l.setText(QCirclePluginUtil.d(paramInt));
      return;
    }
    localTextView.setTypeface(Typeface.DEFAULT);
    this.l.setText(getResources().getString(2131895872));
  }
  
  public boolean b()
  {
    return false;
  }
  
  public QQCircleFeedBase.StBusiInfoCommentListData getBusiInfo()
  {
    try
    {
      QCircleInitBean localQCircleInitBean = getInitBean();
      QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = new QQCircleFeedBase.StBusiInfoCommentListData();
      localStBusiInfoCommentListData.mergeFrom(localQCircleInitBean.getBusiInfoData());
      localStBusiInfoCommentListData.setHasFlag(true);
      return localStBusiInfoCommentListData;
    }
    catch (Exception localException)
    {
      label29:
      break label29;
    }
    QLog.e("QCircleCommentBottomBar", 1, "getInfoError");
    return null;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    localArrayList.add(QCirclePushUpdateEvent.class);
    localArrayList.add(QCircleUndoPushUpdateEvent.class);
    return localArrayList;
  }
  
  public QCircleExtraTypeInfo getExtraTypeInfo()
  {
    return this.m;
  }
  
  public int getLayoutId()
  {
    return 2131626792;
  }
  
  protected String getLogTag()
  {
    return "QCircleCommentBottomBar";
  }
  
  public QCirclePolyLikeAniView getPolymorphicAniView()
  {
    if ((getInteractor() instanceof QCircleInteractor)) {
      return ((QCircleInteractor)getInteractor()).b();
    }
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    QCircleCommentInfo localQCircleCommentInfo;
    if (i1 == 2131436329)
    {
      if ((getInteractor() instanceof QCircleInteractor))
      {
        if (h()) {
          a(6, 2, this.m);
        }
        localQCircleCommentInfo = new QCircleCommentInfo();
        localQCircleCommentInfo.b = this.h;
        localQCircleCommentInfo.c = this.m;
        localQCircleCommentInfo.i = 6;
        localQCircleCommentInfo.g = QCircleCommentInfo.j;
        ((QCircleInteractor)getInteractor()).a("comment_panel_show", localQCircleCommentInfo);
      }
    }
    else if ((i1 == 2131448254) && ((getInteractor() instanceof QCircleInteractor)))
    {
      if (h()) {
        a(7, 2, this.m);
      }
      localQCircleCommentInfo = new QCircleCommentInfo();
      localQCircleCommentInfo.b = this.h;
      localQCircleCommentInfo.c = this.m;
      localQCircleCommentInfo.i = 7;
      localQCircleCommentInfo.d = this.i;
      localQCircleCommentInfo.e = this.j;
      ((QCircleInteractor)getInteractor()).a("comment_input_window_show", localQCircleCommentInfo);
      g();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    d();
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((LinearLayout)findViewById(2131437423));
    this.c = ((QCirclePolyLikeFrameLayout)findViewById(2131436501));
    this.e = ((TextView)findViewById(2131448254));
    this.b = ((QCircleRecommendImageView)findViewById(2131436387));
    this.d = ((ImageView)findViewById(2131436329));
    this.f = ((TextView)findViewById(2131436328));
    this.l = ((TextView)findViewById(2131436388));
    this.g = ((QCirclePraiseTextView)findViewById(2131436503));
    this.c.setIsContentDetail(true);
    this.b.setPageType(2);
    this.n = findViewById(2131436510);
    c();
    this.g.setEmptyText(getResources().getString(2131895845));
    f();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleCommentUpdateEvent)) && (this.h != null))
    {
      QCircleCommentUpdateEvent localQCircleCommentUpdateEvent = (QCircleCommentUpdateEvent)paramSimpleBaseEvent;
      if (localQCircleCommentUpdateEvent.feedId.equals(this.h.id.get())) {
        a(localQCircleCommentUpdateEvent);
      }
    }
    if ((paramSimpleBaseEvent instanceof QCirclePushUpdateEvent)) {
      a((QCirclePushUpdateEvent)paramSimpleBaseEvent);
    }
    if ((paramSimpleBaseEvent instanceof QCircleUndoPushUpdateEvent)) {
      a((QCircleUndoPushUpdateEvent)paramSimpleBaseEvent);
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    this.c.setIsContentDetail(true);
  }
  
  public void release()
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void setExtraTypeInfo(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    this.m = paramQCircleExtraTypeInfo;
    this.c.setExtraTypeInfo(paramQCircleExtraTypeInfo);
    a(this.b);
  }
  
  public void setPushData(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed != null) && (paramStFeed.busiData.get() != null))
    {
      Object localObject = new QQCircleFeedBase.StFeedBusiReqData();
      try
      {
        ((QQCircleFeedBase.StFeedBusiReqData)localObject).mergeFrom(paramStFeed.busiData.get().toByteArray());
        localObject = ((QQCircleFeedBase.StFeedBusiReqData)localObject).pushList;
        QCirclePushInfoManager.a().a(paramStFeed.id.get(), (FeedCloudMeta.StPushList)localObject);
        if (localObject != null)
        {
          b(((FeedCloudMeta.StPushList)localObject).totalClickCount.get());
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramStFeed)
      {
        paramStFeed.printStackTrace();
      }
    }
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    super.setReportBean(paramQCircleReportBean);
    QCirclePolyLikeFrameLayout localQCirclePolyLikeFrameLayout = this.c;
    if (localQCirclePolyLikeFrameLayout != null) {
      localQCirclePolyLikeFrameLayout.setReportBean(paramQCircleReportBean);
    }
  }
  
  public void setShareClickListener(View.OnClickListener paramOnClickListener)
  {
    this.k = paramOnClickListener;
  }
  
  public void setTargetCommentAndReply(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    this.i = paramStComment;
    this.j = paramStReply;
    paramStComment = a(paramStComment, paramStReply);
    if (!TextUtils.isEmpty(paramStComment)) {
      a(paramStComment);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentBottomBar
 * JD-Core Version:    0.7.0.1
 */