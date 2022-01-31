import android.os.Handler;
import android.os.Message;

public class arnn
  extends Handler
{
  arnm a;
  
  protected arnn(arnm paramarnm)
  {
    this.a = paramarnm;
  }
  
  protected void a()
  {
    this.a = null;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      paramMessage = (String)paramMessage.obj;
      this.a.a(paramMessage);
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arnn
 * JD-Core Version:    0.7.0.1
 */