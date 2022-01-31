package com.tencent.biz.subscribe.comment;

import android.widget.TextView;
import vzz;
import wah;
import wbb;

public class CommentPresenter$2
  implements Runnable
{
  public CommentPresenter$2(vzz paramvzz) {}
  
  public void run()
  {
    if (vzz.a(this.this$0) != null) {
      vzz.a(this.this$0).a(vzz.a(this.this$0));
    }
    if (vzz.a(this.this$0) != null)
    {
      if (vzz.a(this.this$0) > 0)
      {
        vzz.a(this.this$0).setText(wbb.a(vzz.a(this.this$0)));
        vzz.a(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    vzz.a(this.this$0).setText("");
    vzz.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.2
 * JD-Core Version:    0.7.0.1
 */