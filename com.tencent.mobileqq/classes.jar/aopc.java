import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.ProtoReqManager.IProtoRespBack;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgAction;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

class aopc
  implements ProtoReqManager.IProtoRespBack
{
  aopc(aooy paramaooy, int paramInt1, int paramInt2, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, structmsg.StructMsg paramStructMsg, long paramLong) {}
  
  public void onProtoResp(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    bool1 = false;
    ToServiceMsg localToServiceMsg = (ToServiceMsg)paramProtoReq.busiData;
    if (paramProtoResp.resp.getResultCode() != 1000)
    {
      this.jdField_a_of_type_Aooy.a(4012, false, localToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception code:" + paramProtoResp.resp.getResultCode());
      }
      return;
    }
    for (;;)
    {
      try
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        localRspSystemMsgAction = new structmsg.RspSystemMsgAction();
        localRspSystemMsgAction.mergeFrom(paramProtoResp);
        j = localRspSystemMsgAction.head.result.get();
        if (j != 0) {
          continue;
        }
        bool1 = true;
        paramProtoResp = localRspSystemMsgAction.msg_detail.get();
        if (paramProtoResp != null) {
          continue;
        }
        paramProtoResp = "";
      }
      catch (Exception paramProtoResp)
      {
        structmsg.RspSystemMsgAction localRspSystemMsgAction;
        int j;
        int i;
        boolean bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", paramProtoResp);
        bool1 = false;
        continue;
        if (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.has()) {
          continue;
        }
        paramProtoReq.addFriendToFriendList(String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.get(), this.b, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get(), false, bool2, -1L);
        continue;
        continue;
      }
      i = -1;
      if (localRspSystemMsgAction.remark_result.has()) {
        i = localRspSystemMsgAction.remark_result.get();
      }
      localToServiceMsg.extraData.putString("system_msg_action_resp_key", paramProtoResp);
      localToServiceMsg.extraData.putInt("system_msg_action_resp_result_code_key", localRspSystemMsgAction.head.result.get());
      localToServiceMsg.extraData.putInt("system_msg_action_resp_type_key", localRspSystemMsgAction.type.get());
      localToServiceMsg.extraData.putString("system_msg_action_resp_invalid_decided_key", localRspSystemMsgAction.msg_invalid_decided.get());
      localToServiceMsg.extraData.putInt("system_msg_action_resp_remark_result_key", i);
      bool2 = localToServiceMsg.extraData.getBoolean("isUncommonlyUsedFrd");
      if ((bool1) && (this.jdField_a_of_type_Int == 0))
      {
        paramProtoReq = (FriendListHandler)aooy.a(this.jdField_a_of_type_Aooy).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if ((this.b != 3016) && (this.b != 2016)) {
          continue;
        }
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has())) {
          paramProtoReq.addFriendToFriendList(String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.get(), this.b, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get(), false, bool2, -1L);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgActionResp result:" + j + " msg:" + paramProtoResp);
      }
      this.jdField_a_of_type_Aooy.a(4011, bool1, localToServiceMsg);
      return;
      paramProtoReq = localRspSystemMsgAction.head.msg_fail.get();
      paramProtoResp = paramProtoReq;
      if (paramProtoReq == null) {
        paramProtoResp = "";
      }
      localToServiceMsg.extraData.putString("system_msg_action_resp_error_key", paramProtoResp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aopc
 * JD-Core Version:    0.7.0.1
 */