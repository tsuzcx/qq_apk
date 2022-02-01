import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.util.Pair;

public class bjwq
  extends Handler
{
  public bjwq(bjwp parambjwp, Looper paramLooper)
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
    paramMessage = (Pair)paramMessage.obj;
    bjwp.a(this.a, bjwp.a(this.a), (byte[])paramMessage.first, ((Integer)paramMessage.second).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjwq
 * JD-Core Version:    0.7.0.1
 */