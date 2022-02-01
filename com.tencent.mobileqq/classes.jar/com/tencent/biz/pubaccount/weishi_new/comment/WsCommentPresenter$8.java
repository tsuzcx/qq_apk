package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.ListView;
import umj;
import uya;

public class WsCommentPresenter$8
  implements Runnable
{
  public WsCommentPresenter$8(umj paramumj) {}
  
  public void run()
  {
    umj.a(this.this$0, false);
    umj.d(this.this$0);
    uya.d("comment", "onResponse, lastPosition:" + umj.c(this.this$0) + ",currentPosition:" + umj.b(this.this$0));
    if (this.this$0.a != null) {
      this.this$0.a.setSelection(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.8
 * JD-Core Version:    0.7.0.1
 */