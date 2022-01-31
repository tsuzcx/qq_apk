import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04902.1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class beyj
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static final Runnable jdField_a_of_type_JavaLangRunnable = new MiniProgramLpReportDC04902.1();
  private static String jdField_a_of_type_JavaLangString = "appid";
  private static boolean jdField_a_of_type_Boolean;
  private static long[] jdField_a_of_type_ArrayOfLong;
  private static int jdField_b_of_type_Int;
  private static long jdField_b_of_type_Long;
  private static String jdField_b_of_type_JavaLangString = bfgt.b();
  private static int jdField_c_of_type_Int;
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
  private static long l;
  private static long m;
  
  private static String a()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      jdField_a_of_type_JavaLangString = beqh.a().a().appId;
      jdField_c_of_type_JavaLangString = a();
      beiw.a().postDelayed(jdField_a_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public static void a(float paramFloat1, float paramFloat2)
  {
    jdField_d_of_type_JavaLangString = a();
    beiw.a().removeCallbacks(jdField_a_of_type_JavaLangRunnable);
    String str1 = jdField_a_of_type_JavaLangString + '|' + jdField_b_of_type_JavaLangString + '|' + jdField_c_of_type_JavaLangString + '|' + jdField_d_of_type_JavaLangString + '|' + jdField_a_of_type_Long + '|' + jdField_b_of_type_Long + '|' + jdField_c_of_type_Long + '|' + jdField_d_of_type_Long + '|' + jdField_e_of_type_Long + '|' + jdField_f_of_type_Long + '|' + jdField_g_of_type_Long + '|' + jdField_h_of_type_Long + '|' + i + '|' + jdField_e_of_type_JavaLangString + '|' + j + '|' + k + '|' + (int)paramFloat2 + '|' + (int)paramFloat1 + '|' + jdField_f_of_type_JavaLangString + '|' + beyn.a() + '|' + jdField_g_of_type_JavaLangString + '|' + bekw.b(MiniAppEnv.g().getContext()) + '|' + jdField_h_of_type_JavaLangString + '|' + Build.MODEL + '|' + Build.VERSION.RELEASE;
    String str2;
    Object localObject;
    if (!bfgt.a())
    {
      str2 = bfgt.a();
      localObject = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId();
      String str3 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion();
      String str4 = bfgt.e();
      str1 = str1 + '|' + str2 + '|' + (String)localObject + '|' + str3 + '|' + str4;
    }
    for (;;)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putStringArray("data", new String[] { str1 });
      if (bfgt.a()) {}
      for (str2 = "dc04902";; str2 = "dc05389")
      {
        ((Bundle)localObject).putString("log_key", str2);
        besl.a("MiniProgramLpReportDC04", "reportGameEnd " + str1);
        beot.a().a("cmd_dc_report_log_key_data", (Bundle)localObject, null);
        jdField_a_of_type_Boolean = false;
        return;
      }
    }
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
  
  public static void a(long paramLong, boolean paramBoolean)
  {
    int n = 0;
    if (paramBoolean)
    {
      jdField_a_of_type_ArrayOfLong = new long[3];
      jdField_a_of_type_Int = 0;
      m = paramLong;
      l = paramLong;
      return;
    }
    long l2 = paramLong - l;
    if ((jdField_a_of_type_Int >= 3) && (l2 > 83333332L))
    {
      long l1 = 0L;
      while (n < 3)
      {
        l1 += jdField_a_of_type_ArrayOfLong[n];
        n += 1;
      }
      if (l2 > l1 / 3L * 2L)
      {
        if (l2 <= 124999998L) {
          break label130;
        }
        jdField_c_of_type_Int += 1;
      }
    }
    for (;;)
    {
      n = jdField_a_of_type_Int;
      jdField_a_of_type_ArrayOfLong[(n % 3)] = l2;
      jdField_a_of_type_Int += 1;
      break;
      label130:
      jdField_b_of_type_Int += 1;
    }
  }
  
  public static void a(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("data"))) {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).httpReport(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beyj
 * JD-Core Version:    0.7.0.1
 */