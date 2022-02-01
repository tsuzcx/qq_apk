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
  private int jdField_a_of_type_Int;
  private stSimpleMetaComment jdField_a_of_type_UserGrowthStSimpleMetaComment;
  private OnCommentElementClickListener jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener;
  private ReplyActionView jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView;
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
    if ((paramstSimpleMetaComment != null) && (paramstSimpleMetaComment.replyList.size() != 0))
    {
      this.jdField_a_of_type_UserGrowthStSimpleMetaComment = paramstSimpleMetaComment;
      ArrayList localArrayList = paramstSimpleMetaComment.replyList;
      int j = localArrayList.size();
      if (paramInt > 0) {
        paramInt = Math.min(j, paramInt);
      } else {
        paramInt = j;
      }
      this.c = paramInt;
      setVisibility(0);
      removeAllViews();
      int i = 0;
      while (i < paramInt)
      {
        stSimpleMetaReply localstSimpleMetaReply = (stSimpleMetaReply)localArrayList.get(i);
        WsReplyView localWsReplyView = new WsReplyView(getContext());
        localWsReplyView.setPosition(i);
        localWsReplyView.setOnCommentElementClickListener(this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener);
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
        if (paramInt > this.b)
        {
          if (paramInt == j)
          {
            this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setVisibility(8);
            this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.b().setVisibility(0);
          }
          else
          {
            this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setText(HardCodeUtil.a(2131713321));
            this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setVisibility(0);
            this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.b().setVisibility(0);
          }
        }
        else if (j > paramInt)
        {
          paramInt = j - paramInt;
          if (paramInt > 0)
          {
            paramstSimpleMetaComment = this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a();
            paramString = new StringBuilder();
            paramString.append(HardCodeUtil.a(2131713319));
            paramString.append(paramInt);
            paramString.append(HardCodeUtil.a(2131713320));
            paramstSimpleMetaComment.setText(paramString.toString());
            this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setVisibility(0);
            this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.b().setVisibility(8);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.a().setVisibility(8);
          this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.b().setVisibility(8);
        }
        addView(this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView);
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
    if (i != 2131369989)
    {
      if (i != 2131371510) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener;
      if (localObject != null) {
        ((OnCommentElementClickListener)localObject).a(paramView, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaComment);
      }
    }
    else if (this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener != null)
    {
      localObject = this.jdField_a_of_type_UserGrowthStSimpleMetaComment;
      i = getHeight() / this.c;
      this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener.a(paramView, 11, this.jdField_a_of_type_Int, new Object[] { localObject, Integer.valueOf(i) });
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
    this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener = paramOnCommentElementClickListener;
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsReplyContainer
 * JD-Core Version:    0.7.0.1
 */