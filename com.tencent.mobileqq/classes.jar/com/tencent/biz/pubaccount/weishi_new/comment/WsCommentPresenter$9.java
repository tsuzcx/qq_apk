package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.TextView;
import vaj;
import zwa;

public class WsCommentPresenter$9
  implements Runnable
{
  public WsCommentPresenter$9(vaj paramvaj) {}
  
  public void run()
  {
    if (vaj.b(this.this$0) != null)
    {
      if (vaj.b(this.this$0) > 0L)
      {
        vaj.b(this.this$0).setText(zwa.a(vaj.b(this.this$0)));
        vaj.b(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    vaj.b(this.this$0).setText("");
    vaj.b(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.9
 * JD-Core Version:    0.7.0.1
 */