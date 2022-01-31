package com.tencent.biz.subscribe.comment;

import android.text.TextUtils;
import android.widget.Button;
import vyw;

public class ActionSheetDialog$4
  implements Runnable
{
  public ActionSheetDialog$4(vyw paramvyw, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a))
    {
      vyw.a(this.this$0).setText("");
      vyw.a(this.this$0).setVisibility(8);
      return;
    }
    vyw.a(this.this$0).setText(this.a);
    vyw.a(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.ActionSheetDialog.4
 * JD-Core Version:    0.7.0.1
 */