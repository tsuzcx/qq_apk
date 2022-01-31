package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import fx;

class TextPreviewActivity$8
  implements Runnable
{
  TextPreviewActivity$8(TextPreviewActivity paramTextPreviewActivity) {}
  
  public void run()
  {
    Drawable localDrawable = this.this$0.jdField_a_of_type_Fx.a(this.this$0.e);
    if (localDrawable == null)
    {
      TextPreviewActivity.a(this.this$0.e, this.this$0.app, this.this$0.jdField_a_of_type_Bdvu);
      return;
    }
    Message localMessage = this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(18);
    localMessage.obj = localDrawable;
    this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity.8
 * JD-Core Version:    0.7.0.1
 */