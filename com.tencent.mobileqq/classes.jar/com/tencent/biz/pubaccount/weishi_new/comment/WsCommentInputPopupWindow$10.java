package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.ImageButton;
import tdf;

public class WsCommentInputPopupWindow$10
  implements Runnable
{
  public WsCommentInputPopupWindow$10(tdf paramtdf, int paramInt) {}
  
  public void run()
  {
    tdf.b(this.this$0);
    tdf.a(this.this$0).setVisibility(0);
    tdf.b(this.this$0).setVisibility(8);
    if (this.a == 2) {
      tdf.c(this.this$0).performClick();
    }
    while (this.a != 3) {
      return;
    }
    tdf.d(this.this$0).performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.10
 * JD-Core Version:    0.7.0.1
 */