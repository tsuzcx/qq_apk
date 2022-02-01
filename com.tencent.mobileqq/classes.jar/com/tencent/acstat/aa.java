package com.tencent.acstat;

import android.content.Context;
import com.tencent.acstat.common.StatLogger;
import com.tencent.acstat.event.b;
import com.tencent.acstat.event.c;

final class aa
  implements Runnable
{
  aa(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo, c paramc) {}
  
  public final void run()
  {
    try
    {
      b localb = new b(this.a, StatServiceImpl.a(this.a, false, this.b), this.c.a, this.b);
      localb.b().b = this.c.b;
      new ab(localb).a();
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.aa
 * JD-Core Version:    0.7.0.1
 */