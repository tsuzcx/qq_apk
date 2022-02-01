package com.tencent.biz.subscribe.comment;

import android.widget.TextView;
import zux;
import zvg;
import zwa;

public class CommentPresenter$2
  implements Runnable
{
  public CommentPresenter$2(zux paramzux) {}
  
  public void run()
  {
    if (zux.a(this.this$0) != null) {
      zux.a(this.this$0).a(zux.a(this.this$0));
    }
    if (zux.a(this.this$0) != null)
    {
      if (zux.a(this.this$0) > 0)
      {
        zux.a(this.this$0).setText(zwa.a(zux.a(this.this$0)));
        zux.a(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    zux.a(this.this$0).setText("");
    zux.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.2
 * JD-Core Version:    0.7.0.1
 */