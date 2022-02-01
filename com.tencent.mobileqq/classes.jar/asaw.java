import android.os.Handler.Callback;
import android.os.Message;

public class asaw
  implements Handler.Callback
{
  private String a;
  
  public asaw(String paramString)
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
    axwe.a(this.a, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asaw
 * JD-Core Version:    0.7.0.1
 */