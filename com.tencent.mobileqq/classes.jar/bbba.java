import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

public final class bbba
  implements WtTicketPromise
{
  public bbba(String paramString, long paramLong) {}
  
  public void Done(Ticket paramTicket)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("pt4_token response received for ").append(this.jdField_a_of_type_JavaLangString).append(", cost=").append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      if (paramTicket == null) {
        break label64;
      }
    }
    label64:
    for (paramTicket = "";; paramTicket = ". But result was null!")
    {
      QLog.d("SwiftBrowserCookieMonster", 2, paramTicket);
      return;
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SwiftBrowserCookieMonster", 2, "Get pt4_token failed for " + this.jdField_a_of_type_JavaLangString + " because " + paramErrMsg + ", cost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SwiftBrowserCookieMonster", 2, "Get pt4_token timeout for " + this.jdField_a_of_type_JavaLangString + " because " + paramErrMsg + ", cost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bbba
 * JD-Core Version:    0.7.0.1
 */