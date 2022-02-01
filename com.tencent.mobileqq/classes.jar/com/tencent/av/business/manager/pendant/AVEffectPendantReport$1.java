package com.tencent.av.business.manager.pendant;

import com.tencent.av.AVLog;
import java.util.ArrayList;
import java.util.Iterator;

final class AVEffectPendantReport$1
  implements Runnable
{
  public void run()
  {
    if ((AVEffectPendantReport.a() != null) && (!AVEffectPendantReport.a().isEmpty()))
    {
      AVEffectPendantReport.a(0);
      AVEffectPendantReport.b(0);
      Object localObject = AVEffectPendantReport.a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        PendantItem localPendantItem = (PendantItem)((Iterator)localObject).next();
        AVEffectPendantReport.a();
        if (AVEffectPendantReport.a(localPendantItem)) {
          AVEffectPendantReport.b();
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refleshAndSetDownloadInfo()  mTotalCount = ");
      ((StringBuilder)localObject).append(AVEffectPendantReport.c());
      ((StringBuilder)localObject).append("  mDownloadCount = ");
      ((StringBuilder)localObject).append(AVEffectPendantReport.d());
      AVLog.printColorLog("AVEffectPendantReport", ((StringBuilder)localObject).toString());
      AVEffectPendantReport.a();
      return;
    }
    AVEffectPendantReport.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.AVEffectPendantReport.1
 * JD-Core Version:    0.7.0.1
 */