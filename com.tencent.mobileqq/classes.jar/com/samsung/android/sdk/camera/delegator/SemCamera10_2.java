package com.samsung.android.sdk.camera.delegator;

import android.content.Context;
import com.samsung.android.sep.camera.SemCamera;

public class SemCamera10_2
  extends AbstractSemCamera
{
  private SemCamera mSemCamera;
  
  public int checkAvailability(Context paramContext)
  {
    return SemCamera.getInstance().checkAvailability(paramContext);
  }
  
  public boolean isFeatureEnabled(Context paramContext, String paramString, int paramInt)
  {
    return SemCamera.getInstance().isFeatureEnabled(paramContext, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samsung.android.sdk.camera.delegator.SemCamera10_2
 * JD-Core Version:    0.7.0.1
 */