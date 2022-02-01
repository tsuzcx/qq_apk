package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaReply;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import com.tencent.biz.subscribe.comment.ReplyActionView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import zwe;

public class WsReplyContainer
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private int jdField_a_of_type_Int;
  private stSimpleMetaComment jdField_a_of_type_UserGrowthStSimpleMetaComment;
  private ReplyActionView jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView;
  private zwe jdField_a_of_type_Zwe;
  private int b;
  private int c;
  
  public WsReplyContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WsReplyContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WsReplyContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    b();
  }
  
  private void a() {}
  
  private void b() {}
  
  protected void a(stSimpleMetaComment paramstSimpleMetaComment, int paramInt, String paramString)
  {
    if ((paramstSimpleMetaComment == null) || (paramstSimpleMetaComment.replyList.size() == 0))
    {
      setVisibility(8);
      return;
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaComment = paramstSimpleMetaComment;
    ArrayList localArrayList = paramstSimpleMetaComment.replyList;
    int j = localArrayList.size();
    if (paramInt > 0) {}
    for (paramInt = Math.min(j, paramInt);; paramInt = j)
    {
      this.c = paramInt;
      setVisibility(0);
      removeAllViews();
      int i = 0;
      while (i < paramInt)
      {
        stSimpleMetaReply localstSimpleMetaReply = (stSimpleMetaReply)localArrayList.get(i);
        WsReplyView localWsReplyView = new WsReplyView(getContext());
        localWsReplyView.setPosition(i);
        localWsReplyView.setOnCommentElementClickListener(this.jdField_a_of_type_Zwe);
        localWsReplyView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        localWsReplyView.setClickable(true);
        localWsReplyView.setFocusable(true);
        localWsReplyView.setData(paramstSimpleMetaComment, localstSimpleMetaReply, paramString);
        addView(localWsReplyView);
        i += 1;
      }
      if (paramInt <= j)
      {
        if (this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView == null)
        {
          this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView = new ReplyActionView(getContext());
          this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.setClickable(true);
          this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setOnClickListener(this);
          this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.b().setOnClickListener(this);
        }
        if (paramInt <= this.b) {
          break label318;
        }
        if (paramInt != j) {
          break label278;
        }
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setVisibility(8);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.b().setVisibility(0);
      }
      for (;;)
      {
        addView(this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView);
        setVisibility(0);
        return;
        label278:
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setText(anvx.a(2131712857));
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setVisibility(0);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.b().setVisibility(0);
        continue;
        label318:
        if (j > paramInt)
        {
          paramInt = j - paramInt;
          if (paramInt > 0)
          {
            this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setText(anvx.a(2131712855) + paramInt + anvx.a(2131712856));
            this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setVisibility(0);
            this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.b().setVisibility(8);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setVisibility(8);
          this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.b().setVisibility(8);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Zwe != null)
      {
        this.jdField_a_of_type_Zwe.a(paramView, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaComment);
        continue;
        if (this.jdField_a_of_type_Zwe != null)
        {
          stSimpleMetaComment localstSimpleMetaComment = this.jdField_a_of_type_UserGrowthStSimpleMetaComment;
          int i = getHeight() / this.c;
          this.jdField_a_of_type_Zwe.a(paramView, 11, this.jdField_a_of_type_Int, new Object[] { localstSimpleMetaComment, Integer.valueOf(i) });
        }
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  public void setDisplayNum(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setOnCommentElementClickListener(zwe paramzwe)
  {
    this.jdField_a_of_type_Zwe = paramzwe;
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsReplyContainer
 * JD-Core Version:    0.7.0.1
 */