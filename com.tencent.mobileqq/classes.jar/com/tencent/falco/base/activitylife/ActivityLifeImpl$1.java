package com.tencent.falco.base.activitylife;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.falco.base.libapi.activitylife.AppStatusListener;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class ActivityLifeImpl$1
  implements Application.ActivityLifecycleCallbacks
{
  ActivityLifeImpl$1(ActivityLifeImpl paramActivityLifeImpl) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    this.this$0.activitiesAlive.add(new WeakReference(paramActivity));
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    Iterator localIterator = this.this$0.activitiesAlive.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference.get() == null) || (paramActivity.equals(localWeakReference.get()))) {
        localIterator.remove();
      }
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if ((this.this$0.topVisibleActivity != null) && (paramActivity.equals(this.this$0.topVisibleActivity.get()))) {
      this.this$0.topVisibleActivity = null;
    }
    Iterator localIterator = this.this$0.activitiesVisible.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference.get() == null) || (paramActivity.equals(localWeakReference.get()))) {
        localIterator.remove();
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    this.this$0.topVisibleActivity = new SoftReference(paramActivity);
    this.this$0.activitiesVisible.add(new WeakReference(paramActivity));
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    paramActivity = this.this$0;
    paramActivity.activityCount += 1;
    if (this.this$0.activityCount == 1)
    {
      paramActivity = this.this$0.weakReferencesAppListener.iterator();
      while (paramActivity.hasNext())
      {
        SoftReference localSoftReference = (SoftReference)paramActivity.next();
        if (localSoftReference.get() != null) {
          ((AppStatusListener)localSoftReference.get()).onSwitchForeground();
        }
      }
      paramActivity = this.this$0.appStatusListenerList.iterator();
      while (paramActivity.hasNext()) {
        ((AppStatusListener)paramActivity.next()).onSwitchForeground();
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    paramActivity = this.this$0;
    paramActivity.activityCount -= 1;
    if (this.this$0.activityCount == 0)
    {
      paramActivity = this.this$0.weakReferencesAppListener.iterator();
      while (paramActivity.hasNext())
      {
        SoftReference localSoftReference = (SoftReference)paramActivity.next();
        if (localSoftReference.get() != null) {
          ((AppStatusListener)localSoftReference.get()).onSwitchBackground();
        }
      }
      paramActivity = this.this$0.appStatusListenerList.iterator();
      while (paramActivity.hasNext()) {
        ((AppStatusListener)paramActivity.next()).onSwitchBackground();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.activitylife.ActivityLifeImpl.1
 * JD-Core Version:    0.7.0.1
 */