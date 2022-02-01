package com.tencent.assistant.qa.hook;

import com.taobao.android.dexposed.XC_MethodReplacement;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;

final class GalileoHookUtil$1
  extends XC_MethodReplacement
{
  GalileoHookUtil$1(Object paramObject) {}
  
  public Object replaceHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    return this.val$returnObj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.assistant.qa.hook.GalileoHookUtil.1
 * JD-Core Version:    0.7.0.1
 */