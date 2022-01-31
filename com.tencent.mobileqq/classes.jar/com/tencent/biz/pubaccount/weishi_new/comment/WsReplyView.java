package com.tencent.biz.pubaccount.weishi_new.comment;

import NS_KING_SOCIALIZE_META.stMetaComment;
import NS_KING_SOCIALIZE_META.stMetaPerson;
import NS_KING_SOCIALIZE_META.stMetaReply;
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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;
import xod;
import yco;
import ycr;
import ydc;
import yde;

public class WsReplyView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final String jdField_a_of_type_JavaLangString = WsReplyView.class.getName();
  private int jdField_a_of_type_Int;
  private stMetaComment jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment;
  private stMetaReply jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaReply;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FeedRichTextView jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  private yde jdField_a_of_type_Yde;
  private boolean jdField_a_of_type_Boolean;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private final String jdField_b_of_type_JavaLangString = alpo.a(2131713792);
  TextView c;
  TextView d;
  
  public WsReplyView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WsReplyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WsReplyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    b();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131559855, this, true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)localView.findViewById(2131368694));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.a(18.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131375622));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)localView.findViewById(2131375620));
    this.c = ((TextView)localView.findViewById(2131375621));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363684));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131375615));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131375614));
    this.d = ((TextView)localView.findViewById(2131375616));
    setPadding(0, 0, 0, Utils.dp2px(5.0D));
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnLongClickListener(this);
    setOnLongClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if ((((paramView instanceof WsReplyView)) || (paramView.getId() == 2131363684)) && (this.jdField_a_of_type_Yde != null))
      {
        localstMetaComment = this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment;
        localstMetaReply = this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaReply;
        this.jdField_a_of_type_Yde.a(paramView, 7, this.jdField_a_of_type_Int, new Object[] { localstMetaComment, localstMetaReply });
      }
      break;
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Yde == null) || (this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaReply == null));
      this.jdField_a_of_type_Yde.a(paramView, 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaReply.poster);
      return;
    } while (this.jdField_a_of_type_Yde == null);
    stMetaComment localstMetaComment = this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment;
    stMetaReply localstMetaReply = this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaReply;
    this.jdField_a_of_type_Yde.a(paramView, 7, this.jdField_a_of_type_Int, new Object[] { localstMetaComment, localstMetaReply });
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
    stMetaComment localstMetaComment = this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment;
    stMetaReply localstMetaReply = this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaReply;
    this.jdField_a_of_type_Yde.b(paramView, 8, this.jdField_a_of_type_Int, new Object[] { localstMetaComment, localstMetaReply });
    return true;
  }
  
  public void setData(stMetaComment paramstMetaComment, stMetaReply paramstMetaReply, String paramString)
  {
    this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment = paramstMetaComment;
    this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaReply = paramstMetaReply;
    if ((paramstMetaComment == null) || (paramstMetaReply == null)) {
      return;
    }
    if (paramstMetaReply.poster != null)
    {
      if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramstMetaReply.poster.id)) && (bdje.a(paramstMetaReply.poster.avatar)))
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(bdda.c(ydc.a(ydc.a(null, 1, paramstMetaReply.poster.id, 0)).a, 50, 50));
        }
        xod.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, "", xod.a(getContext(), 35.0F), xod.a(getContext(), 35.0F), xod.a(getContext(), 18.0F), this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramstMetaReply.poster.nick);
        if (!paramstMetaReply.poster.id.equals(paramString)) {
          break label348;
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
      label241:
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramstMetaReply.wording);
      this.c.setText(ycr.a(paramstMetaReply.createtime * 1000L));
      this.jdField_a_of_type_Boolean = false;
      paramstMetaComment = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (yco.a()) {
        break label362;
      }
    }
    label348:
    label362:
    for (int i = 0;; i = 8)
    {
      paramstMetaComment.setVisibility(i);
      return;
      xod.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, paramstMetaReply.poster.avatar, xod.a(getContext(), 22.0F), xod.a(getContext(), 22.0F), xod.a(getContext(), 11.0F), bdda.b(), null);
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label241;
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
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsReplyView
 * JD-Core Version:    0.7.0.1
 */