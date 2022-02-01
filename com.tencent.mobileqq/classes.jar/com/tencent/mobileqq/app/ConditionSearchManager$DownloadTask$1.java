package com.tencent.mobileqq.app;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import protocol.KQQConfig.GetResourceRespInfo;

class ConditionSearchManager$DownloadTask$1
  implements Runnable
{
  ConditionSearchManager$DownloadTask$1(ConditionSearchManager.DownloadTask paramDownloadTask, String paramString, File paramFile, BaseQQAppInterface paramBaseQQAppInterface, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DownloadTask runnable start, url=");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = MsfSdkUtils.insertMtype("ConfigCheck", this.a);
    int i = HttpDownloadUtil.downloadData(ConditionSearchManager.DownloadTask.a(this.this$0), (String)localObject, this.b);
    boolean bool;
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCheckupConfig | download result = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject).toString());
    }
    localObject = (ConditionSearchManager)this.c.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
    if (localObject != null) {
      ((ConditionSearchManager)localObject).a(i, this.b, this.d);
    }
    localObject = (IPreDownloadController)ConditionSearchManager.DownloadTask.b(this.this$0).getRuntimeService(IPreDownloadController.class);
    String str = this.a;
    long l2 = -1L;
    long l1 = l2;
    if (bool)
    {
      l1 = l2;
      if (this.b.exists()) {
        l1 = this.b.length();
      }
    }
    ((IPreDownloadController)localObject).preDownloadSuccess(str, l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.DownloadTask.1
 * JD-Core Version:    0.7.0.1
 */