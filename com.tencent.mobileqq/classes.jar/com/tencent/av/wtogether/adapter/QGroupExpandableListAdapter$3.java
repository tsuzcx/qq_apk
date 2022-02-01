package com.tencent.av.wtogether.adapter;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class QGroupExpandableListAdapter$3
  implements View.OnTouchListener
{
  QGroupExpandableListAdapter$3(QGroupExpandableListAdapter paramQGroupExpandableListAdapter, TextView paramTextView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 3) {
          this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        }
      }
      else {
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      }
    }
    else {
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.QGroupExpandableListAdapter.3
 * JD-Core Version:    0.7.0.1
 */