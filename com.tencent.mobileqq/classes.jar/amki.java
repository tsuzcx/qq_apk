import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class amki
  implements abso
{
  amki(amkh paramamkh, byte[] paramArrayOfByte, int paramInt) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = amkh.a(this.jdField_a_of_type_Amkh).createToServiceMsg("MessageSvc.GetMsgV4");
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "--->getC2CMessage cChannel: 4vCookies: " + this.jdField_a_of_type_ArrayOfByte + ",cSyncFlag:" + this.jdField_a_of_type_Int);
    }
    localToServiceMsg.extraData.putByte("cChannel", (byte)4);
    localToServiceMsg.extraData.putByteArray("vCookies", this.jdField_a_of_type_ArrayOfByte);
    localToServiceMsg.extraData.putInt("cSyncFlag", this.jdField_a_of_type_Int);
    localToServiceMsg.extraData.putByte("onlineSyncFlag", (byte)1);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amki
 * JD-Core Version:    0.7.0.1
 */