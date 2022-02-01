package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.ListView;
import vaj;
import vmp;

public class WsCommentPresenter$8
  implements Runnable
{
  public WsCommentPresenter$8(vaj paramvaj) {}
  
  public void run()
  {
    vaj.a(this.this$0, false);
    vaj.d(this.this$0);
    vmp.d("comment", "onResponse, lastPosition:" + vaj.c(this.this$0) + ",currentPosition:" + vaj.b(this.this$0));
    if (this.this$0.a != null) {
      this.this$0.a.setSelection(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.8
 * JD-Core Version:    0.7.0.1
 */