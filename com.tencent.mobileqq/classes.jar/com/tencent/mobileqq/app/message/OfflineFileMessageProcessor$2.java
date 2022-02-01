package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.imcore.message.BaseMessageProcessor.RequestBuilder;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.proto.FMTransC2CMsgInfo;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.TransMsgContext;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class OfflineFileMessageProcessor$2
  implements BaseMessageProcessor.RequestBuilder
{
  OfflineFileMessageProcessor$2(OfflineFileMessageProcessor paramOfflineFileMessageProcessor, String paramString, FMTransC2CMsgInfo paramFMTransC2CMsgInfo, int paramInt, byte[] paramArrayOfByte) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = OfflineFileMessageProcessor.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageOfflineFileMessageProcessor).createToServiceMsg("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_JavaLangString);
    localToServiceMsg.extraData.putLong("msgsize", 0L);
    localToServiceMsg.extraData.putLong("uniseq", this.jdField_a_of_type_ComTencentMobileqqFilemanagerProtoFMTransC2CMsgInfo.uniseq);
    localToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
    localToServiceMsg.extraData.putString("uuid", this.jdField_a_of_type_ComTencentMobileqqFilemanagerProtoFMTransC2CMsgInfo.uuid);
    localToServiceMsg.extraData.putByte("cmd", (byte)0);
    localToServiceMsg.extraData.putByte("keyType", (byte)0);
    localToServiceMsg.extraData.putInt("busiType", this.jdField_a_of_type_ComTencentMobileqqFilemanagerProtoFMTransC2CMsgInfo.busiType);
    localToServiceMsg.extraData.putString("toUin", this.jdField_a_of_type_JavaLangString);
    localToServiceMsg.extraData.putLong("queueSeq", this.jdField_a_of_type_ComTencentMobileqqFilemanagerProtoFMTransC2CMsgInfo.queueSeq);
    localToServiceMsg.extraData.putLong("sessionid", this.jdField_a_of_type_ComTencentMobileqqFilemanagerProtoFMTransC2CMsgInfo.sessionId);
    localToServiceMsg.extraData.putInt("random", MessageUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerProtoFMTransC2CMsgInfo.msgUid));
    localToServiceMsg.addAttribute("_tag_LOGSTR", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerProtoFMTransC2CMsgInfo.msgSeq));
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
    localToServiceMsg.extraData.putInt("transC2CCmd", this.jdField_a_of_type_Int);
    TransMsgContext localTransMsgContext = new TransMsgContext();
    localTransMsgContext.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerProtoFMTransC2CMsgInfo.subCmd;
    localTransMsgContext.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    msg_svc.PbSendMsgReq localPbSendMsgReq = MessageProtoCodec.a(OfflineFileMessageProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageOfflineFileMessageProcessor), 13, this.jdField_a_of_type_JavaLangString, localTransMsgContext, this.jdField_a_of_type_ComTencentMobileqqFilemanagerProtoFMTransC2CMsgInfo.msgSeq, MessageUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerProtoFMTransC2CMsgInfo.msgUid));
    OfflineFileMessageProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageOfflineFileMessageProcessor, localPbSendMsgReq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerProtoFMTransC2CMsgInfo);
    OfflineFileMessageProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageOfflineFileMessageProcessor, localPbSendMsgReq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerProtoFMTransC2CMsgInfo, localTransMsgContext);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerProtoFMTransC2CMsgInfo.entity != null) {
      localToServiceMsg.extraData.putLong("tmpSessionType", this.jdField_a_of_type_ComTencentMobileqqFilemanagerProtoFMTransC2CMsgInfo.entity.tmpSessionType);
    }
    if (QFileAssistantUtils.a(this.jdField_a_of_type_JavaLangString)) {
      OfflineFileMessageProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageOfflineFileMessageProcessor, localPbSendMsgReq);
    }
    localToServiceMsg.putWupBuffer(localPbSendMsgReq.toByteArray());
    localToServiceMsg.extraData.putLong(FileTransferObserver.class.getName(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerProtoFMTransC2CMsgInfo.observerSeq);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.OfflineFileMessageProcessor.2
 * JD-Core Version:    0.7.0.1
 */