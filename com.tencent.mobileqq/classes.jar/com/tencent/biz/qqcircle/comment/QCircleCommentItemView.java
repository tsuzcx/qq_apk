package com.tencent.biz.qqcircle.comment;

import alpo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import tuh;
import tui;
import tuj;
import ycr;
import yde;
import yej;
import yel;

public class QCircleCommentItemView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener, yel
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
  public tuj a;
  private yde jdField_a_of_type_Yde;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private QCircleAsyncTextView jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private Drawable c;
  private Drawable d;
  
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
    View localView = LayoutInflater.from(getContext()).inflate(2131560521, this, true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131364539));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)localView.findViewById(2131362973));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)localView.findViewById(2131372196));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)localView.findViewById(2131372189));
    this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer = ((ItemReplyContainer)localView.findViewById(2131375606));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131375610));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout = ((QCircleCommentPraiseLayout)localView.findViewById(2131372204));
    this.jdField_a_of_type_Tuj = new tuj();
    this.jdField_a_of_type_Tuj.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131376610));
    this.jdField_a_of_type_Tuj.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364546));
    this.jdField_a_of_type_Tuj.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370731));
    this.jdField_a_of_type_Tuj.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131363631));
    this.jdField_a_of_type_Tuj.c = ((TextView)localView.findViewById(2131363685));
    this.jdField_a_of_type_Tuj.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365359));
  }
  
  private void a(FeedCloudMeta.StComment paramStComment)
  {
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.b();
    if (paramStComment.typeFlag.get() == 1)
    {
      if (this.d == null)
      {
        this.d = getResources().getDrawable(2130843540);
        this.d.setBounds(ImmersiveUtils.a(2.0F), 0, ImmersiveUtils.a(33.0F), ImmersiveUtils.a(14.0F));
      }
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setEndSpanIcon(this.d);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.c();
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setText(paramStComment.content.get());
      return;
      if (paramStComment.likeInfo.ownerStatus.get() == 1)
      {
        if (this.c == null)
        {
          this.c = getResources().getDrawable(2130843539);
          this.c.setBounds(ImmersiveUtils.a(2.0F), 0, ImmersiveUtils.a(52.0F), ImmersiveUtils.a(14.0F));
        }
        this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setEndSpanIcon(this.c);
      }
      else
      {
        this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setEndSpanIcon(null);
      }
    }
  }
  
  private void a(FeedCloudMeta.StComment paramStComment, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Tuj != null) && (this.jdField_a_of_type_Tuj.jdField_b_of_type_AndroidWidgetLinearLayout != null))
    {
      if ((!paramBoolean) || (paramStComment == null) || (paramStComment.vecReply.size() <= 0)) {
        break label137;
      }
      String str = ycr.a(paramStComment.createTime.get() * 1000L);
      this.jdField_a_of_type_Tuj.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_Tuj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_Tuj.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      if (paramStComment.vecReply.size() > 0) {
        this.jdField_a_of_type_Tuj.jdField_b_of_type_AndroidWidgetTextView.setText(tra.a(paramStComment.replyCount.get(), true) + alpo.a(2131702589));
      }
    }
    return;
    label137:
    this.jdField_a_of_type_Tuj.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_Tuj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnLongClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this);
    this.jdField_a_of_type_Tuj.c.setOnClickListener(this);
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
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
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    yej.a().a(this);
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
          } while ((this.jdField_a_of_type_Yde == null) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null));
          this.jdField_a_of_type_Yde.a(paramView, 1, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser);
          return;
        } while ((this.jdField_a_of_type_Yde == null) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null));
        this.jdField_a_of_type_Yde.a(paramView, 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser);
        return;
      } while (this.jdField_a_of_type_Yde == null);
      this.jdField_a_of_type_Yde.a(paramView, 4, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
      return;
    } while (this.jdField_a_of_type_Yde == null);
    this.jdField_a_of_type_Yde.a(paramView, 13, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yej.a().b(this);
  }
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_Yde != null) {
      this.jdField_a_of_type_Yde.b(paramView, 5, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
    }
    return true;
  }
  
  public void setData(FeedCloudMeta.StComment paramStComment, int paramInt, FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
    this.jdField_b_of_type_Int = paramInt;
    if ((paramStComment == null) || (paramStFeed == null)) {
      return;
    }
    if (paramStComment.postUser != null)
    {
      if ((getContext() instanceof BaseActivity)) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(((BaseActivity)getContext()).app, paramStComment.postUser);
      }
      if (paramStComment.postUser.id.get().equals(paramStFeed.poster.id.get()))
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130843538);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(ImmersiveUtils.a(2.0F), 0, ImmersiveUtils.a(33.0F), ImmersiveUtils.a(14.0F));
        }
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setEndSpanIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setText(paramStComment.postUser.nick.get());
      }
    }
    else
    {
      a(paramStComment);
      this.jdField_a_of_type_Tuj.jdField_a_of_type_AndroidWidgetTextView.setText(ycr.a(paramStComment.createTime.get() * 1000L));
      a(paramStComment, false);
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.size() != 0) {
        break label338;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout.setData(1, paramStFeed, paramStComment, null, true);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout.setOnClickHookListener(new tui(this));
      return;
      if (paramStComment.postUser.frdState.get() == 1)
      {
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130843537);
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(ImmersiveUtils.a(2.0F), 0, ImmersiveUtils.a(33.0F), ImmersiveUtils.a(14.0F));
        }
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setEndSpanIcon(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setEndSpanIcon(null);
      break;
      label338:
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.size() > 0)
      {
        if (paramInt == 0)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, paramInt, paramStFeed);
          this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          a(paramStComment, true);
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, paramInt, paramStFeed);
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
  
  public void setDisplayNum(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.setDisplayNum(paramInt);
  }
  
  public void setOnCommentElementClickListener(yde paramyde)
  {
    this.jdField_a_of_type_Yde = paramyde;
    this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.setOnCommentElementClickListener(paramyde);
    if ((this.jdField_a_of_type_Tuj != null) && (this.jdField_a_of_type_Tuj.jdField_b_of_type_AndroidWidgetLinearLayout != null)) {
      this.jdField_a_of_type_Tuj.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new tuh(this));
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