package androidx.constraintlayout.motion.widget;

import android.view.MotionEvent;
import android.view.VelocityTracker;

class MotionLayout$MyTracker
  implements MotionLayout.MotionTracker
{
  private static MyTracker me = new MyTracker();
  VelocityTracker tracker;
  
  public static MyTracker obtain()
  {
    me.tracker = VelocityTracker.obtain();
    return me;
  }
  
  public void addMovement(MotionEvent paramMotionEvent)
  {
    VelocityTracker localVelocityTracker = this.tracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.addMovement(paramMotionEvent);
    }
  }
  
  public void clear()
  {
    VelocityTracker localVelocityTracker = this.tracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
  }
  
  public void computeCurrentVelocity(int paramInt)
  {
    VelocityTracker localVelocityTracker = this.tracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.computeCurrentVelocity(paramInt);
    }
  }
  
  public void computeCurrentVelocity(int paramInt, float paramFloat)
  {
    VelocityTracker localVelocityTracker = this.tracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.computeCurrentVelocity(paramInt, paramFloat);
    }
  }
  
  public float getXVelocity()
  {
    VelocityTracker localVelocityTracker = this.tracker;
    if (localVelocityTracker != null) {
      return localVelocityTracker.getXVelocity();
    }
    return 0.0F;
  }
  
  public float getXVelocity(int paramInt)
  {
    VelocityTracker localVelocityTracker = this.tracker;
    if (localVelocityTracker != null) {
      return localVelocityTracker.getXVelocity(paramInt);
    }
    return 0.0F;
  }
  
  public float getYVelocity()
  {
    VelocityTracker localVelocityTracker = this.tracker;
    if (localVelocityTracker != null) {
      return localVelocityTracker.getYVelocity();
    }
    return 0.0F;
  }
  
  public float getYVelocity(int paramInt)
  {
    if (this.tracker != null) {
      return getYVelocity(paramInt);
    }
    return 0.0F;
  }
  
  public void recycle()
  {
    VelocityTracker localVelocityTracker = this.tracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.tracker = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionLayout.MyTracker
 * JD-Core Version:    0.7.0.1
 */