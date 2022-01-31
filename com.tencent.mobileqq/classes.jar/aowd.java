import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class aowd
  extends Handler
{
  aowd(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object[] arrayOfObject = (Object[])paramMessage.obj;
    ((aowi)arrayOfObject[0]).a(paramMessage.what, ((Boolean)arrayOfObject[1]).booleanValue(), arrayOfObject[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aowd
 * JD-Core Version:    0.7.0.1
 */