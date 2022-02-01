package com.tencent.mobileqq.ark.debug;

import android.text.TextUtils;

final class JSDebuggerSoLoader$3
  implements Runnable
{
  public void run()
  {
    if (JSDebuggerSoLoader.c() == 0)
    {
      JSDebuggerSoLoader.a(JSDebuggerSoLoader.a());
      JSDebuggerSoLoader.d();
      JSDebuggerSoLoader.e();
      return;
    }
    if (JSDebuggerSoLoader.c() == 1)
    {
      JSDebuggerSoLoader.e();
      return;
    }
    if (JSDebuggerSoLoader.c() == 2)
    {
      JSDebuggerSoLoader.e();
      String str = JSDebuggerSoLoader.a();
      if (!TextUtils.isEmpty(str)) {
        JSDebuggerSoLoader.a(str, "libarkDebuggerJSImpl.so");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader.3
 * JD-Core Version:    0.7.0.1
 */