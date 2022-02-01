package com.tencent.featuretoggle;

import android.content.Context;
import com.tencent.featuretoggle.models.FeatureTriggered;
import com.tencent.featuretoggle.models.FeatureTypedTriggered;
import java.util.Map;
import org.json.JSONObject;

public final class Toggle
{
  private static ToggleImpl a;
  private static ToggleDataTransfer b = new ToggleDataTransfer();
  
  public static FeatureTriggered a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = b().a(paramString1, null, paramString2);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static Map<String, String> a()
  {
    return b().d();
  }
  
  public static void a(Context paramContext, ToggleConfig paramToggleConfig)
  {
    try
    {
      b().a(paramContext, paramToggleConfig);
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
    b().a(paramOnToggleListener);
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      paramBoolean = b().a(paramString, paramBoolean);
      return paramBoolean;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static ToggleImpl b()
  {
    if (a == null) {
      a = ToggleImpl.a();
    }
    return a;
  }
  
  public static FeatureTypedTriggered<JSONObject> b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = b().a(paramString1, null, paramString2);
      paramString1 = b.a().a(paramString1);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static void b(String paramString, boolean paramBoolean)
  {
    try
    {
      b().b(paramString, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.Toggle
 * JD-Core Version:    0.7.0.1
 */