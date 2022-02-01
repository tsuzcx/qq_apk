package com.tencent.aelight.camera.aioeditor.capture.text;

import android.view.View;

class DynamicTextItem$1
  implements Runnable
{
  DynamicTextItem$1(DynamicTextItem paramDynamicTextItem, View paramView) {}
  
  public void run()
  {
    DynamicTextItem.a(this.this$0).b = Boolean.valueOf(((Boolean)DynamicTextItem.a(this.this$0).b).booleanValue() ^ true);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.1
 * JD-Core Version:    0.7.0.1
 */