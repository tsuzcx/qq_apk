package com.tencent.mobileqq.app;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class MessageRoamManager$11
  extends DownloadListener
{
  MessageRoamManager$11(MessageRoamManager paramMessageRoamManager) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDone status: ");
      ((StringBuilder)localObject).append(paramDownloadTask.f);
      ((StringBuilder)localObject).append(", url: ");
      ((StringBuilder)localObject).append(paramDownloadTask.a);
      QLog.d("Q.roammsg.MessageRoamManager", 2, ((StringBuilder)localObject).toString());
    }
    int i = paramDownloadTask.a.indexOf("?");
    if (i == -1) {
      localObject = paramDownloadTask.a;
    } else {
      localObject = paramDownloadTask.a.substring(0, i - 1);
    }
    if (MessageRoamConstants.a.contains((CharSequence)localObject))
    {
      this.a.a(paramDownloadTask);
      return;
    }
    if ("https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json".equals(localObject))
    {
      this.a.b(paramDownloadTask);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDone unkonw url: ");
      ((StringBuilder)localObject).append(paramDownloadTask.a);
      QLog.e("Q.roammsg.MessageRoamManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.11
 * JD-Core Version:    0.7.0.1
 */