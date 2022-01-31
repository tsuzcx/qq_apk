package com.qq.android.dexposed;

import com.qq.android.dexposed.callbacks.XCallback;

public abstract class XC_MethodHook
  extends XCallback
{
  public XC_MethodHook() {}
  
  public XC_MethodHook(int paramInt)
  {
    super(paramInt);
  }
  
  protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam) {}
  
  protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qq.android.dexposed.XC_MethodHook
 * JD-Core Version:    0.7.0.1
 */