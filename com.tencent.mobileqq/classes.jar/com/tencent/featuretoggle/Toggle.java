package com.tencent.featuretoggle;

import android.content.Context;
import java.util.Map;

public final class Toggle
{
  private static ToggleImpl a;
  
  private static ToggleImpl a()
  {
    if (a == null) {
      a = ToggleImpl.a();
    }
    return a;
  }
  
  public static Map<String, String> a()
  {
    return a().a();
  }
  
  public static void a(Context paramContext, ToggleConfig paramToggleConfig)
  {
    try
    {
      a().a(paramContext, paramToggleConfig);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(OnToggleListener paramOnToggleListener)
  {
    a().a(paramOnToggleListener);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    try
    {
      a().a(paramString, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      paramBoolean = a().a(paramString, paramBoolean);
      return paramBoolean;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.Toggle
 * JD-Core Version:    0.7.0.1
 */