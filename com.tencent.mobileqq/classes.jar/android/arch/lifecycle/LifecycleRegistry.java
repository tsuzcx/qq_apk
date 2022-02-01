package android.arch.lifecycle;

import android.arch.core.internal.FastSafeIterableMap;
import android.arch.core.internal.SafeIterableMap.IteratorWithAdditions;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class LifecycleRegistry
  extends Lifecycle
{
  private static final String LOG_TAG = "LifecycleRegistry";
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
    Object localObject = null;
    if (paramLifecycleObserver != null) {
      paramLifecycleObserver = ((LifecycleRegistry.ObserverWithState)paramLifecycleObserver.getValue()).mState;
    } else {
      paramLifecycleObserver = null;
    }
    if (!this.mParentStates.isEmpty())
    {
      localObject = this.mParentStates;
      localObject = (Lifecycle.State)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    }
    return min(min(this.mState, paramLifecycleObserver), (Lifecycle.State)localObject);
  }
  
  private static Lifecycle.Event downEvent(Lifecycle.State paramState)
  {
    int i = LifecycleRegistry.1.$SwitchMap$android$arch$lifecycle$Lifecycle$State[paramState.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Unexpected state value ");
              localStringBuilder.append(paramState);
              throw new IllegalArgumentException(localStringBuilder.toString());
            }
            throw new IllegalArgumentException();
          }
          return Lifecycle.Event.ON_PAUSE;
        }
        return Lifecycle.Event.ON_STOP;
      }
      return Lifecycle.Event.ON_DESTROY;
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
    switch (LifecycleRegistry.1.$SwitchMap$android$arch$lifecycle$Lifecycle$Event[paramEvent.ordinal()])
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected event value ");
      localStringBuilder.append(paramEvent);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 6: 
      return Lifecycle.State.DESTROYED;
    case 5: 
      return Lifecycle.State.RESUMED;
    case 3: 
    case 4: 
      return Lifecycle.State.STARTED;
    }
    return Lifecycle.State.CREATED;
  }
  
  private boolean isSynced()
  {
    if (this.mObserverMap.size() == 0) {
      return true;
    }
    Lifecycle.State localState1 = ((LifecycleRegistry.ObserverWithState)this.mObserverMap.eldest().getValue()).mState;
    Lifecycle.State localState2 = ((LifecycleRegistry.ObserverWithState)this.mObserverMap.newest().getValue()).mState;
    return (localState1 == localState2) && (this.mState == localState2);
  }
  
  static Lifecycle.State min(@NonNull Lifecycle.State paramState1, @Nullable Lifecycle.State paramState2)
  {
    Lifecycle.State localState = paramState1;
    if (paramState2 != null)
    {
      localState = paramState1;
      if (paramState2.compareTo(paramState1) < 0) {
        localState = paramState2;
      }
    }
    return localState;
  }
  
  private void moveToState(Lifecycle.State paramState)
  {
    if (this.mState == paramState) {
      return;
    }
    this.mState = paramState;
    if ((!this.mHandlingEvent) && (this.mAddingObserverCounter == 0))
    {
      this.mHandlingEvent = true;
      sync();
      this.mHandlingEvent = false;
      return;
    }
    this.mNewEventOccurred = true;
  }
  
  private void popParentState()
  {
    ArrayList localArrayList = this.mParentStates;
    localArrayList.remove(localArrayList.size() - 1);
  }
  
  private void pushParentState(Lifecycle.State paramState)
  {
    this.mParentStates.add(paramState);
  }
  
  private void sync()
  {
    LifecycleOwner localLifecycleOwner = (LifecycleOwner)this.mLifecycleOwner.get();
    if (localLifecycleOwner == null)
    {
      Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
      return;
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
    int i = LifecycleRegistry.1.$SwitchMap$android$arch$lifecycle$Lifecycle$State[paramState.ordinal()];
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Unexpected state value ");
              localStringBuilder.append(paramState);
              throw new IllegalArgumentException(localStringBuilder.toString());
            }
          }
          else {
            throw new IllegalArgumentException();
          }
        }
        else {
          return Lifecycle.Event.ON_RESUME;
        }
      }
      else {
        return Lifecycle.Event.ON_START;
      }
    }
    return Lifecycle.Event.ON_CREATE;
  }
  
  public void addObserver(@NonNull LifecycleObserver paramLifecycleObserver)
  {
    if (this.mState == Lifecycle.State.DESTROYED) {
      localState = Lifecycle.State.DESTROYED;
    } else {
      localState = Lifecycle.State.INITIALIZED;
    }
    LifecycleRegistry.ObserverWithState localObserverWithState = new LifecycleRegistry.ObserverWithState(paramLifecycleObserver, localState);
    if ((LifecycleRegistry.ObserverWithState)this.mObserverMap.putIfAbsent(paramLifecycleObserver, localObserverWithState) != null) {
      return;
    }
    LifecycleOwner localLifecycleOwner = (LifecycleOwner)this.mLifecycleOwner.get();
    if (localLifecycleOwner == null) {
      return;
    }
    int i;
    if ((this.mAddingObserverCounter == 0) && (!this.mHandlingEvent)) {
      i = 0;
    } else {
      i = 1;
    }
    Lifecycle.State localState = calculateTargetState(paramLifecycleObserver);
    this.mAddingObserverCounter += 1;
    while ((localObserverWithState.mState.compareTo(localState) < 0) && (this.mObserverMap.contains(paramLifecycleObserver)))
    {
      pushParentState(localObserverWithState.mState);
      localObserverWithState.dispatchEvent(localLifecycleOwner, upEvent(localObserverWithState.mState));
      popParentState();
      localState = calculateTargetState(paramLifecycleObserver);
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
  
  @MainThread
  public void markState(@NonNull Lifecycle.State paramState)
  {
    moveToState(paramState);
  }
  
  public void removeObserver(@NonNull LifecycleObserver paramLifecycleObserver)
  {
    this.mObserverMap.remove(paramLifecycleObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.arch.lifecycle.LifecycleRegistry
 * JD-Core Version:    0.7.0.1
 */