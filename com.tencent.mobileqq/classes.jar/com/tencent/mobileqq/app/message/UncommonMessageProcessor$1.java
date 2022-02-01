package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.imcore.message.BaseMessageProcessor.RequestBuilder;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class UncommonMessageProcessor$1
  implements BaseMessageProcessor.RequestBuilder
{
  UncommonMessageProcessor$1(UncommonMessageProcessor paramUncommonMessageProcessor, MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq) {}
  
  public ToServiceMsg a()
  {
    long l = System.currentTimeMillis();
    ToServiceMsg localToServiceMsg = UncommonMessageProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageUncommonMessageProcessor).createToServiceMsg("MessageSvc.PbMultiMsgSend");
    localToServiceMsg.extraData.putLong("uniseq", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
    localToServiceMsg.extraData.putInt("msgtype", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype);
    localToServiceMsg.extraData.putLong("key_msg_info_time_start", l);
    localToServiceMsg.putWupBuffer(this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgReq.toByteArray());
    localToServiceMsg.setTimeout(15000L);
    localToServiceMsg.setEnableFastResend(true);
    if (QLog.isColorLevel())
    {
      int i = MessageUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgUid);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendBlessMsg,  mr_uniseq:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
      localStringBuilder.append(" msgSeq:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgseq);
      localStringBuilder.append(" mr_shMsgseq:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq);
      localStringBuilder.append(" mr_msgUid:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgUid);
      localStringBuilder.append(" random:");
      localStringBuilder.append(i);
      QLog.d("Q.msg.UncommonMessageProcessor", 2, localStringBuilder.toString());
    }
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.UncommonMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */