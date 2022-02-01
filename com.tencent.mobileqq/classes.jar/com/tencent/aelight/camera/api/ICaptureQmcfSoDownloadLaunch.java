package com.tencent.aelight.camera.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ICaptureQmcfSoDownloadLaunch
  extends QRouteApi
{
  public abstract Class getQmcSoDownloadActivity();
  
  public abstract void launch(Context paramContext, String paramString, Bundle paramBundle);
  
  public abstract void launch(Context paramContext, String paramString, Bundle paramBundle, boolean paramBoolean);
  
  public abstract void launchForResult(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt);
  
  public abstract void launchForResult(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt, boolean paramBoolean);
  
  public abstract void launchForResult(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.api.ICaptureQmcfSoDownloadLaunch
 * JD-Core Version:    0.7.0.1
 */