import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class amlb
  extends Handler
{
  amlb(amla paramamla, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == amla.a(this.a))
    {
      QLog.d(amla.a(this.a), 4, "Receive Message!");
      this.a.a();
    }
    for (;;)
    {
      try
      {
        bdla.b(null, "P_CliOper", "Safe_Antiphishing", "", "AlertDialog", "config", 0, 1, "", "", "", "");
        return;
      }
      catch (Exception paramMessage) {}
      if (paramMessage.what == amla.b(this.a))
      {
        QLog.d(amla.a(this.a), 4, "Receive Message!");
        try
        {
          bdla.b(null, "P_CliOper", "Safe_Antiphishing", "", "AlertDialog", "config", 0, 0, "", "", "", "");
          return;
        }
        catch (Exception paramMessage) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlb
 * JD-Core Version:    0.7.0.1
 */