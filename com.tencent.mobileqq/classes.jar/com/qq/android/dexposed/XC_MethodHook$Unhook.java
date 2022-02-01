package com.qq.android.dexposed;

import com.qq.android.dexposed.callbacks.IXUnhook;
import java.lang.reflect.Member;

public class XC_MethodHook$Unhook
  implements IXUnhook
{
  private final Member hookMethod;
  
  public XC_MethodHook$Unhook(XC_MethodHook paramXC_MethodHook, Member paramMember)
  {
    this.hookMethod = paramMember;
  }
  
  public XC_MethodHook getCallback()
  {
    return this.this$0;
  }
  
  public Member getHookedMethod()
  {
    return this.hookMethod;
  }
  
  public void unhook()
  {
    DexposedBridge.unhookMethod(this.hookMethod, this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.XC_MethodHook.Unhook
 * JD-Core Version:    0.7.0.1
 */