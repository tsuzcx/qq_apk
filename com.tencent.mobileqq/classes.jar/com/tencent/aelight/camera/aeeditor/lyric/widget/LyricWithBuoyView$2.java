package com.tencent.aelight.camera.aeeditor.lyric.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.aelight.camera.log.AEQLog;

class LyricWithBuoyView$2
  implements View.OnTouchListener
{
  float jdField_a_of_type_Float = 0.0F;
  float b = 0.0F;
  
  LyricWithBuoyView$2(LyricWithBuoyView paramLyricWithBuoyView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) && (Math.abs(paramMotionEvent.getRawX() - this.jdField_a_of_type_Float) < 10.0F) && (Math.abs(paramMotionEvent.getRawY() - this.b) < 10.0F))
      {
        if (LyricWithBuoyView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricWithBuoyView) != null)
        {
          LyricWithBuoyView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricWithBuoyView).a();
          return true;
        }
        AEQLog.a("LyricWithBuoyView", "onClick() mOnLyricWithBuoyViewOperationListener == null.");
        return true;
      }
    }
    else
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.b = paramMotionEvent.getRawY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricWithBuoyView.2
 * JD-Core Version:    0.7.0.1
 */