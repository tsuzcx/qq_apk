package com.tencent.acstat;

import android.content.Context;
import com.tencent.acstat.common.StatLogger;

final class p
  implements Runnable
{
  p(Context paramContext, int paramInt) {}
  
  public final void run()
  {
    try
    {
      StatServiceImpl.flushDataToDB(this.a);
      af.a(this.a).a(this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.acstat.p
 * JD-Core Version:    0.7.0.1
 */