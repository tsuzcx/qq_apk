import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class biuq
  extends Handler
{
  biuq(biup parambiup, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.arg1;
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    ((bitz)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(107)).notifyUI(3, true, Integer.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biuq
 * JD-Core Version:    0.7.0.1
 */