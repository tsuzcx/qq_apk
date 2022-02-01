import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class bgdp
  extends Handler
{
  public bgdp(bgdn parambgdn, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 2: 
          return;
        }
      }
      finally {}
      paramMessage = paramMessage.getData();
      this.a.b(paramMessage.getDouble("startTime"), paramMessage.getStringArray("pinyins"));
      this.a.a(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdp
 * JD-Core Version:    0.7.0.1
 */