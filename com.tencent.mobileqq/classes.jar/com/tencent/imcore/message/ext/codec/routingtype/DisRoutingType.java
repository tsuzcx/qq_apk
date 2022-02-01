package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgsvc.msg_svc.Dis;
import msf.msgsvc.msg_svc.RoutingHead;

public class DisRoutingType
  implements RoutingType<AppInterface>
{
  public int a()
  {
    return 3000;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    paramAppInterface = new msg_svc.Dis();
    paramAppInterface.dis_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramRoutingHead.dis.set(paramAppInterface);
    return true;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return 3008;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.DisRoutingType
 * JD-Core Version:    0.7.0.1
 */