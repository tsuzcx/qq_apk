package com.tencent.imcore.message.ext.codec;

import com.tencent.imcore.message.GetAioListCallback;
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;
import mqq.app.AppRuntime;

public class PublicAccountGetAioList
  implements GetAioListCallback
{
  private void a(List<MessageRecord> paramList)
  {
    try
    {
      Collections.sort(paramList, new PublicAccountGetAioList.1(this));
      return;
    }
    catch (Exception paramList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("PaiYiPaiGetAioList", 2, "Collections sort exception ! ", paramList);
    }
  }
  
  private void a(List<MessageRecord> paramList, MessageRecord paramMessageRecord)
  {
    if (PAWeatherItemBuilder.a(paramMessageRecord.senderuin))
    {
      if (!(paramMessageRecord instanceof MessageForText)) {
        break label111;
      }
      if (!((MessageForText)paramMessageRecord).msg.startsWith(" ")) {
        paramList.remove(paramMessageRecord);
      }
    }
    for (;;)
    {
      if ((paramMessageRecord.msgtype == -5008) && (ArkAppCenter.b())) {
        paramList.remove(paramMessageRecord);
      }
      if ((paramMessageRecord.msgtype == -2011) && ((paramMessageRecord instanceof MessageForStructing)))
      {
        AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramMessageRecord).structingMsg;
        if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID == 85)) {
          paramList.remove(paramMessageRecord);
        }
      }
      return;
      label111:
      if ((!(paramMessageRecord instanceof MessageForArkApp)) && (!(paramMessageRecord instanceof MessageForStructing))) {
        paramList.remove(paramMessageRecord);
      }
    }
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, List<MessageRecord> paramList, AppRuntime paramAppRuntime)
  {
    if (paramInt1 != 1008) {
      return;
    }
    paramInt1 = paramList.size() - 1;
    if (paramInt1 >= 0)
    {
      paramString = (MessageRecord)paramList.get(paramInt1);
      if (paramString == null) {}
      for (;;)
      {
        paramInt1 -= 1;
        break;
        a(paramList, paramString);
      }
    }
    a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.PublicAccountGetAioList
 * JD-Core Version:    0.7.0.1
 */