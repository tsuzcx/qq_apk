package com.tencent.mobileqq.app.api;

import android.content.Context;
import android.view.Window;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IScreenShotService
  extends QRouteApi
{
  public abstract void logForDev(String paramString);
  
  public abstract IScreenShot newInstance(Context paramContext, Window paramWindow);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.api.IScreenShotService
 * JD-Core Version:    0.7.0.1
 */