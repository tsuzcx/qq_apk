package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.ListView;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WsCommentPresenter$10
  implements Runnable
{
  WsCommentPresenter$10(WsCommentPresenter paramWsCommentPresenter) {}
  
  public void run()
  {
    WsCommentPresenter.a(this.this$0, false);
    WsCommentPresenter.i(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResponse, lastPosition:");
    localStringBuilder.append(WsCommentPresenter.j(this.this$0));
    localStringBuilder.append(",currentPosition:");
    localStringBuilder.append(this.this$0.o());
    WSLog.d("comment", localStringBuilder.toString());
    if (WsCommentPresenter.a(this.this$0) != null) {
      WsCommentPresenter.a(this.this$0).setSelection(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.10
 * JD-Core Version:    0.7.0.1
 */