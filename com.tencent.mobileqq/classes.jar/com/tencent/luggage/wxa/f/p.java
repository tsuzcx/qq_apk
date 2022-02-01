package com.tencent.luggage.wxa.f;

import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class p
  implements View.OnTouchListener
{
  private long a = -1L;
  private float b = -1.0F;
  private int c = 0;
  private p.a d;
  
  private float a(MotionEvent paramMotionEvent)
  {
    try
    {
      if (this.c >= 2)
      {
        float f3 = paramMotionEvent.getX(0);
        float f1 = paramMotionEvent.getY(0);
        float f4 = paramMotionEvent.getX(1);
        float f2 = paramMotionEvent.getY(1);
        f3 = Math.abs(f3 - f4);
        f1 = Math.abs(f1 - f2);
        return f3 + f1;
      }
    }
    catch (Exception paramMotionEvent)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pointerDistance error: ");
      localStringBuilder.append(paramMotionEvent.getMessage());
      Log.e("MicroMsg.SRVTListener", localStringBuilder.toString());
    }
    return 0.0F;
  }
  
  public void a(p.a parama)
  {
    this.d = parama;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
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
            Log.d("MicroMsg.SRVTListener", "ACTION_POINTER_UP");
            this.c -= 1;
            return true;
          }
          Log.d("MicroMsg.SRVTListener", "ACTION_POINTER_DOWN");
          this.c += 1;
          return true;
        }
        if (this.c >= 2)
        {
          float f1 = a(paramMotionEvent);
          paramView = new StringBuilder();
          paramView.append("distance: ");
          paramView.append(f1);
          Log.v("MicroMsg.SRVTListener", paramView.toString());
          if (f1 > 0.0F)
          {
            float f2 = this.b;
            if (f2 <= 0.0F)
            {
              this.b = f1;
              return true;
            }
            if (Math.abs(f1 - f2) > 15.0F)
            {
              if (f1 > this.b)
              {
                Log.d("MicroMsg.SRVTListener", "zoom out");
                paramView = this.d;
                if (paramView != null) {
                  paramView.g();
                }
              }
              else
              {
                Log.d("MicroMsg.SRVTListener", "zoom in");
                paramView = this.d;
                if (paramView != null) {
                  paramView.h();
                }
              }
              this.b = f1;
              return true;
            }
          }
        }
      }
      else
      {
        Log.d("MicroMsg.SRVTListener", "ACTION_UP");
        this.b = -1.0F;
        this.c = 0;
        return true;
      }
    }
    else
    {
      Log.d("MicroMsg.SRVTListener", "ACTION_DOWN");
      if ((this.a > 0L) && (SystemClock.elapsedRealtime() - this.a < 400L))
      {
        paramView = this.d;
        if (paramView != null) {
          paramView.f();
        }
      }
      else
      {
        paramView = this.d;
        if (paramView != null) {
          paramView.a(paramMotionEvent.getX(), paramMotionEvent.getY());
        }
      }
      this.a = SystemClock.elapsedRealtime();
      this.b = -1.0F;
      this.c += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.p
 * JD-Core Version:    0.7.0.1
 */