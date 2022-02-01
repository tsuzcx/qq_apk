package com.tencent.imcore.message;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMConstants.RevertMsgCallback;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class QQMessageFacade$2
  implements FMConstants.RevertMsgCallback
{
  QQMessageFacade$2(QQMessageFacade paramQQMessageFacade, MessageForFile paramMessageForFile, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop).e(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt == -6101) || (paramInt == -7003))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
      QQMessageFacade.a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade).getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    QQMessageFacade.a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade).getMsgHandler().a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop, BaseMessageProcessor.e, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade.2
 * JD-Core Version:    0.7.0.1
 */