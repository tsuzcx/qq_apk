package com.tencent.biz.pubaccount.util.monitor;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

class FPSSuspendedBall$SuspendedBallTouchListener
  implements View.OnTouchListener
{
  private int b;
  private int c;
  private float d;
  private float e;
  
  private FPSSuspendedBall$SuspendedBallTouchListener(FPSSuspendedBall paramFPSSuspendedBall) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i == 2))
      {
        FPSSuspendedBall.a(this.a).x = (this.b + (int)(this.d - paramMotionEvent.getRawX()));
        FPSSuspendedBall.a(this.a).y = (this.c + (int)(paramMotionEvent.getRawY() - this.e));
        FPSSuspendedBall.b(this.a).updateViewLayout(paramView, FPSSuspendedBall.a(this.a));
      }
    }
    else
    {
      this.b = FPSSuspendedBall.a(this.a).x;
      this.c = FPSSuspendedBall.a(this.a).y;
      this.d = paramMotionEvent.getRawX();
      this.e = paramMotionEvent.getRawY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.monitor.FPSSuspendedBall.SuspendedBallTouchListener
 * JD-Core Version:    0.7.0.1
 */