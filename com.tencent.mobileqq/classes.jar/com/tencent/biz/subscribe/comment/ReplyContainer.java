package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ReplyContainer
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private int a;
  private int b;
  private OnCommentElementClickListener c;
  private ReplyActionView d;
  private CertifiedAccountMeta.StComment e;
  private int f;
  
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
    CertifiedAccountMeta.StComment localStComment = this.e;
    if ((localStComment != null) && (localStComment.vecReply.get() != null))
    {
      int j = this.e.vecReply.get().size();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          if ((((CertifiedAccountMeta.StReply)this.e.vecReply.get(i)).id.get().equals(paramString)) && (getChildCount() > i + 1) && ((getChildAt(i) instanceof ReplyView))) {
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
    if ((paramStComment != null) && (paramStComment.vecReply.size() != 0))
    {
      this.e = paramStComment;
      List localList = paramStComment.vecReply.get();
      int j = localList.size();
      if (j > 0)
      {
        if (paramInt > 0) {
          paramInt = Math.min(j, paramInt);
        } else {
          paramInt = j;
        }
        this.f = paramInt;
        setVisibility(0);
        removeAllViews();
        int i = 0;
        while (i < paramInt)
        {
          CertifiedAccountMeta.StReply localStReply = (CertifiedAccountMeta.StReply)localList.get(i);
          ReplyView localReplyView = new ReplyView(getContext());
          localReplyView.setPosition(i);
          localReplyView.setOnCommentElementClickListener(this.c);
          localReplyView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
          localReplyView.setClickable(true);
          localReplyView.setFocusable(true);
          localReplyView.setData(paramStComment, localStReply, paramString);
          addView(localReplyView);
          i += 1;
        }
        if (paramInt <= j)
        {
          if (this.d == null)
          {
            this.d = new ReplyActionView(getContext());
            this.d.setClickable(true);
            this.d.getMoreReply().setOnClickListener(this);
            this.d.getLessReply().setOnClickListener(this);
          }
          if (paramInt > this.b)
          {
            if (paramInt == j)
            {
              this.d.getMoreReply().setVisibility(8);
              this.d.getLessReply().setVisibility(0);
            }
            else
            {
              this.d.getMoreReply().setText(HardCodeUtil.a(2131910874));
              this.d.getMoreReply().setVisibility(0);
              this.d.getLessReply().setVisibility(8);
            }
          }
          else if (j > paramInt)
          {
            paramInt = j - paramInt;
            if (paramInt > 0)
            {
              paramStComment = this.d.getMoreReply();
              paramString = new StringBuilder();
              paramString.append(HardCodeUtil.a(2131910872));
              paramString.append(paramInt);
              paramString.append(HardCodeUtil.a(2131910873));
              paramStComment.setText(paramString.toString());
              this.d.getMoreReply().setVisibility(0);
              this.d.getLessReply().setVisibility(8);
            }
          }
          else
          {
            this.d.getMoreReply().setVisibility(8);
            this.d.getLessReply().setVisibility(8);
          }
          addView(this.d);
        }
        setVisibility(0);
        return;
      }
      setVisibility(8);
      return;
    }
    setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i != 2131437142)
    {
      if (i == 2131438887)
      {
        localObject = this.c;
        if (localObject != null) {
          ((OnCommentElementClickListener)localObject).a(paramView, 10, this.a, this.e);
        }
      }
    }
    else if (this.c != null)
    {
      localObject = this.e;
      i = getHeight() / this.f;
      this.c.a(paramView, 11, this.a, new Object[] { localObject, Integer.valueOf(i) });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  public void setDisplayNum(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setOnCommentElementClickListener(OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.c = paramOnCommentElementClickListener;
  }
  
  public void setPosition(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.ReplyContainer
 * JD-Core Version:    0.7.0.1
 */