package com.tencent.biz.pubaccount.weishi_new.comment;

import aajx;
import android.widget.TextView;
import ufr;

public class WsCommentPresenter$9
  implements Runnable
{
  public WsCommentPresenter$9(ufr paramufr) {}
  
  public void run()
  {
    if (ufr.b(this.this$0) != null)
    {
      if (ufr.b(this.this$0) > 0L)
      {
        ufr.b(this.this$0).setText(aajx.a(ufr.b(this.this$0)));
        ufr.b(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    ufr.b(this.this$0).setText("");
    ufr.b(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.9
 * JD-Core Version:    0.7.0.1
 */