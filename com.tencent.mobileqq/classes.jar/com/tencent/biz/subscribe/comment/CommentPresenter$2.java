package com.tencent.biz.subscribe.comment;

import android.widget.TextView;
import ybx;
import ycg;
import yda;

public class CommentPresenter$2
  implements Runnable
{
  public CommentPresenter$2(ybx paramybx) {}
  
  public void run()
  {
    if (ybx.a(this.this$0) != null) {
      ybx.a(this.this$0).a(ybx.a(this.this$0));
    }
    if (ybx.a(this.this$0) != null)
    {
      if (ybx.a(this.this$0) > 0)
      {
        ybx.a(this.this$0).setText(yda.a(ybx.a(this.this$0)));
        ybx.a(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    ybx.a(this.this$0).setText("");
    ybx.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.2
 * JD-Core Version:    0.7.0.1
 */