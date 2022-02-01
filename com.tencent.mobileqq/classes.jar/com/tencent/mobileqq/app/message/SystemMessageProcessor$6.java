package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgRead;

class SystemMessageProcessor$6
  implements ProtoReqManagerImpl.IProtoRespBack
{
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    try
    {
      paramProtoResp = paramProtoResp.resp.getWupBuffer();
      paramProtoReq = new structmsg.RspSystemMsgRead();
      paramProtoReq.mergeFrom(paramProtoResp);
      int i = paramProtoReq.head.result.get();
      if (QLog.isColorLevel())
      {
        paramProtoResp = new StringBuilder();
        paramProtoResp.append("clearFriendSystemMsgResp reqSeq=");
        paramProtoResp.append(this.a);
        paramProtoResp.append(";resultCode=");
        paramProtoResp.append(i);
        paramProtoResp.append(";latestFriendSeq=");
        paramProtoResp.append(this.b);
        paramProtoResp.append(";latestGroupSeq=");
        paramProtoResp.append(this.c);
        QLog.d("Q.systemmsg.", 2, paramProtoResp.toString());
        return;
      }
    }
    catch (Exception paramProtoResp)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "clearFriendSystemMsgResp exception", paramProtoResp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.SystemMessageProcessor.6
 * JD-Core Version:    0.7.0.1
 */