package com.tencent.biz.qqcircle.comment;

import alud;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import tra;
import tuw;
import tux;
import tuy;
import xsm;
import yha;
import yhn;
import yiw;
import yiy;

public class QCircleCommentItemView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener, yiy
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ItemReplyContainer jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer;
  private QCircleAsyncTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleCommentPraiseLayout jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  public tuy a;
  private yhn jdField_a_of_type_Yhn;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private QCircleAsyncTextView jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private Drawable c;
  
  public QCircleCommentItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleCommentItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleCommentItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    b();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560522, this, true);
    localView.setPadding(0, 0, 0, xsm.a(getContext(), 12.0F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131364541));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)localView.findViewById(2131362973));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)localView.findViewById(2131372216));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)localView.findViewById(2131372209));
    this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer = ((ItemReplyContainer)localView.findViewById(2131375657));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131375661));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout = ((QCircleCommentPraiseLayout)localView.findViewById(2131372224));
    this.jdField_a_of_type_Tuy = new tuy();
    this.jdField_a_of_type_Tuy.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131376664));
    this.jdField_a_of_type_Tuy.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364548));
    this.jdField_a_of_type_Tuy.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370750));
    this.jdField_a_of_type_Tuy.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131363633));
    this.jdField_a_of_type_Tuy.c = ((TextView)localView.findViewById(2131363687));
    this.jdField_a_of_type_Tuy.c.setVisibility(8);
    this.jdField_a_of_type_Tuy.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365361));
  }
  
  private void a(FeedCloudMeta.StComment paramStComment)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramStComment.content.get());
    if (paramStComment.typeFlag.get() == 1)
    {
      if (this.c == null)
      {
        this.c = getResources().getDrawable(2130843555);
        this.c.setBounds(ImmersiveUtils.a(2.0F), 0, ImmersiveUtils.a(33.0F), ImmersiveUtils.a(14.0F));
      }
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.c);
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(true);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.c();
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setText(localSpannableStringBuilder);
      return;
      if (paramStComment.likeInfo.ownerStatus.get() == 1)
      {
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130843554);
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(ImmersiveUtils.a(2.0F), 0, ImmersiveUtils.a(52.0F), ImmersiveUtils.a(14.0F));
        }
        this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(true);
      }
      else
      {
        this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(false);
      }
    }
  }
  
  private void a(FeedCloudMeta.StComment paramStComment, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Tuy != null) && (this.jdField_a_of_type_Tuy.jdField_b_of_type_AndroidWidgetLinearLayout != null))
    {
      if ((!paramBoolean) || (paramStComment == null) || (paramStComment.vecReply.size() <= 0)) {
        break label138;
      }
      String str = yha.a(paramStComment.createTime.get() * 1000L);
      this.jdField_a_of_type_Tuy.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_Tuy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_Tuy.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      if (paramStComment.vecReply.size() > 0) {
        this.jdField_a_of_type_Tuy.jdField_b_of_type_AndroidWidgetTextView.setText(tra.a(paramStComment.replyCount.get(), true) + alud.a(2131702601));
      }
    }
    return;
    label138:
    this.jdField_a_of_type_Tuy.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_Tuy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnLongClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this);
    this.jdField_a_of_type_Tuy.c.setOnClickListener(this);
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer;
  }
  
  public FeedCloudMeta.StComment a()
  {
    return this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
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
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while ((this.jdField_a_of_type_Yhn == null) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null));
          this.jdField_a_of_type_Yhn.a(paramView, 1, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser);
          return;
        } while ((this.jdField_a_of_type_Yhn == null) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null));
        this.jdField_a_of_type_Yhn.a(paramView, 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser);
        return;
      } while (this.jdField_a_of_type_Yhn == null);
      this.jdField_a_of_type_Yhn.a(paramView, 4, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
      return;
    } while (this.jdField_a_of_type_Yhn == null);
    this.jdField_a_of_type_Yhn.a(paramView, 13, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yiw.a().b(this);
  }
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_Yhn != null) {
      this.jdField_a_of_type_Yhn.b(paramView, 5, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
    }
    return true;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((!(paramSimpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent)) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (!TextUtils.equals(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mFeedId, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()))) {}
    while ((((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mType != 1) || (!TextUtils.equals(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mCommentId, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get()))) {
      return;
    }
    if (tra.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.get())) {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.ownerStatus.set(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mPraisedStatus);
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.status.set(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mPraisedStatus);
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.count.set(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mPraisedNum);
    a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
  }
  
  public void setData(FeedCloudMeta.StComment paramStComment, int paramInt1, FeedCloudMeta.StFeed paramStFeed, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
    if ((paramStComment == null) || (paramStFeed == null)) {
      return;
    }
    if ((paramStComment.postUser != null) && (paramStComment.postUser.nick.get() != null))
    {
      if ((getContext() instanceof BaseActivity)) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(((BaseActivity)getContext()).app, paramStComment.postUser);
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramStComment.postUser.nick.get());
      if (paramStComment.postUser.id.get().equals(paramStFeed.poster.id.get()))
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130843553);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(ImmersiveUtils.a(2.0F), 0, ImmersiveUtils.a(33.0F), ImmersiveUtils.a(14.0F));
        }
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(true);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setText(localSpannableStringBuilder);
      }
    }
    else
    {
      a(paramStComment);
      this.jdField_a_of_type_Tuy.jdField_a_of_type_AndroidWidgetTextView.setText(yha.a(paramStComment.createTime.get() * 1000L));
      a(paramStComment, false);
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.size() != 0) {
        break label301;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout.setData(1, paramStFeed, paramStComment, null, true);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout.setOnClickHookListener(new tux(this));
      return;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(false);
      break;
      label301:
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.size() > 0)
      {
        if (paramInt1 == 0)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          a(paramStComment, true);
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, paramInt1, paramStFeed, paramInt2, paramBoolean);
          this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  public void setOnCommentElementClickListener(yhn paramyhn)
  {
    this.jdField_a_of_type_Yhn = paramyhn;
    this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.setOnCommentElementClickListener(paramyhn);
    if ((this.jdField_a_of_type_Tuy != null) && (this.jdField_a_of_type_Tuy.jdField_b_of_type_AndroidWidgetLinearLayout != null)) {
      this.jdField_a_of_type_Tuy.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new tuw(this));
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.setPosition(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentItemView
 * JD-Core Version:    0.7.0.1
 */