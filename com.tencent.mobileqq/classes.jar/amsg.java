import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class amsg
  extends Handler
{
  amsg(amsf paramamsf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == amsf.a(this.a))
    {
      QLog.d(amsf.a(this.a), 4, "Receive Message!");
      this.a.a();
    }
    for (;;)
    {
      try
      {
        bdll.b(null, "P_CliOper", "Safe_Antiphishing", "", "AlertDialog", "config", 0, 1, "", "", "", "");
        return;
      }
      catch (Exception paramMessage) {}
      if (paramMessage.what == amsf.b(this.a))
      {
        QLog.d(amsf.a(this.a), 4, "Receive Message!");
        try
        {
          bdll.b(null, "P_CliOper", "Safe_Antiphishing", "", "AlertDialog", "config", 0, 0, "", "", "", "");
          return;
        }
        catch (Exception paramMessage) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsg
 * JD-Core Version:    0.7.0.1
 */