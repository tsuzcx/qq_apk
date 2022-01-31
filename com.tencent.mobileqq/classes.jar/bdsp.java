import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.net.MalformedURLException;
import java.net.URL;

public class bdsp
{
  public static void a(MiniAppInfo paramMiniAppInfo, String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    String str1;
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.appId != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramLong1 == 0L) {
        break label238;
      }
      str1 = "1";
    }
    try
    {
      for (;;)
      {
        String str2 = new URL(paramString).getHost();
        if (paramString.indexOf('?') == -1) {
          break;
        }
        str4 = paramString.substring(0, paramString.indexOf('?'));
        paramMiniAppInfo = paramMiniAppInfo.appId + '|' + paramString + '|' + str1 + '|' + String.valueOf(paramInt) + '|' + paramLong2 + '|' + paramLong1 + '|' + str2 + '|' + str4 + '|' + bdsq.a() + '|' + paramMiniAppInfo.getReportType() + '|' + "Android" + '|' + System.currentTimeMillis();
        paramString = new Bundle();
        paramString.putString("log_key", "dc05116");
        paramString.putStringArray("data", new String[] { paramMiniAppInfo });
        bdkq.a().a("cmd_dc_report_log_key_data", paramString, null);
        return;
        label238:
        str1 = "0";
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        bdnw.d("MiniProgramLpReportDC05", "reportOneHttpOrDownloadRequest", localMalformedURLException);
        String str3 = paramString;
        continue;
        String str4 = paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdsp
 * JD-Core Version:    0.7.0.1
 */