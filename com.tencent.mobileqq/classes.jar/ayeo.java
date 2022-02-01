import com.tencent.mobileqq.data.MessageRecord;
import tencent.im.msg.im_msg_body.RichText;

public abstract interface ayeo
{
  public abstract MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText);
  
  public abstract void onSend(ayep paramayep);
  
  public abstract void updateMsg(ayep paramayep);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayeo
 * JD-Core Version:    0.7.0.1
 */