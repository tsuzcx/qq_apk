package com.tencent.av.business.manager.pendant;

import java.util.ArrayList;
import java.util.Iterator;
import lbc;
import lhj;

public final class AVEffectPendantReport$1
  implements Runnable
{
  public void run()
  {
    if ((lhj.a() == null) || (lhj.a().isEmpty()))
    {
      lhj.d();
      return;
    }
    lhj.a(0);
    lhj.b(0);
    Iterator localIterator = lhj.a().iterator();
    while (localIterator.hasNext())
    {
      PendantItem localPendantItem = (PendantItem)localIterator.next();
      lhj.a();
      if (lhj.a(localPendantItem)) {
        lhj.b();
      }
    }
    lbc.c("AVEffectPendantReport", "refleshAndSetDownloadInfo()  mTotalCount = " + lhj.c() + "  mDownloadCount = " + lhj.d());
    lhj.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.AVEffectPendantReport.1
 * JD-Core Version:    0.7.0.1
 */