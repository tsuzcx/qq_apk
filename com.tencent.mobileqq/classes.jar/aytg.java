import android.app.Application;
import android.content.Context;
import android.telephony.TelephonyManager;
import androidx.core.app.ActivityCompat;
import com.tencent.qphone.base.util.QLog;

public class aytg
{
  public static int a(Context paramContext)
  {
    int i = bhnv.b(paramContext);
    if (i == 1) {
      return 2;
    }
    if (i == 2) {
      return 3;
    }
    if (i == 3) {
      return 4;
    }
    return 1;
  }
  
  public static String a()
  {
    try
    {
      String str = bhlo.a();
      return str;
    }
    catch (Exception localException)
    {
      QLog.i("", 4, "no phone permission");
    }
    return "";
  }
  
  public static String a(Application paramApplication)
  {
    for (;;)
    {
      try
      {
        Object localObject = (TelephonyManager)paramApplication.getSystemService("phone");
        if (ActivityCompat.checkSelfPermission(paramApplication, "android.permission.READ_PHONE_STATE") == 0)
        {
          paramApplication = ((TelephonyManager)localObject).getDeviceId();
          localObject = paramApplication;
          if (paramApplication == null) {
            localObject = "unknown";
          }
          return localObject;
        }
      }
      catch (Exception paramApplication)
      {
        QLog.w("", 4, " get client info error " + paramApplication.getMessage());
        return "unknown";
      }
      paramApplication = "unknown";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aytg
 * JD-Core Version:    0.7.0.1
 */