package com.tencent.imcore.message;

import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;

class BaseMessageProcessor$3
  implements BaseMessageProcessor.RequestBuilder
{
  BaseMessageProcessor$3(BaseMessageProcessor paramBaseMessageProcessor, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = this.b.r.createToServiceMsg("PbMessageSvc.PbMsgReadedReport");
    localToServiceMsg.putWupBuffer(this.a.toByteArray());
    localToServiceMsg.setEnableFastResend(true);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageProcessor.3
 * JD-Core Version:    0.7.0.1
 */