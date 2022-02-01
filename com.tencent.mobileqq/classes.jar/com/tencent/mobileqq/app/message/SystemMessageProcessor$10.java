package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;

class SystemMessageProcessor$10
  implements ProtoReqManagerImpl.IProtoRespBack
{
  SystemMessageProcessor$10(SystemMessageProcessor paramSystemMessageProcessor) {}
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    if (paramProtoResp.resp.getResultCode() != 1000)
    {
      this.a.a(4006, false, null);
      return;
    }
    SystemMessageProcessor.a(this.a, paramProtoResp, paramProtoReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.SystemMessageProcessor.10
 * JD-Core Version:    0.7.0.1
 */