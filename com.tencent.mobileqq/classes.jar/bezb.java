import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.HashMap;

public class bezb
{
  private static final HashMap<String, bezc> a = new HashMap();
  
  private static void a(bezc parambezc)
  {
    if (parambezc != null) {
      try
      {
        String str = parambezc.a();
        betc.a("MiniProgramLpReportDC05", "doReport " + str);
        betc.a("MiniProgramLpReportDC05", "doReport " + parambezc.toString());
        Bundle localBundle = new Bundle();
        localBundle.putStringArray("data", new String[] { str });
        if (bfhk.a()) {}
        for (str = "dc05115";; str = "dc05387")
        {
          localBundle.putString("log_key", str);
          bepk.a().a("cmd_dc_report_log_key_data", localBundle, null);
          parambezc.a();
          return;
        }
        return;
      }
      catch (Exception parambezc)
      {
        betc.d("MiniProgramLpReportDC05", "doReport ", parambezc);
      }
    }
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (bezc)a.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null)
      {
        bezc.a(paramMiniAppInfo, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
        a(paramMiniAppInfo);
      }
    }
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (bezc)a.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null) {
        paramMiniAppInfo.a(paramLong2, paramLong1, paramInt);
      }
    }
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (bezc)a.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null) {
        paramMiniAppInfo.a(paramLong, paramInt, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bezb
 * JD-Core Version:    0.7.0.1
 */