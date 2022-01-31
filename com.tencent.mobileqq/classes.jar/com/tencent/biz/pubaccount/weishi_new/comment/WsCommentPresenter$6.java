package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.ListView;
import tdn;
import tlo;

public class WsCommentPresenter$6
  implements Runnable
{
  public WsCommentPresenter$6(tdn paramtdn) {}
  
  public void run()
  {
    tdn.c(this.this$0);
    tlo.d(tdn.a(this.this$0), "onResponse, lastPosition:" + tdn.b(this.this$0) + ",currentPosition:" + tdn.a(this.this$0));
    if (this.this$0.a != null) {
      this.this$0.a.setSelection(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.6
 * JD-Core Version:    0.7.0.1
 */