import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class bhbx
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
      QMLog.w("MiniGdtReporter", "report: no need report now " + paramInt);
      return;
    }
    if (paramMiniAppInfo == null)
    {
      QMLog.w("MiniGdtReporter", "report: null config", new Throwable());
      return;
    }
    LaunchParam localLaunchParam = paramMiniAppInfo.launchParam;
    if (localLaunchParam == null)
    {
      QMLog.w("MiniGdtReporter", "report: null param " + paramMiniAppInfo, new Throwable());
      return;
    }
    if (localLaunchParam.scene != 1095)
    {
      QMLog.d("MiniGdtReporter", "report: not form ad " + localLaunchParam.scene);
      return;
    }
    if (localLaunchParam.timestamp == 0L)
    {
      QMLog.w("MiniGdtReporter", "report: no timestamp " + paramMiniAppInfo, new Throwable());
      return;
    }
    String str = null;
    paramMiniAppInfo = str;
    if (!TextUtils.isEmpty(localLaunchParam.navigateExtData)) {}
    try
    {
      paramMiniAppInfo = new JSONObject(localLaunchParam.navigateExtData).optString("reportUrl");
      if (TextUtils.isEmpty(paramMiniAppInfo))
      {
        QMLog.w("MiniGdtReporter", "report: empty url " + localLaunchParam, new Throwable());
        return;
      }
    }
    catch (JSONException paramMiniAppInfo)
    {
      for (;;)
      {
        QMLog.w("MiniGdtReporter", "report: failed to read ext data " + localLaunchParam, paramMiniAppInfo);
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
          str = paramMiniAppInfo.replace("__PAGE_ACTION_ID__", Integer.toString(51)).replace("__PAGE_TIME__", Long.toString(System.currentTimeMillis() - localLaunchParam.timestamp));
          paramMiniAppInfo = str;
        }
        catch (Exception localException1) {}
        try
        {
          str = paramMiniAppInfo.replace("__OS_TYPE__", Integer.toString(2)).replace("__VERSION__", URLEncoder.encode("1.3.1", "utf-8"));
          paramMiniAppInfo = str;
          paramInt = 1;
          if (paramInt == 0) {
            break;
          }
          QMLog.i("MiniGdtReporter", "report: get report url " + paramMiniAppInfo + " " + localLaunchParam.timestamp);
          bhbq.a(paramMiniAppInfo);
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
      QMLog.w("MiniGdtReporter", "report: failed to convert report url " + paramMiniAppInfo + " " + paramInt, localException1);
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhbx
 * JD-Core Version:    0.7.0.1
 */