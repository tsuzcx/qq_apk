package com.tencent.biz.subscribe.comment;

import aaiu;
import aajd;
import aajx;
import android.widget.TextView;

public class CommentPresenter$2
  implements Runnable
{
  public CommentPresenter$2(aaiu paramaaiu) {}
  
  public void run()
  {
    if (aaiu.a(this.this$0) != null) {
      aaiu.a(this.this$0).a(aaiu.a(this.this$0));
    }
    if (aaiu.a(this.this$0) != null)
    {
      if (aaiu.a(this.this$0) > 0)
      {
        aaiu.a(this.this$0).setText(aajx.a(aaiu.a(this.this$0)));
        aaiu.a(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    aaiu.a(this.this$0).setText("");
    aaiu.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.2
 * JD-Core Version:    0.7.0.1
 */