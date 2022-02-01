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
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      paramMessage = (hj)paramMessage.obj;
      Object localObject;
      if (paramMessage.a == 0)
      {
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
      else if (paramMessage.a == 1)
      {
        if (this.a.d != null)
        {
          localObject = this.a.d;
          int i = paramMessage.d;
          double d1 = paramMessage.e;
          ((jr)localObject).k = i;
          ((jr)localObject).l = d1;
          d1 = ((jr)localObject).q;
          double d2 = ((jr)localObject).l;
          Double.isNaN(d1);
          int m = (int)Math.log10(d1 * d2);
          d1 = jr.h[0];
          d2 = Math.pow(10.0D, m);
          Double.isNaN(d1);
          i = (int)(d1 * d2);
          d1 = i;
          d2 = ((jr)localObject).l;
          Double.isNaN(d1);
          int j = (int)(d1 / d2);
          if ((j > 0) && (!Double.isNaN(((jr)localObject).l)))
          {
            int k = 0;
            while (j < ((jr)localObject).q)
            {
              k += 1;
              i = jr.h.length;
              d1 = jr.h[(k % i)];
              d2 = Math.pow(10.0D, k / jr.h.length + m);
              Double.isNaN(d1);
              i = (int)(d1 * d2);
              d1 = i;
              d2 = ((jr)localObject).l;
              Double.isNaN(d1);
              j = (int)(d1 / d2);
            }
            if (i >= 1000)
            {
              i /= 1000;
              paramMessage = "km";
            }
            else
            {
              paramMessage = "m";
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(i);
            localStringBuilder.append(paramMessage);
            ((jr)localObject).i = localStringBuilder.toString();
            ((jr)localObject).j = j;
            ((jr)localObject).d.setText(((jr)localObject).i);
          }
          ((jr)localObject).b();
          paramMessage = this.a.d;
          if (paramMessage.n)
          {
            if (paramMessage.m != null) {
              paramMessage.m.postInvalidate();
            }
            if (paramMessage.o != null)
            {
              if (paramMessage.o.getVisibility() != 0)
              {
                paramMessage.o.setVisibility(0);
                return;
              }
              paramMessage.o.clearAnimation();
            }
          }
        }
      }
      else if ((paramMessage.a == 3) && (fz.g == 1))
      {
        if (TextUtils.equals("original", "wechat")) {
          return;
        }
        if (this.a.a == null) {
          return;
        }
        if (this.a.e == null)
        {
          paramMessage = this.a;
          paramMessage.e = new hu(paramMessage.a.getContext().getApplicationContext());
          this.a.e.a = this.a.f;
        }
        this.a.e.a(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.lu.1
 * JD-Core Version:    0.7.0.1
 */