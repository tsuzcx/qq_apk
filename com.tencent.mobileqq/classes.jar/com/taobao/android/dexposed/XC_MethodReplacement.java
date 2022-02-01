package com.taobao.android.dexposed;

import de.robv.android.xposed.XC_MethodHook.MethodHookParam;

public abstract class XC_MethodReplacement
  extends XC_MethodHook
{
  public static final XC_MethodReplacement DO_NOTHING = new XC_MethodReplacement.1(20000);
  
  public XC_MethodReplacement() {}
  
  public XC_MethodReplacement(int paramInt)
  {
    super(paramInt);
  }
  
  public static XC_MethodReplacement returnConstant(int paramInt, Object paramObject)
  {
    return new XC_MethodReplacement.2(paramInt, paramObject);
  }
  
  public static XC_MethodReplacement returnConstant(Object paramObject)
  {
    return returnConstant(50, paramObject);
  }
  
  public final void afterHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam) {}
  
  public final void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    try
    {
      paramMethodHookParam.setResult(replaceHookedMethod(paramMethodHookParam));
      return;
    }
    catch (Throwable localThrowable)
    {
      paramMethodHookParam.setThrowable(localThrowable);
    }
  }
  
  protected abstract Object replaceHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.taobao.android.dexposed.XC_MethodReplacement
 * JD-Core Version:    0.7.0.1
 */