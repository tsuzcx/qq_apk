package com.tencent.mobileqq.activity.aio.audiopanel;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.CheckBox;

class VoiceTextEditPanel$3
  implements Runnable
{
  VoiceTextEditPanel$3(VoiceTextEditPanel paramVoiceTextEditPanel, int paramInt, View paramView) {}
  
  public void run()
  {
    Rect localRect = new Rect();
    VoiceTextEditPanel.a(this.this$0).getHitRect(localRect);
    localRect.top -= this.jdField_a_of_type_Int;
    localRect.bottom += this.jdField_a_of_type_Int;
    localRect.left -= this.jdField_a_of_type_Int * 2;
    localRect.right += this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidViewView.setTouchDelegate(new TouchDelegate(localRect, VoiceTextEditPanel.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel.3
 * JD-Core Version:    0.7.0.1
 */