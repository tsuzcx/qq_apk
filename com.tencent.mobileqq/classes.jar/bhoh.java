import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ProfilePerformanceReport.1;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class bhoh
{
  public static bhoh a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "param_click2create", "param_first_draw", "param_first_show", "param_open", "param_run_delay", "param_init_data", "param_fetch_data", "param_prepare_res", "param_refresh_from_cache", "param_refresh_from_net" };
  public static bhoh b;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private final long[] jdField_a_of_type_ArrayOfLong;
  private final long[] b;
  
  public static void a() {}
  
  public static void b() {}
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 9)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ArrayOfLong[paramInt] != 0L);
      this.jdField_a_of_type_ArrayOfLong[paramInt] = SystemClock.elapsedRealtime();
      if (paramInt == 0)
      {
        this.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_ArrayOfLong[3] = this.jdField_a_of_type_ArrayOfLong[paramInt];
      }
    } while (!QLog.isDevelopLevel());
    this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    this.jdField_a_of_type_JavaLangStringBuilder.append("markStart, [").append(jdField_a_of_type_ArrayOfJavaLangString[paramInt]).append(",").append(this.jdField_a_of_type_ArrayOfLong[paramInt]).append(",").append(this.jdField_a_of_type_Int).append("]");
    QLog.i("ProfilePerformanceReport", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public void a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    long l2 = 0L;
    long l1 = 0L;
    if (i <= 9)
    {
      label58:
      String str;
      if ((this.b[i] != 0L) && (this.jdField_a_of_type_ArrayOfLong[i] != 0L))
      {
        l1 = this.b[i] - this.jdField_a_of_type_ArrayOfLong[i];
        if (i == 3) {
          l2 = l1;
        }
        str = jdField_a_of_type_ArrayOfJavaLangString[i];
        if (l1 <= 0L) {
          break label107;
        }
      }
      label107:
      for (long l3 = l1;; l3 = 0L)
      {
        localHashMap.put(str, String.valueOf(l3));
        i += 1;
        break;
        l1 = 0L;
        break label58;
      }
    }
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_Int = 1;
    if (QLog.isDevelopLevel())
    {
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      this.jdField_a_of_type_JavaLangStringBuilder.append("reportPerformance, [").append(l1).append(",").append(localHashMap.toString()).append("]");
      QLog.i("ProfilePerformanceReport", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
    ThreadManager.getSubThreadHandler().post(new ProfilePerformanceReport.1(this, paramString, l2, localHashMap));
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3);
  }
  
  public boolean a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 9)) {}
    while ((this.jdField_a_of_type_ArrayOfLong[paramInt] == 0L) || (this.b[paramInt] == 0L)) {
      return false;
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int < 3) {}
    while ((this.jdField_a_of_type_Int != 4) && (!paramBoolean)) {
      return false;
    }
    return true;
  }
  
  public void b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 9)) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ArrayOfLong[paramInt] != 0L) && (this.b[paramInt] == 0L))
      {
        this.b[paramInt] = SystemClock.elapsedRealtime();
        if (paramInt == 1)
        {
          this.b[3] = this.b[paramInt];
          this.jdField_a_of_type_Int = 3;
        }
        while (QLog.isDevelopLevel())
        {
          this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
          this.jdField_a_of_type_JavaLangStringBuilder.append("markEnd, [").append(jdField_a_of_type_ArrayOfJavaLangString[paramInt]).append(",").append(this.b[paramInt]).append(",").append(this.b[paramInt] - this.jdField_a_of_type_ArrayOfLong[paramInt]).append(",").append(this.jdField_a_of_type_Int).append("]");
          QLog.i("ProfilePerformanceReport", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
          return;
          if (paramInt == 9) {
            this.jdField_a_of_type_Int = 4;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhoh
 * JD-Core Version:    0.7.0.1
 */