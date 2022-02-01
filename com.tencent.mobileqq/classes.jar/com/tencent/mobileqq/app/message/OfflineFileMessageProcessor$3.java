package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.imcore.message.BaseMessageProcessor.RequestBuilder;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.TransMsgContext;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class OfflineFileMessageProcessor$3
  implements BaseMessageProcessor.RequestBuilder
{
  OfflineFileMessageProcessor$3(OfflineFileMessageProcessor paramOfflineFileMessageProcessor, String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = OfflineFileMessageProcessor.e(this.g).createToServiceMsg("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putString("uin", this.a);
    localToServiceMsg.extraData.putByte("cmd", (byte)0);
    localToServiceMsg.extraData.putByte("keyType", (byte)0);
    localToServiceMsg.extraData.putByte("sendType", (byte)0);
    localToServiceMsg.extraData.putInt("busiType", 1025);
    localToServiceMsg.extraData.putString("toUin", this.a);
    localToServiceMsg.extraData.putLong("sessionid", this.b);
    localToServiceMsg.extraData.putInt("random", this.c);
    localToServiceMsg.extraData.putLong("msgsize", 0L);
    localToServiceMsg.addAttribute("_tag_LOGSTR", String.valueOf(this.d));
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 9);
    localToServiceMsg.extraData.putInt("transC2CCmd", this.e);
    TransMsgContext localTransMsgContext = new TransMsgContext();
    localTransMsgContext.a = this.e;
    localTransMsgContext.b = this.f;
    localToServiceMsg.putWupBuffer(MessageProtoCodec.a(OfflineFileMessageProcessor.f(this.g), 9, this.a, localTransMsgContext, this.d, this.c).toByteArray());
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.OfflineFileMessageProcessor.3
 * JD-Core Version:    0.7.0.1
 */