package androidx.lifecycle;

import androidx.annotation.NonNull;

class CompositeGeneratedAdaptersObserver
  implements LifecycleEventObserver
{
  private final GeneratedAdapter[] mGeneratedAdapters;
  
  CompositeGeneratedAdaptersObserver(GeneratedAdapter[] paramArrayOfGeneratedAdapter)
  {
    this.mGeneratedAdapters = paramArrayOfGeneratedAdapter;
  }
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    int j = 0;
    MethodCallsLogger localMethodCallsLogger = new MethodCallsLogger();
    GeneratedAdapter[] arrayOfGeneratedAdapter = this.mGeneratedAdapters;
    int k = arrayOfGeneratedAdapter.length;
    int i = 0;
    while (i < k)
    {
      arrayOfGeneratedAdapter[i].callMethods(paramLifecycleOwner, paramEvent, false, localMethodCallsLogger);
      i += 1;
    }
    arrayOfGeneratedAdapter = this.mGeneratedAdapters;
    k = arrayOfGeneratedAdapter.length;
    i = j;
    while (i < k)
    {
      arrayOfGeneratedAdapter[i].callMethods(paramLifecycleOwner, paramEvent, true, localMethodCallsLogger);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.CompositeGeneratedAdaptersObserver
 * JD-Core Version:    0.7.0.1
 */