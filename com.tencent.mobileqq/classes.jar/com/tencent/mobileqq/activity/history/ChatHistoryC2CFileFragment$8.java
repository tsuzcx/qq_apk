package com.tencent.mobileqq.activity.history;

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

class ChatHistoryC2CFileFragment$8
  implements FMDialogUtil.FMDialogInterface
{
  ChatHistoryC2CFileFragment$8(ChatHistoryC2CFileFragment paramChatHistoryC2CFileFragment, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    if (this.a.getCloudType() == 0)
    {
      this.b.a.getOnlineFileSessionCenter().b(this.a.nSessionId);
      return;
    }
    if (this.a.getCloudType() == 6)
    {
      DataLineHandler localDataLineHandler = (DataLineHandler)this.b.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.a.uniseq));
      if (!localDataLineHandler.b(localArrayList)) {
        FMToastUtil.a(2131889576);
      }
    }
    else
    {
      this.b.a.getFileManagerEngine().h(this.a);
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment.8
 * JD-Core Version:    0.7.0.1
 */