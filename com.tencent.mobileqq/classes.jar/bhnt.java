import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class bhnt
{
  public static bhnu a;
  public static String a;
  public static boolean a;
  public static bhnu b;
  public static String b;
  public static boolean b;
  public static bhnu c;
  public static boolean c;
  public static bhnu d;
  public static bhnu e = new bhnu();
  public static bhnu f = new bhnu(3);
  public static bhnu g = new bhnu(5);
  public static bhnu h = new bhnu();
  
  static
  {
    jdField_a_of_type_JavaLangString = "AutoMonitor_Camera";
    jdField_a_of_type_Boolean = a();
    jdField_b_of_type_JavaLangString = "FreqMonitorSwitch";
    jdField_a_of_type_Bhnu = new bhnu();
    jdField_b_of_type_Bhnu = new bhnu();
    jdField_c_of_type_Bhnu = new bhnu();
    d = new bhnu();
    jdField_c_of_type_Boolean = true;
  }
  
  public static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 0) || (paramArrayOfInt == null) || (paramInt2 > paramArrayOfInt.length)) {}
    long l;
    do
    {
      return 0;
      l = 0L;
      int i = paramInt1;
      while (i < paramInt2)
      {
        l += paramArrayOfInt[i];
        i += 1;
      }
    } while (paramInt2 - paramInt1 == 0);
    return (int)(l / (paramInt2 - paramInt1));
  }
  
  public static String a(int[] paramArrayOfInt, int paramInt)
  {
    if ((paramInt == 0) || (paramArrayOfInt == null) || (paramInt > paramArrayOfInt.length)) {
      return "";
    }
    int i = paramInt - 1;
    if (i == -1) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    paramInt = 0;
    for (;;)
    {
      localStringBuilder.append(paramArrayOfInt[paramInt]);
      if (paramInt == i) {
        return ']';
      }
      localStringBuilder.append(", ");
      paramInt += 1;
    }
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Bhnu.a())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("CameraStartCost, activityCost=%d, refreshCost=%d, cameraCost=%d, cost=%d", new Object[] { Long.valueOf(jdField_a_of_type_Bhnu.jdField_a_of_type_ArrayOfLong[1] - jdField_a_of_type_Bhnu.jdField_a_of_type_ArrayOfLong[0]), Long.valueOf(jdField_a_of_type_Bhnu.jdField_a_of_type_ArrayOfLong[2] - jdField_a_of_type_Bhnu.jdField_a_of_type_ArrayOfLong[1]), Long.valueOf(jdField_a_of_type_Bhnu.jdField_a_of_type_ArrayOfLong[3] - jdField_a_of_type_Bhnu.jdField_a_of_type_ArrayOfLong[2]), Long.valueOf(jdField_a_of_type_Bhnu.jdField_a_of_type_ArrayOfLong[3] - jdField_a_of_type_Bhnu.jdField_a_of_type_ArrayOfLong[0]) }));
      jdField_a_of_type_Bhnu.c();
    }
  }
  
  public static boolean a()
  {
    if (!PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).getBoolean(jdField_b_of_type_JavaLangString, false)) {
      return bace.a(Environment.getExternalStorageDirectory() + "/Tencent/AutoTestFlag_03");
    }
    return true;
  }
  
  public static void b()
  {
    if (d.a())
    {
      d.jdField_b_of_type_Long = System.currentTimeMillis();
      long l = d.jdField_b_of_type_Long - d.jdField_a_of_type_Long;
      QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("CameraEditStatistic, avgRenderCost=%d, cost=%d, frameCount=%d, frameFreq=%d", new Object[] { Integer.valueOf(a(d.jdField_a_of_type_ArrayOfInt, 0, d.jdField_b_of_type_Int)), Long.valueOf(l), Integer.valueOf(d.jdField_b_of_type_Int), Long.valueOf(d.jdField_b_of_type_Int * 1000 / l) }));
      QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("CameraEditStatistic, render cost: %s", new Object[] { a(d.jdField_a_of_type_ArrayOfInt, d.jdField_b_of_type_Int) }));
      d.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhnt
 * JD-Core Version:    0.7.0.1
 */