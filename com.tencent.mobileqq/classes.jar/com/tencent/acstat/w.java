package com.tencent.acstat;

import android.content.Context;
import com.tencent.acstat.common.StatLogger;

final class w
  implements Runnable
{
  w(String paramString, Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public final void run()
  {
    if ((this.a == null) || (this.a.trim().length() == 0))
    {
      StatServiceImpl.f().w("qq num is null or empty.");
      return;
    }
    StatServiceImpl.a(this.b, new StatAccount(this.a), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.w
 * JD-Core Version:    0.7.0.1
 */