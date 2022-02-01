package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgAction;

class SystemMessageProcessor$11
  implements ProtoReqManagerImpl.IProtoRespBack
{
  SystemMessageProcessor$11(SystemMessageProcessor paramSystemMessageProcessor) {}
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    ToServiceMsg localToServiceMsg = (ToServiceMsg)paramProtoReq.busiData;
    int i = paramProtoResp.resp.getResultCode();
    boolean bool2 = false;
    if (i != 1000) {
      this.a.a(4012, false, localToServiceMsg);
    }
    label341:
    for (;;)
    {
      boolean bool1;
      try
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        structmsg.RspSystemMsgAction localRspSystemMsgAction = new structmsg.RspSystemMsgAction();
        localRspSystemMsgAction.mergeFrom(paramProtoResp);
        int j = localRspSystemMsgAction.head.result.get();
        paramProtoReq = "";
        if (j == 0)
        {
          bool1 = true;
        }
        else
        {
          String str = localRspSystemMsgAction.head.msg_fail.get();
          paramProtoResp = str;
          if (str == null) {
            paramProtoResp = "";
          }
          localToServiceMsg.extraData.putString("system_msg_action_resp_error_key", paramProtoResp);
          bool1 = false;
        }
        paramProtoResp = localRspSystemMsgAction.msg_detail.get();
        if (paramProtoResp != null) {
          break label341;
        }
        paramProtoResp = paramProtoReq;
        i = -1;
        if (localRspSystemMsgAction.remark_result.has()) {
          i = localRspSystemMsgAction.remark_result.get();
        }
        localToServiceMsg.extraData.putString("system_msg_action_resp_key", paramProtoResp);
        localToServiceMsg.extraData.putInt("system_msg_action_resp_result_code_key", localRspSystemMsgAction.head.result.get());
        localToServiceMsg.extraData.putInt("system_msg_action_resp_type_key", localRspSystemMsgAction.type.get());
        localToServiceMsg.extraData.putString("system_msg_action_resp_invalid_decided_key", localRspSystemMsgAction.msg_invalid_decided.get());
        localToServiceMsg.extraData.putInt("system_msg_action_resp_remark_result_key", i);
        if (QLog.isColorLevel())
        {
          paramProtoReq = new StringBuilder();
          paramProtoReq.append("sendFriendSystemMsgActionResp result:");
          paramProtoReq.append(j);
          paramProtoReq.append(" msg:");
          paramProtoReq.append(paramProtoResp);
          QLog.d("Q.systemmsg.", 2, paramProtoReq.toString());
        }
      }
      catch (Exception paramProtoResp)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", paramProtoResp);
          bool1 = bool2;
        }
      }
      this.a.a(4011, bool1, localToServiceMsg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.SystemMessageProcessor.11
 * JD-Core Version:    0.7.0.1
 */