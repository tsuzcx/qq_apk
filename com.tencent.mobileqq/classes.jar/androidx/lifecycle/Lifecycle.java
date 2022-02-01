package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Lifecycle
{
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  AtomicReference<Object> mInternalScopeRef = new AtomicReference();
  
  @MainThread
  public abstract void addObserver(@NonNull LifecycleObserver paramLifecycleObserver);
  
  @MainThread
  @NonNull
  public abstract Lifecycle.State getCurrentState();
  
  @MainThread
  public abstract void removeObserver(@NonNull LifecycleObserver paramLifecycleObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.Lifecycle
 * JD-Core Version:    0.7.0.1
 */