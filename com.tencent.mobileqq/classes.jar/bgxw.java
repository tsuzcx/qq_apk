import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.HashMap;

public class bgxw
{
  private static final HashMap<String, bgxx> a = new HashMap();
  
  private static void a(bgxx parambgxx)
  {
    if (parambgxx != null) {
      try
      {
        String str = parambgxx.a();
        QMLog.d("MiniProgramLpReportDC05", "doReport " + str);
        QMLog.d("MiniProgramLpReportDC05", "doReport " + parambgxx.toString());
        Bundle localBundle = new Bundle();
        localBundle.putStringArray("data", new String[] { str });
        if (QUAUtil.isQQApp()) {}
        for (str = "dc05115";; str = "dc05387")
        {
          localBundle.putString("log_key", str);
          bgpn.a().a("cmd_dc_report_log_key_data", localBundle, null);
          parambgxx.a();
          return;
        }
        return;
      }
      catch (Exception parambgxx)
      {
        QMLog.e("MiniProgramLpReportDC05", "doReport ", parambgxx);
      }
    }
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (bgxx)a.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null)
      {
        bgxx.a(paramMiniAppInfo, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
        a(paramMiniAppInfo);
      }
    }
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (bgxx)a.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null) {
        paramMiniAppInfo.a(paramLong2, paramLong1, paramInt);
      }
    }
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (bgxx)a.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null) {
        paramMiniAppInfo.a(paramLong, paramInt, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgxw
 * JD-Core Version:    0.7.0.1
 */