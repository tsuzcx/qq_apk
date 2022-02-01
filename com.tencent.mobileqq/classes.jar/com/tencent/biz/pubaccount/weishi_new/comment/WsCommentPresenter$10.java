package com.tencent.biz.pubaccount.weishi_new.comment;

import ulq;
import umj;
import uya;

public class WsCommentPresenter$10
  implements Runnable
{
  public WsCommentPresenter$10(umj paramumj) {}
  
  public void run()
  {
    if (umj.a(this.this$0) != null)
    {
      umj.a(this.this$0).notifyDataSetChanged();
      return;
    }
    uya.d("comment", "updateAdapterOnUI, mCommentAdapter is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.10
 * JD-Core Version:    0.7.0.1
 */