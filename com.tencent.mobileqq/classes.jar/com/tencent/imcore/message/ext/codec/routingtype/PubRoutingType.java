package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import msf.msgsvc.msg_svc.PublicPlat;
import msf.msgsvc.msg_svc.RoutingHead;

public class PubRoutingType
  implements RoutingType<AppInterface>
{
  public int a()
  {
    return 1008;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    paramAppInterface = ((QQAppInterface)paramAppInterface).getMsgCache().e(paramMessageRecord.frienduin);
    msg_svc.PublicPlat localPublicPlat = new msg_svc.PublicPlat();
    localPublicPlat.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    if (paramAppInterface != null)
    {
      paramMessageRecord = new byte[paramAppInterface.length - 2];
      PkgTools.copyData(paramMessageRecord, 0, paramAppInterface, 2, paramAppInterface.length - 2);
      localPublicPlat.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.public_plat.set(localPublicPlat);
    return true;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return 7001;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.PubRoutingType
 * JD-Core Version:    0.7.0.1
 */