package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Comparator;

class ChatHistoryC2CFileFragment$2
  implements Comparator<Object>
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    if ((paramObject2 instanceof FileManagerEntity)) {
      if (((FileManagerEntity)paramObject1).srvTime <= ((FileManagerEntity)paramObject2).srvTime) {}
    }
    do
    {
      return -1;
      return 1;
      if (!(paramObject2 instanceof TencentDocData)) {
        break;
      }
    } while (((FileManagerEntity)paramObject1).srvTime > ((TencentDocData)paramObject2).aioTime);
    return 1;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment.2
 * JD-Core Version:    0.7.0.1
 */