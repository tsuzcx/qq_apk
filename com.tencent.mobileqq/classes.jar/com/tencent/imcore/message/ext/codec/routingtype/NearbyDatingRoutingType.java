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
import msf.msgsvc.msg_svc.NearByDatingTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class NearbyDatingRoutingType
  implements RoutingType<AppInterface>
{
  public int a()
  {
    return 1010;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    msg_svc.NearByDatingTmp localNearByDatingTmp = new msg_svc.NearByDatingTmp();
    localNearByDatingTmp.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramAppInterface = (QQAppInterface)paramAppInterface;
    Message localMessage = paramAppInterface.getMessageFacade().getLastMessage(paramMessageRecord.frienduin, 1010);
    localNearByDatingTmp.reply.set(localMessage.hasReply);
    paramMessageRecord = paramAppInterface.getMsgCache().p(paramMessageRecord.frienduin);
    if (paramMessageRecord != null)
    {
      if (QLog.isDevelopLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("发送附近人约会临时会话消息 有keyNearbyDating------>");
        paramAppInterface.append(HexUtil.bytes2HexStr(paramMessageRecord));
        paramAppInterface.append(",length:");
        paramAppInterface.append(paramMessageRecord.length);
        QLog.d("nearby_dating", 4, paramAppInterface.toString());
      }
      localNearByDatingTmp.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.nearby_dating_tmp.set(localNearByDatingTmp);
    return true;
  }
  
  public int b()
  {
    return 8012;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.NearbyDatingRoutingType
 * JD-Core Version:    0.7.0.1
 */