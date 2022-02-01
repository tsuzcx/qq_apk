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
import anvx;
import bgyp;
import bheg;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import var;
import vas;
import vmp;
import zvr;
import zwa;
import zwc;
import zwe;

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
  public WsReplyContainer a;
  FeedRichTextView jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  public vas a;
  private zwe jdField_a_of_type_Zwe;
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
    View localView = LayoutInflater.from(getContext()).inflate(2131560040, this, true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131364921));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)localView.findViewById(2131363145));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.a(18.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373083));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)localView.findViewById(2131373063));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer = ((WsReplyContainer)localView.findViewById(2131376535));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131370089);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370086));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370090));
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131365759);
    this.jdField_a_of_type_Vas = new vas();
    this.jdField_a_of_type_Vas.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131377662));
    this.jdField_a_of_type_Vas.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364928));
    this.jdField_a_of_type_Vas.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371569));
    this.jdField_a_of_type_Vas.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131363955));
    this.jdField_a_of_type_Vas.c = ((TextView)localView.findViewById(2131364014));
    this.jdField_a_of_type_Vas.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365767));
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Vas != null) && (this.jdField_a_of_type_Vas.jdField_b_of_type_AndroidWidgetLinearLayout != null))
    {
      if ((!paramBoolean) || (paramstSimpleMetaComment == null) || (paramstSimpleMetaComment.replyList.size() <= 0)) {
        break label127;
      }
      String str = zvr.a(paramstSimpleMetaComment.createtime * 1000L);
      this.jdField_a_of_type_Vas.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_Vas.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_Vas.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      if (paramstSimpleMetaComment.replyList.size() > 0) {
        this.jdField_a_of_type_Vas.jdField_b_of_type_AndroidWidgetTextView.setText(paramstSimpleMetaComment.replyNum + anvx.a(2131701714));
      }
    }
    return;
    label127:
    this.jdField_a_of_type_Vas.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_Vas.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850940);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166209));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850906);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165357));
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
      if ((this.jdField_a_of_type_Zwe != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaComment != null))
      {
        this.jdField_a_of_type_Zwe.a(paramView, 1, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaComment.poster);
        continue;
        if ((this.jdField_a_of_type_Zwe != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaComment != null))
        {
          this.jdField_a_of_type_Zwe.a(paramView, 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaComment.poster);
          continue;
          if (this.jdField_a_of_type_Zwe != null)
          {
            this.jdField_a_of_type_Zwe.a(paramView, 4, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaComment);
            continue;
            if (this.jdField_a_of_type_Zwe != null)
            {
              this.jdField_a_of_type_Boolean = true;
              label194:
              stSimpleMetaComment localstSimpleMetaComment;
              if (this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing == 1)
              {
                vmp.c("comment", "点赞前 isDing：" + bool + ",mComment.isDing:" + this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing);
                a(bool);
                if (bool) {
                  break label373;
                }
                vmp.c("comment", "执行点赞 ...............");
                localstSimpleMetaComment = this.jdField_a_of_type_UserGrowthStSimpleMetaComment;
                localstSimpleMetaComment.dingNum += 1L;
                this.jdField_b_of_type_AndroidWidgetTextView.setText(zwa.a(this.jdField_a_of_type_UserGrowthStSimpleMetaComment.dingNum));
              }
              for (;;)
              {
                this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing = ((this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing + 1) % 2);
                vmp.c("comment", "点赞后 mComment.isDing：" + this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing + ",clickPosition:" + this.jdField_a_of_type_Int);
                this.jdField_a_of_type_Zwe.a(paramView, 6, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaComment);
                break;
                bool = false;
                break label194;
                label373:
                if (this.jdField_a_of_type_UserGrowthStSimpleMetaComment.dingNum > 1L)
                {
                  vmp.c("comment", "执行点赞-1 ...............");
                  localstSimpleMetaComment = this.jdField_a_of_type_UserGrowthStSimpleMetaComment;
                  localstSimpleMetaComment.dingNum -= 1L;
                  this.jdField_b_of_type_AndroidWidgetTextView.setText(zwa.a(this.jdField_a_of_type_UserGrowthStSimpleMetaComment.dingNum));
                }
                else
                {
                  localstSimpleMetaComment = this.jdField_a_of_type_UserGrowthStSimpleMetaComment;
                  localstSimpleMetaComment.dingNum -= 1L;
                  vmp.c("comment", "执行取消点赞 ...............");
                  this.jdField_b_of_type_AndroidWidgetTextView.setText("");
                }
              }
            }
            vmp.c("comment", "mOnCommentElementClickListener is null ...............");
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
      if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramstSimpleMetaComment.poster.id)) && (StringUtil.isEmpty(paramstSimpleMetaComment.poster.avatar)))
      {
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(bheg.c(zwc.a(zwc.a(null, 1, paramstSimpleMetaComment.poster.id, 0)).a, 50, 50));
        }
        UIUtils.setRoundCornerViewByURL(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, "", UIUtils.dip2px(getContext(), 35.0F), UIUtils.dip2px(getContext(), 35.0F), UIUtils.dip2px(getContext(), 18.0F), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramstSimpleMetaComment.poster.nick);
        if (!paramstSimpleMetaComment.poster.id.equals(paramString)) {
          break label402;
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130850950);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.a(21.0F), ImmersiveUtils.a(12.0F));
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ImmersiveUtils.a(2.0F));
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramstSimpleMetaComment.wording);
      this.jdField_a_of_type_Vas.jdField_a_of_type_AndroidWidgetTextView.setText(zvr.a(paramstSimpleMetaComment.createtime * 1000L));
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(zwa.a(paramstSimpleMetaComment.dingNum));
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
      UIUtils.setRoundCornerViewByURL(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, paramstSimpleMetaComment.poster.avatar, UIUtils.dip2px(getContext(), 35.0F), UIUtils.dip2px(getContext(), 35.0F), UIUtils.dip2px(getContext(), 18.0F), bheg.b(), null);
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
  
  public void setOnCommentElementClickListener(zwe paramzwe)
  {
    this.jdField_a_of_type_Zwe = paramzwe;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setOnCommentElementClickListener(paramzwe);
    if ((this.jdField_a_of_type_Vas != null) && (this.jdField_a_of_type_Vas.jdField_b_of_type_AndroidWidgetLinearLayout != null)) {
      this.jdField_a_of_type_Vas.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new var(this));
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