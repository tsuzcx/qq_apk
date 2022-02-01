package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBStringField;
import msf.msgsvc.msg_svc.AddressListTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class ContactRoutingType
  implements RoutingType
{
  public int a()
  {
    return 1006;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new msg_svc.AddressListTmp();
    paramQQAppInterface.from_phone.set(paramMessageRecord.senderuin);
    paramQQAppInterface.to_phone.set(paramMessageRecord.frienduin);
    paramRoutingHead.address_list.set(paramQQAppInterface);
    return true;
  }
  
  public int b()
  {
    return 8005;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.ContactRoutingType
 * JD-Core Version:    0.7.0.1
 */