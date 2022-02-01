package com.tencent.biz;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class PoiMapActivity$2
  implements View.OnTouchListener
{
  PoiMapActivity$2(PoiMapActivity paramPoiMapActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.a.b();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.2
 * JD-Core Version:    0.7.0.1
 */