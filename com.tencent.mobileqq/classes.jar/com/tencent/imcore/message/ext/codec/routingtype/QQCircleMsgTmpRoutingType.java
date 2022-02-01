package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import msf.msgsvc.msg_svc.CommTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class QQCircleMsgTmpRoutingType
  implements RoutingType<AppInterface>
{
  public int a()
  {
    return 10008;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    msg_svc.CommTmp localCommTmp = new msg_svc.CommTmp();
    localCommTmp.c2c_type.set(1);
    localCommTmp.svr_type.set(165);
    paramAppInterface = ((QQAppInterface)paramAppInterface).getMsgCache().e(paramMessageRecord.frienduin, paramMessageRecord.selfuin);
    if (paramAppInterface != null) {
      localCommTmp.sig.set(ByteStringMicro.copyFrom(paramAppInterface));
    }
    localCommTmp.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramRoutingHead.comm_tmp.set(localCommTmp);
    return true;
  }
  
  public int b()
  {
    return 8043;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.QQCircleMsgTmpRoutingType
 * JD-Core Version:    0.7.0.1
 */