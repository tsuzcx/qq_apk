package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgsvc.msg_svc.CommTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class CmgameTmpRoutingType
  implements RoutingType<AppInterface>
{
  public int a()
  {
    return 1036;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    paramAppInterface = new msg_svc.CommTmp();
    paramAppInterface.c2c_type.set(1);
    paramAppInterface.svr_type.set(160);
    paramAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramRoutingHead.comm_tmp.set(paramAppInterface);
    return true;
  }
  
  public int b()
  {
    return 3022;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.CmgameTmpRoutingType
 * JD-Core Version:    0.7.0.1
 */