package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaPerson;
import aajo;
import aajx;
import aajz;
import aakb;
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
import anzj;
import bhgn;
import bhmq;
import bhsr;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import uga;
import ugb;
import uqf;
import zps;

public class WsCommentView
  extends RelativeLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private stSimpleMetaComment jdField_a_of_type_UserGrowthStSimpleMetaComment;
  private aakb jdField_a_of_type_Aakb;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public WsReplyContainer a;
  FeedRichTextView jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  public ugb a;
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
    View localView = LayoutInflater.from(getContext()).inflate(2131559992, this, true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131364804));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)localView.findViewById(2131363109));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.a(18.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372916));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)localView.findViewById(2131372901));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer = ((WsReplyContainer)localView.findViewById(2131376512));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131369925);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369922));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369926));
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131365632);
    this.jdField_a_of_type_Ugb = new ugb();
    this.jdField_a_of_type_Ugb.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131377621));
    this.jdField_a_of_type_Ugb.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364811));
    this.jdField_a_of_type_Ugb.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371416));
    this.jdField_a_of_type_Ugb.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131363857));
    this.jdField_a_of_type_Ugb.c = ((TextView)localView.findViewById(2131363914));
    this.jdField_a_of_type_Ugb.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365640));
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ugb != null) && (this.jdField_a_of_type_Ugb.jdField_b_of_type_AndroidWidgetLinearLayout != null))
    {
      if ((!paramBoolean) || (paramstSimpleMetaComment == null) || (paramstSimpleMetaComment.replyList.size() <= 0)) {
        break label127;
      }
      String str = aajo.a(paramstSimpleMetaComment.createtime * 1000L);
      this.jdField_a_of_type_Ugb.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_Ugb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_Ugb.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      if (paramstSimpleMetaComment.replyList.size() > 0) {
        this.jdField_a_of_type_Ugb.jdField_b_of_type_AndroidWidgetTextView.setText(paramstSimpleMetaComment.replyNum + anzj.a(2131701128));
      }
    }
    return;
    label127:
    this.jdField_a_of_type_Ugb.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_Ugb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850863);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166181));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850830);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165343));
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Aakb != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaComment != null))
      {
        this.jdField_a_of_type_Aakb.a(paramView, 1, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaComment.poster);
        continue;
        if ((this.jdField_a_of_type_Aakb != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaComment != null))
        {
          this.jdField_a_of_type_Aakb.a(paramView, 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaComment.poster);
          continue;
          if (this.jdField_a_of_type_Aakb != null)
          {
            this.jdField_a_of_type_Aakb.a(paramView, 4, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaComment);
            continue;
            if (this.jdField_a_of_type_Aakb != null)
            {
              this.jdField_a_of_type_Boolean = true;
              label194:
              stSimpleMetaComment localstSimpleMetaComment;
              if (this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing == 1)
              {
                uqf.c("comment", "点赞前 isDing：" + bool + ",mComment.isDing:" + this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing);
                a(bool);
                if (bool) {
                  break label373;
                }
                uqf.c("comment", "执行点赞 ...............");
                localstSimpleMetaComment = this.jdField_a_of_type_UserGrowthStSimpleMetaComment;
                localstSimpleMetaComment.dingNum += 1L;
                this.jdField_b_of_type_AndroidWidgetTextView.setText(aajx.a(this.jdField_a_of_type_UserGrowthStSimpleMetaComment.dingNum));
              }
              for (;;)
              {
                this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing = ((this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing + 1) % 2);
                uqf.c("comment", "点赞后 mComment.isDing：" + this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing + ",clickPosition:" + this.jdField_a_of_type_Int);
                this.jdField_a_of_type_Aakb.a(paramView, 6, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaComment);
                break;
                bool = false;
                break label194;
                label373:
                if (this.jdField_a_of_type_UserGrowthStSimpleMetaComment.dingNum > 1L)
                {
                  uqf.c("comment", "执行点赞-1 ...............");
                  localstSimpleMetaComment = this.jdField_a_of_type_UserGrowthStSimpleMetaComment;
                  localstSimpleMetaComment.dingNum -= 1L;
                  this.jdField_b_of_type_AndroidWidgetTextView.setText(aajx.a(this.jdField_a_of_type_UserGrowthStSimpleMetaComment.dingNum));
                }
                else
                {
                  localstSimpleMetaComment = this.jdField_a_of_type_UserGrowthStSimpleMetaComment;
                  localstSimpleMetaComment.dingNum -= 1L;
                  uqf.c("comment", "执行取消点赞 ...............");
                  this.jdField_b_of_type_AndroidWidgetTextView.setText("");
                }
              }
            }
            uqf.c("comment", "mOnCommentElementClickListener is null ...............");
          }
        }
      }
    }
  }
  
  public void setData(stSimpleMetaComment paramstSimpleMetaComment, int paramInt, String paramString)
  {
    this.jdField_a_of_type_UserGrowthStSimpleMetaComment = paramstSimpleMetaComment;
    if (paramstSimpleMetaComment == null) {
      return;
    }
    label235:
    boolean bool;
    if (paramstSimpleMetaComment.poster != null)
    {
      if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramstSimpleMetaComment.poster.id)) && (bhsr.a(paramstSimpleMetaComment.poster.avatar)))
      {
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(bhmq.c(aajz.a(aajz.a(null, 1, paramstSimpleMetaComment.poster.id, 0)).a, 50, 50));
        }
        zps.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, "", zps.a(getContext(), 35.0F), zps.a(getContext(), 35.0F), zps.a(getContext(), 18.0F), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramstSimpleMetaComment.poster.nick);
        if (!paramstSimpleMetaComment.poster.id.equals(paramString)) {
          break label402;
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130850872);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.a(21.0F), ImmersiveUtils.a(12.0F));
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ImmersiveUtils.a(2.0F));
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramstSimpleMetaComment.wording);
      this.jdField_a_of_type_Ugb.jdField_a_of_type_AndroidWidgetTextView.setText(aajo.a(paramstSimpleMetaComment.createtime * 1000L));
      a(paramstSimpleMetaComment, false);
      if (this.jdField_a_of_type_UserGrowthStSimpleMetaComment.replyList.size() != 0) {
        break label416;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setVisibility(8);
      label296:
      if (this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing != 0) {
        break label500;
      }
      bool = true;
      label309:
      a(bool);
      if (paramstSimpleMetaComment.dingNum <= 0L) {
        break label506;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(aajx.a(paramstSimpleMetaComment.dingNum));
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
      zps.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, paramstSimpleMetaComment.poster.avatar, zps.a(getContext(), 35.0F), zps.a(getContext(), 35.0F), zps.a(getContext(), 18.0F), bhmq.b(), null);
      break;
      label402:
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label235;
      label416:
      if (this.jdField_a_of_type_UserGrowthStSimpleMetaComment.replyList.size() > 0)
      {
        if (paramInt == 0)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.a(this.jdField_a_of_type_UserGrowthStSimpleMetaComment, paramInt, paramString);
          this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setVisibility(8);
          a(paramstSimpleMetaComment, true);
          break label296;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.a(this.jdField_a_of_type_UserGrowthStSimpleMetaComment, paramInt, paramString);
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
  
  public void setOnCommentElementClickListener(aakb paramaakb)
  {
    this.jdField_a_of_type_Aakb = paramaakb;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setOnCommentElementClickListener(paramaakb);
    if ((this.jdField_a_of_type_Ugb != null) && (this.jdField_a_of_type_Ugb.jdField_b_of_type_AndroidWidgetLinearLayout != null)) {
      this.jdField_a_of_type_Ugb.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new uga(this));
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setPosition(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentView
 * JD-Core Version:    0.7.0.1
 */