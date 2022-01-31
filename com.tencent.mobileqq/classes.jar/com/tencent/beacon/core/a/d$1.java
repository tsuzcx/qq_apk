package com.tencent.beacon.core.a;

import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.event.TunnelModule;

final class d$1
  implements Runnable
{
  public final void run()
  {
    b.b("[net] db events to up on netConnectChange", new Object[0]);
    try
    {
      TunnelModule.doUploadRecentCommonData(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.a.d.1
 * JD-Core Version:    0.7.0.1
 */