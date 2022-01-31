package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;

class ScrollerCompat$ScrollerCompatImplGingerbread
  implements ScrollerCompat.ScrollerCompatImpl
{
  public void abortAnimation(Object paramObject)
  {
    ScrollerCompatGingerbread.abortAnimation(paramObject);
  }
  
  public boolean computeScrollOffset(Object paramObject)
  {
    return ScrollerCompatGingerbread.computeScrollOffset(paramObject);
  }
  
  public Object createScroller(Context paramContext, Interpolator paramInterpolator)
  {
    return ScrollerCompatGingerbread.createScroller(paramContext, paramInterpolator);
  }
  
  public void fling(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    ScrollerCompatGingerbread.fling(paramObject, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public void fling(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    ScrollerCompatGingerbread.fling(paramObject, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
  }
  
  public float getCurrVelocity(Object paramObject)
  {
    return 0.0F;
  }
  
  public int getCurrX(Object paramObject)
  {
    return ScrollerCompatGingerbread.getCurrX(paramObject);
  }
  
  public int getCurrY(Object paramObject)
  {
    return ScrollerCompatGingerbread.getCurrY(paramObject);
  }
  
  public int getFinalX(Object paramObject)
  {
    return ScrollerCompatGingerbread.getFinalX(paramObject);
  }
  
  public int getFinalY(Object paramObject)
  {
    return ScrollerCompatGingerbread.getFinalY(paramObject);
  }
  
  public boolean isFinished(Object paramObject)
  {
    return ScrollerCompatGingerbread.isFinished(paramObject);
  }
  
  public boolean isOverScrolled(Object paramObject)
  {
    return ScrollerCompatGingerbread.isOverScrolled(paramObject);
  }
  
  public void notifyHorizontalEdgeReached(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    ScrollerCompatGingerbread.notifyHorizontalEdgeReached(paramObject, paramInt1, paramInt2, paramInt3);
  }
  
  public void notifyVerticalEdgeReached(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    ScrollerCompatGingerbread.notifyVerticalEdgeReached(paramObject, paramInt1, paramInt2, paramInt3);
  }
  
  public void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ScrollerCompatGingerbread.startScroll(paramObject, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ScrollerCompatGingerbread.startScroll(paramObject, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.widget.ScrollerCompat.ScrollerCompatImplGingerbread
 * JD-Core Version:    0.7.0.1
 */