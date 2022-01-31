import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;

public abstract interface amrx
{
  public abstract boolean getHasPulledSourceMsg();
  
  public abstract MessageForReplyText.SourceMsgInfo getSourceMsgInfo();
  
  public abstract void setPulledSourceMsg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     amrx
 * JD-Core Version:    0.7.0.1
 */