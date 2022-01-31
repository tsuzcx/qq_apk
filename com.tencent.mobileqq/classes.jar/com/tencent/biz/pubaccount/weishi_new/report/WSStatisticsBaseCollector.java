package com.tencent.biz.pubaccount.weishi_new.report;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import bbdh;
import bdjp;
import bgyi;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import snf;
import vzw;

public class WSStatisticsBaseCollector
{
  private static final String KEY_SESSION_ID = "key_session_id";
  private static final String KEY_SESSION_STAMP = "key_session_stamp";
  private static String mExtendInfo;
  private static String mOperationId;
  private static String mPushId;
  private static String mSceneFrom;
  private static String mSessionId;
  private static String mSessionStamp;
  private static String mSopName;
  private static String mTestId;
  
  public static Map<String, String> getBaseParams()
  {
    HashMap localHashMap = new HashMap(38);
    localHashMap.put("qimei", UserAction.getQIMEI());
    localHashMap.put("imsi", bbdh.b());
    localHashMap.put("imei", bdjp.c());
    localHashMap.put("mac", bdjp.a());
    localHashMap.put("dev_brand", GlobalUtil.getInstance().getBrand());
    localHashMap.put("dev_model", Build.MODEL);
    localHashMap.put("os", "Android");
    localHashMap.put("screen_res", bdjp.e());
    localHashMap.put("operating_system_version", Build.VERSION.RELEASE);
    localHashMap.put("ui_version", ROMUtil.getRomName() + ROMUtil.getRomVersion());
    localHashMap.put("app_ver", DeviceUtils.getVersionName(BaseApplicationImpl.getContext()));
    localHashMap.put("wifiBssid", snf.e());
    localHashMap.put("push_id", getPushId());
    localHashMap.put("ip", DeviceUtils.getLocalIpAddress());
    localHashMap.put("session_id", getSessionId());
    localHashMap.put("session_stamp", getSessionStamp());
    localHashMap.put("sop_name", getSopName());
    localHashMap.put("qua", bgyi.a());
    localHashMap.put("android_id", bbdh.f());
    localHashMap.put("qq", snf.a().getAccount());
    if (vzw.a(BaseApplicationImpl.getApplication())) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("if_install_weishi", str);
      localHashMap.put("person_id", "");
      localHashMap.put("time", String.valueOf(System.currentTimeMillis()));
      localHashMap.put("network_type", snf.d());
      localHashMap.put("extended_fields", getExtendInfo());
      localHashMap.put("scenes_from", getSceneFrom());
      localHashMap.put("operation_id", getOperationId());
      localHashMap.put("test_id", getTestId());
      return localHashMap;
    }
  }
  
  private static String getExtendInfo()
  {
    return mExtendInfo;
  }
  
  private static String getOperationId()
  {
    return mOperationId;
  }
  
  public static String getPushId()
  {
    return mPushId;
  }
  
  private static String getSceneFrom()
  {
    return mSceneFrom;
  }
  
  private static String getSessionId()
  {
    if (TextUtils.isEmpty(mSessionId)) {
      return LocalMultiProcConfig.getString("weishi_usergrowth", "key_session_id", "");
    }
    return mSessionId;
  }
  
  private static String getSessionStamp()
  {
    if (TextUtils.isEmpty(mSessionStamp)) {
      return LocalMultiProcConfig.getString("weishi_usergrowth", "key_session_stamp", "");
    }
    return mSessionStamp;
  }
  
  private static String getSopName()
  {
    return mSopName;
  }
  
  private static String getTestId()
  {
    return mTestId;
  }
  
  public static void setExtendInfo(String paramString)
  {
    mExtendInfo = paramString;
  }
  
  public static void setOperationId(String paramString)
  {
    mOperationId = paramString;
  }
  
  public static void setPushId(String paramString)
  {
    mPushId = paramString;
  }
  
  public static void setSceneFrom(String paramString)
  {
    mSceneFrom = paramString;
  }
  
  public static void setSessionId(String paramString)
  {
    mSessionId = paramString;
    LocalMultiProcConfig.putString("weishi_usergrowth", "key_session_id", mSessionId);
  }
  
  public static void setSessionStamp(String paramString)
  {
    mSessionStamp = paramString;
    LocalMultiProcConfig.putString("weishi_usergrowth", "key_session_stamp", mSessionStamp);
  }
  
  public static void setSopName(String paramString)
  {
    mSopName = paramString;
  }
  
  public static void setTestId(String paramString)
  {
    mTestId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsBaseCollector
 * JD-Core Version:    0.7.0.1
 */