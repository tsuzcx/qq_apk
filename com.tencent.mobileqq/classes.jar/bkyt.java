import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;

public class bkyt
{
  public static void a(int paramInt)
  {
    a("WidgetReport", 302, 7, paramInt, false, false);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    a("MsgActiveFeed", 133, paramInt1, paramInt2, false, false);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QZLog.isColorLevel()) {
      QZLog.i(paramString, 2, "reportToPf00064 actiontype = " + paramInt1 + " subactionType = " + paramInt2 + " reserves = " + paramInt3 + " isNeedSample = " + paramBoolean1 + " isReportNow = " + paramBoolean2);
    }
    paramString = new LpReportInfo_pf00064(paramInt1, paramInt2, paramInt3);
    LpReportManager.getInstance().reportToPF00064(paramString, paramBoolean1, paramBoolean2);
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    a("VipSignature", paramInt1, paramInt2, 0, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyt
 * JD-Core Version:    0.7.0.1
 */