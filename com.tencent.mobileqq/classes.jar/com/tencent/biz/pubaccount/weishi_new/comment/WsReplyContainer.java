package com.tencent.biz.pubaccount.weishi_new.comment;

import NS_KING_SOCIALIZE_META.stMetaComment;
import NS_KING_SOCIALIZE_META.stMetaReply;
import alud;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.subscribe.comment.ReplyActionView;
import java.util.ArrayList;
import java.util.List;
import yhn;

public class WsReplyContainer
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private int jdField_a_of_type_Int;
  private stMetaComment jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment;
  private ReplyActionView jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView;
  private yhn jdField_a_of_type_Yhn;
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
  
  protected void a(stMetaComment paramstMetaComment, int paramInt, String paramString)
  {
    if ((paramstMetaComment == null) || (paramstMetaComment.replyList.size() == 0))
    {
      setVisibility(8);
      return;
    }
    this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment = paramstMetaComment;
    ArrayList localArrayList = paramstMetaComment.replyList;
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
        stMetaReply localstMetaReply = (stMetaReply)localArrayList.get(i);
        WsReplyView localWsReplyView = new WsReplyView(getContext());
        localWsReplyView.setPosition(i);
        localWsReplyView.setOnCommentElementClickListener(this.jdField_a_of_type_Yhn);
        localWsReplyView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        localWsReplyView.setClickable(true);
        localWsReplyView.setFocusable(true);
        localWsReplyView.setData(paramstMetaComment, localstMetaReply, paramString);
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
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setText(alud.a(2131713790));
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setVisibility(0);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.b().setVisibility(0);
        continue;
        label318:
        if (j > paramInt)
        {
          paramInt = j - paramInt;
          if (paramInt > 0)
          {
            this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setText(alud.a(2131713788) + paramInt + alud.a(2131713789));
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
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Yhn == null);
      this.jdField_a_of_type_Yhn.a(paramView, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment);
      return;
    } while (this.jdField_a_of_type_Yhn == null);
    stMetaComment localstMetaComment = this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment;
    int i = getHeight() / this.c;
    this.jdField_a_of_type_Yhn.a(paramView, 11, this.jdField_a_of_type_Int, new Object[] { localstMetaComment, Integer.valueOf(i) });
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  public void setDisplayNum(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setOnCommentElementClickListener(yhn paramyhn)
  {
    this.jdField_a_of_type_Yhn = paramyhn;
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsReplyContainer
 * JD-Core Version:    0.7.0.1
 */