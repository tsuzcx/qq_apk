package com.tencent.mobileqq.apollo.screenshot.api.impl;

import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.screenshot.api.IApolloAvatarVideoProcessor.OnProcessFinishListener;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ApolloAvatarVideoProcessorImpl$VideoUploadProcessorHandler
  extends TransProcessorHandler
{
  private ApolloAvatarVideoProcessorImpl$VideoUploadProcessorHandler(ApolloAvatarVideoProcessorImpl paramApolloAvatarVideoProcessorImpl) {}
  
  private void a(FileMsg paramFileMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("[cmshow]ApolloAvatarVideoProcessor", 2, String.format("handleStatusSendFinished, fileType=%s", new Object[] { Integer.valueOf(paramFileMsg.fileType) }));
    }
    if (paramFileMsg.fileType == 36) {
      ApolloAvatarVideoProcessorImpl.access$1900(this.a);
    } else if (paramFileMsg.fileType == 37) {
      ApolloAvatarVideoProcessorImpl.access$2000(this.a);
    } else if (paramFileMsg.fileType == 38) {
      ApolloAvatarVideoProcessorImpl.access$2100(this.a);
    } else if (paramFileMsg.fileType == 48) {
      ApolloAvatarVideoProcessorImpl.access$2200(this.a, paramFileMsg);
    }
    FaceUtil.a(null);
  }
  
  private void b(FileMsg paramFileMsg)
  {
    QLog.e("[cmshow]ApolloAvatarVideoProcessor", 2, String.format("handleStatusSendError, errorCode=%s", new Object[] { Integer.valueOf(paramFileMsg.errorCode) }));
    FaceUtil.a(null);
    if (ApolloAvatarVideoProcessorImpl.access$300(this.a) != null) {
      ApolloAvatarVideoProcessorImpl.access$300(this.a).a(false, ApolloAvatarVideoProcessorImpl.access$400(this.a));
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((AppInterface)ApolloAvatarVideoProcessorImpl.access$1500(this.a).get() != null)
    {
      if (!ApolloAvatarVideoProcessorImpl.access$1800(this.a)) {
        return;
      }
      FileMsg localFileMsg = (FileMsg)paramMessage.obj;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoUploadProcessorHandler.handleMessage fileType=");
      localStringBuilder.append(localFileMsg.fileType);
      localStringBuilder.append(", errorCode=");
      localStringBuilder.append(localFileMsg.errorCode);
      localStringBuilder.append("， what=");
      localStringBuilder.append(paramMessage.what);
      QLog.d("[cmshow]ApolloAvatarVideoProcessor", 4, localStringBuilder.toString());
      int i = paramMessage.what;
      if (i != 1003)
      {
        if (i != 1005) {
          return;
        }
        b(localFileMsg);
        return;
      }
      a(localFileMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.api.impl.ApolloAvatarVideoProcessorImpl.VideoUploadProcessorHandler
 * JD-Core Version:    0.7.0.1
 */