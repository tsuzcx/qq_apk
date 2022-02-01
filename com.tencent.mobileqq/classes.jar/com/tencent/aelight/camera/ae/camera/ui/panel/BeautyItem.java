package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautyItem;", "", "type", "Lcom/tencent/ttpic/openapi/config/BeautyRealConfig$TYPE;", "key", "", "min", "", "max", "defaultValue", "imageResId", "iconUrl", "(Ljava/lang/String;ILcom/tencent/ttpic/openapi/config/BeautyRealConfig$TYPE;Ljava/lang/String;IIIILjava/lang/String;)V", "getDefaultValue", "()I", "getIconUrl", "()Ljava/lang/String;", "getImageResId", "getKey", "getMax", "getMin", "getType", "()Lcom/tencent/ttpic/openapi/config/BeautyRealConfig$TYPE;", "NONE", "RESET", "SKIN", "BASICFACE", "TOOTH_WHITEN", "FACE_FEATURE_SOFT", "FACE_FEATURE_REDCHEEK", "FACE_FEATURE_LIPS_LUT_ALPHA", "REMOVE_POUNCH", "REMOVE_WRINKLES2", "LUT_CLEAR_ALPHA", "LUT_FOUNDATION_ALPHA", "FOREHEAD", "EYE", "MOUTH_SHAPE", "FACE_THIN", "FACE_SMALLER", "NOSE", "CHEEKBONE_THIN", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public enum BeautyItem
{
  private final int defaultValue;
  @Nullable
  private final String iconUrl;
  private final int imageResId;
  @NotNull
  private final String key;
  private final int max;
  private final int min;
  @NotNull
  private final BeautyRealConfig.TYPE type;
  
  static
  {
    BeautyItem localBeautyItem1 = new BeautyItem("NONE", 0, BeautyRealConfig.TYPE.NONE, "无", 0, 0, 0, 2063925620, null);
    NONE = localBeautyItem1;
    BeautyItem localBeautyItem2 = new BeautyItem("RESET", 1, BeautyRealConfig.TYPE.EMPTY, "恢复默认", 0, 0, 0, 2063925312, null);
    RESET = localBeautyItem2;
    BeautyItem localBeautyItem3 = new BeautyItem("SKIN", 2, BeautyRealConfig.TYPE.BEAUTY, "磨皮", 0, 100, 60, 2063925609, "https://down.qq.com/shadow_qqcamera/Android/res/磨皮.png");
    SKIN = localBeautyItem3;
    BeautyItem localBeautyItem4 = new BeautyItem("BASICFACE", 3, BeautyRealConfig.TYPE.FACTOR_THIN_NEW, "瘦脸", 0, 100, 40, 2063925598, "https://down.qq.com/shadow_qqcamera/Android/res/瘦脸.png");
    BASICFACE = localBeautyItem4;
    BeautyItem localBeautyItem5 = new BeautyItem("TOOTH_WHITEN", 4, BeautyRealConfig.TYPE.TOOTH_WHITEN, "白牙", 0, 100, 20, 2063925610, "https://down.qq.com/shadow_qqcamera/Android/res/美牙.png");
    TOOTH_WHITEN = localBeautyItem5;
    BeautyItem localBeautyItem6 = new BeautyItem("FACE_FEATURE_SOFT", 5, BeautyRealConfig.TYPE.FACE_FEATURE_SOFT, "立体", 0, 100, 40, 2063925594, "https://down.qq.com/shadow_qqcamera/Android/res/立体.png");
    FACE_FEATURE_SOFT = localBeautyItem6;
    BeautyItem localBeautyItem7 = new BeautyItem("FACE_FEATURE_REDCHEEK", 6, BeautyRealConfig.TYPE.FACE_FEATURE_REDCHEEK, "腮红", 0, 100, 20, 2063925608, "https://down.qq.com/shadow_qqcamera/Android/res/腮红.png");
    FACE_FEATURE_REDCHEEK = localBeautyItem7;
    BeautyItem localBeautyItem8 = new BeautyItem("FACE_FEATURE_LIPS_LUT_ALPHA", 7, BeautyRealConfig.TYPE.FACE_FEATURE_LIPS_LUT_ALPHA, "口红", 0, 100, 30, 2063925604, "https://down.qq.com/shadow_qqcamera/Android/res/口红.png");
    FACE_FEATURE_LIPS_LUT_ALPHA = localBeautyItem8;
    BeautyItem localBeautyItem9 = new BeautyItem("REMOVE_POUNCH", 8, BeautyRealConfig.TYPE.REMOVE_POUNCH, "黑眼圈", 0, 100, 50, 2063925607, "https://down.qq.com/shadow_qqcamera/Android/res/黑眼圈.png");
    REMOVE_POUNCH = localBeautyItem9;
    BeautyItem localBeautyItem10 = new BeautyItem("REMOVE_WRINKLES2", 9, BeautyRealConfig.TYPE.REMOVE_WRINKLES2, "法令纹", 0, 100, 30, 2063925605, "https://down.qq.com/shadow_qqcamera/Android/res/法令纹.png");
    REMOVE_WRINKLES2 = localBeautyItem10;
    BeautyItem localBeautyItem11 = new BeautyItem("LUT_CLEAR_ALPHA", 10, BeautyRealConfig.TYPE.LUT_CLERA_ALPHA, "清晰", 0, 100, 20, 2063925596, "https://down.qq.com/shadow_qqcamera/Android/res/清晰.png");
    LUT_CLEAR_ALPHA = localBeautyItem11;
    BeautyItem localBeautyItem12 = new BeautyItem("LUT_FOUNDATION_ALPHA", 11, BeautyRealConfig.TYPE.LUT_FOUNDATION_ALPHA, "美白", 0, 100, 30, 2063925595, "https://down.qq.com/shadow_qqcamera/Android/res/美白.png");
    LUT_FOUNDATION_ALPHA = localBeautyItem12;
    BeautyItem localBeautyItem13 = new BeautyItem("FOREHEAD", 12, BeautyRealConfig.TYPE.FOREHEAD, "额头", 0, 100, 0, 2063925602, "https://down.qq.com/shadow_qqcamera/Android/res/额头.png");
    FOREHEAD = localBeautyItem13;
    BeautyItem localBeautyItem14 = new BeautyItem("EYE", 13, BeautyRealConfig.TYPE.EYE, "大眼", 0, 100, 30, 2063925597, "https://down.qq.com/shadow_qqcamera/Android/res/大眼.png");
    EYE = localBeautyItem14;
    BeautyItem localBeautyItem15 = new BeautyItem("MOUTH_SHAPE", 14, BeautyRealConfig.TYPE.MOUTH_SHAPE, "嘴形", -100, 100, 0, 2063925603, "https://down.qq.com/shadow_qqcamera/Android/res/嘴形.png");
    MOUTH_SHAPE = localBeautyItem15;
    BeautyItem localBeautyItem16 = new BeautyItem("FACE_THIN", 15, BeautyRealConfig.TYPE.FACE_THIN, "窄脸", 0, 100, 0, 2063925600, "https://down.qq.com/shadow_qqcamera/Android/res/窄脸.png");
    FACE_THIN = localBeautyItem16;
    BeautyItem localBeautyItem17 = new BeautyItem("FACE_SMALLER", 16, BeautyRealConfig.TYPE.FACTOR_SMALL_NEW, "小脸", 0, 100, 0, 2063925611, "https://down.qq.com/shadow_qqcamera/Android/res/小脸.png");
    FACE_SMALLER = localBeautyItem17;
    BeautyItem localBeautyItem18 = new BeautyItem("NOSE", 17, BeautyRealConfig.TYPE.NOSE, "瘦鼻", 0, 100, 30, 2063925606, "https://down.qq.com/shadow_qqcamera/Android/res/瘦鼻.png");
    NOSE = localBeautyItem18;
    BeautyItem localBeautyItem19 = new BeautyItem("CHEEKBONE_THIN", 18, BeautyRealConfig.TYPE.CHEEKBONE_THIN, "瘦颧骨", 0, 100, 20, 2063925600, "https://down.qq.com/shadow_qqcamera/Android/res/瘦颧骨.png");
    CHEEKBONE_THIN = localBeautyItem19;
    $VALUES = new BeautyItem[] { localBeautyItem1, localBeautyItem2, localBeautyItem3, localBeautyItem4, localBeautyItem5, localBeautyItem6, localBeautyItem7, localBeautyItem8, localBeautyItem9, localBeautyItem10, localBeautyItem11, localBeautyItem12, localBeautyItem13, localBeautyItem14, localBeautyItem15, localBeautyItem16, localBeautyItem17, localBeautyItem18, localBeautyItem19 };
  }
  
  private BeautyItem(BeautyRealConfig.TYPE paramTYPE, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.type = paramTYPE;
    this.key = paramString1;
    this.min = paramInt1;
    this.max = paramInt2;
    this.defaultValue = paramInt3;
    this.imageResId = paramInt4;
    this.iconUrl = paramString2;
  }
  
  public final int getDefaultValue()
  {
    return this.defaultValue;
  }
  
  @Nullable
  public final String getIconUrl()
  {
    return this.iconUrl;
  }
  
  public final int getImageResId()
  {
    return this.imageResId;
  }
  
  @NotNull
  public final String getKey()
  {
    return this.key;
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
  public final BeautyRealConfig.TYPE getType()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.BeautyItem
 * JD-Core Version:    0.7.0.1
 */