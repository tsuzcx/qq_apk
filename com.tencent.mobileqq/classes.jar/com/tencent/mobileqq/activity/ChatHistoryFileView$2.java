package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Comparator;

class ChatHistoryFileView$2
  implements Comparator<Object>
{
  ChatHistoryFileView$2(ChatHistoryFileView paramChatHistoryFileView) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 instanceof FileManagerEntity)) {
      if ((paramObject2 instanceof FileManagerEntity)) {
        if (((FileManagerEntity)paramObject1).srvTime <= ((FileManagerEntity)paramObject2).srvTime) {}
      }
    }
    do
    {
      do
      {
        do
        {
          return -1;
          return 1;
          if (!(paramObject2 instanceof TencentDocData)) {
            break;
          }
        } while (((FileManagerEntity)paramObject1).srvTime > ((TencentDocData)paramObject2).aioTime);
        return 1;
        if (!(paramObject1 instanceof TencentDocData)) {
          break label124;
        }
        if (!(paramObject2 instanceof FileManagerEntity)) {
          break;
        }
      } while (((TencentDocData)paramObject1).aioTime > ((FileManagerEntity)paramObject2).srvTime);
      return 1;
      if (!(paramObject2 instanceof TencentDocData)) {
        break;
      }
    } while (((TencentDocData)paramObject1).aioTime > ((TencentDocData)paramObject2).aioTime);
    return 1;
    label124:
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileView.2
 * JD-Core Version:    0.7.0.1
 */