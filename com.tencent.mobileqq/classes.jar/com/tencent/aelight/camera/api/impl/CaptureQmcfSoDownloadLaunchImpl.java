package com.tencent.aelight.camera.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.aelight.camera.aebase.activity.CaptureQmcfSoDownloadActivity;
import com.tencent.aelight.camera.api.ICaptureQmcfSoDownloadLaunch;

public class CaptureQmcfSoDownloadLaunchImpl
  implements ICaptureQmcfSoDownloadLaunch
{
  public Class getQmcSoDownloadActivity()
  {
    return CaptureQmcfSoDownloadActivity.class;
  }
  
  public void launch(Context paramContext, String paramString, Bundle paramBundle)
  {
    CaptureQmcfSoDownloadActivity.a(paramContext, paramString, paramBundle);
  }
  
  public void launch(Context paramContext, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    CaptureQmcfSoDownloadActivity.a(paramContext, paramString, paramBundle, paramBoolean);
  }
  
  public void launchForResult(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    CaptureQmcfSoDownloadActivity.a(paramActivity, paramString, paramBundle, paramInt);
  }
  
  public void launchForResult(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    CaptureQmcfSoDownloadActivity.a(paramActivity, paramString, paramBundle, paramInt, paramBoolean);
  }
  
  public void launchForResult(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    CaptureQmcfSoDownloadActivity.a(paramActivity, paramString, paramBundle, paramInt, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.CaptureQmcfSoDownloadLaunchImpl
 * JD-Core Version:    0.7.0.1
 */