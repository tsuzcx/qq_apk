package com.tencent.mobileqq.app;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgsvc.msg_svc.PbSendMsgResp;

class MessageHandler$HandleSendTroopMessageRespPBFail
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private FromServiceMsg jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
  private ToServiceMsg jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg;
  private String jdField_a_of_type_JavaLangString;
  private msg_svc.PbSendMsgResp jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp;
  private boolean jdField_a_of_type_Boolean;
  private Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  public MessageHandler$HandleSendTroopMessageRespPBFail(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString, msg_svc.PbSendMsgResp paramPbSendMsgResp, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean, Object[] paramArrayOfObject, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp = paramPbSendMsgResp;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ArrayOfJavaLangObject = paramArrayOfObject;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public HandleSendTroopMessageRespPBFail a()
  {
    int i = this.jdField_a_of_type_Int;
    Object localObject1;
    Object localObject2;
    if ((i == 10) || (i == 34))
    {
      this.jdField_b_of_type_Boolean = true;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.getMessageFacade().b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_b_of_type_Long);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      if (((MessageHandler)localObject2).a((MessageRecord)localObject1, ((MessageHandler)localObject2).a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
    }
    if (this.jdField_a_of_type_Int == 299)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("<---handleSendTroopMessageRespPB MessageRecord send fail uinseq = ");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_Long);
        ((StringBuilder)localObject1).append(", msgseq = ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
        QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.getMessageFacade().b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_b_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.getMsgCache().a(this.jdField_a_of_type_JavaLangString, 1, this.jdField_b_of_type_Long);
      long l2 = 0L;
      long l1;
      if (localObject1 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("<---handleSendTroopMessageRespPB MessageRecord send fail, MessageRecord=");
          ((StringBuilder)localObject2).append(((MessageRecord)localObject1).toString());
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject2).toString());
        }
        l2 = ((MessageRecord)localObject1).shmsgseq;
        l1 = ((MessageRecord)localObject1).time;
      }
      for (;;)
      {
        break;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB MessageRecord send fail, uniseq not match !");
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, 1);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()) && (((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq > 0L))
        {
          l2 = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq;
          l1 = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time;
        }
        else
        {
          l1 = MessageCache.a();
        }
      }
      localObject1 = new MessageForUniteGrayTip();
      localObject2 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new UniteGrayTipParam((String)localObject2, (String)localObject2, this.jdField_a_of_type_ArrayOfJavaLangObject[6].toString(), 1, -5040, 131082, l1);
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, (UniteGrayTipParam)localObject2);
      ((MessageForUniteGrayTip)localObject1).isread = true;
      ((MessageForUniteGrayTip)localObject1).shmsgseq = l2;
      UniteGrayTipMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, (MessageForUniteGrayTip)localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_a_of_type_ArrayOfJavaLangObject, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getUin(), this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(3002, false, this.jdField_a_of_type_ArrayOfJavaLangObject);
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
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.HandleSendTroopMessageRespPBFail
 * JD-Core Version:    0.7.0.1
 */