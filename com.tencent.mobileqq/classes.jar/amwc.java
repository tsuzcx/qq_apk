import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgResp;

public class amwc
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
  
  public amwc(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, msg_svc.PbSendMsgResp paramPbSendMsgResp, int paramInt1, boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt2)
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
  
  public amwc a()
  {
    if ((this.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Int == 34))
    {
      this.jdField_b_of_type_Boolean = true;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getMessageFacade().queryMsgItemByUniseq(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_Long);
      if (MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (MessageRecord)localObject, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.removeMessageObserver(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_b_of_type_Long);
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
    }
    MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp);
    Object localObject = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData;
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = ((Bundle)localObject).getString("uToUin");
    arrayOfObject[1] = Integer.valueOf(3000);
    arrayOfObject[2] = Integer.valueOf(this.jdField_a_of_type_Int);
    arrayOfObject[3] = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttribute("sendmsgHandler");
    arrayOfObject[4] = Long.valueOf(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.getLong("timeOut"));
    arrayOfObject[5] = Long.valueOf(this.jdField_a_of_type_Long);
    MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, arrayOfObject, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getUin(), this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(3008, false, arrayOfObject);
    if ((this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp != null) && (this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp.errmsg.has()) && (this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp.errmsg.get() != null) && (QLog.isColorLevel())) {
      QLog.d("Q.msg.MessageHandler", 2, "send dicussion msg failed: " + this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp.errmsg.get());
    }
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwc
 * JD-Core Version:    0.7.0.1
 */