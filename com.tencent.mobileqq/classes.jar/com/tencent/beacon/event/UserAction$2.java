package com.tencent.beacon.event;

import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.event.TunnelModule;

final class UserAction$2
  implements Runnable
{
  public final void run()
  {
    b.b("[core] db events to up on app call", new Object[0]);
    try
    {
      TunnelModule.doUploadAllEventsData();
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.event.UserAction.2
 * JD-Core Version:    0.7.0.1
 */