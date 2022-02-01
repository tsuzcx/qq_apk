import android.app.Activity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Properties;

public class bbht
{
  public static int a;
  public static long a;
  public static String a;
  public static boolean a;
  public static int b;
  
  private static String a()
  {
    if (jdField_a_of_type_Int % 180 == 0) {
      return "0";
    }
    return "1";
  }
  
  public static void a()
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaLangString = null;
    jdField_a_of_type_Int = 90;
    b = 2;
    jdField_a_of_type_Long = 0L;
  }
  
  public static void a(int paramInt, String paramString)
  {
    try
    {
      long l = bbnt.a(paramString);
      if (l == 0L) {}
      for (float f = -1.0F;; f = paramInt * 1000.0F / (float)l)
      {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "capture_video_fps", false, f, 0L, null, "");
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
        if (paramInt2 == -1)
        {
          if (jdField_a_of_type_Boolean)
          {
            alpt.a("", "0X80072C5", b(), jdField_a_of_type_JavaLangString, "", "");
            return;
          }
          alpt.a("", "0X80072C4", b());
          return;
        }
      } while (paramInt2 != 0);
      if (jdField_a_of_type_Boolean)
      {
        alpt.b("", "0X80072C6");
        return;
      }
      alpt.b("", "0X80072C7");
      return;
      if (paramInt2 == -1)
      {
        paramActivity = new Properties();
        paramActivity.setProperty("shortvideo_duration", String.valueOf(jdField_a_of_type_Long));
        paramActivity.setProperty("shortvideo_rotation", a());
        paramActivity.setProperty("shortvideo_camera", b());
        if (!jdField_a_of_type_Boolean)
        {
          alpt.a("", "0X8006A16", String.valueOf(jdField_a_of_type_Long), a(), b(), "");
          alsm.a("shortvideo_send_noeffects", paramActivity);
          return;
        }
        alpt.a("", "0X8006A19", String.valueOf(jdField_a_of_type_Long), a(), b(), jdField_a_of_type_JavaLangString);
        alsm.a("shortvideo_send_effects", paramActivity);
        return;
      }
    } while (paramInt2 != 0);
    if (jdField_a_of_type_Boolean)
    {
      alpt.b("", "0X8006A1B");
      return;
    }
    alpt.b("", "0X8006A17");
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      alpt.a("", "0X8007BB7", str);
      return;
    }
  }
  
  private static String b()
  {
    if (b == 1) {
      return "1";
    }
    return "0";
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Boolean)
    {
      alpt.a("", "0X80072C3", b(), jdField_a_of_type_JavaLangString, "", "");
      return;
    }
    alpt.a("", "0X80072C2", b());
  }
  
  public static void c()
  {
    if (jdField_a_of_type_Boolean)
    {
      alpt.a("", "0X8006A18", String.valueOf(jdField_a_of_type_Long), a(), b(), jdField_a_of_type_JavaLangString);
      return;
    }
    alpt.a("", "0X8006A13", String.valueOf(jdField_a_of_type_Long), a(), b(), "");
  }
  
  public static void d()
  {
    alpt.b("", "0X80072C1");
  }
  
  public static void e()
  {
    alpt.b("", "0X8006A12");
  }
  
  public static void f()
  {
    alpt.b("", "0X8006A15");
    alsm.a("shortvideo_rotate_camera", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbht
 * JD-Core Version:    0.7.0.1
 */