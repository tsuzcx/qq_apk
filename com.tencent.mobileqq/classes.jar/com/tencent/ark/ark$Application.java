package com.tencent.ark;

import android.graphics.Bitmap;

public class ark$Application
  extends ark.NativeObject
{
  public static final native Application Create(String paramString1, String paramString2);
  
  public static native void EnableScriptLeakCheck(boolean paramBoolean);
  
  public static native boolean JSCLoaded();
  
  public native boolean CheckPermissions(String paramString);
  
  public native boolean CheckShareUrlLegality(String paramString);
  
  public native boolean CheckUrlLegality(String paramString);
  
  public native int CheckVersion();
  
  public native boolean CopyIconToBitmap(Bitmap paramBitmap);
  
  public native String GetActionSet();
  
  public native String GetDescription();
  
  public native String GetEngineResPath();
  
  public native String GetID();
  
  public native int GetIconHeight();
  
  public native int GetIconWidth();
  
  public native String GetLauncher();
  
  public native int GetScriptType();
  
  public native String GetSpecific(String paramString);
  
  public native String GetSystemPathFromLocal(String paramString);
  
  public native String GetUrlWhiteList();
  
  public native String GetVersion();
  
  public native void IncreaseGraphicMemSize(long paramLong);
  
  public native boolean Load(String paramString1, String paramString2, String paramString3);
  
  public native void Release();
  
  public native boolean Run(ark.ApplicationCallback paramApplicationCallback, String paramString);
  
  public native void SetForeground(boolean paramBoolean);
  
  public native boolean SetSpecific(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ark.Application
 * JD-Core Version:    0.7.0.1
 */