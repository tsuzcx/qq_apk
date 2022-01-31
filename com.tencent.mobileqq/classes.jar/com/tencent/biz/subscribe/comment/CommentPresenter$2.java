package com.tencent.biz.subscribe.comment;

import android.widget.TextView;
import ygg;
import ygp;
import yhj;

public class CommentPresenter$2
  implements Runnable
{
  public CommentPresenter$2(ygg paramygg) {}
  
  public void run()
  {
    if (ygg.a(this.this$0) != null) {
      ygg.a(this.this$0).a(ygg.a(this.this$0));
    }
    if (ygg.a(this.this$0) != null)
    {
      if (ygg.a(this.this$0) > 0)
      {
        ygg.a(this.this$0).setText(yhj.a(ygg.a(this.this$0)));
        ygg.a(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    ygg.a(this.this$0).setText("");
    ygg.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.2
 * JD-Core Version:    0.7.0.1
 */