package com.tencent.av.business.manager.pendant;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class EffectPendantTools$1
  implements Runnable
{
  EffectPendantTools$1(EffectPendantTools paramEffectPendantTools, File paramFile, PendantItem paramPendantItem) {}
  
  public void run()
  {
    try
    {
      ZipUtils.unZipFile(this.a, this.this$0.b(this.b));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTools.1
 * JD-Core Version:    0.7.0.1
 */