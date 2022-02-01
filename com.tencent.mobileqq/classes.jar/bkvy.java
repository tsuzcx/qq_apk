import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

final class bkvy
  implements WtTicketPromise
{
  bkvy(bkvz parambkvz, String paramString) {}
  
  public void Done(Ticket paramTicket)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletUtils", 2, "get pskey async success!");
    }
    if (this.jdField_a_of_type_Bkvz != null) {
      this.jdField_a_of_type_Bkvz.a(0, new String[] { bkvx.a(paramTicket, this.jdField_a_of_type_JavaLangString) });
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletUtils", 2, "preGetKey. PSk Failed!!!");
    }
    if (this.jdField_a_of_type_Bkvz != null) {
      this.jdField_a_of_type_Bkvz.a(-1, new String[] { paramErrMsg.getMessage() });
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletUtils", 2, "preGetKey. PSk Timeout!");
    }
    if (this.jdField_a_of_type_Bkvz != null) {
      this.jdField_a_of_type_Bkvz.a(-1, new String[] { paramErrMsg.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvy
 * JD-Core Version:    0.7.0.1
 */