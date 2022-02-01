package com.tencent.mfsdk.impls.memory;

import android.app.Activity;
import android.view.Choreographer;
import java.lang.reflect.Field;

final class ActivityLeakSolutionInner$1
  implements Runnable
{
  ActivityLeakSolutionInner$1(Activity paramActivity) {}
  
  public void run()
  {
    try
    {
      Choreographer localChoreographer = Choreographer.getInstance();
      ActivityLeakSolutionInner.a.set(localChoreographer, this.a.getApplicationContext());
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mfsdk.impls.memory.ActivityLeakSolutionInner.1
 * JD-Core Version:    0.7.0.1
 */