package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class EditTextDialog$7
  implements View.OnTouchListener
{
  private final int jdField_a_of_type_Int = 10;
  private boolean jdField_a_of_type_Boolean = false;
  private int b;
  
  EditTextDialog$7(EditTextDialog paramEditTextDialog) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX();
    float f = paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
        if (Math.abs(f - this.b) > 10.0F)
        {
          this.jdField_a_of_type_Boolean = true;
          return false;
        }
      }
      else
      {
        return this.jdField_a_of_type_Boolean;
      }
    }
    else
    {
      this.b = ((int)f);
      this.jdField_a_of_type_Boolean = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.7
 * JD-Core Version:    0.7.0.1
 */