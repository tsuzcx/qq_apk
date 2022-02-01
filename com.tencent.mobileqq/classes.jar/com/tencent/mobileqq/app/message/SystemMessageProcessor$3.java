package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.imcore.message.BaseMessageProcessor.RequestBuilder;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgRead;

class SystemMessageProcessor$3
  implements BaseMessageProcessor.RequestBuilder
{
  SystemMessageProcessor$3(SystemMessageProcessor paramSystemMessageProcessor, long paramLong1, long paramLong2, structmsg.ReqSystemMsgRead paramReqSystemMsgRead) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = SystemMessageProcessor.b(this.d).createToServiceMsg("ProfileService.Pb.ReqSystemMsgRead");
    localToServiceMsg.extraData.putLong("latestFriendSeq", this.a);
    localToServiceMsg.extraData.putLong("latestGroupSeq", this.b);
    localToServiceMsg.putWupBuffer(this.c.toByteArray());
    localToServiceMsg.setEnableFastResend(true);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.SystemMessageProcessor.3
 * JD-Core Version:    0.7.0.1
 */