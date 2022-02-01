package com.tencent.mobileqq.activity.aio.tim;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;

class TIMUserManager$3$1
  implements Runnable
{
  TIMUserManager$3$1(TIMUserManager.3 param3, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, StateListDrawable paramStateListDrawable) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    if (this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundDrawable(this.b);
      this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(-16777216);
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setBackgroundDrawable(this.c);
    this.this$0.jdField_a_of_type_ComTencentWidgetPatchedButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tim.TIMUserManager.3.1
 * JD-Core Version:    0.7.0.1
 */