import cooperation.qqreader.QRBridgeUtil;
import java.util.Map;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

public final class biyv
  implements WtTicketPromise
{
  public biyv(String paramString) {}
  
  public void Done(Ticket paramTicket)
  {
    if (paramTicket != null)
    {
      bjbl.d("QRBridgeUtil", "preGetKeyInPreloadService : Done");
      paramTicket = (byte[])paramTicket._pskey_map.get(this.a);
      if (paramTicket != null) {
        QRBridgeUtil.access$000().put(this.a, new String(paramTicket));
      }
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    bjbl.d("QRBridgeUtil", "preGetKeyInPreloadService failed " + paramErrMsg);
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    bjbl.d("QRBridgeUtil", "preGetKeyInPreloadService timeout!" + paramErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biyv
 * JD-Core Version:    0.7.0.1
 */