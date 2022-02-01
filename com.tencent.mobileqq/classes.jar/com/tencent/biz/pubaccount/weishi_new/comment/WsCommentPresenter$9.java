package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.TextView;
import com.tencent.biz.subscribe.comment.Formatter;

class WsCommentPresenter$9
  implements Runnable
{
  WsCommentPresenter$9(WsCommentPresenter paramWsCommentPresenter) {}
  
  public void run()
  {
    if (WsCommentPresenter.b(this.this$0) != null)
    {
      if (WsCommentPresenter.b(this.this$0) > 0L)
      {
        WsCommentPresenter.b(this.this$0).setText(Formatter.a(WsCommentPresenter.b(this.this$0)));
        WsCommentPresenter.b(this.this$0).setVisibility(0);
        return;
      }
      WsCommentPresenter.b(this.this$0).setText("");
      WsCommentPresenter.b(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.9
 * JD-Core Version:    0.7.0.1
 */