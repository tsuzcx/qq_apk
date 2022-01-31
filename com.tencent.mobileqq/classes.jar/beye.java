import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class beye
{
  private static final AtomicBoolean a = new AtomicBoolean(true);
  
  public static void a()
  {
    a.set(false);
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    if (!a.compareAndSet(false, true))
    {
      besl.c("MiniGdtReporter", "report: no need report now " + paramInt);
      return;
    }
    if (paramMiniAppInfo == null)
    {
      besl.c("MiniGdtReporter", "report: null config", new Throwable());
      return;
    }
    LaunchParam localLaunchParam = paramMiniAppInfo.launchParam;
    if (localLaunchParam == null)
    {
      besl.c("MiniGdtReporter", "report: null param " + paramMiniAppInfo, new Throwable());
      return;
    }
    if (localLaunchParam.jdField_a_of_type_Int != 1095)
    {
      besl.a("MiniGdtReporter", "report: not form ad " + localLaunchParam.jdField_a_of_type_Int);
      return;
    }
    if (localLaunchParam.jdField_a_of_type_Long == 0L)
    {
      besl.c("MiniGdtReporter", "report: no timestamp " + paramMiniAppInfo, new Throwable());
      return;
    }
    String str = null;
    paramMiniAppInfo = str;
    if (!TextUtils.isEmpty(localLaunchParam.e)) {}
    try
    {
      paramMiniAppInfo = new JSONObject(localLaunchParam.e).optString("reportUrl");
      if (TextUtils.isEmpty(paramMiniAppInfo))
      {
        besl.c("MiniGdtReporter", "report: empty url " + localLaunchParam, new Throwable());
        return;
      }
    }
    catch (JSONException paramMiniAppInfo)
    {
      for (;;)
      {
        besl.c("MiniGdtReporter", "report: failed to read ext data " + localLaunchParam, paramMiniAppInfo);
        paramMiniAppInfo = str;
      }
    }
    if (paramInt == 0) {}
    for (;;)
    {
      for (;;)
      {
        try
        {
          str = paramMiniAppInfo.replace("__PAGE_ACTION_ID__", Integer.toString(51)).replace("__PAGE_TIME__", Long.toString(System.currentTimeMillis() - localLaunchParam.jdField_a_of_type_Long));
          paramMiniAppInfo = str;
        }
        catch (Exception localException1) {}
        try
        {
          str = paramMiniAppInfo.replace("__OS_TYPE__", Integer.toString(2)).replace("__VERSION__", URLEncoder.encode("1.1.0", "utf-8"));
          paramMiniAppInfo = str;
          paramInt = 1;
          if (paramInt == 0) {
            break;
          }
          besl.b("MiniGdtReporter", "report: get report url " + paramMiniAppInfo + " " + localLaunchParam.jdField_a_of_type_Long);
          bexx.a(paramMiniAppInfo);
          return;
        }
        catch (Exception localException2)
        {
          label409:
          break label409;
        }
      }
      str = paramMiniAppInfo.replace("__PAGE_ACTION_ID__", Integer.toString(52)).replace("__LANDING_ERROR_CODE__", Integer.toString(paramInt));
      paramMiniAppInfo = str;
      continue;
      besl.c("MiniGdtReporter", "report: failed to convert report url " + paramMiniAppInfo + " " + paramInt, localException1);
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beye
 * JD-Core Version:    0.7.0.1
 */