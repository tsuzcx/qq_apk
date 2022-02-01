package com.tencent.biz.subscribe.comment;

import android.widget.TextView;
import zfs;
import zgb;
import zgv;

public class CommentPresenter$2
  implements Runnable
{
  public CommentPresenter$2(zfs paramzfs) {}
  
  public void run()
  {
    if (zfs.a(this.this$0) != null) {
      zfs.a(this.this$0).a(zfs.a(this.this$0));
    }
    if (zfs.a(this.this$0) != null)
    {
      if (zfs.a(this.this$0) > 0)
      {
        zfs.a(this.this$0).setText(zgv.a(zfs.a(this.this$0)));
        zfs.a(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    zfs.a(this.this$0).setText("");
    zfs.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.2
 * JD-Core Version:    0.7.0.1
 */