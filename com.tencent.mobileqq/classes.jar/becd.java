import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.ReSendCmd;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class becd
  implements WtTicketPromise
{
  becd(becb parambecb, TicketManager paramTicketManager, ReSendCmd paramReSendCmd) {}
  
  public void Done(Ticket paramTicket)
  {
    int i;
    if (paramTicket == null) {
      i = 1;
    }
    for (;;)
    {
      QLog.i("TeamWorkHandler", 1, "getSkeyFromServerAndRetry get skey from server : Done,result: " + i);
      paramTicket = this.jdField_a_of_type_MqqManagerTicketManager.getSkey(this.jdField_a_of_type_Becb.mApp.getCurrentAccountUin());
      if ((!TextUtils.isEmpty(paramTicket)) && (paramTicket.length() > 0))
      {
        becb.b(this.jdField_a_of_type_Becb, 0);
        QLog.i("TeamWorkHandler", 1, "getSkeyFromServerAndRetry get skey from server success!");
      }
      becb.a(this.jdField_a_of_type_Becb, this.jdField_a_of_type_ComTencentMobileqqTeamworkReSendCmd);
      return;
      if ((paramTicket != null) && (paramTicket._sig == null)) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    QLog.i("TeamWorkHandler", 1, "getSkeyFromServerAndRetry get skey from server : Failed, " + paramErrMsg);
    becb.a(this.jdField_a_of_type_Becb, this.jdField_a_of_type_ComTencentMobileqqTeamworkReSendCmd);
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    QLog.i("TeamWorkHandler", 1, "getSkeyFromServerAndRetry get skey from server : Timeout, " + paramErrMsg);
    becb.a(this.jdField_a_of_type_Becb, this.jdField_a_of_type_ComTencentMobileqqTeamworkReSendCmd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     becd
 * JD-Core Version:    0.7.0.1
 */