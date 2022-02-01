package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.onlinepush.api.TroopOnlinePushObserver;
import com.tencent.mobileqq.troop.troopmemberlevel.api.ITroopMemberLevelHandler;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x3b.Submsgtype0x3b.MsgBody;

public class SubType0x3b
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    try
    {
      localMsgBody = new Submsgtype0x3b.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      if (!QLog.isColorLevel()) {
        break label179;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("0x210Push_0x3b, group code: ");
      bool = localMsgBody.uint64_group_code.has();
      localObject1 = "";
      if (!bool) {
        break label430;
      }
      paramMsgType0x210 = String.valueOf(localMsgBody.uint64_group_code.get());
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        Submsgtype0x3b.MsgBody localMsgBody;
        Object localObject2;
        boolean bool;
        Object localObject1;
        label179:
        int i;
        int j;
        long l;
        continue;
        label430:
        paramMsgType0x210 = "";
      }
    }
    ((StringBuilder)localObject2).append(paramMsgType0x210);
    ((StringBuilder)localObject2).append(", user switch: ");
    paramMsgType0x210 = (MsgType0x210)localObject1;
    if (localMsgBody.uint32_user_show_flag.has()) {
      paramMsgType0x210 = String.valueOf(localMsgBody.uint32_user_show_flag.get());
    }
    ((StringBuilder)localObject2).append(paramMsgType0x210);
    ((StringBuilder)localObject2).append(", level map changed: ");
    ((StringBuilder)localObject2).append(localMsgBody.uint32_member_level_changed.has());
    ((StringBuilder)localObject2).append(",uint32_member_level_new_changed");
    ((StringBuilder)localObject2).append(localMsgBody.uint32_member_level_new_changed.has());
    QLog.d("Q.getTroopMemberLevelInfo", 2, ((StringBuilder)localObject2).toString());
    if (localMsgBody.uint64_group_code.has())
    {
      if (localMsgBody.uint32_user_show_flag.has())
      {
        i = localMsgBody.uint32_user_show_flag.get();
        paramMsgType0x210 = String.valueOf(localMsgBody.uint64_group_code.get());
        localObject2 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        localObject1 = ((TroopManager)localObject2).f(paramMsgType0x210);
        ((TroopInfo)localObject1).cGroupRankUserFlag = ((byte)i);
        ((TroopManager)localObject2).b((TroopInfo)localObject1);
        localObject2 = paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_PUSH_HANDLER);
        j = TroopOnlinePushObserver.TYPE_TROOP_RANK_SWITCH_CHANGE;
        bool = false;
        if (i == 1) {
          bool = true;
        }
        ((BusinessHandler)localObject2).notifyUI(j, true, new Object[] { paramMsgType0x210, Boolean.valueOf(bool) });
        if (1 == ((TroopInfo)localObject1).cGroupRankUserFlag) {
          ((ITroopMemberLevelHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LEVEL_HANDLER)).a(paramMsgType0x210);
        }
      }
      if (localMsgBody.uint32_member_level_changed.has())
      {
        l = localMsgBody.uint64_group_code.get();
        ((ITroopMemberLevelHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LEVEL_HANDLER)).a(String.valueOf(l));
      }
      if (localMsgBody.uint32_member_level_new_changed.has())
      {
        l = localMsgBody.uint64_group_code.get();
        ((ITroopMemberLevelHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LEVEL_HANDLER)).a(String.valueOf(l));
        return;
        if (QLog.isColorLevel()) {
          QLog.e("Q.getTroopMemberLevelInfo", 2, "0x210Push_0x3b, failed to parse Submsgtype0x3b.MsgBody");
        }
      }
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x3b
 * JD-Core Version:    0.7.0.1
 */