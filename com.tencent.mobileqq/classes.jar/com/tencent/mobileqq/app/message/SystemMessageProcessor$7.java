package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.imcore.message.BaseMessageProcessor.RequestBuilder;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgRead;

class SystemMessageProcessor$7
  implements BaseMessageProcessor.RequestBuilder
{
  SystemMessageProcessor$7(SystemMessageProcessor paramSystemMessageProcessor, long paramLong, structmsg.ReqSystemMsgRead paramReqSystemMsgRead) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = SystemMessageProcessor.c(this.c).createToServiceMsg("ProfileService.Pb.ReqSystemMsgRead");
    localToServiceMsg.extraData.putLong("latestGroupSeq", this.a);
    localToServiceMsg.extraData.putLong("type", 1L);
    localToServiceMsg.putWupBuffer(this.b.toByteArray());
    localToServiceMsg.setEnableFastResend(true);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.SystemMessageProcessor.7
 * JD-Core Version:    0.7.0.1
 */