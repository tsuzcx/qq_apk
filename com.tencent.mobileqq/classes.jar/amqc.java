import android.os.Message;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

public class amqc
  extends TransProcessorHandler
{
  public amqc(HotChatCenterFragment paramHotChatCenterFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i == 1003) || (i == 2003)) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqc
 * JD-Core Version:    0.7.0.1
 */