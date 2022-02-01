package com.tencent.mobileqq.ark.debug;

import com.tencent.ark.ArkDebugger;
import com.tencent.mobileqq.ark.api.INativeLibLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

final class JSDebuggerSoLoader$2
  implements Runnable
{
  JSDebuggerSoLoader$2(String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setJSDebuggerLibPathForArk: ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(this.b);
    QLog.i("JSDebuggerSoLoader", 2, ((StringBuilder)localObject).toString());
    localObject = (INativeLibLoader)QRoute.api(INativeLibLoader.class);
    if (!((INativeLibLoader)localObject).isArkLibraryLoaded()) {
      ((INativeLibLoader)localObject).loadArkLibrary();
    }
    ArkDebugger.SetJSLibraryPath(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader.2
 * JD-Core Version:    0.7.0.1
 */