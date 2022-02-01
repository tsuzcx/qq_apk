package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgsvc.msg_svc.Grp;
import msf.msgsvc.msg_svc.RoutingHead;

public class HotchatTopicRoutingType
  implements RoutingType
{
  public int a()
  {
    return 1026;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new msg_svc.Grp();
    paramQQAppInterface.group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramRoutingHead.grp.set(paramQQAppInterface);
    return true;
  }
  
  public int b()
  {
    return 3013;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.HotchatTopicRoutingType
 * JD-Core Version:    0.7.0.1
 */