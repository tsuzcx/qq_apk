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

class LiteActivity$57
  implements FreeWifiHelper.FreeWifiDialogListener
{
  LiteActivity$57(LiteActivity paramLiteActivity, DataLineMsgRecord paramDataLineMsgRecord, FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2) {}
  
  public void a(int paramInt)
  {
    paramInt = DataLineMsgRecord.getDevTypeBySeId(this.a.sessionid);
    if (this.b == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FileManagerUtil.j(this.c));
      ((StringBuilder)localObject).append(this.e.getString(2131889759));
      FMToastUtil.b(((StringBuilder)localObject).toString());
      localObject = this.e.app.getFileManagerEngine().a(this.d, null, this.e.app.getAccount(), 0, false);
      this.a.nWeiyunSessionId = ((FileManagerEntity)localObject).nSessionId;
      this.e.app.getMessageFacade().d(paramInt).f(this.a.msgId);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FileManagerUtil.j(this.c));
    ((StringBuilder)localObject).append(this.e.getString(2131889759));
    FMToastUtil.b(((StringBuilder)localObject).toString());
    this.e.app.getFileManagerEngine().b(this.a.nWeiyunSessionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.57
 * JD-Core Version:    0.7.0.1
 */