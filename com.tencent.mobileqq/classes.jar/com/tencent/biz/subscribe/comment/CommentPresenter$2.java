package com.tencent.biz.subscribe.comment;

import android.widget.TextView;
import wni;
import wnr;
import wol;

public class CommentPresenter$2
  implements Runnable
{
  public CommentPresenter$2(wni paramwni) {}
  
  public void run()
  {
    if (wni.a(this.this$0) != null) {
      wni.a(this.this$0).a(wni.a(this.this$0));
    }
    if (wni.a(this.this$0) != null)
    {
      if (wni.a(this.this$0) > 0)
      {
        wni.a(this.this$0).setText(wol.a(wni.a(this.this$0)));
        wni.a(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    wni.a(this.this$0).setText("");
    wni.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.2
 * JD-Core Version:    0.7.0.1
 */