import android.os.Handler.Callback;
import android.os.Message;

public class anmq
  implements Handler.Callback
{
  private String a;
  
  public anmq(String paramString)
  {
    this.a = paramString;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    atas.a(this.a, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     anmq
 * JD-Core Version:    0.7.0.1
 */