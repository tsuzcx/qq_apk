package com.tencent.av.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MultiVideoCtrlLayerUIBase$5
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      paramView.setAlpha(0.5F);
      this.a.setAlpha(0.5F);
    }
    else if (paramMotionEvent.getAction() == 1)
    {
      paramView.setAlpha(1.0F);
      this.a.setAlpha(1.0F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.5
 * JD-Core Version:    0.7.0.1
 */