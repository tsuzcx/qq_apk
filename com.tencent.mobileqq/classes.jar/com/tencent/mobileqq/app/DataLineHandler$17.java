package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.WeiyunCallback;
import com.tencent.qphone.base.util.BaseApplication;

class DataLineHandler$17
  implements WeiYunLogicCenter.WeiyunCallback
{
  DataLineHandler$17(DataLineHandler paramDataLineHandler, long paramLong) {}
  
  public void a(int paramInt, String paramString)
  {
    FMToastUtil.c(BaseApplicationImpl.getContext().getString(2131692624));
    ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).OnSessionComplete(this.jdField_a_of_type_Long, 41, paramInt);
  }
  
  public void a(Object paramObject)
  {
    Object localObject = (String)paramObject;
    paramObject = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramObject.OnSessionComplete(this.jdField_a_of_type_Long, 0, -999);
    }
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      do
      {
        return;
        int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_Long);
        localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.getMessageFacade().a(i).a(this.jdField_a_of_type_Long);
      } while (localDataLineMsgRecord == null);
      localDataLineMsgRecord.serverPath = ((String)localObject);
      localDataLineMsgRecord.nOpType = 1;
      localDataLineMsgRecord.bIsSended = true;
      localDataLineMsgRecord.bIsTransfering = false;
      if (localDataLineMsgRecord.entityID != 0L)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.getFileManagerDataCenter().a(localDataLineMsgRecord.entityID);
        if (localObject != null)
        {
          ((FileManagerEntity)localObject).status = 1;
          ((FileManagerEntity)localObject).Uuid = localDataLineMsgRecord.serverPath;
        }
      }
    } while (!paramObject.a(localDataLineMsgRecord));
    paramObject.a(localDataLineMsgRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler.17
 * JD-Core Version:    0.7.0.1
 */