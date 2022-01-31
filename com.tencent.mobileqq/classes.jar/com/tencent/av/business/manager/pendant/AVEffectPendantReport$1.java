package com.tencent.av.business.manager.pendant;

import java.util.ArrayList;
import java.util.Iterator;
import lek;
import lkp;

public final class AVEffectPendantReport$1
  implements Runnable
{
  public void run()
  {
    if ((lkp.a() == null) || (lkp.a().isEmpty()))
    {
      lkp.d();
      return;
    }
    lkp.a(0);
    lkp.b(0);
    Iterator localIterator = lkp.a().iterator();
    while (localIterator.hasNext())
    {
      PendantItem localPendantItem = (PendantItem)localIterator.next();
      lkp.a();
      if (lkp.a(localPendantItem)) {
        lkp.b();
      }
    }
    lek.c("AVEffectPendantReport", "refleshAndSetDownloadInfo()  mTotalCount = " + lkp.c() + "  mDownloadCount = " + lkp.d());
    lkp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.AVEffectPendantReport.1
 * JD-Core Version:    0.7.0.1
 */