package com.tencent.biz.pubaccount.weishi_new.comment;

import uex;
import ufp;
import upe;

public class WsCommentPresenter$10
  implements Runnable
{
  public WsCommentPresenter$10(ufp paramufp) {}
  
  public void run()
  {
    if (ufp.a(this.this$0) != null)
    {
      ufp.a(this.this$0).notifyDataSetChanged();
      return;
    }
    upe.d("comment", "updateAdapterOnUI, mCommentAdapter is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.10
 * JD-Core Version:    0.7.0.1
 */