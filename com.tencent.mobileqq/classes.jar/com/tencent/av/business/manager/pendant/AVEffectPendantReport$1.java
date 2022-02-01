package com.tencent.av.business.manager.pendant;

import java.util.ArrayList;
import java.util.Iterator;
import lba;
import lhl;

public final class AVEffectPendantReport$1
  implements Runnable
{
  public void run()
  {
    if ((lhl.a() == null) || (lhl.a().isEmpty()))
    {
      lhl.d();
      return;
    }
    lhl.a(0);
    lhl.b(0);
    Iterator localIterator = lhl.a().iterator();
    while (localIterator.hasNext())
    {
      PendantItem localPendantItem = (PendantItem)localIterator.next();
      lhl.a();
      if (lhl.a(localPendantItem)) {
        lhl.b();
      }
    }
    lba.f("AVEffectPendantReport", "refleshAndSetDownloadInfo()  mTotalCount = " + lhl.c() + "  mDownloadCount = " + lhl.d());
    lhl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.AVEffectPendantReport.1
 * JD-Core Version:    0.7.0.1
 */