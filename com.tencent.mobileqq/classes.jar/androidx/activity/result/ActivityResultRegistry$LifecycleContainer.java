package androidx.activity.result;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import java.util.ArrayList;
import java.util.Iterator;

class ActivityResultRegistry$LifecycleContainer
{
  final Lifecycle mLifecycle;
  private final ArrayList<LifecycleEventObserver> mObservers;
  
  ActivityResultRegistry$LifecycleContainer(@NonNull Lifecycle paramLifecycle)
  {
    this.mLifecycle = paramLifecycle;
    this.mObservers = new ArrayList();
  }
  
  void addObserver(@NonNull LifecycleEventObserver paramLifecycleEventObserver)
  {
    this.mLifecycle.addObserver(paramLifecycleEventObserver);
    this.mObservers.add(paramLifecycleEventObserver);
  }
  
  void clearObservers()
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext())
    {
      LifecycleEventObserver localLifecycleEventObserver = (LifecycleEventObserver)localIterator.next();
      this.mLifecycle.removeObserver(localLifecycleEventObserver);
    }
    this.mObservers.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.ActivityResultRegistry.LifecycleContainer
 * JD-Core Version:    0.7.0.1
 */