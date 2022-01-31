import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class beii
  extends Handler
{
  beii(beih parambeih, Looper paramLooper)
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
    ((behr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(107)).notifyUI(3, true, Integer.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beii
 * JD-Core Version:    0.7.0.1
 */