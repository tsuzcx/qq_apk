import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class bhrf
  extends Handler
{
  bhrf(bhrd parambhrd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    synchronized (this.a)
    {
      if (bhrd.a(this.a) != null) {
        bhrd.a(this.a).a(bhrd.a(this.a));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhrf
 * JD-Core Version:    0.7.0.1
 */