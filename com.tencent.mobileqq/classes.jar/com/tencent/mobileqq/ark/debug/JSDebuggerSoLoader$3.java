package com.tencent.mobileqq.ark.debug;

import android.text.TextUtils;
import aqas;

public final class JSDebuggerSoLoader$3
  implements Runnable
{
  public void run()
  {
    if (aqas.a() == 0)
    {
      aqas.a(aqas.a());
      aqas.a();
      aqas.a();
    }
    String str;
    do
    {
      do
      {
        return;
        if (aqas.a() == 1)
        {
          aqas.a();
          return;
        }
      } while (aqas.a() != 2);
      aqas.a();
      str = aqas.a();
    } while (TextUtils.isEmpty(str));
    aqas.a(str, "libarkDebuggerJSImpl.so");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader.3
 * JD-Core Version:    0.7.0.1
 */