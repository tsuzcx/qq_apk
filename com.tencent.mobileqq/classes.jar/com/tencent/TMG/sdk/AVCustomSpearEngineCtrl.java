package com.tencent.TMG.sdk;

public class AVCustomSpearEngineCtrl
{
  public int nativeObj = 0;
  
  public native int addParamByRole(String paramString1, String paramString2);
  
  public native void clear();
  
  public native String getDefaultRole();
  
  public native String getParamByRole(String paramString);
  
  public native int getParamCount();
  
  public native String getRoleByIndex(int paramInt);
  
  public native boolean hasRole(String paramString);
  
  public native int setDefaultRole(String paramString);
  
  public native void setSpearEngineScence(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVCustomSpearEngineCtrl
 * JD-Core Version:    0.7.0.1
 */