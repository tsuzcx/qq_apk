package com.dataline.activities;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

class LiteActivity$9
  implements View.OnTouchListener
{
  LiteActivity$9(LiteActivity paramLiteActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      String str = LiteActivity.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ontouch--fcc----: ");
      localStringBuilder.append(paramMotionEvent.getAction());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.a.q();
    LiteActivity.a(this.a, false);
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.postDelayed(new LiteActivity.9.1(this), 200L);
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.onTouch(paramView, paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.9
 * JD-Core Version:    0.7.0.1
 */