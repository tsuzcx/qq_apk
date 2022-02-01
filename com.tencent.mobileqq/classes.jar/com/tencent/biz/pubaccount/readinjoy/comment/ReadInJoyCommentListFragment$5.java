package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;

class ReadInJoyCommentListFragment$5
  extends ReadInJoyObserver
{
  ReadInJoyCommentListFragment$5(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void b(String paramString)
  {
    super.b(paramString);
    if (ReadInJoyCommentListFragment.a(this.a) != null)
    {
      paramString = ReadInJoyCommentListFragment.a(this.a).a(paramString, ReadInJoyCommentListFragment.a(this.a));
      if (paramString != null) {
        ReadInJoyCommentListFragment.a(this.a).a(paramString, CommentProteusUtil.a(paramString, 0), 2);
      }
      ReadInJoyCommentListFragment.a(this.a).notifyDataSetChanged();
    }
  }
  
  public void c()
  {
    if (ReadInJoyCommentListFragment.a(this.a) != null) {
      ReadInJoyCommentListFragment.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment.5
 * JD-Core Version:    0.7.0.1
 */