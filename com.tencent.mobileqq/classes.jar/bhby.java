import android.os.Handler;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04266.1;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04266.2;
import com.tencent.qqmini.sdk.utils.QUAUtil;

public class bhby
{
  public static void a(MiniAppInfo paramMiniAppInfo, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong1, String paramString5, long paramLong2, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    bhch.a().a().post(new MiniProgramLpReportDC04266.1(paramInt1, paramMiniAppInfo, paramInt2, paramString2, paramLong2, paramLong1, paramString1, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10));
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    bhch.a().a().post(new MiniProgramLpReportDC04266.2(paramMiniAppInfo, paramString1, paramString2, paramInt, paramLong1, paramLong2, paramString3, paramString4, paramString5, paramString6, paramString7));
  }
  
  private static boolean b(int paramInt)
  {
    return (paramInt == 20) || (paramInt == 22) || (paramInt == 605) || (paramInt == 1011) || (paramInt == 1024) || (paramInt == 1028);
  }
  
  private static int c()
  {
    return 3;
  }
  
  private static int d()
  {
    return 14;
  }
  
  private static int e()
  {
    return 13;
  }
  
  private static int f()
  {
    if (QUAUtil.isQQApp()) {
      return c();
    }
    return e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhby
 * JD-Core Version:    0.7.0.1
 */