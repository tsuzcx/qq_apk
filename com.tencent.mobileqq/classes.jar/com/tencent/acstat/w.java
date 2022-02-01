package com.tencent.acstat;

import android.content.Context;
import com.tencent.acstat.common.StatLogger;

final class w
  implements Runnable
{
  w(String paramString, Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public final void run()
  {
    String str = this.a;
    if ((str != null) && (str.trim().length() != 0))
    {
      StatServiceImpl.a(this.b, new StatAccount(this.a), this.c);
      return;
    }
    StatServiceImpl.f().w("qq num is null or empty.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.w
 * JD-Core Version:    0.7.0.1
 */