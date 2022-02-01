package androidx.lifecycle;

import androidx.annotation.NonNull;

public abstract interface LifecycleEventObserver
  extends LifecycleObserver
{
  public abstract void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.LifecycleEventObserver
 * JD-Core Version:    0.7.0.1
 */