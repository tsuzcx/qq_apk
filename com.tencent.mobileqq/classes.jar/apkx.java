import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class apkx
  implements WtTicketPromise
{
  apkx(apkv paramapkv, TicketManager paramTicketManager, QQAppInterface paramQQAppInterface, String paramString, apky paramapky) {}
  
  public void Done(Ticket paramTicket)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ArkApp.GetPSKeyAsyncHandler", 2, "--- pskey async done---  ");
    }
    paramTicket = this.jdField_a_of_type_MqqManagerTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Apky != null) {
      this.jdField_a_of_type_Apky.a(paramTicket);
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, "--- pskey async failed---  " + paramErrMsg.getMessage());
    if (this.jdField_a_of_type_Apky != null) {
      this.jdField_a_of_type_Apky.a(null);
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, "--- pskey async timeout---  " + paramErrMsg.getMessage());
    if (this.jdField_a_of_type_Apky != null) {
      this.jdField_a_of_type_Apky.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apkx
 * JD-Core Version:    0.7.0.1
 */