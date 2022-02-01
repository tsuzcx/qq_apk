package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgResp;

class MessageHandler$HandleSendDiscussionMsgRespPBNotSuccess
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private FromServiceMsg jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
  private ToServiceMsg jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg;
  private String jdField_a_of_type_JavaLangString;
  private msg_svc.PbSendMsgResp jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  public MessageHandler$HandleSendDiscussionMsgRespPBNotSuccess(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, msg_svc.PbSendMsgResp paramPbSendMsgResp, int paramInt1, boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
    this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp = paramPbSendMsgResp;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public HandleSendDiscussionMsgRespPBNotSuccess a()
  {
    int i = this.jdField_a_of_type_Int;
    if ((i == 10) || (i == 34))
    {
      this.jdField_b_of_type_Boolean = true;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.getMessageFacade().b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_Long);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      if (((MessageHandler)localObject2).a((MessageRecord)localObject1, ((MessageHandler)localObject2).a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_b_of_type_Long);
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp);
    Object localObject1 = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData;
    Object localObject2 = new Object[6];
    localObject2[0] = ((Bundle)localObject1).getString("uToUin");
    localObject2[1] = Integer.valueOf(3000);
    localObject2[2] = Integer.valueOf(this.jdField_a_of_type_Int);
    localObject2[3] = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttribute("sendmsgHandler");
    localObject2[4] = Long.valueOf(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.getLong("timeOut"));
    localObject2[5] = Long.valueOf(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((Object[])localObject2, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getUin(), this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(3008, false, localObject2);
    localObject1 = this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp;
    if ((localObject1 != null) && (((msg_svc.PbSendMsgResp)localObject1).errmsg.has()) && (this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp.errmsg.get() != null) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("send dicussion msg failed: ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp.errmsg.get());
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.HandleSendDiscussionMsgRespPBNotSuccess
 * JD-Core Version:    0.7.0.1
 */