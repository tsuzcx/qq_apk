package com.tencent.biz.subscribe.comment;

import android.text.TextUtils;
import android.widget.Button;

class ActionSheetDialog$4
  implements Runnable
{
  ActionSheetDialog$4(ActionSheetDialog paramActionSheetDialog, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a))
    {
      ActionSheetDialog.e(this.this$0).setText("");
      ActionSheetDialog.e(this.this$0).setVisibility(8);
      return;
    }
    ActionSheetDialog.e(this.this$0).setText(this.a);
    ActionSheetDialog.e(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.ActionSheetDialog.4
 * JD-Core Version:    0.7.0.1
 */