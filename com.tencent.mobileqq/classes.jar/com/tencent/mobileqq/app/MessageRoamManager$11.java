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
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "onDone status: " + paramDownloadTask.f + ", url: " + paramDownloadTask.a);
    }
    int i = paramDownloadTask.a.indexOf("?");
    String str;
    if (i == -1)
    {
      str = paramDownloadTask.a;
      if (!MessageRoamConstants.a.contains(str)) {
        break label105;
      }
      this.a.a(paramDownloadTask);
    }
    label105:
    do
    {
      return;
      str = paramDownloadTask.a.substring(0, i - 1);
      break;
      if ("https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json".equals(str))
      {
        this.a.b(paramDownloadTask);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.roammsg.MessageRoamManager", 2, "onDone unkonw url: " + paramDownloadTask.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.11
 * JD-Core Version:    0.7.0.1
 */