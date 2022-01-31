package com.tencent.map.sdk.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ZoomControls;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView;

final class lu$1
  extends Handler
{
  lu$1(lu paramlu, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject;
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      paramMessage = (hj)paramMessage.obj;
      if (paramMessage.a != 0) {
        break label86;
      }
      if (this.a.c != null)
      {
        localObject = this.a.c;
        boolean bool1 = paramMessage.b;
        boolean bool2 = paramMessage.c;
        if (((js)localObject).a != null)
        {
          ((js)localObject).a.setIsZoomInEnabled(bool1);
          ((js)localObject).a.setIsZoomOutEnabled(bool2);
        }
      }
    }
    label86:
    int i;
    int m;
    int j;
    label202:
    do
    {
      do
      {
        do
        {
          return;
          if (paramMessage.a != 1) {
            break;
          }
        } while (this.a.d == null);
        localObject = this.a.d;
        i = paramMessage.d;
        double d = paramMessage.e;
        ((jr)localObject).k = i;
        ((jr)localObject).l = d;
        m = (int)Math.log10(((jr)localObject).q * ((jr)localObject).l);
        i = (int)(jr.h[0] * Math.pow(10.0D, m));
        j = (int)(i / ((jr)localObject).l);
        if ((j > 0) && (!Double.isNaN(((jr)localObject).l))) {
          break label518;
        }
        ((jr)localObject).b();
        paramMessage = this.a.d;
      } while (!paramMessage.n);
      if (paramMessage.m != null) {
        paramMessage.m.postInvalidate();
      }
    } while (paramMessage.o == null);
    if (paramMessage.o.getVisibility() != 0)
    {
      paramMessage.o.setVisibility(0);
      return;
    }
    for (;;)
    {
      int k;
      if (j < ((jr)localObject).q)
      {
        k += 1;
        i = jr.h.length;
        i = (int)(jr.h[(k % i)] * Math.pow(10.0D, k / jr.h.length + m));
        j = (int)(i / ((jr)localObject).l);
      }
      else
      {
        if (i >= 1000) {
          i /= 1000;
        }
        for (paramMessage = "km";; paramMessage = "m")
        {
          ((jr)localObject).i = (i + paramMessage);
          ((jr)localObject).j = j;
          ((jr)localObject).d.setText(((jr)localObject).i);
          break label202;
          paramMessage.o.clearAnimation();
          return;
          if ((paramMessage.a != 3) || (fz.g != 1) || (TextUtils.equals("original", "wechat")) || (this.a.a == null)) {
            break;
          }
          if (this.a.e == null)
          {
            this.a.e = new hu(this.a.a.getContext().getApplicationContext());
            this.a.e.a = this.a.f;
          }
          this.a.e.a(this.a.a);
          return;
        }
        label518:
        k = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.lu.1
 * JD-Core Version:    0.7.0.1
 */