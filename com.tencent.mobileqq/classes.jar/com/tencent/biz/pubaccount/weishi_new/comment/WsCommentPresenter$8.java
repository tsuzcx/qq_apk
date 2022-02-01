package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.ListView;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WsCommentPresenter$8
  implements Runnable
{
  WsCommentPresenter$8(WsCommentPresenter paramWsCommentPresenter) {}
  
  public void run()
  {
    WsCommentPresenter.a(this.this$0, false);
    WsCommentPresenter.d(this.this$0);
    WSLog.d("comment", "onResponse, lastPosition:" + WsCommentPresenter.c(this.this$0) + ",currentPosition:" + WsCommentPresenter.b(this.this$0));
    if (this.this$0.a != null) {
      this.this$0.a.setSelection(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.8
 * JD-Core Version:    0.7.0.1
 */