package com.tencent.aelight.camera.aioeditor.capture.paster;

import com.tencent.aelight.camera.aioeditor.capture.util.InfoStickerSaveUtils;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class QIMInformationPasterManager$InformationPasterResDownloader$1
  implements INetEngineListener
{
  QIMInformationPasterManager$InformationPasterResDownloader$1(QIMInformationPasterManager.InformationPasterResDownloader paramInformationPasterResDownloader) {}
  
  public void onResp(NetResp paramNetResp)
  {
    InformationFacePackage.Item localItem = (InformationFacePackage.Item)paramNetResp.mReq.getUserData();
    String str = localItem.g;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onResp ,url is :");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(" http status:");
      ((StringBuilder)localObject1).append(paramNetResp.mHttpCode);
      QLog.d("QIMInformationPasterManager", 2, ((StringBuilder)localObject1).toString());
    }
    int i = paramNetResp.mHttpCode;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 200)
    {
      localObject1 = InfoStickerSaveUtils.a(localItem);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("info paster path:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("QIMInformationPasterManager", 1, ((StringBuilder)localObject2).toString());
      localObject2 = FileUtils.calcMd5((String)localObject1);
      if ((localItem.h != null) && (localItem.h.equalsIgnoreCase((String)localObject2)))
      {
        bool1 = QIMInformationPasterManager.InformationPasterResDownloader.a(this.a).c(localItem);
      }
      else
      {
        FileUtils.delete((String)localObject1, false);
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("info paster res md5 error, res md5:");
          ((StringBuilder)localObject1).append(localItem.h);
          ((StringBuilder)localObject1).append(",file md5:");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.d("QIMInformationPasterManager", 2, ((StringBuilder)localObject1).toString());
          bool1 = bool2;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onResp:");
      ((StringBuilder)localObject1).append(paramNetResp.mHttpCode);
      ((StringBuilder)localObject1).append(",isSuccess:");
      ((StringBuilder)localObject1).append(bool1);
      QLog.d("QIMInformationPasterManager", 2, ((StringBuilder)localObject1).toString());
    }
    paramNetResp = ((ArrayList)QIMInformationPasterManager.InformationPasterResDownloader.b(this.a).get(str)).iterator();
    while (paramNetResp.hasNext())
    {
      localObject1 = (WeakReference)paramNetResp.next();
      if (((WeakReference)localObject1).get() != null) {
        ((QIMInformationPasterManager.IInformationPasterResDownloaderCallback)((WeakReference)localObject1).get()).a(bool1, str, localItem);
      }
    }
    QIMInformationPasterManager.InformationPasterResDownloader.b(this.a).remove(str);
  }
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    String str = ((InformationFacePackage.Item)???.getUserData()).g;
    float f = (float)(paramLong1 * 100L / paramLong2);
    synchronized (QIMInformationPasterManager.InformationPasterResDownloader.b(this.a))
    {
      Iterator localIterator = ((ArrayList)QIMInformationPasterManager.InformationPasterResDownloader.b(this.a).get(str)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((QIMInformationPasterManager.IInformationPasterResDownloaderCallback)localWeakReference.get()).a(f, str, 0);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager.InformationPasterResDownloader.1
 * JD-Core Version:    0.7.0.1
 */