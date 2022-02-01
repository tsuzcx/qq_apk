import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class bayv
  extends Handler
{
  public bayv(bayq parambayq, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 1: 
        bayq.a(this.a);
        return;
      }
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
      QLog.e("QzoneGiftManager", 1, "handleMessage exception = " + paramMessage.getMessage());
      return;
    }
    bayq.b(this.a);
    return;
    bayq.c(this.a);
    return;
    bayq.d(this.a);
    return;
    bayq.e(this.a);
    return;
    bayq.f(this.a);
    return;
    bayq.g(this.a);
    return;
    bayq.h(this.a);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bayv
 * JD-Core Version:    0.7.0.1
 */