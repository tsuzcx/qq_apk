package com.tencent.luggage.wxa.standalone_open_runtime;

import android.content.Context;
import android.content.res.AssetManager;

public class OpenRuntimeJNI
{
  static
  {
    System.loadLibrary("wxaopenruntimejni");
  }
  
  public static String a()
  {
    return nativeObtainConfig();
  }
  
  public static void a(Context paramContext)
  {
    nativeInit(paramContext.getAssets());
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    return nativeCheckValid(paramString, paramInt);
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt)
  {
    return nativeCheckLibValid(paramString1, paramString2, paramInt);
  }
  
  private static native boolean nativeCheckLibValid(String paramString1, String paramString2, int paramInt);
  
  private static native boolean nativeCheckValid(String paramString, int paramInt);
  
  private static native void nativeInit(AssetManager paramAssetManager);
  
  private static native String nativeObtainConfig();
  
  private static native void nativeUnInit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.OpenRuntimeJNI
 * JD-Core Version:    0.7.0.1
 */