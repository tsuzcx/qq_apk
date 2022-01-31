package com.tencent.biz.subscribe.comment;

import android.widget.TextView;
import wnl;
import wnu;
import woo;

public class CommentPresenter$2
  implements Runnable
{
  public CommentPresenter$2(wnl paramwnl) {}
  
  public void run()
  {
    if (wnl.a(this.this$0) != null) {
      wnl.a(this.this$0).a(wnl.a(this.this$0));
    }
    if (wnl.a(this.this$0) != null)
    {
      if (wnl.a(this.this$0) > 0)
      {
        wnl.a(this.this$0).setText(woo.a(wnl.a(this.this$0)));
        wnl.a(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    wnl.a(this.this$0).setText("");
    wnl.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.2
 * JD-Core Version:    0.7.0.1
 */