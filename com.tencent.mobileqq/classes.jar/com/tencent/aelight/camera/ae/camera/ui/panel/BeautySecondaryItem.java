package com.tencent.aelight.camera.ae.camera.ui.panel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautySecondaryItem;", "", "parent", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautyItem;", "itemName", "", "subType", "icon", "", "iconUrl", "min", "max", "defaultValue", "maskPath", "(Ljava/lang/String;ILcom/tencent/aelight/camera/ae/camera/ui/panel/BeautyItem;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIILjava/lang/String;)V", "getDefaultValue", "()I", "getIcon", "getIconUrl", "()Ljava/lang/String;", "getItemName", "getMaskPath", "getMax", "getMin", "getParent", "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautyItem;", "getSubType", "SUB_THIN_FACE_NATURE", "SUB_THIN_FACE_GIRL", "SUB_THIN_FACE_BOY", "SUB_LIPSTICK_NONE", "SUB_LIPSTICK_MI_TAO", "SUB_LIPSTICK_SHAN_HU", "SUB_LIPSTICK_WEN_ROU", "SUB_LIPSTICK_HUO_LI", "SUB_LIPSTICK_FU_GU", "SUB_RED_CHEEK_NONE", "SUB_RED_CHEEK_JIAN_YUE", "SUB_RED_CHECK_CHENG_SHU", "SUB_RED_CHECK_HAI_XIU", "SUB_RED_CHECK_SHENG_XIA", "SUB_LI_TI_NONE", "SUB_LI_TI_GUANG_MANG", "SUB_LI_TI_ZI_RAN", "SUB_LI_TI_QING_XIN", "SUB_LI_TI_JUN_LANG", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public enum BeautySecondaryItem
{
  private final int defaultValue;
  private final int icon;
  @Nullable
  private final String iconUrl;
  @NotNull
  private final String itemName;
  @NotNull
  private final String maskPath;
  private final int max;
  private final int min;
  @NotNull
  private final BeautyItem parent;
  @NotNull
  private final String subType;
  
  static
  {
    BeautySecondaryItem localBeautySecondaryItem1 = new BeautySecondaryItem("SUB_THIN_FACE_NATURE", 0, BeautyItem.BASICFACE, "自然", "basicV7.natureFace.enable", 2063925598, "https://down.qq.com/shadow_qqcamera/Android/res/自然.png", 0, 100, 40, "");
    SUB_THIN_FACE_NATURE = localBeautySecondaryItem1;
    BeautySecondaryItem localBeautySecondaryItem2 = new BeautySecondaryItem("SUB_THIN_FACE_GIRL", 1, BeautyItem.BASICFACE, "气质", "basicV7.godnessFace.enable", 2063925601, "https://down.qq.com/shadow_qqcamera/Android/res/女神.png", 0, 100, 40, "");
    SUB_THIN_FACE_GIRL = localBeautySecondaryItem2;
    BeautySecondaryItem localBeautySecondaryItem3 = new BeautySecondaryItem("SUB_THIN_FACE_BOY", 2, BeautyItem.BASICFACE, "英俊", "basicV7.maleGodFace.enable", 2063925599, "https://down.qq.com/shadow_qqcamera/Android/res/男神.png", 0, 100, 40, "");
    SUB_THIN_FACE_BOY = localBeautySecondaryItem3;
    BeautySecondaryItem localBeautySecondaryItem4 = new BeautySecondaryItem("SUB_LIPSTICK_NONE", 3, BeautyItem.NONE, "无", "", 0, null, 0, 0, 0, "");
    SUB_LIPSTICK_NONE = localBeautySecondaryItem4;
    BeautySecondaryItem localBeautySecondaryItem5 = new BeautySecondaryItem("SUB_LIPSTICK_MI_TAO", 4, BeautyItem.FACE_FEATURE_LIPS_LUT_ALPHA, "蜜桃色", "lipstick_shanhu", 0, "https://down.qq.com/shadow_qqcamera/Android/res/dy_ae_camera_kou_hong_mi_tao.png", 0, 100, 30, "images/beauty/lips_mitaose.png");
    SUB_LIPSTICK_MI_TAO = localBeautySecondaryItem5;
    BeautySecondaryItem localBeautySecondaryItem6 = new BeautySecondaryItem("SUB_LIPSTICK_SHAN_HU", 5, BeautyItem.FACE_FEATURE_LIPS_LUT_ALPHA, "珊瑚橘", "lipstick_xi_you", 0, "https://down.qq.com/shadow_qqcamera/Android/res/dy_ae_camera_kou_hong_shan_hu.png", 0, 100, 50, "images/beauty/lips_shanhuju.png");
    SUB_LIPSTICK_SHAN_HU = localBeautySecondaryItem6;
    BeautySecondaryItem localBeautySecondaryItem7 = new BeautySecondaryItem("SUB_LIPSTICK_WEN_ROU", 6, BeautyItem.FACE_FEATURE_LIPS_LUT_ALPHA, "温柔粉", "lipstick_dou_sha", 0, "https://down.qq.com/shadow_qqcamera/Android/res/dy_ae_camera_kou_hong_wen_rou.png", 0, 100, 50, "images/beauty/lips_wenroufen.png");
    SUB_LIPSTICK_WEN_ROU = localBeautySecondaryItem7;
    BeautySecondaryItem localBeautySecondaryItem8 = new BeautySecondaryItem("SUB_LIPSTICK_HUO_LI", 7, BeautyItem.FACE_FEATURE_LIPS_LUT_ALPHA, "活力橙", "lipstick_yuan_qi", 0, "https://down.qq.com/shadow_qqcamera/Android/res/dy_ae_camera_kou_hong_huoli.png", 0, 100, 50, "images/beauty/lips_huolicheng.png");
    SUB_LIPSTICK_HUO_LI = localBeautySecondaryItem8;
    BeautySecondaryItem localBeautySecondaryItem9 = new BeautySecondaryItem("SUB_LIPSTICK_FU_GU", 8, BeautyItem.FACE_FEATURE_LIPS_LUT_ALPHA, "复古红", "lipstick_fu_gu", 0, "https://down.qq.com/shadow_qqcamera/Android/res/dy_ae_camera_kou_hong_fu_gu.png", 0, 100, 50, "images/beauty/lips_fuguhong.png");
    SUB_LIPSTICK_FU_GU = localBeautySecondaryItem9;
    BeautySecondaryItem localBeautySecondaryItem10 = new BeautySecondaryItem("SUB_RED_CHEEK_NONE", 9, BeautyItem.NONE, "无", "", 0, null, 0, 0, 0, "");
    SUB_RED_CHEEK_NONE = localBeautySecondaryItem10;
    BeautySecondaryItem localBeautySecondaryItem11 = new BeautySecondaryItem("SUB_RED_CHEEK_JIAN_YUE", 10, BeautyItem.FACE_FEATURE_REDCHEEK, "简约", "red_check_ri_chang", 0, "https://down.qq.com/shadow_qqcamera/Android/res/dy_ae_camera_sai_hong_jian_yue.png", 0, 100, 20, "images/beauty/saihong_jianyue.png");
    SUB_RED_CHEEK_JIAN_YUE = localBeautySecondaryItem11;
    BeautySecondaryItem localBeautySecondaryItem12 = new BeautySecondaryItem("SUB_RED_CHECK_CHENG_SHU", 11, BeautyItem.FACE_FEATURE_REDCHEEK, "成熟", "red_check_tian_cheng", 0, "https://down.qq.com/shadow_qqcamera/Android/res/dy_ae_camera_sai_hong_cheng_shu.png", 0, 100, 50, "images/beauty/saihong_chengshu.png");
    SUB_RED_CHECK_CHENG_SHU = localBeautySecondaryItem12;
    BeautySecondaryItem localBeautySecondaryItem13 = new BeautySecondaryItem("SUB_RED_CHECK_HAI_XIU", 12, BeautyItem.FACE_FEATURE_REDCHEEK, "害羞", "red_check_qiang_wei", 0, "https://down.qq.com/shadow_qqcamera/Android/res/dy_ae_camera_sai_hong_hai_xiu.png", 0, 100, 50, "images/beauty/saihong_haixiu.png");
    SUB_RED_CHECK_HAI_XIU = localBeautySecondaryItem13;
    BeautySecondaryItem localBeautySecondaryItem14 = new BeautySecondaryItem("SUB_RED_CHECK_SHENG_XIA", 13, BeautyItem.FACE_FEATURE_REDCHEEK, "盛夏", "red_check_zhi_xing", 0, "https://down.qq.com/shadow_qqcamera/Android/res/dy_ae_camera_sai_hong_sheng_xia.png", 0, 100, 50, "images/beauty/saihong_shengxia.png");
    SUB_RED_CHECK_SHENG_XIA = localBeautySecondaryItem14;
    BeautySecondaryItem localBeautySecondaryItem15 = new BeautySecondaryItem("SUB_LI_TI_NONE", 14, BeautyItem.NONE, "无", "", 0, null, 0, 0, 0, "");
    SUB_LI_TI_NONE = localBeautySecondaryItem15;
    BeautySecondaryItem localBeautySecondaryItem16 = new BeautySecondaryItem("SUB_LI_TI_GUANG_MANG", 15, BeautyItem.FACE_FEATURE_SOFT, "光芒", "li_ti_shui_guang", 0, "https://down.qq.com/shadow_qqcamera/Android/res/dy_ae_camera_li_ti_guang_mang.png", 0, 100, 40, "images/beauty/liti_guangmang.png");
    SUB_LI_TI_GUANG_MANG = localBeautySecondaryItem16;
    BeautySecondaryItem localBeautySecondaryItem17 = new BeautySecondaryItem("SUB_LI_TI_ZI_RAN", 16, BeautyItem.FACE_FEATURE_SOFT, "自然", "li_ti_zi_ran", 0, "https://down.qq.com/shadow_qqcamera/Android/res/dy_ae_camera_li_ti_zi_ran.png", 0, 100, 40, "images/beauty/liti_ziran.png");
    SUB_LI_TI_ZI_RAN = localBeautySecondaryItem17;
    BeautySecondaryItem localBeautySecondaryItem18 = new BeautySecondaryItem("SUB_LI_TI_QING_XIN", 17, BeautyItem.FACE_FEATURE_SOFT, "清新", "li_ti_jian_ling", 0, "https://down.qq.com/shadow_qqcamera/Android/res/dy_ae_camera_li_ti_qing_xin.png", 0, 100, 40, "images/beauty/liti_qingxin.png");
    SUB_LI_TI_QING_XIN = localBeautySecondaryItem18;
    BeautySecondaryItem localBeautySecondaryItem19 = new BeautySecondaryItem("SUB_LI_TI_JUN_LANG", 18, BeautyItem.FACE_FEATURE_SOFT, "俊朗", "li_ti_ying_jun", 0, "https://down.qq.com/shadow_qqcamera/Android/res/dy_ae_camera_li_ti_jun_lang.png", 0, 100, 40, "images/beauty/liti_junlang.png");
    SUB_LI_TI_JUN_LANG = localBeautySecondaryItem19;
    $VALUES = new BeautySecondaryItem[] { localBeautySecondaryItem1, localBeautySecondaryItem2, localBeautySecondaryItem3, localBeautySecondaryItem4, localBeautySecondaryItem5, localBeautySecondaryItem6, localBeautySecondaryItem7, localBeautySecondaryItem8, localBeautySecondaryItem9, localBeautySecondaryItem10, localBeautySecondaryItem11, localBeautySecondaryItem12, localBeautySecondaryItem13, localBeautySecondaryItem14, localBeautySecondaryItem15, localBeautySecondaryItem16, localBeautySecondaryItem17, localBeautySecondaryItem18, localBeautySecondaryItem19 };
  }
  
  private BeautySecondaryItem(BeautyItem paramBeautyItem, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3, int paramInt4, String paramString4)
  {
    this.parent = paramBeautyItem;
    this.itemName = paramString1;
    this.subType = paramString2;
    this.icon = paramInt1;
    this.iconUrl = paramString3;
    this.min = paramInt2;
    this.max = paramInt3;
    this.defaultValue = paramInt4;
    this.maskPath = paramString4;
  }
  
  public final int getDefaultValue()
  {
    return this.defaultValue;
  }
  
  public final int getIcon()
  {
    return this.icon;
  }
  
  @Nullable
  public final String getIconUrl()
  {
    return this.iconUrl;
  }
  
  @NotNull
  public final String getItemName()
  {
    return this.itemName;
  }
  
  @NotNull
  public final String getMaskPath()
  {
    return this.maskPath;
  }
  
  public final int getMax()
  {
    return this.max;
  }
  
  public final int getMin()
  {
    return this.min;
  }
  
  @NotNull
  public final BeautyItem getParent()
  {
    return this.parent;
  }
  
  @NotNull
  public final String getSubType()
  {
    return this.subType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.BeautySecondaryItem
 * JD-Core Version:    0.7.0.1
 */