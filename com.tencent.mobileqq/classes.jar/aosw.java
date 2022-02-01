import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class aosw
  implements aczq
{
  aosw(aosu paramaosu, String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = aosu.b(this.jdField_a_of_type_Aosu).createToServiceMsg("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_JavaLangString);
    localToServiceMsg.extraData.putByte("cmd", (byte)0);
    localToServiceMsg.extraData.putByte("keyType", (byte)0);
    localToServiceMsg.extraData.putByte("sendType", (byte)0);
    localToServiceMsg.extraData.putInt("busiType", 1025);
    localToServiceMsg.extraData.putString("toUin", this.jdField_a_of_type_JavaLangString);
    localToServiceMsg.extraData.putLong("sessionid", this.jdField_a_of_type_Long);
    localToServiceMsg.extraData.putInt("random", this.jdField_a_of_type_Int);
    localToServiceMsg.extraData.putLong("msgsize", 0L);
    localToServiceMsg.addAttribute("_tag_LOGSTR", String.valueOf(this.jdField_b_of_type_Long));
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 9);
    localToServiceMsg.extraData.putInt("transC2CCmd", this.jdField_b_of_type_Int);
    bcsd localbcsd = new bcsd();
    localbcsd.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    localbcsd.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localToServiceMsg.putWupBuffer(bcrw.a(aosu.b(this.jdField_a_of_type_Aosu), 9, this.jdField_a_of_type_JavaLangString, localbcsd, this.jdField_b_of_type_Long, this.jdField_a_of_type_Int).toByteArray());
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosw
 * JD-Core Version:    0.7.0.1
 */