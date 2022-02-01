package com.tencent.luggage.wxa.pp;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.luggage.wxa.mn.e;

class al$2
  implements View.OnTouchListener
{
  al$2(al paramal, g paramg, ai paramai) {}
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 0) {
      e.a(this.a, paramMotionEvent);
    }
    return this.b.a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.al.2
 * JD-Core Version:    0.7.0.1
 */