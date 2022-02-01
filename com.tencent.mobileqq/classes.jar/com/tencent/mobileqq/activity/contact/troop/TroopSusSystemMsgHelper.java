package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class TroopSusSystemMsgHelper
{
  public static String a = "TroopSusSystemMsgHelper";
  
  public static void a(BaseMessageManager paramBaseMessageManager, MessageRecord paramMessageRecord, IMessageFacade paramIMessageFacade, QQAppInterface paramQQAppInterface)
  {
    if ((paramBaseMessageManager != null) && (paramMessageRecord != null) && (paramIMessageFacade != null))
    {
      if (paramQQAppInterface == null) {
        return;
      }
      if ((paramMessageRecord instanceof MessageForSystemMsg))
      {
        localObject = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
        if (localObject != null) {
          paramMessageRecord.time = ((structmsg.StructMsg)localObject).msg_time.get();
        }
      }
      Object localObject = paramIMessageFacade.getLastMessage(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      int k = GroupSystemMsgController.a().c(paramQQAppInterface);
      if (k > 0)
      {
        int j = 0;
        int i = j;
        if (!paramMessageRecord.isSendFromLocal())
        {
          i = j;
          if (paramMessageRecord.time < ((Message)localObject).time) {
            i = 1;
          }
        }
        if (i == 0)
        {
          MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject, paramMessageRecord);
          ((Message)localObject).msgData = paramMessageRecord.msgData;
          paramIMessageFacade.setIncomingMsg((MessageRecord)localObject);
          try
          {
            paramBaseMessageManager.a((Message)localObject);
          }
          catch (Throwable paramBaseMessageManager)
          {
            if (QLog.isColorLevel()) {
              QLog.d(a, 2, "add GroupSuspiciousMsg ERROR", paramBaseMessageManager);
            }
          }
          paramIMessageFacade.getIncomingMsg().unReadNum = k;
        }
      }
      else
      {
        paramIMessageFacade.setIncomingMsg(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopSusSystemMsgHelper
 * JD-Core Version:    0.7.0.1
 */