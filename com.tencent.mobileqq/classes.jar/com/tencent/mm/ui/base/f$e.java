package com.tencent.mm.ui.base;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class f$e
  implements View.OnTouchListener
{
  private f$e(f paramf) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if ((i == 0) && (f.b(this.a) != null) && (f.b(this.a).isShowing()) && (j >= 0) && (j < f.b(this.a).getWidth()) && (k >= 0) && (k < f.b(this.a).getHeight())) {
      f.d(this.a).postDelayed(f.c(this.a), 250L);
    } else if (i == 1) {
      f.d(this.a).removeCallbacks(f.c(this.a));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.f.e
 * JD-Core Version:    0.7.0.1
 */