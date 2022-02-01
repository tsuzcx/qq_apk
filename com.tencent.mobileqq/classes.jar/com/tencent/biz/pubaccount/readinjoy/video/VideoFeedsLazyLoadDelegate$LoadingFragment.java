package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class VideoFeedsLazyLoadDelegate$LoadingFragment
  extends ReportV4Fragment
{
  private VideoFeedsLazyLoadDelegate a;
  
  public static LoadingFragment a(VideoFeedsLazyLoadDelegate paramVideoFeedsLazyLoadDelegate)
  {
    LoadingFragment localLoadingFragment = new LoadingFragment();
    localLoadingFragment.a = paramVideoFeedsLazyLoadDelegate;
    return localLoadingFragment;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = this.a.a(paramLayoutInflater, paramViewGroup, paramBundle);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLazyLoadDelegate.LoadingFragment
 * JD-Core Version:    0.7.0.1
 */