package com.tencent.assistant.qa.hook;

import com.taobao.android.dexposed.XC_MethodHook;
import com.tencent.HookLog;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;

final class GalileoHookUtil$2
  extends XC_MethodHook
{
  GalileoHookUtil$2(String paramString, Object[] paramArrayOfObject) {}
  
  public void afterHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    HookLog.d("methodName is " + this.val$methodName + "replaceMethodParams afterHookedMethod");
  }
  
  public void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    HookLog.d("methodName is " + this.val$methodName + "replaceMethodParams beforeHookedMethod");
    paramMethodHookParam.args = this.val$args;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.assistant.qa.hook.GalileoHookUtil.2
 * JD-Core Version:    0.7.0.1
 */