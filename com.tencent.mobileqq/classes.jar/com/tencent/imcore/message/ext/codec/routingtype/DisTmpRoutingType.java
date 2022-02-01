package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgsvc.msg_svc.DisTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class DisTmpRoutingType
  implements RoutingType<AppInterface>
{
  public int a()
  {
    return 1004;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    paramAppInterface = new msg_svc.DisTmp();
    paramAppInterface.dis_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
    paramAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramRoutingHead.dis_tmp.set(paramAppInterface);
    return true;
  }
  
  public int b()
  {
    return 8002;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.DisTmpRoutingType
 * JD-Core Version:    0.7.0.1
 */