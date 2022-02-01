package com.taobao.android.dexposed;

import de.robv.android.xposed.XC_MethodHook.MethodHookParam;

final class XC_MethodReplacement$2
  extends XC_MethodReplacement
{
  XC_MethodReplacement$2(int paramInt, Object paramObject)
  {
    super(paramInt);
  }
  
  protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    return this.val$result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.taobao.android.dexposed.XC_MethodReplacement.2
 * JD-Core Version:    0.7.0.1
 */