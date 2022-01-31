import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bgsg
  extends Handler
{
  public bgsg(bgse parambgse)
  {
    super(Looper.getMainLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgsg
 * JD-Core Version:    0.7.0.1
 */