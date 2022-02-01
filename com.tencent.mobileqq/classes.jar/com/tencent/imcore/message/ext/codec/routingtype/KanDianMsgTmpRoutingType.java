package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import msf.msgsvc.msg_svc.CommTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class KanDianMsgTmpRoutingType
  implements RoutingType<AppInterface>
{
  public int a()
  {
    return 10013;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    paramAppInterface = new msg_svc.CommTmp();
    paramAppInterface.c2c_type.set(1);
    paramAppInterface.svr_type.set(170);
    byte[] arrayOfByte = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getKanDianChatSessionKey(paramMessageRecord.frienduin, paramMessageRecord.selfuin);
    if (arrayOfByte != null) {
      paramAppInterface.sig.set(ByteStringMicro.copyFrom(arrayOfByte));
    }
    paramAppInterface.to_uin.set(Long.parseLong(paramMessageRecord.frienduin));
    paramRoutingHead.comm_tmp.set(paramAppInterface);
    return true;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return 8048;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.KanDianMsgTmpRoutingType
 * JD-Core Version:    0.7.0.1
 */