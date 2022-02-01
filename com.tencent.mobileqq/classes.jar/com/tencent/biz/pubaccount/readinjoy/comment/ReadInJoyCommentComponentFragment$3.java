package com.tencent.biz.pubaccount.readinjoy.comment;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ReadInJoyCommentComponentFragment$3
  implements Runnable
{
  ReadInJoyCommentComponentFragment$3(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment, String paramString) {}
  
  public void run()
  {
    if (!new File(this.a).exists())
    {
      this.this$0.g();
      this.this$0.a(1, this.this$0.getString(2131718211));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic file not exist, path=" + this.a);
      }
      return;
    }
    ITransFileController localITransFileController = (ITransFileController)ReadInJoyCommentComponentFragment.a(this.this$0).app.getRuntimeService(ITransFileController.class);
    this.this$0.a.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    localITransFileController.addHandle(this.this$0.a);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mCommandId = 10;
    localTransferRequest.mLocalPath = this.a;
    localTransferRequest.mUniseq = ((Math.random() * 1000000.0D));
    localTransferRequest.mPeerUin = "0";
    localTransferRequest.mFileType = 24;
    localTransferRequest.mRichTag = "KandianUGCPicUpload";
    localITransFileController.transferAsync(localTransferRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment.3
 * JD-Core Version:    0.7.0.1
 */