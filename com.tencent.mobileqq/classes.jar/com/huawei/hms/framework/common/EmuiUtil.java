package com.huawei.hms.framework.common;

import com.huawei.android.os.BuildEx.VERSION;

public class EmuiUtil
{
  private static final String BUILDEX_NAME = "com.huawei.android.os.BuildEx";
  public static final String BUILDEX_VERSION = "com.huawei.android.os.BuildEx$VERSION";
  private static final int EMUI_3_0 = 7;
  private static final int EMUI_3_1 = 8;
  private static final int EMUI_4_0 = 9;
  private static final int EMUI_4_1 = 10;
  private static final int EMUI_5_0 = 11;
  private static final int EMUI_6_0 = 14;
  private static final int EMUI_8_0_1 = 15;
  private static final int EMUI_9_0 = 17;
  public static final String EMUI_SDK_INT = "EMUI_SDK_INT";
  private static final int EMUI_TYPE_UNKOWN = -1;
  public static final String GET_PRIMARY_COLOR = "getPrimaryColor";
  public static final String GET_SUGGESTION_FOR_GROUND_COLOR_STYLE = "getSuggestionForgroundColorStyle";
  public static final String IMMERSION_STYLE = "com.huawei.android.immersion.ImmersionStyle";
  private static final String TAG = "KPMS_Util_Emui";
  private static final int TYPE_EMUI_30 = 30;
  private static final int TYPE_EMUI_31 = 31;
  private static final int TYPE_EMUI_40 = 40;
  private static final int TYPE_EMUI_41 = 41;
  private static final int TYPE_EMUI_50 = 50;
  private static final int TYPE_EMUI_60 = 60;
  private static final int TYPE_EMUI_801 = 81;
  private static final int TYPE_EMUI_90 = 90;
  private static int emuiType = -1;
  
  static {}
  
  private static int getEMUIVersionCode()
  {
    Object localObject = ReflectionUtils.getStaticFieldObj("com.huawei.android.os.BuildEx$VERSION", "EMUI_SDK_INT");
    int i;
    if (localObject != null) {
      try
      {
        i = ((Integer)localObject).intValue();
      }
      catch (ClassCastException localClassCastException)
      {
        Logger.e("KPMS_Util_Emui", "getEMUIVersionCode ClassCastException:", localClassCastException);
      }
    } else {
      i = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("the emui version code is::");
    localStringBuilder.append(i);
    Logger.d("KPMS_Util_Emui", localStringBuilder.toString());
    return i;
  }
  
  private static void initEmuiType()
  {
    int i = getEMUIVersionCode();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getEmuiType emuiVersionCode=");
    localStringBuilder.append(i);
    Logger.d("KPMS_Util_Emui", localStringBuilder.toString());
    if (i >= 17) {
      emuiType = 90;
    } else if (i >= 15) {
      emuiType = 81;
    } else if (i >= 14) {
      emuiType = 60;
    } else if (i >= 11) {
      emuiType = 50;
    } else if (i >= 10) {
      emuiType = 41;
    } else if (i >= 9) {
      emuiType = 40;
    } else if (i >= 8) {
      emuiType = 31;
    } else if (i >= 7) {
      emuiType = 30;
    }
    if (emuiType == -1) {
      Logger.i("KPMS_Util_Emui", "emuiType is unkown");
    }
  }
  
  public static boolean isEMUI()
  {
    return -1 != emuiType;
  }
  
  public static boolean isUpPVersion()
  {
    return (ReflectionUtils.checkCompatible("com.huawei.android.os.BuildEx")) && (BuildEx.VERSION.EMUI_SDK_INT >= 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.EmuiUtil
 * JD-Core Version:    0.7.0.1
 */