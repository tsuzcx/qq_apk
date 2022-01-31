package com.tencent.map.core.functions.animation;

import android.view.animation.Interpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;

public class GlTranslateAnimation
  extends GlAnimation
{
  private GeoPoint a = null;
  private GeoPoint b = null;
  private boolean c = false;
  
  public GlTranslateAnimation(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint != null)
    {
      this.b = new GeoPoint(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
      this.c = true;
    }
  }
  
  protected void performAnimation(float paramFloat, Interpolator paramInterpolator)
  {
    if ((this.b == null) || (this.a == null)) {}
    int m;
    int n;
    int j;
    int i;
    do
    {
      return;
      m = this.b.getLatitudeE6();
      n = this.a.getLatitudeE6();
      j = this.b.getLongitudeE6();
      int k = this.a.getLongitudeE6();
      paramFloat = paramInterpolator.getInterpolation(paramFloat);
      i = this.a.getLatitudeE6();
      m = (int)((m - n) * paramFloat);
      n = this.a.getLongitudeE6();
      j = (int)((j - k) * paramFloat);
    } while (this.animationProperty == null);
    this.animationProperty.setPosition(m + i, j + n);
  }
  
  public boolean startAnimation(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    if (!super.startAnimation(null, null)) {
      return false;
    }
    if (paramGeoPoint1 != null) {
      this.a = new GeoPoint(paramGeoPoint1.getLatitudeE6(), paramGeoPoint1.getLongitudeE6());
    }
    if ((!this.c) && (paramGeoPoint2 != null)) {
      this.b = new GeoPoint(paramGeoPoint2.getLatitudeE6(), paramGeoPoint2.getLongitudeE6());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GlTranslateAnimation
 * JD-Core Version:    0.7.0.1
 */