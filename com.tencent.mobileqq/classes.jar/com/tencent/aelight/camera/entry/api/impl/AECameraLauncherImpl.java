package com.tencent.aelight.camera.entry.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.aelight.camera.ae.entry.AECameraLauncher;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import org.jetbrains.annotations.Nullable;

public class AECameraLauncherImpl
  implements IAECameraLauncher
{
  public boolean isCameraResReady()
  {
    return AECameraLauncher.a();
  }
  
  public void launchAECameraFromCircle(Context paramContext, Bundle paramBundle)
  {
    AECameraLauncher.b(paramContext, paramBundle);
  }
  
  public void launchAECameraUnit(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AECameraLauncher.a(paramActivity, paramInt, paramBundle);
  }
  
  public void launchAEMutiCameraFromCircle(Context paramContext, @Nullable Bundle paramBundle)
  {
    AECameraLauncher.c(paramContext, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.entry.api.impl.AECameraLauncherImpl
 * JD-Core Version:    0.7.0.1
 */