package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;

class EdgeEffectCompat$BaseEdgeEffectImpl
  implements EdgeEffectCompat.EdgeEffectImpl
{
  public boolean draw(Object paramObject, Canvas paramCanvas)
  {
    return false;
  }
  
  public void finish(Object paramObject) {}
  
  public boolean isFinished(Object paramObject)
  {
    return true;
  }
  
  public Object newEdgeEffect(Context paramContext)
  {
    return null;
  }
  
  public boolean onAbsorb(Object paramObject, int paramInt)
  {
    return false;
  }
  
  public boolean onPull(Object paramObject, float paramFloat)
  {
    return false;
  }
  
  public boolean onPull(Object paramObject, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onRelease(Object paramObject)
  {
    return false;
  }
  
  public void setSize(Object paramObject, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.widget.EdgeEffectCompat.BaseEdgeEffectImpl
 * JD-Core Version:    0.7.0.1
 */