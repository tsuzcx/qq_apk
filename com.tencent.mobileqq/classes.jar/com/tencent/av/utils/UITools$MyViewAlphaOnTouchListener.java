package com.tencent.av.utils;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class UITools$MyViewAlphaOnTouchListener
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        UITools.a(paramView, 1.0F);
      }
    }
    else {
      UITools.a(paramView, 0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener
 * JD-Core Version:    0.7.0.1
 */