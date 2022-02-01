package com.google.android.material.internal;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ContextUtils
{
  @Nullable
  public static Activity a(Context paramContext)
  {
    while ((paramContext instanceof ContextWrapper))
    {
      if ((paramContext instanceof Activity)) {
        return (Activity)paramContext;
      }
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.ContextUtils
 * JD-Core Version:    0.7.0.1
 */