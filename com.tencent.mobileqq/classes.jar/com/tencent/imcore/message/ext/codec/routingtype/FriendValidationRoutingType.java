package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.AuthTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class FriendValidationRoutingType
  implements RoutingType
{
  public int a()
  {
    return 1022;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    msg_svc.AuthTmp localAuthTmp = new msg_svc.AuthTmp();
    localAuthTmp.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramMessageRecord = paramQQAppInterface.getMsgCache().h(paramMessageRecord.frienduin);
    if (paramMessageRecord != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendValidationRoutingType", 2, "friendValidation------>" + HexUtil.bytes2HexStr(paramMessageRecord) + ",length:" + paramMessageRecord.length);
      }
      localAuthTmp.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.auth_tmp.set(localAuthTmp);
    return true;
  }
  
  public int b()
  {
    return 6013;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.FriendValidationRoutingType
 * JD-Core Version:    0.7.0.1
 */