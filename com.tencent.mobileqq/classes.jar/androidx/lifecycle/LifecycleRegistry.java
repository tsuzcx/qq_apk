package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap.IteratorWithAdditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class LifecycleRegistry
  extends Lifecycle
{
  private int mAddingObserverCounter = 0;
  private boolean mHandlingEvent = false;
  private final WeakReference<LifecycleOwner> mLifecycleOwner;
  private boolean mNewEventOccurred = false;
  private FastSafeIterableMap<LifecycleObserver, LifecycleRegistry.ObserverWithState> mObserverMap = new FastSafeIterableMap();
  private ArrayList<Lifecycle.State> mParentStates = new ArrayList();
  private Lifecycle.State mState;
  
  public LifecycleRegistry(@NonNull LifecycleOwner paramLifecycleOwner)
  {
    this.mLifecycleOwner = new WeakReference(paramLifecycleOwner);
    this.mState = Lifecycle.State.INITIALIZED;
  }
  
  private void backwardPass(LifecycleOwner paramLifecycleOwner)
  {
    Iterator localIterator = this.mObserverMap.descendingIterator();
    while ((localIterator.hasNext()) && (!this.mNewEventOccurred))
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      LifecycleRegistry.ObserverWithState localObserverWithState = (LifecycleRegistry.ObserverWithState)localEntry.getValue();
      while ((localObserverWithState.mState.compareTo(this.mState) > 0) && (!this.mNewEventOccurred) && (this.mObserverMap.contains(localEntry.getKey())))
      {
        Lifecycle.Event localEvent = downEvent(localObserverWithState.mState);
        pushParentState(getStateAfter(localEvent));
        localObserverWithState.dispatchEvent(paramLifecycleOwner, localEvent);
        popParentState();
      }
    }
  }
  
  private Lifecycle.State calculateTargetState(LifecycleObserver paramLifecycleObserver)
  {
    paramLifecycleObserver = this.mObserverMap.ceil(paramLifecycleObserver);
    if (paramLifecycleObserver != null)
    {
      paramLifecycleObserver = ((LifecycleRegistry.ObserverWithState)paramLifecycleObserver.getValue()).mState;
      if (this.mParentStates.isEmpty()) {
        break label74;
      }
    }
    label74:
    for (Lifecycle.State localState = (Lifecycle.State)this.mParentStates.get(this.mParentStates.size() - 1);; localState = null)
    {
      return min(min(this.mState, paramLifecycleObserver), localState);
      paramLifecycleObserver = null;
      break;
    }
  }
  
  private static Lifecycle.Event downEvent(Lifecycle.State paramState)
  {
    switch (LifecycleRegistry.1.$SwitchMap$androidx$lifecycle$Lifecycle$State[paramState.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value " + paramState);
    case 1: 
      throw new IllegalArgumentException();
    case 2: 
      return Lifecycle.Event.ON_DESTROY;
    case 3: 
      return Lifecycle.Event.ON_STOP;
    case 4: 
      return Lifecycle.Event.ON_PAUSE;
    }
    throw new IllegalArgumentException();
  }
  
  private void forwardPass(LifecycleOwner paramLifecycleOwner)
  {
    SafeIterableMap.IteratorWithAdditions localIteratorWithAdditions = this.mObserverMap.iteratorWithAdditions();
    while ((localIteratorWithAdditions.hasNext()) && (!this.mNewEventOccurred))
    {
      Map.Entry localEntry = (Map.Entry)localIteratorWithAdditions.next();
      LifecycleRegistry.ObserverWithState localObserverWithState = (LifecycleRegistry.ObserverWithState)localEntry.getValue();
      while ((localObserverWithState.mState.compareTo(this.mState) < 0) && (!this.mNewEventOccurred) && (this.mObserverMap.contains(localEntry.getKey())))
      {
        pushParentState(localObserverWithState.mState);
        localObserverWithState.dispatchEvent(paramLifecycleOwner, upEvent(localObserverWithState.mState));
        popParentState();
      }
    }
  }
  
  static Lifecycle.State getStateAfter(Lifecycle.Event paramEvent)
  {
    switch (LifecycleRegistry.1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[paramEvent.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unexpected event value " + paramEvent);
    case 1: 
    case 2: 
      return Lifecycle.State.CREATED;
    case 3: 
    case 4: 
      return Lifecycle.State.STARTED;
    case 5: 
      return Lifecycle.State.RESUMED;
    }
    return Lifecycle.State.DESTROYED;
  }
  
  private boolean isSynced()
  {
    if (this.mObserverMap.size() == 0) {
      return true;
    }
    Lifecycle.State localState1 = ((LifecycleRegistry.ObserverWithState)this.mObserverMap.eldest().getValue()).mState;
    Lifecycle.State localState2 = ((LifecycleRegistry.ObserverWithState)this.mObserverMap.newest().getValue()).mState;
    if ((localState1 == localState2) && (this.mState == localState2)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  static Lifecycle.State min(@NonNull Lifecycle.State paramState1, @Nullable Lifecycle.State paramState2)
  {
    if ((paramState2 != null) && (paramState2.compareTo(paramState1) < 0)) {
      return paramState2;
    }
    return paramState1;
  }
  
  private void moveToState(Lifecycle.State paramState)
  {
    if (this.mState == paramState) {
      return;
    }
    this.mState = paramState;
    if ((this.mHandlingEvent) || (this.mAddingObserverCounter != 0))
    {
      this.mNewEventOccurred = true;
      return;
    }
    this.mHandlingEvent = true;
    sync();
    this.mHandlingEvent = false;
  }
  
  private void popParentState()
  {
    this.mParentStates.remove(this.mParentStates.size() - 1);
  }
  
  private void pushParentState(Lifecycle.State paramState)
  {
    this.mParentStates.add(paramState);
  }
  
  private void sync()
  {
    LifecycleOwner localLifecycleOwner = (LifecycleOwner)this.mLifecycleOwner.get();
    if (localLifecycleOwner == null) {
      throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }
    while (!isSynced())
    {
      this.mNewEventOccurred = false;
      if (this.mState.compareTo(((LifecycleRegistry.ObserverWithState)this.mObserverMap.eldest().getValue()).mState) < 0) {
        backwardPass(localLifecycleOwner);
      }
      Map.Entry localEntry = this.mObserverMap.newest();
      if ((!this.mNewEventOccurred) && (localEntry != null) && (this.mState.compareTo(((LifecycleRegistry.ObserverWithState)localEntry.getValue()).mState) > 0)) {
        forwardPass(localLifecycleOwner);
      }
    }
    this.mNewEventOccurred = false;
  }
  
  private static Lifecycle.Event upEvent(Lifecycle.State paramState)
  {
    switch (LifecycleRegistry.1.$SwitchMap$androidx$lifecycle$Lifecycle$State[paramState.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value " + paramState);
    case 1: 
    case 5: 
      return Lifecycle.Event.ON_CREATE;
    case 2: 
      return Lifecycle.Event.ON_START;
    case 3: 
      return Lifecycle.Event.ON_RESUME;
    }
    throw new IllegalArgumentException();
  }
  
  public void addObserver(@NonNull LifecycleObserver paramLifecycleObserver)
  {
    Lifecycle.State localState;
    LifecycleRegistry.ObserverWithState localObserverWithState;
    if (this.mState == Lifecycle.State.DESTROYED)
    {
      localState = Lifecycle.State.DESTROYED;
      localObserverWithState = new LifecycleRegistry.ObserverWithState(paramLifecycleObserver, localState);
      if ((LifecycleRegistry.ObserverWithState)this.mObserverMap.putIfAbsent(paramLifecycleObserver, localObserverWithState) == null) {
        break label49;
      }
    }
    label49:
    LifecycleOwner localLifecycleOwner;
    do
    {
      return;
      localState = Lifecycle.State.INITIALIZED;
      break;
      localLifecycleOwner = (LifecycleOwner)this.mLifecycleOwner.get();
    } while (localLifecycleOwner == null);
    if ((this.mAddingObserverCounter != 0) || (this.mHandlingEvent)) {}
    for (int i = 1;; i = 0)
    {
      localState = calculateTargetState(paramLifecycleObserver);
      this.mAddingObserverCounter += 1;
      while ((localObserverWithState.mState.compareTo(localState) < 0) && (this.mObserverMap.contains(paramLifecycleObserver)))
      {
        pushParentState(localObserverWithState.mState);
        localObserverWithState.dispatchEvent(localLifecycleOwner, upEvent(localObserverWithState.mState));
        popParentState();
        localState = calculateTargetState(paramLifecycleObserver);
      }
    }
    if (i == 0) {
      sync();
    }
    this.mAddingObserverCounter -= 1;
  }
  
  @NonNull
  public Lifecycle.State getCurrentState()
  {
    return this.mState;
  }
  
  public int getObserverCount()
  {
    return this.mObserverMap.size();
  }
  
  public void handleLifecycleEvent(@NonNull Lifecycle.Event paramEvent)
  {
    moveToState(getStateAfter(paramEvent));
  }
  
  @Deprecated
  @MainThread
  public void markState(@NonNull Lifecycle.State paramState)
  {
    setCurrentState(paramState);
  }
  
  public void removeObserver(@NonNull LifecycleObserver paramLifecycleObserver)
  {
    this.mObserverMap.remove(paramLifecycleObserver);
  }
  
  @MainThread
  public void setCurrentState(@NonNull Lifecycle.State paramState)
  {
    moveToState(paramState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.LifecycleRegistry
 * JD-Core Version:    0.7.0.1
 */