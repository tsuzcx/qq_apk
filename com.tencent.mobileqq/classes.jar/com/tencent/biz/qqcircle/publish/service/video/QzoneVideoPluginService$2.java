package com.tencent.biz.qqcircle.publish.service.video;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;
import com.tencent.qphone.base.util.QLog;

final class QzoneVideoPluginService$2
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    Object localObject = paramMessage.getData().getString("source_path");
    String str = paramMessage.getData().getString("client_key");
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i == 2) {
        return;
      }
      if (i != 3) {
        if (i != 1004) {
          if (i == 1005) {}
        }
      }
    }
    StringBuilder localStringBuilder;
    switch (i)
    {
    default: 
    case 1001: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TrimVideo Fail. client_key=");
      localStringBuilder.append(str);
      localStringBuilder.append(" source_path=");
      localStringBuilder.append((String)localObject);
      QLog.i("[upload2][compress]", 1, localStringBuilder.toString());
      QCircleHostQzoneThreadHelper.removeBackGroundThreadTask(QzoneVideoPluginService.h());
      paramMessage = paramMessage.getData().getString("report_msg");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(QzoneVideoPluginService.i());
      localStringBuilder.append(paramMessage);
      QzoneVideoPluginService.a(false, (String)localObject, "", localStringBuilder.toString(), str);
      return;
    case 1000: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TrimVideo Success. client_key=");
      localStringBuilder.append(str);
      localStringBuilder.append(" source_path=");
      localStringBuilder.append((String)localObject);
      QLog.i("[upload2][compress]", 1, localStringBuilder.toString());
      QCircleHostQzoneThreadHelper.removeBackGroundThreadTask(QzoneVideoPluginService.h());
      QzoneVideoPluginService.a(true, (String)localObject, paramMessage.getData().getString("target_file"), QzoneVideoPluginService.j(), str);
      return;
      if (paramMessage.obj != null)
      {
        if (!(paramMessage.obj instanceof String)) {
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("video_dest_file", (String)paramMessage.obj);
        paramMessage = Message.obtain();
        paramMessage.what = 1002;
        paramMessage.obj = localObject;
        try
        {
          QzoneVideoPluginService.k().send(paramMessage);
          return;
        }
        catch (Exception paramMessage)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("DEST_FILE_PATH sendMessageToClient");
          ((StringBuilder)localObject).append(paramMessage.getMessage());
          QLog.e("[upload2][compress]", 1, ((StringBuilder)localObject).toString());
          return;
        }
      }
      return;
      QCircleHostQzoneThreadHelper.postBackGoundThreadDelayed(QzoneVideoPluginService.h(), 5000L);
      return;
      i = paramMessage.arg1;
      paramMessage = new StringBuilder();
      paramMessage.append("BuildVideo Progress：");
      paramMessage.append(i);
      paramMessage.append("client_key=");
      paramMessage.append(str);
      paramMessage.append(" source_path=");
      paramMessage.append((String)localObject);
      QLog.i("[upload2][compress]", 1, paramMessage.toString());
      return;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("BuildVideo Begin. client_key=");
      localStringBuilder.append(str);
      localStringBuilder.append(" source_path=");
      localStringBuilder.append((String)localObject);
      QLog.i("[upload2][compress]", 1, localStringBuilder.toString());
      QzoneVideoPluginService.a(paramMessage, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.service.video.QzoneVideoPluginService.2
 * JD-Core Version:    0.7.0.1
 */