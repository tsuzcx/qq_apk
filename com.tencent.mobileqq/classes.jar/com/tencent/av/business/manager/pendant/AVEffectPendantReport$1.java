package com.tencent.av.business.manager.pendant;

import com.tencent.av.AVLog;
import java.util.ArrayList;
import java.util.Iterator;

final class AVEffectPendantReport$1
  implements Runnable
{
  public void run()
  {
    if ((AVEffectPendantReport.f() != null) && (!AVEffectPendantReport.f().isEmpty()))
    {
      AVEffectPendantReport.a(0);
      AVEffectPendantReport.b(0);
      Object localObject = AVEffectPendantReport.f().iterator();
      while (((Iterator)localObject).hasNext())
      {
        PendantItem localPendantItem = (PendantItem)((Iterator)localObject).next();
        AVEffectPendantReport.g();
        if (AVEffectPendantReport.a(localPendantItem)) {
          AVEffectPendantReport.h();
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refleshAndSetDownloadInfo()  mTotalCount = ");
      ((StringBuilder)localObject).append(AVEffectPendantReport.i());
      ((StringBuilder)localObject).append("  mDownloadCount = ");
      ((StringBuilder)localObject).append(AVEffectPendantReport.j());
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