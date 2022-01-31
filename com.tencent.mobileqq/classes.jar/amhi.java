import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgRead;

class amhi
  implements abnz
{
  amhi(amha paramamha, long paramLong, structmsg.ReqSystemMsgRead paramReqSystemMsgRead) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = amha.b(this.jdField_a_of_type_Amha).createToServiceMsg("ProfileService.Pb.ReqSystemMsgRead");
    localToServiceMsg.extraData.putLong("latestGroupSeq", this.jdField_a_of_type_Long);
    localToServiceMsg.extraData.putLong("type", 1L);
    localToServiceMsg.putWupBuffer(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$ReqSystemMsgRead.toByteArray());
    localToServiceMsg.setEnableFastResend(true);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amhi
 * JD-Core Version:    0.7.0.1
 */