import com.tencent.qphone.base.util.QLog;

public class atiy
{
  protected static int a;
  protected static long a;
  protected static String a;
  protected static int b;
  protected static long b;
  protected static long c;
  protected static long d;
  protected static long e;
  protected static long f;
  
  static
  {
    jdField_b_of_type_Int = 0;
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static long a()
  {
    return f - jdField_a_of_type_Long;
  }
  
  public static void a()
  {
    jdField_b_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, "reportStartGetVideoInfoTime,time = " + jdField_b_of_type_Long);
    }
  }
  
  public static void a(int paramInt)
  {
    jdField_b_of_type_Int = paramInt;
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    c = 0L;
    e = 0L;
    f = 0L;
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangString = naj.a() + "";
    jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, "reportEntryTime,time = " + jdField_a_of_type_Long);
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, "reportVideoLoad,time =  feedid = " + paramString + " loadingTime =" + jdField_a_of_type_Int);
    }
    axqy.b(null, "dc02676", "grp_lbs", paramString, "video_quality", "play_load_again", paramInt, 0, String.valueOf(jdField_a_of_type_Int), "", "", "||" + paramString + "|||" + jdField_a_of_type_JavaLangString);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, "reportVideoPlayResult,time = feedid = " + paramString1 + " playType=" + paramInt + " errCode=" + paramString2 + " subErrCode=" + paramString3);
    }
    axqy.b(null, "dc02676", "grp_lbs", paramString1, "video_quality", "play_result", paramInt, 0, paramString2, paramString3, "", "||" + paramString1 + "|||" + jdField_a_of_type_JavaLangString);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    if (jdField_b_of_type_Int == 2) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, " reportVideoSurportPlayOnline,time =  feedid = " + paramString1 + " reportType=" + paramInt + " downloadProgress=" + paramString2 + " videoSize=" + paramString3 + "downloadedSize=" + paramString4 + "waitTime=" + (System.currentTimeMillis() - jdField_a_of_type_Long) + " isPlaying = " + paramBoolean + " startPlayTime =  " + f);
    }
    int i;
    if (paramBoolean)
    {
      i = 1;
      paramString5 = new StringBuilder().append(System.currentTimeMillis() - jdField_a_of_type_Long).append("|");
      if (f != 0L) {
        break label212;
      }
    }
    label212:
    for (int j = 1;; j = 2)
    {
      axqy.b(null, "dc02676", "grp_lbs", paramString1, "video_quality", "play_support_online", paramInt, i, paramString2, paramString3, paramString4, j + "|" + paramString1 + "|||" + jdField_a_of_type_JavaLangString);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (jdField_b_of_type_Int != 0) {
      return;
    }
    long l1 = f - e;
    long l2 = c - jdField_b_of_type_Long;
    long l3 = d - jdField_a_of_type_Long;
    long l4 = f - jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, "reportVideoPlayLoadTime,videoLoadTime = " + l1 + " getVideoInfoTime = " + l2 + " initVideoListUITime =" + l3 + " allTimeConsume=" + l4 + " feedsid=" + paramString + " playType=" + paramInt + " isUrlProvide=" + paramBoolean);
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      axqy.b(null, "dc02676", "grp_lbs", paramString, "video_quality", "play_loading_time", paramInt, i, String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), String.valueOf(l4) + "||" + paramString + "|||" + jdField_a_of_type_JavaLangString);
      return;
    }
  }
  
  public static long b()
  {
    return f - e;
  }
  
  public static void b()
  {
    c = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, "reportFinisGetVideoInfoTime,time = " + c);
    }
  }
  
  public static void c()
  {
    d = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, "reportUIInitFinishTime,time = " + d);
    }
  }
  
  public static void d()
  {
    e = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, "reportInitToPlayTime,time = " + e);
    }
  }
  
  public static void e()
  {
    f = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, "reportStartPlayTime,time = " + f);
    }
  }
  
  public static void f()
  {
    jdField_a_of_type_Int += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atiy
 * JD-Core Version:    0.7.0.1
 */