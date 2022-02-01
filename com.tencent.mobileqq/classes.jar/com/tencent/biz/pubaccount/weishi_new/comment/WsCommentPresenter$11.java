package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.TextView;
import com.tencent.biz.subscribe.comment.Formatter;

class WsCommentPresenter$11
  implements Runnable
{
  WsCommentPresenter$11(WsCommentPresenter paramWsCommentPresenter) {}
  
  public void run()
  {
    if (WsCommentPresenter.k(this.this$0) != null)
    {
      if (WsCommentPresenter.l(this.this$0) > 0L)
      {
        WsCommentPresenter.k(this.this$0).setText(Formatter.a(WsCommentPresenter.l(this.this$0)));
        WsCommentPresenter.k(this.this$0).setVisibility(0);
        return;
      }
      WsCommentPresenter.k(this.this$0).setText("");
      WsCommentPresenter.k(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.11
 * JD-Core Version:    0.7.0.1
 */