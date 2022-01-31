package com.tencent.biz.pubaccount.weishi_new.comment;

import NS_KING_SOCIALIZE_META.stMetaComment;
import NS_KING_SOCIALIZE_META.stMetaPerson;
import alud;
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
import bdam;
import bdhj;
import bdnn;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import teb;
import tec;
import tlo;
import xsm;
import yha;
import yhj;
import yhl;
import yhn;

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
  private yhn jdField_a_of_type_Yhn;
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
    View localView = LayoutInflater.from(getContext()).inflate(2131559850, this, true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131364541));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)localView.findViewById(2131362973));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.a(18.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372216));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)localView.findViewById(2131372209));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer = ((WsReplyContainer)localView.findViewById(2131375657));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131369433);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369430));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369434));
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131365355);
    this.jdField_a_of_type_Tec = new tec();
    this.jdField_a_of_type_Tec.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131376664));
    this.jdField_a_of_type_Tec.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364548));
    this.jdField_a_of_type_Tec.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370750));
    this.jdField_a_of_type_Tec.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131363633));
    this.jdField_a_of_type_Tec.c = ((TextView)localView.findViewById(2131363687));
    this.jdField_a_of_type_Tec.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365361));
  }
  
  private void a(stMetaComment paramstMetaComment, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Tec != null) && (this.jdField_a_of_type_Tec.jdField_b_of_type_AndroidWidgetLinearLayout != null))
    {
      if ((!paramBoolean) || (paramstMetaComment == null) || (paramstMetaComment.replyList.size() <= 0)) {
        break label127;
      }
      String str = yha.a(paramstMetaComment.createtime * 1000L);
      this.jdField_a_of_type_Tec.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_Tec.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_Tec.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      if (paramstMetaComment.replyList.size() > 0) {
        this.jdField_a_of_type_Tec.jdField_b_of_type_AndroidWidgetTextView.setText(paramstMetaComment.replyNum + alud.a(2131702601));
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850211);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165307));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850212);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165649));
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    switch (paramView.getId())
    {
    default: 
    case 2131362973: 
    case 2131372216: 
    case 2131364541: 
    case 2131372209: 
      do
      {
        do
        {
          do
          {
            return;
          } while ((this.jdField_a_of_type_Yhn == null) || (this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment == null));
          this.jdField_a_of_type_Yhn.a(paramView, 1, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.poster);
          return;
        } while ((this.jdField_a_of_type_Yhn == null) || (this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment == null));
        this.jdField_a_of_type_Yhn.a(paramView, 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.poster);
        return;
      } while (this.jdField_a_of_type_Yhn == null);
      this.jdField_a_of_type_Yhn.a(paramView, 4, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment);
      return;
    }
    if (this.jdField_a_of_type_Yhn != null)
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(yhj.a(this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.dingNum));
      }
      for (;;)
      {
        this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.isDing = ((this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.isDing + 1) % 2);
        tlo.c("comment", "点赞后 mComment.isDing：" + this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.isDing + ",clickPosition:" + this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Yhn.a(paramView, 6, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment);
        return;
        bool = false;
        break;
        label358:
        if (this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.dingNum > 1L)
        {
          tlo.c("comment", "执行点赞-1 ...............");
          localstMetaComment = this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment;
          localstMetaComment.dingNum -= 1L;
          this.jdField_b_of_type_AndroidWidgetTextView.setText(yhj.a(this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.dingNum));
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
    if (this.jdField_a_of_type_Yhn != null) {
      this.jdField_a_of_type_Yhn.b(paramView, 5, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment);
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
      if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramstMetaComment.poster.id)) && (bdnn.a(paramstMetaComment.poster.avatar)))
      {
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(bdhj.c(yhl.a(yhl.a(null, 1, paramstMetaComment.poster.id, 0)).a, 50, 50));
        }
        xsm.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, "", xsm.a(getContext(), 35.0F), xsm.a(getContext(), 35.0F), xsm.a(getContext(), 18.0F), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramstMetaComment.poster.nick);
        if (!paramstMetaComment.poster.id.equals(paramString)) {
          break label402;
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130850237);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.a(21.0F), ImmersiveUtils.a(12.0F));
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ImmersiveUtils.a(2.0F));
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramstMetaComment.wording);
      this.jdField_a_of_type_Tec.jdField_a_of_type_AndroidWidgetTextView.setText(yha.a(paramstMetaComment.createtime * 1000L));
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(yhj.a(paramstMetaComment.dingNum));
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
      xsm.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, paramstMetaComment.poster.avatar, xsm.a(getContext(), 35.0F), xsm.a(getContext(), 35.0F), xsm.a(getContext(), 18.0F), bdhj.b(), null);
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
  
  public void setOnCommentElementClickListener(yhn paramyhn)
  {
    this.jdField_a_of_type_Yhn = paramyhn;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setOnCommentElementClickListener(paramyhn);
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