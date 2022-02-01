package androidx.lifecycle;

import androidx.annotation.NonNull;

class FullLifecycleObserverAdapter
  implements LifecycleEventObserver
{
  private final FullLifecycleObserver mFullLifecycleObserver;
  private final LifecycleEventObserver mLifecycleEventObserver;
  
  FullLifecycleObserverAdapter(FullLifecycleObserver paramFullLifecycleObserver, LifecycleEventObserver paramLifecycleEventObserver)
  {
    this.mFullLifecycleObserver = paramFullLifecycleObserver;
    this.mLifecycleEventObserver = paramLifecycleEventObserver;
  }
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    switch (FullLifecycleObserverAdapter.1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[paramEvent.ordinal()])
    {
    default: 
      break;
    case 7: 
      throw new IllegalArgumentException("ON_ANY must not been send by anybody");
    case 6: 
      this.mFullLifecycleObserver.onDestroy(paramLifecycleOwner);
      break;
    case 5: 
      this.mFullLifecycleObserver.onStop(paramLifecycleOwner);
      break;
    case 4: 
      this.mFullLifecycleObserver.onPause(paramLifecycleOwner);
      break;
    case 3: 
      this.mFullLifecycleObserver.onResume(paramLifecycleOwner);
      break;
    case 2: 
      this.mFullLifecycleObserver.onStart(paramLifecycleOwner);
      break;
    case 1: 
      this.mFullLifecycleObserver.onCreate(paramLifecycleOwner);
    }
    LifecycleEventObserver localLifecycleEventObserver = this.mLifecycleEventObserver;
    if (localLifecycleEventObserver != null) {
      localLifecycleEventObserver.onStateChanged(paramLifecycleOwner, paramEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.FullLifecycleObserverAdapter
 * JD-Core Version:    0.7.0.1
 */