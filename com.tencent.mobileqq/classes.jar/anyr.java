import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgsvc.msg_svc.PbSendMsgResp;

public class anyr
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
  
  public anyr(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString, msg_svc.PbSendMsgResp paramPbSendMsgResp, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean, Object[] paramArrayOfObject, int paramInt2)
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
  
  public anyr a()
  {
    Object localObject;
    if ((this.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Int == 34))
    {
      this.jdField_b_of_type_Boolean = true;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getMessageFacade().queryMsgItemByUniseq(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_b_of_type_Long);
      if (MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (MessageRecord)localObject, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.removeMessageObserver(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
    }
    long l2;
    long l1;
    if (this.jdField_a_of_type_Int == 299)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB MessageRecord send fail uinseq = " + this.jdField_b_of_type_Long + ", msgseq = " + this.jdField_a_of_type_Long);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getMessageFacade().queryMsgItemByUniseq(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_b_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getMsgCache().a(this.jdField_a_of_type_JavaLangString, 1, this.jdField_b_of_type_Long);
      if (localObject == null) {
        break label401;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB MessageRecord send fail, MessageRecord=" + ((MessageRecord)localObject).toString());
      }
      l2 = ((MessageRecord)localObject).shmsgseq;
      l1 = ((MessageRecord)localObject).time;
    }
    for (;;)
    {
      localObject = new MessageForUniteGrayTip();
      avhz localavhz = new avhz(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangObject[6].toString(), 1, -5040, 131082, l1);
      ((MessageForUniteGrayTip)localObject).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, localavhz);
      ((MessageForUniteGrayTip)localObject).isread = true;
      ((MessageForUniteGrayTip)localObject).shmsgseq = l2;
      avia.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, (MessageForUniteGrayTip)localObject);
      MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp);
      MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, this.jdField_a_of_type_ArrayOfJavaLangObject, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getUin(), this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(3002, false, this.jdField_a_of_type_ArrayOfJavaLangObject);
      this.jdField_a_of_type_Boolean = false;
      return this;
      label401:
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB MessageRecord send fail, uniseq not match !");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getMessageFacade().getMsgList(this.jdField_a_of_type_JavaLangString, 1);
      if ((localObject != null) && (!((List)localObject).isEmpty()) && (((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).shmsgseq > 0L))
      {
        l2 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).shmsgseq;
        l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time;
      }
      else
      {
        l1 = bcrg.a();
        l2 = 0L;
      }
    }
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
 * Qualified Name:     anyr
 * JD-Core Version:    0.7.0.1
 */