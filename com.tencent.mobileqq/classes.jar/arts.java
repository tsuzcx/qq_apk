import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;

public abstract interface arts
{
  public abstract boolean getHasPulledSourceMsg();
  
  public abstract MessageForReplyText.SourceMsgInfo getSourceMsgInfo();
  
  public abstract void setPulledSourceMsg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arts
 * JD-Core Version:    0.7.0.1
 */