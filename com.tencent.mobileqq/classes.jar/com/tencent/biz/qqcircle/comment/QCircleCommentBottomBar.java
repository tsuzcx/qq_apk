package com.tencent.biz.qqcircle.comment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
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
import trw;
import tuj;
import tuz;
import tzw;
import tzy;
import udz;
import yiw;
import yiy;

public class QCircleCommentBottomBar
  extends BaseWidgetView<FeedCloudMeta.StFeed>
  implements View.OnClickListener, yiy
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCirclePolyParseFrameLayout jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout;
  private QCirclePraiseTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView;
  private QCircleRecommendImageView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private FeedCloudMeta.StReply jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
  private udz jdField_a_of_type_Udz;
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
  }
  
  private String a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (paramStReply != null)
    {
      if (paramStReply.postUser == null) {
        break label162;
      }
      paramStReply = String.format(getContext().getString(2131692456), new Object[] { paramStReply.postUser.nick.get() });
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
      paramStReply = String.format(getContext().getString(2131692456), new Object[] { paramStComment.postUser.nick.get() });
      paramStComment = paramStReply;
    } while (paramStReply.length() <= 10);
    paramStComment = paramStReply.substring(0, 10);
    return paramStComment + "...";
    label162:
    return null;
  }
  
  private void b()
  {
    yiw.a().a(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private void c()
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = null;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply = null;
    a(getContext().getString(2131698290));
  }
  
  public int a()
  {
    return 2131560528;
  }
  
  public QCirclePolymorphicAniView a()
  {
    if ((a() instanceof trw)) {
      return ((trw)a()).a();
    }
    return null;
  }
  
  public ExtraTypeInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  }
  
  public tuz a()
  {
    if ((a() instanceof trw)) {
      return ((trw)a()).a();
    }
    return null;
  }
  
  public void a()
  {
    if (a() != null) {
      a().e();
    }
    yiw.a().b(this);
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
        this.b.setText(getResources().getString(2131698283));
      }
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369625));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout = ((QCirclePolyParseFrameLayout)findViewById(2131368863));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378648));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView = ((QCircleRecommendImageView)findViewById(2131368790));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368750));
    this.b = ((TextView)findViewById(2131368749));
    this.c = ((TextView)findViewById(2131368791));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView = ((QCirclePraiseTextView)findViewById(2131368865));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setUnPraiseDrawable(2130843573);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setPraisedDrawable(2130843562);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setIsContentDetail(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setPageType(2);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setBackgroundDrawable(getResources().getDrawable(2130843562));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setReportListener(new tuj(this));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView.setEmptyText(getResources().getString(2131698365));
    b();
  }
  
  protected void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setAniView(a());
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
          break label146;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      while ((a() != null) && (a().a() != null))
      {
        a().a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
        a().g();
        return;
        label146:
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        setPushData(paramStFeed);
      }
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
    if (a() != null) {
      return a().a();
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
    this.c.setText(getResources().getString(2131698370));
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    localArrayList.add(QCircleForwardEvent.class);
    localArrayList.add(QCirclePushUpdateEvent.class);
    return localArrayList;
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
      } while (a() == null);
      if (tzy.a().c(57)) {
        tzw.a(6, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      }
      a().a(a());
      a().a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      a().g();
      a().a(6);
      return;
      if (this.jdField_a_of_type_Udz == null) {
        this.jdField_a_of_type_Udz = new udz(this.jdField_a_of_type_AndroidAppActivity);
      }
      this.jdField_a_of_type_Udz.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      this.jdField_a_of_type_Udz.a(false);
      return;
    } while (a() == null);
    if (tzy.a().c(57)) {
      tzw.a(7, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    }
    a().a(a());
    a().a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
    a().a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
    a().a(7);
    c();
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
        QLog.e("QCircleCommentBottomBar", 1, "receiveEvent error" + paramSimpleBaseEvent.getMessage());
        paramSimpleBaseEvent.printStackTrace();
      }
      a(((QCircleCommentUpdateEvent)paramSimpleBaseEvent).commentTotalNum);
    }
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
    if (a() != null) {
      a().a(paramExtraTypeInfo);
    }
    if ((this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout != null) && ((paramExtraTypeInfo instanceof ReportExtraTypeInfo))) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setExtraTypeInfo((ReportExtraTypeInfo)paramExtraTypeInfo);
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