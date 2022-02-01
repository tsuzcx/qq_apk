package com.tencent.biz.pubaccount.weishi_new.comment;

import uez;
import ufr;
import uqf;

public class WsCommentPresenter$10
  implements Runnable
{
  public WsCommentPresenter$10(ufr paramufr) {}
  
  public void run()
  {
    if (ufr.a(this.this$0) != null)
    {
      ufr.a(this.this$0).notifyDataSetChanged();
      return;
    }
    uqf.d("comment", "updateAdapterOnUI, mCommentAdapter is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.10
 * JD-Core Version:    0.7.0.1
 */