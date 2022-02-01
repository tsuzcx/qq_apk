import android.text.TextUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class bdpt
{
  public static final String a = String.valueOf(153);
  public static final String b = String.valueOf(153);
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (paramInt2 < 0) {
      paramInt2 = bgnt.a(null);
    }
    for (;;)
    {
      int i = paramInt2;
      if (paramInt2 <= 0) {
        i = 10;
      }
      paramAppRuntime = paramString4;
      try
      {
        if (TextUtils.isEmpty(paramString4)) {
          paramAppRuntime = "1";
        }
        VasWebviewUtil.reportVasStatus(paramString1, paramString2, paramString3, i, paramInt1, paramInt3, Integer.parseInt(paramAppRuntime), paramString5, "");
        if ((QLog.isColorLevel()) && (paramInt3 < 0))
        {
          paramString4 = new StringBuilder();
          paramString4.append(paramString1).append("|step:");
          paramString4.append(paramInt1).append("|from:");
          paramString4.append(paramString2).append("|resultCode:");
          paramString4.append(paramInt3).append("|id:");
          paramString4.append(paramString3).append("|version:");
          paramString4.append(paramAppRuntime);
          QLog.i("ThemeReporter", 2, "ThemeReporterreportTheme Error data::" + paramString4.toString());
        }
        return;
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("ThemeReporter", 1, "ThemeReporter reportTheme Exception:" + paramAppRuntime.getMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdpt
 * JD-Core Version:    0.7.0.1
 */