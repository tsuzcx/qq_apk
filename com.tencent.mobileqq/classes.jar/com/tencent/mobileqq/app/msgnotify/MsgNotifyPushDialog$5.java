package com.tencent.mobileqq.app.msgnotify;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class MsgNotifyPushDialog$5
  extends DownloadListener
{
  MsgNotifyPushDialog$5(String paramString) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    MsgNotifyPushDialog.i = null;
    QLog.d(MsgNotifyPushDialog.a, 1, "downloadZipFile cancel");
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    MsgNotifyPushDialog.i = null;
    if (paramDownloadTask.e() == 3)
    {
      paramDownloadTask = MsgNotifyPushDialog.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download finished ");
      localStringBuilder.append(MsgNotifyPushDialog.h);
      QLog.d(paramDownloadTask, 1, localStringBuilder.toString());
      paramDownloadTask = new File(this.a);
      if ((paramDownloadTask.exists()) && (MsgNotifyPushDialog.a(paramDownloadTask))) {
        QLog.d(MsgNotifyPushDialog.a, 1, "downloadZipFile suc and zip succ");
      }
    }
    else
    {
      QLog.d(MsgNotifyPushDialog.a, 1, new Object[] { "downloadZipFile failed: ", paramDownloadTask.d, " code=", Integer.valueOf(paramDownloadTask.c) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog.5
 * JD-Core Version:    0.7.0.1
 */