package com.tencent.mobileqq.apollo.screenshot;

import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ApolloAvatarVideoProcessor$VideoUploadProcessorHandler
  extends TransProcessorHandler
{
  private ApolloAvatarVideoProcessor$VideoUploadProcessorHandler(ApolloAvatarVideoProcessor paramApolloAvatarVideoProcessor) {}
  
  private void a(FileMsg paramFileMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ApolloAvatarVideoProcessor", 2, String.format("handleStatusSendFinished, fileType=%s", new Object[] { Integer.valueOf(paramFileMsg.fileType) }));
    }
    if (paramFileMsg.fileType == 36) {
      ApolloAvatarVideoProcessor.b(this.a);
    }
    for (;;)
    {
      FaceUtil.a(null);
      return;
      if (paramFileMsg.fileType == 37) {
        ApolloAvatarVideoProcessor.c(this.a);
      } else if (paramFileMsg.fileType == 38) {
        ApolloAvatarVideoProcessor.d(this.a);
      } else if (paramFileMsg.fileType == 48) {
        ApolloAvatarVideoProcessor.a(this.a, paramFileMsg);
      }
    }
  }
  
  private void b(FileMsg paramFileMsg)
  {
    QLog.e("ApolloAvatarVideoProcessor", 2, String.format("handleStatusSendError, errorCode=%s", new Object[] { Integer.valueOf(paramFileMsg.errorCode) }));
    FaceUtil.a(null);
    if (ApolloAvatarVideoProcessor.a(this.a) != null) {
      ApolloAvatarVideoProcessor.a(this.a).a(false, ApolloAvatarVideoProcessor.a(this.a));
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (((AppInterface)ApolloAvatarVideoProcessor.a(this.a).get() == null) || (!ApolloAvatarVideoProcessor.a(this.a))) {
      return;
    }
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    QLog.d("ApolloAvatarVideoProcessor", 4, "VideoUploadProcessorHandler.handleMessage fileType=" + localFileMsg.fileType + ", errorCode=" + localFileMsg.errorCode + "， what=" + paramMessage.what);
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1003: 
      a(localFileMsg);
      return;
    }
    b(localFileMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloAvatarVideoProcessor.VideoUploadProcessorHandler
 * JD-Core Version:    0.7.0.1
 */