import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class blhe
  extends Handler
{
  public blhe()
  {
    super(Looper.getMainLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramMessage.obj == null);
      paramMessage = ((WeakReference)paramMessage.obj).get();
    } while ((paramMessage == null) || (!(paramMessage instanceof blhb)));
    ((blhb)paramMessage).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blhe
 * JD-Core Version:    0.7.0.1
 */