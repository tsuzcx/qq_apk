import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.net.MalformedURLException;
import java.net.URL;

public class bhcf
{
  public static void a(MiniAppInfo paramMiniAppInfo, String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject;
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.appId != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramLong1 == 0L) {
        break label349;
      }
      localObject = "1";
    }
    for (;;)
    {
      String str4 = QUAUtil.getQUA();
      String str5 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId();
      String str6 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion();
      String str7 = QUAUtil.getLoginType();
      try
      {
        String str1 = new URL(paramString).getHost();
        if (paramString.indexOf('?') != -1)
        {
          str3 = paramString.substring(0, paramString.indexOf('?'));
          paramString = paramMiniAppInfo.appId + '|' + paramString + '|' + (String)localObject + '|' + String.valueOf(paramInt) + '|' + paramLong2 + '|' + paramLong1 + '|' + str1 + '|' + str3 + '|' + bhcg.a() + '|' + paramMiniAppInfo.getReportType() + '|' + "Android" + '|' + System.currentTimeMillis();
          paramMiniAppInfo = paramString;
          if (!QUAUtil.isQQApp()) {
            paramMiniAppInfo = paramString + '|' + str4 + '|' + str5 + '|' + str6 + '|' + str7;
          }
          localObject = new Bundle();
          if (!QUAUtil.isQQApp()) {
            break label379;
          }
          paramString = "dc05116";
          ((Bundle)localObject).putString("log_key", paramString);
          ((Bundle)localObject).putStringArray("data", new String[] { paramMiniAppInfo });
          bgtu.a().a("cmd_dc_report_log_key_data", (Bundle)localObject, null);
          return;
          label349:
          localObject = "0";
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QMLog.e("MiniProgramLpReportDC05", "reportOneHttpOrDownloadRequest", localMalformedURLException);
          String str2 = paramString;
          continue;
          String str3 = paramString;
          continue;
          label379:
          paramString = "dc05388";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhcf
 * JD-Core Version:    0.7.0.1
 */