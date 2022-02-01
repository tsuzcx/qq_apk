package com.tencent.mobileqq.ar.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ARScanEntryView$2
  implements View.OnTouchListener
{
  ARScanEntryView$2(ARScanEntryView paramARScanEntryView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
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
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.2
 * JD-Core Version:    0.7.0.1
 */