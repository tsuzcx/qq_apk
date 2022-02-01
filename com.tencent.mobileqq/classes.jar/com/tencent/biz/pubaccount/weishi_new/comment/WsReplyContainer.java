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
import com.tencent.biz.subscribe.comment.OnCommentElementClickListener;
import com.tencent.biz.subscribe.comment.ReplyActionView;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;
import java.util.List;

public class WsReplyContainer
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private int a;
  private int b;
  private OnCommentElementClickListener c;
  private ReplyActionView d;
  private stSimpleMetaComment e;
  private int f;
  
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
  
  protected void a(stSimpleMetaComment paramstSimpleMetaComment, int paramInt, String paramString, WSOnGetReportInfo paramWSOnGetReportInfo)
  {
    if ((paramstSimpleMetaComment != null) && (paramstSimpleMetaComment.replyList.size() != 0))
    {
      this.e = paramstSimpleMetaComment;
      ArrayList localArrayList = paramstSimpleMetaComment.replyList;
      int j = localArrayList.size();
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
        stSimpleMetaReply localstSimpleMetaReply = (stSimpleMetaReply)localArrayList.get(i);
        WsReplyView localWsReplyView = new WsReplyView(getContext());
        localWsReplyView.setPosition(i);
        localWsReplyView.setOnCommentElementClickListener(this.c);
        localWsReplyView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        localWsReplyView.setClickable(true);
        localWsReplyView.setFocusable(true);
        localWsReplyView.setReportParams(paramWSOnGetReportInfo, this.a);
        localWsReplyView.setData(paramstSimpleMetaComment, localstSimpleMetaReply, paramString);
        addView(localWsReplyView);
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
            this.d.getLessReply().setVisibility(0);
          }
        }
        else if (j > paramInt)
        {
          paramInt = j - paramInt;
          if (paramInt > 0)
          {
            paramstSimpleMetaComment = this.d.getMoreReply();
            paramString = new StringBuilder();
            paramString.append(HardCodeUtil.a(2131910872));
            paramString.append(paramInt);
            paramString.append(HardCodeUtil.a(2131910873));
            paramstSimpleMetaComment.setText(paramString.toString());
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
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i != 2131437142)
    {
      if (i != 2131438887) {
        return;
      }
      localObject = this.c;
      if (localObject != null) {
        ((OnCommentElementClickListener)localObject).a(paramView, 10, this.a, this.e);
      }
    }
    else if (this.c != null)
    {
      localObject = this.e;
      i = getHeight() / this.f;
      this.c.a(paramView, 11, this.a, new Object[] { localObject, Integer.valueOf(i) });
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
  
  public void setOnCommentElementClickListener(OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.c = paramOnCommentElementClickListener;
  }
  
  public void setPosition(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsReplyContainer
 * JD-Core Version:    0.7.0.1
 */