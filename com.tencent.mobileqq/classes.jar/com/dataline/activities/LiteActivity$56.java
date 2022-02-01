package com.dataline.activities;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class LiteActivity$56
  implements FMDialogUtil.FMDialogInterface
{
  LiteActivity$56(LiteActivity paramLiteActivity, DataLineMsgRecord paramDataLineMsgRecord, FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2) {}
  
  public void a()
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FileManagerUtil.c(this.jdField_a_of_type_JavaLangString));
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131692688));
      FMToastUtil.b(((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getFileManagerEngine().a(this.b, null, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount(), 0, false);
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.nWeiyunSessionId = ((FileManagerEntity)localObject).nSessionId;
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getMessageFacade().a(i).d(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgId);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FileManagerUtil.c(this.jdField_a_of_type_JavaLangString));
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131692688));
    FMToastUtil.b(((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getFileManagerEngine().a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.nWeiyunSessionId);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.56
 * JD-Core Version:    0.7.0.1
 */