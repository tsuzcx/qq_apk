package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.NearByAssistantTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class NearbyAssistantRoutingType
  implements RoutingType<AppInterface>
{
  public int a()
  {
    return 0;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    msg_svc.NearByAssistantTmp localNearByAssistantTmp = new msg_svc.NearByAssistantTmp();
    localNearByAssistantTmp.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramMessageRecord = ((QQAppInterface)paramAppInterface).getMsgCache().t(paramMessageRecord.frienduin);
    if (paramMessageRecord != null)
    {
      if (QLog.isDevelopLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("发送附近人助手临时会话消息 有NearbyAssistantKey------>");
        paramAppInterface.append(HexUtil.bytes2HexStr(paramMessageRecord));
        paramAppInterface.append(",length:");
        paramAppInterface.append(paramMessageRecord.length);
        QLog.d("nearby_assistant", 4, paramAppInterface.toString());
      }
      localNearByAssistantTmp.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.nearby_assistant_tmp.set(localNearByAssistantTmp);
    return true;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return 8014;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.NearbyAssistantRoutingType
 * JD-Core Version:    0.7.0.1
 */