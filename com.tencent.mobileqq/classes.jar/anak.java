import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport.1;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport.2;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport.3;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport.4;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport.5;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport.6;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport.7;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport.8;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport.9;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class anak
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static anal jdField_a_of_type_Anal;
  private static int b = -1;
  
  public static long a(String paramString, long paramLong)
  {
    return BaseApplicationImpl.sApplication.getSharedPreferences("sp_mini_scan_report", 4).getLong(paramString, paramLong);
  }
  
  public static void a()
  {
    jdField_a_of_type_Anal = new anal(null);
    jdField_a_of_type_Anal.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public static void a(int paramInt)
  {
    anal localanal = jdField_a_of_type_Anal;
    if (localanal == null) {}
    long l;
    do
    {
      return;
      jdField_a_of_type_Anal = null;
      l = System.currentTimeMillis() - localanal.jdField_a_of_type_Long;
    } while ((l > 600000L) || (localanal.jdField_a_of_type_Int <= 0));
    int k = localanal.jdField_a_of_type_Int;
    int m = localanal.b;
    int n = localanal.c;
    int i1 = localanal.d / k;
    int i;
    if (m <= 0)
    {
      i = 0;
      if (n > 0) {
        break label124;
      }
    }
    label124:
    for (int j = 0;; j = localanal.f / n)
    {
      ThreadManager.post(new MiniScanReport.1(i1, l, k, paramInt, m, i, n, j), 5, null, false);
      return;
      i = localanal.e / m;
      break;
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if ((jdField_a_of_type_Anal == null) || (paramInt1 <= 1) || (paramInt1 > 15000)) {
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      localanal = jdField_a_of_type_Anal;
      localanal.jdField_a_of_type_Int += 1;
      localanal = jdField_a_of_type_Anal;
      localanal.d += paramInt1;
      return;
    case 1: 
      localanal = jdField_a_of_type_Anal;
      localanal.b += 1;
      localanal = jdField_a_of_type_Anal;
      localanal.e += paramInt1;
      return;
    }
    anal localanal = jdField_a_of_type_Anal;
    localanal.c += 1;
    localanal = jdField_a_of_type_Anal;
    localanal.f += paramInt1;
  }
  
  public static void a(String paramString, long paramLong)
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("sp_mini_scan_report", 4).edit().putLong(paramString, paramLong).apply();
  }
  
  public static void a(boolean paramBoolean, int paramInt, String paramString)
  {
    ThreadManager.post(new MiniScanReport.2(paramBoolean, paramInt, paramString), 5, null, false);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ThreadManager.post(new MiniScanReport.5(paramBoolean1, paramBoolean2), 5, null, false);
  }
  
  public static boolean a()
  {
    if (b == -1) {
      if (!BaseApplication.getContext().getSharedPreferences("envSwitch", 4).getBoolean("key_base_test_scan_on", false)) {
        break label42;
      }
    }
    label42:
    for (int i = 1;; i = 0)
    {
      b = i;
      if (b != 1) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Long == 0L) {
      jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
    jdField_a_of_type_Int += 1;
  }
  
  public static void b(int paramInt)
  {
    ThreadManager.post(new MiniScanReport.6(paramInt), 5, null, false);
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new MiniScanReport.3(paramInt1, paramInt2), 5, null, false);
  }
  
  private static void b(HashMap<String, String> paramHashMap)
  {
    String str2 = Build.MODEL;
    int i = Build.VERSION.SDK_INT;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramHashMap.put("report_key_device_model", str1);
    paramHashMap.put("report_key_device_sdk", String.valueOf(i));
  }
  
  public static void c()
  {
    if ((jdField_a_of_type_Long == 0L) || (jdField_a_of_type_Int == 0))
    {
      jdField_a_of_type_Long = 0L;
      jdField_a_of_type_Int = 0;
      return;
    }
    long l = (SystemClock.uptimeMillis() - jdField_a_of_type_Long) / 1000L;
    if (l != 0L)
    {
      int i = (int)(jdField_a_of_type_Int / l);
      if ((QLog.isColorLevel()) || (a())) {
        QLog.i("MiniRecog.MiniScanReport", 1, String.format("base_test_scan frame_rate=%d", new Object[] { Integer.valueOf(i) }));
      }
    }
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_Int = 0;
  }
  
  public static void c(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new MiniScanReport.4(paramInt2, paramInt1), 5, null, false);
  }
  
  public static void d(int paramInt1, int paramInt2)
  {
    if ((paramInt2 <= 0) || (paramInt2 > 180000)) {
      return;
    }
    ThreadManager.post(new MiniScanReport.7(paramInt1, paramInt2), 5, null, false);
  }
  
  public static void e(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new MiniScanReport.8(paramInt1, paramInt2), 5, null, false);
  }
  
  public static void f(int paramInt1, int paramInt2)
  {
    if ((paramInt2 <= 0) || (paramInt2 > 180000)) {
      return;
    }
    ThreadManager.post(new MiniScanReport.9(paramInt1, paramInt2), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anak
 * JD-Core Version:    0.7.0.1
 */