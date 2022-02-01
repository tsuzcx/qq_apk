package com.tencent.biz.pubaccount.ecshopassit;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class EcShopAssistantManager$EcShopAssistantDownloadListener
  extends DownloadListener
{
  private WeakReference<EcShopAssistantManager> a;
  
  EcShopAssistantManager$EcShopAssistantDownloadListener(EcShopAssistantManager paramEcShopAssistantManager)
  {
    this.a = new WeakReference(paramEcShopAssistantManager);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (EcShopAssistantManager)((WeakReference)localObject).get();
      if (localObject != null)
      {
        QQAppInterface localQQAppInterface = ((EcShopAssistantManager)localObject).c;
        if ((paramDownloadTask.c == 0) && (localQQAppInterface != null))
        {
          localQQAppInterface.getPreferences().edit().putLong("last_modified_time", paramDownloadTask.I).commit();
          ((EcShopAssistantManager)localObject).d();
        }
        if (QLog.isColorLevel())
        {
          localObject = new File(EcShopAssistantManager.a);
          long l = 0L;
          if (((File)localObject).exists()) {
            l = ((File)localObject).lastModified();
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("download onDone status=");
          ((StringBuilder)localObject).append(paramDownloadTask.e());
          ((StringBuilder)localObject).append(",errCode=");
          ((StringBuilder)localObject).append(paramDownloadTask.c);
          ((StringBuilder)localObject).append(",httpCode=");
          ((StringBuilder)localObject).append(paramDownloadTask.H);
          ((StringBuilder)localObject).append(",local lastModify=");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append(",server lastModify=");
          ((StringBuilder)localObject).append(paramDownloadTask.I);
          QLog.d("EcShopAssistantManager", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.EcShopAssistantDownloadListener
 * JD-Core Version:    0.7.0.1
 */