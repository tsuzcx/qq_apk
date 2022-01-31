package com.tencent.biz.subscribe.comment;

import android.text.TextUtils;
import android.widget.TextView;
import yav;

public class ActionSheetDialog$3
  implements Runnable
{
  public void run()
  {
    if (TextUtils.isEmpty(this.a))
    {
      yav.a(this.this$0).setText("");
      yav.a(this.this$0).setVisibility(8);
      return;
    }
    yav.a(this.this$0).setText(this.a);
    yav.a(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.ActionSheetDialog.3
 * JD-Core Version:    0.7.0.1
 */