import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class azth
  extends Handler
{
  public azth(aztc paramaztc, Looper paramLooper)
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
        aztc.a(this.a);
        return;
      }
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
      QLog.e("QzoneGiftManager", 1, "handleMessage exception = " + paramMessage.getMessage());
      return;
    }
    aztc.b(this.a);
    return;
    aztc.c(this.a);
    return;
    aztc.d(this.a);
    return;
    aztc.e(this.a);
    return;
    aztc.f(this.a);
    return;
    aztc.g(this.a);
    return;
    aztc.h(this.a);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azth
 * JD-Core Version:    0.7.0.1
 */