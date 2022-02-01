package android.arch.lifecycle;

import android.support.annotation.NonNull;

public abstract interface DefaultLifecycleObserver
  extends FullLifecycleObserver
{
  public abstract void onCreate(@NonNull LifecycleOwner paramLifecycleOwner);
  
  public abstract void onDestroy(@NonNull LifecycleOwner paramLifecycleOwner);
  
  public abstract void onPause(@NonNull LifecycleOwner paramLifecycleOwner);
  
  public abstract void onResume(@NonNull LifecycleOwner paramLifecycleOwner);
  
  public abstract void onStart(@NonNull LifecycleOwner paramLifecycleOwner);
  
  public abstract void onStop(@NonNull LifecycleOwner paramLifecycleOwner);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.arch.lifecycle.DefaultLifecycleObserver
 * JD-Core Version:    0.7.0.1
 */