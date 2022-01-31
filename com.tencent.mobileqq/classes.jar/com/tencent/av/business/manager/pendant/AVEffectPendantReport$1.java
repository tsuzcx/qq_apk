package com.tencent.av.business.manager.pendant;

import java.util.ArrayList;
import java.util.Iterator;
import lcg;
import lim;

public final class AVEffectPendantReport$1
  implements Runnable
{
  public void run()
  {
    if ((lim.a() == null) || (lim.a().isEmpty()))
    {
      lim.d();
      return;
    }
    lim.a(0);
    lim.b(0);
    Iterator localIterator = lim.a().iterator();
    while (localIterator.hasNext())
    {
      PendantItem localPendantItem = (PendantItem)localIterator.next();
      lim.a();
      if (lim.a(localPendantItem)) {
        lim.b();
      }
    }
    lcg.c("AVEffectPendantReport", "refleshAndSetDownloadInfo()  mTotalCount = " + lim.c() + "  mDownloadCount = " + lim.d());
    lim.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.AVEffectPendantReport.1
 * JD-Core Version:    0.7.0.1
 */