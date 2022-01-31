import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;

public abstract interface aozq
{
  public abstract boolean getHasPulledSourceMsg();
  
  public abstract MessageForReplyText.SourceMsgInfo getSourceMsgInfo();
  
  public abstract void setPulledSourceMsg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aozq
 * JD-Core Version:    0.7.0.1
 */