import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class aotv
  implements aczq
{
  aotv(aotu paramaotu, MessageRecord paramMessageRecord, boolean paramBoolean, msg_svc.PbSendMsgReq paramPbSendMsgReq) {}
  
  public ToServiceMsg a()
  {
    long l = System.currentTimeMillis();
    ToServiceMsg localToServiceMsg = aotu.a(this.jdField_a_of_type_Aotu).createToServiceMsg("MessageSvc.PbMultiMsgSend");
    localToServiceMsg.extraData.putLong("uniseq", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
    localToServiceMsg.extraData.putInt("msgtype", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype);
    localToServiceMsg.extraData.putBoolean(bcrn.h, this.jdField_a_of_type_Boolean);
    localToServiceMsg.extraData.putLong("key_msg_info_time_start", l);
    localToServiceMsg.putWupBuffer(this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgReq.toByteArray());
    localToServiceMsg.setTimeout(15000L);
    localToServiceMsg.setEnableFastResend(true);
    if (QLog.isColorLevel())
    {
      int i = bcsa.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgUid);
      QLog.d("Q.msg.UncommonMessageProcessor", 2, "sendBlessMsg,  mr_uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + " msgSeq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgseq + " mr_shMsgseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq + " mr_msgUid:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgUid + " random:" + i + " isRedBagVideo:" + this.jdField_a_of_type_Boolean);
    }
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aotv
 * JD-Core Version:    0.7.0.1
 */