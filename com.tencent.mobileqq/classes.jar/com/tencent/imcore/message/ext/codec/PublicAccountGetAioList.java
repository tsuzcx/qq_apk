package com.tencent.imcore.message.ext.codec;

import com.tencent.imcore.message.GetAioListCallback;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
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
      if (QLog.isColorLevel()) {
        QLog.w("PaiYiPaiGetAioList", 2, "Collections sort exception ! ", paramList);
      }
    }
  }
  
  private void a(List<MessageRecord> paramList, MessageRecord paramMessageRecord)
  {
    if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(paramMessageRecord.senderuin)) {
      if ((paramMessageRecord instanceof MessageForText))
      {
        if (!((MessageForText)paramMessageRecord).msg.startsWith(" ")) {
          paramList.remove(paramMessageRecord);
        }
      }
      else if ((!(paramMessageRecord instanceof MessageForArkApp)) && (!(paramMessageRecord instanceof MessageForStructing))) {
        paramList.remove(paramMessageRecord);
      }
    }
    Object localObject = (IArkConfig)QRoute.api(IArkConfig.class);
    if ((paramMessageRecord.msgtype == -5008) && (((IArkConfig)localObject).isPANonShow())) {
      paramList.remove(paramMessageRecord);
    }
    if ((paramMessageRecord.msgtype == -2011) && ((paramMessageRecord instanceof MessageForStructing)))
    {
      localObject = ((MessageForStructing)paramMessageRecord).structingMsg;
      if ((localObject != null) && (((AbsStructMsg)localObject).mMsgServiceID == 85)) {
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
    while (paramInt1 >= 0)
    {
      paramString = (MessageRecord)paramList.get(paramInt1);
      if (paramString != null) {
        a(paramList, paramString);
      }
      paramInt1 -= 1;
    }
    a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.PublicAccountGetAioList
 * JD-Core Version:    0.7.0.1
 */