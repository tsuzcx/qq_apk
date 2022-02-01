package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import android.util.Log;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class c
{
  public void a(Context paramContext, c.a parama)
  {
    if ((!com.huawei.updatesdk.service.e.c.c(paramContext)) || (!h.a().d()))
    {
      parama.a(Boolean.valueOf(false));
      return;
    }
    paramContext = new c.b(parama);
    paramContext.executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
    try
    {
      paramContext.get(500L, TimeUnit.MILLISECONDS);
      return;
    }
    catch (Exception localException)
    {
      paramContext.cancel(true);
      Log.e("AutoUpdateUtil", "init AutoUpdateInfo error: " + localException.toString());
      parama.a(Boolean.valueOf(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.c
 * JD-Core Version:    0.7.0.1
 */