package android.arch.lifecycle;

import android.support.annotation.NonNull;

public abstract interface LifecycleOwner
{
  @NonNull
  public abstract Lifecycle getLifecycle();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.arch.lifecycle.LifecycleOwner
 * JD-Core Version:    0.7.0.1
 */