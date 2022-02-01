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
    List localList = this.listAnimations;
    if (localList == null) {
      return;
    }
    localList.clear();
  }
  
  protected void performAnimation(float paramFloat, Interpolator paramInterpolator)
  {
    Object localObject = this.listAnimations;
    if (localObject == null) {
      return;
    }
    int j = ((List)localObject).size();
    if (j == 0) {
      return;
    }
    int i = 0;
    while (i < j)
    {
      localObject = (GlAnimation)this.listAnimations.get(i);
      if (localObject != null) {
        if (this.boShareInterpolator) {
          ((GlAnimation)localObject).performAnimation(paramFloat, paramInterpolator);
        } else {
          ((GlAnimation)localObject).performAnimation(paramFloat, ((GlAnimation)localObject).getInterpolator());
        }
      }
      i += 1;
    }
  }
  
  public void setAnimationProperty(GlAnimation.SetAnimatePropertyListener paramSetAnimatePropertyListener)
  {
    super.setAnimationProperty(paramSetAnimatePropertyListener);
    Object localObject = this.listAnimations;
    if (localObject == null) {
      return;
    }
    int j = ((List)localObject).size();
    if (j == 0) {
      return;
    }
    int i = 0;
    while (i < j)
    {
      localObject = (GlAnimation)this.listAnimations.get(i);
      if (localObject != null) {
        ((GlAnimation)localObject).setAnimationProperty(paramSetAnimatePropertyListener);
      }
      i += 1;
    }
  }
  
  public boolean startAnimation(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    boolean bool2 = super.startAnimation(paramGeoPoint1, paramGeoPoint2);
    if (!bool2) {
      return false;
    }
    Object localObject = this.listAnimations;
    if (localObject == null) {
      return false;
    }
    int j = ((List)localObject).size();
    if (j == 0) {
      return false;
    }
    int i = 0;
    while (i < j)
    {
      localObject = (GlAnimation)this.listAnimations.get(i);
      boolean bool1 = bool2;
      if (localObject != null) {
        if ((bool2) && (((GlAnimation)localObject).startAnimation(paramGeoPoint1, paramGeoPoint2))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
      }
      i += 1;
      bool2 = bool1;
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GlAnimationSet
 * JD-Core Version:    0.7.0.1
 */