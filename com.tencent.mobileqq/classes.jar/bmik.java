import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

public class bmik
  implements WtTicketPromise
{
  public bmik(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void Done(Ticket paramTicket)
  {
    bmbx.b("AEEditorImageEditFragment", "psKey success.");
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    bmbx.d("AEEditorImageEditFragment", paramErrMsg.toString());
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    bmbx.d("AEEditorImageEditFragment", paramErrMsg.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmik
 * JD-Core Version:    0.7.0.1
 */