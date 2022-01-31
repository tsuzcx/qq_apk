import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.util.Pair;

public class bdtu
  extends Handler
{
  public bdtu(bdtt parambdtt, Looper paramLooper)
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
    bdtt.a(this.a, bdtt.a(this.a), (byte[])paramMessage.first, ((Integer)paramMessage.second).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdtu
 * JD-Core Version:    0.7.0.1
 */