package com.tencent.acstat;

import android.content.Context;
import com.tencent.acstat.common.StatLogger;

final class v
  implements Runnable
{
  v(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public final void run()
  {
    try
    {
      StatServiceImpl.stopSession();
      StatServiceImpl.a(this.a, true, this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.acstat.v
 * JD-Core Version:    0.7.0.1
 */