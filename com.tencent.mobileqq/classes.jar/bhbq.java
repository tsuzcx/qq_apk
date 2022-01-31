import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.report.GdtCgiReportRunnable;

public class bhbq
{
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.a(new GdtCgiReportRunnable(paramString), 16, null, false);
    QMLog.i("GDT_CGI_REPORT", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhbq
 * JD-Core Version:    0.7.0.1
 */