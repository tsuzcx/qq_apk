package com.tencent.biz.pubaccount.readinjoy.comment;

import mqq.util.WeakReference;

public class ReadInJoySecondCommentListAdapter$SecondCommentOperationCallback
{
  private final WeakReference a;
  
  public ReadInJoySecondCommentListAdapter$SecondCommentOperationCallback(ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment)
  {
    this.a = new WeakReference(paramReadInJoySecondCommentListFragment);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, CommentInfo paramCommentInfo)
  {
    if (this.a.get() != null) {
      ((ReadInJoySecondCommentListFragment)this.a.get()).a(paramString1, paramString2, paramInt, paramCommentInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListAdapter.SecondCommentOperationCallback
 * JD-Core Version:    0.7.0.1
 */