package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.message.TinyIdCache;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.CommTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class QQGameMsgTmpRoutingType
  implements RoutingType<AppInterface>
{
  public int a()
  {
    return 10007;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    msg_svc.CommTmp localCommTmp = new msg_svc.CommTmp();
    localCommTmp.c2c_type.set(1);
    localCommTmp.svr_type.set(164);
    byte[] arrayOfByte = ((MessageCache)paramAppInterface.getMsgCache()).c(paramMessageRecord.frienduin, paramMessageRecord.selfuin);
    if (arrayOfByte != null) {
      localCommTmp.sig.set(ByteStringMicro.copyFrom(arrayOfByte));
    }
    paramMessageRecord = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().a(paramMessageRecord.frienduin);
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramMessageRecord);
      l1 = l2;
    }
    catch (NumberFormatException paramMessageRecord)
    {
      QLog.d("QQGameMsgTmpRoutingType", 1, paramMessageRecord, new Object[0]);
    }
    localCommTmp.to_uin.set(l1);
    paramRoutingHead.comm_tmp.set(localCommTmp);
    return true;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return 8042;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.QQGameMsgTmpRoutingType
 * JD-Core Version:    0.7.0.1
 */