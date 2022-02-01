package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.TextView;
import umj;
import zgv;

public class WsCommentPresenter$9
  implements Runnable
{
  public WsCommentPresenter$9(umj paramumj) {}
  
  public void run()
  {
    if (umj.b(this.this$0) != null)
    {
      if (umj.b(this.this$0) > 0L)
      {
        umj.b(this.this$0).setText(zgv.a(umj.b(this.this$0)));
        umj.b(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    umj.b(this.this$0).setText("");
    umj.b(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.9
 * JD-Core Version:    0.7.0.1
 */