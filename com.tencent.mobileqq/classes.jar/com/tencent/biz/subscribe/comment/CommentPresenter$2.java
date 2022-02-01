package com.tencent.biz.subscribe.comment;

import aaet;
import aafc;
import aafw;
import android.widget.TextView;

public class CommentPresenter$2
  implements Runnable
{
  public CommentPresenter$2(aaet paramaaet) {}
  
  public void run()
  {
    if (aaet.a(this.this$0) != null) {
      aaet.a(this.this$0).a(aaet.a(this.this$0));
    }
    if (aaet.a(this.this$0) != null)
    {
      if (aaet.a(this.this$0) > 0)
      {
        aaet.a(this.this$0).setText(aafw.a(aaet.a(this.this$0)));
        aaet.a(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    aaet.a(this.this$0).setText("");
    aaet.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.2
 * JD-Core Version:    0.7.0.1
 */