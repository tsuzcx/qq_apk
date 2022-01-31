package android.arch.lifecycle;

class FullLifecycleObserverAdapter
  implements GenericLifecycleObserver
{
  private final FullLifecycleObserver mObserver;
  
  FullLifecycleObserverAdapter(FullLifecycleObserver paramFullLifecycleObserver)
  {
    this.mObserver = paramFullLifecycleObserver;
  }
  
  public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
  {
    switch (FullLifecycleObserverAdapter.1.$SwitchMap$android$arch$lifecycle$Lifecycle$Event[paramEvent.ordinal()])
    {
    default: 
      return;
    case 7: 
      throw new IllegalArgumentException("ON_ANY must not been send by anybody");
    case 6: 
      this.mObserver.onDestroy(paramLifecycleOwner);
      return;
    case 5: 
      this.mObserver.onStop(paramLifecycleOwner);
      return;
    case 4: 
      this.mObserver.onPause(paramLifecycleOwner);
      return;
    case 3: 
      this.mObserver.onResume(paramLifecycleOwner);
      return;
    case 2: 
      this.mObserver.onStart(paramLifecycleOwner);
      return;
    }
    this.mObserver.onCreate(paramLifecycleOwner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.arch.lifecycle.FullLifecycleObserverAdapter
 * JD-Core Version:    0.7.0.1
 */