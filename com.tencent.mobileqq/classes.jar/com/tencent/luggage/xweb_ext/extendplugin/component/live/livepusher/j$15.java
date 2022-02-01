package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import com.tencent.luggage.wxa.qz.o;

class j$15
  implements ScaleGestureDetector.OnScaleGestureListener
{
  j$15(j paramj) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    int k = j.l(this.a).b();
    if (k > 0)
    {
      float f2 = paramScaleGestureDetector.getScaleFactor();
      float f1;
      if (f2 > 1.0F)
      {
        f2 = 0.2F / k * (k - j.p(this.a)) + 1.0F;
        f1 = f2;
        if (f2 <= 1.1F) {
          f1 = 1.1F;
        }
      }
      else
      {
        f1 = f2;
        if (f2 < 1.0F)
        {
          f2 = 1.0F - 0.2F / k * j.p(this.a);
          f1 = f2;
          if (f2 >= 0.9F) {
            f1 = 0.9F;
          }
        }
      }
      int j = Math.round(j.p(this.a) * f1);
      int i = j;
      if (j == j.p(this.a)) {
        if (f1 > 1.0F)
        {
          i = j + 1;
        }
        else
        {
          i = j;
          if (f1 < 1.0F) {
            i = j - 1;
          }
        }
      }
      j = i;
      if (i >= k) {
        j = k;
      }
      i = j;
      if (j <= 1) {
        i = 1;
      }
      if (f1 > 1.0F)
      {
        j = i;
        if (i < j.p(this.a)) {
          j = j.p(this.a);
        }
      }
      else
      {
        j = i;
        if (f1 < 1.0F)
        {
          j = i;
          if (i > j.p(this.a)) {
            j = j.p(this.a);
          }
        }
      }
      j.d(this.a, j);
      if (j.l(this.a) != null)
      {
        o.d(j.g(this.a), "onScale, maxZoom:%s, current scale:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j.p(this.a)) });
        j.l(this.a).b(j.p(this.a));
      }
    }
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j.15
 * JD-Core Version:    0.7.0.1
 */