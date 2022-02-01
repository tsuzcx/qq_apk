import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bmel
  extends Handler
{
  bmel(bmej parambmej, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 993323) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmel
 * JD-Core Version:    0.7.0.1
 */