package com.tencent.mobileqq.ark.debug;

import android.text.TextUtils;

final class JSDebuggerSoLoader$3
  implements Runnable
{
  public void run()
  {
    if (JSDebuggerSoLoader.a() == 0)
    {
      JSDebuggerSoLoader.a(JSDebuggerSoLoader.a());
      JSDebuggerSoLoader.a();
      JSDebuggerSoLoader.a();
    }
    String str;
    do
    {
      do
      {
        return;
        if (JSDebuggerSoLoader.a() == 1)
        {
          JSDebuggerSoLoader.a();
          return;
        }
      } while (JSDebuggerSoLoader.a() != 2);
      JSDebuggerSoLoader.a();
      str = JSDebuggerSoLoader.a();
    } while (TextUtils.isEmpty(str));
    JSDebuggerSoLoader.a(str, "libarkDebuggerJSImpl.so");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader.3
 * JD-Core Version:    0.7.0.1
 */