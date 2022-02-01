import dov.com.qq.im.ae.cmshow.AECMShowRequestController;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

public class bnjb
  implements WtTicketPromise
{
  public bnjb(AECMShowRequestController paramAECMShowRequestController) {}
  
  public void Done(Ticket paramTicket)
  {
    bnrh.b("AECMShowRequestController", "psKey success.");
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    bnrh.d("AECMShowRequestController", paramErrMsg.toString());
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    bnrh.d("AECMShowRequestController", paramErrMsg.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjb
 * JD-Core Version:    0.7.0.1
 */