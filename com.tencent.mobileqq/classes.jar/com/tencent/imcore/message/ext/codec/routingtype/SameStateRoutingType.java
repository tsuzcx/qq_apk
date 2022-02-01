package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.RichStatusTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class SameStateRoutingType
  implements RoutingType<AppInterface>
{
  public int a()
  {
    return 1009;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    msg_svc.RichStatusTmp localRichStatusTmp = new msg_svc.RichStatusTmp();
    localRichStatusTmp.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramMessageRecord = ((QQAppInterface)paramAppInterface).getMsgCache().n(paramMessageRecord.frienduin);
    if (paramMessageRecord != null)
    {
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("sameState------>");
        paramAppInterface.append(HexUtil.bytes2HexStr(paramMessageRecord));
        paramAppInterface.append(",length:");
        paramAppInterface.append(paramMessageRecord.length);
        QLog.d("SameStateRoutingType", 2, paramAppInterface.toString());
      }
      localRichStatusTmp.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.rich_status_tmp.set(localRichStatusTmp);
    return true;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return 8006;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.SameStateRoutingType
 * JD-Core Version:    0.7.0.1
 */