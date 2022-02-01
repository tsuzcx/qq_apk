package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import android.os.Message;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

class VideoUploadController$2
  extends TransProcessorHandler
{
  VideoUploadController$2(VideoUploadController paramVideoUploadController) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.fileType != 24) || (localFileMsg.commandId != 54)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((VideoUploadController.a(this.a) == null) || (VideoUploadController.a(this.a).mUniseq != localFileMsg.uniseq));
        switch (paramMessage.what)
        {
        case 1004: 
        default: 
          return;
        case 1001: 
          VideoUploadController.a(this.a, System.currentTimeMillis());
        }
      } while (this.a.a == null);
      this.a.a.a();
      return;
    } while (this.a.a == null);
    this.a.a.a(localFileMsg.transferedSize, localFileMsg.fileSize);
    return;
    this.a.a(localFileMsg);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send error:" + localFileMsg.errorCode);
    }
    VideoUploadController.a(this.a, 1004, null, null, null);
    VideoUploadController.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.VideoUploadController.2
 * JD-Core Version:    0.7.0.1
 */