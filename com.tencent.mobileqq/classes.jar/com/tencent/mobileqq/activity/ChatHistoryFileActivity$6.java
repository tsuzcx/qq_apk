package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.Iterator;
import java.util.List;

class ChatHistoryFileActivity$6
  implements FMDialogUtil.FMDialogInterface
{
  ChatHistoryFileActivity$6(ChatHistoryFileActivity paramChatHistoryFileActivity, List paramList, FileManagerEngine paramFileManagerEngine) {}
  
  public void a()
  {
    FMToastUtil.d(this.c.getString(2131889761));
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        if (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) {
          this.b.a(localFileManagerEntity.getFilePath(), "", this.c.app.getCurrentAccountUin(), 0, false);
        } else {
          this.b.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
        }
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity.6
 * JD-Core Version:    0.7.0.1
 */