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
import msf.msgsvc.msg_svc.BusinessWPATmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class BusinessCRMRoutingType
  implements RoutingType<AppInterface>
{
  public int a()
  {
    return 1024;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;
    Object localObject = localQQAppInterface.getMsgCache().d(paramMessageRecord.frienduin);
    paramAppInterface = new msg_svc.BusinessWPATmp();
    paramAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("conversation------>sig:");
        paramMessageRecord.append(HexUtil.bytes2HexStr((byte[])localObject));
        paramMessageRecord.append(",length:");
        paramMessageRecord.append(localObject.length);
        QLog.d("BusinessCRMRoutingType", 2, paramMessageRecord.toString());
      }
      paramAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
    }
    else
    {
      paramMessageRecord = localQQAppInterface.getMsgCache().e(paramMessageRecord.frienduin);
      if (paramMessageRecord != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("conversation------>sigt:");
          ((StringBuilder)localObject).append(HexUtil.bytes2HexStr(paramMessageRecord));
          ((StringBuilder)localObject).append(",length:");
          ((StringBuilder)localObject).append(paramMessageRecord.length);
          QLog.d("BusinessCRMRoutingType", 2, ((StringBuilder)localObject).toString());
        }
        paramAppInterface.sigt.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
    }
    paramRoutingHead.business_wpa_tmp.set(paramAppInterface);
    return true;
  }
  
  public int b()
  {
    return 8010;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.BusinessCRMRoutingType
 * JD-Core Version:    0.7.0.1
 */