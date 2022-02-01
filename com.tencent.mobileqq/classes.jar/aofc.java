import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import tencent.im.troop.homework.ReqSend1V1Msg;
import tencent.im.troop.homework.RspSend1V1Msg;

public class aofc
{
  public static void a(aoep paramaoep, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    homework.RspSend1V1Msg localRspSend1V1Msg = new homework.RspSend1V1Msg();
    homework.ReqSend1V1Msg localReqSend1V1Msg = new homework.ReqSend1V1Msg();
    if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troopManagerTroopHandler", 2, new Object[] { "handleTroopBulkSendMessageRespond failed, no response, error=", paramFromServiceMsg.getBusinessFailMsg() });
      }
      paramaoep.notifyUI(121, false, new Object[] { null, null });
      return;
    }
    try
    {
      localRspSend1V1Msg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.getWupBuffer());
      paramFromServiceMsg = new byte[paramToServiceMsg.getInt() - 4];
      paramToServiceMsg.get(paramFromServiceMsg);
      localReqSend1V1Msg.mergeFrom(paramFromServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troopManagerTroopHandler", 2, new Object[] { "handleTroopBulkSendMessageRespond, ", zel.a(localRspSend1V1Msg) });
      }
      paramaoep.notifyUI(121, true, new Object[] { localRspSend1V1Msg, localReqSend1V1Msg });
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      QLog.e(".troop.troopManagerTroopHandler", 2, "handleTroopBulkSendMessageRespond", paramToServiceMsg);
      paramaoep.notifyUI(121, false, new Object[] { null, null });
    }
  }
  
  public static void a(@NonNull aoep paramaoep, @NonNull homework.ReqSend1V1Msg paramReqSend1V1Msg)
  {
    if (QLog.isColorLevel()) {
      QLog.i(".troop.troopManagerTroopHandler", 2, "sendTroopBulkSendMessageRequest");
    }
    ToServiceMsg localToServiceMsg = paramaoep.createToServiceMsg("HwSvc.send_msg");
    localToServiceMsg.putWupBuffer(paramReqSend1V1Msg.toByteArray());
    paramaoep.a(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aofc
 * JD-Core Version:    0.7.0.1
 */