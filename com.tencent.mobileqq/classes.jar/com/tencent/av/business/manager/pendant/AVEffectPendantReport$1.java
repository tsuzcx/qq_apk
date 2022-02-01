package com.tencent.av.business.manager.pendant;

import com.tencent.av.AVLog;
import java.util.ArrayList;
import java.util.Iterator;

final class AVEffectPendantReport$1
  implements Runnable
{
  public void run()
  {
    if ((AVEffectPendantReport.a() == null) || (AVEffectPendantReport.a().isEmpty()))
    {
      AVEffectPendantReport.d();
      return;
    }
    AVEffectPendantReport.a(0);
    AVEffectPendantReport.b(0);
    Iterator localIterator = AVEffectPendantReport.a().iterator();
    while (localIterator.hasNext())
    {
      PendantItem localPendantItem = (PendantItem)localIterator.next();
      AVEffectPendantReport.a();
      if (AVEffectPendantReport.a(localPendantItem)) {
        AVEffectPendantReport.b();
      }
    }
    AVLog.printColorLog("AVEffectPendantReport", "refleshAndSetDownloadInfo()  mTotalCount = " + AVEffectPendantReport.c() + "  mDownloadCount = " + AVEffectPendantReport.d());
    AVEffectPendantReport.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.AVEffectPendantReport.1
 * JD-Core Version:    0.7.0.1
 */