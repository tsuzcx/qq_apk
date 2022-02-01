import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class bazp
  extends Handler
{
  public bazp(bazk parambazk, Looper paramLooper)
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
        bazk.a(this.a);
        return;
      }
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
      QLog.e("QzoneGiftManager", 1, "handleMessage exception = " + paramMessage.getMessage());
      return;
    }
    bazk.b(this.a);
    return;
    bazk.c(this.a);
    return;
    bazk.d(this.a);
    return;
    bazk.e(this.a);
    return;
    bazk.f(this.a);
    return;
    bazk.g(this.a);
    return;
    bazk.h(this.a);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazp
 * JD-Core Version:    0.7.0.1
 */