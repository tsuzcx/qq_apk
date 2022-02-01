package com.huawei.hmf.tasks.a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import com.huawei.hmf.tasks.ExecuteResult;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

public final class g
  extends ReportFragment
{
  private static final WeakHashMap<Activity, WeakReference<g>> b = new WeakHashMap();
  private final List<WeakReference<ExecuteResult<?>>> a = new ArrayList();
  
  private static g a(Activity paramActivity)
  {
    Object localObject1 = (WeakReference)b.get(paramActivity);
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
      return (g)((WeakReference)localObject1).get();
    }
    Object localObject2 = paramActivity.getFragmentManager();
    try
    {
      localObject1 = (g)((FragmentManager)localObject2).findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
      if (localObject1 == null) {
        try
        {
          localObject2 = a((FragmentManager)localObject2);
          localObject1 = localObject2;
        }
        catch (ClassCastException localClassCastException2)
        {
          paramActivity = (Activity)localObject1;
          localObject1 = localClassCastException2;
          break label96;
        }
      }
      try
      {
        b.put(paramActivity, new WeakReference(localObject1));
        return localObject1;
      }
      catch (ClassCastException localClassCastException3)
      {
        paramActivity = (Activity)localObject1;
        localObject1 = localClassCastException3;
      }
      localStringBuilder = new StringBuilder("found LifecycleCallbackFragment but the type do not match. ");
    }
    catch (ClassCastException localClassCastException1)
    {
      paramActivity = null;
    }
    label96:
    StringBuilder localStringBuilder;
    localStringBuilder.append(localClassCastException1.getMessage());
    Log.e("LifecycleCallbackFrg", localStringBuilder.toString());
    return paramActivity;
  }
  
  private static g a(FragmentManager paramFragmentManager)
  {
    try
    {
      Object localObject = new g();
      try
      {
        paramFragmentManager.beginTransaction().add((Fragment)localObject, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
        return localObject;
      }
      catch (Exception localException2)
      {
        paramFragmentManager = (FragmentManager)localObject;
        localObject = localException2;
      }
      localStringBuilder = new StringBuilder("create fragment failed.");
    }
    catch (Exception localException1)
    {
      paramFragmentManager = null;
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append(localException1.getMessage());
    Log.e("LifecycleCallbackFrg", localStringBuilder.toString());
    return paramFragmentManager;
  }
  
  public static void a(Activity arg0, ExecuteResult paramExecuteResult)
  {
    g localg = a(???);
    if (localg != null) {
      synchronized (localg.a)
      {
        localg.a.add(new WeakReference(paramExecuteResult));
        return;
      }
    }
  }
  
  public final void onStop()
  {
    super.onStop();
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ExecuteResult localExecuteResult = (ExecuteResult)((WeakReference)localIterator.next()).get();
        if (localExecuteResult != null) {
          localExecuteResult.cancel();
        }
      }
      this.a.clear();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.g
 * JD-Core Version:    0.7.0.1
 */