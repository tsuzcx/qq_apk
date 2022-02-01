package com.tencent.imcore.message.adder;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class LongTextAddMessageHandler
  implements IAddMessageHandler
{
  private void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((!paramMessageRecord.isSendFromLocal()) && ((paramMessageRecord.msgtype == -1051) || ((paramMessageRecord.isLongMsg()) && (paramMessageRecord.longMsgCount == paramMessageRecord.longMsgIndex + 1))))
    {
      LongTextMsgManager localLongTextMsgManager = (LongTextMsgManager)paramQQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER);
      if (paramQQAppInterface.mAutomator.a() == 1)
      {
        localLongTextMsgManager.b(paramQQAppInterface, paramMessageRecord);
        return;
      }
      ThreadManager.getSubThreadHandler().postDelayed(new LongTextAddMessageHandler.1(this, localLongTextMsgManager, paramQQAppInterface, paramMessageRecord), 10000L);
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
      QLog.d("Q.msg.BaseMessageManager", 1, "longmsg receive report error!", paramAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.adder.LongTextAddMessageHandler
 * JD-Core Version:    0.7.0.1
 */