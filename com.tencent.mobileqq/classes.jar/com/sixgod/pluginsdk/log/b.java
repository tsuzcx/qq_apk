package com.sixgod.pluginsdk.log;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class b
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (SixGodReporter.sReportImpl != null))
    {
      paramContext = paramIntent.getSerializableExtra("report_info");
      if ((paramContext instanceof a))
      {
        SGLog.a("SixGod_PluginSdk.report", "onReceive");
        paramContext = (a)paramContext;
        SixGodReporter.sReportImpl.report(paramContext.a, paramContext.b, paramContext.c, paramContext.d, paramContext.e, paramContext.f, paramContext.g, paramContext.h, paramContext.i, paramContext.j, paramContext.k);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.log.b
 * JD-Core Version:    0.7.0.1
 */