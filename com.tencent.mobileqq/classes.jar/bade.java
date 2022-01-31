import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.ReSendCmd;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class bade
  implements WtTicketPromise
{
  bade(badd parambadd, TicketManager paramTicketManager, ReSendCmd paramReSendCmd) {}
  
  public void Done(Ticket paramTicket)
  {
    int i;
    if (paramTicket == null) {
      i = 1;
    }
    for (;;)
    {
      QLog.i("TeamWorkHandler", 1, "getPskeyFromServerAndRetry get pskey from server : Done, result: " + i);
      paramTicket = this.jdField_a_of_type_MqqManagerTicketManager.getPskey(this.jdField_a_of_type_Badd.mApp.getCurrentAccountUin(), "docs.qq.com");
      if ((!TextUtils.isEmpty(paramTicket)) && (paramTicket.length() > 0))
      {
        badd.a(this.jdField_a_of_type_Badd, 0);
        QLog.i("TeamWorkHandler", 1, "getPskeyFromServerAndRetry get pskey from server success!");
      }
      badd.a(this.jdField_a_of_type_Badd, this.jdField_a_of_type_ComTencentMobileqqTeamworkReSendCmd);
      return;
      if ((paramTicket != null) && (paramTicket._pskey_map == null)) {
        i = 2;
      } else if ((paramTicket != null) && (paramTicket._pskey_map != null) && (paramTicket._pskey_map.get("docs.qq.com") == null)) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    QLog.i("TeamWorkHandler", 1, "getPskeyFromServerAndRetry get pskey from server : Failed, " + paramErrMsg);
    badd.a(this.jdField_a_of_type_Badd, this.jdField_a_of_type_ComTencentMobileqqTeamworkReSendCmd);
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    QLog.i("TeamWorkHandler", 1, "getPskeyFromServerAndRetry get pskey from server : Timeout, " + paramErrMsg);
    badd.a(this.jdField_a_of_type_Badd, this.jdField_a_of_type_ComTencentMobileqqTeamworkReSendCmd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bade
 * JD-Core Version:    0.7.0.1
 */