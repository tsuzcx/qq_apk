import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;

class anwr
  extends Handler
{
  anwr(anwq paramanwq, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (Pair)paramMessage.obj;
    this.a.b(((Long)paramMessage.first).longValue(), ((Long)paramMessage.second).longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anwr
 * JD-Core Version:    0.7.0.1
 */