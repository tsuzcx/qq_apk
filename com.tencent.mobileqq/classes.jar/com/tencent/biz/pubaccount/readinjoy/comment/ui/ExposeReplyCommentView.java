package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

public class ExposeReplyCommentView
  extends ViewBase
{
  private NativeExposeReplyCommentView a;
  
  public ExposeReplyCommentView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeExposeReplyCommentView(paramVafContext.getContext());
  }
  
  public void a(ReadInJoyCommentListAdapter paramReadInJoyCommentListAdapter)
  {
    this.a.setAdapter(paramReadInJoyCommentListAdapter);
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.a;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return super.setAttribute(paramInt, paramObject);
    } while ((!(paramObject instanceof CommentViewItem)) || (((CommentViewItem)paramObject).a == null));
    this.a.a((CommentViewItem)paramObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.ExposeReplyCommentView
 * JD-Core Version:    0.7.0.1
 */