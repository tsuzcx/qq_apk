import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

class bdyv
  implements Handler.Callback
{
  bdyv(bdys parambdys) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = bdys.a();
      int i = paramMessage.getInt("timer2_interval", 0);
      int m = paramMessage.getInt("timer2_retry_times", 0);
      int j = paramMessage.getInt("timer2_start_hour", 0);
      int k = paramMessage.getInt("timer2_end_hour", 0);
      if ((bdyp.a == 0L) || (NetConnInfoCenter.getServerTimeMillis() - bdyp.a < i))
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, i);
        return true;
      }
      if (this.a.jdField_a_of_type_Int >= m)
      {
        QLog.i("SportManager", 2, "retry time enough cancel task.");
        this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        return true;
      }
      paramMessage = Calendar.getInstance();
      paramMessage.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
      m = paramMessage.get(11);
      if (m >= j)
      {
        paramMessage = this.a;
        paramMessage.jdField_a_of_type_Int += 1;
        this.a.a("timer2 callback report1");
      }
      for (;;)
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, i + 2000);
        return true;
        if (m >= k) {
          break;
        }
        paramMessage.set(11, 0);
        paramMessage.set(12, 0);
        paramMessage.set(13, 0);
        paramMessage.set(14, 0);
        if (bdyp.a - paramMessage.getTimeInMillis() > 0L)
        {
          QLog.i("SportManager", 2, "already report cancel task.");
          this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          return true;
        }
        paramMessage = this.a;
        paramMessage.jdField_a_of_type_Int += 1;
        this.a.a("timer2 callback report2");
      }
      QLog.i("SportManager", 2, "over time cancel task.");
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyv
 * JD-Core Version:    0.7.0.1
 */