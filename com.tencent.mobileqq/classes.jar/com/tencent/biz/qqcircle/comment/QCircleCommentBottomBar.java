package com.tencent.biz.qqcircle.comment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
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
import bgjb;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFrameLayout;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCirclePraiseTextView;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;
import uxx;
import uzb;
import uzc;
import vhr;
import vhs;
import vht;
import vrg;
import vtm;
import zwp;
import zwr;
import zzr;

public class QCircleCommentBottomBar
  extends QCircleBaseWidgetView<FeedCloudMeta.StFeed>
  implements View.OnClickListener, zwr
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCirclePolyLikeFrameLayout jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout;
  protected ReportExtraTypeInfo a;
  private QCirclePraiseTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView;
  private QCircleRecommendImageView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private FeedCloudMeta.StReply jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private TextView c;
  
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
    this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = new ReportExtraTypeInfo();
  }
  
  @NotNull
  private RotateAnimation a()
  {
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(3000L);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    localRotateAnimation.setRepeatCount(-1);
    return localRotateAnimation;
  }
  
  private QCircleInitBean a()
  {
    return (QCircleInitBean)((Activity)getContext()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
  }
  
  private String a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (paramStReply != null)
    {
      if (paramStReply.postUser == null) {
        break label162;
      }
      paramStReply = String.format(getContext().getString(2131692041), new Object[] { paramStReply.postUser.nick.get() });
      paramStComment = paramStReply;
      if (paramStReply.length() > 10)
      {
        paramStComment = paramStReply.substring(0, 10);
        paramStComment = paramStComment + "...";
      }
    }
    do
    {
      return paramStComment;
      if ((paramStComment == null) || (paramStComment.postUser == null)) {
        break;
      }
      paramStReply = String.format(getContext().getString(2131692041), new Object[] { paramStComment.postUser.nick.get() });
      paramStComment = paramStReply;
    } while (paramStReply.length() <= 10);
    paramStComment = paramStReply.substring(0, 10);
    return paramStComment + "...";
    label162:
    return null;
  }
  
  private RotateAnimation b()
  {
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(800L);
    localRotateAnimation.setInterpolator(new AccelerateInterpolator());
    localRotateAnimation.setAnimationListener(new vht(this));
    return localRotateAnimation;
  }
  
  private boolean b()
  {
    return QCircleReportBean.isContentDetailPage(d());
  }
  
  private void c()
  {
    String str = bgjb.a(getContext(), "key_sp_content_detail_is_show_push_spin");
    if (str.equals("")) {}
    for (int i = 0; i != 0; i = Integer.parseInt(str))
    {
      d();
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.startAnimation(a());
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setPushAnimationListener(new vhs(this));
    }
    bgjb.a(getContext(), "key_sp_content_detail_is_show_push_spin", "1");
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      ((FrameLayout)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  private void e()
  {
    QCircleInitBean localQCircleInitBean = (QCircleInitBean)((Activity)getContext()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
    if (localQCircleInitBean != null)
    {
      QCirclePolyLikeAniView localQCirclePolyLikeAniView = a();
      if ((localQCirclePolyLikeAniView != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        localQCirclePolyLikeAniView.startRewardAni(localQCircleInitBean.getPolyLike(), this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.a(), this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.b(), true, null, false);
      }
    }
  }
  
  private void f()
  {
    zwp.a().a(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private void g()
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = null;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply = null;
    a(getContext().getString(2131697138));
  }
  
  public int a()
  {
    return 2131560688;
  }
  
  public QCirclePolyLikeAniView a()
  {
    if ((a() instanceof uzb)) {
      return ((uzb)a()).a();
    }
    return null;
  }
  
  public ExtraTypeInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  }
  
  public String a()
  {
    return "QCircleCommentBottomBar";
  }
  
  public QQCircleFeedBase.StBusiInfoCommentListData a()
  {
    try
    {
      QCircleInitBean localQCircleInitBean = a();
      QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = new QQCircleFeedBase.StBusiInfoCommentListData();
      localStBusiInfoCommentListData.mergeFrom(localQCircleInitBean.getBusiInfoData());
      localStBusiInfoCommentListData.setHasFlag(true);
      return localStBusiInfoCommentListData;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleCommentBottomBar", 1, "getInfoError");
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.b == null) {}
    for (;;)
    {
      return;
      if (paramInt > 0)
      {
        zzr.a(this.b, false);
        this.b.setText(uxx.d(paramInt));
      }
      while (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null)
      {
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.commentCount.set(paramInt);
        return;
        this.b.setTypeface(Typeface.DEFAULT);
        this.b.setText(getResources().getString(2131697127));
      }
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370040));
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout = ((QCirclePolyLikeFrameLayout)findViewById(2131369228));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379504));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView = ((QCircleRecommendImageView)findViewById(2131369135));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369090));
    this.b = ((TextView)findViewById(2131369089));
    this.c = ((TextView)findViewById(2131369136));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView = ((QCirclePraiseTextView)findViewById(2131369230));
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setUnPraiseDrawable(2130843991);
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setPraisedDrawable(2130843991);
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setIsContentDetail(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setPageType(2);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setReportListener(new vhr(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369238);
    c();
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView.setEmptyText(getResources().getString(2131697228));
    f();
  }
  
  protected void a(FeedCloudMeta.StFeed paramStFeed)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("bindData:");
    if (paramStFeed == null) {}
    for (String str = "feed == null";; str = paramStFeed.toString())
    {
      QLog.d("QCircleCommentBottomBar", 2, str);
      if (paramStFeed != null) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    if (this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setAniView(a());
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setFeedData(paramStFeed);
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView.setFeedData(paramStFeed);
    }
    a(paramStFeed.commentCount.get());
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setFeedData(paramStFeed, 2);
      }
      if (!uxx.a(paramStFeed.poster.id.get())) {
        break label215;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      if (((a() instanceof uzb)) && (a() != null))
      {
        paramStFeed = new uzc();
        paramStFeed.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
        paramStFeed.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
        ((uzb)a()).a("comment_panel_show", paramStFeed);
      }
      e();
      return;
      label215:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      setPushData(paramStFeed);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    zwp.a().b(this);
  }
  
  public void b(int paramInt)
  {
    if (this.c == null) {
      return;
    }
    if (paramInt > 0)
    {
      zzr.a(this.c, false);
      this.c.setText(uxx.d(paramInt));
      return;
    }
    this.c.setTypeface(Typeface.DEFAULT);
    this.c.setText(getResources().getString(2131697244));
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    localArrayList.add(QCirclePushUpdateEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((a() instanceof uzb))
      {
        if (b()) {
          vrg.a(6, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, e());
        }
        uzc localuzc = new uzc();
        localuzc.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
        localuzc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
        localuzc.c = 6;
        localuzc.b = uzc.d;
        ((uzb)a()).a("comment_panel_show", localuzc);
        continue;
        if ((a() instanceof uzb))
        {
          if (b()) {
            vrg.a(7, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, e());
          }
          localuzc = new uzc();
          localuzc.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
          localuzc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
          localuzc.c = 7;
          localuzc.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
          localuzc.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
          localuzc.jdField_a_of_type_JavaLangString = "main";
          ((uzb)a()).a("comment_input_window_show", localuzc);
          g();
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    d();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleCommentUpdateEvent)) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && (((QCircleCommentUpdateEvent)paramSimpleBaseEvent).feedId.equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()))) {
      switch (((QCircleCommentUpdateEvent)paramSimpleBaseEvent).eventStatus)
      {
      }
    }
    for (;;)
    {
      QQCircleFeedBase.StFeedBusiReqData localStFeedBusiReqData;
      if ((paramSimpleBaseEvent instanceof QCirclePushUpdateEvent))
      {
        paramSimpleBaseEvent = (QCirclePushUpdateEvent)paramSimpleBaseEvent;
        if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && (paramSimpleBaseEvent.mTargetFeedId.equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()))) {
          localStFeedBusiReqData = new QQCircleFeedBase.StFeedBusiReqData();
        }
      }
      try
      {
        localStFeedBusiReqData.mergeFrom(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.busiData.get().toByteArray());
        if (localStFeedBusiReqData.pushList != null)
        {
          vtm.a(localStFeedBusiReqData.pushList, paramSimpleBaseEvent.mAllPushTimes);
          b(localStFeedBusiReqData.pushList.totalClickCount.get());
          this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.busiData.set(ByteStringMicro.copyFrom(localStFeedBusiReqData.toByteArray()));
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramSimpleBaseEvent)
      {
        paramSimpleBaseEvent.printStackTrace();
        return;
      }
      catch (Exception paramSimpleBaseEvent)
      {
        QLog.e("QCircleCommentBottomBar", 1, "receiveEvent error" + paramSimpleBaseEvent.getMessage());
        paramSimpleBaseEvent.printStackTrace();
      }
      a(((QCircleCommentUpdateEvent)paramSimpleBaseEvent).commentTotalNum);
    }
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
    if ((this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout != null) && ((paramExtraTypeInfo instanceof ReportExtraTypeInfo))) {
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setExtraTypeInfo((ReportExtraTypeInfo)paramExtraTypeInfo);
    }
  }
  
  public void setHostActivity(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void setPushData(FeedCloudMeta.StFeed paramStFeed)
  {
    QQCircleFeedBase.StFeedBusiReqData localStFeedBusiReqData;
    if ((paramStFeed != null) && (paramStFeed.busiData.get() != null)) {
      localStFeedBusiReqData = new QQCircleFeedBase.StFeedBusiReqData();
    }
    try
    {
      localStFeedBusiReqData.mergeFrom(paramStFeed.busiData.get().toByteArray());
      paramStFeed = localStFeedBusiReqData.pushList;
      if (paramStFeed != null) {
        b(paramStFeed.totalClickCount.get());
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramStFeed)
    {
      paramStFeed.printStackTrace();
    }
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    super.setReportBean(paramQCircleReportBean);
    if (this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setReportBean(paramQCircleReportBean);
    }
  }
  
  public void setShareClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setTargetCommentAndReply(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply = paramStReply;
    paramStComment = a(paramStComment, paramStReply);
    if (!TextUtils.isEmpty(paramStComment)) {
      a(paramStComment);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentBottomBar
 * JD-Core Version:    0.7.0.1
 */