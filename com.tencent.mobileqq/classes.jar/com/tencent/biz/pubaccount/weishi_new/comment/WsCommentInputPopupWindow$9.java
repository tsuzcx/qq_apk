package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.ImageButton;
import umb;

public class WsCommentInputPopupWindow$9
  implements Runnable
{
  public WsCommentInputPopupWindow$9(umb paramumb, int paramInt) {}
  
  public void run()
  {
    umb.a(this.this$0, true);
    umb.a(this.this$0).setVisibility(0);
    umb.b(this.this$0).setVisibility(8);
    if (this.a == 2) {
      umb.c(this.this$0).performClick();
    }
    while (this.a != 3) {
      return;
    }
    umb.d(this.this$0).performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.9
 * JD-Core Version:    0.7.0.1
 */