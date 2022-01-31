package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.TextView;
import tdn;
import yhj;

public class WsCommentPresenter$7
  implements Runnable
{
  public WsCommentPresenter$7(tdn paramtdn) {}
  
  public void run()
  {
    if (tdn.b(this.this$0) != null)
    {
      if (tdn.b(this.this$0) > 0L)
      {
        tdn.b(this.this$0).setText(yhj.a(tdn.b(this.this$0)));
        tdn.b(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    tdn.b(this.this$0).setText("");
    tdn.b(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.7
 * JD-Core Version:    0.7.0.1
 */