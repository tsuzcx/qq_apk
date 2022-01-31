package com.tencent.biz.qqcircle.comment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleForwardEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCirclePolyParseFrameLayout;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;
import com.tencent.biz.qqcircle.widgets.QCirclePraiseTextView;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;
import tra;
import ttu;
import tuk;
import tyk;
import tym;
import ubi;
import yej;
import yel;

public class QCircleCommentBottomBar
  extends LinearLayout
  implements View.OnClickListener, yel
{
  public static final String a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCirclePolyParseFrameLayout jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout;
  private QCirclePolymorphicAniView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView;
  private QCirclePraiseTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView;
  private QCircleRecommendImageView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private FeedCloudMeta.StReply jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
  private tuk jdField_a_of_type_Tuk;
  private ubi jdField_a_of_type_Ubi;
  private TextView b;
  private TextView c;
  
  static
  {
    jdField_a_of_type_JavaLangString = QCircleCommentBottomBar.class.getSimpleName();
  }
  
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
    b();
    c();
  }
  
  private String a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (paramStReply != null)
    {
      if (paramStReply.postUser == null) {
        break label162;
      }
      paramStReply = String.format(getContext().getString(2131692455), new Object[] { paramStReply.postUser.nick.get() });
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
      paramStReply = String.format(getContext().getString(2131692455), new Object[] { paramStComment.postUser.nick.get() });
      paramStComment = paramStReply;
    } while (paramStReply.length() <= 10);
    paramStComment = paramStReply.substring(0, 10);
    return paramStComment + "...";
    label162:
    return null;
  }
  
  private void b()
  {
    setClickable(true);
    setOrientation(0);
    setBackgroundColor(0);
    LayoutInflater.from(getContext()).inflate(2131560528, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369607));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout = ((QCirclePolyParseFrameLayout)findViewById(2131368848));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378594));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView = ((QCircleRecommendImageView)findViewById(2131368776));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368736));
    this.b = ((TextView)findViewById(2131368735));
    this.c = ((TextView)findViewById(2131368777));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView = ((QCirclePraiseTextView)findViewById(2131368850));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setUnPraiseDrawable(2130843558);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setPraisedDrawable(2130843547);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setIsContentDetail(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setPageType(2);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setBackgroundDrawable(getResources().getDrawable(2130843547));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setReportListener(new ttu(this));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView.setEmptyText(getResources().getString(2131698353));
  }
  
  private void c()
  {
    yej.a().a(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private void d()
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = null;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply = null;
    a(getContext().getString(2131698287));
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    localArrayList.add(QCircleForwardEvent.class);
    localArrayList.add(QCirclePushUpdateEvent.class);
    return localArrayList;
  }
  
  public tuk a()
  {
    return this.jdField_a_of_type_Tuk;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Tuk != null) {
      this.jdField_a_of_type_Tuk.d();
    }
    yej.a().b(this);
  }
  
  public void a(int paramInt)
  {
    if (this.b == null) {}
    for (;;)
    {
      return;
      if (paramInt > 0) {
        this.b.setText(tra.b(paramInt));
      }
      while (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null)
      {
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.commentCount.set(paramInt);
        return;
        this.b.setText(getResources().getString(2131698281));
      }
    }
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
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
          int j = localStFeedBusiReqData.pushList.count.get();
          int i = j;
          if (localStFeedBusiReqData.pushList.hasClickCount.get() == 0)
          {
            i = j;
            if (paramSimpleBaseEvent.mAllPushTimes > 0) {
              i = j + 1;
            }
          }
          localStFeedBusiReqData.pushList.hasClickCount.set(paramSimpleBaseEvent.mAllPushTimes);
          localStFeedBusiReqData.pushList.count.set(i);
          b(i);
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
        QLog.e(jdField_a_of_type_JavaLangString, 1, "receiveEvent error" + paramSimpleBaseEvent.getMessage());
        paramSimpleBaseEvent.printStackTrace();
      }
      a(((QCircleCommentUpdateEvent)paramSimpleBaseEvent).commentTotalNum);
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
    if (this.jdField_a_of_type_Tuk != null) {
      return this.jdField_a_of_type_Tuk.a();
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    if (this.c == null) {
      return;
    }
    if (paramInt > 0)
    {
      this.c.setText(tra.b(paramInt));
      return;
    }
    this.c.setText(getResources().getString(2131698358));
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Tuk != null) && (this.jdField_a_of_type_Tuk.b());
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Tuk == null);
      if (tym.a().c(57)) {
        tyk.a(6, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      }
      this.jdField_a_of_type_Tuk.f();
      this.jdField_a_of_type_Tuk.a(6);
      return;
      if (this.jdField_a_of_type_Ubi == null) {
        this.jdField_a_of_type_Ubi = new ubi(this.jdField_a_of_type_AndroidAppActivity);
      }
      this.jdField_a_of_type_Ubi.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      this.jdField_a_of_type_Ubi.a(false);
      return;
    } while (this.jdField_a_of_type_Tuk == null);
    if (tym.a().c(57)) {
      tyk.a(7, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    }
    this.jdField_a_of_type_Tuk.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
    this.jdField_a_of_type_Tuk.a(7);
    d();
  }
  
  public void setCommentPanelView(Activity paramActivity, ViewStub paramViewStub)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
    this.jdField_a_of_type_Tuk = new tuk(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Tuk.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewViewStub);
  }
  
  public void setCurrentAniView(QCirclePolymorphicAniView paramQCirclePolymorphicAniView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView = paramQCirclePolymorphicAniView;
  }
  
  public void setCurrentFeed(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setAniView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setFeedData(paramStFeed);
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
        if (!tra.a(paramStFeed.poster.id.get())) {
          break label137;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      while (this.jdField_a_of_type_Tuk != null)
      {
        this.jdField_a_of_type_Tuk.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView);
        this.jdField_a_of_type_Tuk.a(paramStFeed);
        return;
        label137:
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        setPushData(paramStFeed);
      }
    }
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
    if (this.jdField_a_of_type_Tuk != null) {
      this.jdField_a_of_type_Tuk.a(paramExtraTypeInfo);
    }
    if ((this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout != null) && ((paramExtraTypeInfo instanceof ReportExtraTypeInfo))) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setExtraTypeInfo((ReportExtraTypeInfo)paramExtraTypeInfo);
    }
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
        b(paramStFeed.count.get());
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramStFeed)
    {
      paramStFeed.printStackTrace();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentBottomBar
 * JD-Core Version:    0.7.0.1
 */