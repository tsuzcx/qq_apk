package com.tencent.mfsdk.LeakInspector;

import abvb;
import android.app.Activity;
import android.view.Choreographer;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public final class ActivityLeakSolution$1
  implements Runnable
{
  public ActivityLeakSolution$1(Activity paramActivity) {}
  
  public void run()
  {
    try
    {
      Choreographer localChoreographer = Choreographer.getInstance();
      abvb.a.set(localChoreographer, this.a.getApplicationContext());
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("LeakInspector", 2, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.LeakInspector.ActivityLeakSolution.1
 * JD-Core Version:    0.7.0.1
 */