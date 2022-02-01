package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;

class LifeOnlineElemDecoder$2
  implements Runnable
{
  LifeOnlineElemDecoder$2(LifeOnlineElemDecoder paramLifeOnlineElemDecoder, MessageHandler paramMessageHandler, msg_comm.Msg paramMsg) {}
  
  public void run()
  {
    ((IPublicAccountHandler)this.a.n.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).getAIOHistoryMsg(String.valueOf(this.b.msg_head.from_uin.get()), 0L, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.LifeOnlineElemDecoder.2
 * JD-Core Version:    0.7.0.1
 */