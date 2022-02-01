import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class avdv
  implements WtTicketPromise
{
  avdv(avdu paramavdu, String paramString) {}
  
  public void Done(Ticket paramTicket)
  {
    if (DeleteFaceFragment.a(this.jdField_a_of_type_Avdu.a))
    {
      QLog.d("DeleteFaceFragment", 1, "GetSkey Done, activity is empty");
      return;
    }
    QLog.d("DeleteFaceFragment", 1, "GetSkey done");
    if ((paramTicket == null) || (paramTicket._sig == null))
    {
      QLog.e("DeleteFaceFragment", 1, "ticket is error");
      DeleteFaceFragment.a(this.jdField_a_of_type_Avdu.a, this.jdField_a_of_type_Avdu.a.getString(2131693975));
      return;
    }
    paramTicket = new String(paramTicket._sig);
    DeleteFaceFragment.a(this.jdField_a_of_type_Avdu.a, this.jdField_a_of_type_JavaLangString, paramTicket);
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    QLog.e("DeleteFaceFragment", 1, new Object[] { "getSkey Failed, ", paramErrMsg.getMessage() });
    DeleteFaceFragment.a(this.jdField_a_of_type_Avdu.a, paramErrMsg.getMessage());
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    QLog.e("DeleteFaceFragment", 1, new Object[] { "getSkey timeout, ", paramErrMsg.getMessage() });
    DeleteFaceFragment.a(this.jdField_a_of_type_Avdu.a, paramErrMsg.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdv
 * JD-Core Version:    0.7.0.1
 */