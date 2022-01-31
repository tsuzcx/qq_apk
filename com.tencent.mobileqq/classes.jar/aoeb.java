import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;

public class aoeb
{
  public MessageRecord a;
  public boolean a;
  public boolean b;
  public boolean c;
  
  public aoeb(MessageRecord paramMessageRecord)
  {
    this.a = paramMessageRecord;
    this.b = (paramMessageRecord instanceof MessageForPic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoeb
 * JD-Core Version:    0.7.0.1
 */