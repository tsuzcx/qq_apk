package com.tencent.biz.pubaccount.weishi_new.report;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.weishi_new.util.WSDeviceUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSHardwareUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.statistics.CaughtExceptionReport;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.tmassistantbase.util.GlobalUtil;
import cooperation.qzone.QUA;
import java.util.HashMap;
import java.util.Map;

public class WSStatisticsBaseCollector
{
  private static final String APP_VERSION = AppSetting.a(BaseApplicationImpl.getContext());
  public static final String KEY_REF_PAGE_ID = "key_ref_page_id";
  private static final String SCREEN_RES = ;
  private static final String UI_VERSION = ROMUtil.getRomName() + ROMUtil.getRomVersion();
  private String mEventName;
  private String mExtendInfo;
  private String mOperationId;
  private String mPushId;
  private String mSopName;
  private String mSubSession;
  private String mTestId;
  
  private String getExtendInfo()
  {
    return this.mExtendInfo;
  }
  
  private String getLocalIpAddress()
  {
    try
    {
      String str = WSDeviceUtils.a();
      return str;
    }
    catch (NullPointerException localNullPointerException)
    {
      CaughtExceptionReport.a(localNullPointerException);
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
    if (TextUtils.isEmpty(WSReportEventConstants.b)) {
      return WSSharePreferencesUtil.a("key_ref_page_id", "");
    }
    return WSReportEventConstants.b;
  }
  
  private String getTestId()
  {
    return WSReportUtils.a(this.mTestId);
  }
  
  public Map<String, String> getBaseParams()
  {
    HashMap localHashMap = new HashMap(38);
    localHashMap.put("qimei", UserAction.getQIMEI());
    localHashMap.put("imsi", DeviceInfoUtil.b());
    localHashMap.put("imei", MobileInfoUtil.c());
    localHashMap.put("mac", MobileInfoUtil.a());
    localHashMap.put("dev_brand", GlobalUtil.getInstance().getBrand());
    localHashMap.put("dev_model", Build.MODEL);
    localHashMap.put("os", "Android");
    localHashMap.put("screen_res", SCREEN_RES);
    localHashMap.put("operating_system_version", Build.VERSION.RELEASE);
    localHashMap.put("ui_version", UI_VERSION);
    localHashMap.put("app_ver", APP_VERSION);
    localHashMap.put("wifiBssid", WSDeviceUtils.f());
    localHashMap.put("push_id", getPushId());
    localHashMap.put("ip", getLocalIpAddress());
    localHashMap.put("session_id", WSPublicAccReport.getInstance().getSessionId());
    localHashMap.put("session_stamp", WSPublicAccReport.getInstance().getSessionStamp());
    localHashMap.put("sop_name", getSopName());
    localHashMap.put("qua", QUA.getQUA3());
    localHashMap.put("android_id", DeviceInfoUtil.f());
    localHashMap.put("qq", WeishiUtils.a());
    if (WeishiGuideUtils.a(BaseApplicationImpl.getApplication())) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("if_install_weishi", str);
      localHashMap.put("person_id", WeishiUtils.d());
      localHashMap.put("time", String.valueOf(System.currentTimeMillis()));
      localHashMap.put("network_type", WSDeviceUtils.g());
      localHashMap.put("extended_fields", getExtendInfo());
      localHashMap.put("scenes_from", WSReportUtils.a());
      localHashMap.put("operation_id", getOperationId());
      localHashMap.put("test_id", getTestId());
      localHashMap.put("ref_page_id", getRefPageId());
      localHashMap.put("sub_session_id", getSubSession());
      localHashMap.put("hardware_info", WSHardwareUtil.a(BaseApplicationImpl.getContext()));
      localHashMap.put("hardware_level", String.valueOf(WSHardwareUtil.a(BaseApplicationImpl.getContext())));
      return localHashMap;
    }
  }
  
  public String getSopName()
  {
    return this.mSopName;
  }
  
  public String getSubSession()
  {
    if ((TextUtils.equals(this.mEventName, "gzh_pagevisit")) && (TextUtils.equals(getSopName(), "feeds"))) {
      return "";
    }
    return this.mSubSession;
  }
  
  public void setEventName(String paramString)
  {
    this.mEventName = paramString;
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
  
  public void setSopName(String paramString)
  {
    this.mSopName = paramString;
  }
  
  public void setSubSession(String paramString)
  {
    this.mSubSession = paramString;
  }
  
  public void setTestId(String paramString)
  {
    this.mTestId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsBaseCollector
 * JD-Core Version:    0.7.0.1
 */