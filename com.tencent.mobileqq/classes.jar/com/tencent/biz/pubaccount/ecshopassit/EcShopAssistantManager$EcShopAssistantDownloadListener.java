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
    if (this.a != null)
    {
      Object localObject = (EcShopAssistantManager)this.a.get();
      if (localObject != null)
      {
        QQAppInterface localQQAppInterface = ((EcShopAssistantManager)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if ((paramDownloadTask.a == 0) && (localQQAppInterface != null))
        {
          localQQAppInterface.getPreferences().edit().putLong("last_modified_time", paramDownloadTask.i).commit();
          ((EcShopAssistantManager)localObject).b();
        }
        if (QLog.isColorLevel())
        {
          localObject = new File(EcShopAssistantManager.jdField_a_of_type_JavaLangString);
          long l = 0L;
          if (((File)localObject).exists()) {
            l = ((File)localObject).lastModified();
          }
          QLog.d("EcShopAssistantManager", 2, "download onDone status=" + paramDownloadTask.a() + ",errCode=" + paramDownloadTask.a + ",httpCode=" + paramDownloadTask.f + ",local lastModify=" + l + ",server lastModify=" + paramDownloadTask.i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.EcShopAssistantDownloadListener
 * JD-Core Version:    0.7.0.1
 */