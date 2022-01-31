package com.tencent.map.core.functions.animation;

import android.view.animation.Interpolator;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class GlEmergeAnimation
  extends GlAnimation
{
  private LatLng a = null;
  
  public GlEmergeAnimation(LatLng paramLatLng)
  {
    this.a = paramLatLng;
  }
  
  public LatLng getStartPoint()
  {
    return this.a;
  }
  
  protected void performAnimation(float paramFloat, Interpolator paramInterpolator)
  {
    paramFloat = paramInterpolator.getInterpolation(paramFloat);
    if (this.animationProperty != null) {
      this.animationProperty.setRatio(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GlEmergeAnimation
 * JD-Core Version:    0.7.0.1
 */