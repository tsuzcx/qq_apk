import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class bigm
{
  public static void a(AppInterface paramAppInterface, String paramString, HashMap<String, String> paramHashMap)
  {
    if (a()) {
      b(paramAppInterface, paramString, paramHashMap);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("VSHealthReportUtil", 1, "[reportToBeacon] no need to report to beacon");
  }
  
  private static boolean a()
  {
    return ((Boolean)abac.a().a("is_redirect_aio_to_main_page", Boolean.valueOf(false))).booleanValue();
  }
  
  private static void b(AppInterface paramAppInterface, String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramAppInterface == null)
    {
      QLog.e("VSHealthReportUtil", 1, "[reportToBeacon] report to beacon error, app is null!");
      return;
    }
    if (paramHashMap == null) {
      paramHashMap = new HashMap();
    }
    for (;;)
    {
      paramHashMap.put("userid", paramAppInterface.getCurrentAccountUin());
      paramHashMap.put("platform", "android");
      paramHashMap.put("data_timestamp", String.valueOf(System.currentTimeMillis()));
      bdmc.a(BaseApplication.getContext()).a(paramAppInterface.getCurrentAccountUin(), paramString, true, 0L, 0L, paramHashMap, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bigm
 * JD-Core Version:    0.7.0.1
 */