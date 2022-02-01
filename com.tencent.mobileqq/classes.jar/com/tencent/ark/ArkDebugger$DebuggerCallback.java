package com.tencent.ark;

public abstract interface ArkDebugger$DebuggerCallback
{
  public abstract void Accepted();
  
  public abstract boolean ReadyToRun(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void ReceivedPackage(String paramString1, String paramString2);
  
  public abstract void Stopped(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkDebugger.DebuggerCallback
 * JD-Core Version:    0.7.0.1
 */