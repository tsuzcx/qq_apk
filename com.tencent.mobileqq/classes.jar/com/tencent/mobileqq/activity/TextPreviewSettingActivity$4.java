package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;

class TextPreviewSettingActivity$4
  implements Runnable
{
  TextPreviewSettingActivity$4(TextPreviewSettingActivity paramTextPreviewSettingActivity) {}
  
  public void run()
  {
    Drawable localDrawable = TextPreviewSettingActivity.b(this.this$0).getFontNameDrawable(TextPreviewSettingActivity.a(this.this$0));
    if (localDrawable == null)
    {
      TextPreviewSettingActivity.a(TextPreviewSettingActivity.a(this.this$0), this.this$0.app, this.this$0.b);
      return;
    }
    Message localMessage = TextPreviewSettingActivity.d(this.this$0).obtainMessage(18);
    localMessage.obj = localDrawable;
    TextPreviewSettingActivity.d(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewSettingActivity.4
 * JD-Core Version:    0.7.0.1
 */