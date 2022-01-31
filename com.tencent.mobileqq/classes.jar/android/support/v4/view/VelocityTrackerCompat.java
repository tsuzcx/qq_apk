package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public final class VelocityTrackerCompat
{
  static final VelocityTrackerCompat.VelocityTrackerVersionImpl IMPL = new VelocityTrackerCompat.BaseVelocityTrackerVersionImpl();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      IMPL = new VelocityTrackerCompat.HoneycombVelocityTrackerVersionImpl();
      return;
    }
  }
  
  public static float getXVelocity(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return IMPL.getXVelocity(paramVelocityTracker, paramInt);
  }
  
  public static float getYVelocity(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return IMPL.getYVelocity(paramVelocityTracker, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.VelocityTrackerCompat
 * JD-Core Version:    0.7.0.1
 */