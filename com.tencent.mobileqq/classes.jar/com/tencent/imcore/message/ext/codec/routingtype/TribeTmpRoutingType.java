package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.CommTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class TribeTmpRoutingType
  implements RoutingType<AppInterface>
{
  public int a()
  {
    return 10002;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    msg_svc.CommTmp localCommTmp = new msg_svc.CommTmp();
    localCommTmp.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    localCommTmp.c2c_type.set(1);
    localCommTmp.svr_type.set(149);
    paramAppInterface = (QQAppInterface)paramAppInterface;
    Message localMessage = paramAppInterface.getMessageFacade().getLastMessage(paramMessageRecord.frienduin, 1001);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TRIBE_TMP------>reply=");
      localStringBuilder.append(localMessage.hasReply);
      QLog.d("TribeTmpRoutingType", 2, localStringBuilder.toString());
    }
    paramMessageRecord = paramAppInterface.getMsgCache().j(paramMessageRecord.frienduin);
    if (paramMessageRecord != null)
    {
      if (QLog.isDevelopLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("发送兴趣部落临时会消息 有key------>");
        paramAppInterface.append(HexUtil.bytes2HexStr(paramMessageRecord));
        paramAppInterface.append(",length:");
        paramAppInterface.append(paramMessageRecord.length);
        QLog.d("fight_accost", 4, paramAppInterface.toString());
      }
      localCommTmp.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.comm_tmp.set(localCommTmp);
    return true;
  }
  
  public int b()
  {
    return 8028;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.TribeTmpRoutingType
 * JD-Core Version:    0.7.0.1
 */