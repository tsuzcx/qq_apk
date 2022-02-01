package com.tencent.luggage.wxa.pp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public class an
  implements View.OnTouchListener
{
  private static final int a = ;
  private final Handler b = new an.1(this, Looper.getMainLooper());
  private float c;
  private float d;
  private boolean e = false;
  
  private void a(View paramView)
  {
    paramView.setPressed(false);
    this.e = false;
    this.b.removeMessages(1);
    this.b.removeMessages(2);
  }
  
  private boolean c()
  {
    if (!this.e)
    {
      b();
      return true;
    }
    return false;
  }
  
  protected void a() {}
  
  protected void b() {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
          a(paramView);
          return true;
        }
        i = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        float f3 = -i;
        if ((f3 <= f1) && (f1 <= paramView.getWidth() + i) && (f3 <= f2) && (f2 <= paramView.getHeight() + i)) {
          return true;
        }
        this.e = true;
        return true;
      }
      if ((!this.e) && (this.b.hasMessages(1))) {
        a();
      }
      a(paramView);
      return true;
    }
    paramView.setPressed(true);
    paramView = this.b;
    paramView.sendMessageDelayed(Message.obtain(paramView, 1), a);
    this.c = paramMotionEvent.getX();
    this.d = paramMotionEvent.getY();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.an
 * JD-Core Version:    0.7.0.1
 */