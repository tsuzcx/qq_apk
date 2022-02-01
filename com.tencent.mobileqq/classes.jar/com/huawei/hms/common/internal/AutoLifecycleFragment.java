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
  private static final String TAG = "HmsAutoLifecycleFrag";
  private final SparseArray<AutoLifecycleFragment.ClientInfo> mAutoClientInfoMap = new SparseArray();
  private boolean mStarted;
  
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
    this.mStarted = true;
    int i = 0;
    while (i < this.mAutoClientInfoMap.size())
    {
      ((AutoLifecycleFragment.ClientInfo)this.mAutoClientInfoMap.valueAt(i)).apiClient.connect(null);
      i += 1;
    }
  }
  
  public void onStop()
  {
    super.onStop();
    int i = 0;
    this.mStarted = false;
    while (i < this.mAutoClientInfoMap.size())
    {
      ((AutoLifecycleFragment.ClientInfo)this.mAutoClientInfoMap.valueAt(i)).apiClient.disconnect();
      i += 1;
    }
  }
  
  public void startAutoMange(int paramInt, HuaweiApiClient paramHuaweiApiClient)
  {
    Preconditions.checkNotNull(paramHuaweiApiClient, "HuaweiApiClient instance cannot be null");
    boolean bool;
    if (this.mAutoClientInfoMap.indexOfKey(paramInt) < 0) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Already managing a HuaweiApiClient with this clientId: ");
    localStringBuilder.append(paramInt);
    Preconditions.checkState(bool, localStringBuilder.toString());
    this.mAutoClientInfoMap.put(paramInt, new AutoLifecycleFragment.ClientInfo(this, paramInt, paramHuaweiApiClient));
    if (this.mStarted) {
      paramHuaweiApiClient.connect(null);
    }
  }
  
  public void stopAutoManage(int paramInt)
  {
    AutoLifecycleFragment.ClientInfo localClientInfo = (AutoLifecycleFragment.ClientInfo)this.mAutoClientInfoMap.get(paramInt);
    this.mAutoClientInfoMap.remove(paramInt);
    if (localClientInfo != null) {
      localClientInfo.stopAutoManage();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.internal.AutoLifecycleFragment
 * JD-Core Version:    0.7.0.1
 */