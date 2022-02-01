package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.SyncLoadTask;
import com.tencent.mobileqq.utils.configsp.ARPromotionConfigSP;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ReadConfigTask
  extends SyncLoadTask
{
  PromotionConfigInfo a;
  final String b;
  WeakReference<AppInterface> c;
  
  ReadConfigTask(String paramString1, String paramString2, AppInterface paramAppInterface)
  {
    super(paramString1);
    this.b = paramString2;
    this.c = new WeakReference(paramAppInterface);
  }
  
  public void innerClean()
  {
    this.a = null;
  }
  
  public boolean runOnSubThread(Resources paramResources)
  {
    this.a = ARPromotionConfigSP.b(this.b, null);
    paramResources = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadConfigTask,ConfigInfo[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    QLog.w(paramResources, 1, localStringBuilder.toString());
    PromotionDevice.c();
    QQAudioHelper.b((AppInterface)this.c.get());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.ReadConfigTask
 * JD-Core Version:    0.7.0.1
 */