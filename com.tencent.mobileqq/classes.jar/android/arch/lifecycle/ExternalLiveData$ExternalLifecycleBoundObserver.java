package android.arch.lifecycle;

import android.support.annotation.NonNull;

class ExternalLiveData$ExternalLifecycleBoundObserver
  extends LiveData<T>.LifecycleBoundObserver
{
  ExternalLiveData$ExternalLifecycleBoundObserver(LifecycleOwner paramLifecycleOwner, @NonNull Observer<T> paramObserver)
  {
    super(paramLifecycleOwner, paramObserver, localObserver);
  }
  
  boolean shouldBeActive()
  {
    return this.mOwner.getLifecycle().getCurrentState().isAtLeast(this.this$0.observerActiveLevel());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.arch.lifecycle.ExternalLiveData.ExternalLifecycleBoundObserver
 * JD-Core Version:    0.7.0.1
 */