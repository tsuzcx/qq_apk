import com.tencent.qphone.base.util.QLog;

public class bcke
{
  private static int jdField_a_of_type_Int;
  private static volatile boolean jdField_a_of_type_Boolean;
  private static long[] jdField_a_of_type_ArrayOfLong = new long[20];
  private static int jdField_b_of_type_Int;
  private static volatile boolean jdField_b_of_type_Boolean;
  private static long[] jdField_b_of_type_ArrayOfLong = new long[20];
  private static int jdField_c_of_type_Int;
  private static long[] jdField_c_of_type_ArrayOfLong = new long[20];
  private static int jdField_d_of_type_Int;
  private static long[] jdField_d_of_type_ArrayOfLong = new long[20];
  
  public static void a()
  {
    if ((jdField_c_of_type_Int == 20) && (!jdField_a_of_type_Boolean))
    {
      if (!jdField_b_of_type_Boolean) {}
      for (int i = 1;; i = 0)
      {
        jdField_b_of_type_Boolean = true;
        jdField_a_of_type_Boolean = true;
        l = 0L;
        j = 0;
        while (j < jdField_c_of_type_Int)
        {
          l += jdField_c_of_type_ArrayOfLong[j];
          d1 = jdField_c_of_type_ArrayOfLong[j] / 1000.0D;
          QLog.d("SVFilterPreprocessFpsTest", 4, "SVFilterPreprocessFpsTest[FrameBuffer]temp=" + d1 + "ms framefpsOnce=" + 1000.0D / d1);
          j += 1;
        }
      }
      double d1 = l / 1000.0D / 20.0D;
      if (QLog.isColorLevel()) {
        QLog.d("SVFilterPreprocessFpsTest", 2, "SVFilterPreprocessFpsTest[FrameBuffer]avg=" + d1 + "ms avgfps=" + 1000.0D / d1);
      }
      if (i != 0) {
        bckc.a("sv_preprocess_frame_buffer", d1);
      }
      long l = 0L;
      int j = 0;
      while (j < jdField_d_of_type_Int)
      {
        l += jdField_d_of_type_ArrayOfLong[j];
        d1 = jdField_d_of_type_ArrayOfLong[j] / 1000.0D;
        QLog.d("SVFilterPreprocessFpsTest", 4, "SVFilterPreprocessFpsTest[ClipVideo]temp=" + d1 + "ms ClipVideoFpsOnce=" + 1000.0D / d1);
        j += 1;
      }
      d1 = l / 1000.0D / 20.0D;
      if (QLog.isColorLevel()) {
        QLog.d("SVFilterPreprocessFpsTest", 2, "SVFilterPreprocessFpsTest[ClipVideo]avg=" + d1 + "ms avgfps=" + 1000.0D / d1);
      }
      if (i != 0) {
        bckc.a("sv_preprocess_clip_video", d1);
      }
      l = 0L;
      j = 0;
      while (j < 20)
      {
        d1 = (jdField_b_of_type_ArrayOfLong[j] - jdField_a_of_type_ArrayOfLong[j]) / 1000.0D;
        l = (l + d1);
        QLog.d("SVFilterPreprocessFpsTest", 4, "SVFilterPreprocessFpsTest[TotalTime]temp=" + d1 + "ms InputfpsOnce=" + 1000.0D / d1);
        j += 1;
      }
      d1 = l / 20L;
      QLog.d("SVFilterPreprocessFpsTest", 4, "SVFilterPreprocessFpsTest[TotalTime]avg=" + d1 + "ms avgInputfps_Process=" + 1000.0D / d1);
      if (i != 0) {
        bckc.a("sv_preprocess_total_time", d1);
      }
      d1 = (jdField_b_of_type_ArrayOfLong[19] - jdField_a_of_type_ArrayOfLong[0]) / 1000.0D / 20.0D;
      if (QLog.isColorLevel()) {
        QLog.d("SVFilterPreprocessFpsTest", 2, "SVFilterPreprocessFpsTest[TotalTime]avg=" + d1 + "ms avgInputfps_Camera=" + 1000.0D / d1);
      }
    }
  }
  
  public static void a(long paramLong)
  {
    if (jdField_a_of_type_Int < 20)
    {
      long[] arrayOfLong = jdField_a_of_type_ArrayOfLong;
      int i = jdField_a_of_type_Int;
      jdField_a_of_type_Int = i + 1;
      arrayOfLong[i] = paramLong;
    }
  }
  
  public static void b()
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Int = 0;
    jdField_a_of_type_Boolean = false;
  }
  
  public static void b(long paramLong)
  {
    if (jdField_b_of_type_Int < 20)
    {
      long[] arrayOfLong = jdField_b_of_type_ArrayOfLong;
      int i = jdField_b_of_type_Int;
      jdField_b_of_type_Int = i + 1;
      arrayOfLong[i] = paramLong;
    }
  }
  
  public static void c(long paramLong)
  {
    if (jdField_c_of_type_Int < 20)
    {
      long[] arrayOfLong = jdField_c_of_type_ArrayOfLong;
      int i = jdField_c_of_type_Int;
      jdField_c_of_type_Int = i + 1;
      arrayOfLong[i] = paramLong;
    }
  }
  
  public static void d(long paramLong)
  {
    if (jdField_d_of_type_Int < 20)
    {
      long[] arrayOfLong = jdField_d_of_type_ArrayOfLong;
      int i = jdField_d_of_type_Int;
      jdField_d_of_type_Int = i + 1;
      arrayOfLong[i] = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcke
 * JD-Core Version:    0.7.0.1
 */