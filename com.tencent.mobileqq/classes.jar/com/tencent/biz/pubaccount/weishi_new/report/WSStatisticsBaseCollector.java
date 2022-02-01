package com.tencent.biz.pubaccount.weishi_new.report;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import bcdb;
import biaq;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import java.util.HashMap;
import java.util.Map;
import uvu;
import uyo;
import yqu;

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
      bcdb.a(localNullPointerException);
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
    if (TextUtils.isEmpty(uvu.b)) {
      return LocalMultiProcConfig.getString("weishi_usergrowth", "key_ref_page_id", "");
    }
    return uvu.b;
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
    localHashMap.put("imsi", DeviceInfoUtil.getIMSI());
    localHashMap.put("imei", biaq.c());
    localHashMap.put("mac", biaq.a());
    localHashMap.put("dev_brand", GlobalUtil.getInstance().getBrand());
    localHashMap.put("dev_model", Build.MODEL);
    localHashMap.put("os", "Android");
    localHashMap.put("screen_res", SCREEN_RES);
    localHashMap.put("operating_system_version", Build.VERSION.RELEASE);
    localHashMap.put("ui_version", UI_VERSION);
    localHashMap.put("app_ver", APP_VERSION);
    localHashMap.put("wifiBssid", uyo.e());
    localHashMap.put("push_id", getPushId());
    localHashMap.put("ip", getLocalIpAddress());
    localHashMap.put("session_id", WSPublicAccReport.getInstance().getSessionId());
    localHashMap.put("session_stamp", WSPublicAccReport.getInstance().getSessionStamp());
    localHashMap.put("sop_name", getSopName());
    localHashMap.put("qua", QUA.getQUA3());
    localHashMap.put("android_id", DeviceInfoUtil.getAndroidID());
    localHashMap.put("qq", uyo.a());
    if (yqu.a(BaseApplicationImpl.getApplication())) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("if_install_weishi", str);
      localHashMap.put("person_id", uyo.f());
      localHashMap.put("time", String.valueOf(System.currentTimeMillis()));
      localHashMap.put("network_type", uyo.d());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsBaseCollector
 * JD-Core Version:    0.7.0.1
 */