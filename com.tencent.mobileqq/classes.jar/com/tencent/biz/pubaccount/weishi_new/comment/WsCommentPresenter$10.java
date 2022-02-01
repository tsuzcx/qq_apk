package com.tencent.biz.pubaccount.weishi_new.comment;

import uzq;
import vaj;
import vmp;

public class WsCommentPresenter$10
  implements Runnable
{
  public WsCommentPresenter$10(vaj paramvaj) {}
  
  public void run()
  {
    if (vaj.a(this.this$0) != null)
    {
      vaj.a(this.this$0).notifyDataSetChanged();
      return;
    }
    vmp.d("comment", "updateAdapterOnUI, mCommentAdapter is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.10
 * JD-Core Version:    0.7.0.1
 */