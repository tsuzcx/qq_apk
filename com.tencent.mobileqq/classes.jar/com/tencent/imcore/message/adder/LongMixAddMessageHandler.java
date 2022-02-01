package com.tencent.imcore.message.adder;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class LongMixAddMessageHandler
  implements IAddMessageHandler
{
  private void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((!paramMessageRecord.isSendFromLocal()) && ((paramMessageRecord.msgtype == -1036) || (paramMessageRecord.msgtype == -1035)))
    {
      MixedMsgManager localMixedMsgManager = (MixedMsgManager)paramQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER);
      if (paramQQAppInterface.mAutomator.a() == 1)
      {
        localMixedMsgManager.a(paramMessageRecord);
        return;
      }
      ThreadManager.getSubThreadHandler().postDelayed(new LongMixAddMessageHandler.1(this, localMixedMsgManager, paramMessageRecord), 10000L);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Map<String, MessageRecord> paramMap, String paramString, int paramInt)
  {
    try
    {
      a((QQAppInterface)paramAppRuntime, paramMessageRecord);
      return;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.msg.BaseMessageManager", 1, "mixexmsg receive report error!", paramAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.adder.LongMixAddMessageHandler
 * JD-Core Version:    0.7.0.1
 */