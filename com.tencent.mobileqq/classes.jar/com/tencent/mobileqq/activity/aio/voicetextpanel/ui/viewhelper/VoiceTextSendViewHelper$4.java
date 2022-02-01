package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import aiym;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.CheckBox;

public class VoiceTextSendViewHelper$4
  implements Runnable
{
  public VoiceTextSendViewHelper$4(aiym paramaiym, int paramInt, View paramView) {}
  
  public void run()
  {
    Rect localRect = new Rect();
    aiym.a(this.this$0).getHitRect(localRect);
    localRect.top -= this.jdField_a_of_type_Int;
    localRect.bottom += this.jdField_a_of_type_Int;
    localRect.left -= this.jdField_a_of_type_Int * 2;
    localRect.right += this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidViewView.setTouchDelegate(new TouchDelegate(localRect, aiym.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSendViewHelper.4
 * JD-Core Version:    0.7.0.1
 */