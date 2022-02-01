package com.tencent.hippy.qq.fragment;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/hippy/qq/fragment/HippyActivityLifecycleOwner;", "", "getActivityLifecycleDispatcher", "Lcom/tencent/hippy/qq/fragment/HippyActivityLifecycleDispatcher;", "hippy-api_release"}, k=1, mv={1, 1, 16})
public abstract interface HippyActivityLifecycleOwner
{
  @NotNull
  public abstract HippyActivityLifecycleDispatcher getActivityLifecycleDispatcher();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.fragment.HippyActivityLifecycleOwner
 * JD-Core Version:    0.7.0.1
 */