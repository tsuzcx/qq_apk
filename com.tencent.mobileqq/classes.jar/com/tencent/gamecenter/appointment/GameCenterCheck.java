package com.tencent.gamecenter.appointment;

import acig;
import acik;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import avmc;
import bcuy;
import bhnv;
import bkad;
import bkag;
import bnyy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    PackageManager localPackageManager = BaseApplicationImpl.getContext().getPackageManager();
    int i = 0;
    Object localObject1 = null;
    if (i < j)
    {
      if (TextUtils.isEmpty(paramArrayOfString[i])) {}
      DownloadInfo localDownloadInfo;
      label274:
      label293:
      for (;;)
      {
        i += 1;
        break;
        Object localObject2 = acik.a(paramString + paramArrayOfString[i]);
        localDownloadInfo = new DownloadInfo();
        try
        {
          localObject2 = new JSONObject((String)localObject2);
          localDownloadInfo.c = ((JSONObject)localObject2).optString("appid");
          localDownloadInfo.j = ((JSONObject)localObject2).optString("myAppId");
          localDownloadInfo.k = ((JSONObject)localObject2).optString("apkId");
          localDownloadInfo.e = ((JSONObject)localObject2).optString("packageName");
          localDownloadInfo.b = ((JSONObject)localObject2).optInt("versionCode");
        }
        catch (JSONException localJSONException)
        {
          label171:
          localJSONException.printStackTrace();
        }
        try
        {
          localObject2 = localPackageManager.getPackageInfo(localDownloadInfo.e.trim(), 0);
          localObject1 = localObject2;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          break label171;
          if (!QLog.isColorLevel()) {
            break label274;
          }
          QLog.i("GameCenterCheck", 2, localDownloadInfo.c + " installed");
          acik.a(null, "426", "202142", localDownloadInfo.c, "42601", "1", "116");
        }
        if (localObject1 == null)
        {
          localArrayList.add(localDownloadInfo);
          if (!QLog.isColorLevel()) {
            break label293;
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
    bkad.c("GameCenterCheck", "checkGameCenter canAppointStart=" + bool);
    if (!bool) {
      return;
    }
    ThreadManager.excute(new GameCenterCheck.1(), 192, null, false);
  }
  
  public static void a(JSONArray paramJSONArray)
  {
    bkad.c("GameCenterCheck", "checkIfNeedToDownloadUpdateApp jsonArray=" + paramJSONArray);
    if ((paramJSONArray == null) || (paramJSONArray.length() < 1)) {}
    for (;;)
    {
      return;
      acik.a(new String[] { "APPOINTMENT_UPDATE_LIST" });
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject;
        try
        {
          localObject = paramJSONArray.optJSONObject(i);
          String str1 = ((JSONObject)localObject).optString("appid");
          int j = ((JSONObject)localObject).optInt("version_code");
          String str2 = ((JSONObject)localObject).optString("pkg_name");
          String str3 = ((JSONObject)localObject).optString("app_name");
          String str4 = ((JSONObject)localObject).optString("apk_channel", "10000144");
          String str5 = ((JSONObject)localObject).optString("apk_url");
          int k = ((JSONObject)localObject).optInt("min_version");
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str5)))
          {
            acik.a(null, "558", "206679", str1, "72702", "4", "430", new String[] { "", "1", "5" });
            if (!acik.a(str2, j, k))
            {
              bkad.c("GameCenterCheck", "checkIfNeedToDownloadUpdateApp cancel, appId=" + str1 + ",checkVersion is false");
            }
            else
            {
              localObject = new Bundle();
              ((Bundle)localObject).putString("packageName", str2);
              ((Bundle)localObject).putString("apkChannel", str4);
              ((Bundle)localObject).putString("appName", str3);
              ((Bundle)localObject).putString("apkUrl", str5);
              ((Bundle)localObject).putInt("versionCode", j);
              ((Bundle)localObject).putString("via", "auto_update");
              ((Bundle)localObject).putInt("from", 3);
              ((Bundle)localObject).putInt("flags", 63);
              avmc.a((Bundle)localObject, str1, false, 0);
            }
          }
        }
        catch (Exception localException)
        {
          QLog.e("GameCenterCheck", 2, "checkIfNeedToDownloadUpdateApp exception", localException);
        }
        bkad.c("GameCenterCheck", "checkIfNeedToDownloadUpdateApp params check fail，jsonTmp=" + ((JSONObject)localObject).toString());
        i += 1;
      }
    }
  }
  
  public static void a(String[] paramArrayOfString)
  {
    bkad.c("GameCenterCheck", "checkIfNeedToDownloadDelayApp:" + paramArrayOfString);
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {}
    for (;;)
    {
      return;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        acik.a(null, "558", "203713", paramArrayOfString[i], "55801", "4", "430");
        i += 1;
      }
      acik.a("DELAY_LIST", "");
      paramArrayOfString = a(paramArrayOfString, "DELAY_APPID_DETAIL_");
      if (paramArrayOfString.size() == 0)
      {
        bkad.c("GameCenterCheck", "checkIfNeedToDownloadDelayApp params.size=0:");
        return;
      }
      paramArrayOfString = paramArrayOfString.iterator();
      while (paramArrayOfString.hasNext())
      {
        Object localObject = (DownloadInfo)paramArrayOfString.next();
        localObject = acik.a("DELAY_APPID_DETAIL_" + ((DownloadInfo)localObject).c);
        try
        {
          acik.a((String)localObject, true, 2);
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
    if ((!TextUtils.isEmpty(acik.a("APPOINTMENT_LIST"))) || (!TextUtils.isEmpty(acik.a("APPOINTMENT_UPDATE_LIST"))) || (!TextUtils.isEmpty(acik.a("DELAY_LIST"))) || (!TextUtils.isEmpty(acik.a("APPOINTMENT_RES_LIST"))) || (!TextUtils.isEmpty(acik.a("APPOINTMENT_TGPA_LIST")))) {}
    for (boolean bool = true;; bool = false)
    {
      bkad.c("GameCenterCheck", "hasAppointTask hasTask=" + bool);
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
      bkad.c("GameCenterCheck", str1);
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
      acik.a(new String[] { "APPOINTMENT_TGPA_LIST" });
      int i = 0;
      while (i < paramJSONArray.length())
      {
        int j;
        int k;
        String str2;
        String str3;
        int m;
        String str4;
        String str5;
        try
        {
          localObject2 = paramJSONArray.optJSONObject(i);
          str1 = ((JSONObject)localObject2).optString("appid");
          j = ((JSONObject)localObject2).optInt("version_code");
          localObject1 = ((JSONObject)localObject2).optString("app_name");
          k = ((JSONObject)localObject2).optInt("package_type");
          str2 = ((JSONObject)localObject2).optString("package_name");
          str3 = ((JSONObject)localObject2).optString("package_src_url");
          m = ((JSONObject)localObject2).optInt("package_index");
          str4 = ((JSONObject)localObject2).optString("package_id");
          str5 = ((JSONObject)localObject2).optString("package_md5");
          if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
            break label576;
          }
          bkad.c("GameCenterCheck", "checkIfNeedToDownloadTGPA packageName=" + (String)localObject1 + ",resType=" + k + ",appId=" + str1 + ",resName=" + str2 + ",srcUrl=" + str3 + ",versionCode=" + j + ",versionName=" + str4 + ",resMD5=" + str5);
          if (((k == 0) && (!acik.e)) || ((k == 1) && (!acik.d)) || ((k == 4) && (!acik.d))) {
            break label605;
          }
          if (k == 1)
          {
            boolean bool = acik.a((String)localObject1, j);
            if (bool) {
              break label470;
            }
            bkad.c("GameCenterCheck", "checkIfNeedToDownloadTGPA cancel, checkVersion=" + bool);
          }
        }
        catch (Exception localException)
        {
          QLog.e("GameCenterCheck", 2, "checkIfNeedToDownloadTGPA exception", localException);
        }
        if (k == 4)
        {
          int n = acik.a((String)localObject1);
          if (n != -1)
          {
            bkad.c("GameCenterCheck", "checkIfNeedToDownloadTGPA cancel, localVersion=" + n);
            break label605;
          }
        }
        else
        {
          if ((k == 0) && (acik.a(0, localException, str2))) {
            break label605;
          }
        }
        label470:
        Object localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("from", 3);
        ((Bundle)localObject2).putString("packageName", (String)localObject1);
        ((Bundle)localObject2).putString("apkUrl", str3);
        ((Bundle)localObject2).putString("resName", str2);
        ((Bundle)localObject2).putInt("resIndex", m);
        ((Bundle)localObject2).putString("resVersionName", str4);
        ((Bundle)localObject2).putInt("versionCode", j);
        ((Bundle)localObject2).putString("resMD5", str5);
        ((Bundle)localObject2).putString("via", "auto_tgpa");
        avmc.a((Bundle)localObject2, localException, true, k);
        break label605;
        label576:
        bkad.c("GameCenterCheck", "checkIfNeedToDownloadTGPA params check fail，jsonTmp=" + ((JSONObject)localObject2).toString());
        label605:
        i += 1;
      }
    }
  }
  
  public static void b(String[] paramArrayOfString)
  {
    bkad.c("GameCenterCheck", "checkIfNeedToDownloadAppointApp:" + paramArrayOfString);
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {
      return;
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      acik.a(null, "558", "203701", paramArrayOfString[i], "55801", "4", "430");
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
        localObject3 = acik.a("APPOINT_APPID_DETAIL_" + paramArrayOfString[i]);
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
        acik.a("APPOINTMENT_LIST", (String)localObject2);
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
        bkad.c("GameCenterCheck", "checkIfNeedToDownloadAppointApp params.size=0:");
        return;
      }
      paramArrayOfString = new JSONArray();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DownloadInfo)((Iterator)localObject1).next();
        localObject3 = acik.a("APPOINT_APPID_DETAIL_" + ((DownloadInfo)localObject2).c);
        try
        {
          acik.a((String)localObject3, true, 1);
          acik.c(((DownloadInfo)localObject2).c, "APPOINTMENT_DOWNLOAD_LIST");
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
      bnyy.a().a(paramArrayOfString, null);
      return;
    }
  }
  
  public static boolean b()
  {
    if (bhnv.h(BaseApplicationImpl.getContext()))
    {
      PowerManager localPowerManager = (PowerManager)BaseApplicationImpl.getContext().getSystemService("power");
      if ((localPowerManager != null) && (!localPowerManager.isScreenOn()) && ((acig.a >= 20) || (acig.b))) {
        return true;
      }
    }
    acik.a(null, "426", "205572", "", "42601", "1", "116");
    return false;
  }
  
  public int a()
  {
    bkad.c("GameCenterCheck", "GameCenterCheck doStep");
    acik.a();
    if ((!acik.b) && (!acik.a) && (!acik.c) && (!acik.d) && (!acik.e))
    {
      bkad.b("GameCenterCheck", "GameCenterCheck switch is off");
      return super.a();
    }
    Long localLong3 = Long.valueOf(acik.a("APPOINTMENT_LASTGET_TIME"));
    Long localLong2 = Long.valueOf(acik.a("APPOINTMENT_LOAD_GAP"));
    Long localLong1 = localLong2;
    if (0L == localLong2.longValue()) {
      localLong1 = Long.valueOf(30L);
    }
    long l = NetConnInfoCenter.getServerTime();
    bkad.c("GameCenterCheck", "GameCenterCheck loadGap=" + localLong1 + ", lastTime:" + localLong3 + ",isAppointDownload=" + acik.b + ",isDelayDownload=" + acik.a + ",isUpdateDownload=" + acik.c + ",isResApkDownload=" + acik.d + ",isResDefDownload=" + acik.e);
    int i;
    if (l - localLong3.longValue() < localLong1.longValue())
    {
      i = 1;
      if (i == 0) {
        break label257;
      }
      a();
    }
    for (;;)
    {
      if (a()) {
        acig.a();
      }
      bkag.a();
      bnyy.a().a(false, -1L);
      return super.a();
      i = 0;
      break;
      label257:
      bkad.c("GameCenterCheck", "GameCenterCheck getPreDownloadList loadGap=" + localLong1);
      ((bcuy)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(12)).c();
    }
  }
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterCheck
 * JD-Core Version:    0.7.0.1
 */