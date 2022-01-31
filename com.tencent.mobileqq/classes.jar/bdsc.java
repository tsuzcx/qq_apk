import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2.1;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2.2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bdsc
{
  public static final long a;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static Runnable jdField_a_of_type_JavaLangRunnable = new MiniAppReportManager2.2();
  public static HashMap<String, bdsd> a;
  public static final boolean a;
  public static HashMap<String, Integer> b;
  private static boolean b;
  private static boolean c;
  
  static
  {
    jdField_a_of_type_Long = a();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_Boolean = bdle.a().a();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap.put("load_baselib_fail", Integer.valueOf(402));
    jdField_b_of_type_JavaUtilHashMap.put("download_url_fail", Integer.valueOf(403));
    jdField_b_of_type_JavaUtilHashMap.put("download_apk_fail", Integer.valueOf(404));
    jdField_b_of_type_JavaUtilHashMap.put("unpkg_fail", Integer.valueOf(405));
    jdField_b_of_type_JavaUtilHashMap.put("load_pkg_fail", Integer.valueOf(406));
    jdField_b_of_type_JavaUtilHashMap.put("system_version_limit_fail", Integer.valueOf(407));
    jdField_b_of_type_JavaUtilHashMap.put("qq_version_limit_fail", Integer.valueOf(408));
    jdField_b_of_type_JavaUtilHashMap.put("loading_page_kill", Integer.valueOf(409));
    jdField_b_of_type_JavaUtilHashMap.put("baselib_task_fail", Integer.valueOf(410));
    jdField_b_of_type_JavaUtilHashMap.put("pkg_task_fail", Integer.valueOf(411));
    jdField_b_of_type_JavaUtilHashMap.put("start_no_intent", Integer.valueOf(412));
    jdField_b_of_type_JavaUtilHashMap.put("appid_conflict", Integer.valueOf(413));
    jdField_b_of_type_JavaUtilHashMap.put("init_data_fail", Integer.valueOf(414));
    jdField_b_of_type_JavaUtilHashMap.put("not_foreground", Integer.valueOf(415));
    jdField_b_of_type_JavaUtilHashMap.put("splash_exit_when_fail", Integer.valueOf(416));
    jdField_b_of_type_JavaUtilHashMap.put("shotcut_request_fail", Integer.valueOf(417));
    jdField_b_of_type_JavaUtilHashMap.put("offline_not_support", Integer.valueOf(418));
    jdField_b_of_type_JavaUtilHashMap.put("offline_not_ready", Integer.valueOf(419));
    jdField_b_of_type_JavaUtilHashMap.put("not_ready", Integer.valueOf(420));
    jdField_b_of_type_JavaUtilHashMap.put("show_page_kill", Integer.valueOf(421));
    jdField_b_of_type_Boolean = true;
  }
  
  public static long a()
  {
    return bdhg.a("MiniGame", "MiniShowTimeout", 45000L);
  }
  
  private static bdsd a(String paramString1, String paramString2, String paramString3, MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      bdnw.a("MiniAppReportManager2", "new report (appId is null)");
      paramString1 = null;
      return paramString1;
    }
    long l = System.currentTimeMillis();
    if (jdField_b_of_type_Boolean)
    {
      jdField_b_of_type_Boolean = false;
      b();
      jdField_a_of_type_JavaLangRunnable.run();
    }
    bdsd localbdsd = (bdsd)jdField_a_of_type_JavaUtilHashMap.get(paramMiniAppInfo.appId);
    paramString3 = localbdsd;
    if (localbdsd == null)
    {
      paramString3 = new bdsd();
      paramString3.jdField_b_of_type_JavaLangString = String.valueOf(l);
      jdField_a_of_type_JavaUtilHashMap.put(paramMiniAppInfo.appId, paramString3);
    }
    paramString3.jdField_a_of_type_JavaLangString = paramMiniAppInfo.appId;
    paramString3.jdField_a_of_type_Int = paramMiniAppInfo.getEngineType();
    paramString3.jdField_b_of_type_Int = paramMiniAppInfo.getReportType();
    paramString3.jdField_c_of_type_Int = paramMiniAppInfo.verType;
    paramString3.jdField_d_of_type_Long = l;
    if ("2click".equals(paramString1)) {
      if (paramString3.jdField_d_of_type_Int != 0) {
        break label500;
      }
    }
    for (;;)
    {
      paramString3.a();
      d();
      paramString3.jdField_a_of_type_Long = l;
      paramString3.jdField_c_of_type_Boolean = bdnx.a(paramMiniAppInfo);
      paramString3.jdField_d_of_type_Boolean = true;
      c();
      if ((paramString3.jdField_d_of_type_Int != 0) && ("2show".equals(paramString1)) && ("bring_to_front".equals(paramString2)))
      {
        paramString3.a();
        d();
        paramString3.jdField_a_of_type_Long = l;
        c();
      }
      if ("2load".equals(paramString1)) {
        paramString3.jdField_b_of_type_Long = l;
      }
      if ((paramString3.jdField_d_of_type_Int == 0) && ("2launch".equals(paramString1)))
      {
        paramString3.jdField_c_of_type_Long = l;
        paramString3.jdField_d_of_type_Int = 1;
        paramString3.jdField_a_of_type_Boolean = true;
        c();
      }
      if ((paramString3.jdField_d_of_type_Int == 0) && (("2launch_fail".equals(paramString1)) || ("2close".equals(paramString1)) || ("2back_key".equals(paramString1)) || ("2hide".equals(paramString1))))
      {
        paramString3.jdField_c_of_type_Long = l;
        paramString3.jdField_d_of_type_Int = 2;
        paramString3.jdField_a_of_type_Boolean = true;
        c();
      }
      if ("2show".equals(paramString1))
      {
        paramString3.e = l;
        paramString3.f = 0L;
      }
      if ("2hide".equals(paramString1)) {
        paramString3.f = l;
      }
      if ("2unload".equals(paramString1)) {
        jdField_a_of_type_JavaUtilHashMap.remove(paramMiniAppInfo.appId);
      }
      paramString1 = paramString3;
      if (!bdnw.b()) {
        break;
      }
      bdnw.a("MiniAppReportManager2", "launchState: launchId = [" + paramString3.jdField_b_of_type_JavaLangString + "], launchResult = [" + paramString3.jdField_d_of_type_Int + "], clickTime = [" + paramString3.jdField_a_of_type_Long + "], launchTime = [" + paramString3.jdField_c_of_type_Long + "], showTime = [" + paramString3.e + "], hideTime = [" + paramString3.f + "]");
      return paramString3;
      label500:
      paramString3.jdField_b_of_type_JavaLangString = String.valueOf(l);
    }
  }
  
  private static String a(long paramLong)
  {
    if (paramLong < 0L) {
      return "timeout-1";
    }
    if (paramLong < 15000L) {
      return "timeout_" + Math.round((float)(paramLong / 1000L));
    }
    if (paramLong < 25000L) {
      return "timeout_25";
    }
    return "timeout";
  }
  
  private static String a(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      if (paramMiniAppInfo.isReportTypeMiniGame()) {
        return "1";
      }
      return "0";
    }
    return "1";
  }
  
  public static void a(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo)
  {
    bdsd localbdsd = (bdsd)jdField_a_of_type_JavaUtilHashMap.get(paramMiniAppInfo.appId);
    String str = "";
    if (localbdsd != null)
    {
      if (!localbdsd.jdField_d_of_type_Boolean) {
        break label97;
      }
      paramString = "" + "flutter";
    }
    for (;;)
    {
      str = paramString;
      if (localbdsd.jdField_c_of_type_Boolean) {
        str = paramString + "_hasPkg";
      }
      bdsu.a(paramMiniAppInfo, paramInt, str, a(paramMiniAppInfo));
      return;
      label97:
      if (bdsd.jdField_b_of_type_Boolean) {
        paramString = "" + "_webview_x5";
      } else {
        paramString = "" + "_webview_system";
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, MiniAppInfo paramMiniAppInfo)
  {
    String str1;
    Object localObject;
    String str2;
    label195:
    label241:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            if (jdField_a_of_type_Boolean)
            {
              b(paramString1, paramString2, paramString3, paramMiniAppInfo);
              return;
            }
            bdsr.a().a().post(new MiniAppReportManager2.1(paramMiniAppInfo, paramString1, paramString3, paramString2));
            if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {
              break label410;
            }
            str1 = paramMiniAppInfo.appId;
            if (!"2launch_fail".equals(paramString1)) {
              break;
            }
            localObject = (Integer)jdField_b_of_type_JavaUtilHashMap.get(paramString2);
            paramString2 = (String)localObject;
            if (localObject == null) {
              paramString2 = Integer.valueOf(401);
            }
            int i = paramString2.intValue();
            if (paramMiniAppInfo.isReportTypeMiniGame())
            {
              paramString2 = "1";
              str2 = bdse.a(str1);
              String str3 = bdse.c(str1);
              if (!paramMiniAppInfo.isReportTypeMiniGame()) {
                break label195;
              }
              localObject = bdse.e(str1);
              bdsu.a(paramMiniAppInfo, 2, paramString3, null, null, i, paramString2, 0L, null, str2, str3, (String)localObject, bdse.d(str1));
              if (!"2unload".equals(paramString1)) {
                break label418;
              }
              bdse.b(paramMiniAppInfo.appId);
              return;
            }
          }
          catch (Throwable paramString1)
          {
            bdnw.d("MiniAppReportManager2", "", paramString1);
            return;
          }
          paramString2 = "0";
          continue;
          localObject = bdse.b(str1);
        }
        if (("2launch".equals(paramString1)) && ("first_frame".equals(paramString2)))
        {
          bdse.d(str1, true);
          if (!paramMiniAppInfo.isReportTypeMiniGame()) {
            break label419;
          }
          paramString2 = "1";
          localObject = bdse.a(str1);
          str2 = bdse.c(str1);
          if (paramMiniAppInfo.isReportTypeMiniGame()) {}
          for (str1 = bdse.e(str1);; str1 = bdse.b(str1))
          {
            bdsu.a(paramMiniAppInfo, 2, paramString3, null, null, 0, paramString2, 0L, null, (String)localObject, str2, str1, "cold_start");
            break;
          }
        }
      } while ((!"2launch".equals(paramString1)) || (!"click_resume".equals(paramString2)));
      bdse.a(str1, true);
    } while (bdse.d(str1) == 1);
    if (paramMiniAppInfo.isReportTypeMiniGame()) {}
    for (paramString2 = "1";; paramString2 = "0")
    {
      localObject = bdse.a(str1);
      str2 = bdse.c(str1);
      if (paramMiniAppInfo.isReportTypeMiniGame()) {}
      for (str1 = bdse.e(str1);; str1 = bdse.b(str1))
      {
        bdsu.a(paramMiniAppInfo, 2, paramString3, null, null, 0, paramString2, 0L, null, (String)localObject, str2, str1, "hot_start");
        break;
      }
      label410:
      str1 = "";
      break;
      label418:
      return;
      label419:
      paramString2 = "0";
      break label241;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, MiniAppInfo paramMiniAppInfo)
  {
    String str1 = a(paramMiniAppInfo);
    if (bdnw.b()) {
      bdnw.a("MiniAppReportManager2", "reportPageViewInMainProcess  new report called with: [launchId = " + paramString3 + "], [subActionType = " + paramString2 + "], [appType = " + str1 + "], [reserves = " + paramString5 + "], [reserves2 = " + paramString6 + "], [reserves3 = " + paramString7 + "], [path =" + paramString4 + "]");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(bdsq.a());
    String str2 = bdgj.a(paramString4);
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null)) {}
    for (paramString4 = String.valueOf(paramMiniAppInfo.launchParam.jdField_a_of_type_Int);; paramString4 = null)
    {
      localArrayList.addAll(bdsq.a(paramMiniAppInfo, str2, paramString4, paramString1, paramString2, paramString5, paramString6, paramString7, null, null, str1, paramString3));
      localArrayList.addAll(bdsq.b());
      if ((a(paramString2, paramMiniAppInfo)) && (paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null) && (paramMiniAppInfo.launchParam.jdField_a_of_type_JavaUtilMap != null) && (paramMiniAppInfo.launchParam.jdField_a_of_type_JavaUtilMap.size() > 0)) {
        localArrayList.addAll(bdsq.a(paramMiniAppInfo.launchParam.jdField_a_of_type_JavaUtilMap));
      }
      paramString1 = bdsq.a(2, localArrayList, null);
      bdsr.a().b(paramString1);
      if ((bdhg.a("MiniApp", "mini_app_report_first_frame_flush", 1) == 1) && ("2show".equals(paramString2)) && ("first_frame".equals(paramString5))) {
        bdsr.a().a(true);
      }
      return;
    }
  }
  
  public static boolean a(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    return true;
  }
  
  private static void b()
  {
    SharedPreferences localSharedPreferences = MiniAppEnv.g().getContext().getSharedPreferences("MiniAppLaunshState", 4);
    Object localObject = localSharedPreferences.getString("appid", null);
    if (localObject != null)
    {
      localObject = ((String)localObject).split(",");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject[i];
        if (!TextUtils.isEmpty(localCharSequence))
        {
          String str = localSharedPreferences.getString(localCharSequence, null);
          if (str != null)
          {
            bdsd localbdsd = new bdsd();
            localbdsd.a(str);
            if (!TextUtils.isEmpty(localbdsd.jdField_a_of_type_JavaLangString)) {
              jdField_a_of_type_JavaUtilHashMap.put(localCharSequence, localbdsd);
            }
          }
        }
        i += 1;
      }
      d();
    }
  }
  
  private static void b(bdsd parambdsd)
  {
    parambdsd.jdField_d_of_type_Int = 2;
    long l = parambdsd.f - parambdsd.jdField_a_of_type_Long;
    if (l <= 0L) {
      l = parambdsd.jdField_a_of_type_Long - System.currentTimeMillis();
    }
    for (;;)
    {
      String str2 = a(l);
      MiniAppInfo localMiniAppInfo;
      if (parambdsd.jdField_a_of_type_Boolean)
      {
        localMiniAppInfo = new MiniAppInfo();
        localMiniAppInfo.appId = parambdsd.jdField_a_of_type_JavaLangString;
      }
      try
      {
        localMiniAppInfo.verType = parambdsd.jdField_c_of_type_Int;
        localMiniAppInfo.setEngineType(parambdsd.jdField_a_of_type_Int);
        localMiniAppInfo.setReportType(parambdsd.jdField_b_of_type_Int);
        label88:
        if (parambdsd.jdField_b_of_type_Long == 0L) {}
        for (String str1 = "2load_fail";; str1 = "2show_fail")
        {
          a("page_view", str1, parambdsd.jdField_b_of_type_JavaLangString, null, str2, String.valueOf(l), parambdsd.b(), localMiniAppInfo);
          parambdsd.jdField_a_of_type_Boolean = false;
          parambdsd.jdField_d_of_type_Int = 2;
          c();
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label88;
      }
    }
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, MiniAppInfo paramMiniAppInfo)
  {
    bdsd localbdsd = a(paramString1, paramString2, paramString3, paramMiniAppInfo);
    if (localbdsd == null) {
      bdnw.a("MiniAppReportManager2", "new report (launchState is not exist): [subActionType = " + paramString1 + "], [reserves = " + paramString2 + "], [path = " + paramString3 + "]");
    }
    long l1;
    do
    {
      do
      {
        return;
        if (bdnw.b()) {
          bdnw.a("MiniAppReportManager2", "reportPageViewInMainProcess called with: launchId = [" + localbdsd.jdField_b_of_type_JavaLangString + "], subActionType = [" + paramString1 + "], reserves = [" + paramString2 + "], path = [" + paramString3 + "]");
        }
        l1 = localbdsd.jdField_c_of_type_Long - localbdsd.jdField_a_of_type_Long;
        long l2 = localbdsd.f;
        long l3 = localbdsd.e;
        if (("2back_key".equals(paramString1)) && (localbdsd.jdField_a_of_type_Boolean))
        {
          a("page_view", "2show_fail", localbdsd.jdField_b_of_type_JavaLangString, null, "back_cancel", String.valueOf(l1), localbdsd.b(), paramMiniAppInfo);
          localbdsd.jdField_a_of_type_Boolean = false;
        }
        if (("2close".equals(paramString1)) && (localbdsd.jdField_a_of_type_Boolean))
        {
          a("page_view", "2show_fail", localbdsd.jdField_b_of_type_JavaLangString, null, "close_cancel", String.valueOf(l1), localbdsd.b(), paramMiniAppInfo);
          localbdsd.jdField_a_of_type_Boolean = false;
        }
        if ("2hide".equals(paramString1))
        {
          if (localbdsd.jdField_a_of_type_Boolean)
          {
            a("page_view", "2show_fail", localbdsd.jdField_b_of_type_JavaLangString, null, "home_cancel", String.valueOf(l1), localbdsd.b(), paramMiniAppInfo);
            localbdsd.jdField_a_of_type_Boolean = false;
          }
          a("page_view", paramString1, localbdsd.jdField_b_of_type_JavaLangString, paramString3, paramString2, String.valueOf(l2 - l3), null, paramMiniAppInfo);
          return;
        }
        if (!"2launch_fail".equals(paramString1)) {
          break;
        }
      } while (!localbdsd.jdField_a_of_type_Boolean);
      a("page_view", "2show_fail", localbdsd.jdField_b_of_type_JavaLangString, null, paramString2, String.valueOf(l1), localbdsd.b(), paramMiniAppInfo);
      localbdsd.jdField_a_of_type_Boolean = false;
      return;
      if (!"2launch".equals(paramString1)) {
        break;
      }
      if (localbdsd.jdField_a_of_type_Boolean)
      {
        a("page_view", "2show", localbdsd.jdField_b_of_type_JavaLangString, paramString3, paramString2, String.valueOf(l1), localbdsd.b(), paramMiniAppInfo);
        localbdsd.jdField_a_of_type_Boolean = false;
      }
    } while (!"first_frame".equals(paramString2));
    a("page_view", "2show", localbdsd.jdField_b_of_type_JavaLangString, paramString3, "first_frame_extend", String.valueOf(l1), localbdsd.b(), paramMiniAppInfo);
    return;
    a("page_view", paramString1, localbdsd.jdField_b_of_type_JavaLangString, paramString3, paramString2, null, localbdsd.b(), paramMiniAppInfo);
  }
  
  private static void c()
  {
    SharedPreferences.Editor localEditor = MiniAppEnv.g().getContext().getSharedPreferences("MiniAppLaunshState", 4).edit();
    localEditor.clear();
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (bdsd)((Map.Entry)localObject).getValue();
      if (((bdsd)localObject).jdField_d_of_type_Int == 0)
      {
        localStringBuilder.append(str);
        localStringBuilder.append(',');
        localEditor.putString(str, ((bdsd)localObject).a());
      }
    }
    localEditor.putString("appid", localStringBuilder.toString());
    localEditor.commit();
  }
  
  private static void d()
  {
    if (jdField_a_of_type_AndroidOsHandler == null) {
      jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    if ((jdField_a_of_type_AndroidOsHandler != null) && (!jdField_c_of_type_Boolean))
    {
      jdField_a_of_type_AndroidOsHandler.postDelayed(jdField_a_of_type_JavaLangRunnable, jdField_a_of_type_Long);
      jdField_c_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdsc
 * JD-Core Version:    0.7.0.1
 */