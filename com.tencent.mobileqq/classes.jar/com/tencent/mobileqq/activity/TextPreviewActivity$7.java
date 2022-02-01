package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;

class TextPreviewActivity$7
  implements Runnable
{
  TextPreviewActivity$7(TextPreviewActivity paramTextPreviewActivity) {}
  
  public void run()
  {
    Drawable localDrawable = this.this$0.D.getFontNameDrawable(this.this$0.F);
    if (localDrawable == null)
    {
      TextPreviewActivity.a(this.this$0.F, this.this$0.app, this.this$0.ag);
      return;
    }
    Message localMessage = this.this$0.E.obtainMessage(18);
    localMessage.obj = localDrawable;
    this.this$0.E.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity.7
 * JD-Core Version:    0.7.0.1
 */