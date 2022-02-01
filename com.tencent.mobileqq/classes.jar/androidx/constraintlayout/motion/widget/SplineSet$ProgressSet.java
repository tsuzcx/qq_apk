package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class SplineSet$ProgressSet
  extends SplineSet
{
  boolean mNoMethod = false;
  
  public void setProperty(View paramView, float paramFloat)
  {
    if ((paramView instanceof MotionLayout))
    {
      ((MotionLayout)paramView).setProgress(get(paramFloat));
      return;
    }
    if (this.mNoMethod) {
      return;
    }
    Object localObject = null;
    try
    {
      Method localMethod = paramView.getClass().getMethod("setProgress", new Class[] { Float.TYPE });
      localObject = localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label57:
      break label57;
    }
    this.mNoMethod = true;
    if (localObject != null) {
      try
      {
        localObject.invoke(paramView, new Object[] { Float.valueOf(get(paramFloat)) });
        return;
      }
      catch (InvocationTargetException paramView)
      {
        Log.e("SplineSet", "unable to setProgress", paramView);
        return;
      }
      catch (IllegalAccessException paramView)
      {
        Log.e("SplineSet", "unable to setProgress", paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.SplineSet.ProgressSet
 * JD-Core Version:    0.7.0.1
 */