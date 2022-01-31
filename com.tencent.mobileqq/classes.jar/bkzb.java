import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;

public class bkzb
  extends Handler
{
  public bkzb(BaseShortVideoOprerator paramBaseShortVideoOprerator, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkzb
 * JD-Core Version:    0.7.0.1
 */