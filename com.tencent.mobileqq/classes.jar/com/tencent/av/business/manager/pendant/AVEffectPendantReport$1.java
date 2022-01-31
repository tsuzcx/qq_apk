package com.tencent.av.business.manager.pendant;

import java.util.ArrayList;
import java.util.Iterator;
import lcl;
import lir;

public final class AVEffectPendantReport$1
  implements Runnable
{
  public void run()
  {
    if ((lir.a() == null) || (lir.a().isEmpty()))
    {
      lir.d();
      return;
    }
    lir.a(0);
    lir.b(0);
    Iterator localIterator = lir.a().iterator();
    while (localIterator.hasNext())
    {
      PendantItem localPendantItem = (PendantItem)localIterator.next();
      lir.a();
      if (lir.a(localPendantItem)) {
        lir.b();
      }
    }
    lcl.c("AVEffectPendantReport", "refleshAndSetDownloadInfo()  mTotalCount = " + lir.c() + "  mDownloadCount = " + lir.d());
    lir.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.AVEffectPendantReport.1
 * JD-Core Version:    0.7.0.1
 */