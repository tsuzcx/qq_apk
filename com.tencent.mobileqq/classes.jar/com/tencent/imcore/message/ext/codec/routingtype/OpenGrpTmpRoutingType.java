package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgsvc.msg_svc.PubGroupTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class OpenGrpTmpRoutingType
  implements RoutingType<AppInterface>
{
  public int a()
  {
    return 1020;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    paramAppInterface = new msg_svc.PubGroupTmp();
    paramAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
    paramAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramRoutingHead.pub_group_tmp.set(paramAppInterface);
    return true;
  }
  
  public int b()
  {
    return 6009;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.OpenGrpTmpRoutingType
 * JD-Core Version:    0.7.0.1
 */