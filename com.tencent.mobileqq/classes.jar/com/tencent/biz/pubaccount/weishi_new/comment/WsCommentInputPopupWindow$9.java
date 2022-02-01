package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.ImageButton;
import ufh;

public class WsCommentInputPopupWindow$9
  implements Runnable
{
  public WsCommentInputPopupWindow$9(ufh paramufh, int paramInt) {}
  
  public void run()
  {
    ufh.a(this.this$0, true);
    ufh.a(this.this$0).setVisibility(0);
    ufh.b(this.this$0).setVisibility(8);
    if (this.a == 2) {
      ufh.c(this.this$0).performClick();
    }
    while (this.a != 3) {
      return;
    }
    ufh.d(this.this$0).performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.9
 * JD-Core Version:    0.7.0.1
 */