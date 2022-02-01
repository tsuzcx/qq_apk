package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x3b.Submsgtype0x3b.MsgBody;

public class SubType0x3b
  implements Msg0X210SubTypeDecoder
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        Submsgtype0x3b.MsgBody localMsgBody = new Submsgtype0x3b.MsgBody();
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder().append("0x210Push_0x3b, group code: ");
          if (!localMsgBody.uint64_group_code.has()) {
            break label401;
          }
          paramMsgType0x210 = String.valueOf(localMsgBody.uint64_group_code.get());
          localObject1 = ((StringBuilder)localObject1).append(paramMsgType0x210).append(", user switch: ");
          if (localMsgBody.uint32_user_show_flag.has())
          {
            paramMsgType0x210 = String.valueOf(localMsgBody.uint32_user_show_flag.get());
            QLog.d("Q.getTroopMemberLevelInfo", 2, paramMsgType0x210 + ", level map changed: " + localMsgBody.uint32_member_level_changed.has() + ",uint32_member_level_new_changed" + localMsgBody.uint32_member_level_new_changed.has());
          }
        }
        else
        {
          if (!localMsgBody.uint64_group_code.has()) {
            break label400;
          }
          if (localMsgBody.uint32_user_show_flag.has())
          {
            int i = localMsgBody.uint32_user_show_flag.get();
            paramMsgType0x210 = String.valueOf(localMsgBody.uint64_group_code.get());
            Object localObject2 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            localObject1 = ((TroopManager)localObject2).b(paramMsgType0x210);
            ((TroopInfo)localObject1).cGroupRankUserFlag = ((byte)i);
            ((TroopManager)localObject2).b((TroopInfo)localObject1);
            localObject2 = (TroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
            if (localObject2 != null)
            {
              int j = TroopNotificationConstants.bW;
              if (i == 1) {
                bool = true;
              }
              ((TroopHandler)localObject2).notifyUI(j, true, new Object[] { paramMsgType0x210, Boolean.valueOf(bool) });
            }
            if (1 == ((TroopInfo)localObject1).cGroupRankUserFlag) {
              ((TroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).f(paramMsgType0x210);
            }
          }
          if (localMsgBody.uint32_member_level_changed.has())
          {
            l = localMsgBody.uint64_group_code.get();
            ((TroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).f(String.valueOf(l));
          }
          if (!localMsgBody.uint32_member_level_new_changed.has()) {
            break label400;
          }
          long l = localMsgBody.uint64_group_code.get();
          ((TroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).f(String.valueOf(l));
          return;
        }
        paramMsgType0x210 = "";
        continue;
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.getTroopMemberLevelInfo", 2, "0x210Push_0x3b, failed to parse Submsgtype0x3b.MsgBody");
        }
      }
      label400:
      label401:
      paramMsgType0x210 = "";
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x3b
 * JD-Core Version:    0.7.0.1
 */