package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anni;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import java.util.ArrayList;
import uxx;
import vvt;
import vvu;
import zlx;
import zwp;
import zwr;
import zxl;

public class QCircleCommentPraiseLayout
  extends LinearLayout
  implements View.OnClickListener, zwr, zxl<QCircleReportBean>
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private FeedCloudMeta.StReply jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
  private vvu jdField_a_of_type_Vvu;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 2130843958;
  private boolean jdField_b_of_type_Boolean;
  private int c = 2130843960;
  
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
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = zlx.a(getContext(), 3.0F);
    localLayoutParams.gravity = 16;
    localLayoutParams.bottomMargin = zlx.a(getContext(), 0.5F);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(zlx.a(getContext(), 20.0F), zlx.a(getContext(), 20.0F));
    localLayoutParams.gravity = 16;
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    setTouchDelegate(this.jdField_a_of_type_AndroidWidgetImageView, 30);
  }
  
  private boolean a()
  {
    return QCircleReportBean.isContentDetailPage(QCircleReportBean.getPageId("QCircleCommentPraiseLay", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean));
  }
  
  private void b()
  {
    try
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(getResources().getDrawable(this.c));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166249));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleCommentPraiseLay", 1, "showLikeView setBackgroundDrawable error");
    }
  }
  
  private void c()
  {
    try
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(getResources().getDrawable(this.jdField_b_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166248));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleCommentPraiseLay", 1, "showUnLikeView setBackgroundDrawable error");
    }
  }
  
  public QCircleReportBean a()
  {
    return QCircleReportBean.getReportBean("QCircleCommentPraiseLay", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramInt == 1) {
      b();
    }
    while (this.jdField_b_of_type_Boolean) {
      if (paramLong == 0L)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
        if (paramInt == 0) {
          c();
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(uxx.d(paramLong));
        return;
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    zwp.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
      QQToast.a(getContext(), anni.a(2131700978), 0).a();
    }
    this.jdField_a_of_type_Boolean = false;
    FeedCloudMeta.StLike localStLike = new FeedCloudMeta.StLike();
    int i;
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null))
    {
      localStLike = (FeedCloudMeta.StLike)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.get();
      if (localStLike.status.get() == 0) {
        i = 3;
      }
    }
    for (;;)
    {
      label104:
      boolean bool;
      label131:
      int m;
      if (this.jdField_a_of_type_Vvu != null)
      {
        vvu localvvu = this.jdField_a_of_type_Vvu;
        if (localStLike.status.get() == 0)
        {
          bool = true;
          localvvu.a(bool);
        }
      }
      else
      {
        if (localStLike.status.get() != 0) {
          break label330;
        }
        m = 1;
        label154:
        if ((this.jdField_a_of_type_Int != 1) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null)) {
          break label341;
        }
        k = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.count.get();
        if (m != 1) {
          break label336;
        }
        label190:
        j = k + j;
      }
      for (;;)
      {
        a(m, j);
        int n = localStLike.status.get();
        VSNetworkHelper.a().a(getContext(), new QCircleDoLikeRequest(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, i, localStLike, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply, a()), new vvt(this, m, j, n, k));
        break;
        i = 4;
        break label104;
        if ((this.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null)) {
          break label405;
        }
        localStLike = (FeedCloudMeta.StLike)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.get();
        if (localStLike.status.get() == 0) {}
        for (i = 5;; i = 6) {
          break;
        }
        bool = false;
        break label131;
        label330:
        m = 0;
        break label154;
        label336:
        j = -1;
        break label190;
        label341:
        if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null))
        {
          n = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.count.get();
          if (m == 1) {}
          for (j = k;; j = -1)
          {
            j = n + j;
            k = n;
            break;
          }
        }
        j = 0;
        k = 0;
      }
      label405:
      i = 0;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    zwp.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent)) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && (TextUtils.equals(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mFeedId, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get())))
    {
      paramSimpleBaseEvent = (QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent;
      if ((this.jdField_a_of_type_Int != 1) || (paramSimpleBaseEvent.mType != 1) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (!TextUtils.equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), paramSimpleBaseEvent.mCommentId))) {
        break label133;
      }
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.status.set(paramSimpleBaseEvent.mPraisedStatus);
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.count.set(paramSimpleBaseEvent.mPraisedNum);
      a(paramSimpleBaseEvent.mPraisedStatus, paramSimpleBaseEvent.mPraisedNum);
    }
    label133:
    while ((this.jdField_a_of_type_Int != 2) || (paramSimpleBaseEvent.mType != 2) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) || (!TextUtils.equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), paramSimpleBaseEvent.mCommentId)) || (!TextUtils.equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get(), paramSimpleBaseEvent.mReplyId))) {
      return;
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.status.set(paramSimpleBaseEvent.mPraisedStatus);
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.count.set(paramSimpleBaseEvent.mPraisedNum);
    a(paramSimpleBaseEvent.mPraisedStatus, paramSimpleBaseEvent.mPraisedNum);
  }
  
  public void setData(int paramInt, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    setData(paramInt, paramStFeed, paramStComment, paramStReply, false);
  }
  
  public void setData(int paramInt, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, boolean paramBoolean)
  {
    setVisibility(8);
    if (paramStFeed == null) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply = paramStReply;
        this.jdField_b_of_type_Boolean = paramBoolean;
        if (this.jdField_a_of_type_Int != 1) {
          break;
        }
      } while (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null);
      a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.status.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.count.get());
      setVisibility(0);
      return;
    } while ((this.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null));
    a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.status.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.count.get());
    setVisibility(0);
  }
  
  public void setOnClickHookListener(vvu paramvvu)
  {
    this.jdField_a_of_type_Vvu = paramvvu;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = QCircleReportBean.setReportBean("QCircleCommentPraiseLay", paramQCircleReportBean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout
 * JD-Core Version:    0.7.0.1
 */