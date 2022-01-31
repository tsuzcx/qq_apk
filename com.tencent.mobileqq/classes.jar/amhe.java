import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgAction;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

class amhe
  implements barg
{
  amhe(amha paramamha, int paramInt1, int paramInt2, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, structmsg.StructMsg paramStructMsg, long paramLong) {}
  
  public void a(bari parambari, barh parambarh)
  {
    bool1 = false;
    ToServiceMsg localToServiceMsg = (ToServiceMsg)parambarh.a;
    if (parambari.a.getResultCode() != 1000)
    {
      this.jdField_a_of_type_Amha.a(4012, false, localToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception code:" + parambari.a.getResultCode());
      }
      return;
    }
    for (;;)
    {
      try
      {
        parambari = parambari.a.getWupBuffer();
        localRspSystemMsgAction = new structmsg.RspSystemMsgAction();
        localRspSystemMsgAction.mergeFrom(parambari);
        j = localRspSystemMsgAction.head.result.get();
        if (j != 0) {
          continue;
        }
        bool1 = true;
        parambari = localRspSystemMsgAction.msg_detail.get();
        if (parambari != null) {
          continue;
        }
        parambari = "";
      }
      catch (Exception parambari)
      {
        structmsg.RspSystemMsgAction localRspSystemMsgAction;
        int j;
        int i;
        boolean bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", parambari);
        bool1 = false;
        continue;
        if (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.has()) {
          continue;
        }
        parambarh.a(String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.get(), this.b, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get(), false, bool2, -1L);
        continue;
        continue;
      }
      i = -1;
      if (localRspSystemMsgAction.remark_result.has()) {
        i = localRspSystemMsgAction.remark_result.get();
      }
      localToServiceMsg.extraData.putString("system_msg_action_resp_key", parambari);
      localToServiceMsg.extraData.putInt("system_msg_action_resp_result_code_key", localRspSystemMsgAction.head.result.get());
      localToServiceMsg.extraData.putInt("system_msg_action_resp_type_key", localRspSystemMsgAction.type.get());
      localToServiceMsg.extraData.putString("system_msg_action_resp_invalid_decided_key", localRspSystemMsgAction.msg_invalid_decided.get());
      localToServiceMsg.extraData.putInt("system_msg_action_resp_remark_result_key", i);
      bool2 = localToServiceMsg.extraData.getBoolean("isUncommonlyUsedFrd");
      if ((bool1) && (this.jdField_a_of_type_Int == 0))
      {
        parambarh = (FriendListHandler)amha.a(this.jdField_a_of_type_Amha).a(1);
        if ((this.b != 3016) && (this.b != 2016)) {
          continue;
        }
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has())) {
          parambarh.a(String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.get(), this.b, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get(), false, bool2, -1L);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgActionResp result:" + j + " msg:" + parambari);
      }
      this.jdField_a_of_type_Amha.a(4011, bool1, localToServiceMsg);
      return;
      parambarh = localRspSystemMsgAction.head.msg_fail.get();
      parambari = parambarh;
      if (parambarh == null) {
        parambari = "";
      }
      localToServiceMsg.extraData.putString("system_msg_action_resp_error_key", parambari);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amhe
 * JD-Core Version:    0.7.0.1
 */