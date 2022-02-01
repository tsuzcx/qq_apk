package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBStringField;
import msf.msgsvc.msg_svc.AddressListTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class ContactRoutingType
  implements RoutingType<AppInterface>
{
  public int a()
  {
    return 1006;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    paramAppInterface = new msg_svc.AddressListTmp();
    paramAppInterface.from_phone.set(paramMessageRecord.senderuin);
    paramAppInterface.to_phone.set(paramMessageRecord.frienduin);
    paramRoutingHead.address_list.set(paramAppInterface);
    return true;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return 8005;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.ContactRoutingType
 * JD-Core Version:    0.7.0.1
 */