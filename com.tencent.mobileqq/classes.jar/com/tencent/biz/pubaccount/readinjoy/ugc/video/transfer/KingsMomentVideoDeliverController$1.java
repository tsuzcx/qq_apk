package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import android.os.Message;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

class KingsMomentVideoDeliverController$1
  extends TransProcessorHandler
{
  KingsMomentVideoDeliverController$1(KingsMomentVideoDeliverController paramKingsMomentVideoDeliverController) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.fileType != 24) || (localFileMsg.commandId != 10)) {}
    while ((localFileMsg.uniseq != this.a.a.mUniseq) || (localFileMsg.fileMd5.equals(KingsMomentVideoDeliverController.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1002: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mVideoTransProcessorHandler transfer=" + localFileMsg.transferedSize + ", total=" + localFileMsg.fileSize);
      KingsMomentVideoDeliverController.a(this.a, (float)localFileMsg.transferedSize * 100.0F / (float)localFileMsg.fileSize);
      return;
    case 1003: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler send finished!");
      KingsMomentVideoDeliverController.a(this.a, localFileMsg.fileMd5);
      KingsMomentVideoDeliverController.b(this.a, localFileMsg.fileUrl);
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler mImageMd5=" + KingsMomentVideoDeliverController.a(this.a) + ", mImageUrl=" + KingsMomentVideoDeliverController.b(this.a));
      KingsMomentVideoDeliverController.a(this.a, 0, KingsMomentVideoDeliverController.b(this.a), KingsMomentVideoDeliverController.a(this.a), null, null, null);
      return;
    }
    QLog.d("KingsMomentVideoDeliveControllerr", 1, "upload king moment cover failed");
    KingsMomentVideoDeliverController.a(this.a, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.KingsMomentVideoDeliverController.1
 * JD-Core Version:    0.7.0.1
 */