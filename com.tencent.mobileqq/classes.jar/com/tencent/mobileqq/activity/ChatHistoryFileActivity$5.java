package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wifi.FreeWifiDialogListener;
import java.util.Iterator;
import java.util.List;

class ChatHistoryFileActivity$5
  implements FreeWifiDialogListener
{
  ChatHistoryFileActivity$5(ChatHistoryFileActivity paramChatHistoryFileActivity, List paramList, FileManagerEngine paramFileManagerEngine) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      FMToastUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.getString(2131692733));
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          if (FileUtils.b(localFileManagerEntity.getFilePath())) {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine.a(localFileManagerEntity.getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.app.getCurrentAccountUin(), 0, false);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity.5
 * JD-Core Version:    0.7.0.1
 */