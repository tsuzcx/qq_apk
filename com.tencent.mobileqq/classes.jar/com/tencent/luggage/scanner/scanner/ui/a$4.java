package com.tencent.luggage.scanner.scanner.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.luggage.wxa.qz.o;

class a$4
  implements View.OnTouchListener
{
  private float b;
  private float c = 400.0F;
  private boolean d = false;
  
  a$4(a parama) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    o.e("Luggage.ScanUIRectView", "pointIndex:%d, action: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 5)
          {
            if (i != 6) {
              return true;
            }
            o.e("Luggage.ScanUIRectView", "up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramMotionEvent.getX(j)), Float.valueOf(paramMotionEvent.getY(j)) });
            if (paramMotionEvent.getPointerCount() == 2)
            {
              this.b = ((float)(Math.pow(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), 2.0D) + Math.pow(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), 2.0D)));
              if (this.d)
              {
                this.d = false;
                return true;
              }
            }
          }
          else
          {
            o.e("Luggage.ScanUIRectView", "down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramMotionEvent.getX(j)), Float.valueOf(paramMotionEvent.getY(j)) });
            if (paramMotionEvent.getPointerCount() == 2) {
              this.b = ((float)(Math.pow(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), 2.0D) + Math.pow(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), 2.0D)));
            }
            this.d = false;
            return true;
          }
        }
        else if (paramMotionEvent.getPointerCount() == 2)
        {
          o.e("Luggage.ScanUIRectView", "move,pointer:0,x:%f,y:%f", new Object[] { Float.valueOf(paramMotionEvent.getX(0)), Float.valueOf(paramMotionEvent.getY(0)) });
          o.e("Luggage.ScanUIRectView", "move,pointer:1,x:%f,y:%f", new Object[] { Float.valueOf(paramMotionEvent.getX(1)), Float.valueOf(paramMotionEvent.getY(1)) });
          float f = (float)(Math.pow(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), 2.0D) + Math.pow(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), 2.0D));
          o.e("Luggage.ScanUIRectView", "distance:%f,lastDistance:%f,min move:%f", new Object[] { Float.valueOf(f), Float.valueOf(this.b), Float.valueOf(this.c) });
          if (Math.abs(f - this.b) > this.c)
          {
            if (a.h(this.a)) {
              a.e(this.a, false);
            }
            if (f - this.b > 0.0F)
            {
              ((com.tencent.luggage.scanner.camera.a)this.a.b).c(2);
              this.d = true;
            }
            else
            {
              ((com.tencent.luggage.scanner.camera.a)this.a.b).c(3);
              this.d = true;
            }
            this.b = f;
            return true;
          }
        }
      }
      else
      {
        o.e("Luggage.ScanUIRectView", "last up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()) });
        if (paramMotionEvent.getPointerCount() == 2)
        {
          this.b = ((float)(Math.pow(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), 2.0D) + Math.pow(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), 2.0D)));
          return true;
        }
      }
    }
    else
    {
      o.e("Luggage.ScanUIRectView", "first down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()) });
      this.d = false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.a.4
 * JD-Core Version:    0.7.0.1
 */