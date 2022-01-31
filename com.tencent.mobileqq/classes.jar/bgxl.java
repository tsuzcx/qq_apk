import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2.1;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2.2;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2.3;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class bgxl
{
  public static final long a;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static Runnable jdField_a_of_type_JavaLangRunnable = new MiniAppReportManager2.2();
  public static HashMap<String, bgxm> a;
  public static final boolean a;
  public static HashMap<String, Integer> b;
  private static boolean b;
  private static boolean c;
  
  static
  {
    jdField_a_of_type_Long = a();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_Boolean = AppLoaderFactory.g().isMainProcess();
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
    return bglq.a("qqtriton", "MiniShowTimeout", 45000L);
  }
  
  private static bgxm a(String paramString1, String paramString2, String paramString3, MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      QMLog.d("MiniAppReportManager2", "new report (appId is null)");
      paramString1 = null;
      return paramString1;
    }
    long l = System.currentTimeMillis();
    if (jdField_b_of_type_Boolean)
    {
      jdField_b_of_type_Boolean = false;
      c();
      jdField_a_of_type_JavaLangRunnable.run();
    }
    paramString3 = (bgxm)jdField_a_of_type_JavaUtilHashMap.get(paramMiniAppInfo.appId);
    if (paramString3 == null)
    {
      paramString3 = new bgxm();
      paramString3.jdField_b_of_type_JavaLangString = String.valueOf(l);
      jdField_a_of_type_JavaUtilHashMap.put(paramMiniAppInfo.appId, paramString3);
    }
    for (;;)
    {
      paramString3.jdField_a_of_type_JavaLangString = paramMiniAppInfo.appId;
      paramString3.jdField_a_of_type_Int = paramMiniAppInfo.getEngineType();
      paramString3.jdField_b_of_type_Int = paramMiniAppInfo.getReportType();
      paramString3.jdField_c_of_type_Int = paramMiniAppInfo.verType;
      paramString3.jdField_d_of_type_Long = l;
      if ("2click".equals(paramString1))
      {
        if (paramString3.jdField_d_of_type_Int != 0) {
          break label541;
        }
        label152:
        paramString3.a();
        e();
        paramString3.jdField_a_of_type_Long = l;
        if (!bgxm.jdField_b_of_type_Boolean) {
          if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getTbsVersion() <= 0) {
            break label553;
          }
        }
      }
      label541:
      label553:
      for (boolean bool = true;; bool = false)
      {
        bgxm.jdField_b_of_type_Boolean = bool;
        paramString3.jdField_c_of_type_Boolean = bgrb.a(paramMiniAppInfo);
        paramString3.jdField_d_of_type_Boolean = true;
        d();
        if ((paramString3.jdField_d_of_type_Int != 0) && ("2show".equals(paramString1)) && ("bring_to_front".equals(paramString2)))
        {
          paramString3.a();
          e();
          paramString3.jdField_a_of_type_Long = l;
          d();
        }
        if ("2load".equals(paramString1)) {
          paramString3.jdField_b_of_type_Long = l;
        }
        if ("2load_end".equals(paramString1)) {
          paramString3.g = l;
        }
        if ((paramString3.jdField_d_of_type_Int == 0) && ("2launch".equals(paramString1)))
        {
          paramString3.jdField_c_of_type_Long = l;
          paramString3.jdField_d_of_type_Int = 1;
          paramString3.jdField_a_of_type_Boolean = true;
          d();
        }
        if ((paramString3.jdField_d_of_type_Int == 0) && (("2launch_fail".equals(paramString1)) || ("2close".equals(paramString1)) || ("2back_key".equals(paramString1)) || ("2hide".equals(paramString1))))
        {
          paramString3.jdField_c_of_type_Long = l;
          paramString3.jdField_d_of_type_Int = 2;
          paramString3.jdField_a_of_type_Boolean = true;
          d();
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
        if (!QMLog.isDebugEnabled()) {
          break;
        }
        QMLog.d("MiniAppReportManager2", "launchState: launchId = [" + paramString3.jdField_b_of_type_JavaLangString + "], launchResult = [" + paramString3.jdField_d_of_type_Int + "], clickTime = [" + paramString3.jdField_a_of_type_Long + "], launchTime = [" + paramString3.jdField_c_of_type_Long + "], showTime = [" + paramString3.e + "], hideTime = [" + paramString3.f + "]");
        return paramString3;
        paramString3.jdField_b_of_type_JavaLangString = String.valueOf(l);
        break label152;
      }
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
    return "0";
  }
  
  public static void a()
  {
    QMLog.d("MiniAppReportManager2", "onEnterBackground");
    try
    {
      bgya.a().a().post(new MiniAppReportManager2.3());
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("MiniAppReportManager2", "onEnterBackground exception", localThrowable);
    }
  }
  
  public static void a(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo)
  {
    bgxm localbgxm = (bgxm)jdField_a_of_type_JavaUtilHashMap.get(paramMiniAppInfo.appId);
    String str = "";
    if (localbgxm != null)
    {
      if (!localbgxm.jdField_d_of_type_Boolean) {
        break label97;
      }
      paramString = "" + "flutter";
    }
    for (;;)
    {
      str = paramString;
      if (localbgxm.jdField_c_of_type_Boolean) {
        str = paramString + "_hasPkg";
      }
      bgyd.a(paramMiniAppInfo, paramInt, str, bgyd.a(paramMiniAppInfo));
      return;
      label97:
      if (bgxm.jdField_b_of_type_Boolean) {
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
    int i;
    String str2;
    label199:
    label245:
    do
    {
      do
      {
        String str3;
        for (;;)
        {
          try
          {
            if (jdField_a_of_type_Boolean)
            {
              b(paramString1, paramString2, paramString3, paramMiniAppInfo);
              return;
            }
            bgya.a().a().post(new MiniAppReportManager2.1(paramMiniAppInfo, paramString1, paramString3, paramString2));
            if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {
              break label461;
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
            i = paramString2.intValue();
            if (paramMiniAppInfo.isReportTypeMiniGame())
            {
              paramString2 = "1";
              str2 = bgxn.a(str1);
              str3 = bgxn.c(str1);
              if (!paramMiniAppInfo.isReportTypeMiniGame()) {
                break label199;
              }
              localObject = bgxn.e(str1);
              bgyd.a(paramMiniAppInfo, 2, paramString3, null, null, i, paramString2, 0L, null, str2, str3, (String)localObject, bgxn.d(str1));
              if ((!"2unload".equals(paramString1)) || (paramMiniAppInfo == null)) {
                break label469;
              }
              bgxn.b(paramMiniAppInfo.appId);
              return;
            }
          }
          catch (Throwable paramString1)
          {
            QMLog.e("MiniAppReportManager2", "", paramString1);
            return;
          }
          paramString2 = "0";
          continue;
          localObject = bgxn.b(str1);
        }
        if (("2launch".equals(paramString1)) && ("first_frame".equals(paramString2)))
        {
          bgxn.e(str1, true);
          if (!paramMiniAppInfo.isReportTypeMiniGame()) {
            break label470;
          }
          paramString2 = "1";
          str2 = bgxn.a(str1);
          str3 = bgxn.c(str1);
          if (paramMiniAppInfo.isReportTypeMiniGame()) {}
          for (localObject = bgxn.e(str1);; localObject = bgxn.b(str1))
          {
            bgyd.a(paramMiniAppInfo, 2, paramString3, null, null, 0, paramString2, 0L, null, str2, str3, (String)localObject, "cold_start");
            if ((!paramMiniAppInfo.isEngineTypeMiniApp()) || (!paramMiniAppInfo.supportNativeRenderMode())) {
              break;
            }
            bgxn.a(str1, true);
            break;
          }
        }
      } while ((!"2launch".equals(paramString1)) || (!"click_resume".equals(paramString2)));
      if ((!paramMiniAppInfo.isEngineTypeMiniApp()) || (!paramMiniAppInfo.supportNativeRenderMode())) {
        break label477;
      }
      i = 1;
      if (i == 0) {
        bgxn.a(str1, true);
      }
    } while ((bgxn.d(str1) == 1) || (i != 0));
    label363:
    if (paramMiniAppInfo.isReportTypeMiniGame()) {}
    for (paramString2 = "1";; paramString2 = "0")
    {
      localObject = bgxn.a(str1);
      str2 = bgxn.c(str1);
      if (paramMiniAppInfo.isReportTypeMiniGame()) {}
      for (str1 = bgxn.e(str1);; str1 = bgxn.b(str1))
      {
        bgyd.a(paramMiniAppInfo, 2, paramString3, null, null, 0, paramString2, 0L, null, (String)localObject, str2, str1, "hot_start");
        break;
      }
      label461:
      str1 = "";
      break;
      label469:
      return;
      label470:
      paramString2 = "0";
      break label245;
      label477:
      i = 0;
      break label363;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, MiniAppInfo paramMiniAppInfo)
  {
    ArrayList localArrayList;
    if (QUAUtil.isQQApp())
    {
      if ("2click".equals(paramString2)) {
        a(paramString1, "click", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
      }
    }
    else
    {
      String str1 = a(paramMiniAppInfo);
      if (QMLog.isDebugEnabled()) {
        QMLog.d("MiniAppReportManager2", "reportPageViewInMainProcess  new report called with: [launchId = " + paramString3 + "], [subActionType = " + paramString2 + "], [appType = " + str1 + "], [reserves = " + paramString5 + "], [reserves2 = " + paramString6 + "], [reserves3 = " + paramString7 + "], [path =" + paramString4 + "]");
      }
      localArrayList = new ArrayList();
      localArrayList.addAll(bgxz.b());
      String str2 = bgkl.a(paramString4);
      if ((paramMiniAppInfo == null) || (paramMiniAppInfo.launchParam == null)) {
        break label562;
      }
      paramString4 = String.valueOf(paramMiniAppInfo.launchParam.scene);
      label191:
      localArrayList.addAll(bgxz.a(paramMiniAppInfo, str2, paramString4, paramString1, paramString2, paramString5, paramString6, paramString7, null, null, null, str1, paramString3));
      localArrayList.addAll(bgxz.c());
      if (!QUAUtil.isQQApp()) {
        localArrayList.addAll(bgxz.a());
      }
      if (!QUAUtil.isQQApp()) {
        break label567;
      }
    }
    label562:
    label567:
    for (int i = 2;; i = 12)
    {
      paramString1 = bgxz.a(i, localArrayList, null);
      bgya.a().b(paramString1);
      if ((bglq.a("qqminiapp", "mini_app_report_first_frame_flush", 1) == 1) && ("2show".equals(paramString2)) && (("first_frame".equals(paramString5)) || ("click_resume".equals(paramString5)))) {
        bgya.a().a(true);
      }
      return;
      if ("2show".equals(paramString2))
      {
        a(paramString1, "show", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        break;
      }
      if ("2hide".equals(paramString2))
      {
        a(paramString1, "hide", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        break;
      }
      if ("2load".equals(paramString2))
      {
        a(paramString1, "load", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        break;
      }
      if ("2close".equals(paramString2))
      {
        a(paramString1, "close", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        break;
      }
      if ("2unload".equals(paramString2))
      {
        a(paramString1, "unload", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        break;
      }
      if ("2show_fail".equals(paramString2))
      {
        a(paramString1, "show_fail", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        break;
      }
      if ("2load_fail".equals(paramString2))
      {
        a(paramString1, "load_fail", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        break;
      }
      if (!"2finishshow".equals(paramString2)) {
        break;
      }
      a(paramString1, "finishshow", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
      break;
      paramString4 = null;
      break label191;
    }
  }
  
  private static void b(bgxm parambgxm)
  {
    parambgxm.jdField_d_of_type_Int = 2;
    long l = parambgxm.f - parambgxm.jdField_a_of_type_Long;
    if (l <= 0L) {
      l = parambgxm.jdField_a_of_type_Long - System.currentTimeMillis();
    }
    for (;;)
    {
      String str2 = a(l);
      MiniAppInfo localMiniAppInfo;
      if (parambgxm.jdField_a_of_type_Boolean)
      {
        localMiniAppInfo = new MiniAppInfo();
        localMiniAppInfo.appId = parambgxm.jdField_a_of_type_JavaLangString;
      }
      try
      {
        localMiniAppInfo.verType = parambgxm.jdField_c_of_type_Int;
        localMiniAppInfo.setEngineType(parambgxm.jdField_a_of_type_Int);
        localMiniAppInfo.setReportType(parambgxm.jdField_b_of_type_Int);
        label88:
        if (parambgxm.jdField_b_of_type_Long == 0L) {}
        for (String str1 = "2load_fail";; str1 = "2show_fail")
        {
          a("page_view", str1, parambgxm.jdField_b_of_type_JavaLangString, null, str2, String.valueOf(l), parambgxm.b(), localMiniAppInfo);
          parambgxm.jdField_a_of_type_Boolean = false;
          parambgxm.jdField_d_of_type_Int = 2;
          d();
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
    bgxm localbgxm = a(paramString1, paramString2, paramString3, paramMiniAppInfo);
    if (localbgxm == null) {
      QMLog.d("MiniAppReportManager2", "new report (launchState is not exist): [subActionType = " + paramString1 + "], [reserves = " + paramString2 + "], [path = " + paramString3 + "]");
    }
    long l1;
    long l4;
    long l5;
    long l6;
    long l7;
    do
    {
      do
      {
        return;
        if (QMLog.isDebugEnabled()) {
          QMLog.d("MiniAppReportManager2", "reportPageViewInMainProcess called with: launchId = [" + localbgxm.jdField_b_of_type_JavaLangString + "], subActionType = [" + paramString1 + "], reserves = [" + paramString2 + "], path = [" + paramString3 + "]");
        }
        l1 = localbgxm.jdField_c_of_type_Long - localbgxm.jdField_a_of_type_Long;
        long l2 = localbgxm.f;
        long l3 = localbgxm.e;
        l4 = localbgxm.jdField_b_of_type_Long;
        l5 = localbgxm.jdField_a_of_type_Long;
        l6 = localbgxm.g;
        l7 = localbgxm.jdField_a_of_type_Long;
        if (("2back_key".equals(paramString1)) && (localbgxm.jdField_a_of_type_Boolean))
        {
          a("page_view", "2show_fail", localbgxm.jdField_b_of_type_JavaLangString, null, "back_cancel", String.valueOf(l1), localbgxm.b(), paramMiniAppInfo);
          localbgxm.jdField_a_of_type_Boolean = false;
        }
        if (("2close".equals(paramString1)) && (localbgxm.jdField_a_of_type_Boolean))
        {
          a("page_view", "2show_fail", localbgxm.jdField_b_of_type_JavaLangString, null, "close_cancel", String.valueOf(l1), localbgxm.b(), paramMiniAppInfo);
          localbgxm.jdField_a_of_type_Boolean = false;
        }
        if ("2hide".equals(paramString1))
        {
          if (localbgxm.jdField_a_of_type_Boolean)
          {
            a("page_view", "2show_fail", localbgxm.jdField_b_of_type_JavaLangString, null, "home_cancel", String.valueOf(l1), localbgxm.b(), paramMiniAppInfo);
            localbgxm.jdField_a_of_type_Boolean = false;
          }
          a("page_view", paramString1, localbgxm.jdField_b_of_type_JavaLangString, paramString3, paramString2, String.valueOf(l2 - l3), null, paramMiniAppInfo);
          return;
        }
        if (!"2launch_fail".equals(paramString1)) {
          break;
        }
      } while (!localbgxm.jdField_a_of_type_Boolean);
      a("page_view", "2show_fail", localbgxm.jdField_b_of_type_JavaLangString, null, paramString2, String.valueOf(l1), localbgxm.b(), paramMiniAppInfo);
      localbgxm.jdField_a_of_type_Boolean = false;
      return;
      if (!"2launch".equals(paramString1)) {
        break;
      }
      if (localbgxm.jdField_a_of_type_Boolean)
      {
        a("page_view", "2show", localbgxm.jdField_b_of_type_JavaLangString, paramString3, paramString2, String.valueOf(l1), localbgxm.b(), paramMiniAppInfo);
        localbgxm.jdField_a_of_type_Boolean = false;
      }
    } while (!"first_frame".equals(paramString2));
    a("page_view", "2show", localbgxm.jdField_b_of_type_JavaLangString, paramString3, "first_frame_extend", String.valueOf(l1), localbgxm.b(), paramMiniAppInfo);
    return;
    if ("2load".equals(paramString1))
    {
      a("page_view", paramString1, localbgxm.jdField_b_of_type_JavaLangString, paramString3, paramString2, String.valueOf(l4 - l5), localbgxm.b(), paramMiniAppInfo);
      return;
    }
    if ("2load_end".equals(paramString1))
    {
      a("page_view", paramString1, localbgxm.jdField_b_of_type_JavaLangString, paramString3, paramString2, String.valueOf(l6 - l7), localbgxm.b(), paramMiniAppInfo);
      return;
    }
    a("page_view", paramString1, localbgxm.jdField_b_of_type_JavaLangString, paramString3, paramString2, null, localbgxm.b(), paramMiniAppInfo);
  }
  
  private static void c()
  {
    SharedPreferences localSharedPreferences = AppLoaderFactory.g().getMiniAppEnv().getContext().getSharedPreferences("MiniAppLaunshState", 4);
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
            bgxm localbgxm = new bgxm();
            localbgxm.a(str);
            if (!TextUtils.isEmpty(localbgxm.jdField_a_of_type_JavaLangString)) {
              jdField_a_of_type_JavaUtilHashMap.put(localCharSequence, localbgxm);
            }
          }
        }
        i += 1;
      }
      e();
    }
  }
  
  private static void d()
  {
    SharedPreferences.Editor localEditor = AppLoaderFactory.g().getMiniAppEnv().getContext().getSharedPreferences("MiniAppLaunshState", 4).edit();
    localEditor.clear();
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (bgxm)((Map.Entry)localObject).getValue();
      if (((bgxm)localObject).jdField_d_of_type_Int == 0)
      {
        localStringBuilder.append(str);
        localStringBuilder.append(',');
        localEditor.putString(str, ((bgxm)localObject).a());
      }
    }
    localEditor.putString("appid", localStringBuilder.toString());
    localEditor.commit();
  }
  
  private static void e()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgxl
 * JD-Core Version:    0.7.0.1
 */