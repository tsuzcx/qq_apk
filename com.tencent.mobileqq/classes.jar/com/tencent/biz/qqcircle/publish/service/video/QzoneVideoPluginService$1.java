package com.tencent.biz.qqcircle.publish.service.video;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

final class QzoneVideoPluginService$1
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleMessage, what=");
    ((StringBuilder)localObject).append(paramMessage.what);
    QLog.i("[upload2][compress]", 1, ((StringBuilder)localObject).toString());
    int i = paramMessage.what;
    if (i != 1006)
    {
      int j;
      switch (i)
      {
      default: 
        return;
      case 1003: 
        QzoneVideoPluginService.b(true);
        i = QCircleHostQzoneThreadHelper.getVideoThreadId();
        if (Process.getThreadPriority(i) != 19) {
          Process.setThreadPriority(i, 19);
        }
        j = Process.getThreadPriority(i);
        if (!QLog.isColorLevel()) {
          break;
        }
        paramMessage = new StringBuilder();
        paramMessage.append("SPEED DOWN, tid=");
        paramMessage.append(i);
        paramMessage.append(", priority=");
        paramMessage.append(j);
        paramMessage.append(", TRIM_THREAD_PRORITY=");
        paramMessage.append(TrimVideoThread.a);
        QLog.d("[QcirclePublish]QzoneVideoPluginService", 2, paramMessage.toString());
        return;
      case 1002: 
        QzoneVideoPluginService.b(false);
        i = QCircleHostQzoneThreadHelper.getVideoThreadId();
        j = Process.getThreadPriority(i);
        if (j > TrimVideoThread.a) {
          if (QzoneVideoPluginService.e() <= 80) {
            Process.setThreadPriority(i, TrimVideoThread.a);
          } else if (j > 10) {
            Process.setThreadPriority(i, 10);
          }
        }
        j = Process.getThreadPriority(i);
        if (!QLog.isColorLevel()) {
          break;
        }
        paramMessage = new StringBuilder();
        paramMessage.append("SPEED UP, tid=");
        paramMessage.append(i);
        paramMessage.append(", priority=");
        paramMessage.append(j);
        paramMessage.append(", TRIM_THREAD_PRORITY=");
        paramMessage.append(TrimVideoThread.a);
        QLog.d("[QcirclePublish]QzoneVideoPluginService", 2, paramMessage.toString());
        return;
      case 1001: 
        if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Intent)))
        {
          if (!QzoneVideoPluginService.c())
          {
            QzoneVideoPluginService.a(true);
            QzoneVideoPluginService.a(paramMessage);
            return;
          }
          QLog.i("[upload2][compress]", 1, "other video is processing, add to queue.");
          localObject = new Message();
          ((Message)localObject).obj = paramMessage.obj;
          QzoneVideoPluginService.d().add(localObject);
          return;
        }
        QLog.e("[upload2][compress]", 1, "msg.obj is wrong");
        return;
      case 1000: 
        if (paramMessage.replyTo == null)
        {
          QLog.e("[QcirclePublish]QzoneVideoPluginService", 1, "no client is wrong");
          return;
        }
        QzoneVideoPluginService.a(paramMessage.replyTo);
        return;
      }
    }
    else
    {
      paramMessage = ((Intent)paramMessage.obj).getStringExtra("client_key");
      if (!TextUtils.isEmpty(paramMessage))
      {
        localObject = QzoneVideoPluginService.d().iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramMessage.equals(((Intent)((Message)((Iterator)localObject).next()).obj).getStringExtra("client_key"))) {
            ((Iterator)localObject).remove();
          }
        }
        if (paramMessage.equals(QzoneVideoPluginService.f())) {
          VideoTrimmer.a(paramMessage);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.service.video.QzoneVideoPluginService.1
 * JD-Core Version:    0.7.0.1
 */