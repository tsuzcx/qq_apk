package com.tencent.av.business.manager.pendant;

import java.util.ArrayList;
import java.util.Iterator;
import krx;
import kyb;

public final class AVEffectPendantReport$1
  implements Runnable
{
  public void run()
  {
    if ((kyb.a() == null) || (kyb.a().isEmpty()))
    {
      kyb.d();
      return;
    }
    kyb.a(0);
    kyb.b(0);
    Iterator localIterator = kyb.a().iterator();
    while (localIterator.hasNext())
    {
      PendantItem localPendantItem = (PendantItem)localIterator.next();
      kyb.a();
      if (kyb.a(localPendantItem)) {
        kyb.b();
      }
    }
    krx.c("AVEffectPendantReport", "refleshAndSetDownloadInfo()  mTotalCount = " + kyb.c() + "  mDownloadCount = " + kyb.d());
    kyb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.AVEffectPendantReport.1
 * JD-Core Version:    0.7.0.1
 */