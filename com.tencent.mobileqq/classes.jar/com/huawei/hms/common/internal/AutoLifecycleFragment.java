package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.SparseArray;
import com.huawei.hms.api.HuaweiApiClient;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;

public class AutoLifecycleFragment
  extends ReportFragment
{
  private final SparseArray<AutoLifecycleFragment.a> a = new SparseArray();
  private boolean b;
  
  public static AutoLifecycleFragment getInstance(Activity paramActivity)
  {
    Preconditions.checkMainThread("Must be called on the main thread");
    try
    {
      AutoLifecycleFragment localAutoLifecycleFragment = (AutoLifecycleFragment)paramActivity.getFragmentManager().findFragmentByTag("HmsAutoLifecycleFrag");
      FragmentManager localFragmentManager = paramActivity.getFragmentManager();
      paramActivity = localAutoLifecycleFragment;
      if (localAutoLifecycleFragment == null)
      {
        paramActivity = new AutoLifecycleFragment();
        localFragmentManager.beginTransaction().add(paramActivity, "HmsAutoLifecycleFrag").commitAllowingStateLoss();
        localFragmentManager.executePendingTransactions();
      }
      return paramActivity;
    }
    catch (ClassCastException paramActivity)
    {
      throw new IllegalStateException("Fragment with tag HmsAutoLifecycleFrag is not a AutoLifecycleFragment", paramActivity);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    this.b = true;
    int i = 0;
    while (i < this.a.size())
    {
      ((AutoLifecycleFragment.a)this.a.valueAt(i)).a.connect(null);
      i += 1;
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.b = false;
    int i = 0;
    while (i < this.a.size())
    {
      ((AutoLifecycleFragment.a)this.a.valueAt(i)).a.disconnect();
      i += 1;
    }
  }
  
  public void startAutoMange(int paramInt, HuaweiApiClient paramHuaweiApiClient)
  {
    Preconditions.checkNotNull(paramHuaweiApiClient, "HuaweiApiClient instance cannot be null");
    if (this.a.indexOfKey(paramInt) < 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "Already managing a HuaweiApiClient with this clientId: " + paramInt);
      this.a.put(paramInt, new AutoLifecycleFragment.a(this, paramInt, paramHuaweiApiClient));
      if (this.b) {
        paramHuaweiApiClient.connect(null);
      }
      return;
    }
  }
  
  public void stopAutoManage(int paramInt)
  {
    AutoLifecycleFragment.a locala = (AutoLifecycleFragment.a)this.a.get(paramInt);
    this.a.remove(paramInt);
    if (locala != null) {
      locala.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.AutoLifecycleFragment
 * JD-Core Version:    0.7.0.1
 */