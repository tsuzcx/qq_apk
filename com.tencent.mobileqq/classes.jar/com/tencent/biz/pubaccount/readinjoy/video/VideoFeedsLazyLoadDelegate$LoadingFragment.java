package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class VideoFeedsLazyLoadDelegate$LoadingFragment
  extends Fragment
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
    return this.a.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLazyLoadDelegate.LoadingFragment
 * JD-Core Version:    0.7.0.1
 */