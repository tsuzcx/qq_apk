import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class bfyb
  extends Handler
{
  public bfyb()
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
    } while ((paramMessage == null) || (!(paramMessage instanceof bfxy)));
    ((bfxy)paramMessage).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfyb
 * JD-Core Version:    0.7.0.1
 */