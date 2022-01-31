package com.tencent.mobileqq.ark.debug;

import alvf;
import android.text.TextUtils;

public final class JSDebuggerSoLoader$3
  implements Runnable
{
  public void run()
  {
    if (alvf.a() == 0)
    {
      alvf.a(alvf.a());
      alvf.a();
      alvf.a();
    }
    String str;
    do
    {
      do
      {
        return;
        if (alvf.a() == 1)
        {
          alvf.a();
          return;
        }
      } while (alvf.a() != 2);
      alvf.a();
      str = alvf.a();
    } while (TextUtils.isEmpty(str));
    alvf.a(str, "libarkDebuggerJSImpl.so");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader.3
 * JD-Core Version:    0.7.0.1
 */