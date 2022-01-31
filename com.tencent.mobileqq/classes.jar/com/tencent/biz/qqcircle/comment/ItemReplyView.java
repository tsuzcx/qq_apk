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
import tts;
import ttt;
import yde;
import yej;
import yel;

public class ItemReplyView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener, yel
{
  private static final String jdField_a_of_type_JavaLangString = ReplyView.class.getName();
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private QCircleAsyncTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private QCircleCommentPraiseLayout jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private FeedCloudMeta.StReply jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
  private yde jdField_a_of_type_Yde;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private QCircleAsyncTextView jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private final String jdField_b_of_type_JavaLangString = alpo.a(2131713792);
  private Drawable c;
  private Drawable d;
  
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
    View localView = LayoutInflater.from(getContext()).inflate(2131560574, this, true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)localView.findViewById(2131375622));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)localView.findViewById(2131375620));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setNeedParseColor(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout = ((QCircleCommentPraiseLayout)localView.findViewById(2131372204));
  }
  
  private void a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.b();
    if (paramStReply.typeFlag.get() == 1)
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
      StringBuilder localStringBuilder = new StringBuilder();
      if ((paramStComment != null) && (paramStReply.targetUser != null) && (!TextUtils.isEmpty(paramStReply.targetUser.id.get())))
      {
        localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
        localStringBuilder.append(paramStReply.targetUser.nick.get());
        this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(2, paramStReply.targetUser.nick.get().length() + 1, new ttt(this, paramStReply));
        localStringBuilder.append("：");
      }
      localStringBuilder.append(paramStReply.content.get());
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setText(localStringBuilder);
      return;
      if (paramStReply.likeInfo.ownerStatus.get() == 1)
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
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnLongClickListener(this);
    setOnLongClickListener(this);
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
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
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    yej.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131375621: 
    default: 
      if (((paramView instanceof ReplyView)) && (this.jdField_a_of_type_Yde != null))
      {
        localStComment = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
        localStReply = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
        this.jdField_a_of_type_Yde.a(paramView, 7, this.jdField_a_of_type_Int, new Object[] { localStComment, localStReply });
      }
      break;
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Yde == null) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null));
      this.jdField_a_of_type_Yde.a(paramView, 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser);
      return;
    } while (this.jdField_a_of_type_Yde == null);
    FeedCloudMeta.StComment localStComment = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
    FeedCloudMeta.StReply localStReply = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
    this.jdField_a_of_type_Yde.a(paramView, 7, this.jdField_a_of_type_Int, new Object[] { localStComment, localStReply });
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yej.a().b(this);
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
    } while (this.jdField_a_of_type_Yde == null);
    FeedCloudMeta.StComment localStComment = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
    FeedCloudMeta.StReply localStReply = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
    this.jdField_a_of_type_Yde.b(paramView, 8, this.jdField_a_of_type_Int, new Object[] { localStComment, localStReply });
    return true;
  }
  
  public void setData(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply = paramStReply;
    if ((paramStFeed == null) || (paramStComment == null) || (paramStReply == null)) {
      return;
    }
    if (paramStReply.postUser != null)
    {
      if (!paramStReply.postUser.id.get().equals(paramStFeed.poster.id.get())) {
        break label166;
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130843538);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(ImmersiveUtils.a(2.0F), 0, ImmersiveUtils.a(33.0F), ImmersiveUtils.a(14.0F));
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setEndSpanIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setText(paramStReply.postUser.nick.get());
      a(paramStComment, paramStReply);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout.setData(2, paramStFeed, paramStComment, paramStReply, true);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout.setOnClickHookListener(new tts(this));
      return;
      label166:
      if (paramStReply.postUser.frdState.get() == 1)
      {
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130843537);
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(ImmersiveUtils.a(2.0F), 0, ImmersiveUtils.a(33.0F), ImmersiveUtils.a(14.0F));
        }
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setEndSpanIcon(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setEndSpanIcon(null);
      }
    }
  }
  
  public void setOnCommentElementClickListener(yde paramyde)
  {
    this.jdField_a_of_type_Yde = paramyde;
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