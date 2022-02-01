package com.tencent.biz.richframework.compat;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public abstract class CompatAndroidXFragment
  extends CompatPublicFragment
{
  private static final String TAG = "CompatAndroidXFragment";
  private Fragment mFragment;
  
  protected abstract Fragment createSupportFragment();
  
  public Fragment getRealFragment()
  {
    return this.mFragment;
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    Fragment localFragment = this.mFragment;
    if (localFragment != null) {
      localFragment.onActivityCreated(paramBundle);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Fragment localFragment = this.mFragment;
    if (localFragment != null) {
      localFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    if (getActivity() != null)
    {
      this.mFragment = createSupportFragment();
      onFragmentCreatedInstance(getRealFragment());
      paramContext = this.mFragment;
      if (paramContext != null) {
        paramContext.onAttach(getActivity());
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Fragment localFragment = this.mFragment;
    if (localFragment != null) {
      localFragment.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Fragment localFragment = this.mFragment;
    if (localFragment != null) {
      localFragment.onCreate(paramBundle);
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Fragment localFragment = this.mFragment;
    if (localFragment == null) {
      paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    } else {
      paramLayoutInflater = localFragment.onCreateView(paramLayoutInflater, null, null);
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Fragment localFragment = this.mFragment;
    if (localFragment != null) {
      localFragment.onDestroy();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Fragment localFragment = this.mFragment;
    if (localFragment != null) {
      localFragment.onDestroyView();
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    Fragment localFragment = this.mFragment;
    if (localFragment != null) {
      localFragment.onDetach();
    }
  }
  
  protected abstract void onFragmentCreatedInstance(Fragment paramFragment);
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    Fragment localFragment = this.mFragment;
    if (localFragment != null) {
      localFragment.onHiddenChanged(paramBoolean);
    }
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
  }
  
  public void onPause()
  {
    super.onPause();
    Fragment localFragment = this.mFragment;
    if (localFragment != null) {
      localFragment.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Fragment localFragment = this.mFragment;
    if (localFragment != null) {
      localFragment.onResume();
    }
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Fragment localFragment = this.mFragment;
    if (localFragment != null) {
      localFragment.onSaveInstanceState(paramBundle);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    Fragment localFragment = this.mFragment;
    if (localFragment != null) {
      localFragment.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    Fragment localFragment = this.mFragment;
    if (localFragment != null) {
      localFragment.onStop();
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    Fragment localFragment = this.mFragment;
    if (localFragment != null) {
      localFragment.onViewCreated(paramView, paramBundle);
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    Fragment localFragment = this.mFragment;
    if (localFragment != null) {
      localFragment.setUserVisibleHint(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.compat.CompatAndroidXFragment
 * JD-Core Version:    0.7.0.1
 */