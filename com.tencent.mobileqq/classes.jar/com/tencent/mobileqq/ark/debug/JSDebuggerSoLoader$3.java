package com.tencent.mobileqq.ark.debug;

import algs;
import android.text.TextUtils;

public final class JSDebuggerSoLoader$3
  implements Runnable
{
  public void run()
  {
    if (algs.a() == 0)
    {
      algs.a(algs.a());
      algs.a();
      algs.a();
    }
    String str;
    do
    {
      do
      {
        return;
        if (algs.a() == 1)
        {
          algs.a();
          return;
        }
      } while (algs.a() != 2);
      algs.a();
      str = algs.a();
    } while (TextUtils.isEmpty(str));
    algs.a(str, "libarkDebuggerJSImpl.so");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader.3
 * JD-Core Version:    0.7.0.1
 */