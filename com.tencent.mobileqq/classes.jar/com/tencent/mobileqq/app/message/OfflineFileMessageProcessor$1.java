package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.imcore.message.BaseMessageProcessor.RequestBuilder;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.proto.FMTransC2CMsgInfo;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.TransMsgContext;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class OfflineFileMessageProcessor$1
  implements BaseMessageProcessor.RequestBuilder
{
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = OfflineFileMessageProcessor.a(this.h).createToServiceMsg("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putString("uin", this.a);
    localToServiceMsg.extraData.putLong("msgsize", 0L);
    localToServiceMsg.extraData.putLong("uniseq", this.b.uniseq);
    localToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
    localToServiceMsg.extraData.putString("uuid", this.b.uuid);
    localToServiceMsg.extraData.putByte("cmd", (byte)0);
    localToServiceMsg.extraData.putByte("keyType", (byte)0);
    localToServiceMsg.extraData.putInt("busiType", this.b.busiType);
    localToServiceMsg.extraData.putString("toUin", this.a);
    localToServiceMsg.extraData.putLong("queueSeq", this.b.queueSeq);
    localToServiceMsg.extraData.putLong("sessionid", this.b.sessionId);
    localToServiceMsg.extraData.putInt("random", MessageUtils.b(this.b.msgUid));
    localToServiceMsg.addAttribute("_tag_LOGSTR", String.valueOf(this.b.msgSeq));
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
    localToServiceMsg.extraData.putInt("transC2CCmd", this.c);
    TransMsgContext localTransMsgContext = new TransMsgContext();
    localTransMsgContext.a = this.b.subCmd;
    localTransMsgContext.b = this.d;
    localToServiceMsg.putWupBuffer(MessageProtoCodec.a(OfflineFileMessageProcessor.b(this.h), this.a, this.e, this.f, this.g, localTransMsgContext, this.b.msgSeq, MessageUtils.b(this.b.msgUid)).toByteArray());
    localToServiceMsg.extraData.putLong(FileTransferObserver.class.getName(), this.b.observerSeq);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.OfflineFileMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */