package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TimeCycleSplineSet$ProgressSet
  extends TimeCycleSplineSet
{
  boolean mNoMethod = false;
  
  public boolean setProperty(View paramView, float paramFloat, long paramLong, KeyCache paramKeyCache)
  {
    Object localObject;
    if ((paramView instanceof MotionLayout))
    {
      ((MotionLayout)paramView).setProgress(get(paramFloat, paramLong, paramView, paramKeyCache));
    }
    else
    {
      if (this.mNoMethod) {
        return false;
      }
      localObject = null;
    }
    try
    {
      Method localMethod = paramView.getClass().getMethod("setProgress", new Class[] { Float.TYPE });
      localObject = localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label66:
      break label66;
    }
    this.mNoMethod = true;
    if (localObject != null) {
      try
      {
        localObject.invoke(paramView, new Object[] { Float.valueOf(get(paramFloat, paramLong, paramView, paramKeyCache)) });
      }
      catch (InvocationTargetException paramView)
      {
        Log.e("SplineSet", "unable to setProgress", paramView);
      }
      catch (IllegalAccessException paramView)
      {
        Log.e("SplineSet", "unable to setProgress", paramView);
      }
    }
    return this.mContinue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.TimeCycleSplineSet.ProgressSet
 * JD-Core Version:    0.7.0.1
 */