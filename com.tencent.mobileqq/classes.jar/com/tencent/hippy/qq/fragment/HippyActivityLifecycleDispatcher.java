package com.tencent.hippy.qq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/hippy/qq/fragment/HippyActivityLifecycleDispatcher;", "Lcom/tencent/hippy/qq/fragment/HippyActivityLifecycleListener;", "()V", "mActivityLifecycleListeners", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addActivityLifecycleListener", "", "listener", "clearAllListener", "onActivityCreated", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "removeActivityLifecycleListener", "hippy-api_release"}, k=1, mv={1, 1, 16})
public final class HippyActivityLifecycleDispatcher
  implements HippyActivityLifecycleListener
{
  private final ArrayList<HippyActivityLifecycleListener> mActivityLifecycleListeners = new ArrayList();
  
  public final void addActivityLifecycleListener(@NotNull HippyActivityLifecycleListener paramHippyActivityLifecycleListener)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyActivityLifecycleListener, "listener");
    this.mActivityLifecycleListeners.add(paramHippyActivityLifecycleListener);
  }
  
  public final void clearAllListener()
  {
    this.mActivityLifecycleListeners.clear();
  }
  
  public void onActivityCreated(@Nullable Activity paramActivity, @Nullable Bundle paramBundle)
  {
    Iterator localIterator = this.mActivityLifecycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((HippyActivityLifecycleListener)localIterator.next()).onActivityCreated(paramActivity, paramBundle);
    }
  }
  
  public void onActivityDestroyed(@Nullable Activity paramActivity)
  {
    Iterator localIterator = this.mActivityLifecycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((HippyActivityLifecycleListener)localIterator.next()).onActivityDestroyed(paramActivity);
    }
  }
  
  public void onActivityPaused(@Nullable Activity paramActivity)
  {
    Iterator localIterator = this.mActivityLifecycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((HippyActivityLifecycleListener)localIterator.next()).onActivityPaused(paramActivity);
    }
  }
  
  public void onActivityResult(@Nullable Activity paramActivity, int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    Iterator localIterator = this.mActivityLifecycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((HippyActivityLifecycleListener)localIterator.next()).onActivityResult(paramActivity, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onActivityResumed(@Nullable Activity paramActivity)
  {
    Iterator localIterator = this.mActivityLifecycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((HippyActivityLifecycleListener)localIterator.next()).onActivityResumed(paramActivity);
    }
  }
  
  public void onActivitySaveInstanceState(@Nullable Activity paramActivity, @Nullable Bundle paramBundle)
  {
    Iterator localIterator = this.mActivityLifecycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((HippyActivityLifecycleListener)localIterator.next()).onActivitySaveInstanceState(paramActivity, paramBundle);
    }
  }
  
  public void onActivityStarted(@Nullable Activity paramActivity)
  {
    Iterator localIterator = this.mActivityLifecycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((HippyActivityLifecycleListener)localIterator.next()).onActivityStarted(paramActivity);
    }
  }
  
  public void onActivityStopped(@Nullable Activity paramActivity)
  {
    Iterator localIterator = this.mActivityLifecycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((HippyActivityLifecycleListener)localIterator.next()).onActivityStopped(paramActivity);
    }
  }
  
  public final void removeActivityLifecycleListener(@NotNull HippyActivityLifecycleListener paramHippyActivityLifecycleListener)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyActivityLifecycleListener, "listener");
    this.mActivityLifecycleListeners.remove(paramHippyActivityLifecycleListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.fragment.HippyActivityLifecycleDispatcher
 * JD-Core Version:    0.7.0.1
 */