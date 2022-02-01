import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cooperation.troop.TroopPluginManager;

public class bmiw
  extends Handler
{
  public bmiw(TroopPluginManager paramTroopPluginManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    ((bmiz)paramMessage.obj).a(paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmiw
 * JD-Core Version:    0.7.0.1
 */