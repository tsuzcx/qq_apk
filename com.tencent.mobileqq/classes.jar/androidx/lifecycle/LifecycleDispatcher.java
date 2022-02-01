package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

class LifecycleDispatcher
{
  private static AtomicBoolean sInitialized = new AtomicBoolean(false);
  
  static void init(Context paramContext)
  {
    if (sInitialized.getAndSet(true)) {
      return;
    }
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new LifecycleDispatcher.DispatcherActivityCallback());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.LifecycleDispatcher
 * JD-Core Version:    0.7.0.1
 */