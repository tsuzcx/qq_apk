package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.ListView;
import ufr;
import uqf;

public class WsCommentPresenter$8
  implements Runnable
{
  public WsCommentPresenter$8(ufr paramufr) {}
  
  public void run()
  {
    ufr.a(this.this$0, false);
    ufr.d(this.this$0);
    uqf.d("comment", "onResponse, lastPosition:" + ufr.c(this.this$0) + ",currentPosition:" + ufr.b(this.this$0));
    if (this.this$0.a != null) {
      this.this$0.a.setSelection(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.8
 * JD-Core Version:    0.7.0.1
 */