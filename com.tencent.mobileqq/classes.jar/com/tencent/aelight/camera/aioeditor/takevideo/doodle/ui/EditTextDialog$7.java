package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class EditTextDialog$7
  implements View.OnTouchListener
{
  private final int b = 10;
  private int c;
  private boolean d = false;
  
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
        if (Math.abs(f - this.c) > 10.0F)
        {
          this.d = true;
          return false;
        }
      }
      else
      {
        return this.d;
      }
    }
    else
    {
      this.c = ((int)f);
      this.d = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.7
 * JD-Core Version:    0.7.0.1
 */