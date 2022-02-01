package com.tencent.aelight.camera.aioeditor.capture.text;

import android.view.View;

class DynamicTextItem$2
  implements Runnable
{
  DynamicTextItem$2(DynamicTextItem paramDynamicTextItem, boolean paramBoolean, View paramView, Runnable paramRunnable) {}
  
  public void run()
  {
    if (((Boolean)DynamicTextItem.a(this.this$0).b).booleanValue() != this.jdField_a_of_type_Boolean)
    {
      DynamicTextItem.a(this.this$0).b = Boolean.valueOf(((Boolean)DynamicTextItem.a(this.this$0).b).booleanValue() ^ true);
      this.jdField_a_of_type_AndroidViewView.invalidate();
    }
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null) {
      localRunnable.run();
    }
    DynamicTextItem.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.2
 * JD-Core Version:    0.7.0.1
 */