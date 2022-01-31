import android.text.TextUtils;
import com.tencent.qqmini.sdk.report.GdtCgiReportRunnable;

public class bdsb
{
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    bdew.a(new GdtCgiReportRunnable(paramString), 16, null, false);
    bdnw.b("GDT_CGI_REPORT", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdsb
 * JD-Core Version:    0.7.0.1
 */