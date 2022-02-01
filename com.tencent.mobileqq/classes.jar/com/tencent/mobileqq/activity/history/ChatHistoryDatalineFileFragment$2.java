package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Comparator;

class ChatHistoryDatalineFileFragment$2
  implements Comparator<FileManagerEntity>
{
  ChatHistoryDatalineFileFragment$2(ChatHistoryDatalineFileFragment paramChatHistoryDatalineFileFragment) {}
  
  public int a(FileManagerEntity paramFileManagerEntity1, FileManagerEntity paramFileManagerEntity2)
  {
    if (paramFileManagerEntity1.srvTime < paramFileManagerEntity2.srvTime) {
      return 1;
    }
    if (paramFileManagerEntity1.srvTime > paramFileManagerEntity2.srvTime) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryDatalineFileFragment.2
 * JD-Core Version:    0.7.0.1
 */