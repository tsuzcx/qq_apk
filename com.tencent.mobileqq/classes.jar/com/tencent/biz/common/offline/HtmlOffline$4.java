package com.tencent.biz.common.offline;

import com.tencent.biz.common.offline.util.ILog;
import java.util.HashMap;
import mqq.app.AppRuntime;

final class HtmlOffline$4
  implements Runnable
{
  HtmlOffline$4(int paramInt, String paramString, AppRuntime paramAppRuntime, HashMap paramHashMap, AsyncBack paramAsyncBack, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (HtmlOffline.f.a())
    {
      ILog localILog = HtmlOffline.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start checkUpThread. delay:");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", businessId:");
      localStringBuilder.append(this.b);
      localILog.a("HtmlCheckUpdate", 2, localStringBuilder.toString());
    }
    int i = this.a;
    long l;
    if (i > 0) {
      l = i * 1000;
    }
    try
    {
      Thread.sleep(l);
      label96:
      HtmlOffline.a(this.c, this.d, this.e, true, this.f, this.g);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label96;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline.4
 * JD-Core Version:    0.7.0.1
 */