package com.tencent.aelight.camera.util.api.impl;

import android.support.annotation.NonNull;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import org.jetbrains.annotations.NotNull;

public class AECameraPrefsUtilImpl
  implements IAECameraPrefsUtil
{
  public boolean getBoolean(@NonNull String paramString, boolean paramBoolean, int paramInt)
  {
    return AECameraPrefsUtil.a().b(paramString, paramBoolean, paramInt);
  }
  
  public long getLong(@NonNull String paramString, long paramLong, int paramInt)
  {
    return AECameraPrefsUtil.a().b(paramString, paramLong, paramInt);
  }
  
  public String getString(@NonNull String paramString1, String paramString2, int paramInt)
  {
    return AECameraPrefsUtil.a().b(paramString1, paramString2, paramInt);
  }
  
  public void putBoolean(@NonNull String paramString, boolean paramBoolean, int paramInt)
  {
    AECameraPrefsUtil.a().a(paramString, paramBoolean, paramInt);
  }
  
  public void putLong(@NonNull String paramString, long paramLong, int paramInt)
  {
    AECameraPrefsUtil.a().a(paramString, paramLong, paramInt);
  }
  
  public void putString(@NonNull String paramString1, String paramString2, int paramInt)
  {
    AECameraPrefsUtil.a().a(paramString1, paramString2, paramInt);
  }
  
  public void remove(@NotNull String paramString, int paramInt)
  {
    AECameraPrefsUtil.a().a(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.util.api.impl.AECameraPrefsUtilImpl
 * JD-Core Version:    0.7.0.1
 */