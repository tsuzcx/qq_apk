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
import android.widget.RelativeLayout;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout;
import com.tencent.biz.subscribe.comment.ReplyView;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import tra;
import tuh;
import tui;
import yhn;
import yiw;
import yiy;

public class ItemReplyView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener, yiy
{
  private static final String jdField_a_of_type_JavaLangString = ReplyView.class.getName();
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private QCircleAsyncTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private QCircleCommentPraiseLayout jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private FeedCloudMeta.StReply jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
  private yhn jdField_a_of_type_Yhn;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private QCircleAsyncTextView jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private final String jdField_b_of_type_JavaLangString = alud.a(2131713804);
  private Drawable c;
  
  public ItemReplyView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ItemReplyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ItemReplyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    b();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560591, this, true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)localView.findViewById(2131375673));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)localView.findViewById(2131375671));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setNeedParseColor(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout = ((QCircleCommentPraiseLayout)localView.findViewById(2131372224));
  }
  
  private void a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramStComment != null) && (paramStReply.targetUser != null) && (!TextUtils.isEmpty(paramStReply.targetUser.id.get())))
    {
      localSpannableStringBuilder.append(this.jdField_b_of_type_JavaLangString).append(paramStReply.targetUser.nick.get());
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, this.jdField_b_of_type_JavaLangString.length(), this.jdField_b_of_type_JavaLangString.length() + paramStReply.targetUser.nick.get().length(), new tui(this, paramStReply));
      if (paramStReply.targetUser.id.get().equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get()))
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130843553);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(ImmersiveUtils.a(2.0F), 0, ImmersiveUtils.a(33.0F), ImmersiveUtils.a(14.0F));
        }
        this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      localSpannableStringBuilder.append("：");
    }
    localSpannableStringBuilder.append(paramStReply.content.get());
    if (paramStReply.typeFlag.get() == 1)
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
      if (paramStReply.likeInfo.ownerStatus.get() == 1)
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
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnLongClickListener(this);
    setOnLongClickListener(this);
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
    case 2131375672: 
    default: 
      if (((paramView instanceof ReplyView)) && (this.jdField_a_of_type_Yhn != null))
      {
        localStComment = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
        localStReply = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
        this.jdField_a_of_type_Yhn.a(paramView, 7, this.jdField_a_of_type_Int, new Object[] { localStComment, localStReply });
      }
      break;
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Yhn == null) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null));
      this.jdField_a_of_type_Yhn.a(paramView, 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser);
      return;
    } while (this.jdField_a_of_type_Yhn == null);
    FeedCloudMeta.StComment localStComment = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
    FeedCloudMeta.StReply localStReply = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
    this.jdField_a_of_type_Yhn.a(paramView, 7, this.jdField_a_of_type_Int, new Object[] { localStComment, localStReply });
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yiw.a().b(this);
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = true;
    switch (paramView.getId())
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
    } while (this.jdField_a_of_type_Yhn == null);
    FeedCloudMeta.StComment localStComment = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
    FeedCloudMeta.StReply localStReply = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
    this.jdField_a_of_type_Yhn.b(paramView, 8, this.jdField_a_of_type_Int, new Object[] { localStComment, localStReply });
    return true;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((!(paramSimpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent)) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) || (!TextUtils.equals(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mFeedId, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()))) {}
    while ((((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mType != 2) || (!TextUtils.equals(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mCommentId, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get())) || (!TextUtils.equals(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mReplyId, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get()))) {
      return;
    }
    if (tra.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.get())) {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.ownerStatus.set(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mPraisedStatus);
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.status.set(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mPraisedStatus);
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.count.set(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mPraisedNum);
    a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
  }
  
  public void setData(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply = paramStReply;
    if ((paramStFeed == null) || (paramStComment == null) || (paramStReply == null)) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder;
    if ((paramStReply.postUser != null) && (paramStReply.postUser.nick.get() != null))
    {
      localSpannableStringBuilder = new SpannableStringBuilder(paramStReply.postUser.nick.get());
      if (!paramStReply.postUser.id.get().equals(paramStFeed.poster.id.get())) {
        break label204;
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130843553);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(ImmersiveUtils.a(2.0F), 0, ImmersiveUtils.a(33.0F), ImmersiveUtils.a(14.0F));
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setText(localSpannableStringBuilder);
      a(paramStComment, paramStReply);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout.setData(2, paramStFeed, paramStComment, paramStReply, true);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout.setOnClickHookListener(new tuh(this));
      return;
      label204:
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(false);
    }
  }
  
  public void setOnCommentElementClickListener(yhn paramyhn)
  {
    this.jdField_a_of_type_Yhn = paramyhn;
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.ItemReplyView
 * JD-Core Version:    0.7.0.1
 */