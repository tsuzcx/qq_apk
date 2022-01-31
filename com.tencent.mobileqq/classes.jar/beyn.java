import NS_COMM.COMM.Entry;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportReq;
import NS_MINI_REPORT.REPORT.SingleDcData;
import NS_MINI_REPORT.REPORT.StDcReportReq;
import NS_MINI_REPORT.REPORT.StThirdDcReportReq;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class beyn
{
  private static MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private static final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static final Map<String, String> b = new HashMap();
  
  static
  {
    MiniAppInfo localMiniAppInfo = new MiniAppInfo();
    localMiniAppInfo.appId = "0000000000";
    jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = localMiniAppInfo;
    jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam.jdField_a_of_type_JavaLangString = "0000000000";
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
    String str = bekw.a(MiniAppEnv.g().getContext());
    if (str == null) {
      return "unknown";
    }
    return str.toLowerCase();
  }
  
  public static String a(MiniAppInfo paramMiniAppInfo)
  {
    return (String)jdField_a_of_type_JavaUtilMap.get(b(paramMiniAppInfo));
  }
  
  public static List<COMM.Entry> a()
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { a("source_app", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId()), a("source_version", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion()), a("source_uin_platform", bfgt.e()), a("connect_openid", beuc.a().c()), a("connect_type", String.valueOf(beuc.a().a())) }));
  }
  
  public static List<COMM.Entry> a(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramMiniAppInfo != null)
    {
      localArrayList.addAll(Arrays.asList(new COMM.Entry[] { a("launchid", paramString11), a("appid", paramMiniAppInfo.appId), a("app_version", String.valueOf(paramMiniAppInfo.version)), a("app_classification", null), a("app_tag", ""), a("app_status", String.valueOf(paramMiniAppInfo.verType)) }));
      if (!TextUtils.isEmpty(paramMiniAppInfo.via)) {
        localArrayList.add(a("via", paramMiniAppInfo.via));
      }
    }
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.baseLibInfo != null)) {
      localArrayList.add(a("app_js_version", paramMiniAppInfo.baseLibInfo.baseLibVersion));
    }
    paramString1 = a("path", paramString1);
    if (bfgt.a()) {
      if (paramString2 == null) {}
    }
    for (;;)
    {
      localArrayList.addAll(Arrays.asList(new COMM.Entry[] { paramString1, a("refer", paramString2), a("actiontype", String.valueOf(paramString3)), a("sub_actiontype", String.valueOf(paramString4)), a("reserves_action", String.valueOf(paramString5)), a("reserves2", String.valueOf(paramString6)), a("reserves3", String.valueOf(paramString7)), a("reserves4", String.valueOf(paramString8)), a("reserves5", String.valueOf(paramString9)), a("app_type", String.valueOf(paramString10)), a("sdk_version", bfgt.a()) }));
      if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null) && (paramMiniAppInfo.launchParam.jdField_a_of_type_JavaUtilMap != null) && (paramMiniAppInfo.launchParam.jdField_a_of_type_JavaUtilMap.size() > 0)) {
        localArrayList.addAll(a(paramMiniAppInfo.launchParam.jdField_a_of_type_JavaUtilMap));
      }
      if ((paramMiniAppInfo != null) && (paramMiniAppInfo.reportData != null) && (paramMiniAppInfo.reportData.size() > 0)) {
        localArrayList.addAll(a(paramMiniAppInfo.reportData));
      }
      return localArrayList;
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
    COMM.Entry localEntry1 = a("uid", beuc.a().a());
    COMM.Entry localEntry2 = a("appid", b(paramMiniAppInfo));
    paramString10 = a("launchid", paramString10);
    label60:
    COMM.Entry localEntry3;
    label73:
    COMM.Entry localEntry4;
    label109:
    COMM.Entry localEntry5;
    COMM.Entry localEntry6;
    COMM.Entry localEntry7;
    label145:
    label204:
    COMM.Entry localEntry8;
    if (paramString2 != null)
    {
      paramString2 = a("event", paramString2);
      paramString9 = a("timestamp", paramString9);
      if (paramString1 == null) {
        break label532;
      }
      localEntry3 = a("page", paramString1);
      if (paramString3 == null) {
        break label538;
      }
      paramString3 = a("attachinfo", paramString3);
      localEntry4 = a("appversion", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion());
      if (paramMiniAppInfo == null) {
        break label544;
      }
      paramString1 = paramMiniAppInfo.version;
      localEntry5 = a("miniapp_version", paramString1);
      localEntry6 = a("qua", bfgt.b());
      localEntry7 = a("sdk_version", bfgt.a());
      if (paramString4 == null) {
        break label550;
      }
      paramString4 = a("cmd", paramString4);
      paramString5 = a("retcode", paramString5);
      paramString7 = a("time_cost", paramString7);
      paramString8 = a("third_url", paramString8);
      if ((paramMiniAppInfo == null) || (paramMiniAppInfo.baseLibInfo == null)) {
        break label557;
      }
      paramString1 = paramMiniAppInfo.baseLibInfo.baseLibVersion;
      paramString1 = a("baselib_version", paramString1);
      paramString6 = a("app_type", paramString6);
      localEntry8 = a("network_type", a());
      if ((paramMiniAppInfo == null) || (paramMiniAppInfo.launchParam == null)) {
        break label563;
      }
    }
    label532:
    label538:
    label544:
    label550:
    label557:
    label563:
    for (paramMiniAppInfo = String.valueOf(paramMiniAppInfo.launchParam.jdField_a_of_type_Int);; paramMiniAppInfo = "")
    {
      return new ArrayList(Arrays.asList(new COMM.Entry[] { localEntry1, localEntry2, paramString10, paramString2, paramString9, localEntry3, paramString3, localEntry4, localEntry5, localEntry6, localEntry7, paramString4, paramString5, paramString7, paramString8, paramString1, paramString6, localEntry8, a("scene", paramMiniAppInfo), a("source_app", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId()), a("source_version", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion()), a("source_uin_platform", bfgt.e()), a("connect_openid", beuc.a().c()), a("connect_type", String.valueOf(beuc.a().a())), a("reverse1", paramString11), a("reverse2", paramString12), a("reverse3", paramString13), a("reverse4", paramString14), a("render_mode", paramString15) }));
      paramString2 = "";
      break;
      paramString1 = "";
      break label60;
      paramString3 = "";
      break label73;
      paramString1 = "";
      break label109;
      paramString4 = "";
      break label145;
      paramString1 = "";
      break label204;
    }
  }
  
  public static List<COMM.Entry> a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(new COMM.Entry[] { a("actiontype", String.valueOf(paramString1)), a("sub_actiontype", String.valueOf(paramString2)), a("reserves_action", String.valueOf(paramString3)), a("reserves2", String.valueOf(paramString4)), a("reserves3", String.valueOf(paramString5)), a("reserves4", String.valueOf(paramString6)), a("reserves5", String.valueOf(paramString7)) }));
    return localArrayList;
  }
  
  public static List<COMM.Entry> a(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localArrayList.add(a((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    return localArrayList;
  }
  
  public static void a(int paramInt)
  {
    if ((paramInt == 605) || (paramInt == 1)) {
      jdField_a_of_type_JavaUtilMap.put("0000000000", "0");
    }
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo)
  {
    String str1 = b(paramMiniAppInfo);
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = String.valueOf(System.currentTimeMillis());
      jdField_a_of_type_JavaUtilMap.put(str1, str2);
      besl.d("MiniProgramReportHelper", "[mini] assignAppLaunchId [appId= " + str1 + "] [launchId=" + str2);
    }
    jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
  }
  
  private static String b(MiniAppInfo paramMiniAppInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMiniAppInfo != null)
    {
      localObject1 = localObject2;
      if (paramMiniAppInfo.launchParam != null) {
        localObject1 = paramMiniAppInfo.launchParam.jdField_a_of_type_JavaLangString;
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
  
  public static List<COMM.Entry> b()
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { a("uin", String.valueOf(beuc.a().a())), a("touin", ""), a("timestamp", String.valueOf(System.currentTimeMillis())), a("qqversion", bfgt.b()), a("idfa", ""), a("idfv", ""), a("android_id", Settings.Secure.getString(MiniAppEnv.g().getContext().getContentResolver(), "android_id")) }));
  }
  
  public static List<COMM.Entry> c()
  {
    ArrayList localArrayList = new ArrayList(Arrays.asList(new COMM.Entry[] { a("device_platform", "Android"), a("device_maker", Build.MANUFACTURER), a("device_model", Build.MODEL), a("device_version", Build.VERSION.RELEASE), a("network_type", a()), a("network_gateway_ip", ""), a("network_ssid", bekw.b(MiniAppEnv.g().getContext())) }));
    if (0 != 0) {
      throw new NullPointerException();
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beyn
 * JD-Core Version:    0.7.0.1
 */