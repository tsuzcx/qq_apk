package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgsvc.msg_svc.Grp;
import msf.msgsvc.msg_svc.RoutingHead;

public class HotchatTopicRoutingType
  implements RoutingType<AppInterface>
{
  public int a()
  {
    return 1026;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    paramAppInterface = new msg_svc.Grp();
    paramAppInterface.group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramRoutingHead.grp.set(paramAppInterface);
    return true;
  }
  
  public int b()
  {
    return 3013;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.HotchatTopicRoutingType
 * JD-Core Version:    0.7.0.1
 */