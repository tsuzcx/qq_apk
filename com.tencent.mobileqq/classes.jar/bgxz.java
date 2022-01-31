import NS_COMM.COMM.Entry;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportReq;
import NS_MINI_REPORT.REPORT.SingleDcData;
import NS_MINI_REPORT.REPORT.StDcReportReq;
import NS_MINI_REPORT.REPORT.StThirdDcReportReq;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import com.tencent.qqmini.sdk.utils.EnvUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bgxz
{
  private static MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  public static final String a;
  private static final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static String jdField_b_of_type_JavaLangString;
  private static final Map<String, String> jdField_b_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = String.valueOf(DeviceInfoUtil.getPerfLevel());
    MiniAppInfo localMiniAppInfo = new MiniAppInfo();
    localMiniAppInfo.appId = "0000000000";
    jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = localMiniAppInfo;
    jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam.miniAppId = "0000000000";
  }
  
  private static long a()
  {
    try
    {
      ActivityManager localActivityManager = (ActivityManager)AppLoaderFactory.g().getContext().getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      localActivityManager.getMemoryInfo(localMemoryInfo);
      long l = localMemoryInfo.totalMem / 1024L / 1024L;
      return l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0L;
  }
  
  public static COMM.Entry a(String paramString1, String paramString2)
  {
    COMM.Entry localEntry = new COMM.Entry();
    if (paramString1 != null) {
      localEntry.key.set(paramString1);
    }
    if (paramString2 != null) {
      localEntry.value.set(paramString2);
    }
    return localEntry;
  }
  
  public static APP_REPORT_TRANSFER.SingleDcData a(int paramInt, List<COMM.Entry> paramList1, List<COMM.Entry> paramList2)
  {
    APP_REPORT_TRANSFER.SingleDcData localSingleDcData = new APP_REPORT_TRANSFER.SingleDcData();
    localSingleDcData.dcid.set(paramInt);
    if ((paramList1 != null) && (!paramList1.isEmpty())) {
      localSingleDcData.report_data.addAll(paramList1);
    }
    if ((paramList2 != null) && (!paramList2.isEmpty())) {
      localSingleDcData.extinfo.addAll(paramList2);
    }
    return localSingleDcData;
  }
  
  public static APP_REPORT_TRANSFER.StDataReportReq a(List<APP_REPORT_TRANSFER.SingleDcData> paramList)
  {
    APP_REPORT_TRANSFER.StDataReportReq localStDataReportReq = new APP_REPORT_TRANSFER.StDataReportReq();
    localStDataReportReq.dcdata.addAll(paramList);
    return localStDataReportReq;
  }
  
  public static REPORT.SingleDcData a(int paramInt, String paramString, List<COMM.Entry> paramList1, List<COMM.Entry> paramList2)
  {
    REPORT.SingleDcData localSingleDcData = new REPORT.SingleDcData();
    localSingleDcData.dcid.set(paramInt);
    localSingleDcData.type.set(paramString);
    if ((paramList1 != null) && (!paramList1.isEmpty())) {
      localSingleDcData.report_data.addAll(paramList1);
    }
    if ((paramList2 != null) && (!paramList2.isEmpty())) {
      localSingleDcData.extinfo.addAll(paramList2);
    }
    return localSingleDcData;
  }
  
  public static REPORT.StDcReportReq a(List<REPORT.SingleDcData> paramList)
  {
    REPORT.StDcReportReq localStDcReportReq = new REPORT.StDcReportReq();
    localStDcReportReq.dcdata.addAll(paramList);
    return localStDcReportReq;
  }
  
  public static REPORT.StThirdDcReportReq a(List<REPORT.SingleDcData> paramList)
  {
    REPORT.StThirdDcReportReq localStThirdDcReportReq = new REPORT.StThirdDcReportReq();
    if (paramList != null) {
      localStThirdDcReportReq.dcdata.addAll(paramList);
    }
    return localStThirdDcReportReq;
  }
  
  public static MiniAppInfo a()
  {
    return jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  }
  
  public static String a()
  {
    String str = bgld.a(AppLoaderFactory.g().getMiniAppEnv().getContext());
    if (str == null) {
      return "unknown";
    }
    return str.toLowerCase();
  }
  
  public static String a(MiniAppInfo paramMiniAppInfo)
  {
    return (String)jdField_a_of_type_JavaUtilMap.get(c(paramMiniAppInfo));
  }
  
  public static List<COMM.Entry> a()
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { a("source_app", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId()), a("source_version", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion()), a("source_uin_platform", QUAUtil.getLoginType()), a("connect_openid", bgte.a().c()), a("connect_type", String.valueOf(bgte.a().a())) }));
  }
  
  public static List<COMM.Entry> a(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramMiniAppInfo != null)
    {
      COMM.Entry localEntry1 = a("launchid", paramString12);
      COMM.Entry localEntry2 = a("appid", paramMiniAppInfo.appId);
      COMM.Entry localEntry3 = a("app_version", String.valueOf(paramMiniAppInfo.version));
      COMM.Entry localEntry4 = a("app_classification", null);
      COMM.Entry localEntry5 = a("app_tag", "");
      if (!EnvUtils.isPkgDownloaded(paramMiniAppInfo)) {
        break label511;
      }
      paramString12 = "1";
      COMM.Entry localEntry6 = a("isPkgDownloaed", paramString12);
      if (!EnvUtils.isX5Enabled(paramMiniAppInfo)) {
        break label519;
      }
      paramString12 = "1";
      label104:
      localArrayList.addAll(Arrays.asList(new COMM.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, localEntry6, a("isX5Enabled", paramString12), a("app_status", String.valueOf(paramMiniAppInfo.verType)) }));
      if (!TextUtils.isEmpty(paramMiniAppInfo.via)) {
        localArrayList.add(a("via", paramMiniAppInfo.via));
      }
    }
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.baseLibInfo != null)) {
      localArrayList.add(a("app_js_version", paramMiniAppInfo.baseLibInfo.baseLibVersion));
    }
    paramString1 = a("path", paramString1);
    if (QUAUtil.isQQMainApp()) {
      if (paramString2 == null) {}
    }
    for (;;)
    {
      localArrayList.addAll(Arrays.asList(new COMM.Entry[] { paramString1, a("refer", paramString2), a("actiontype", String.valueOf(paramString3)), a("sub_actiontype", String.valueOf(paramString4)), a("reserves_action", String.valueOf(paramString5)), a("reserves2", String.valueOf(paramString6)), a("reserves3", String.valueOf(paramString7)), a("reserves4", String.valueOf(paramString8)), a("reserves5", String.valueOf(paramString9)), a("reserves6", String.valueOf(paramString10)), a("app_type", String.valueOf(paramString11)), a("sdk_version", QUAUtil.getQUA()) }));
      if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null) && (!TextUtils.isEmpty(paramMiniAppInfo.launchParam.reportData))) {
        localArrayList.addAll(a(paramMiniAppInfo.launchParam.reportData));
      }
      if ((paramMiniAppInfo != null) && (paramMiniAppInfo.reportData != null) && (!TextUtils.isEmpty(paramMiniAppInfo.reportData))) {
        localArrayList.addAll(a(paramMiniAppInfo.reportData));
      }
      return localArrayList;
      label511:
      paramString12 = "0";
      break;
      label519:
      paramString12 = "0";
      break label104;
      paramString2 = "";
      continue;
      if (paramString2 != null) {
        paramString2 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName() + "_" + paramString2;
      } else {
        paramString2 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName() + "_1001";
      }
    }
  }
  
  public static List<COMM.Entry> a(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15)
  {
    COMM.Entry localEntry1 = a("uid", bgte.a().a());
    COMM.Entry localEntry2 = a("appid", c(paramMiniAppInfo));
    paramString10 = a("launchid", paramString10);
    label62:
    COMM.Entry localEntry3;
    label75:
    COMM.Entry localEntry4;
    label111:
    COMM.Entry localEntry5;
    COMM.Entry localEntry6;
    COMM.Entry localEntry7;
    label147:
    label206:
    COMM.Entry localEntry8;
    COMM.Entry localEntry9;
    COMM.Entry localEntry10;
    if (paramString2 != null)
    {
      paramString2 = a("event", paramString2);
      paramString9 = a("timestamp", paramString9);
      if (paramString1 == null) {
        break label593;
      }
      localEntry3 = a("page", paramString1);
      if (paramString3 == null) {
        break label600;
      }
      paramString3 = a("attachinfo", paramString3);
      localEntry4 = a("appversion", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion());
      if (paramMiniAppInfo == null) {
        break label607;
      }
      paramString1 = paramMiniAppInfo.version;
      localEntry5 = a("miniapp_version", paramString1);
      localEntry6 = a("qua", QUAUtil.getPlatformQUA());
      localEntry7 = a("sdk_version", QUAUtil.getQUA());
      if (paramString4 == null) {
        break label614;
      }
      paramString4 = a("cmd", paramString4);
      paramString5 = a("retcode", paramString5);
      paramString7 = a("time_cost", paramString7);
      paramString8 = a("third_url", paramString8);
      if ((paramMiniAppInfo == null) || (paramMiniAppInfo.baseLibInfo == null)) {
        break label622;
      }
      paramString1 = paramMiniAppInfo.baseLibInfo.baseLibVersion;
      paramString1 = a("baselib_version", paramString1);
      localEntry8 = a("x5_version", String.valueOf(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getTbsVersion()));
      localEntry9 = a("deviceinfo", c());
      paramString6 = a("app_type", paramString6);
      localEntry10 = a("network_type", a());
      if ((paramMiniAppInfo == null) || (paramMiniAppInfo.launchParam == null)) {
        break label629;
      }
    }
    label593:
    label600:
    label607:
    label614:
    label622:
    label629:
    for (paramMiniAppInfo = String.valueOf(paramMiniAppInfo.launchParam.scene);; paramMiniAppInfo = "")
    {
      return new ArrayList(Arrays.asList(new COMM.Entry[] { localEntry1, localEntry2, paramString10, paramString2, paramString9, localEntry3, paramString3, localEntry4, localEntry5, localEntry6, localEntry7, paramString4, paramString5, paramString7, paramString8, paramString1, localEntry8, localEntry9, paramString6, localEntry10, a("scene", paramMiniAppInfo), a("source_app", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId()), a("source_version", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion()), a("source_uin_platform", QUAUtil.getLoginType()), a("connect_openid", bgte.a().c()), a("connect_type", String.valueOf(bgte.a().a())), a("reverse1", paramString11), a("reverse2", paramString12), a("reverse3", paramString13), a("reverse4", paramString14), a("render_mode", paramString15), a("busiType", jdField_a_of_type_JavaLangString) }));
      paramString2 = "";
      break;
      paramString1 = "";
      break label62;
      paramString3 = "";
      break label75;
      paramString1 = "";
      break label111;
      paramString4 = "";
      break label147;
      paramString1 = "";
      break label206;
    }
  }
  
  public static List<COMM.Entry> a(String paramString)
  {
    Object localObject = a(paramString);
    paramString = new ArrayList();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramString.add(a((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    return paramString;
  }
  
  public static List<COMM.Entry> a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(new COMM.Entry[] { a("actiontype", String.valueOf(paramString1)), a("sub_actiontype", String.valueOf(paramString2)), a("reserves_action", String.valueOf(paramString3)), a("reserves2", String.valueOf(paramString4)), a("reserves3", String.valueOf(paramString5)), a("reserves4", String.valueOf(paramString6)), a("reserves5", String.valueOf(paramString7)) }));
    return localArrayList;
  }
  
  private static Map<String, String> a(String paramString)
  {
    int i = 0;
    String str1 = null;
    localObject1 = null;
    Object localObject2 = null;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = str1;
      try
      {
        String[] arrayOfString = paramString.split("&");
        localObject1 = str1;
        int j = arrayOfString.length;
        for (paramString = (String)localObject2;; paramString = (String)localObject2)
        {
          localObject1 = paramString;
          if (i >= j) {
            break;
          }
          String str2 = arrayOfString[i];
          localObject1 = paramString;
          int k = str2.indexOf("=");
          localObject2 = paramString;
          if (k > 0)
          {
            localObject2 = paramString;
            localObject1 = paramString;
            if (k < str2.length() - 1)
            {
              localObject1 = paramString;
              str1 = URLDecoder.decode(str2.substring(0, k), "UTF-8");
              localObject1 = paramString;
              str2 = URLDecoder.decode(str2.substring(k + 1), "UTF-8");
              localObject2 = paramString;
              if (paramString == null)
              {
                localObject1 = paramString;
                localObject2 = new HashMap();
              }
              localObject1 = localObject2;
              ((Map)localObject2).put(str1, str2);
            }
          }
          i += 1;
        }
        return localObject1;
      }
      catch (Exception paramString)
      {
        QMLog.e("MiniProgramReportHelper", " parse reportData error.", paramString);
      }
    }
  }
  
  public static void a(int paramInt)
  {
    if ((paramInt == 605) || (paramInt == 1)) {
      jdField_a_of_type_JavaUtilMap.put("0000000000", "0");
    }
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo)
  {
    String str1 = c(paramMiniAppInfo);
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = String.valueOf(System.currentTimeMillis());
      jdField_a_of_type_JavaUtilMap.put(str1, str2);
      QMLog.i("MiniProgramReportHelper", "[mini] assignAppLaunchId [appId= " + str1 + "] [launchId=" + str2 + "]");
    }
    jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
  }
  
  private static String b()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    if ((str2 != null) && (str1 != null) && (str2.toLowerCase().startsWith(str1.toLowerCase()))) {
      return str2;
    }
    return str1 + " " + str2;
  }
  
  public static String b(MiniAppInfo paramMiniAppInfo)
  {
    return (String)jdField_b_of_type_JavaUtilMap.get(c(paramMiniAppInfo));
  }
  
  public static List<COMM.Entry> b()
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { a("uin", String.valueOf(bgte.a().a())), a("touin", ""), a("timestamp", String.valueOf(System.currentTimeMillis())), a("qqversion", QUAUtil.getPlatformQUA()), a("imei", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getImei()), a("idfa", ""), a("idfv", ""), a("android_id", Settings.Secure.getString(AppLoaderFactory.g().getMiniAppEnv().getContext().getContentResolver(), "android_id")) }));
  }
  
  private static String c()
  {
    if (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
      return jdField_b_of_type_JavaLangString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("a=").append(Build.VERSION.SDK_INT).append("&mem=").append(a()).append("&mo=").append(b());
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    return jdField_b_of_type_JavaLangString;
  }
  
  private static String c(MiniAppInfo paramMiniAppInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMiniAppInfo != null)
    {
      localObject1 = localObject2;
      if (paramMiniAppInfo.launchParam != null) {
        localObject1 = paramMiniAppInfo.launchParam.miniAppId;
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (paramMiniAppInfo != null) {
        localObject2 = paramMiniAppInfo.appId;
      }
    }
    paramMiniAppInfo = (MiniAppInfo)localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      paramMiniAppInfo = "0000000000";
    }
    return paramMiniAppInfo;
  }
  
  public static List<COMM.Entry> c()
  {
    ArrayList localArrayList = new ArrayList(Arrays.asList(new COMM.Entry[] { a("device_platform", "Android"), a("device_maker", Build.MANUFACTURER), a("device_model", Build.MODEL), a("device_version", Build.VERSION.RELEASE), a("network_type", a()), a("network_gateway_ip", ""), a("network_ssid", bgld.b(AppLoaderFactory.g().getMiniAppEnv().getContext())) }));
    Object localObject = bgkn.a();
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\*");
      if (localObject.length == 2) {
        localArrayList.addAll(Arrays.asList(new COMM.Entry[] { a("gps_x", localObject[0]), a("gps_y", localObject[1]) }));
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgxz
 * JD-Core Version:    0.7.0.1
 */