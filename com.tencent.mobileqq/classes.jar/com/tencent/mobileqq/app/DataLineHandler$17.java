package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.weiyun.WeiyunCallback;
import com.tencent.qphone.base.util.BaseApplication;

class DataLineHandler$17
  implements WeiyunCallback
{
  DataLineHandler$17(DataLineHandler paramDataLineHandler, long paramLong) {}
  
  public void a(int paramInt, String paramString)
  {
    FMToastUtil.c(BaseApplicationImpl.getContext().getString(2131889599));
    ((DataLineHandler)this.b.i.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).OnSessionComplete(this.a, 41, paramInt);
  }
  
  public void a(Object paramObject)
  {
    Object localObject = (String)paramObject;
    paramObject = (DataLineHandler)this.b.i.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramObject.OnSessionComplete(this.a, 0, -999);
      return;
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(this.a);
    DataLineMsgRecord localDataLineMsgRecord = this.b.i.getMessageFacade().d(i).a(this.a);
    if (localDataLineMsgRecord == null) {
      return;
    }
    localDataLineMsgRecord.serverPath = ((String)localObject);
    localDataLineMsgRecord.nOpType = 1;
    localDataLineMsgRecord.bIsSended = true;
    localDataLineMsgRecord.bIsTransfering = false;
    if (localDataLineMsgRecord.entityID != 0L)
    {
      localObject = this.b.i.getFileManagerDataCenter().a(localDataLineMsgRecord.entityID);
      if (localObject != null)
      {
        ((FileManagerEntity)localObject).status = 1;
        ((FileManagerEntity)localObject).Uuid = localDataLineMsgRecord.serverPath;
      }
    }
    if (paramObject.a(localDataLineMsgRecord)) {
      paramObject.b(localDataLineMsgRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler.17
 * JD-Core Version:    0.7.0.1
 */