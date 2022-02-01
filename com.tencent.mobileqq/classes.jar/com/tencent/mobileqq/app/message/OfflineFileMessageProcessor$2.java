package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.imcore.message.BaseMessageProcessor.RequestBuilder;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.proto.FMTransC2CMsgInfo;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.TransMsgContext;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class OfflineFileMessageProcessor$2
  implements BaseMessageProcessor.RequestBuilder
{
  OfflineFileMessageProcessor$2(OfflineFileMessageProcessor paramOfflineFileMessageProcessor, String paramString, FMTransC2CMsgInfo paramFMTransC2CMsgInfo, int paramInt, byte[] paramArrayOfByte) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = OfflineFileMessageProcessor.c(this.e).createToServiceMsg("MessageSvc.PbSendMsg");
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
    msg_svc.PbSendMsgReq localPbSendMsgReq = MessageProtoCodec.a(OfflineFileMessageProcessor.d(this.e), 13, this.a, localTransMsgContext, this.b.msgSeq, MessageUtils.b(this.b.msgUid));
    OfflineFileMessageProcessor.a(this.e, localPbSendMsgReq, this.b);
    OfflineFileMessageProcessor.a(this.e, localPbSendMsgReq, this.b, localTransMsgContext);
    if (this.b.entity != null) {
      localToServiceMsg.extraData.putLong("tmpSessionType", this.b.entity.tmpSessionType);
    }
    if (QFileAssistantUtils.a(this.a)) {
      OfflineFileMessageProcessor.a(this.e, localPbSendMsgReq);
    }
    localToServiceMsg.putWupBuffer(localPbSendMsgReq.toByteArray());
    localToServiceMsg.extraData.putLong(FileTransferObserver.class.getName(), this.b.observerSeq);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.OfflineFileMessageProcessor.2
 * JD-Core Version:    0.7.0.1
 */