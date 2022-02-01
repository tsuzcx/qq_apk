package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stSimpleMetaReply;
import aafk;
import aafn;
import aafy;
import aaga;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anni;
import bggm;
import bgmo;
import bgsp;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;
import zlx;

public class WsReplyView
  extends RelativeLayout
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = WsReplyView.class.getName();
  private static final String jdField_b_of_type_JavaLangString = anni.a(2131712183);
  private int jdField_a_of_type_Int;
  private stSimpleMetaComment jdField_a_of_type_UserGrowthStSimpleMetaComment;
  private stSimpleMetaReply jdField_a_of_type_UserGrowthStSimpleMetaReply;
  private aaga jdField_a_of_type_Aaga;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FeedRichTextView jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  private boolean jdField_a_of_type_Boolean;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TextView c;
  private TextView d;
  private TextView e;
  
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
    View localView = LayoutInflater.from(getContext()).inflate(2131559990, this, true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)localView.findViewById(2131369037));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.a(10.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376397));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)localView.findViewById(2131376395));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376396));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131376389));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131376388));
    this.c = ((TextView)localView.findViewById(2131376390));
    this.d = ((TextView)localView.findViewById(2131376399));
    this.e = ((TextView)localView.findViewById(2131376398));
    setPadding(0, 0, 0, Utils.dp2px(5.0D));
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    stSimpleMetaComment localstSimpleMetaComment;
    stSimpleMetaReply localstSimpleMetaReply;
    switch (paramView.getId())
    {
    default: 
      if ((((paramView instanceof WsReplyView)) || (paramView.getId() == 2131363889)) && (this.jdField_a_of_type_Aaga != null))
      {
        localstSimpleMetaComment = this.jdField_a_of_type_UserGrowthStSimpleMetaComment;
        localstSimpleMetaReply = this.jdField_a_of_type_UserGrowthStSimpleMetaReply;
        this.jdField_a_of_type_Aaga.a(paramView, 7, this.jdField_a_of_type_Int, new Object[] { localstSimpleMetaComment, localstSimpleMetaReply });
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Aaga != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaReply != null))
      {
        this.jdField_a_of_type_Aaga.a(paramView, 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaReply.poster);
        continue;
        if (this.jdField_a_of_type_Aaga != null)
        {
          localstSimpleMetaComment = this.jdField_a_of_type_UserGrowthStSimpleMetaComment;
          localstSimpleMetaReply = this.jdField_a_of_type_UserGrowthStSimpleMetaReply;
          this.jdField_a_of_type_Aaga.a(paramView, 7, this.jdField_a_of_type_Int, new Object[] { localstSimpleMetaComment, localstSimpleMetaReply });
          continue;
          if (this.jdField_a_of_type_Aaga != null)
          {
            localstSimpleMetaComment = this.jdField_a_of_type_UserGrowthStSimpleMetaComment;
            localstSimpleMetaReply = this.jdField_a_of_type_UserGrowthStSimpleMetaReply;
            this.jdField_a_of_type_Aaga.a(paramView, 77, this.jdField_a_of_type_Int, new Object[] { localstSimpleMetaComment, localstSimpleMetaReply });
          }
        }
      }
    }
  }
  
  public void setData(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, String paramString)
  {
    this.jdField_a_of_type_UserGrowthStSimpleMetaComment = paramstSimpleMetaComment;
    this.jdField_a_of_type_UserGrowthStSimpleMetaReply = paramstSimpleMetaReply;
    if ((paramstSimpleMetaComment == null) || (paramstSimpleMetaReply == null)) {
      return;
    }
    if (paramstSimpleMetaReply.poster != null)
    {
      if ((!BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramstSimpleMetaReply.poster.id)) || (!bgsp.a(paramstSimpleMetaReply.poster.avatar))) {
        break label357;
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(bgmo.c(aafy.a(aafy.a(null, 1, paramstSimpleMetaReply.poster.id, 0)).a, 50, 50));
      }
      zlx.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, "", zlx.a(getContext(), 20.0F), zlx.a(getContext(), 20.0F), zlx.a(getContext(), 10.0F), this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramstSimpleMetaReply.poster.nick);
      if (!paramstSimpleMetaReply.poster.id.equals(paramString)) {
        break label405;
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130850845);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.a(21.0F), ImmersiveUtils.a(12.0F));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ImmersiveUtils.a(2.0F));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      label241:
      if (paramstSimpleMetaReply.receiver != null)
      {
        paramString = paramstSimpleMetaReply.receiver.nick;
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.equals(paramstSimpleMetaComment.poster.id, paramstSimpleMetaReply.receiver.id))) {
          break label419;
        }
        this.d.setVisibility(8);
        this.e.setVisibility(8);
      }
    }
    label301:
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramstSimpleMetaReply.wording);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(aafn.a(paramstSimpleMetaReply.createtime * 1000L));
    this.jdField_a_of_type_Boolean = false;
    paramstSimpleMetaComment = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (!aafk.a()) {}
    for (int i = 0;; i = 8)
    {
      paramstSimpleMetaComment.setVisibility(i);
      return;
      label357:
      zlx.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, paramstSimpleMetaReply.poster.avatar, zlx.a(getContext(), 20.0F), zlx.a(getContext(), 20.0F), zlx.a(getContext(), 10.0F), bgmo.b(), null);
      break;
      label405:
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label241;
      label419:
      this.e.setVisibility(0);
      this.e.setText(paramString);
      this.d.setVisibility(0);
      break label301;
    }
  }
  
  public void setOnCommentElementClickListener(aaga paramaaga)
  {
    this.jdField_a_of_type_Aaga = paramaaga;
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsReplyView
 * JD-Core Version:    0.7.0.1
 */