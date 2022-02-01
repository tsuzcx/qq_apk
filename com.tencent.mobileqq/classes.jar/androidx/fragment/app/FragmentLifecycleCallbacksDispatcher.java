package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class FragmentLifecycleCallbacksDispatcher
{
  @NonNull
  private final FragmentManager mFragmentManager;
  @NonNull
  private final CopyOnWriteArrayList<FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder> mLifecycleCallbacks = new CopyOnWriteArrayList();
  
  FragmentLifecycleCallbacksDispatcher(@NonNull FragmentManager paramFragmentManager)
  {
    this.mFragmentManager = paramFragmentManager;
  }
  
  void dispatchOnFragmentActivityCreated(@NonNull Fragment paramFragment, @Nullable Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = this.mFragmentManager.getParent();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentActivityCreated(paramFragment, paramBundle, true);
    }
    localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentActivityCreated(this.mFragmentManager, paramFragment, paramBundle);
      }
    }
  }
  
  void dispatchOnFragmentAttached(@NonNull Fragment paramFragment, @NonNull Context paramContext, boolean paramBoolean)
  {
    Object localObject = this.mFragmentManager.getParent();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentAttached(paramFragment, paramContext, true);
    }
    localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentAttached(this.mFragmentManager, paramFragment, paramContext);
      }
    }
  }
  
  void dispatchOnFragmentCreated(@NonNull Fragment paramFragment, @Nullable Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = this.mFragmentManager.getParent();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentCreated(paramFragment, paramBundle, true);
    }
    localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentCreated(this.mFragmentManager, paramFragment, paramBundle);
      }
    }
  }
  
  void dispatchOnFragmentDestroyed(@NonNull Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.mFragmentManager.getParent();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDestroyed(paramFragment, true);
    }
    localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentDestroyed(this.mFragmentManager, paramFragment);
      }
    }
  }
  
  void dispatchOnFragmentDetached(@NonNull Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.mFragmentManager.getParent();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDetached(paramFragment, true);
    }
    localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentDetached(this.mFragmentManager, paramFragment);
      }
    }
  }
  
  void dispatchOnFragmentPaused(@NonNull Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.mFragmentManager.getParent();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPaused(paramFragment, true);
    }
    localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentPaused(this.mFragmentManager, paramFragment);
      }
    }
  }
  
  void dispatchOnFragmentPreAttached(@NonNull Fragment paramFragment, @NonNull Context paramContext, boolean paramBoolean)
  {
    Object localObject = this.mFragmentManager.getParent();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreAttached(paramFragment, paramContext, true);
    }
    localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentPreAttached(this.mFragmentManager, paramFragment, paramContext);
      }
    }
  }
  
  void dispatchOnFragmentPreCreated(@NonNull Fragment paramFragment, @Nullable Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = this.mFragmentManager.getParent();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreCreated(paramFragment, paramBundle, true);
    }
    localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentPreCreated(this.mFragmentManager, paramFragment, paramBundle);
      }
    }
  }
  
  void dispatchOnFragmentResumed(@NonNull Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.mFragmentManager.getParent();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentResumed(paramFragment, true);
    }
    localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentResumed(this.mFragmentManager, paramFragment);
      }
    }
  }
  
  void dispatchOnFragmentSaveInstanceState(@NonNull Fragment paramFragment, @NonNull Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = this.mFragmentManager.getParent();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentSaveInstanceState(paramFragment, paramBundle, true);
    }
    localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentSaveInstanceState(this.mFragmentManager, paramFragment, paramBundle);
      }
    }
  }
  
  void dispatchOnFragmentStarted(@NonNull Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.mFragmentManager.getParent();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStarted(paramFragment, true);
    }
    localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentStarted(this.mFragmentManager, paramFragment);
      }
    }
  }
  
  void dispatchOnFragmentStopped(@NonNull Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.mFragmentManager.getParent();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStopped(paramFragment, true);
    }
    localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentStopped(this.mFragmentManager, paramFragment);
      }
    }
  }
  
  void dispatchOnFragmentViewCreated(@NonNull Fragment paramFragment, @NonNull View paramView, @Nullable Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = this.mFragmentManager.getParent();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewCreated(paramFragment, paramView, paramBundle, true);
    }
    localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentViewCreated(this.mFragmentManager, paramFragment, paramView, paramBundle);
      }
    }
  }
  
  void dispatchOnFragmentViewDestroyed(@NonNull Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.mFragmentManager.getParent();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewDestroyed(paramFragment, true);
    }
    localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentViewDestroyed(this.mFragmentManager, paramFragment);
      }
    }
  }
  
  public void registerFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks, boolean paramBoolean)
  {
    this.mLifecycleCallbacks.add(new FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder(paramFragmentLifecycleCallbacks, paramBoolean));
  }
  
  public void unregisterFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.mLifecycleCallbacks;
    int i = 0;
    try
    {
      int j = this.mLifecycleCallbacks.size();
      if (i < j)
      {
        if (((FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder)this.mLifecycleCallbacks.get(i)).mCallback != paramFragmentLifecycleCallbacks) {
          break label70;
        }
        this.mLifecycleCallbacks.remove(i);
      }
      return;
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          throw paramFragmentLifecycleCallbacks;
        }
        label70:
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentLifecycleCallbacksDispatcher
 * JD-Core Version:    0.7.0.1
 */