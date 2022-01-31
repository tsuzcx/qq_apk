package com.tencent.mobileqq.ark.debug;

import android.text.TextUtils;
import anqh;

public final class JSDebuggerSoLoader$3
  implements Runnable
{
  public void run()
  {
    if (anqh.a() == 0)
    {
      anqh.a(anqh.a());
      anqh.a();
      anqh.a();
    }
    String str;
    do
    {
      do
      {
        return;
        if (anqh.a() == 1)
        {
          anqh.a();
          return;
        }
      } while (anqh.a() != 2);
      anqh.a();
      str = anqh.a();
    } while (TextUtils.isEmpty(str));
    anqh.a(str, "libarkDebuggerJSImpl.so");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader.3
 * JD-Core Version:    0.7.0.1
 */