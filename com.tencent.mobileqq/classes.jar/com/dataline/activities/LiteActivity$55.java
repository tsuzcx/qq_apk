package com.dataline.activities;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.wifi.FreeWifiHelper.FreeWifiDialogListener;

class LiteActivity$55
  implements FreeWifiHelper.FreeWifiDialogListener
{
  LiteActivity$55(LiteActivity paramLiteActivity, DataLineMsgRecord paramDataLineMsgRecord, FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2) {}
  
  public void a(int paramInt)
  {
    paramInt = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FileManagerUtil.c(this.jdField_a_of_type_JavaLangString));
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131692688));
      FMToastUtil.b(((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getFileManagerEngine().a(this.b, null, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount(), 0, false);
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.nWeiyunSessionId = ((FileManagerEntity)localObject).nSessionId;
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getMessageFacade().a(paramInt).d(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgId);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FileManagerUtil.c(this.jdField_a_of_type_JavaLangString));
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131692688));
    FMToastUtil.b(((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getFileManagerEngine().a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.nWeiyunSessionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.55
 * JD-Core Version:    0.7.0.1
 */