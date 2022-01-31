import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04902.1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class bdsm
{
  private static long jdField_a_of_type_Long;
  private static final Runnable jdField_a_of_type_JavaLangRunnable = new MiniProgramLpReportDC04902.1();
  private static String jdField_a_of_type_JavaLangString = "appid";
  private static boolean jdField_a_of_type_Boolean;
  private static long jdField_b_of_type_Long;
  private static String jdField_b_of_type_JavaLangString = bdzd.b();
  private static long jdField_c_of_type_Long;
  private static String jdField_c_of_type_JavaLangString = a();
  private static long jdField_d_of_type_Long;
  private static String jdField_d_of_type_JavaLangString = a();
  private static long jdField_e_of_type_Long;
  private static String jdField_e_of_type_JavaLangString;
  private static long jdField_f_of_type_Long;
  private static String jdField_f_of_type_JavaLangString;
  private static long jdField_g_of_type_Long;
  private static String jdField_g_of_type_JavaLangString;
  private static long jdField_h_of_type_Long;
  private static String jdField_h_of_type_JavaLangString = "Android";
  private static long i;
  private static long j;
  private static long k;
  
  private static String a()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      jdField_a_of_type_JavaLangString = bdlx.a().a().appId;
      jdField_c_of_type_JavaLangString = a();
      bdew.a().postDelayed(jdField_a_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public static void a(float paramFloat1, float paramFloat2)
  {
    jdField_d_of_type_JavaLangString = a();
    bdew.a().removeCallbacks(jdField_a_of_type_JavaLangRunnable);
    String str = jdField_a_of_type_JavaLangString + '|' + jdField_b_of_type_JavaLangString + '|' + jdField_c_of_type_JavaLangString + '|' + jdField_d_of_type_JavaLangString + '|' + jdField_a_of_type_Long + '|' + jdField_b_of_type_Long + '|' + jdField_c_of_type_Long + '|' + jdField_d_of_type_Long + '|' + jdField_e_of_type_Long + '|' + jdField_f_of_type_Long + '|' + jdField_g_of_type_Long + '|' + jdField_h_of_type_Long + '|' + i + '|' + jdField_e_of_type_JavaLangString + '|' + j + '|' + k + '|' + (int)paramFloat2 + '|' + (int)paramFloat1 + '|' + jdField_f_of_type_JavaLangString + '|' + bdsq.a() + '|' + jdField_g_of_type_JavaLangString + '|' + bdgt.b(MiniAppEnv.g().getContext()) + '|' + jdField_h_of_type_JavaLangString + '|' + Build.MODEL + '|' + Build.VERSION.RELEASE;
    Bundle localBundle = new Bundle();
    localBundle.putStringArray("data", new String[] { str });
    localBundle.putString("log_key", "dc04902");
    bdnw.a("MiniProgramLpReportDC04", "reportGameEnd " + str);
    bdkq.a().a("cmd_dc_report_log_key_data", localBundle, null);
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(long paramLong)
  {
    if (paramLong <= 20L) {
      jdField_a_of_type_Long += paramLong;
    }
    for (;;)
    {
      if (paramLong > k)
      {
        k = paramLong;
        j = System.currentTimeMillis();
      }
      return;
      if (paramLong <= 33L) {
        jdField_b_of_type_Long += paramLong;
      } else if (paramLong <= 50L) {
        jdField_c_of_type_Long += paramLong;
      } else if (paramLong <= 100L) {
        jdField_d_of_type_Long += paramLong;
      } else {
        jdField_e_of_type_Long += paramLong;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdsm
 * JD-Core Version:    0.7.0.1
 */