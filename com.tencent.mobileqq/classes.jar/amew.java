import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;

public class amew
  extends Handler
{
  public amew(QSecFramework paramQSecFramework, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (paramMessage.arg1 != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSecFramework", 2, "handle native msg for cookie:" + paramMessage.arg1);
      }
      QSecFramework.a(6, paramMessage.arg1, 0, 0, null, null, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     amew
 * JD-Core Version:    0.7.0.1
 */