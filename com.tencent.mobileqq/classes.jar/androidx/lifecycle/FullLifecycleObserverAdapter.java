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
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      for (;;)
      {
        if (this.mLifecycleEventObserver != null) {
          this.mLifecycleEventObserver.onStateChanged(paramLifecycleOwner, paramEvent);
        }
        return;
        this.mFullLifecycleObserver.onCreate(paramLifecycleOwner);
        continue;
        this.mFullLifecycleObserver.onStart(paramLifecycleOwner);
        continue;
        this.mFullLifecycleObserver.onResume(paramLifecycleOwner);
        continue;
        this.mFullLifecycleObserver.onPause(paramLifecycleOwner);
        continue;
        this.mFullLifecycleObserver.onStop(paramLifecycleOwner);
        continue;
        this.mFullLifecycleObserver.onDestroy(paramLifecycleOwner);
      }
    }
    throw new IllegalArgumentException("ON_ANY must not been send by anybody");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.FullLifecycleObserverAdapter
 * JD-Core Version:    0.7.0.1
 */