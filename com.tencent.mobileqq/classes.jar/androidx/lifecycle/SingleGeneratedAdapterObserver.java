package androidx.lifecycle;

import androidx.annotation.NonNull;

class SingleGeneratedAdapterObserver
  implements LifecycleEventObserver
{
  private final GeneratedAdapter mGeneratedAdapter;
  
  SingleGeneratedAdapterObserver(GeneratedAdapter paramGeneratedAdapter)
  {
    this.mGeneratedAdapter = paramGeneratedAdapter;
  }
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    this.mGeneratedAdapter.callMethods(paramLifecycleOwner, paramEvent, false, null);
    this.mGeneratedAdapter.callMethods(paramLifecycleOwner, paramEvent, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.SingleGeneratedAdapterObserver
 * JD-Core Version:    0.7.0.1
 */