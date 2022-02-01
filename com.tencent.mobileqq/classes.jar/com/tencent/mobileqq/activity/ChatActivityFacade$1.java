package com.tencent.mobileqq.activity;

import aycx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PttDownExtraInfo;
import com.tencent.qphone.base.util.QLog;

public final class ChatActivityFacade$1
  implements Runnable
{
  public ChatActivityFacade$1(MessageForPtt paramMessageForPtt, QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, aycx paramaycx, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("FileTrans", 2, "downloadPtt istroop" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop + " itemType " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.itemType + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq);
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localTransferRequest.mPeerUin = this.jdField_a_of_type_JavaLangString;
    localTransferRequest.mUinType = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop;
    localTransferRequest.mFileType = 2;
    localTransferRequest.mUniseq = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq;
    localTransferRequest.mIsUp = false;
    localTransferRequest.mServerPath = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer;
    localTransferRequest.mOutFilePath = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getLocalFilePath();
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.isSendFromOtherTerminal()) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.isSend()))
    {
      bool = true;
      localTransferRequest.mIsSelfSend = bool;
      localTransferRequest.mMd5 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.md5;
      localTransferRequest.mGroupFileID = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.groupFileID;
      localTransferRequest.mGroupFileKeyStr = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.groupFileKeyStr;
      localTransferRequest.mDbRecVersion = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.subVersion;
      localTransferRequest.mRec = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      if (!this.jdField_a_of_type_Boolean) {
        break label286;
      }
    }
    for (;;)
    {
      localTransferRequest.mDownMode = i;
      localTransferRequest.mDownCallBack = this.jdField_a_of_type_Aycx;
      localTransferRequest.mExtraObj = new TransferRequest.PttDownExtraInfo(this.jdField_a_of_type_Int, this.b);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(localTransferRequest);
      return;
      bool = false;
      break;
      label286:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.1
 * JD-Core Version:    0.7.0.1
 */