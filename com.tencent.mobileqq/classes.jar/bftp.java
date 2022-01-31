import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.util.Pair;

public class bftp
  extends Handler
{
  public bftp(bfto parambfto, Looper paramLooper)
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
    bfto.a(this.a, bfto.a(this.a), (byte[])paramMessage.first, ((Integer)paramMessage.second).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bftp
 * JD-Core Version:    0.7.0.1
 */