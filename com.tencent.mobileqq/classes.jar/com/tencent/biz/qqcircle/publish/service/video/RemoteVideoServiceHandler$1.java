package com.tencent.biz.qqcircle.publish.service.video;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.publish.model.ShuoshuoVideoInfo;
import com.tencent.biz.qqcircle.publish.queue.QCircleTaskQueue;
import com.tencent.biz.qqcircle.publish.task.IQueueTask;
import com.tencent.biz.qqcircle.publish.task.compress.VideoCompressEngine;
import com.tencent.biz.qqcircle.publish.task.compress.VideoCompressTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class RemoteVideoServiceHandler$1
  extends Handler
{
  RemoteVideoServiceHandler$1(RemoteVideoServiceHandler paramRemoteVideoServiceHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("RemoteVideoServiceHandler handleMessage, what=");
    ((StringBuilder)localObject1).append(paramMessage.what);
    QLog.i("[QcirclePublish]RemoteVideoServiceHandler", 1, ((StringBuilder)localObject1).toString());
    int i = paramMessage.what;
    localObject1 = "";
    String str;
    VideoCompressTask localVideoCompressTask;
    Object localObject2;
    switch (i)
    {
    default: 
    case 1003: 
      str = ((Intent)paramMessage.obj).getStringExtra("client_key");
      if (!TextUtils.isEmpty(str))
      {
        localVideoCompressTask = VideoCompressEngine.a().a(str);
        if (localVideoCompressTask != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("RemoteVideoServiceHandler start compress video, video path:");
          paramMessage = (Message)localObject1;
          if (localVideoCompressTask.a != null)
          {
            paramMessage = (Message)localObject1;
            if (localVideoCompressTask.a.b != null) {
              paramMessage = localVideoCompressTask.a.b;
            }
          }
          ((StringBuilder)localObject2).append(paramMessage);
          QLog.i("[QcirclePublish]RemoteVideoServiceHandler", 1, ((StringBuilder)localObject2).toString());
          VideoCompressEngine.a().b(str);
          return;
        }
      }
      break;
    case 1002: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Intent)))
      {
        paramMessage = (Intent)paramMessage.obj;
        RemoteVideoServiceHandler.a(this.a, paramMessage.getStringExtra("video_dest_file"));
        return;
      }
      QLog.w("[QcirclePublish]RemoteVideoServiceHandler", 1, "RemoteVideoServiceHandler handleMessage 1002, message.obj is not valid");
      return;
    case 1000: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Intent)))
      {
        RemoteVideoServiceHandler.a(this.a, null);
        localObject2 = (Intent)paramMessage.obj;
        str = ((Intent)localObject2).getStringExtra("client_key");
        paramMessage = new StringBuilder();
        paramMessage.append("clientKey=");
        paramMessage.append(str);
        QLog.i("[QcirclePublish]RemoteVideoServiceHandler", 1, paramMessage.toString());
        if (!TextUtils.isEmpty(str))
        {
          paramMessage = QCircleTaskQueue.a().a(str);
          localVideoCompressTask = VideoCompressEngine.a().a(str);
          if ((paramMessage != null) && (RemoteVideoServiceHandler.a(this.a).contains(paramMessage.i())))
          {
            this.a.b(paramMessage.i());
            return;
          }
          if (localVideoCompressTask != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("RemoteVideoServiceHandler compress video finish, video path:");
            paramMessage = (Message)localObject1;
            if (localVideoCompressTask.a != null)
            {
              paramMessage = (Message)localObject1;
              if (localVideoCompressTask.a.b != null) {
                paramMessage = localVideoCompressTask.a.b;
              }
            }
            localStringBuilder.append(paramMessage);
            QLog.i("[QcirclePublish]RemoteVideoServiceHandler", 1, localStringBuilder.toString());
            VideoCompressEngine.a().a(str, (Intent)localObject2);
            return;
          }
          paramMessage = new StringBuilder();
          paramMessage.append("RemoteVideoServiceHandler handleMessage, clientkey not in sessions, clientkey=");
          paramMessage.append(str);
          QLog.w("[QcirclePublish]RemoteVideoServiceHandler", 1, paramMessage.toString());
          return;
        }
        paramMessage = new StringBuilder();
        paramMessage.append("RemoteVideoServiceHandler handleMessage, clientkey not in sessions, clientkey=");
        paramMessage.append(str);
        QLog.w("[QcirclePublish]RemoteVideoServiceHandler", 1, paramMessage.toString());
        return;
      }
      QLog.w("[QcirclePublish]RemoteVideoServiceHandler", 1, "RemoteVideoServiceHandler handleMessage 1000, message.obj is not valid");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.service.video.RemoteVideoServiceHandler.1
 * JD-Core Version:    0.7.0.1
 */