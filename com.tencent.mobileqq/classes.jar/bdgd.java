import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.soload.LoadParam;

class bdgd
{
  public static long a(LoadParam paramLoadParam, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    if (LoadParam.isCloseReport(paramLoadParam)) {
      return 0L;
    }
    return VACDReportUtil.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6);
  }
  
  public static void a(LoadParam paramLoadParam, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (LoadParam.isCloseReport(paramLoadParam)) {
      return;
    }
    VACDReportUtil.endReport(paramLong, paramString1, paramString2, paramInt, paramString3);
  }
  
  public static void a(LoadParam paramLoadParam, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if (LoadParam.isCloseReport(paramLoadParam)) {
      return;
    }
    VACDReportUtil.a(paramLong, paramString1, paramString2, paramString3, paramInt, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgd
 * JD-Core Version:    0.7.0.1
 */