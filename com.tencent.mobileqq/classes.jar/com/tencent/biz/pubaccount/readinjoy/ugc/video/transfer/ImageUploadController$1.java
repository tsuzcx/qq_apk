package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

class ImageUploadController$1
  extends TransProcessorHandler
{
  ImageUploadController$1(ImageUploadController paramImageUploadController) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.fileType != 24) || (localFileMsg.commandId != 10)) {}
    while ((localFileMsg.uniseq != this.a.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mUniseq) || (TextUtils.equals(localFileMsg.fileMd5, ImageUploadController.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1002: 
    case 1004: 
    default: 
      return;
    case 1001: 
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController$FileUploadListener != null) {
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController$FileUploadListener.a();
      }
      ImageUploadController.a(this.a, System.currentTimeMillis());
      return;
    case 1003: 
      ImageUploadController.b(this.a, System.currentTimeMillis());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 0, String.valueOf(ImageUploadController.a(this.a)), String.valueOf(ImageUploadController.b(this.a)), String.valueOf(ImageUploadController.a(this.a) - ImageUploadController.b(this.a)), String.valueOf(ImageUploadController.c(this.a) - ImageUploadController.d(this.a)));
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send finished!");
      }
      ImageUploadController.a(this.a, localFileMsg.fileMd5);
      ImageUploadController.b(this.a, localFileMsg.fileUrl);
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler mImageMd5=" + ImageUploadController.a(this.a) + ", mImageUrl=" + ImageUploadController.b(this.a));
      }
      ImageUploadController.a(this.a, 0, ImageUploadController.b(this.a), ImageUploadController.a(this.a), null);
      return;
    }
    ImageUploadController.b(this.a, System.currentTimeMillis());
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 1, String.valueOf(ImageUploadController.a(this.a)), String.valueOf(ImageUploadController.b(this.a)), String.valueOf(ImageUploadController.a(this.a) - ImageUploadController.b(this.a)), String.valueOf(ImageUploadController.c(this.a) - ImageUploadController.d(this.a)));
    if (QLog.isColorLevel()) {
      QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send error:" + localFileMsg.errorCode);
    }
    ImageUploadController.a(this.a, 1004, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.ImageUploadController.1
 * JD-Core Version:    0.7.0.1
 */