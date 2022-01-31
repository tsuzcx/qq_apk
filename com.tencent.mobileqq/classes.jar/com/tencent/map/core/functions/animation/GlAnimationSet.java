package com.tencent.map.core.functions.animation;

import android.view.animation.Interpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class GlAnimationSet
  extends GlAnimation
{
  protected boolean boShareInterpolator = true;
  protected List<GlAnimation> listAnimations = null;
  
  public GlAnimationSet(boolean paramBoolean)
  {
    this.boShareInterpolator = paramBoolean;
    if (this.listAnimations == null) {
      this.listAnimations = new ArrayList();
    }
  }
  
  public void addAnimation(GlAnimation paramGlAnimation)
  {
    if (paramGlAnimation == null) {
      return;
    }
    this.listAnimations.add(paramGlAnimation);
  }
  
  public void cleanAnimation()
  {
    if (this.listAnimations == null) {
      return;
    }
    this.listAnimations.clear();
  }
  
  protected void performAnimation(float paramFloat, Interpolator paramInterpolator)
  {
    if (this.listAnimations == null) {}
    int j;
    do
    {
      return;
      j = this.listAnimations.size();
    } while (j == 0);
    int i = 0;
    label26:
    GlAnimation localGlAnimation;
    if (i < j)
    {
      localGlAnimation = (GlAnimation)this.listAnimations.get(i);
      if (localGlAnimation != null)
      {
        if (!this.boShareInterpolator) {
          break label73;
        }
        localGlAnimation.performAnimation(paramFloat, paramInterpolator);
      }
    }
    for (;;)
    {
      i += 1;
      break label26;
      break;
      label73:
      localGlAnimation.performAnimation(paramFloat, localGlAnimation.getInterpolator());
    }
  }
  
  public void setAnimationProperty(GlAnimation.SetAnimatePropertyListener paramSetAnimatePropertyListener)
  {
    super.setAnimationProperty(paramSetAnimatePropertyListener);
    if (this.listAnimations == null) {}
    for (;;)
    {
      return;
      int j = this.listAnimations.size();
      if (j != 0)
      {
        int i = 0;
        while (i < j)
        {
          GlAnimation localGlAnimation = (GlAnimation)this.listAnimations.get(i);
          if (localGlAnimation != null) {
            localGlAnimation.setAnimationProperty(paramSetAnimatePropertyListener);
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean startAnimation(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    boolean bool = super.startAnimation(paramGeoPoint1, paramGeoPoint2);
    if (!bool) {}
    int j;
    do
    {
      do
      {
        return false;
      } while (this.listAnimations == null);
      j = this.listAnimations.size();
    } while (j == 0);
    int i = 0;
    if (i < j)
    {
      GlAnimation localGlAnimation = (GlAnimation)this.listAnimations.get(i);
      if (localGlAnimation == null) {
        break label100;
      }
      if ((bool) && (localGlAnimation.startAnimation(paramGeoPoint1, paramGeoPoint2))) {
        bool = true;
      }
    }
    label100:
    for (;;)
    {
      i += 1;
      break;
      bool = false;
      continue;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GlAnimationSet
 * JD-Core Version:    0.7.0.1
 */