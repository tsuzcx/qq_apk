package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.comment.DateUtils;
import com.tencent.biz.subscribe.comment.Formatter;
import com.tencent.biz.subscribe.comment.LocalHeadFetchUtils;
import com.tencent.biz.subscribe.comment.OnCommentElementClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class WsCommentView
  extends RelativeLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private stSimpleMetaComment jdField_a_of_type_UserGrowthStSimpleMetaComment;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  WsCommentView.MoreCommentHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder;
  WsReplyContainer jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer;
  FeedRichTextView jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  private OnCommentElementClickListener jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public WsCommentView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WsCommentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WsCommentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    b();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131559989, this, true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131364941));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)localView.findViewById(2131363135));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.dpToPx(18.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372989));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)localView.findViewById(2131372969));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer = ((WsReplyContainer)localView.findViewById(2131376418));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131370027);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370026));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370028));
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131365759);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder = new WsCommentView.MoreCommentHolder();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131377500));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364948));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371500));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131363977));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder.c = ((TextView)localView.findViewById(2131364035));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365766));
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder;
    if ((localObject != null) && (((WsCommentView.MoreCommentHolder)localObject).jdField_b_of_type_AndroidWidgetLinearLayout != null)) {
      if ((paramBoolean) && (paramstSimpleMetaComment != null) && (paramstSimpleMetaComment.replyList.size() > 0))
      {
        localObject = DateUtils.a(paramstSimpleMetaComment.createtime * 1000L);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        if (paramstSimpleMetaComment.replyList.size() > 0)
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder.jdField_b_of_type_AndroidWidgetTextView;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramstSimpleMetaComment.replyNum);
          localStringBuilder.append(HardCodeUtil.a(2131702403));
          ((TextView)localObject).setText(localStringBuilder.toString());
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130851291);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166226));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130851252);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165327));
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    stSimpleMetaComment localstSimpleMetaComment;
    switch (paramView.getId())
    {
    default: 
    case 2131372989: 
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener;
      if (localObject != null)
      {
        localstSimpleMetaComment = this.jdField_a_of_type_UserGrowthStSimpleMetaComment;
        if (localstSimpleMetaComment != null)
        {
          ((OnCommentElementClickListener)localObject).a(paramView, 2, this.jdField_a_of_type_Int, localstSimpleMetaComment.poster);
          return;
        }
      }
      break;
    case 2131370027: 
      if (this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener != null)
      {
        this.jdField_a_of_type_Boolean = true;
        boolean bool;
        if (this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing == 1) {
          bool = true;
        } else {
          bool = false;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("点赞前 isDing：");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(",mComment.isDing:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing);
        WSLog.c("comment", ((StringBuilder)localObject).toString());
        a(bool);
        if (!bool)
        {
          WSLog.c("comment", "执行点赞 ...............");
          localObject = this.jdField_a_of_type_UserGrowthStSimpleMetaComment;
          ((stSimpleMetaComment)localObject).dingNum += 1L;
          this.jdField_b_of_type_AndroidWidgetTextView.setText(Formatter.a(this.jdField_a_of_type_UserGrowthStSimpleMetaComment.dingNum));
        }
        else if (this.jdField_a_of_type_UserGrowthStSimpleMetaComment.dingNum > 1L)
        {
          WSLog.c("comment", "执行点赞-1 ...............");
          localObject = this.jdField_a_of_type_UserGrowthStSimpleMetaComment;
          ((stSimpleMetaComment)localObject).dingNum -= 1L;
          this.jdField_b_of_type_AndroidWidgetTextView.setText(Formatter.a(this.jdField_a_of_type_UserGrowthStSimpleMetaComment.dingNum));
        }
        else
        {
          localObject = this.jdField_a_of_type_UserGrowthStSimpleMetaComment;
          ((stSimpleMetaComment)localObject).dingNum -= 1L;
          WSLog.c("comment", "执行取消点赞 ...............");
          this.jdField_b_of_type_AndroidWidgetTextView.setText("");
        }
        localObject = this.jdField_a_of_type_UserGrowthStSimpleMetaComment;
        ((stSimpleMetaComment)localObject).isDing = ((((stSimpleMetaComment)localObject).isDing + 1) % 2);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("点赞后 mComment.isDing：");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing);
        ((StringBuilder)localObject).append(",clickPosition:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        WSLog.c("comment", ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener.a(paramView, 6, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaComment);
        return;
      }
      WSLog.c("comment", "mOnCommentElementClickListener is null ...............");
      return;
    case 2131364941: 
    case 2131372969: 
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener;
      if (localObject != null)
      {
        ((OnCommentElementClickListener)localObject).a(paramView, 4, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaComment);
        return;
      }
      break;
    case 2131363135: 
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener;
      if (localObject != null)
      {
        localstSimpleMetaComment = this.jdField_a_of_type_UserGrowthStSimpleMetaComment;
        if (localstSimpleMetaComment != null) {
          ((OnCommentElementClickListener)localObject).a(paramView, 1, this.jdField_a_of_type_Int, localstSimpleMetaComment.poster);
        }
      }
      break;
    }
  }
  
  public void setData(stSimpleMetaComment paramstSimpleMetaComment, int paramInt, String paramString)
  {
    this.jdField_a_of_type_UserGrowthStSimpleMetaComment = paramstSimpleMetaComment;
    if (paramstSimpleMetaComment == null) {
      return;
    }
    stSimpleMetaPerson localstSimpleMetaPerson = paramstSimpleMetaComment.poster;
    boolean bool = true;
    if (localstSimpleMetaPerson != null)
    {
      if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramstSimpleMetaComment.poster.id)) && (StringUtil.a(paramstSimpleMetaComment.poster.avatar)))
      {
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(ImageUtil.c(LocalHeadFetchUtils.a(LocalHeadFetchUtils.a(null, 1, paramstSimpleMetaComment.poster.id, 0)).a, 50, 50));
        }
        UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, "", UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 18.0F), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
      }
      else
      {
        UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, paramstSimpleMetaComment.poster.avatar, UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 18.0F), ImageUtil.e(), null);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramstSimpleMetaComment.poster.nick);
      if (paramstSimpleMetaComment.poster.id.equals(paramString))
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130851305);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.dpToPx(21.0F), ImmersiveUtils.dpToPx(12.0F));
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(2.0F));
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramstSimpleMetaComment.wording);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder.jdField_a_of_type_AndroidWidgetTextView.setText(DateUtils.a(paramstSimpleMetaComment.createtime * 1000L));
    a(paramstSimpleMetaComment, false);
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaComment.replyList.size() == 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setVisibility(8);
    } else if (this.jdField_a_of_type_UserGrowthStSimpleMetaComment.replyList.size() > 0)
    {
      if (paramInt == 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.a(this.jdField_a_of_type_UserGrowthStSimpleMetaComment, paramInt, paramString);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setVisibility(8);
        a(paramstSimpleMetaComment, true);
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.a(this.jdField_a_of_type_UserGrowthStSimpleMetaComment, paramInt, paramString);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setVisibility(0);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setVisibility(8);
    }
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing != 0) {
      bool = false;
    }
    a(bool);
    if (paramstSimpleMetaComment.dingNum > 0L) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(Formatter.a(paramstSimpleMetaComment.dingNum));
    } else {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void setDisplayNum(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setDisplayNum(paramInt);
  }
  
  public void setOnCommentElementClickListener(OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener = paramOnCommentElementClickListener;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setOnCommentElementClickListener(paramOnCommentElementClickListener);
    paramOnCommentElementClickListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder;
    if ((paramOnCommentElementClickListener != null) && (paramOnCommentElementClickListener.jdField_b_of_type_AndroidWidgetLinearLayout != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new WsCommentView.1(this));
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setPosition(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentView
 * JD-Core Version:    0.7.0.1
 */