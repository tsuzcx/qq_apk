import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.FriendListHandler;
import mqq.os.MqqHandler;

public class anym
  extends MqqHandler
{
  public anym(FriendListHandler paramFriendListHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    FriendListHandler.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anym
 * JD-Core Version:    0.7.0.1
 */