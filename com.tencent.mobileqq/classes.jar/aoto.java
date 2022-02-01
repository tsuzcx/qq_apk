import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgRead;

class aoto
  implements aczq
{
  aoto(aoti paramaoti, long paramLong1, long paramLong2, structmsg.ReqSystemMsgRead paramReqSystemMsgRead) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = aoti.a(this.jdField_a_of_type_Aoti).createToServiceMsg("ProfileService.Pb.ReqSystemMsgRead");
    localToServiceMsg.extraData.putLong("latestFriendSeq", this.jdField_a_of_type_Long);
    localToServiceMsg.extraData.putLong("latestGroupSeq", this.b);
    localToServiceMsg.putWupBuffer(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$ReqSystemMsgRead.toByteArray());
    localToServiceMsg.setEnableFastResend(true);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoto
 * JD-Core Version:    0.7.0.1
 */