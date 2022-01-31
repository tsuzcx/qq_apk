import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgAction;

class amhd
  implements barg
{
  amhd(amha paramamha) {}
  
  public void a(bari parambari, barh parambarh)
  {
    ToServiceMsg localToServiceMsg = (ToServiceMsg)parambarh.a;
    if (parambari.a.getResultCode() != 1000) {
      this.a.a(4012, false, localToServiceMsg);
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
        boolean bool1;
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", parambari);
        boolean bool2 = false;
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
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgActionResp result:" + j + " msg:" + parambari);
        bool2 = bool1;
      }
      this.a.a(4011, bool2, localToServiceMsg);
      return;
      parambarh = localRspSystemMsgAction.head.msg_fail.get();
      parambari = parambarh;
      if (parambarh == null) {
        parambari = "";
      }
      localToServiceMsg.extraData.putString("system_msg_action_resp_error_key", parambari);
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amhd
 * JD-Core Version:    0.7.0.1
 */