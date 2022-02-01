package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;

public class CommentView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private int jdField_a_of_type_Int;
  private CertifiedAccountMeta.StComment jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  CommentView.MoreCommentHolder jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$MoreCommentHolder;
  private OnCommentElementClickListener jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener;
  ReplyContainer jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer;
  AsyncRichTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public CommentView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CommentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    b();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131558785, this, true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131364941));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)localView.findViewById(2131363135));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.dpToPx(18.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372989));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)localView.findViewById(2131372969));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer = ((ReplyContainer)localView.findViewById(2131376418));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131370027);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370026));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370028));
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131365759);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$MoreCommentHolder = new CommentView.MoreCommentHolder();
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$MoreCommentHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131377500));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$MoreCommentHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364948));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$MoreCommentHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371500));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$MoreCommentHolder.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131363977));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$MoreCommentHolder.c = ((TextView)localView.findViewById(2131364035));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$MoreCommentHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365766));
  }
  
  private void a(CertifiedAccountMeta.StComment paramStComment, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$MoreCommentHolder;
    if ((localObject != null) && (((CommentView.MoreCommentHolder)localObject).jdField_b_of_type_AndroidWidgetLinearLayout != null)) {
      if ((paramBoolean) && (paramStComment != null) && (paramStComment.vecReply.size() > 0))
      {
        localObject = DateUtils.a(paramStComment.createTime.get() * 1000L);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$MoreCommentHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$MoreCommentHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$MoreCommentHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        if (paramStComment.vecReply.size() > 0)
        {
          localObject = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$MoreCommentHolder.jdField_b_of_type_AndroidWidgetTextView;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramStComment.replyCount);
          localStringBuilder.append(HardCodeUtil.a(2131702403));
          ((TextView)localObject).setText(localStringBuilder.toString());
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$MoreCommentHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$MoreCommentHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setOnLongClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this);
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer;
  }
  
  public ReplyView a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.a(paramString);
  }
  
  public void onClick(View paramView)
  {
    OnCommentElementClickListener localOnCommentElementClickListener;
    CertifiedAccountMeta.StComment localStComment;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131372989: 
      localOnCommentElementClickListener = this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener;
      if (localOnCommentElementClickListener != null)
      {
        localStComment = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
        if (localStComment != null) {
          localOnCommentElementClickListener.a(paramView, 2, this.jdField_a_of_type_Int, localStComment.postUser);
        }
      }
      break;
    case 2131364941: 
    case 2131372969: 
      localOnCommentElementClickListener = this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener;
      if (localOnCommentElementClickListener != null) {
        localOnCommentElementClickListener.a(paramView, 4, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment);
      }
      break;
    case 2131363135: 
      localOnCommentElementClickListener = this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener;
      if (localOnCommentElementClickListener != null)
      {
        localStComment = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
        if (localStComment != null) {
          localOnCommentElementClickListener.a(paramView, 1, this.jdField_a_of_type_Int, localStComment.postUser);
        }
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131364941) && (i != 2131372969)) {
      return false;
    }
    OnCommentElementClickListener localOnCommentElementClickListener = this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener;
    if (localOnCommentElementClickListener != null) {
      localOnCommentElementClickListener.b(paramView, 5, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment);
    }
    return true;
  }
  
  public void setData(CertifiedAccountMeta.StComment paramStComment, int paramInt, String paramString)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment = paramStComment;
    if (paramStComment == null) {
      return;
    }
    CertifiedAccountMeta.StUser localStUser = paramStComment.postUser;
    int i = 0;
    if (localStUser != null)
    {
      if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramStComment.postUser.id.get())) && (StringUtil.a(paramStComment.postUser.icon.get())))
      {
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(ImageUtil.c(LocalHeadFetchUtils.a(LocalHeadFetchUtils.a(null, 1, paramStComment.postUser.id.get(), 0)).a, 50, 50));
        }
        UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, "", UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 18.0F), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
      }
      else
      {
        UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, paramStComment.postUser.icon.get(), UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 18.0F), ImageUtil.e(), null);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStComment.postUser.nick.get());
      if (paramStComment.postUser.id.get().equals(paramString))
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
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText(paramStComment.content.get());
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$MoreCommentHolder.jdField_a_of_type_AndroidWidgetTextView.setText(DateUtils.a(paramStComment.createTime.get() * 1000L));
    a(paramStComment, false);
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.vecReply.size() == 0) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setVisibility(8);
    } else if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.vecReply.size() > 0)
    {
      if (paramInt == 0)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, paramInt, paramString);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setVisibility(8);
        a(paramStComment, true);
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, paramInt, paramString);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setVisibility(0);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setVisibility(8);
    }
    this.jdField_a_of_type_Boolean = false;
    paramStComment = this.jdField_a_of_type_AndroidViewView;
    if (CommentUIConfig.a()) {
      paramInt = i;
    } else {
      paramInt = 8;
    }
    paramStComment.setVisibility(paramInt);
  }
  
  public void setDisplayNum(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setDisplayNum(paramInt);
  }
  
  public void setOnCommentElementClickListener(OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener = paramOnCommentElementClickListener;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setOnCommentElementClickListener(paramOnCommentElementClickListener);
    paramOnCommentElementClickListener = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$MoreCommentHolder;
    if ((paramOnCommentElementClickListener != null) && (paramOnCommentElementClickListener.jdField_b_of_type_AndroidWidgetLinearLayout != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$MoreCommentHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new CommentView.1(this));
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setPosition(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentView
 * JD-Core Version:    0.7.0.1
 */