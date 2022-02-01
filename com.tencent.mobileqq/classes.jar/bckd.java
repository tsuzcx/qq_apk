import com.tencent.qphone.base.util.QLog;

public class bckd
{
  public static int a;
  public static String a;
  public static boolean a;
  private static long[] a;
  public static int b;
  private static volatile boolean jdField_b_of_type_Boolean;
  private static long[] jdField_b_of_type_ArrayOfLong;
  private static int jdField_c_of_type_Int;
  private static boolean jdField_c_of_type_Boolean;
  private static long[] jdField_c_of_type_ArrayOfLong;
  private static int jdField_d_of_type_Int;
  private static long[] jdField_d_of_type_ArrayOfLong;
  private static int jdField_e_of_type_Int;
  private static long[] jdField_e_of_type_ArrayOfLong;
  private static int jdField_f_of_type_Int;
  private static long[] jdField_f_of_type_ArrayOfLong;
  private static int g;
  private static int h;
  
  static
  {
    jdField_a_of_type_ArrayOfLong = new long[20];
    jdField_b_of_type_ArrayOfLong = new long[20];
    jdField_c_of_type_ArrayOfLong = new long[20];
    jdField_d_of_type_ArrayOfLong = new long[20];
    jdField_e_of_type_ArrayOfLong = new long[20];
    jdField_f_of_type_ArrayOfLong = new long[20];
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static void a()
  {
    if (!jdField_b_of_type_Boolean) {
      h += 1;
    }
    if (h >= 5) {
      jdField_b_of_type_Boolean = true;
    }
  }
  
  public static void a(long paramLong)
  {
    if ((jdField_b_of_type_Boolean) && (jdField_d_of_type_Int < 20))
    {
      long[] arrayOfLong = jdField_c_of_type_ArrayOfLong;
      int i = jdField_d_of_type_Int;
      jdField_d_of_type_Int = i + 1;
      arrayOfLong[i] = paramLong;
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (!jdField_a_of_type_JavaLangString.equals(paramString))
    {
      jdField_e_of_type_Int = 0;
      jdField_a_of_type_JavaLangString = paramString;
    }
    if ((jdField_b_of_type_Boolean) && (jdField_e_of_type_Int < 20))
    {
      paramString = jdField_d_of_type_ArrayOfLong;
      int i = jdField_e_of_type_Int;
      jdField_e_of_type_Int = i + 1;
      paramString[i] = paramLong;
    }
  }
  
  public static void b()
  {
    long l2 = 0L;
    int j = 0;
    if ((g > 5) && (!jdField_c_of_type_Boolean))
    {
      jdField_c_of_type_Boolean = true;
      int i;
      long l1;
      double d1;
      if (jdField_c_of_type_Int > 0)
      {
        i = 0;
        l1 = 0L;
        while (i < jdField_c_of_type_Int)
        {
          l1 += jdField_b_of_type_ArrayOfLong[i];
          i += 1;
        }
        d1 = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[FaceTotalTime=" + d1 + "ms] avg=" + d1 / jdField_c_of_type_Int);
        }
        bckc.a("sv_filter_face_track", d1 / jdField_c_of_type_Int);
      }
      if (jdField_d_of_type_Int > 0)
      {
        i = 0;
        l1 = 0L;
        while (i < jdField_d_of_type_Int)
        {
          l1 += jdField_c_of_type_ArrayOfLong[i];
          i += 1;
        }
        d1 = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[FilterTotalTime=" + d1 + "ms] avg=" + d1 / jdField_d_of_type_Int);
        }
        bckc.a("sv_filter_draw_frame", d1 / jdField_d_of_type_Int);
      }
      if (jdField_e_of_type_Int > 0)
      {
        i = 0;
        l1 = 0L;
        while (i < jdField_e_of_type_Int)
        {
          l1 += jdField_d_of_type_ArrayOfLong[i];
          i += 1;
        }
        d1 = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[ShowTotalDrawTime=" + d1 + "ms] avg=" + d1 / jdField_e_of_type_Int);
        }
        bckc.a("sv_filter_total_draw", d1 / jdField_e_of_type_Int);
      }
      if (jdField_f_of_type_Int > 0)
      {
        i = 0;
        l1 = 0L;
        while (i < jdField_f_of_type_Int)
        {
          l1 += jdField_e_of_type_ArrayOfLong[i];
          i += 1;
        }
        d1 = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[ShowNoFilterTotalDrawTime=" + d1 + "ms] avg=" + d1 / jdField_f_of_type_Int);
        }
        bckc.a("sv_filter_no_filter_total_draw", d1 / jdField_f_of_type_Int);
      }
      if (g > 0)
      {
        l1 = l2;
        i = j;
        while (i < g)
        {
          l1 += jdField_f_of_type_ArrayOfLong[i];
          i += 1;
        }
        d1 = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[ShowTotalTime=" + d1 + "ms] avg=" + d1 / g);
        }
        bckc.a("sv_filter_total_process_frame", d1 / g);
      }
      if (jdField_b_of_type_Int == 0) {
        jdField_b_of_type_Int = 1;
      }
      bckc.a("sv_filter_track_ratio", jdField_a_of_type_Int * 1000 / jdField_b_of_type_Int);
    }
  }
  
  public static void b(long paramLong)
  {
    if ((jdField_b_of_type_Boolean) && (jdField_f_of_type_Int < 20))
    {
      long[] arrayOfLong = jdField_e_of_type_ArrayOfLong;
      int i = jdField_f_of_type_Int;
      jdField_f_of_type_Int = i + 1;
      arrayOfLong[i] = paramLong;
    }
  }
  
  public static void c(long paramLong)
  {
    if ((jdField_b_of_type_Boolean) && (g < 20))
    {
      long[] arrayOfLong = jdField_f_of_type_ArrayOfLong;
      int i = g;
      g = i + 1;
      arrayOfLong[i] = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckd
 * JD-Core Version:    0.7.0.1
 */