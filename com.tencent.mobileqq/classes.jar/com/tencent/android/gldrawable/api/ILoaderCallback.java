package com.tencent.android.gldrawable.api;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/ILoaderCallback;", "", "onLoadFailed", "", "onLoadSucceed", "api_release"}, k=1, mv={1, 1, 16})
public abstract interface ILoaderCallback
{
  public abstract void onLoadFailed();
  
  public abstract void onLoadSucceed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.ILoaderCallback
 * JD-Core Version:    0.7.0.1
 */