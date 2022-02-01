import android.os.Message;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;

public class amkn
  extends bdzm
{
  public amkn(HotChatCenterFragment paramHotChatCenterFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i == 1003) || (i == 2003)) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkn
 * JD-Core Version:    0.7.0.1
 */