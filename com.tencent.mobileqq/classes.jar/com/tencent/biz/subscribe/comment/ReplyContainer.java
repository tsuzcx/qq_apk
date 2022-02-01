package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import aakb;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anzj;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ReplyContainer
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private int jdField_a_of_type_Int;
  private CertifiedAccountMeta.StComment jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
  private aakb jdField_a_of_type_Aakb;
  private ReplyActionView jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView;
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
  
  public ReplyView a(String paramString)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.vecReply.get() != null))
    {
      int j = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.vecReply.get().size();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          if ((((CertifiedAccountMeta.StReply)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.vecReply.get(i)).id.get().equals(paramString)) && (getChildCount() > i + 1) && ((getChildAt(i) instanceof ReplyView))) {
            return (ReplyView)getChildAt(i);
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
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
        break label442;
      }
    }
    label286:
    label442:
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
        localReplyView.setOnCommentElementClickListener(this.jdField_a_of_type_Aakb);
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
          break label327;
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
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setText(anzj.a(2131712278));
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setVisibility(0);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.b().setVisibility(8);
        continue;
        label327:
        if (j > paramInt)
        {
          paramInt = j - paramInt;
          if (paramInt > 0)
          {
            this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setText(anzj.a(2131712276) + paramInt + anzj.a(2131712277));
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Aakb != null)
      {
        this.jdField_a_of_type_Aakb.a(paramView, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment);
        continue;
        if (this.jdField_a_of_type_Aakb != null)
        {
          CertifiedAccountMeta.StComment localStComment = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
          int i = getHeight() / this.c;
          this.jdField_a_of_type_Aakb.a(paramView, 11, this.jdField_a_of_type_Int, new Object[] { localStComment, Integer.valueOf(i) });
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
  
  public void setOnCommentElementClickListener(aakb paramaakb)
  {
    this.jdField_a_of_type_Aakb = paramaakb;
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.ReplyContainer
 * JD-Core Version:    0.7.0.1
 */