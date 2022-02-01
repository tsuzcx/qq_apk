package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseMessageHandlerUtils
{
  public static void a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 1) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
        if (MessageUtils.a(localMessageRecord))
        {
          int j;
          if (((i > 0) && (((MessageRecord)paramList.get(i - 1)).shmsgseq == localMessageRecord.shmsgseq)) || ((i < paramList.size() - 1) && (((MessageRecord)paramList.get(i + 1)).shmsgseq == localMessageRecord.shmsgseq))) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0) {
            localArrayList.add(localMessageRecord);
          }
        }
        i += 1;
      }
      paramList.removeAll(localArrayList);
    }
  }
  
  public static boolean a(ArrayList<MessageRecord> paramArrayList)
  {
    boolean bool2 = false;
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      bool1 = bool2;
      if (!paramArrayList.hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)paramArrayList.next();
    } while ((localMessageRecord.isSend()) || (localMessageRecord.isread));
    boolean bool1 = true;
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseMessageHandlerUtils
 * JD-Core Version:    0.7.0.1
 */