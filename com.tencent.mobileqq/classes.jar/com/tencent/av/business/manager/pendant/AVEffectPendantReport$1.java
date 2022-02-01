package com.tencent.av.business.manager.pendant;

import java.util.ArrayList;
import java.util.Iterator;
import lbd;
import lhx;

public final class AVEffectPendantReport$1
  implements Runnable
{
  public void run()
  {
    if ((lhx.a() == null) || (lhx.a().isEmpty()))
    {
      lhx.d();
      return;
    }
    lhx.a(0);
    lhx.b(0);
    Iterator localIterator = lhx.a().iterator();
    while (localIterator.hasNext())
    {
      PendantItem localPendantItem = (PendantItem)localIterator.next();
      lhx.a();
      if (lhx.a(localPendantItem)) {
        lhx.b();
      }
    }
    lbd.f("AVEffectPendantReport", "refleshAndSetDownloadInfo()  mTotalCount = " + lhx.c() + "  mDownloadCount = " + lhx.d());
    lhx.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.AVEffectPendantReport.1
 * JD-Core Version:    0.7.0.1
 */