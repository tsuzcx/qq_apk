package com.tencent.gamecenter.appointment;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.PowerManager;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.WLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GameCenterCheck
  extends AsyncStep
{
  public final long a;
  
  public GameCenterCheck()
  {
    this.jdField_a_of_type_Long = 30L;
  }
  
  public static List<DownloadInfo> a(String[] paramArrayOfString, String paramString)
  {
    int j = paramArrayOfString.length;
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = MobileQQ.sMobileQQ;
    PackageManager localPackageManager = MobileQQ.getContext().getPackageManager();
    int i = 0;
    localObject1 = null;
    if (i < j)
    {
      if (TextUtils.isEmpty(paramArrayOfString[i])) {}
      DownloadInfo localDownloadInfo;
      label279:
      label298:
      for (;;)
      {
        i += 1;
        break;
        Object localObject2 = GameCenterSpUtils.a(paramString + paramArrayOfString[i]);
        localDownloadInfo = new DownloadInfo();
        try
        {
          localObject2 = new JSONObject((String)localObject2);
          localDownloadInfo.c = ((JSONObject)localObject2).optString("appid");
          localDownloadInfo.j = ((JSONObject)localObject2).optString("myAppId");
          localDownloadInfo.k = ((JSONObject)localObject2).optString("apkId");
          localDownloadInfo.jdField_e_of_type_JavaLangString = ((JSONObject)localObject2).optString("packageName");
          localDownloadInfo.b = ((JSONObject)localObject2).optInt("versionCode");
        }
        catch (JSONException localJSONException)
        {
          label176:
          localJSONException.printStackTrace();
        }
        try
        {
          localObject2 = localPackageManager.getPackageInfo(localDownloadInfo.jdField_e_of_type_JavaLangString.trim(), 0);
          localObject1 = localObject2;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          break label176;
          if (!QLog.isColorLevel()) {
            break label279;
          }
          QLog.i("GameCenterCheck", 2, localDownloadInfo.c + " installed");
          GameCenterUtils.a(null, "426", "202142", localDownloadInfo.c, "42601", "1", "116");
        }
        if (localObject1 == null)
        {
          localArrayList.add(localDownloadInfo);
          if (!QLog.isColorLevel()) {
            break label298;
          }
          QLog.i("GameCenterCheck", 2, localDownloadInfo.c + " no installed");
          continue;
        }
      }
    }
    return localArrayList;
  }
  
  public static void a()
  {
    boolean bool = b();
    WLog.c("GameCenterCheck", "checkGameCenter canAppointStart=" + bool);
    if (!bool) {
      return;
    }
    ThreadManager.excute(new GameCenterCheck.1(), 192, null, false);
  }
  
  private static void a(String paramString, int paramInt)
  {
    WLog.c("GameCenterCheck", "sstartDownload paramsJson=" + paramString + ",from=" + paramInt + ",isWifi=" + AppNetConnInfo.isWifiConn());
    try
    {
      paramString = new WadlParams(paramString);
      paramString.b = 2;
      paramString.d = paramInt;
      WadlProxyServiceUtil.a().b(paramString);
      if (2 == paramInt)
      {
        GameCenterUtils.a(null, "427", "202139", paramString.jdField_a_of_type_JavaLangString, "42701", "1", "117");
        return;
      }
      if (1 == paramInt)
      {
        GameCenterUtils.a(null, "426", "202140", paramString.jdField_a_of_type_JavaLangString, "42601", "1", "116");
        return;
      }
    }
    catch (Exception paramString)
    {
      WLog.a("GameCenterCheck", "startDownload exception", paramString);
    }
  }
  
  public static void a(JSONArray paramJSONArray)
  {
    WLog.c("GameCenterCheck", "checkIfNeedToDownloadUpdateApp jsonArray=" + paramJSONArray);
    if ((paramJSONArray == null) || (paramJSONArray.length() < 1)) {}
    for (;;)
    {
      return;
      GameCenterSpUtils.a(new String[] { "APPOINTMENT_UPDATE_LIST" });
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject;
        try
        {
          localObject = paramJSONArray.optJSONObject(i);
          String str4 = ((JSONObject)localObject).optString("appid");
          int j = ((JSONObject)localObject).optInt("version_code");
          String str5 = ((JSONObject)localObject).optString("pkg_name");
          String str1 = ((JSONObject)localObject).optString("app_name");
          String str2 = ((JSONObject)localObject).optString("apk_channel", "10000144");
          String str3 = ((JSONObject)localObject).optString("apk_url");
          int k = ((JSONObject)localObject).optInt("min_version");
          if ((!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(str5)) && (!TextUtils.isEmpty(str3)))
          {
            GameCenterUtils.a(null, "558", "206679", str4, "72702", "4", "430", new String[] { "", "1", "5" });
            if (!GameCenterUtils.a(str5, j, k))
            {
              GameCenterUtils.a(null, "558", "206679", str4, "72703", "4", "430", new String[] { "", "1", "5" });
              WLog.c("GameCenterCheck", "checkIfNeedToDownloadUpdateApp cancel, appId=" + str4 + ",checkVersion is false");
            }
            else
            {
              localObject = new WadlParams(str4, str5);
              ((WadlParams)localObject).b = 2;
              ((WadlParams)localObject).jdField_a_of_type_Boolean = false;
              ((WadlParams)localObject).c = str2;
              ((WadlParams)localObject).j = str1;
              ((WadlParams)localObject).jdField_e_of_type_JavaLangString = str3;
              ((WadlParams)localObject).jdField_e_of_type_Int = j;
              ((WadlParams)localObject).l = "auto_update";
              ((WadlParams)localObject).d = 3;
              ((WadlParams)localObject).b(56);
              WadlProxyServiceUtil.a().b((WadlParams)localObject);
            }
          }
        }
        catch (Exception localException)
        {
          QLog.e("GameCenterCheck", 2, "checkIfNeedToDownloadUpdateApp exception", localException);
        }
        WLog.c("GameCenterCheck", "checkIfNeedToDownloadUpdateApp params check fail，jsonTmp=" + ((JSONObject)localObject).toString());
        i += 1;
      }
    }
  }
  
  public static void a(String[] paramArrayOfString)
  {
    WLog.c("GameCenterCheck", "checkIfNeedToDownloadDelayApp:" + paramArrayOfString);
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {}
    for (;;)
    {
      return;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        GameCenterUtils.a(null, "558", "203713", paramArrayOfString[i], "55801", "4", "430");
        i += 1;
      }
      GameCenterSpUtils.a("DELAY_LIST", "");
      paramArrayOfString = a(paramArrayOfString, "DELAY_APPID_DETAIL_");
      if (paramArrayOfString.size() == 0)
      {
        WLog.c("GameCenterCheck", "checkIfNeedToDownloadDelayApp params.size=0:");
        return;
      }
      paramArrayOfString = paramArrayOfString.iterator();
      while (paramArrayOfString.hasNext())
      {
        Object localObject = (DownloadInfo)paramArrayOfString.next();
        localObject = GameCenterSpUtils.a("DELAY_APPID_DETAIL_" + ((DownloadInfo)localObject).c);
        try
        {
          a((String)localObject, 2);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public static boolean a()
  {
    if ((!TextUtils.isEmpty(GameCenterSpUtils.a("APPOINTMENT_LIST"))) || (!TextUtils.isEmpty(GameCenterSpUtils.a("APPOINTMENT_UPDATE_LIST"))) || (!TextUtils.isEmpty(GameCenterSpUtils.a("DELAY_LIST"))) || (!TextUtils.isEmpty(GameCenterSpUtils.a("APPOINTMENT_RES_LIST"))) || (!TextUtils.isEmpty(GameCenterSpUtils.a("APPOINTMENT_TGPA_LIST")))) {}
    for (boolean bool = true;; bool = false)
    {
      WLog.c("GameCenterCheck", "hasAppointTask hasTask=" + bool);
      return bool;
    }
  }
  
  public static void b(JSONArray paramJSONArray)
  {
    Object localObject1 = new StringBuilder().append("checkIfNeedToDownloadTGPA jsonArray=");
    String str1;
    if (paramJSONArray != null)
    {
      str1 = paramJSONArray.toString();
      WLog.c("GameCenterCheck", str1);
      if ((paramJSONArray != null) && (paramJSONArray.length() >= 1)) {
        break label61;
      }
    }
    for (;;)
    {
      return;
      str1 = "empty";
      break;
      label61:
      GameCenterSpUtils.a(new String[] { "APPOINTMENT_TGPA_LIST" });
      int i = 0;
      while (i < paramJSONArray.length())
      {
        String str4;
        int j;
        String str5;
        int k;
        int m;
        String str2;
        String str3;
        try
        {
          localObject2 = paramJSONArray.optJSONObject(i);
          str4 = ((JSONObject)localObject2).optString("appid");
          j = ((JSONObject)localObject2).optInt("version_code");
          str5 = ((JSONObject)localObject2).optString("app_name");
          k = ((JSONObject)localObject2).optInt("package_type");
          str1 = ((JSONObject)localObject2).optString("package_name");
          localObject1 = ((JSONObject)localObject2).optString("package_src_url");
          m = ((JSONObject)localObject2).optInt("package_index");
          str2 = ((JSONObject)localObject2).optString("package_id");
          str3 = ((JSONObject)localObject2).optString("package_md5");
          if ((TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str5)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
            break label579;
          }
          WLog.c("GameCenterCheck", "checkIfNeedToDownloadTGPA packageName=" + str5 + ",resType=" + k + ",appId=" + str4 + ",resName=" + str1 + ",srcUrl=" + (String)localObject1 + ",versionCode=" + j + ",versionName=" + str2 + ",resMD5=" + str3);
          if (((k == 0) && (!GameCenterUtils.e)) || ((k == 1) && (!GameCenterUtils.d)) || ((k == 4) && (!GameCenterUtils.d))) {
            break label608;
          }
          if (k == 1)
          {
            boolean bool = GameCenterUtils.a(str5, j);
            if (bool) {
              break label470;
            }
            WLog.c("GameCenterCheck", "checkIfNeedToDownloadTGPA cancel, checkVersion=" + bool);
          }
        }
        catch (Exception localException)
        {
          QLog.e("GameCenterCheck", 2, "checkIfNeedToDownloadTGPA exception", localException);
        }
        if (k == 4)
        {
          int n = GameCenterUtils.a(str5);
          if (n != -1)
          {
            WLog.c("GameCenterCheck", "checkIfNeedToDownloadTGPA cancel, localVersion=" + n);
            break label608;
          }
        }
        else
        {
          if ((k == 0) && (GameCenterUtils.a(0, str4, localException))) {
            break label608;
          }
        }
        label470:
        Object localObject2 = new WadlParams(str4, str5);
        ((WadlParams)localObject2).a(2);
        ((WadlParams)localObject2).a(4);
        ((WadlParams)localObject2).b = 2;
        ((WadlParams)localObject2).jdField_a_of_type_Boolean = true;
        ((WadlParams)localObject2).jdField_g_of_type_Int = k;
        ((WadlParams)localObject2).d = 3;
        ((WadlParams)localObject2).jdField_e_of_type_JavaLangString = ((String)localObject1);
        ((WadlParams)localObject2).h = localException;
        ((WadlParams)localObject2).f = m;
        ((WadlParams)localObject2).jdField_g_of_type_JavaLangString = str2;
        ((WadlParams)localObject2).jdField_e_of_type_Int = j;
        ((WadlParams)localObject2).i = str3;
        ((WadlParams)localObject2).l = "auto_tgpa";
        WadlProxyServiceUtil.a().b((WadlParams)localObject2);
        break label608;
        label579:
        WLog.c("GameCenterCheck", "checkIfNeedToDownloadTGPA params check fail，jsonTmp=" + ((JSONObject)localObject2).toString());
        label608:
        i += 1;
      }
    }
  }
  
  public static void b(String[] paramArrayOfString)
  {
    WLog.c("GameCenterCheck", "checkIfNeedToDownloadAppointApp:" + paramArrayOfString);
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {
      return;
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      GameCenterUtils.a(null, "558", "203701", paramArrayOfString[i], "55801", "4", "430");
      i += 1;
    }
    j = 0;
    Object localObject2 = "";
    Object localObject1 = "";
    i = 0;
    for (;;)
    {
      Object localObject3;
      if (i < paramArrayOfString.length) {
        localObject3 = GameCenterSpUtils.a("APPOINT_APPID_DETAIL_" + paramArrayOfString[i]);
      }
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        long l1 = ((JSONObject)localObject3).optLong("downloadStartTime", 0L);
        long l2 = ((JSONObject)localObject3).optLong("downloadEndTime", 0L);
        long l3 = NetConnInfoCenter.getServerTime();
        if ((l1 <= l3) && (l3 <= l2))
        {
          localObject3 = (String)localObject1 + paramArrayOfString[i] + "|";
          j = 1;
          localObject1 = localObject3;
        }
        else
        {
          localObject3 = (String)localObject2 + paramArrayOfString[i] + "|";
          localObject2 = localObject3;
        }
      }
      catch (Exception localException2)
      {
        i += 1;
      }
      if (j != 0) {
        GameCenterSpUtils.a("APPOINTMENT_LIST", (String)localObject2);
      }
      paramArrayOfString = ((String)localObject1).split("\\|");
      if (paramArrayOfString.length == 0) {
        break;
      }
      i = 0;
      while (i < paramArrayOfString.length)
      {
        if (TextUtils.isEmpty(paramArrayOfString[i])) {}
        i += 1;
      }
      localObject1 = a(paramArrayOfString, "APPOINT_APPID_DETAIL_");
      if (((List)localObject1).size() < 1)
      {
        WLog.c("GameCenterCheck", "checkIfNeedToDownloadAppointApp params.size=0:");
        return;
      }
      paramArrayOfString = new JSONArray();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DownloadInfo)((Iterator)localObject1).next();
        localObject3 = GameCenterSpUtils.a("APPOINT_APPID_DETAIL_" + ((DownloadInfo)localObject2).c);
        try
        {
          a((String)localObject3, 1);
          GameCenterUtils.b(((DownloadInfo)localObject2).c, "APPOINTMENT_DOWNLOAD_LIST");
          paramArrayOfString.put(((DownloadInfo)localObject2).c);
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
      }
      if (paramArrayOfString.length() <= 0) {
        break;
      }
      ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).reportDownloadStart(paramArrayOfString, null);
      return;
    }
  }
  
  public static boolean b()
  {
    Object localObject = MobileQQ.sMobileQQ;
    if (NetworkUtil.h(MobileQQ.getContext()))
    {
      localObject = MobileQQ.sMobileQQ;
      localObject = (PowerManager)MobileQQ.getContext().getSystemService("power");
      if ((localObject != null) && (!((PowerManager)localObject).isScreenOn()) && ((GameCenterBroadcastReceiver.a >= 20) || (GameCenterBroadcastReceiver.b))) {
        return true;
      }
    }
    return false;
  }
  
  public int a()
  {
    WLog.c("GameCenterCheck", "GameCenterCheck doStep");
    GameCenterUtils.a();
    if ((!GameCenterUtils.b) && (!GameCenterUtils.jdField_a_of_type_Boolean) && (!GameCenterUtils.c) && (!GameCenterUtils.d) && (!GameCenterUtils.e))
    {
      WLog.b("GameCenterCheck", "GameCenterCheck switch is off");
      return super.a();
    }
    Long localLong3 = Long.valueOf(GameCenterSpUtils.a("APPOINTMENT_LASTGET_TIME"));
    Long localLong2 = Long.valueOf(GameCenterSpUtils.a("APPOINTMENT_LOAD_GAP"));
    Long localLong1 = localLong2;
    if (0L == localLong2.longValue()) {
      localLong1 = Long.valueOf(30L);
    }
    long l = NetConnInfoCenter.getServerTime();
    WLog.c("GameCenterCheck", "GameCenterCheck loadGap=" + localLong1 + ", lastTime:" + localLong3 + ",isAppointDownload=" + GameCenterUtils.b + ",isDelayDownload=" + GameCenterUtils.jdField_a_of_type_Boolean + ",isUpdateDownload=" + GameCenterUtils.c + ",isResApkDownload=" + GameCenterUtils.d + ",isResDefDownload=" + GameCenterUtils.e);
    int i;
    if (l - localLong3.longValue() < localLong1.longValue())
    {
      i = 1;
      if (i == 0) {
        break label268;
      }
      a();
    }
    for (;;)
    {
      if (a()) {
        GameCenterBroadcastReceiver.a();
      }
      QRoute.api(IQQGameConfigService.class);
      ((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).checkConfigUpdate(false, -1L);
      return super.a();
      i = 0;
      break;
      label268:
      WLog.c("GameCenterCheck", "GameCenterCheck getPreDownloadList loadGap=" + localLong1);
      ((GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getManager(QQManagerFactory.GAMECENTER_MANAGER)).c();
    }
  }
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterCheck
 * JD-Core Version:    0.7.0.1
 */