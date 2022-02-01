import com.tencent.mobileqq.data.MessageRecord;
import tencent.im.msg.im_msg_body.RichText;

public abstract interface azla
{
  public abstract MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText);
  
  public abstract void onSend(azlb paramazlb);
  
  public abstract void updateMsg(azlb paramazlb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azla
 * JD-Core Version:    0.7.0.1
 */