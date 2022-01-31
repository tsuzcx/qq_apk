import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

class bajl
  extends Handler
{
  bajl(bajk parambajk, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object[] arrayOfObject = (Object[])paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      paramMessage = (List)arrayOfObject[0];
      boolean bool = ((Boolean)arrayOfObject[1]).booleanValue();
      String str = (String)arrayOfObject[2];
      long l = ((Long)arrayOfObject[3]).longValue();
      this.a.a(paramMessage, bool, str, l);
      return;
    case 2: 
      paramMessage = (azpg)arrayOfObject[0];
      this.a.f(paramMessage);
      return;
    case 3: 
      paramMessage = (azpg)arrayOfObject[0];
      this.a.g(paramMessage);
      return;
    case 4: 
      paramMessage = (azpg)arrayOfObject[0];
      this.a.h(paramMessage);
      return;
    case 5: 
      int i = paramMessage.arg1;
      this.a.a(i);
      return;
    }
    paramMessage = (azpg)arrayOfObject[0];
    this.a.j(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bajl
 * JD-Core Version:    0.7.0.1
 */