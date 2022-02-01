package com.tencent.biz.pubaccount.weishi_new.comment;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WsCommentPresenter$12
  implements Runnable
{
  WsCommentPresenter$12(WsCommentPresenter paramWsCommentPresenter) {}
  
  public void run()
  {
    if (WsCommentPresenter.m(this.this$0) != null)
    {
      WsCommentPresenter.m(this.this$0).notifyDataSetChanged();
      return;
    }
    WSLog.d("comment", "updateAdapterOnUI, mCommentAdapter is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.12
 * JD-Core Version:    0.7.0.1
 */