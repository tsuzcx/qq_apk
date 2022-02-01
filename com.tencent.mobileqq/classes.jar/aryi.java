import android.os.Handler.Callback;
import android.os.Message;

public class aryi
  implements Handler.Callback
{
  private String a;
  
  public aryi(String paramString)
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
    axpo.a(this.a, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryi
 * JD-Core Version:    0.7.0.1
 */