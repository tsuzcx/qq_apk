import android.os.Handler.Callback;
import android.os.Message;

public class amwi
  implements Handler.Callback
{
  private String a;
  
  public amwi(String paramString)
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
    aseo.a(this.a, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     amwi
 * JD-Core Version:    0.7.0.1
 */