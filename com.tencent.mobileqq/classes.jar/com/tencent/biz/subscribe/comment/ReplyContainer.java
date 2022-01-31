package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import ajjy;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;
import wbf;

public class ReplyContainer
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private int jdField_a_of_type_Int;
  private CertifiedAccountMeta.StComment jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
  private ReplyActionView jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView;
  private wbf jdField_a_of_type_Wbf;
  private int b;
  private int c;
  
  public ReplyContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReplyContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReplyContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    b();
  }
  
  private void a() {}
  
  private void b() {}
  
  protected void a(CertifiedAccountMeta.StComment paramStComment, int paramInt, String paramString)
  {
    if ((paramStComment == null) || (paramStComment.vecReply.size() == 0))
    {
      setVisibility(8);
      return;
    }
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment = paramStComment;
    List localList = paramStComment.vecReply.get();
    int j = localList.size();
    if (j > 0) {
      if (paramInt <= 0) {
        break label441;
      }
    }
    label286:
    label441:
    for (paramInt = Math.min(j, paramInt);; paramInt = j)
    {
      this.c = paramInt;
      setVisibility(0);
      removeAllViews();
      int i = 0;
      while (i < paramInt)
      {
        CertifiedAccountMeta.StReply localStReply = (CertifiedAccountMeta.StReply)localList.get(i);
        ReplyView localReplyView = new ReplyView(getContext());
        localReplyView.setPosition(i);
        localReplyView.setOnCommentElementClickListener(this.jdField_a_of_type_Wbf);
        localReplyView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        localReplyView.setClickable(true);
        localReplyView.setFocusable(true);
        localReplyView.setData(paramStComment, localStReply, paramString);
        addView(localReplyView);
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
          break label326;
        }
        if (paramInt != j) {
          break label286;
        }
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setVisibility(8);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.b().setVisibility(0);
      }
      for (;;)
      {
        addView(this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView);
        setVisibility(0);
        return;
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setText(ajjy.a(2131647607));
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setVisibility(0);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.b().setVisibility(0);
        continue;
        label326:
        if (j > paramInt)
        {
          paramInt = j - paramInt;
          if (paramInt > 0)
          {
            this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setText(ajjy.a(2131647605) + paramInt + ajjy.a(2131647606));
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
      setVisibility(8);
      return;
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
      } while (this.jdField_a_of_type_Wbf == null);
      this.jdField_a_of_type_Wbf.a(paramView, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment);
      return;
    } while (this.jdField_a_of_type_Wbf == null);
    CertifiedAccountMeta.StComment localStComment = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
    int i = getHeight() / this.c;
    this.jdField_a_of_type_Wbf.a(paramView, 11, this.jdField_a_of_type_Int, new Object[] { localStComment, Integer.valueOf(i) });
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  public void setDisplayNum(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setOnCommentElementClickListener(wbf paramwbf)
  {
    this.jdField_a_of_type_Wbf = paramwbf;
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.ReplyContainer
 * JD-Core Version:    0.7.0.1
 */