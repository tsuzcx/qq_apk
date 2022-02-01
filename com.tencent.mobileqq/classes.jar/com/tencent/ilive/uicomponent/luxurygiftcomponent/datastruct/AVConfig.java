package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct;

import org.json.JSONObject;

public class AVConfig
{
  public static final int AV_PKG_PE = 1;
  public static final int AV_PKG_SRC = 0;
  public static final int RECORD_SCREEN_LEVEL_1280 = 11;
  public static final int RECORD_SCREEN_LEVEL_640 = 12;
  private static int sAVPkgType = 1;
  private static String sAnchorRolesValue = "anchor";
  private static long sAnchorSocreVersion = 0L;
  private static int sBeautySkinValue = 1;
  private static int sBeautyWhiteValue = 3;
  private static int sBitrateOfSreenrecord = 1600;
  private static JSONObject sCameraConfig;
  private static int sCheckVideoFrameException = 0;
  private static int sForceUseHwDecConfig = -1;
  private static int sForceUseHwEncConfig = -1;
  private static int sHeightOfSceenrecord = 720;
  private static boolean sIsCameraSetRecordingHint = true;
  private static boolean sIsCurrentDisablePtuVideoFilters = false;
  private static boolean sIsDubNeedHeadset = false;
  private static boolean sIsEnableScreenRecord = true;
  private static boolean sIsPtvFilterSupported = true;
  private static boolean sIsRecvAudio = true;
  private static boolean sIsSupportBeauty = true;
  private static boolean sIsSupportHardwareDecodeForRTMP = true;
  private static boolean sIsSupportHardwareDecoder = true;
  private static boolean sIsSupportHardwareEncode = true;
  private static boolean sIsSupportOpenglesAPI = true;
  private static boolean sIsSupportPtuBeauty = false;
  private static boolean sIsSupportPtuRetouch = false;
  private static JSONObject sMediaAVConfig;
  private static JSONObject sOpenSdkConfig;
  private static int sPtuBeautyFilterID = -1;
  private static int sPtuBeautySecondFilterID = -1;
  private static int sPtuBeautyType = 1;
  private static boolean sPtuInitialed = false;
  private static int sRecordScreenLevel = 11;
  private static AVConfig.RtmpConfig sRtmpConfig;
  private static int sRtmpPlayerIndex = -1;
  private static String sRtmpPlayerUrl = "";
  private static String sRtmpRoomID = "";
  private static int sUseOpenSdkHwDecConfig = 1;
  private static int sUseOpenSdkHwEncConfig = 1;
  private static JSONObject sVideoGearInfo;
  private static int sWidthOfScreenrecord = 1280;
  
  public static int getAVPkgType()
  {
    return 1;
  }
  
  public static String getAnchorRolesValue()
  {
    return sAnchorRolesValue;
  }
  
  public static long getAnchorScoreVersion()
  {
    return sAnchorSocreVersion;
  }
  
  public static int getBeautySkinValue()
  {
    return sBeautySkinValue;
  }
  
  public static int getBeautyWhiteValue()
  {
    return sBeautyWhiteValue;
  }
  
  public static int getBitrateOfSreenrecord()
  {
    return sBitrateOfSreenrecord;
  }
  
  public static JSONObject getCameraConfig()
  {
    return sCameraConfig;
  }
  
  public static int getCheckVideoFrameException()
  {
    return sCheckVideoFrameException;
  }
  
  public static boolean getDubNeedHeadsetCfg()
  {
    return sIsDubNeedHeadset;
  }
  
  public static int getForceUseHwDecConfig()
  {
    return sForceUseHwDecConfig;
  }
  
  public static int getForceUseHwEncConfig()
  {
    return sForceUseHwEncConfig;
  }
  
  public static int getHeightOfSceenrecord()
  {
    return sHeightOfSceenrecord;
  }
  
  public static JSONObject getMediaAVConfig()
  {
    return sMediaAVConfig;
  }
  
  public static JSONObject getOpenSdkConfig()
  {
    JSONObject localJSONObject2 = sOpenSdkConfig;
    JSONObject localJSONObject1 = localJSONObject2;
    if (localJSONObject2 == null) {
      localJSONObject1 = new JSONObject();
    }
    return localJSONObject1;
  }
  
  public static int getPtuBeautyFilterID()
  {
    return sPtuBeautyFilterID;
  }
  
  public static int getPtuBeautySecondFilterID()
  {
    return sPtuBeautySecondFilterID;
  }
  
  public static int getPtuBeautyType()
  {
    return sPtuBeautyType;
  }
  
  public static int getRecordScreenLevel()
  {
    return sRecordScreenLevel;
  }
  
  public static boolean getRecvAudioCfg()
  {
    return sIsRecvAudio;
  }
  
  public static AVConfig.RtmpConfig getRtmpConfig()
  {
    return sRtmpConfig;
  }
  
  public static int getRtmpPlayerIndex()
  {
    return sRtmpPlayerIndex;
  }
  
  public static String getRtmpPlayerUrl()
  {
    return sRtmpPlayerUrl;
  }
  
  public static String getRtmpRoomID()
  {
    return sRtmpRoomID;
  }
  
  public static int getUseOpenSdkHwDecConfig()
  {
    return sUseOpenSdkHwDecConfig;
  }
  
  public static int getUseOpenSdkHwEncConfig()
  {
    return sUseOpenSdkHwEncConfig;
  }
  
  public static JSONObject getVideoGearInfo()
  {
    return sVideoGearInfo;
  }
  
  public static int getWidthOfScreenrecord()
  {
    return sWidthOfScreenrecord;
  }
  
  public static boolean isCameraSetRecordingHint()
  {
    return sIsCameraSetRecordingHint;
  }
  
  public static boolean isPtvFilterSupported()
  {
    return sIsPtvFilterSupported;
  }
  
  public static boolean isSupportBeauty()
  {
    return sIsSupportBeauty;
  }
  
  public static boolean isSupportHardwareDecodeForRTMP()
  {
    return sIsSupportHardwareDecodeForRTMP;
  }
  
  public static boolean isSupportHardwareDecoder()
  {
    return sIsSupportHardwareDecoder;
  }
  
  public static boolean isSupportHardwareEncode()
  {
    return sIsSupportHardwareEncode;
  }
  
  public static boolean isSupportOpenglesAPI()
  {
    return sIsSupportOpenglesAPI;
  }
  
  public static boolean isSupportPtuBeauty()
  {
    return sIsSupportPtuBeauty;
  }
  
  public static boolean isSupportPtuRetouch()
  {
    return (sIsSupportPtuRetouch) && (isSupportPtuBeauty());
  }
  
  public static boolean isSupportPtuVideoFilters()
  {
    return sIsCurrentDisablePtuVideoFilters;
  }
  
  public static boolean isUsePtuRetouch()
  {
    return (sIsSupportPtuRetouch) && (isSupportPtuBeauty()) && (sPtuInitialed);
  }
  
  public static void markPtuInitialed(boolean paramBoolean)
  {
    sPtuInitialed = paramBoolean;
  }
  
  public static void setAVPkgType(int paramInt)
  {
    sAVPkgType = 1;
  }
  
  public static void setAnchorRolesConfig(String paramString)
  {
    sAnchorRolesValue = paramString;
  }
  
  public static void setAnchorScoreVersion(long paramLong)
  {
    sAnchorSocreVersion = paramLong;
  }
  
  public static void setBeautySkinValue(int paramInt)
  {
    sBeautySkinValue = paramInt;
  }
  
  public static void setBeautyWhiteValue(int paramInt)
  {
    sBeautyWhiteValue = paramInt;
  }
  
  public static void setBitrateOfSreenrecord(int paramInt)
  {
    sBitrateOfSreenrecord = paramInt;
  }
  
  public static void setCameraConfig(JSONObject paramJSONObject)
  {
    sCameraConfig = paramJSONObject;
  }
  
  public static void setCheckVideoFrameException(int paramInt)
  {
    sCheckVideoFrameException = paramInt;
  }
  
  public static void setDubNeedHeadsetCfg(boolean paramBoolean)
  {
    sIsDubNeedHeadset = paramBoolean;
  }
  
  public static void setForceUseHwDecConfig(int paramInt)
  {
    sForceUseHwDecConfig = paramInt;
  }
  
  public static void setForceUseHwEncConfig(int paramInt)
  {
    sForceUseHwEncConfig = paramInt;
  }
  
  public static void setHeightOfSceenrecord(int paramInt)
  {
    sHeightOfSceenrecord = paramInt;
  }
  
  public static void setIsCameraSetRecordingHint(boolean paramBoolean)
  {
    sIsCameraSetRecordingHint = paramBoolean;
  }
  
  public static void setIsPtvFilterSupported(boolean paramBoolean)
  {
    sIsPtvFilterSupported = paramBoolean;
  }
  
  public static void setIsSupportBeauty(boolean paramBoolean)
  {
    sIsSupportBeauty = paramBoolean;
  }
  
  public static void setIsSupportOpenglesAPI(boolean paramBoolean)
  {
    sIsSupportOpenglesAPI = paramBoolean;
  }
  
  public static void setMediaAVConfig(JSONObject paramJSONObject)
  {
    sMediaAVConfig = paramJSONObject;
  }
  
  public static void setOpenSdkConfig(JSONObject paramJSONObject)
  {
    sOpenSdkConfig = paramJSONObject;
  }
  
  public static void setPtuBeautyFilterID(int paramInt)
  {
    sPtuBeautyFilterID = paramInt;
  }
  
  public static void setPtuBeautySecondFilterID(int paramInt)
  {
    sPtuBeautySecondFilterID = paramInt;
  }
  
  public static void setPtuBeautyType(int paramInt)
  {
    sPtuBeautyType = paramInt;
  }
  
  public static void setRecordScreenLevel(int paramInt)
  {
    sRecordScreenLevel = paramInt;
  }
  
  public static void setRecvAudioCfg(boolean paramBoolean)
  {
    sIsRecvAudio = paramBoolean;
  }
  
  public static void setRtmpConfig(AVConfig.RtmpConfig paramRtmpConfig)
  {
    sRtmpConfig = paramRtmpConfig;
  }
  
  public static void setRtmpPlayerIndex(int paramInt)
  {
    sRtmpPlayerIndex = paramInt;
  }
  
  public static void setRtmpPlayerUrl(String paramString)
  {
    sRtmpPlayerUrl = paramString;
  }
  
  public static void setRtmpRoomID(String paramString)
  {
    sRtmpRoomID = paramString;
  }
  
  public static void setSupportHardwareDecodeForRTMP(boolean paramBoolean)
  {
    sIsSupportHardwareDecodeForRTMP = paramBoolean;
  }
  
  public static void setSupportHardwareDecoder(boolean paramBoolean)
  {
    sIsSupportHardwareDecoder = paramBoolean;
  }
  
  public static void setSupportHardwareEncode(boolean paramBoolean)
  {
    sIsSupportHardwareEncode = paramBoolean;
  }
  
  public static void setSupportPtuBeauty(boolean paramBoolean)
  {
    sIsSupportPtuBeauty = paramBoolean;
  }
  
  public static void setSupportPtuRetouch(boolean paramBoolean)
  {
    sIsSupportPtuRetouch = paramBoolean;
  }
  
  public static void setSupportPtuVideoFilters(boolean paramBoolean)
  {
    sIsCurrentDisablePtuVideoFilters = paramBoolean;
  }
  
  public static void setUseOpenSdkHwDecConfig(int paramInt)
  {
    sUseOpenSdkHwDecConfig = paramInt;
  }
  
  public static void setUseOpenSdkHwEncConfig(int paramInt)
  {
    sUseOpenSdkHwEncConfig = paramInt;
  }
  
  public static void setVideoGearInfo(JSONObject paramJSONObject)
  {
    sVideoGearInfo = paramJSONObject;
  }
  
  public static void setWidthOfScreenrecord(int paramInt)
  {
    sWidthOfScreenrecord = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.AVConfig
 * JD-Core Version:    0.7.0.1
 */