package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import java.util.ArrayList;
import java.util.List;

class ChatHistoryFileView$4$1
  implements FMDialogUtil.FMDialogInterface
{
  ChatHistoryFileView$4$1(ChatHistoryFileView.4 param4, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView$4.a.a.getOnlineFileSessionCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 6)
    {
      DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView$4.a.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq));
      if (!localDataLineHandler.a(localArrayList)) {
        FMToastUtil.a(2131692553);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView$4.a.a.getFileManagerEngine().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileView.4.1
 * JD-Core Version:    0.7.0.1
 */