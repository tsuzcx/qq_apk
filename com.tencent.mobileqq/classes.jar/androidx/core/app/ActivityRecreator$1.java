package androidx.core.app;

final class ActivityRecreator$1
  implements Runnable
{
  ActivityRecreator$1(ActivityRecreator.LifecycleCheckCallbacks paramLifecycleCheckCallbacks, Object paramObject) {}
  
  public void run()
  {
    this.val$callbacks.currentlyRecreatingToken = this.val$token;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.app.ActivityRecreator.1
 * JD-Core Version:    0.7.0.1
 */