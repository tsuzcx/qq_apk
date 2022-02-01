package com.tencent.av.business.manager.pendant;

import java.util.ArrayList;
import java.util.Iterator;
import lbj;
import lhr;

public final class AVEffectPendantReport$1
  implements Runnable
{
  public void run()
  {
    if ((lhr.a() == null) || (lhr.a().isEmpty()))
    {
      lhr.d();
      return;
    }
    lhr.a(0);
    lhr.b(0);
    Iterator localIterator = lhr.a().iterator();
    while (localIterator.hasNext())
    {
      PendantItem localPendantItem = (PendantItem)localIterator.next();
      lhr.a();
      if (lhr.a(localPendantItem)) {
        lhr.b();
      }
    }
    lbj.c("AVEffectPendantReport", "refleshAndSetDownloadInfo()  mTotalCount = " + lhr.c() + "  mDownloadCount = " + lhr.d());
    lhr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.AVEffectPendantReport.1
 * JD-Core Version:    0.7.0.1
 */