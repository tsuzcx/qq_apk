package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import ajya;
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
import baxj;
import bbef;
import bbkk;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;
import vzl;
import wnz;
import woa;
import wob;
import woc;
import won;
import wop;

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
  public ReplyContainer a;
  AsyncRichTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
  public wob a;
  private wop jdField_a_of_type_Wop;
  private boolean jdField_a_of_type_Boolean;
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
    View localView = LayoutInflater.from(getContext()).inflate(2131558715, this, true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131364467));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)localView.findViewById(2131362938));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.a(18.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371878));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)localView.findViewById(2131371871));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer = ((ReplyContainer)localView.findViewById(2131375126));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131369183);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369180));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369184));
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131365268);
    this.jdField_a_of_type_Wob = new wob();
    this.jdField_a_of_type_Wob.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131376111));
    this.jdField_a_of_type_Wob.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364474));
    this.jdField_a_of_type_Wob.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370425));
    this.jdField_a_of_type_Wob.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131363586));
    this.jdField_a_of_type_Wob.c = ((TextView)localView.findViewById(2131363632));
    this.jdField_a_of_type_Wob.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365274));
  }
  
  private void a(CertifiedAccountMeta.StComment paramStComment, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Wob != null) && (this.jdField_a_of_type_Wob.jdField_b_of_type_AndroidWidgetLinearLayout != null))
    {
      if ((!paramBoolean) || (paramStComment == null) || (paramStComment.vecReply.size() <= 0)) {
        break label129;
      }
      String str = woc.a(paramStComment.createTime.get() * 1000L);
      this.jdField_a_of_type_Wob.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_Wob.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_Wob.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      if (paramStComment.vecReply.size() > 0) {
        this.jdField_a_of_type_Wob.jdField_b_of_type_AndroidWidgetTextView.setText(paramStComment.replyCount + ajya.a(2131702217));
      }
    }
    return;
    label129:
    this.jdField_a_of_type_Wob.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_Wob.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
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
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_Wop == null) || (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment == null));
        this.jdField_a_of_type_Wop.a(paramView, 1, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.postUser);
        return;
      } while ((this.jdField_a_of_type_Wop == null) || (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment == null));
      this.jdField_a_of_type_Wop.a(paramView, 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.postUser);
      return;
    } while (this.jdField_a_of_type_Wop == null);
    this.jdField_a_of_type_Wop.a(paramView, 4, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment);
  }
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_Wop != null) {
      this.jdField_a_of_type_Wop.b(paramView, 5, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment);
    }
    return true;
  }
  
  public void setData(CertifiedAccountMeta.StComment paramStComment, int paramInt, String paramString)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment = paramStComment;
    if (paramStComment == null) {
      return;
    }
    if (paramStComment.postUser != null)
    {
      if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramStComment.postUser.id.get())) && (bbkk.a(paramStComment.postUser.icon.get())))
      {
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(bbef.c(won.a(won.a(null, 1, paramStComment.postUser.id.get(), 0)).a, 50, 50));
        }
        vzl.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, "", vzl.a(getContext(), 35.0F), vzl.a(getContext(), 35.0F), vzl.a(getContext(), 18.0F), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStComment.postUser.nick.get());
        if (!paramStComment.postUser.id.get().equals(paramString)) {
          break label393;
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130849694);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.a(21.0F), ImmersiveUtils.a(12.0F));
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ImmersiveUtils.a(2.0F));
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      }
    }
    else
    {
      label250:
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText(paramStComment.content.get());
      this.jdField_a_of_type_Wob.jdField_a_of_type_AndroidWidgetTextView.setText(woc.a(paramStComment.createTime.get() * 1000L));
      a(paramStComment, false);
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.vecReply.size() != 0) {
        break label407;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setVisibility(8);
      label316:
      this.jdField_a_of_type_Boolean = false;
      paramStComment = this.jdField_a_of_type_AndroidViewView;
      if (!wnz.a()) {
        break label491;
      }
    }
    label393:
    label407:
    label491:
    for (paramInt = 0;; paramInt = 8)
    {
      paramStComment.setVisibility(paramInt);
      return;
      vzl.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, paramStComment.postUser.icon.get(), vzl.a(getContext(), 35.0F), vzl.a(getContext(), 35.0F), vzl.a(getContext(), 18.0F), bbef.b(), null);
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label250;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.vecReply.size() > 0)
      {
        if (paramInt == 0)
        {
          this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, paramInt, paramString);
          this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setVisibility(8);
          a(paramStComment, true);
          break label316;
        }
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, paramInt, paramString);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setVisibility(0);
        break label316;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setVisibility(8);
      break label316;
    }
  }
  
  public void setDisplayNum(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setDisplayNum(paramInt);
  }
  
  public void setOnCommentElementClickListener(wop paramwop)
  {
    this.jdField_a_of_type_Wop = paramwop;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setOnCommentElementClickListener(paramwop);
    if ((this.jdField_a_of_type_Wob != null) && (this.jdField_a_of_type_Wob.jdField_b_of_type_AndroidWidgetLinearLayout != null)) {
      this.jdField_a_of_type_Wob.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new woa(this));
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setPosition(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentView
 * JD-Core Version:    0.7.0.1
 */