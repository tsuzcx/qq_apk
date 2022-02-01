import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class bagf
  extends Handler
{
  public bagf(baga parambaga, Looper paramLooper)
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
        baga.a(this.a);
        return;
      }
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
      QLog.e("QzoneGiftManager", 1, "handleMessage exception = " + paramMessage.getMessage());
      return;
    }
    baga.b(this.a);
    return;
    baga.c(this.a);
    return;
    baga.d(this.a);
    return;
    baga.e(this.a);
    return;
    baga.f(this.a);
    return;
    baga.g(this.a);
    return;
    baga.h(this.a);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagf
 * JD-Core Version:    0.7.0.1
 */