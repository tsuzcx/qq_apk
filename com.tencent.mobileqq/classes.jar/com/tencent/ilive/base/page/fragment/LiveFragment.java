package com.tencent.ilive.base.page.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.falco.utils.UIUtil;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class LiveFragment
  extends LiveBaseFragment
{
  private static final String TAG = "LiveFragment";
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.d("LiveFragment", "onCreate");
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Log.d("LiveFragment", "onCreateView");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.d("LiveFragment", "onDestroy");
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Log.d("LiveFragment", "onDestroyView");
  }
  
  public void onDetach()
  {
    super.onDetach();
    Log.d("LiveFragment", "onDetach");
  }
  
  public void onPause()
  {
    super.onPause();
    Log.d("LiveFragment", "onPause");
  }
  
  public void onStop()
  {
    super.onStop();
    Log.d("LiveFragment", "onStop");
  }
  
  protected void setFullScreen()
  {
    UIUtil.setFullscreen(getActivity(), true, true);
    UIUtil.setStatusBarColor(getActivity(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.base.page.fragment.LiveFragment
 * JD-Core Version:    0.7.0.1
 */