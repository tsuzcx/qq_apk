package com.tencent.av.ui.funchat.record;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class QavRecordButtonView$1
  implements View.OnTouchListener
{
  QavRecordButtonView$1(QavRecordButtonView paramQavRecordButtonView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QavRecordButtonView.a(this.a) != 1)
    {
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if ((i == 1) || (i == 3)) {
          paramView.setAlpha(1.0F);
        }
      }
      else {
        paramView.setAlpha(0.5F);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavRecordButtonView.1
 * JD-Core Version:    0.7.0.1
 */