package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgsvc.msg_svc.Dis;
import msf.msgsvc.msg_svc.RoutingHead;

public class DisRoutingType
  implements RoutingType
{
  public int a()
  {
    return 3000;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new msg_svc.Dis();
    paramQQAppInterface.dis_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramRoutingHead.dis.set(paramQQAppInterface);
    return true;
  }
  
  public int b()
  {
    return 3008;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.DisRoutingType
 * JD-Core Version:    0.7.0.1
 */