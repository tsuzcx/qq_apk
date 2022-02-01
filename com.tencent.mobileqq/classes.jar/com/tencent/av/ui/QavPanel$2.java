package com.tencent.av.ui;

import android.graphics.drawable.ClipDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class QavPanel$2
  implements View.OnTouchListener
{
  QavPanel$2(QavPanel paramQavPanel) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        this.a.a.setAlpha(255);
      }
    }
    else {
      this.a.a.setAlpha(127);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel.2
 * JD-Core Version:    0.7.0.1
 */