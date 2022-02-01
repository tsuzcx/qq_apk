package com.tencent.falco.base.activitylife;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.falco.base.libapi.activitylife.ActivityLifeService;
import com.tencent.falco.base.libapi.activitylife.AppStatusListener;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ActivityLifeImpl
  implements ActivityLifeService
{
  List<WeakReference<Activity>> activitiesAlive = new ArrayList();
  List<WeakReference<Activity>> activitiesVisible = new ArrayList();
  int activityCount = 0;
  Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new ActivityLifeImpl.1(this);
  List<AppStatusListener> appStatusListenerList = new CopyOnWriteArrayList();
  Context context;
  SoftReference<Activity> topVisibleActivity;
  List<SoftReference<AppStatusListener>> weakReferencesAppListener = new CopyOnWriteArrayList();
  
  public void addAppStatusListener(AppStatusListener paramAppStatusListener)
  {
    this.appStatusListenerList.add(paramAppStatusListener);
  }
  
  public void addAppStatusListenerByWeakRef(AppStatusListener paramAppStatusListener)
  {
    if (paramAppStatusListener == null) {
      return;
    }
    this.weakReferencesAppListener.add(new SoftReference(paramAppStatusListener));
  }
  
  public void clearEventOutput() {}
  
  public void finishAllActivity()
  {
    Iterator localIterator = this.activitiesAlive.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)((WeakReference)localIterator.next()).get();
      if ((localActivity != null) && (!localActivity.isFinishing())) {
        localActivity.finish();
      }
    }
    this.activitiesAlive.clear();
  }
  
  public Application.ActivityLifecycleCallbacks getActivityLifecycleCallbacks()
  {
    return this.activityLifecycleCallbacks;
  }
  
  public List<WeakReference<Activity>> getAliveActivityList()
  {
    return this.activitiesAlive;
  }
  
  @Nullable
  public Activity getTopActivity()
  {
    SoftReference localSoftReference = this.topVisibleActivity;
    if (localSoftReference == null) {
      return null;
    }
    return (Activity)localSoftReference.get();
  }
  
  public void onCreate(Context paramContext)
  {
    this.context = paramContext;
    ((Application)paramContext).registerActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
  }
  
  public void onDestroy() {}
  
  public void removeAppStatusListener(AppStatusListener paramAppStatusListener)
  {
    if (this.appStatusListenerList.contains(paramAppStatusListener)) {
      this.appStatusListenerList.remove(paramAppStatusListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.activitylife.ActivityLifeImpl
 * JD-Core Version:    0.7.0.1
 */