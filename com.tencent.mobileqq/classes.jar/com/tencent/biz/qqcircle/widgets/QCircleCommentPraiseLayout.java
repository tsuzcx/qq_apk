package com.tencent.biz.qqcircle.widgets;

import alud;
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
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import java.util.ArrayList;
import tra;
import ucp;
import ucq;
import xsm;
import yiw;
import yiy;

public class QCircleCommentPraiseLayout
  extends LinearLayout
  implements View.OnClickListener, yiy
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private FeedCloudMeta.StReply jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
  private ucq jdField_a_of_type_Ucq;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 2130843556;
  private boolean jdField_b_of_type_Boolean;
  private int c = 2130843558;
  
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
    localLayoutParams.rightMargin = xsm.a(getContext(), 3.0F);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(xsm.a(getContext(), 16.0F), xsm.a(getContext(), 16.0F));
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    setTouchDelegate(this.jdField_a_of_type_AndroidWidgetImageView, 30);
  }
  
  private void b()
  {
    try
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(getResources().getDrawable(this.c));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166181));
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
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166180));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleCommentPraiseLay", 1, "showUnLikeView setBackgroundDrawable error");
    }
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(tra.b(paramLong));
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
    yiw.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(getContext(), alud.a(2131702558), 0).a();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    paramView = new FeedCloudMeta.StLike();
    int i;
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null))
    {
      paramView = (FeedCloudMeta.StLike)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.get();
      if (paramView.status.get() == 0) {
        i = 3;
      }
    }
    for (;;)
    {
      boolean bool;
      label118:
      int m;
      label140:
      label176:
      int n;
      if (this.jdField_a_of_type_Ucq != null)
      {
        ucq localucq = this.jdField_a_of_type_Ucq;
        if (paramView.status.get() == 0)
        {
          bool = true;
          localucq.a(bool);
        }
      }
      else
      {
        if (paramView.status.get() != 0) {
          break label315;
        }
        m = 1;
        if ((this.jdField_a_of_type_Int != 1) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null)) {
          break label326;
        }
        k = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.count.get();
        if (m != 1) {
          break label321;
        }
        n = k + j;
        j = k;
        k = n;
      }
      for (;;)
      {
        a(m, k);
        n = paramView.status.get();
        VSNetworkHelper.a().a(getContext(), new QCircleDoLikeRequest(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, i, paramView, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply), new ucp(this, m, k, n, j));
        return;
        i = 4;
        break;
        if ((this.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null)) {
          break label390;
        }
        paramView = (FeedCloudMeta.StLike)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.get();
        if (paramView.status.get() == 0) {}
        for (i = 5;; i = 6) {
          break;
        }
        bool = false;
        break label118;
        label315:
        m = 0;
        break label140;
        label321:
        j = -1;
        break label176;
        label326:
        if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null))
        {
          n = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.count.get();
          if (m == 1) {}
          for (j = k;; j = -1)
          {
            k = n + j;
            j = n;
            break;
          }
        }
        k = 0;
        j = 0;
      }
      label390:
      i = 0;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yiw.a().b(this);
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
  
  public void setOnClickHookListener(ucq paramucq)
  {
    this.jdField_a_of_type_Ucq = paramucq;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout
 * JD-Core Version:    0.7.0.1
 */