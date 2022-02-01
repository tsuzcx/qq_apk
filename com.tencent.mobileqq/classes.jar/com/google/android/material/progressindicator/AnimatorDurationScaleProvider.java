package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class AnimatorDurationScaleProvider
{
  private static float a = 1.0F;
  
  public float a(@NonNull ContentResolver paramContentResolver)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return Settings.Global.getFloat(paramContentResolver, "animator_duration_scale", 1.0F);
    }
    if (Build.VERSION.SDK_INT == 16) {
      return Settings.System.getFloat(paramContentResolver, "animator_duration_scale", 1.0F);
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.AnimatorDurationScaleProvider
 * JD-Core Version:    0.7.0.1
 */