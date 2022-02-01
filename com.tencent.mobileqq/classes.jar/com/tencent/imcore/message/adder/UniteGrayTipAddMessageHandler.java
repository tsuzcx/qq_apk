package com.tencent.imcore.message.adder;

import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipCallBack;
import java.util.Map;
import mqq.app.AppRuntime;

public class UniteGrayTipAddMessageHandler
  implements IAddMessageHandler
{
  public void a(AppRuntime paramAppRuntime, IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Map<String, MessageRecord> paramMap, String paramString, int paramInt)
  {
    if ((paramMessageRecord instanceof MessageForUniteGrayTip))
    {
      paramAppRuntime = (MessageForUniteGrayTip)paramMessageRecord;
      if (paramAppRuntime.callback != null) {
        paramAppRuntime.callback.a(paramAppRuntime);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.adder.UniteGrayTipAddMessageHandler
 * JD-Core Version:    0.7.0.1
 */