package com.tencent.biz.subscribe.comment;

import android.text.TextUtils;
import android.widget.TextView;
import wmf;

public class ActionSheetDialog$3
  implements Runnable
{
  public void run()
  {
    if (TextUtils.isEmpty(this.a))
    {
      wmf.a(this.this$0).setText("");
      wmf.a(this.this$0).setVisibility(8);
      return;
    }
    wmf.a(this.this$0).setText(this.a);
    wmf.a(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.ActionSheetDialog.3
 * JD-Core Version:    0.7.0.1
 */