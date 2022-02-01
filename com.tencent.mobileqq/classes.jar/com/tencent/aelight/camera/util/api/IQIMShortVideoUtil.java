package com.tencent.aelight.camera.util.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQIMShortVideoUtil
  extends QRouteApi
{
  public abstract boolean isPeakAlive(Context paramContext);
  
  public abstract void preLoadPeakProcess(Context paramContext);
  
  public abstract void preLoadPeakProcess(Context paramContext, Runnable paramRunnable, String paramString);
  
  public abstract void preLoadPeakProcess(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.util.api.IQIMShortVideoUtil
 * JD-Core Version:    0.7.0.1
 */