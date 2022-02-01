package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.imcore.message.BaseMessageProcessor.RequestBuilder;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class UncommonMessageProcessor$1
  implements BaseMessageProcessor.RequestBuilder
{
  UncommonMessageProcessor$1(UncommonMessageProcessor paramUncommonMessageProcessor, MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq) {}
  
  public ToServiceMsg a()
  {
    long l = System.currentTimeMillis();
    ToServiceMsg localToServiceMsg = UncommonMessageProcessor.a(this.c).createToServiceMsg("MessageSvc.PbMultiMsgSend");
    localToServiceMsg.extraData.putLong("uniseq", this.a.uniseq);
    localToServiceMsg.extraData.putInt("msgtype", this.a.msgtype);
    localToServiceMsg.extraData.putLong("key_msg_info_time_start", l);
    localToServiceMsg.putWupBuffer(this.b.toByteArray());
    localToServiceMsg.setTimeout(15000L);
    localToServiceMsg.setEnableFastResend(true);
    if (QLog.isColorLevel())
    {
      int i = MessageUtils.a(this.a.msgUid);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendBlessMsg,  mr_uniseq:");
      localStringBuilder.append(this.a.uniseq);
      localStringBuilder.append(" msgSeq:");
      localStringBuilder.append(this.a.msgseq);
      localStringBuilder.append(" mr_shMsgseq:");
      localStringBuilder.append(this.a.shmsgseq);
      localStringBuilder.append(" mr_msgUid:");
      localStringBuilder.append(this.a.msgUid);
      localStringBuilder.append(" random:");
      localStringBuilder.append(i);
      QLog.d("Q.msg.UncommonMessageProcessor", 2, localStringBuilder.toString());
    }
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.UncommonMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */