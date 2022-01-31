package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;

abstract interface ScrollerCompat$ScrollerCompatImpl
{
  public abstract void abortAnimation(Object paramObject);
  
  public abstract boolean computeScrollOffset(Object paramObject);
  
  public abstract Object createScroller(Context paramContext, Interpolator paramInterpolator);
  
  public abstract void fling(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  public abstract void fling(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
  
  public abstract float getCurrVelocity(Object paramObject);
  
  public abstract int getCurrX(Object paramObject);
  
  public abstract int getCurrY(Object paramObject);
  
  public abstract int getFinalX(Object paramObject);
  
  public abstract int getFinalY(Object paramObject);
  
  public abstract boolean isFinished(Object paramObject);
  
  public abstract boolean isOverScrolled(Object paramObject);
  
  public abstract void notifyHorizontalEdgeReached(Object paramObject, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void notifyVerticalEdgeReached(Object paramObject, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
 * JD-Core Version:    0.7.0.1
 */