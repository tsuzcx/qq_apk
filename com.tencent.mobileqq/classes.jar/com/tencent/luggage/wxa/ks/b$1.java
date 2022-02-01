package com.tencent.luggage.wxa.ks;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.mn.e;

class b$1
  implements View.OnTouchListener
{
  b$1(b paramb) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 0) {
      e.a((ViewGroup)paramView, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ks.b.1
 * JD-Core Version:    0.7.0.1
 */