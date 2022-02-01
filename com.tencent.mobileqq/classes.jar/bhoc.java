import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.utils.PerformanceReportUtils.1;
import com.tencent.mobileqq.utils.PerformanceReportUtils.3;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class bhoc
{
  private static long jdField_a_of_type_Long = 14400000L;
  private static String jdField_a_of_type_JavaLangString = "uiswitchinterval";
  static String[] jdField_a_of_type_ArrayOfJavaLangString = { jdField_e_of_type_JavaLangString, jdField_f_of_type_JavaLangString, jdField_g_of_type_JavaLangString, jdField_h_of_type_JavaLangString, i, j, k };
  private static long jdField_b_of_type_Long;
  private static String jdField_b_of_type_JavaLangString = "uiswitchflag";
  private static long jdField_c_of_type_Long;
  private static String jdField_c_of_type_JavaLangString = "fpsinterval";
  private static long jdField_d_of_type_Long;
  private static String jdField_d_of_type_JavaLangString = "fpsflag";
  private static long jdField_e_of_type_Long;
  private static String jdField_e_of_type_JavaLangString = "actUISwitchC2C";
  private static long jdField_f_of_type_Long;
  private static String jdField_f_of_type_JavaLangString = "actUISwitchGroup";
  private static long jdField_g_of_type_Long;
  private static String jdField_g_of_type_JavaLangString = "actUISwitchDiscuss";
  private static long jdField_h_of_type_Long;
  private static String jdField_h_of_type_JavaLangString = "actUISwitchQzone";
  private static String i = "actUISwitchUserAlbum";
  private static String j = "actUISwitchQunAlbum";
  private static String k = "actUISwitchUserHome";
  private static String l = "actUISwitchPushBannerMyfeed";
  private static String m = "actUISwitchNotificationMyfeed";
  private static String n = "actUISwitchMyfeed";
  private static String o = "actUISwitchAioPreload";
  private static String p = "";
  
  public static String a()
  {
    long l2 = 0L;
    if (gc.c) {
      l2 = 0L | 0x200;
    }
    long l1 = l2;
    if (BubbleManager.a) {
      l1 = l2 | 0x100;
    }
    l2 = l1;
    if (AvatarPendantManager.b) {
      l2 = l1 | 0x400;
    }
    return String.valueOf(l2);
  }
  
  public static void a()
  {
    gc.c = false;
    AvatarPendantManager.b = false;
    BubbleManager.a = false;
    aqkr.a().d();
    ThreadManager.executeOnSubThread(new PerformanceReportUtils.3());
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, long paramLong)
  {
    ThreadManager.post(new PerformanceReportUtils.1(paramInt, paramLong, paramString), 8, null, false);
  }
  
  public static void a(Intent paramIntent, int paramInt, String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = paramIntent.getLongExtra("key_time_record", -1L);
    if (l2 != -1L)
    {
      paramIntent.removeExtra("key_time_record");
      a(BaseApplicationImpl.getContext(), paramString, paramInt, l1 - l2);
    }
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    new bhod(paramString1, paramInt, paramString2).execute(new Void[0]);
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PerformanceReportUtils", 4, "reportFPS saveCompleteTime ：tag:" + paramString + ",time:" + paramLong);
    }
    if ("actFPSAIO".equals(paramString)) {
      jdField_b_of_type_Long = paramLong;
    }
    do
    {
      return;
      if ("actFPSRecent".equals(paramString))
      {
        jdField_c_of_type_Long = paramLong;
        return;
      }
      if ("actFPSFriend".equals(paramString))
      {
        jdField_d_of_type_Long = paramLong;
        return;
      }
      if ("actFPSQZoneFriendFeed".equals(paramString))
      {
        jdField_e_of_type_Long = paramLong;
        return;
      }
      if ("actFPSQZoneMyFeed".equals(paramString))
      {
        jdField_f_of_type_Long = paramLong;
        return;
      }
      if ("actFPSQZoneUserHome".equals(paramString))
      {
        jdField_g_of_type_Long = paramLong;
        return;
      }
    } while (!"actFPSQZoneMoodList".equals(paramString));
    jdField_h_of_type_Long = paramLong;
  }
  
  private static SharedPreferences b()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i1 = 4;; i1 = 0) {
      return localBaseApplication.getSharedPreferences("PerformanceReportUtils", i1);
    }
  }
  
  private static boolean b(String paramString)
  {
    long l1;
    if ("actFPSAIO".equals(paramString)) {
      l1 = jdField_b_of_type_Long;
    }
    for (;;)
    {
      if (l1 == 0L) {}
      while ((float)(SystemClock.uptimeMillis() - l1) / 1000.0F >= 10.0F)
      {
        return false;
        if ("actFPSRecent".equals(paramString))
        {
          l1 = jdField_c_of_type_Long;
          break;
        }
        if (!"actFPSFriend".equals(paramString)) {
          break label72;
        }
        l1 = jdField_d_of_type_Long;
        break;
      }
      return true;
      label72:
      l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhoc
 * JD-Core Version:    0.7.0.1
 */