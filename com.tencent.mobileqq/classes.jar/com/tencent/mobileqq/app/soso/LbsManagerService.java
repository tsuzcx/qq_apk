package com.tencent.mobileqq.app.soso;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LbsManagerService
{
  private static final int MAX_CONTINUE_FAIL_COUNT = 5;
  private static final int REAL_TIME_REQUIREMENT_ALMOST_IMMEDIATELY = 4;
  private static final int REAL_TIME_REQUIREMENT_HIGH = 3;
  private static final int REAL_TIME_REQUIREMENT_IMMEDIATELY = 5;
  private static final int REAL_TIME_REQUIREMENT_LOW = 1;
  private static final int REAL_TIME_REQUIREMENT_MIDDLE = 2;
  private static final HashMap<String, LbsManagerService.BusinessInfo> S_BUSINESS = new HashMap();
  private static final String TAG = "SOSO.LBS.LbsManagerService";
  private static Map<LbsManagerService.OnLocationChangeListener, SosoInterface.OnLocationListener> sListenerMap = new ConcurrentHashMap(8, 0.75F);
  private static Map<SosoInterface.OnLocationListener, LbsManagerService.OnLocationChangeListener> sReverseListenerMap = new ConcurrentHashMap(8, 0.75F);
  
  static
  {
    registerBusinessInfo();
  }
  
  private static LbsManagerService.BusinessInfo getBusinessInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (LbsManagerService.BusinessInfo)S_BUSINESS.get(paramString);
  }
  
  public static SosoInterface.SosoLbsInfo getCachedLbsInfo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SOSO.LBS.LbsManagerService", 0, "getCachedLbsInfo business id: " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = getBusinessInfo(paramString);
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("SOSO.LBS.LbsManagerService", 0, "getCachedLbsInfo business info is null.");
    return null;
    if (paramString.reqRawData) {
      return SosoInterface.getRawSosoInfo(paramString.reqLonAndLat);
    }
    return SosoInterface.getSosoInfo(paramString.requestDataLevel, paramString.reqLonAndLat);
  }
  
  public static SosoInterface.SosoLbsInfo getCachedLbsInfo(boolean paramBoolean)
  {
    if (paramBoolean) {
      return SosoInterface.getRawSosoInfo(false);
    }
    return SosoInterface.getSosoInfo(3, false);
  }
  
  public static String getCity()
  {
    return SosoInterface.getCity();
  }
  
  public static String getCityCode()
  {
    return SosoInterface.getCityCode();
  }
  
  public static String getProvince()
  {
    return SosoInterface.getProvince();
  }
  
  private static SosoInterface.SosoLbsInfo handleLbsInfo(SosoInterface.SosoLbsInfo paramSosoLbsInfo, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      return null;
      localObject = getBusinessInfo(paramString);
    } while ((localObject == null) || (paramSosoLbsInfo == null));
    if (((LbsManagerService.BusinessInfo)localObject).reqRawData)
    {
      paramString = new SosoInterface.SosoLbsInfo();
      paramString.rawData = paramSosoLbsInfo.rawData;
      if (paramSosoLbsInfo.mLocation != null) {
        paramString.mLocation = paramSosoLbsInfo.mLocation.clone(0, ((LbsManagerService.BusinessInfo)localObject).reqLonAndLat);
      }
      if (paramSosoLbsInfo.mAttr != null) {
        paramString.mAttr = paramSosoLbsInfo.mAttr.clone();
      }
      localObject = new ArrayList();
      if (paramSosoLbsInfo.mCells != null) {
        ((ArrayList)localObject).addAll(paramSosoLbsInfo.mCells);
      }
      paramString.mCells = ((ArrayList)localObject);
      localObject = new ArrayList();
      if (paramSosoLbsInfo.mWifis != null) {
        ((ArrayList)localObject).addAll(paramSosoLbsInfo.mWifis);
      }
      paramString.mWifis = ((ArrayList)localObject);
      paramString.mSource = paramSosoLbsInfo.mSource;
      paramString.mVersion = paramSosoLbsInfo.mVersion;
      paramString.provider = paramSosoLbsInfo.provider;
      return paramString;
    }
    paramString = new SosoInterface.SosoLbsInfo();
    paramString.mLocation = paramSosoLbsInfo.mLocation.clone(((LbsManagerService.BusinessInfo)localObject).requestDataLevel, ((LbsManagerService.BusinessInfo)localObject).reqLonAndLat);
    return paramString;
  }
  
  public static boolean isLastLocationSuccess()
  {
    return SosoInterface.isLastLocationSuccess();
  }
  
  private static SosoInterface.OnLocationListener makeSosoOnLocationListener(LbsManagerService.OnLocationChangeListener paramOnLocationChangeListener)
  {
    boolean bool1 = false;
    LbsManagerService.BusinessInfo localBusinessInfo = getBusinessInfo(paramOnLocationChangeListener.businessId);
    if (localBusinessInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 0, "makeSososOnLocationListener business info is null, business id: " + paramOnLocationChangeListener.businessId);
      }
      return null;
    }
    int i = localBusinessInfo.canUseMaxCacheInterval();
    int j = localBusinessInfo.requestDataLevel;
    boolean bool2 = localBusinessInfo.reqGoon;
    boolean bool3 = localBusinessInfo.canUseGps;
    if (!localBusinessInfo.reqRawData) {
      bool1 = true;
    }
    return new LbsManagerService.1(j, bool1, bool3, i, paramOnLocationChangeListener.observerOnUiThread, bool2, paramOnLocationChangeListener.businessId, paramOnLocationChangeListener);
  }
  
  public static void onDestroy()
  {
    synchronized (sListenerMap)
    {
      sListenerMap.clear();
      sReverseListenerMap.clear();
      return;
    }
  }
  
  private static void registerBusinessInfo()
  {
    LbsManagerService.BusinessInfo localBusinessInfo = new LbsManagerService.BusinessInfo("official_location", true, 5, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("QQMapActivity", true, 5, 1, true, true, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("readinjoy_anti_cheating", true, 2, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("vas_red_point", false, 2, 3, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_address_select", true, 5, 0, false, true, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_for_report", true, 3, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_weather", true, 4, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_live", true, 5, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_say", true, 5, 0, false, true, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_upload_pic_video", true, 5, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_photo_recommend", true, 3, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_little_video_enter", true, 3, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_request_server", true, 2, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_h5", false, 3, 3, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_other", true, 5, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("readinjoy_feed_ad_distance", true, 4, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("gdt_tangram", true, 1, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("nearby_readinjoy", true, 4, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("troop_handler", true, 2, 0, false, true, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("troop_member_distance", true, 2, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("webview", true, 3, 4, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qq_weather", false, 3, 3, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qq_story_water_mark", true, 4, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("readinjoy_weather", false, 3, 3, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("LBSService.Point", true, 5, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("Login.Guide", true, 2, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("recommend_troop", true, 2, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("vfuchong_bus_card", false, 3, 3, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("readinjoy_position", false, 3, 3, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qqcircle", true, 4, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("extend_friend", true, 1, 0, false, true, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("miniapp", true, 1, 0, false, true, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
  }
  
  public static void removeListener(LbsManagerService.OnLocationChangeListener paramOnLocationChangeListener)
  {
    if (paramOnLocationChangeListener == null) {
      return;
    }
    for (;;)
    {
      synchronized (sListenerMap)
      {
        if (!sListenerMap.containsKey(paramOnLocationChangeListener)) {
          break label120;
        }
        localOnLocationListener = (SosoInterface.OnLocationListener)sListenerMap.remove(paramOnLocationChangeListener);
        sReverseListenerMap.remove(localOnLocationListener);
        if (QLog.isColorLevel())
        {
          paramOnLocationChangeListener = new StringBuilder().append("removeListener business id is: ").append(paramOnLocationChangeListener.businessId).append(" sosoLocationListener is null: ");
          if (localOnLocationListener == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 0, bool);
          }
        }
        else
        {
          if (localOnLocationListener == null) {
            break;
          }
          SosoInterface.removeOnLocationListener(localOnLocationListener);
          return;
        }
      }
      boolean bool = false;
      continue;
      label120:
      SosoInterface.OnLocationListener localOnLocationListener = null;
    }
  }
  
  public static void startLocation(LbsManagerService.OnLocationChangeListener paramOnLocationChangeListener)
  {
    if (paramOnLocationChangeListener == null) {
      return;
    }
    label131:
    label136:
    for (;;)
    {
      synchronized (sListenerMap)
      {
        if (sListenerMap.containsKey(paramOnLocationChangeListener)) {
          break label131;
        }
        localOnLocationListener = makeSosoOnLocationListener(paramOnLocationChangeListener);
        if (localOnLocationListener == null) {
          break label136;
        }
        sListenerMap.put(paramOnLocationChangeListener, localOnLocationListener);
        sReverseListenerMap.put(localOnLocationListener, paramOnLocationChangeListener);
        break label136;
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("startLocation sosoLocationListener is null : ");
          if (localOnLocationListener == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 0, bool + " business id: " + paramOnLocationChangeListener.businessId);
          }
        }
        else
        {
          if (localOnLocationListener == null) {
            break;
          }
          SosoInterface.startLocation(localOnLocationListener);
          return;
        }
      }
      boolean bool = false;
      continue;
      SosoInterface.OnLocationListener localOnLocationListener = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.LbsManagerService
 * JD-Core Version:    0.7.0.1
 */