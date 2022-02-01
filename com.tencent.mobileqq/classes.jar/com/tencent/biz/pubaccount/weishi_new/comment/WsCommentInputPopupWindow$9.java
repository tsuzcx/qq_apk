package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.ImageButton;
import ufj;

public class WsCommentInputPopupWindow$9
  implements Runnable
{
  public WsCommentInputPopupWindow$9(ufj paramufj, int paramInt) {}
  
  public void run()
  {
    ufj.a(this.this$0, true);
    ufj.a(this.this$0).setVisibility(0);
    ufj.b(this.this$0).setVisibility(8);
    if (this.a == 2) {
      ufj.c(this.this$0).performClick();
    }
    while (this.a != 3) {
      return;
    }
    ufj.d(this.this$0).performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.9
 * JD-Core Version:    0.7.0.1
 */