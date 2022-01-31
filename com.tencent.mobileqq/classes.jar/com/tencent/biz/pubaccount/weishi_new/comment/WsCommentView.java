package com.tencent.biz.pubaccount.weishi_new.comment;

import NS_KING_SOCIALIZE_META.stMetaComment;
import NS_KING_SOCIALIZE_META.stMetaPerson;
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
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import teb;
import tec;
import tlo;
import xod;
import ycr;
import yda;
import ydc;
import yde;

public class WsCommentView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private int jdField_a_of_type_Int;
  private stMetaComment jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public WsReplyContainer a;
  FeedRichTextView jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  public tec a;
  private yde jdField_a_of_type_Yde;
  private boolean jdField_a_of_type_Boolean;
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
    View localView = LayoutInflater.from(getContext()).inflate(2131559851, this, true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131364539));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)localView.findViewById(2131362973));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.a(18.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372196));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)localView.findViewById(2131372189));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer = ((WsReplyContainer)localView.findViewById(2131375606));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131369415);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369412));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369416));
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131365353);
    this.jdField_a_of_type_Tec = new tec();
    this.jdField_a_of_type_Tec.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131376610));
    this.jdField_a_of_type_Tec.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364546));
    this.jdField_a_of_type_Tec.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370731));
    this.jdField_a_of_type_Tec.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131363631));
    this.jdField_a_of_type_Tec.c = ((TextView)localView.findViewById(2131363685));
    this.jdField_a_of_type_Tec.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365359));
  }
  
  private void a(stMetaComment paramstMetaComment, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Tec != null) && (this.jdField_a_of_type_Tec.jdField_b_of_type_AndroidWidgetLinearLayout != null))
    {
      if ((!paramBoolean) || (paramstMetaComment == null) || (paramstMetaComment.replyList.size() <= 0)) {
        break label127;
      }
      String str = ycr.a(paramstMetaComment.createtime * 1000L);
      this.jdField_a_of_type_Tec.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_Tec.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_Tec.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      if (paramstMetaComment.replyList.size() > 0) {
        this.jdField_a_of_type_Tec.jdField_b_of_type_AndroidWidgetTextView.setText(paramstMetaComment.replyNum + alpo.a(2131702589));
      }
    }
    return;
    label127:
    this.jdField_a_of_type_Tec.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_Tec.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnLongClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850138);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165307));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850139);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165649));
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    switch (paramView.getId())
    {
    default: 
    case 2131362973: 
    case 2131372196: 
    case 2131364539: 
    case 2131372189: 
      do
      {
        do
        {
          do
          {
            return;
          } while ((this.jdField_a_of_type_Yde == null) || (this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment == null));
          this.jdField_a_of_type_Yde.a(paramView, 1, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.poster);
          return;
        } while ((this.jdField_a_of_type_Yde == null) || (this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment == null));
        this.jdField_a_of_type_Yde.a(paramView, 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.poster);
        return;
      } while (this.jdField_a_of_type_Yde == null);
      this.jdField_a_of_type_Yde.a(paramView, 4, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment);
      return;
    }
    if (this.jdField_a_of_type_Yde != null)
    {
      this.jdField_a_of_type_Boolean = true;
      stMetaComment localstMetaComment;
      if (this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.isDing == 1)
      {
        tlo.c("comment", "点赞前 isDing：" + bool + ",mComment.isDing:" + this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.isDing);
        a(bool);
        if (bool) {
          break label358;
        }
        tlo.c("comment", "执行点赞 ...............");
        localstMetaComment = this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment;
        localstMetaComment.dingNum += 1L;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(yda.a(this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.dingNum));
      }
      for (;;)
      {
        this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.isDing = ((this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.isDing + 1) % 2);
        tlo.c("comment", "点赞后 mComment.isDing：" + this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.isDing + ",clickPosition:" + this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Yde.a(paramView, 6, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment);
        return;
        bool = false;
        break;
        label358:
        if (this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.dingNum > 1L)
        {
          tlo.c("comment", "执行点赞-1 ...............");
          localstMetaComment = this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment;
          localstMetaComment.dingNum -= 1L;
          this.jdField_b_of_type_AndroidWidgetTextView.setText(yda.a(this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.dingNum));
        }
        else
        {
          localstMetaComment = this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment;
          localstMetaComment.dingNum -= 1L;
          tlo.c("comment", "执行取消点赞 ...............");
          this.jdField_b_of_type_AndroidWidgetTextView.setText("");
        }
      }
    }
    tlo.c("comment", "mOnCommentElementClickListener is null ...............");
  }
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_Yde != null) {
      this.jdField_a_of_type_Yde.b(paramView, 5, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment);
    }
    return true;
  }
  
  public void setData(stMetaComment paramstMetaComment, int paramInt, String paramString)
  {
    this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment = paramstMetaComment;
    if (paramstMetaComment == null) {
      return;
    }
    label235:
    boolean bool;
    if (paramstMetaComment.poster != null)
    {
      if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramstMetaComment.poster.id)) && (bdje.a(paramstMetaComment.poster.avatar)))
      {
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(bdda.c(ydc.a(ydc.a(null, 1, paramstMetaComment.poster.id, 0)).a, 50, 50));
        }
        xod.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, "", xod.a(getContext(), 35.0F), xod.a(getContext(), 35.0F), xod.a(getContext(), 18.0F), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramstMetaComment.poster.nick);
        if (!paramstMetaComment.poster.id.equals(paramString)) {
          break label402;
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
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramstMetaComment.wording);
      this.jdField_a_of_type_Tec.jdField_a_of_type_AndroidWidgetTextView.setText(ycr.a(paramstMetaComment.createtime * 1000L));
      a(paramstMetaComment, false);
      if (this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.replyList.size() != 0) {
        break label416;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setVisibility(8);
      label296:
      if (this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.isDing != 0) {
        break label500;
      }
      bool = true;
      label309:
      a(bool);
      if (paramstMetaComment.dingNum <= 0L) {
        break label506;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(yda.a(paramstMetaComment.dingNum));
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
      xod.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, paramstMetaComment.poster.avatar, xod.a(getContext(), 35.0F), xod.a(getContext(), 35.0F), xod.a(getContext(), 18.0F), bdda.b(), null);
      break;
      label402:
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label235;
      label416:
      if (this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.replyList.size() > 0)
      {
        if (paramInt == 0)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.a(this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment, paramInt, paramString);
          this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setVisibility(8);
          a(paramstMetaComment, true);
          break label296;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.a(this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment, paramInt, paramString);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setVisibility(0);
        break label296;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setVisibility(8);
      break label296;
      label500:
      bool = false;
      break label309;
      label506:
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    }
  }
  
  public void setDisplayNum(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setDisplayNum(paramInt);
  }
  
  public void setOnCommentElementClickListener(yde paramyde)
  {
    this.jdField_a_of_type_Yde = paramyde;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setOnCommentElementClickListener(paramyde);
    if ((this.jdField_a_of_type_Tec != null) && (this.jdField_a_of_type_Tec.jdField_b_of_type_AndroidWidgetLinearLayout != null)) {
      this.jdField_a_of_type_Tec.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new teb(this));
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setPosition(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentView
 * JD-Core Version:    0.7.0.1
 */