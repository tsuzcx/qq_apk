package com.tencent.mobileqq.ark.debug;

import alvg;
import android.text.TextUtils;

public final class JSDebuggerSoLoader$3
  implements Runnable
{
  public void run()
  {
    if (alvg.a() == 0)
    {
      alvg.a(alvg.a());
      alvg.a();
      alvg.a();
    }
    String str;
    do
    {
      do
      {
        return;
        if (alvg.a() == 1)
        {
          alvg.a();
          return;
        }
      } while (alvg.a() != 2);
      alvg.a();
      str = alvg.a();
    } while (TextUtils.isEmpty(str));
    alvg.a(str, "libarkDebuggerJSImpl.so");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader.3
 * JD-Core Version:    0.7.0.1
 */