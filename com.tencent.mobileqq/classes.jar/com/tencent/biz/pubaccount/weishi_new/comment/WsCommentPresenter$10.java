package com.tencent.biz.pubaccount.weishi_new.comment;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WsCommentPresenter$10
  implements Runnable
{
  WsCommentPresenter$10(WsCommentPresenter paramWsCommentPresenter) {}
  
  public void run()
  {
    if (WsCommentPresenter.a(this.this$0) != null)
    {
      WsCommentPresenter.a(this.this$0).notifyDataSetChanged();
      return;
    }
    WSLog.d("comment", "updateAdapterOnUI, mCommentAdapter is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.10
 * JD-Core Version:    0.7.0.1
 */