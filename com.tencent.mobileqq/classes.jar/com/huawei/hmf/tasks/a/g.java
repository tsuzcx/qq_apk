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
    localObject1 = (WeakReference)b.get(paramActivity);
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
      return (g)((WeakReference)localObject1).get();
    }
    FragmentManager localFragmentManager = paramActivity.getFragmentManager();
    try
    {
      localObject1 = (g)localFragmentManager.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
      Object localObject2 = localObject1;
      if (localObject1 == null) {}
      try
      {
        localObject2 = a(localFragmentManager);
        localObject1 = localObject2;
        b.put(paramActivity, new WeakReference(localObject2));
        return localObject2;
      }
      catch (ClassCastException paramActivity) {}
    }
    catch (ClassCastException paramActivity)
    {
      for (;;)
      {
        localObject1 = null;
      }
    }
    Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + paramActivity.getMessage());
    return localObject1;
  }
  
  private static g a(FragmentManager paramFragmentManager)
  {
    try
    {
      g localg = new g();
      Log.e("LifecycleCallbackFrg", "create fragment failed." + localException1.getMessage());
    }
    catch (Exception localException1)
    {
      try
      {
        paramFragmentManager.beginTransaction().add(localg, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
        return localg;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          paramFragmentManager = localException1;
          Object localObject = localException2;
        }
      }
      localException1 = localException1;
      paramFragmentManager = null;
    }
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
    }
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.g
 * JD-Core Version:    0.7.0.1
 */