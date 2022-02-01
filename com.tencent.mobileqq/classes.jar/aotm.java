import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgAction;

class aotm
  implements bevw
{
  aotm(aoti paramaoti) {}
  
  public void a(bevy parambevy, bevx parambevx)
  {
    ToServiceMsg localToServiceMsg = (ToServiceMsg)parambevx.a;
    if (parambevy.a.getResultCode() != 1000) {
      this.a.a(4012, false, localToServiceMsg);
    }
    for (;;)
    {
      try
      {
        parambevy = parambevy.a.getWupBuffer();
        localRspSystemMsgAction = new structmsg.RspSystemMsgAction();
        localRspSystemMsgAction.mergeFrom(parambevy);
        j = localRspSystemMsgAction.head.result.get();
        if (j != 0) {
          continue;
        }
        bool1 = true;
        parambevy = localRspSystemMsgAction.msg_detail.get();
        if (parambevy != null) {
          continue;
        }
        parambevy = "";
      }
      catch (Exception parambevy)
      {
        structmsg.RspSystemMsgAction localRspSystemMsgAction;
        int j;
        boolean bool1;
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", parambevy);
        boolean bool2 = false;
        continue;
        continue;
      }
      i = -1;
      if (localRspSystemMsgAction.remark_result.has()) {
        i = localRspSystemMsgAction.remark_result.get();
      }
      localToServiceMsg.extraData.putString("system_msg_action_resp_key", parambevy);
      localToServiceMsg.extraData.putInt("system_msg_action_resp_result_code_key", localRspSystemMsgAction.head.result.get());
      localToServiceMsg.extraData.putInt("system_msg_action_resp_type_key", localRspSystemMsgAction.type.get());
      localToServiceMsg.extraData.putString("system_msg_action_resp_invalid_decided_key", localRspSystemMsgAction.msg_invalid_decided.get());
      localToServiceMsg.extraData.putInt("system_msg_action_resp_remark_result_key", i);
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgActionResp result:" + j + " msg:" + parambevy);
        bool2 = bool1;
      }
      this.a.a(4011, bool2, localToServiceMsg);
      return;
      parambevx = localRspSystemMsgAction.head.msg_fail.get();
      parambevy = parambevx;
      if (parambevx == null) {
        parambevy = "";
      }
      localToServiceMsg.extraData.putString("system_msg_action_resp_error_key", parambevy);
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aotm
 * JD-Core Version:    0.7.0.1
 */