package androidx.lifecycle;

import androidx.annotation.NonNull;

@Deprecated
public abstract interface LifecycleRegistryOwner
  extends LifecycleOwner
{
  @NonNull
  public abstract LifecycleRegistry getLifecycle();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.LifecycleRegistryOwner
 * JD-Core Version:    0.7.0.1
 */