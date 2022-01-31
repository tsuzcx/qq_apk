import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

public class blmv
  implements WtTicketPromise
{
  public blmv(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void Done(Ticket paramTicket)
  {
    bljn.b(AEEditorImageEditFragment.e(), "psKey success.");
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    bljn.d(AEEditorImageEditFragment.e(), paramErrMsg.toString());
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    bljn.d(AEEditorImageEditFragment.e(), paramErrMsg.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmv
 * JD-Core Version:    0.7.0.1
 */