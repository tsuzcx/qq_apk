package com.tencent.biz.pubaccount.weishi_new.comment;

import aafw;
import android.widget.TextView;
import ufp;

public class WsCommentPresenter$9
  implements Runnable
{
  public WsCommentPresenter$9(ufp paramufp) {}
  
  public void run()
  {
    if (ufp.b(this.this$0) != null)
    {
      if (ufp.b(this.this$0) > 0L)
      {
        ufp.b(this.this$0).setText(aafw.a(ufp.b(this.this$0)));
        ufp.b(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    ufp.b(this.this$0).setText("");
    ufp.b(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.9
 * JD-Core Version:    0.7.0.1
 */