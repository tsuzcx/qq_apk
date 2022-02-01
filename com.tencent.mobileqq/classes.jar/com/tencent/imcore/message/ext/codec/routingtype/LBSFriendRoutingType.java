package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.AccostTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class LBSFriendRoutingType
  implements RoutingType<AppInterface>
{
  public int a()
  {
    return 1001;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    msg_svc.AccostTmp localAccostTmp = new msg_svc.AccostTmp();
    localAccostTmp.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramAppInterface = (QQAppInterface)paramAppInterface;
    Message localMessage = paramAppInterface.getMessageFacade().getLastMessage(paramMessageRecord.frienduin, 1001);
    localAccostTmp.reply.set(localMessage.hasReply);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LBS_FRIEND------>reply=");
      localStringBuilder.append(localMessage.hasReply);
      QLog.d("LBSFriendRoutingType", 2, localStringBuilder.toString());
    }
    paramMessageRecord = paramAppInterface.getMsgCache().r(paramMessageRecord.frienduin);
    if (paramMessageRecord != null)
    {
      if (QLog.isDevelopLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("发送附近人临时会消息 有keyLBSFriend------>");
        paramAppInterface.append(HexUtil.bytes2HexStr(paramMessageRecord));
        paramAppInterface.append(",length:");
        paramAppInterface.append(paramMessageRecord.length);
        QLog.d("fight_accost", 4, paramAppInterface.toString());
      }
      localAccostTmp.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.accost_tmp.set(localAccostTmp);
    return true;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return 6010;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.LBSFriendRoutingType
 * JD-Core Version:    0.7.0.1
 */