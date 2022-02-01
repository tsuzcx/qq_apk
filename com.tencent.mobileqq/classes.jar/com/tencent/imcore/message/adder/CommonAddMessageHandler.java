package com.tencent.imcore.message.adder;

import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Map;
import mqq.app.AppRuntime;

public class CommonAddMessageHandler
  implements IAddMessageHandler
{
  private void a(BaseMessageManager paramBaseMessageManager, MessageRecord paramMessageRecord, Map<String, MessageRecord> paramMap, String paramString, int paramInt)
  {
    if (paramBaseMessageManager.a(paramMessageRecord, false, 1)) {
      if ((paramMap.containsKey(UinTypeUtil.a(paramString, paramInt))) && (!paramMessageRecord.isSendFromLocal()))
      {
        MessageRecord localMessageRecord = (MessageRecord)paramMap.get(UinTypeUtil.a(paramString, paramInt));
        if (paramBaseMessageManager.a(paramMessageRecord) >= paramBaseMessageManager.a(localMessageRecord)) {
          paramMap.put(UinTypeUtil.a(paramString, paramInt), paramMessageRecord);
        }
      }
      else
      {
        paramMap.put(UinTypeUtil.a(paramString, paramInt), paramMessageRecord);
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Map<String, MessageRecord> paramMap, String paramString, int paramInt)
  {
    if ((paramMessageRecord.istroop != 3000) && (paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 0) && (paramMessageRecord.istroop != 10014))
    {
      ((BaseMessageManager)paramIMessageManager).a(paramMessageRecord, true, 1);
      return;
    }
    a((BaseMessageManager)paramIMessageManager, paramMessageRecord, paramMap, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.adder.CommonAddMessageHandler
 * JD-Core Version:    0.7.0.1
 */