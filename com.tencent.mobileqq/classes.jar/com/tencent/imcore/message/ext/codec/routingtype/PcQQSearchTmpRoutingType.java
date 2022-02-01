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
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.QQQueryBusinessTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class PcQQSearchTmpRoutingType
  implements RoutingType<AppInterface>
{
  public int a()
  {
    return 1023;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    Object localObject = ((QQAppInterface)paramAppInterface).getMsgCache().h(paramMessageRecord.frienduin);
    paramAppInterface = new msg_svc.QQQueryBusinessTmp();
    paramAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    if (localObject != null)
    {
      paramMessageRecord = new byte[localObject.length - 2];
      PkgTools.copyData(paramMessageRecord, 0, (byte[])localObject, 2, localObject.length - 2);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("wpa------>");
        ((StringBuilder)localObject).append(HexUtil.bytes2HexStr(paramMessageRecord));
        ((StringBuilder)localObject).append(",length:");
        ((StringBuilder)localObject).append(paramMessageRecord.length);
        QLog.d("PcQQSearchTmpRoutingType", 2, ((StringBuilder)localObject).toString());
      }
      paramAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.qq_querybusiness_tmp.set(paramAppInterface);
    return true;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return 8008;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.PcQQSearchTmpRoutingType
 * JD-Core Version:    0.7.0.1
 */