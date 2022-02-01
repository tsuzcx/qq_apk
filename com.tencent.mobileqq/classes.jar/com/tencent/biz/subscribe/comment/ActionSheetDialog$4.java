package com.tencent.biz.subscribe.comment;

import aadr;
import android.text.TextUtils;
import android.widget.Button;

public class ActionSheetDialog$4
  implements Runnable
{
  public ActionSheetDialog$4(aadr paramaadr, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a))
    {
      aadr.a(this.this$0).setText("");
      aadr.a(this.this$0).setVisibility(8);
      return;
    }
    aadr.a(this.this$0).setText(this.a);
    aadr.a(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.ActionSheetDialog.4
 * JD-Core Version:    0.7.0.1
 */