package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import alpo;
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
import bcwd;
import bdda;
import bdje;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;
import xod;
import yco;
import ycp;
import ycq;
import ycr;
import ydc;
import yde;

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
  public ycq a;
  private yde jdField_a_of_type_Yde;
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
    View localView = LayoutInflater.from(getContext()).inflate(2131558751, this, true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131364539));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)localView.findViewById(2131362973));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.a(18.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372196));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)localView.findViewById(2131372189));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer = ((ReplyContainer)localView.findViewById(2131375606));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131369415);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369412));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369416));
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131365353);
    this.jdField_a_of_type_Ycq = new ycq();
    this.jdField_a_of_type_Ycq.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131376610));
    this.jdField_a_of_type_Ycq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364546));
    this.jdField_a_of_type_Ycq.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370731));
    this.jdField_a_of_type_Ycq.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131363631));
    this.jdField_a_of_type_Ycq.c = ((TextView)localView.findViewById(2131363685));
    this.jdField_a_of_type_Ycq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365359));
  }
  
  private void a(CertifiedAccountMeta.StComment paramStComment, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ycq != null) && (this.jdField_a_of_type_Ycq.jdField_b_of_type_AndroidWidgetLinearLayout != null))
    {
      if ((!paramBoolean) || (paramStComment == null) || (paramStComment.vecReply.size() <= 0)) {
        break label129;
      }
      String str = ycr.a(paramStComment.createTime.get() * 1000L);
      this.jdField_a_of_type_Ycq.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_Ycq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_Ycq.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      if (paramStComment.vecReply.size() > 0) {
        this.jdField_a_of_type_Ycq.jdField_b_of_type_AndroidWidgetTextView.setText(paramStComment.replyCount + alpo.a(2131702589));
      }
    }
    return;
    label129:
    this.jdField_a_of_type_Ycq.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_Ycq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
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
        } while ((this.jdField_a_of_type_Yde == null) || (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment == null));
        this.jdField_a_of_type_Yde.a(paramView, 1, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.postUser);
        return;
      } while ((this.jdField_a_of_type_Yde == null) || (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment == null));
      this.jdField_a_of_type_Yde.a(paramView, 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.postUser);
      return;
    } while (this.jdField_a_of_type_Yde == null);
    this.jdField_a_of_type_Yde.a(paramView, 4, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment);
  }
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_Yde != null) {
      this.jdField_a_of_type_Yde.b(paramView, 5, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment);
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
      if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramStComment.postUser.id.get())) && (bdje.a(paramStComment.postUser.icon.get())))
      {
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(bdda.c(ydc.a(ydc.a(null, 1, paramStComment.postUser.id.get(), 0)).a, 50, 50));
        }
        xod.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, "", xod.a(getContext(), 35.0F), xod.a(getContext(), 35.0F), xod.a(getContext(), 18.0F), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStComment.postUser.nick.get());
        if (!paramStComment.postUser.id.get().equals(paramString)) {
          break label393;
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130850164);
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
      this.jdField_a_of_type_Ycq.jdField_a_of_type_AndroidWidgetTextView.setText(ycr.a(paramStComment.createTime.get() * 1000L));
      a(paramStComment, false);
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.vecReply.size() != 0) {
        break label407;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setVisibility(8);
      label316:
      this.jdField_a_of_type_Boolean = false;
      paramStComment = this.jdField_a_of_type_AndroidViewView;
      if (!yco.a()) {
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
      xod.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, paramStComment.postUser.icon.get(), xod.a(getContext(), 35.0F), xod.a(getContext(), 35.0F), xod.a(getContext(), 18.0F), bdda.b(), null);
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
  
  public void setOnCommentElementClickListener(yde paramyde)
  {
    this.jdField_a_of_type_Yde = paramyde;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setOnCommentElementClickListener(paramyde);
    if ((this.jdField_a_of_type_Ycq != null) && (this.jdField_a_of_type_Ycq.jdField_b_of_type_AndroidWidgetLinearLayout != null)) {
      this.jdField_a_of_type_Ycq.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new ycp(this));
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setPosition(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentView
 * JD-Core Version:    0.7.0.1
 */