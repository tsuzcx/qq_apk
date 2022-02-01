package com.tencent.mobileqq.ark.temp.api.impl;

import android.util.DisplayMetrics;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.temp.api.IDisplayConfig;

public class DisplayConfigImpl
  implements IDisplayConfig
{
  public float getDisplayDensity()
  {
    return ArkAppCenterUtil.d();
  }
  
  public DisplayMetrics getDisplayMetrics()
  {
    return ArkAppCenterUtil.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.temp.api.impl.DisplayConfigImpl
 * JD-Core Version:    0.7.0.1
 */