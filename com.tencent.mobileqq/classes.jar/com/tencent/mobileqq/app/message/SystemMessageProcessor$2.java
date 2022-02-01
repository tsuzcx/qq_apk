package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
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
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

class SystemMessageProcessor$2
  implements ProtoReqManagerImpl.IProtoRespBack
{
  SystemMessageProcessor$2(SystemMessageProcessor paramSystemMessageProcessor, int paramInt1, int paramInt2, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, structmsg.StructMsg paramStructMsg, long paramLong) {}
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    ToServiceMsg localToServiceMsg = (ToServiceMsg)paramProtoReq.busiData;
    int i = paramProtoResp.resp.getResultCode();
    boolean bool2 = false;
    if (i != 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageSystemMessageProcessor.a(4012, false, localToServiceMsg);
      if (QLog.isColorLevel())
      {
        paramProtoReq = new StringBuilder();
        paramProtoReq.append("sendFriendSystemMsgReadedReportResp exception code:");
        paramProtoReq.append(paramProtoResp.resp.getResultCode());
        QLog.d("Q.systemmsg.", 2, paramProtoReq.toString());
      }
      return;
    }
    label591:
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
          break label591;
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
        boolean bool3 = localToServiceMsg.extraData.getBoolean("isUncommonlyUsedFrd");
        if ((bool1) && (this.jdField_a_of_type_Int == 0))
        {
          paramProtoReq = (FriendListHandler)SystemMessageProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageSystemMessageProcessor).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
          if ((this.b != 3016) && (this.b != 2016))
          {
            if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.has()) {
              paramProtoReq.addFriendToFriendList(String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.get(), this.b, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get(), false, bool3, -1L);
            }
          }
          else if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has())) {
            paramProtoReq.addFriendToFriendList(String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.get(), this.b, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get(), false, bool3, -1L);
          }
        }
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
      this.jdField_a_of_type_ComTencentMobileqqAppMessageSystemMessageProcessor.a(4011, bool1, localToServiceMsg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.SystemMessageProcessor.2
 * JD-Core Version:    0.7.0.1
 */