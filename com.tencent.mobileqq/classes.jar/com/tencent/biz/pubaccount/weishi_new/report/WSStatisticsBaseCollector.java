package com.tencent.biz.pubaccount.weishi_new.report;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import bdkh;
import bhlo;
import bjve;
import bmsw;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import uoa;
import uqt;
import zqd;

public class WSStatisticsBaseCollector
{
  private static final String APP_VERSION = AppSetting.a(BaseApplicationImpl.getContext());
  public static final String KEY_REF_PAGE_ID = "key_ref_page_id";
  private static final String SCREEN_RES = ;
  private static final String UI_VERSION = ROMUtil.getRomName() + ROMUtil.getRomVersion();
  private String mExtendInfo;
  private String mOperationId;
  private String mPushId;
  private String mSceneFrom;
  private String mSopName;
  private String mTestId;
  
  private String getExtendInfo()
  {
    return this.mExtendInfo;
  }
  
  private String getLocalIpAddress()
  {
    try
    {
      String str = DeviceUtils.getLocalIpAddress();
      return str;
    }
    catch (NullPointerException localNullPointerException)
    {
      bdkh.a(localNullPointerException);
    }
    return "";
  }
  
  private String getOperationId()
  {
    return this.mOperationId;
  }
  
  private String getPushId()
  {
    return this.mPushId;
  }
  
  private String getRefPageId()
  {
    if (TextUtils.isEmpty(uoa.b)) {
      return LocalMultiProcConfig.getString("weishi_usergrowth", "key_ref_page_id", "");
    }
    return uoa.b;
  }
  
  private String getSceneFrom()
  {
    return this.mSceneFrom;
  }
  
  private String getTestId()
  {
    return this.mTestId;
  }
  
  public Map<String, String> getBaseParams()
  {
    HashMap localHashMap = new HashMap(38);
    localHashMap.put("qimei", UserAction.getQIMEI());
    localHashMap.put("imsi", bhlo.b());
    localHashMap.put("imei", bjve.c());
    localHashMap.put("mac", bjve.a());
    localHashMap.put("dev_brand", GlobalUtil.getInstance().getBrand());
    localHashMap.put("dev_model", Build.MODEL);
    localHashMap.put("os", "Android");
    localHashMap.put("screen_res", SCREEN_RES);
    localHashMap.put("operating_system_version", Build.VERSION.RELEASE);
    localHashMap.put("ui_version", UI_VERSION);
    localHashMap.put("app_ver", APP_VERSION);
    localHashMap.put("wifiBssid", uqt.e());
    localHashMap.put("push_id", getPushId());
    localHashMap.put("ip", getLocalIpAddress());
    localHashMap.put("session_id", WSPublicAccReport.getInstance().getSessionId());
    localHashMap.put("session_stamp", WSPublicAccReport.getInstance().getSessionStamp());
    localHashMap.put("sop_name", getSopName());
    localHashMap.put("qua", bmsw.a());
    localHashMap.put("android_id", bhlo.f());
    localHashMap.put("qq", uqt.a().getAccount());
    if (zqd.a(BaseApplicationImpl.getApplication())) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("if_install_weishi", str);
      localHashMap.put("person_id", uqt.f());
      localHashMap.put("time", String.valueOf(System.currentTimeMillis()));
      localHashMap.put("network_type", uqt.d());
      localHashMap.put("extended_fields", getExtendInfo());
      localHashMap.put("scenes_from", getSceneFrom());
      localHashMap.put("operation_id", getOperationId());
      localHashMap.put("test_id", getTestId());
      localHashMap.put("ref_page_id", getRefPageId());
      return localHashMap;
    }
  }
  
  public String getSopName()
  {
    return this.mSopName;
  }
  
  public void setExtendInfo(String paramString)
  {
    this.mExtendInfo = paramString;
  }
  
  public void setOperationId(String paramString)
  {
    this.mOperationId = paramString;
  }
  
  public void setPushId(String paramString)
  {
    this.mPushId = paramString;
  }
  
  public void setSceneFrom(String paramString)
  {
    this.mSceneFrom = paramString;
  }
  
  public void setSopName(String paramString)
  {
    this.mSopName = paramString;
  }
  
  public void setTestId(String paramString)
  {
    this.mTestId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsBaseCollector
 * JD-Core Version:    0.7.0.1
 */