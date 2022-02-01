import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

public class bpgt
  implements WtTicketPromise
{
  public bpgt(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void Done(Ticket paramTicket)
  {
    bpam.b(AEEditorImageEditFragment.e(), "psKey success.");
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    bpam.d(AEEditorImageEditFragment.e(), paramErrMsg.toString());
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    bpam.d(AEEditorImageEditFragment.e(), paramErrMsg.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgt
 * JD-Core Version:    0.7.0.1
 */