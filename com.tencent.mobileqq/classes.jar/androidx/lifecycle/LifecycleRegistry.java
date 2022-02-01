package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.executor.ArchTaskExecutor;
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
  private final boolean mEnforceMainThread;
  private boolean mHandlingEvent = false;
  private final WeakReference<LifecycleOwner> mLifecycleOwner;
  private boolean mNewEventOccurred = false;
  private FastSafeIterableMap<LifecycleObserver, LifecycleRegistry.ObserverWithState> mObserverMap = new FastSafeIterableMap();
  private ArrayList<Lifecycle.State> mParentStates = new ArrayList();
  private Lifecycle.State mState;
  
  public LifecycleRegistry(@NonNull LifecycleOwner paramLifecycleOwner)
  {
    this(paramLifecycleOwner, true);
  }
  
  private LifecycleRegistry(@NonNull LifecycleOwner paramLifecycleOwner, boolean paramBoolean)
  {
    this.mLifecycleOwner = new WeakReference(paramLifecycleOwner);
    this.mState = Lifecycle.State.INITIALIZED;
    this.mEnforceMainThread = paramBoolean;
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
        Lifecycle.Event localEvent = Lifecycle.Event.downFrom(localObserverWithState.mState);
        if (localEvent == null) {
          break label121;
        }
        pushParentState(localEvent.getTargetState());
        localObserverWithState.dispatchEvent(paramLifecycleOwner, localEvent);
        popParentState();
      }
      continue;
      label121:
      paramLifecycleOwner = new StringBuilder();
      paramLifecycleOwner.append("no event down from ");
      paramLifecycleOwner.append(localObserverWithState.mState);
      throw new IllegalStateException(paramLifecycleOwner.toString());
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
  
  @NonNull
  @VisibleForTesting
  public static LifecycleRegistry createUnsafe(@NonNull LifecycleOwner paramLifecycleOwner)
  {
    return new LifecycleRegistry(paramLifecycleOwner, false);
  }
  
  @SuppressLint({"RestrictedApi"})
  private void enforceMainThreadIfNeeded(String paramString)
  {
    if (this.mEnforceMainThread)
    {
      if (ArchTaskExecutor.getInstance().isMainThread()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Method ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" must be called on the main thread");
      throw new IllegalStateException(localStringBuilder.toString());
    }
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
        Lifecycle.Event localEvent = Lifecycle.Event.upFrom(localObserverWithState.mState);
        if (localEvent == null) {
          break label120;
        }
        localObserverWithState.dispatchEvent(paramLifecycleOwner, localEvent);
        popParentState();
      }
      continue;
      label120:
      paramLifecycleOwner = new StringBuilder();
      paramLifecycleOwner.append("no event up from ");
      paramLifecycleOwner.append(localObserverWithState.mState);
      throw new IllegalStateException(paramLifecycleOwner.toString());
    }
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
    Object localObject = (LifecycleOwner)this.mLifecycleOwner.get();
    if (localObject != null)
    {
      while (!isSynced())
      {
        this.mNewEventOccurred = false;
        if (this.mState.compareTo(((LifecycleRegistry.ObserverWithState)this.mObserverMap.eldest().getValue()).mState) < 0) {
          backwardPass((LifecycleOwner)localObject);
        }
        Map.Entry localEntry = this.mObserverMap.newest();
        if ((!this.mNewEventOccurred) && (localEntry != null) && (this.mState.compareTo(((LifecycleRegistry.ObserverWithState)localEntry.getValue()).mState) > 0)) {
          forwardPass((LifecycleOwner)localObject);
        }
      }
      this.mNewEventOccurred = false;
      return;
    }
    localObject = new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void addObserver(@NonNull LifecycleObserver paramLifecycleObserver)
  {
    enforceMainThreadIfNeeded("addObserver");
    if (this.mState == Lifecycle.State.DESTROYED) {
      localObject = Lifecycle.State.DESTROYED;
    } else {
      localObject = Lifecycle.State.INITIALIZED;
    }
    LifecycleRegistry.ObserverWithState localObserverWithState = new LifecycleRegistry.ObserverWithState(paramLifecycleObserver, (Lifecycle.State)localObject);
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
    Object localObject = calculateTargetState(paramLifecycleObserver);
    this.mAddingObserverCounter += 1;
    while ((localObserverWithState.mState.compareTo((Enum)localObject) < 0) && (this.mObserverMap.contains(paramLifecycleObserver)))
    {
      pushParentState(localObserverWithState.mState);
      localObject = Lifecycle.Event.upFrom(localObserverWithState.mState);
      if (localObject != null)
      {
        localObserverWithState.dispatchEvent(localLifecycleOwner, (Lifecycle.Event)localObject);
        popParentState();
        localObject = calculateTargetState(paramLifecycleObserver);
      }
      else
      {
        paramLifecycleObserver = new StringBuilder();
        paramLifecycleObserver.append("no event up from ");
        paramLifecycleObserver.append(localObserverWithState.mState);
        throw new IllegalStateException(paramLifecycleObserver.toString());
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
    enforceMainThreadIfNeeded("getObserverCount");
    return this.mObserverMap.size();
  }
  
  public void handleLifecycleEvent(@NonNull Lifecycle.Event paramEvent)
  {
    enforceMainThreadIfNeeded("handleLifecycleEvent");
    moveToState(paramEvent.getTargetState());
  }
  
  @Deprecated
  @MainThread
  public void markState(@NonNull Lifecycle.State paramState)
  {
    enforceMainThreadIfNeeded("markState");
    setCurrentState(paramState);
  }
  
  public void removeObserver(@NonNull LifecycleObserver paramLifecycleObserver)
  {
    enforceMainThreadIfNeeded("removeObserver");
    this.mObserverMap.remove(paramLifecycleObserver);
  }
  
  @MainThread
  public void setCurrentState(@NonNull Lifecycle.State paramState)
  {
    enforceMainThreadIfNeeded("setCurrentState");
    moveToState(paramState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.LifecycleRegistry
 * JD-Core Version:    0.7.0.1
 */