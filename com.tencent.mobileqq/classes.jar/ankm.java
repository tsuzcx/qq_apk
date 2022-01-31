import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class ankm
  implements WtTicketPromise
{
  ankm(anke paramanke, TicketManager paramTicketManager, QQAppInterface paramQQAppInterface, String paramString, long paramLong) {}
  
  public void Done(Ticket paramTicket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp", 2, "--- pskey async done---  ");
    }
    paramTicket = this.jdField_a_of_type_MqqManagerTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
    anke.a(this.jdField_a_of_type_Anke, this.jdField_a_of_type_Long, true, paramTicket);
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    QLog.e("ArkApp", 1, "--- pskey async failed---  " + paramErrMsg.getMessage());
    anke.a(this.jdField_a_of_type_Anke, this.jdField_a_of_type_Long, false, null);
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    QLog.e("ArkApp", 1, "--- pskey async timeout---  " + paramErrMsg.getMessage());
    anke.a(this.jdField_a_of_type_Anke, this.jdField_a_of_type_Long, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankm
 * JD-Core Version:    0.7.0.1
 */