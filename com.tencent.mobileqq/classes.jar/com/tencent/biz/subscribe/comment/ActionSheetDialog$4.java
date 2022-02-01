package com.tencent.biz.subscribe.comment;

import android.text.TextUtils;
import android.widget.Button;
import ztv;

public class ActionSheetDialog$4
  implements Runnable
{
  public ActionSheetDialog$4(ztv paramztv, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a))
    {
      ztv.a(this.this$0).setText("");
      ztv.a(this.this$0).setVisibility(8);
      return;
    }
    ztv.a(this.this$0).setText(this.a);
    ztv.a(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.ActionSheetDialog.4
 * JD-Core Version:    0.7.0.1
 */