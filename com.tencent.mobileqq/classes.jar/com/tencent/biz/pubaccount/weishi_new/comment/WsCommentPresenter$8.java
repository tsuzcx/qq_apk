package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.ListView;
import ufp;
import upe;

public class WsCommentPresenter$8
  implements Runnable
{
  public WsCommentPresenter$8(ufp paramufp) {}
  
  public void run()
  {
    ufp.a(this.this$0, false);
    ufp.d(this.this$0);
    upe.d("comment", "onResponse, lastPosition:" + ufp.c(this.this$0) + ",currentPosition:" + ufp.b(this.this$0));
    if (this.this$0.a != null) {
      this.this$0.a.setSelection(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.8
 * JD-Core Version:    0.7.0.1
 */