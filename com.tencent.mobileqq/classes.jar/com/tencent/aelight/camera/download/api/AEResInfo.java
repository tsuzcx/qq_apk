package com.tencent.aelight.camera.download.api;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class AEResInfo
  implements Serializable
{
  @Deprecated
  public static final AEResInfo AE_RES_ADDITIONAL_PACKAGE;
  public static final AEResInfo AE_RES_BASE_PACKAGE;
  public static final AEResInfo AE_RES_CONFIG = new AEResInfo(-1, "718Config");
  public static final AEResInfo LIGHT_RES_BASE_PACKAGE;
  public static final AEResInfo LIGHT_RES_BUNDLE_3DMM;
  public static final AEResInfo LIGHT_RES_BUNDLE_ACE3D;
  public static final AEResInfo LIGHT_RES_BUNDLE_AGE;
  public static final AEResInfo LIGHT_RES_BUNDLE_BODY;
  public static final AEResInfo LIGHT_RES_BUNDLE_BODY_3D;
  public static final AEResInfo LIGHT_RES_BUNDLE_CAT;
  public static final AEResInfo LIGHT_RES_BUNDLE_DEPTH;
  public static final AEResInfo LIGHT_RES_BUNDLE_EMOTION;
  public static final AEResInfo LIGHT_RES_BUNDLE_GAZE;
  public static final AEResInfo LIGHT_RES_BUNDLE_GENDER;
  public static final AEResInfo LIGHT_RES_BUNDLE_HAND;
  public static final AEResInfo LIGHT_RES_BUNDLE_SCENE;
  public static final AEResInfo LIGHT_RES_BUNDLE_SEG_HAIR;
  public static final AEResInfo LIGHT_RES_BUNDLE_SEG_HEAD;
  public static final AEResInfo LIGHT_RES_BUNDLE_SEG_SKY;
  public static final AEResInfo[] packageValues = initPackageValues();
  public static final AEResInfo[] values;
  public String agentType;
  public final String description;
  public final int index;
  public final boolean isPackage;
  public boolean isPredownload = true;
  public final String resPrefix;
  public final int resVersion;
  public final int resVersionLimit;
  
  static
  {
    AE_RES_BASE_PACKAGE = new AEResInfo(0, "AEBasePackage", "new_qq_android_native_short_filter_", "");
    LIGHT_RES_BASE_PACKAGE = new AEResInfo(1, "LightBasePackage", "new_qq_android_native_light_base_", "");
    LIGHT_RES_BUNDLE_HAND = new AEResInfo(2, "LightBundleHand", "new_qq_android_native_light_bundle_hand_", "HAND_AGENT");
    LIGHT_RES_BUNDLE_GENDER = new AEResInfo(3, "LightBundleGender", "new_qq_android_native_light_bundle_gender_", "GENDER_AGENT");
    LIGHT_RES_BUNDLE_CAT = new AEResInfo(4, "LightBundleCat", "new_qq_android_native_light_bundle_cat_", "CAT_AGENT");
    LIGHT_RES_BUNDLE_DEPTH = new AEResInfo(5, "LightBundleDepth", "new_qq_android_native_light_bundle_depth_", "DEPTH_AGENT");
    LIGHT_RES_BUNDLE_SEG_HAIR = new AEResInfo(6, "LightBundleSegHair", "new_qq_android_native_light_bundle_seg_hair_", "HAIR_SEG_AGENT");
    LIGHT_RES_BUNDLE_SEG_SKY = new AEResInfo(7, "LightBundleSegSky", "new_qq_android_native_light_bundle_seg_sky_", "SKY_SEG_AGENT");
    LIGHT_RES_BUNDLE_ACE3D = new AEResInfo(8, "LightBundleAce3D", "new_qq_android_native_light_bundle_ace3d_", "Ace_3d_Engine");
    LIGHT_RES_BUNDLE_3DMM = new AEResInfo(9, "LightBundle3DMM", "new_qq_android_native_light_bundle_3dmm_", "k3D_MM_AGENT");
    LIGHT_RES_BUNDLE_SEG_HEAD = new AEResInfo(10, "LightBundleSegHead", "new_qq_android_native_light_bundle_seg_head_", "HEAD_SEG_AGENT");
    LIGHT_RES_BUNDLE_SCENE = new AEResInfo(11, "LightBundleScene", "new_qq_android_native_light_bundle_scene_", "SCENE_AGENT");
    LIGHT_RES_BUNDLE_EMOTION = new AEResInfo(12, "LightBundleEmotion", "new_qq_android_native_light_bundle_emotion_", "EMOTION_AGENT");
    LIGHT_RES_BUNDLE_BODY = new AEResInfo(13, "LightBundleBody", "new_qq_android_native_light_bundle_body_", "BODY_AGENT");
    LIGHT_RES_BUNDLE_AGE = new AEResInfo(14, "LightBundleAge", "new_qq_android_native_light_bundle_age_", "AGE_AGENT");
    LIGHT_RES_BUNDLE_GAZE = new AEResInfo(15, "LightBundleGaze", "new_qq_android_native_light_bundle_gaze_", "VIEW_POINT_AGENT");
    LIGHT_RES_BUNDLE_BODY_3D = new AEResInfo(16, "LightBundleBody3D", "new_qq_android_native_light_bundle_driver_body_3d_", "BODY3D_AGENT");
    AE_RES_ADDITIONAL_PACKAGE = new AEResInfo(-999, "AEAdditionalPackage", "new_qq_android_native_ptu_res_", "");
    values = new AEResInfo[] { AE_RES_CONFIG, AE_RES_BASE_PACKAGE, LIGHT_RES_BASE_PACKAGE, LIGHT_RES_BUNDLE_HAND, LIGHT_RES_BUNDLE_GENDER, LIGHT_RES_BUNDLE_AGE, LIGHT_RES_BUNDLE_GAZE, LIGHT_RES_BUNDLE_CAT, LIGHT_RES_BUNDLE_DEPTH, LIGHT_RES_BUNDLE_SEG_HAIR, LIGHT_RES_BUNDLE_SEG_SKY, LIGHT_RES_BUNDLE_ACE3D, LIGHT_RES_BUNDLE_3DMM, LIGHT_RES_BUNDLE_SEG_HEAD, LIGHT_RES_BUNDLE_SCENE, LIGHT_RES_BUNDLE_BODY, LIGHT_RES_BUNDLE_BODY_3D, LIGHT_RES_BUNDLE_EMOTION };
  }
  
  private AEResInfo(int paramInt, String paramString)
  {
    this.index = paramInt;
    this.description = paramString;
    this.resPrefix = null;
    this.resVersionLimit = -1;
    this.resVersion = -1;
    this.isPackage = false;
  }
  
  private AEResInfo(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.index = paramInt;
    this.description = paramString1;
    this.resPrefix = paramString2;
    this.agentType = paramString3;
    this.resVersionLimit = 8817002;
    this.resVersion = 8817;
    this.isPackage = true;
  }
  
  public static AEResInfo getAEResInfoByPrefix(String paramString)
  {
    AEResInfo[] arrayOfAEResInfo = packageValues;
    int j = arrayOfAEResInfo.length;
    int i = 0;
    while (i < j)
    {
      AEResInfo localAEResInfo = arrayOfAEResInfo[i];
      if (paramString.equalsIgnoreCase(localAEResInfo.resPrefix)) {
        return localAEResInfo;
      }
      i += 1;
    }
    return null;
  }
  
  private static AEResInfo[] initPackageValues()
  {
    LinkedList localLinkedList = new LinkedList();
    AEResInfo[] arrayOfAEResInfo = values;
    int j = arrayOfAEResInfo.length;
    int i = 0;
    while (i < j)
    {
      AEResInfo localAEResInfo = arrayOfAEResInfo[i];
      if (localAEResInfo.isPackage) {
        localLinkedList.add(localAEResInfo);
      }
      i += 1;
    }
    return (AEResInfo[])localLinkedList.toArray(new AEResInfo[0]);
  }
  
  public static boolean isAdittionPackage(AEResInfo paramAEResInfo)
  {
    return (paramAEResInfo != null) && (paramAEResInfo.index > 1);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{index:");
    localStringBuilder.append(this.index);
    localStringBuilder.append(", description:");
    localStringBuilder.append(this.description);
    localStringBuilder.append(", resPrefix:");
    localStringBuilder.append(this.resPrefix);
    localStringBuilder.append(", resVersionLimit:");
    localStringBuilder.append(this.resVersionLimit);
    localStringBuilder.append(", resVersion:");
    localStringBuilder.append(this.resVersion);
    localStringBuilder.append(", isPackage:");
    localStringBuilder.append(this.isPackage);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.download.api.AEResInfo
 * JD-Core Version:    0.7.0.1
 */