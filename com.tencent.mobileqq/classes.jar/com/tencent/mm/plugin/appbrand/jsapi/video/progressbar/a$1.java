package com.tencent.mm.plugin.appbrand.jsapi.video.progressbar;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.wxa.ma.e.d;
import com.tencent.luggage.wxa.qz.o;

class a$1
  implements View.OnTouchListener
{
  a$1(a parama) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      o.d("MicroMsg.AdVideoPlayerLoadingBar", "ontouch down");
      paramView = this.a;
      paramView.k = false;
      paramView.l = paramMotionEvent.getX();
      if (this.a.a != null)
      {
        this.a.a.a();
        return true;
      }
    }
    else
    {
      int i;
      if (paramMotionEvent.getAction() == 2)
      {
        float f = paramMotionEvent.getX();
        paramView = (FrameLayout.LayoutParams)this.a.e.getLayoutParams();
        i = paramView.leftMargin;
        int j = (int)(f - this.a.l);
        paramView.leftMargin = a.a(this.a, i + j);
        this.a.e.setLayoutParams(paramView);
        i = this.a.getCurrentTimeByBarPoint();
        if (this.a.i > 0)
        {
          paramView = (FrameLayout.LayoutParams)this.a.c.getLayoutParams();
          double d1 = i;
          Double.isNaN(d1);
          double d2 = this.a.i;
          Double.isNaN(d2);
          d1 = d1 * 1.0D / d2;
          d2 = this.a.getBarLen();
          Double.isNaN(d2);
          paramView.width = ((int)(d1 * d2));
          this.a.c.setLayoutParams(paramView);
        }
        paramView = this.a.g;
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append(this.a.c(i / 60));
        paramMotionEvent.append(":");
        paramMotionEvent.append(this.a.c(i % 60));
        paramView.setText(paramMotionEvent.toString());
        this.a.k = true;
        return true;
      }
      if (this.a.k)
      {
        i = this.a.getCurrentTimeByBarPoint();
        if (this.a.a != null)
        {
          paramView = new StringBuilder();
          paramView.append("current time : ");
          paramView.append(i);
          o.d("MicroMsg.AdVideoPlayerLoadingBar", paramView.toString());
          this.a.a.a(i);
        }
        this.a.k = false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.a.1
 * JD-Core Version:    0.7.0.1
 */