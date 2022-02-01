package com.tencent.aelight.camera.aioeditor.capture.text;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class DynamicTextConfigManager$DynamicTextResDownloader$1
  implements INetEngineListener
{
  DynamicTextConfigManager$DynamicTextResDownloader$1(DynamicTextConfigManager.DynamicTextResDownloader paramDynamicTextResDownloader) {}
  
  public void onResp(NetResp arg1)
  {
    DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo localDynamicTextFontInfo = (DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)???.mReq.getUserData();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onResp, url is: ");
      ((StringBuilder)localObject2).append(localDynamicTextFontInfo.a);
      ((StringBuilder)localObject2).append(" http status: ");
      ((StringBuilder)localObject2).append(???.mHttpCode);
      QLog.i("DText", 2, ((StringBuilder)localObject2).toString());
    }
    DynamicTextConfigManager.DynamicTextResDownloader.a(this.a, localDynamicTextFontInfo);
    boolean bool;
    if ((DynamicTextConfigManager.DynamicTextResDownloader.a(this.a).c(localDynamicTextFontInfo)) && (DynamicTextConfigManager.DynamicTextResDownloader.a(this.a).b(localDynamicTextFontInfo))) {
      bool = true;
    } else {
      bool = false;
    }
    int i;
    synchronized (DynamicTextConfigManager.DynamicTextResDownloader.b(this.a))
    {
      localObject2 = (ArrayList)DynamicTextConfigManager.DynamicTextResDownloader.b(this.a).remove(localDynamicTextFontInfo.a);
      i = ((ArrayList)localObject2).size() - 1;
      if (i >= 0)
      {
        WeakReference localWeakReference = (WeakReference)((ArrayList)localObject2).get(i);
        if (localWeakReference.get() != null) {
          ((DynamicTextConfigManager.IDynamicTextResDownloadCallback)localWeakReference.get()).a(bool, localDynamicTextFontInfo.a);
        }
      }
      else
      {
        return;
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)paramNetReq.getUserData();
    synchronized (DynamicTextConfigManager.DynamicTextResDownloader.b(this.a))
    {
      Iterator localIterator = ((ArrayList)DynamicTextConfigManager.DynamicTextResDownloader.b(this.a).get(paramNetReq.a)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((DynamicTextConfigManager.IDynamicTextResDownloadCallback)localWeakReference.get()).a((float)(100L * paramLong1 / paramLong2), paramNetReq.a, paramNetReq.d);
        }
      }
      float f = (float)paramLong1 * 100.0F / (float)paramLong2;
      paramNetReq.e = ((int)f);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("onResDownloadProgressUpdate url: ");
        ((StringBuilder)???).append(paramNetReq.a);
        ((StringBuilder)???).append(" progress: ");
        ((StringBuilder)???).append(f);
        ((StringBuilder)???).append(" curOffset: ");
        ((StringBuilder)???).append(paramLong1);
        ((StringBuilder)???).append(" totalLen: ");
        ((StringBuilder)???).append(paramLong2);
        QLog.i("DText", 2, ((StringBuilder)???).toString());
      }
      return;
    }
    for (;;)
    {
      throw paramNetReq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.DynamicTextResDownloader.1
 * JD-Core Version:    0.7.0.1
 */