package com.tencent.aekit.openrender.util;

import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.text.TextUtils;

public class AEProfilerBase
  implements IAEProfiler
{
  private final String TAG = "AEProfilerBase";
  public boolean mEnableBase = false;
  protected long mOneFrameCost = 0L;
  protected long mStartTime = 0L;
  
  @CallSuper
  public long endByTag(@Nullable String paramString)
  {
    if (!this.mEnableBase) {
      return 0L;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      int i = -1;
      if ((paramString.hashCode() == 1459121842) && (paramString.equals("IAEProfiler-calFps"))) {
        i = 0;
      }
      if (i != 0) {
        return 0L;
      }
      if (this.mStartTime != 0L) {
        this.mOneFrameCost = (System.currentTimeMillis() - this.mStartTime);
      }
      return this.mOneFrameCost;
    }
    return 0L;
  }
  
  public String print()
  {
    return null;
  }
  
  @CallSuper
  public void reset()
  {
    this.mStartTime = 0L;
    this.mOneFrameCost = 0L;
  }
  
  @CallSuper
  public void startByTag(@Nullable String paramString)
  {
    if (!this.mEnableBase) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      int i = -1;
      if ((paramString.hashCode() == 1459121842) && (paramString.equals("IAEProfiler-calFps"))) {
        i = 0;
      }
      if (i != 0) {
        return;
      }
      this.mStartTime = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.util.AEProfilerBase
 * JD-Core Version:    0.7.0.1
 */