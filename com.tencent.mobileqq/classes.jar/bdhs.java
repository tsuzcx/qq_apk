import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class bdhs
  extends Handler
{
  bdhs(bdhq parambdhq, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    synchronized (this.a)
    {
      if (bdhq.a(this.a) != null) {
        bdhq.a(this.a).a(bdhq.a(this.a));
      }
      while (!QLog.isDevelopLevel())
      {
        super.handleMessage(paramMessage);
        return;
      }
      QLog.d("QQLSActivity", 4, "QQLSSensor handler callback=null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdhs
 * JD-Core Version:    0.7.0.1
 */