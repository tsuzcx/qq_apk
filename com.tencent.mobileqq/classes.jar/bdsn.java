import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.HashMap;

public class bdsn
{
  private static final HashMap<String, bdso> a = new HashMap();
  
  private static void a(bdso parambdso)
  {
    if (parambdso != null) {}
    try
    {
      String str = parambdso.a();
      bdnw.a("MiniProgramLpReportDC05", "doReport " + str);
      bdnw.a("MiniProgramLpReportDC05", "doReport " + parambdso.toString());
      Bundle localBundle = new Bundle();
      localBundle.putStringArray("data", new String[] { str });
      localBundle.putString("log_key", "dc05115");
      bdkq.a().a("cmd_dc_report_log_key_data", localBundle, null);
      parambdso.a();
      return;
    }
    catch (Exception parambdso)
    {
      bdnw.d("MiniProgramLpReportDC05", "doReport ", parambdso);
    }
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (bdso)a.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null)
      {
        bdso.a(paramMiniAppInfo, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
        a(paramMiniAppInfo);
      }
    }
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (bdso)a.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null) {
        paramMiniAppInfo.a(paramLong2, paramLong1, paramInt);
      }
    }
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (bdso)a.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null) {
        paramMiniAppInfo.a(paramLong, paramInt, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdsn
 * JD-Core Version:    0.7.0.1
 */