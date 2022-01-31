import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.RenderInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class bhck
{
  static final int jdField_a_of_type_Int = bgpx.a("qqminiapp", "mini_app_report_max_time_cost", 120000);
  private static SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private static ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public static HashMap<String, bhcm> a;
  private static final Map<String, List<String>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static SparseArray<bhcl> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private static ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(1, "onlaunch");
    jdField_a_of_type_AndroidUtilSparseArray.put(4, "basejsdownloadstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(5, "basejsdownloadend");
    jdField_a_of_type_AndroidUtilSparseArray.put(6, "basejsunzipstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(7, "basejsunzipend");
    jdField_a_of_type_AndroidUtilSparseArray.put(8, "basejsreadstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(9, "basejsreadend");
    jdField_a_of_type_AndroidUtilSparseArray.put(10, "basejsreadstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(11, "basejsreadend");
    jdField_a_of_type_AndroidUtilSparseArray.put(12, "appconfigreadstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(13, "appconfigreadend");
    jdField_a_of_type_AndroidUtilSparseArray.put(14, "servicejsstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(15, "servicejsend");
    jdField_a_of_type_AndroidUtilSparseArray.put(16, "basejsstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(17, "basejsready");
    jdField_a_of_type_AndroidUtilSparseArray.put(18, "webviewjsstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(19, "webviewjsready");
    jdField_a_of_type_AndroidUtilSparseArray.put(2, "apponloaded");
    jdField_a_of_type_AndroidUtilSparseArray.put(20, "apponhide");
    jdField_a_of_type_AndroidUtilSparseArray.put(21, "apponshow");
    jdField_a_of_type_AndroidUtilSparseArray.put(22, "apponunload");
    jdField_a_of_type_AndroidUtilSparseArray.put(23, "jsonerror");
    jdField_a_of_type_AndroidUtilSparseArray.put(24, "appcreate");
    jdField_a_of_type_AndroidUtilSparseArray.put(100, "service_start");
    jdField_a_of_type_AndroidUtilSparseArray.put(101, "service_end");
    jdField_a_of_type_AndroidUtilSparseArray.put(102, "webview_start");
    jdField_a_of_type_AndroidUtilSparseArray.put(103, "webview_end");
    jdField_a_of_type_AndroidUtilSparseArray.put(104, "app_load_start");
    jdField_a_of_type_AndroidUtilSparseArray.put(105, "app_load_end");
    jdField_a_of_type_AndroidUtilSparseArray.put(104, "service_app_start");
    jdField_a_of_type_AndroidUtilSparseArray.put(105, "service_app_end");
    jdField_a_of_type_AndroidUtilSparseArray.put(106, "webview_app_start");
    jdField_a_of_type_AndroidUtilSparseArray.put(107, "webview_app_end");
    jdField_a_of_type_AndroidUtilSparseArray.put(200, "runtimecreatetaskstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(201, "runtimecreatetaskend");
    jdField_a_of_type_AndroidUtilSparseArray.put(202, "runtimeinittaskstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(203, "runtimeinittaskend");
    jdField_a_of_type_AndroidUtilSparseArray.put(204, "baselibloadasynctaskstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(205, "baselibloadasynctaskend");
    jdField_a_of_type_AndroidUtilSparseArray.put(206, "apkgloadasynctaskstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(207, "apkgloadasynctaskend");
    jdField_a_of_type_AndroidUtilSparseArray.put(208, "serviceinittaskstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(209, "serviceinittaskend");
    jdField_a_of_type_AndroidUtilSparseArray.put(210, "preloadflagtaskstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(211, "preloadflagtaskend");
    jdField_a_of_type_AndroidUtilSparseArray.put(212, "flutterviewinitstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(213, "flutterviewcreateend");
    jdField_a_of_type_AndroidUtilSparseArray.put(214, "flutterviewchannelinitend");
    jdField_a_of_type_AndroidUtilSparseArray.put(215, "flutterlaunchappstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(216, "flutterlaunchappend");
    jdField_a_of_type_AndroidUtilSparseArray.put(217, "fluttermatchtimecost");
    jdField_a_of_type_AndroidUtilSparseArray.put(218, "fluttersetdatatimecost");
    jdField_a_of_type_AndroidUtilSparseArray.put(219, "flutterrendertimecost");
    jdField_a_of_type_AndroidUtilSparseArray.put(220, "fluttertotaltimecost");
    jdField_a_of_type_AndroidUtilSparseArray.put(221, "runtimecreatetaskstartrealtime");
    jdField_a_of_type_AndroidUtilSparseArray.put(222, "runtimeinittaskstartrealtime");
    jdField_a_of_type_AndroidUtilSparseArray.put(600, "ssocmdstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(601, "ssocmdend");
    jdField_a_of_type_AndroidUtilSparseArray.put(602, "x5installsuccess");
    jdField_a_of_type_AndroidUtilSparseArray.put(603, "x5installfail");
    jdField_a_of_type_AndroidUtilSparseArray.put(604, "x5installtimeout");
    jdField_a_of_type_AndroidUtilSparseArray.put(605, "preloadprocess");
    jdField_a_of_type_AndroidUtilSparseArray.put(606, "pageshow");
    jdField_a_of_type_AndroidUtilSparseArray.put(607, "pagehide");
    jdField_a_of_type_AndroidUtilSparseArray.put(612, "pageclick");
    jdField_a_of_type_AndroidUtilSparseArray.put(608, "onlaunchsucc");
    jdField_a_of_type_AndroidUtilSparseArray.put(609, "onlaunchfail");
    jdField_a_of_type_AndroidUtilSparseArray.put(610, "onlaunchtimeout");
    jdField_a_of_type_AndroidUtilSparseArray.put(619, "appdownloadstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(620, "appdownloadend");
    jdField_a_of_type_AndroidUtilSparseArray.put(621, "appunzipstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(622, "appunzipend");
    jdField_a_of_type_AndroidUtilSparseArray.put(611, "domready");
    jdField_a_of_type_AndroidUtilSparseArray.put(613, "subpkgdownloadstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(614, "subpkgdownloadend");
    jdField_a_of_type_AndroidUtilSparseArray.put(615, "subpkgunpackstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(616, "subpkgunpackend");
    jdField_a_of_type_AndroidUtilSparseArray.put(617, "basejsdownloadfailed");
    jdField_a_of_type_AndroidUtilSparseArray.put(618, "basejsunzipfailed");
    jdField_a_of_type_AndroidUtilSparseArray.put(623, "pageframeloadstart");
    jdField_a_of_type_AndroidUtilSparseArray.put(624, "pageframeloadend");
    jdField_a_of_type_AndroidUtilSparseArray.put(626, "preload_process_start");
    jdField_a_of_type_AndroidUtilSparseArray.put(627, "preload_process_end");
    jdField_a_of_type_AndroidUtilSparseArray.put(628, "http_request_result");
    jdField_a_of_type_AndroidUtilSparseArray.put(629, "cpuPerformance");
    jdField_a_of_type_AndroidUtilSparseArray.put(630, "fpsPerformance");
    jdField_a_of_type_AndroidUtilSparseArray.put(631, "memoryPerformance");
    jdField_a_of_type_AndroidUtilSparseArray.put(632, "web_socket_open");
    jdField_a_of_type_AndroidUtilSparseArray.put(633, "web_socket_close");
    jdField_a_of_type_AndroidUtilSparseArray.put(634, "web_socket_failure");
    jdField_a_of_type_AndroidUtilSparseArray.put(642, "fpsVariance");
    jdField_a_of_type_AndroidUtilSparseArray.put(643, "memoryGrowth");
    jdField_a_of_type_AndroidUtilSparseArray.put(644, "miniappstaytime");
    jdField_a_of_type_AndroidUtilSparseArray.put(636, "first_render_result");
    jdField_a_of_type_AndroidUtilSparseArray.put(637, "re_render_result");
    jdField_a_of_type_AndroidUtilSparseArray.put(638, "newpage_result");
    jdField_a_of_type_AndroidUtilSparseArray.put(639, "storage_usage");
    jdField_a_of_type_AndroidUtilSparseArray.put(640, "http_download");
    jdField_a_of_type_AndroidUtilSparseArray.put(641, "http_upload");
    jdField_a_of_type_AndroidUtilSparseArray.put(1001, "minigamebaselibloadso");
    jdField_a_of_type_AndroidUtilSparseArray.put(1002, "minigamebaselibloadsoend");
    jdField_a_of_type_AndroidUtilSparseArray.put(1003, "minigamebaselibloadjar");
    jdField_a_of_type_AndroidUtilSparseArray.put(1004, "minigamebaselibloadjarend");
    jdField_a_of_type_AndroidUtilSparseArray.put(1005, "minigamebaselibloadjs");
    jdField_a_of_type_AndroidUtilSparseArray.put(1006, "minigamebaselibloadjsend");
    jdField_a_of_type_AndroidUtilSparseArray.put(1007, "minigameloadmainpkg");
    jdField_a_of_type_AndroidUtilSparseArray.put(1008, "minigameloadmainpkgend");
    jdField_a_of_type_AndroidUtilSparseArray.put(1009, "minigameloadsubpkg");
    jdField_a_of_type_AndroidUtilSparseArray.put(1010, "minigameloadsubpkgend");
    jdField_a_of_type_AndroidUtilSparseArray.put(1011, "minigameprogresserror");
    jdField_a_of_type_AndroidUtilSparseArray.put(1012, "minigamebaselibinstallskip");
    jdField_a_of_type_AndroidUtilSparseArray.put(1013, "minigameenterloadingpage");
    jdField_a_of_type_AndroidUtilSparseArray.put(1014, "minigameloadbaselib");
    jdField_a_of_type_AndroidUtilSparseArray.put(1015, "minigameloadbaselibend");
    jdField_a_of_type_AndroidUtilSparseArray.put(1016, "minigamefirsthide");
    jdField_a_of_type_AndroidUtilSparseArray.put(1017, "minigamesurvival");
    jdField_a_of_type_AndroidUtilSparseArray.put(1018, "minigameblackscreen");
    jdField_a_of_type_AndroidUtilSparseArray.put(1019, "minigamenorefresh");
    jdField_a_of_type_AndroidUtilSparseArray.put(1020, "minigamefirststaytime");
    jdField_a_of_type_AndroidUtilSparseArray.put(1021, "minigamestaytime");
    jdField_a_of_type_AndroidUtilSparseArray.put(1022, "minigamefirstlaunch");
    jdField_a_of_type_AndroidUtilSparseArray.put(1023, "minigametwicelaunch");
    jdField_a_of_type_AndroidUtilSparseArray.put(1024, "minigameerrordialog");
    jdField_a_of_type_AndroidUtilSparseArray.put(1025, "capsulebuttoncloseclick");
    jdField_a_of_type_AndroidUtilSparseArray.put(1026, "loadingpagecloseclick");
    jdField_a_of_type_AndroidUtilSparseArray.put(1027, "minigameimagedownload");
    jdField_a_of_type_AndroidUtilSparseArray.put(1028, "miniappstartbycache");
    jdField_a_of_type_AndroidUtilSparseArray.put(1030, "stepstartactivity");
    jdField_a_of_type_AndroidUtilSparseArray.put(1031, "steponcreate");
    jdField_a_of_type_AndroidUtilSparseArray.put(1032, "stepinitdatamustonresume");
    jdField_a_of_type_AndroidUtilSparseArray.put(1033, "steploadbaselibtimecost");
    jdField_a_of_type_AndroidUtilSparseArray.put(1034, "stepinitjspluginlist");
    jdField_a_of_type_AndroidUtilSparseArray.put(1035, "steponresume");
    jdField_a_of_type_AndroidUtilSparseArray.put(1036, "steploadgpkg");
    jdField_a_of_type_AndroidUtilSparseArray.put(1037, "stepinitruntime");
    jdField_a_of_type_AndroidUtilSparseArray.put(1038, "stepinitjspluginengine");
    jdField_a_of_type_AndroidUtilSparseArray.put(1039, "stepcreatesurfaceview");
    jdField_a_of_type_AndroidUtilSparseArray.put(1040, "steplaunchgame");
    jdField_a_of_type_AndroidUtilSparseArray.put(1042, "stepfirstframefromgamelaunched");
    jdField_a_of_type_AndroidUtilSparseArray.put(1043, "stepfirstframefromcreate");
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(1));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(4));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(6));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(619));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(613));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(621));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(626));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(100));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(101));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(102));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(103));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(619));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(620));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(4));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(5));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(14));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(15));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(18));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(19));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(104));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(105));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(106));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(107));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(5));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(617));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(7));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(618));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(620));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(614));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(622));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(627));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(1022));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(1023));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(200));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(202));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(204));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(206));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(208));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(210));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(212));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(212));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(215));
    jdField_b_of_type_AndroidUtilSparseArray.put(2, new bhcl("launch_result", 1));
    jdField_b_of_type_AndroidUtilSparseArray.put(5, new bhcl("basejs_download_result", 4));
    jdField_b_of_type_AndroidUtilSparseArray.put(617, new bhcl("basejs_download_result", 4));
    jdField_b_of_type_AndroidUtilSparseArray.put(7, new bhcl("basejs_unzip_result", 6));
    jdField_b_of_type_AndroidUtilSparseArray.put(618, new bhcl("basejs_unzip_result", 6));
    jdField_b_of_type_AndroidUtilSparseArray.put(620, new bhcl("app_download_result", 619));
    jdField_b_of_type_AndroidUtilSparseArray.put(614, new bhcl("sub_download_result", 613));
    jdField_b_of_type_AndroidUtilSparseArray.put(622, new bhcl("app_unzip_result", 621));
    jdField_b_of_type_AndroidUtilSparseArray.put(627, new bhcl("preload_result", 626));
    jdField_b_of_type_AndroidUtilSparseArray.put(1022, new bhcl("game_first_launch_result", 1));
    jdField_b_of_type_AndroidUtilSparseArray.put(1023, new bhcl("game_twice_launch_result", 1));
    jdField_b_of_type_AndroidUtilSparseArray.put(201, new bhcl("runtime_create_task", 200));
    jdField_b_of_type_AndroidUtilSparseArray.put(203, new bhcl("runtime_init_task", 202));
    jdField_b_of_type_AndroidUtilSparseArray.put(205, new bhcl("base_lib_load_async_task", 204));
    jdField_b_of_type_AndroidUtilSparseArray.put(207, new bhcl("apkg_load_async_task", 206));
    jdField_b_of_type_AndroidUtilSparseArray.put(209, new bhcl("service_init_task", 208));
    jdField_b_of_type_AndroidUtilSparseArray.put(211, new bhcl("preload_flag_task", 210));
    jdField_b_of_type_AndroidUtilSparseArray.put(213, new bhcl("flutter_view_create", 212));
    jdField_b_of_type_AndroidUtilSparseArray.put(214, new bhcl("flutter_view_channel_init", 212));
    jdField_b_of_type_AndroidUtilSparseArray.put(216, new bhcl("flutter_launch_app", 215));
    jdField_b_of_type_JavaUtilArrayList.add("launch_result");
    jdField_b_of_type_JavaUtilArrayList.add("app_download_result");
    jdField_b_of_type_JavaUtilArrayList.add("stepstartactivity");
    jdField_b_of_type_JavaUtilArrayList.add("steponcreate");
    jdField_b_of_type_JavaUtilArrayList.add("stepinitdatamustonresume");
    jdField_b_of_type_JavaUtilArrayList.add("steploadbaselibtimecost");
    jdField_b_of_type_JavaUtilArrayList.add("stepinitjspluginlist");
    jdField_b_of_type_JavaUtilArrayList.add("steponresume");
    jdField_b_of_type_JavaUtilArrayList.add("steploadgpkg");
    jdField_b_of_type_JavaUtilArrayList.add("stepinitruntime");
    jdField_b_of_type_JavaUtilArrayList.add("stepinitjspluginengine");
    jdField_b_of_type_JavaUtilArrayList.add("stepcreatesurfaceview");
    jdField_b_of_type_JavaUtilArrayList.add("stepfirstframefromgamelaunched");
    jdField_b_of_type_JavaUtilArrayList.add("stepfirstframefromcreate");
    jdField_b_of_type_JavaUtilArrayList.add("steplaunchgame");
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static bhcm a(String paramString)
  {
    bhcm localbhcm2 = (bhcm)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    bhcm localbhcm1 = localbhcm2;
    if (localbhcm2 == null)
    {
      localbhcm1 = new bhcm();
      localbhcm1.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaUtilHashMap.put(paramString, localbhcm1);
    }
    return localbhcm1;
  }
  
  public static String a(int paramInt)
  {
    return (String)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public static String a(MiniAppInfo paramMiniAppInfo)
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
  
  public static JSONArray a(String paramString)
  {
    bhcm localbhcm = a(paramString);
    paramString = new JSONArray();
    try
    {
      JSONObject localJSONObject;
      if (localbhcm.jdField_b_of_type_JavaUtilMap.size() > 0)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("navigationStart", localbhcm.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(1)));
        localJSONObject.put("serviceStart", localbhcm.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(100)));
        localJSONObject.put("serviceEnd", localbhcm.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(101)));
        localJSONObject.put("viewStart", localbhcm.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(102)));
        localJSONObject.put("viewEnd", localbhcm.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(103)));
        localJSONObject.put("fetchPkgStart", localbhcm.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(619)));
        localJSONObject.put("fetchPkgEnd", localbhcm.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(620)));
        localJSONObject.put("fetchSdkStart", localbhcm.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(4)));
        localJSONObject.put("fetchSdkEnd", localbhcm.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(5)));
        localJSONObject.put("loadSdkServiceStart", localbhcm.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(14)));
        localJSONObject.put("loadSdkServiceEnd", localbhcm.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(15)));
        localJSONObject.put("loadSdkViewStart", localbhcm.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(18)));
        localJSONObject.put("loadSdkViewEnd", localbhcm.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(19)));
        localJSONObject.put("loadAppServiceStart", localbhcm.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(104)));
        localJSONObject.put("loadAppServiceEnd", localbhcm.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(105)));
        localJSONObject.put("loadAppViewStart", localbhcm.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(106)));
        localJSONObject.put("loadAppViewEnd", localbhcm.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(107)));
        paramString.put(localJSONObject);
      }
      if (localbhcm.jdField_a_of_type_JavaUtilMap.size() > 0)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("navigationStart", localbhcm.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1)));
        localJSONObject.put("serviceStart", localbhcm.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(100)));
        localJSONObject.put("serviceEnd", localbhcm.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(101)));
        localJSONObject.put("viewStart", localbhcm.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(102)));
        localJSONObject.put("viewEnd", localbhcm.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(103)));
        localJSONObject.put("fetchPkgStart", localbhcm.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(619)));
        localJSONObject.put("fetchPkgEnd", localbhcm.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(620)));
        localJSONObject.put("fetchSdkStart", localbhcm.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(4)));
        localJSONObject.put("fetchSdkEnd", localbhcm.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(5)));
        localJSONObject.put("loadSdkServiceStart", localbhcm.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(14)));
        localJSONObject.put("loadSdkServiceEnd", localbhcm.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(15)));
        localJSONObject.put("loadSdkViewStart", localbhcm.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(18)));
        localJSONObject.put("loadSdkViewEnd", localbhcm.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(19)));
        localJSONObject.put("loadAppServiceStart", localbhcm.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(104)));
        localJSONObject.put("loadAppServiceEnd", localbhcm.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(105)));
        localJSONObject.put("loadAppViewStart", localbhcm.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(106)));
        localJSONObject.put("loadAppViewEnd", localbhcm.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(107)));
        paramString.put(localJSONObject);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.e("MiniReportManager", "create performance result failed", localException);
      }
    }
    QMLog.e("MiniReportManager", "wesley: getformance: " + paramString.toString());
    return paramString;
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString)
  {
    a(paramMiniAppInfo, paramInt, null, null, null, 0, paramString, 0L, null, "", "", "", "");
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString, long paramLong)
  {
    a(paramMiniAppInfo, paramInt, null, null, null, 0, paramString, paramLong, null, "", "", "", "");
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString1, String paramString2)
  {
    a(paramMiniAppInfo, paramInt, null, paramString1, null, 0, paramString2, 0L, null, "", "", "", "");
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    a(paramMiniAppInfo, paramInt1, paramString1, paramString2, paramString3, paramInt2, a(paramMiniAppInfo), 0L, null);
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong, String paramString5)
  {
    a(paramMiniAppInfo, paramInt1, paramString1, paramString2, paramString3, paramInt2, paramString4, paramLong, paramString5, "", "", "", "");
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    long l2 = System.currentTimeMillis();
    if (paramMiniAppInfo != null) {}
    for (Object localObject1 = paramMiniAppInfo.appId;; localObject1 = "0000000000")
    {
      bhcm localbhcm = a((String)localObject1);
      long l1;
      Object localObject2;
      if (paramInt1 == 1)
      {
        if ((paramMiniAppInfo.isEngineTypeMiniApp()) && (paramMiniAppInfo.supportNativeRenderMode())) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            bhbu.a((String)localObject1);
          }
          if ((paramMiniAppInfo == null) || (paramMiniAppInfo.launchParam == null) || (paramMiniAppInfo.launchParam.launchClickTimeMillis == 0L)) {
            break label787;
          }
          l1 = paramMiniAppInfo.launchParam.launchClickTimeMillis;
          QMLog.d("MiniReportManager", "reportEventType: fix onlaunch timestamp to " + paramMiniAppInfo.launchParam.launchClickTimeMillis);
          localbhcm.jdField_a_of_type_Boolean = false;
          if (localbhcm.jdField_b_of_type_Boolean) {
            break label355;
          }
          localObject2 = a("0000000000");
          if ((localObject2 == null) || (((bhcm)localObject2).jdField_a_of_type_JavaUtilMap.size() <= 0)) {
            break label315;
          }
          Iterator localIterator = ((bhcm)localObject2).jdField_a_of_type_JavaUtilMap.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            localbhcm.jdField_a_of_type_JavaUtilMap.put(localEntry.getKey(), localEntry.getValue());
            QMLog.d("MiniReportManager", "transfer eventtime" + localEntry.getKey() + "[" + (String)jdField_a_of_type_AndroidUtilSparseArray.get(((Integer)localEntry.getKey()).intValue()) + " ] + appid:" + (String)localObject1);
          }
        }
        ((bhcm)localObject2).jdField_a_of_type_JavaUtilMap.clear();
      }
      for (;;)
      {
        label315:
        if ((paramInt1 == 611) && (!localbhcm.jdField_a_of_type_Boolean)) {
          paramInt1 = 2;
        }
        for (;;)
        {
          if (paramInt1 == 2) {
            if (localbhcm.jdField_a_of_type_Boolean) {
              QMLog.d("MiniReportManager", "has report apponloaded. ignore apponloaed ");
            }
          }
          label782:
          for (;;)
          {
            return;
            label355:
            if (localbhcm.jdField_b_of_type_JavaUtilMap.size() == 0) {
              localbhcm.jdField_b_of_type_JavaUtilMap.putAll(localbhcm.jdField_a_of_type_JavaUtilMap);
            }
            break;
            localbhcm.jdField_a_of_type_Boolean = true;
            localbhcm.jdField_b_of_type_Boolean = true;
            if (jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt1))) {
              localbhcm.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), Long.valueOf(l1));
            }
            localObject2 = "";
            localObject1 = localObject2;
            if (paramMiniAppInfo != null)
            {
              localObject1 = localObject2;
              if (paramMiniAppInfo.renderInfo != null) {
                localObject1 = paramMiniAppInfo.renderInfo.renderMode + "";
              }
            }
            bhby.a(paramMiniAppInfo, paramInt1, paramString1, paramString2, paramString3, paramInt2, paramString4, paramLong, paramString5, l1, paramString6, paramString7, paramString8, paramString9, (String)localObject1);
            paramString2 = (bhcl)jdField_b_of_type_AndroidUtilSparseArray.get(paramInt1);
            if (paramString2 != null)
            {
              paramString3 = (Long)localbhcm.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramString2.jdField_a_of_type_Int));
              if (paramString3 == null) {
                break label748;
              }
              paramLong = paramString3.longValue();
              if (paramLong > 0L)
              {
                l2 -= paramLong;
                paramString2 = paramString2.jdField_a_of_type_JavaLangString;
                paramString3 = (String)localbhcm.c.get(Integer.valueOf(paramInt1));
                if (l2 < 0L) {
                  break label754;
                }
                paramLong = l2;
                if (l2 > jdField_a_of_type_Int) {
                  paramLong = jdField_a_of_type_Int;
                }
                if (QMLog.isColorLevel()) {
                  QMLog.e("MiniReportManager", "timeCostEvent;eventId:" + paramInt1 + ";costTime:" + paramLong + "ms");
                }
                bhby.a(paramMiniAppInfo, paramString2, paramString3, paramInt2, paramLong, l1, paramString6, paramString7, paramString8, paramString9, (String)localObject1);
              }
            }
            for (;;)
            {
              if ((paramInt1 != 2) || (!"0".equals(paramString4))) {
                break label782;
              }
              bhby.a(paramMiniAppInfo, 630, paramString1, "0", null, 0, paramString4, 0L, null, l1, "", "", "", "", (String)localObject1);
              return;
              label748:
              paramLong = 0L;
              break;
              label754:
              QMLog.e("MiniReportManager", "costTime < 0 " + l2);
            }
          }
        }
        label787:
        l1 = l2;
        break;
        l1 = l2;
      }
    }
  }
  
  private static void a(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)) && (!TextUtils.isEmpty(paramString)))
    {
      if (jdField_a_of_type_JavaUtilMap.get(paramMiniAppInfo.appId) == null) {
        jdField_a_of_type_JavaUtilMap.put(paramMiniAppInfo.appId, new ArrayList());
      }
      ((List)jdField_a_of_type_JavaUtilMap.get(paramMiniAppInfo.appId)).add(paramString);
    }
  }
  
  public static void a(String paramString1, MiniAppInfo paramMiniAppInfo, String paramString2)
  {
    if (paramString1 != null)
    {
      QMLog.d("MiniReportManager", "checkShouldReportJSError: report js error " + paramString1);
      if (!a(paramMiniAppInfo, paramString1))
      {
        a(paramMiniAppInfo, 23, paramString2, paramString1, null, 0, a(paramMiniAppInfo), 0L, null, "", "", "", "");
        a(paramMiniAppInfo, paramString1);
      }
    }
  }
  
  private static boolean a(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramString))) {
      return true;
    }
    paramMiniAppInfo = (List)jdField_a_of_type_JavaUtilMap.get(paramMiniAppInfo.appId);
    if (paramMiniAppInfo != null)
    {
      paramMiniAppInfo = paramMiniAppInfo.iterator();
      while (paramMiniAppInfo.hasNext()) {
        if (paramString.equals((String)paramMiniAppInfo.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((QUAUtil.isQQApp()) && ("1".equals(paramString1)) && (!"hot_start".equals(paramString3))) {
      return jdField_b_of_type_JavaUtilArrayList.contains(paramString2);
    }
    return false;
  }
  
  public static void b(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString)
  {
    String str = "0000000000";
    if (paramMiniAppInfo != null) {
      str = paramMiniAppInfo.appId;
    }
    a(str).c.put(Integer.valueOf(paramInt), paramString);
    QMLog.d("MiniReportManager", "addCostTimeEventAttachInfo:  mileStoneEventKey:" + paramInt + "   attachInfo:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhck
 * JD-Core Version:    0.7.0.1
 */