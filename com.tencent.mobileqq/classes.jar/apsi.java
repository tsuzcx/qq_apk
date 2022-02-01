import android.content.SharedPreferences;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class apsi
{
  static SimpleDateFormat a;
  static SimpleDateFormat b;
  
  public static long a(String paramString)
  {
    if (a == null)
    {
      a = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
      a.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    long l2 = -1L;
    try
    {
      l1 = a.parse(paramString).getTime();
      if (QLog.isColorLevel()) {
        QLog.d("ArMapUtil", 2, "data2Millis, date = " + paramString + ",millis = " + l1);
      }
      return l1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("ArMapUtil", 2, "", localException);
          l1 = l2;
        }
      }
    }
  }
  
  public static SharedPreferences a(AppRuntime paramAppRuntime)
  {
    return paramAppRuntime.getApplication().getSharedPreferences(paramAppRuntime.getAccount() + "sp_ar_map", 4);
  }
  
  public static long b(String paramString)
  {
    if (b == null)
    {
      b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      b.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    long l2 = -1L;
    try
    {
      l1 = b.parse(paramString).getTime();
      if (QLog.isColorLevel()) {
        QLog.d("ArMapUtil", 2, "data2Millis1, date = " + paramString + ",millis = " + l1);
      }
      return l1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("ArMapUtil", 2, "", localException);
          l1 = l2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsi
 * JD-Core Version:    0.7.0.1
 */