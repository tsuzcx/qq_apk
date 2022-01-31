import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgAction;

class amls
  implements bavp
{
  amls(amlp paramamlp) {}
  
  public void a(bavr parambavr, bavq parambavq)
  {
    ToServiceMsg localToServiceMsg = (ToServiceMsg)parambavq.a;
    if (parambavr.a.getResultCode() != 1000) {
      this.a.a(4012, false, localToServiceMsg);
    }
    for (;;)
    {
      try
      {
        parambavr = parambavr.a.getWupBuffer();
        localRspSystemMsgAction = new structmsg.RspSystemMsgAction();
        localRspSystemMsgAction.mergeFrom(parambavr);
        j = localRspSystemMsgAction.head.result.get();
        if (j != 0) {
          continue;
        }
        bool1 = true;
        parambavr = localRspSystemMsgAction.msg_detail.get();
        if (parambavr != null) {
          continue;
        }
        parambavr = "";
      }
      catch (Exception parambavr)
      {
        structmsg.RspSystemMsgAction localRspSystemMsgAction;
        int j;
        boolean bool1;
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", parambavr);
        boolean bool2 = false;
        continue;
        continue;
      }
      i = -1;
      if (localRspSystemMsgAction.remark_result.has()) {
        i = localRspSystemMsgAction.remark_result.get();
      }
      localToServiceMsg.extraData.putString("system_msg_action_resp_key", parambavr);
      localToServiceMsg.extraData.putInt("system_msg_action_resp_result_code_key", localRspSystemMsgAction.head.result.get());
      localToServiceMsg.extraData.putInt("system_msg_action_resp_type_key", localRspSystemMsgAction.type.get());
      localToServiceMsg.extraData.putString("system_msg_action_resp_invalid_decided_key", localRspSystemMsgAction.msg_invalid_decided.get());
      localToServiceMsg.extraData.putInt("system_msg_action_resp_remark_result_key", i);
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgActionResp result:" + j + " msg:" + parambavr);
        bool2 = bool1;
      }
      this.a.a(4011, bool2, localToServiceMsg);
      return;
      parambavq = localRspSystemMsgAction.head.msg_fail.get();
      parambavr = parambavq;
      if (parambavq == null) {
        parambavr = "";
      }
      localToServiceMsg.extraData.putString("system_msg_action_resp_error_key", parambavr);
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amls
 * JD-Core Version:    0.7.0.1
 */