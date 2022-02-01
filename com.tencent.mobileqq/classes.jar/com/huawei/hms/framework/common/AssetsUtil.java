package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.InputStream;

public class AssetsUtil
{
  private static final String TAG = "AssetsUtil";
  
  public static String[] list(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      Logger.w("AssetsUtil", "context is null");
      return new String[0];
    }
    paramContext = paramContext.getAssets();
    try
    {
      paramContext = paramContext.list(paramString);
      return paramContext;
    }
    catch (RuntimeException paramContext)
    {
      Logger.e("AssetsUtil", "AssetManager has been destroyed", paramContext);
    }
    return null;
  }
  
  public static InputStream open(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      Logger.w("AssetsUtil", "context is null");
      return null;
    }
    paramContext = paramContext.getAssets();
    try
    {
      paramContext = paramContext.open(paramString);
      return paramContext;
    }
    catch (RuntimeException paramContext)
    {
      Logger.e("AssetsUtil", "AssetManager has been destroyed", paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.AssetsUtil
 * JD-Core Version:    0.7.0.1
 */