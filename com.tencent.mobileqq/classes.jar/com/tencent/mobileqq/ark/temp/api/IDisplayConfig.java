package com.tencent.mobileqq.ark.temp.api;

import android.util.DisplayMetrics;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IDisplayConfig
  extends QRouteApi
{
  public abstract float getDisplayDensity();
  
  public abstract DisplayMetrics getDisplayMetrics();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.temp.api.IDisplayConfig
 * JD-Core Version:    0.7.0.1
 */