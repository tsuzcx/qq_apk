package com.tencent.mobileqq.ark.debug;

import com.tencent.ark.ArkDebugger;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;

public final class JSDebuggerSoLoader$2
  implements Runnable
{
  public JSDebuggerSoLoader$2(String paramString1, String paramString2) {}
  
  public void run()
  {
    QLog.i("JSDebuggerSoLoader", 2, "setJSDebuggerLibPathForArk: " + this.a + "," + this.b);
    ArkAppCenter.b(true);
    ArkDebugger.SetJSLibraryPath(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader.2
 * JD-Core Version:    0.7.0.1
 */