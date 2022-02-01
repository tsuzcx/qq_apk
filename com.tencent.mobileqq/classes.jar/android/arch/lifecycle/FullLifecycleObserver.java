package android.arch.lifecycle;

abstract interface FullLifecycleObserver
  extends LifecycleObserver
{
  public abstract void onCreate(LifecycleOwner paramLifecycleOwner);
  
  public abstract void onDestroy(LifecycleOwner paramLifecycleOwner);
  
  public abstract void onPause(LifecycleOwner paramLifecycleOwner);
  
  public abstract void onResume(LifecycleOwner paramLifecycleOwner);
  
  public abstract void onStart(LifecycleOwner paramLifecycleOwner);
  
  public abstract void onStop(LifecycleOwner paramLifecycleOwner);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.arch.lifecycle.FullLifecycleObserver
 * JD-Core Version:    0.7.0.1
 */