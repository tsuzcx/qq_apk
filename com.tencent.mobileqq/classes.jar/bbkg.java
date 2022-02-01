import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bbkg
  extends Handler
{
  bbkg(bbkf parambbkf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkg
 * JD-Core Version:    0.7.0.1
 */