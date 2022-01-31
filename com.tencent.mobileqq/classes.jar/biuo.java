import cooperation.qqreader.QRBridgeUtil;
import java.util.Map;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

public final class biuo
  implements WtTicketPromise
{
  public biuo(String paramString) {}
  
  public void Done(Ticket paramTicket)
  {
    if (paramTicket != null)
    {
      bixe.d("QRBridgeUtil", "preGetKeyInPreloadService : Done");
      paramTicket = (byte[])paramTicket._pskey_map.get(this.a);
      if (paramTicket != null) {
        QRBridgeUtil.access$000().put(this.a, new String(paramTicket));
      }
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    bixe.d("QRBridgeUtil", "preGetKeyInPreloadService failed " + paramErrMsg);
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    bixe.d("QRBridgeUtil", "preGetKeyInPreloadService timeout!" + paramErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biuo
 * JD-Core Version:    0.7.0.1
 */