import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class amgo
  implements abnz
{
  amgo(amgn paramamgn, String paramString, FMTransC2CMsgInfo paramFMTransC2CMsgInfo, int paramInt, byte[] paramArrayOfByte) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = amgn.a(this.jdField_a_of_type_Amgn).createToServiceMsg("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_JavaLangString);
    localToServiceMsg.extraData.putLong("msgsize", 0L);
    localToServiceMsg.extraData.putLong("uniseq", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.uniseq);
    localToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
    localToServiceMsg.extraData.putString("uuid", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.uuid);
    localToServiceMsg.extraData.putByte("cmd", (byte)0);
    localToServiceMsg.extraData.putByte("keyType", (byte)0);
    localToServiceMsg.extraData.putInt("busiType", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.busiType);
    localToServiceMsg.extraData.putString("toUin", this.jdField_a_of_type_JavaLangString);
    localToServiceMsg.extraData.putLong("queueSeq", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.queueSeq);
    localToServiceMsg.extraData.putLong("sessionid", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.sessionId);
    localToServiceMsg.extraData.putInt("random", ayvy.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.msgUid));
    localToServiceMsg.addAttribute("_tag_LOGSTR", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.msgSeq));
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
    localToServiceMsg.extraData.putInt("transC2CCmd", this.jdField_a_of_type_Int);
    aywb localaywb = new aywb();
    localaywb.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.subCmd;
    localaywb.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    msg_svc.PbSendMsgReq localPbSendMsgReq = ayvu.a(amgn.a(this.jdField_a_of_type_Amgn), 13, this.jdField_a_of_type_JavaLangString, localaywb, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.msgSeq, ayvy.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.msgUid));
    amgn.a(this.jdField_a_of_type_Amgn, localPbSendMsgReq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo);
    amgn.a(this.jdField_a_of_type_Amgn, localPbSendMsgReq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo, localaywb);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.entity != null) {
      localToServiceMsg.extraData.putLong("tmpSessionType", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.entity.tmpSessionType);
    }
    localToServiceMsg.putWupBuffer(localPbSendMsgReq.toByteArray());
    localToServiceMsg.extraData.putLong(aqpg.class.getName(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.observerSeq);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amgo
 * JD-Core Version:    0.7.0.1
 */