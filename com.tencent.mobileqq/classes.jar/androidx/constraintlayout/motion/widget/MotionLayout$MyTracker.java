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
    this.tracker.clear();
  }
  
  public void computeCurrentVelocity(int paramInt)
  {
    this.tracker.computeCurrentVelocity(paramInt);
  }
  
  public void computeCurrentVelocity(int paramInt, float paramFloat)
  {
    this.tracker.computeCurrentVelocity(paramInt, paramFloat);
  }
  
  public float getXVelocity()
  {
    return this.tracker.getXVelocity();
  }
  
  public float getXVelocity(int paramInt)
  {
    return this.tracker.getXVelocity(paramInt);
  }
  
  public float getYVelocity()
  {
    return this.tracker.getYVelocity();
  }
  
  public float getYVelocity(int paramInt)
  {
    return getYVelocity(paramInt);
  }
  
  public void recycle()
  {
    this.tracker.recycle();
    this.tracker = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionLayout.MyTracker
 * JD-Core Version:    0.7.0.1
 */