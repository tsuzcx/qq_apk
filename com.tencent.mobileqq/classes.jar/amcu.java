import android.os.Message;
import com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame;
import mqq.os.MqqHandler;

public class amcu
  extends MqqHandler
{
  public amcu(ContactsInnerFrame paramContactsInnerFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    ContactsInnerFrame.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amcu
 * JD-Core Version:    0.7.0.1
 */