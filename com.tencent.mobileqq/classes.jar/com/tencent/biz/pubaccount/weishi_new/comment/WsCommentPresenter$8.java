package com.tencent.biz.pubaccount.weishi_new.comment;

import tcs;
import tdn;
import tlo;

public class WsCommentPresenter$8
  implements Runnable
{
  public WsCommentPresenter$8(tdn paramtdn) {}
  
  public void run()
  {
    if (tdn.a(this.this$0) != null)
    {
      tdn.a(this.this$0).notifyDataSetChanged();
      return;
    }
    tlo.d(tdn.a(this.this$0), "updateAdapterOnUI, mCommentAdapter is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.8
 * JD-Core Version:    0.7.0.1
 */