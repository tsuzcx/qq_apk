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

class LiteActivity$58
  implements FMDialogUtil.FMDialogInterface
{
  LiteActivity$58(LiteActivity paramLiteActivity, DataLineMsgRecord paramDataLineMsgRecord, FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2) {}
  
  public void a()
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(this.a.sessionid);
    if (this.b == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FileManagerUtil.j(this.c));
      ((StringBuilder)localObject).append(this.e.getString(2131889759));
      FMToastUtil.b(((StringBuilder)localObject).toString());
      localObject = this.e.app.getFileManagerEngine().a(this.d, null, this.e.app.getAccount(), 0, false);
      this.a.nWeiyunSessionId = ((FileManagerEntity)localObject).nSessionId;
      this.e.app.getMessageFacade().d(i).f(this.a.msgId);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FileManagerUtil.j(this.c));
    ((StringBuilder)localObject).append(this.e.getString(2131889759));
    FMToastUtil.b(((StringBuilder)localObject).toString());
    this.e.app.getFileManagerEngine().b(this.a.nWeiyunSessionId);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.58
 * JD-Core Version:    0.7.0.1
 */