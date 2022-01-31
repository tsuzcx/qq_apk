import com.tencent.mobileqq.app.ThreadManager;
import cooperation.comic.webbundle.WebBundleReportUtils.1;

public class bfbe
{
  public static String a = "0";
  public static String b = "1";
  public static String c = "2";
  public static String d = "3";
  public static String e = "4";
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ThreadManager.post(new WebBundleReportUtils.1(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramString3, paramString4, paramString5, paramString6), 5, null, false);
  }
  
  public static void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    String str = "0";
    if (paramBoolean) {
      str = "1";
    }
    a("hybrid", "webBundle_open", 0, 0, 0, 0, paramString1, str, paramString2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfbe
 * JD-Core Version:    0.7.0.1
 */