package com.tencent.imcore.message.adder;

import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.SimpleProxyListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.doc.TencentDocGrayTipsUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.Map;
import mqq.app.AppRuntime;

public class StructingAddMessageHandler
  implements IAddMessageHandler
{
  private void a(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing.structingMsg != null) && (paramMessageForStructing.structingMsg.mMsgUrl != null) && (paramMessageForStructing.structingMsg.mMsgUrl.startsWith("https://docs.qq.com"))) {
      TencentDocGrayTipsUtils.a(paramQQAppInterface, paramMessageForStructing.frienduin, paramMessageForStructing.senderuin, paramMessageForStructing.istroop, paramMessageForStructing.time, paramMessageForStructing.msgseq, paramMessageForStructing.msgUid);
    }
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramMessageRecord).structingMsg;
    if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID == 61)) {
      paramMessageRecord.extInt = 61;
    }
  }
  
  public void a(AppRuntime paramAppRuntime, IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Map<String, MessageRecord> paramMap, String paramString, int paramInt)
  {
    boolean bool = paramMessageRecord instanceof MessageForStructing;
    if (bool) {
      a(paramMessageRecord);
    }
    ((BaseMessageManager)paramIMessageManager).a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord, new SimpleProxyListener(), paramBoolean1, paramBoolean2, paramBoolean3);
    if (bool) {
      a((QQAppInterface)paramAppRuntime, (MessageForStructing)paramMessageRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.adder.StructingAddMessageHandler
 * JD-Core Version:    0.7.0.1
 */