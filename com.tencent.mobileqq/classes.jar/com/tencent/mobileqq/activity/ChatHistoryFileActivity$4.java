package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import java.util.Iterator;
import java.util.List;

class ChatHistoryFileActivity$4
  implements FMDialogUtil.FMDialogInterface
{
  ChatHistoryFileActivity$4(ChatHistoryFileActivity paramChatHistoryFileActivity, List paramList, FileManagerEngine paramFileManagerEngine) {}
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        this.b.h(localFileManagerEntity);
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity.4
 * JD-Core Version:    0.7.0.1
 */