package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyConfigModel;", "", "item", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautyItem;", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautyItem;)V", "defaultValue", "", "getDefaultValue", "()I", "setDefaultValue", "(I)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "iconUrl", "", "getIconUrl", "()Ljava/lang/String;", "imageResId", "getImageResId", "setImageResId", "getItem", "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautyItem;", "key", "getKey", "setKey", "(Ljava/lang/String;)V", "max", "getMax", "setMax", "min", "getMin", "setMin", "secondaryConfigs", "", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautySecondaryConfigModel;", "getSecondaryConfigs", "()Ljava/util/List;", "setSecondaryConfigs", "(Ljava/util/List;)V", "secondarySelectDefault", "getSecondarySelectDefault", "setSecondarySelectDefault", "type", "Lcom/tencent/ttpic/openapi/config/BeautyRealConfig$TYPE;", "getType", "()Lcom/tencent/ttpic/openapi/config/BeautyRealConfig$TYPE;", "setType", "(Lcom/tencent/ttpic/openapi/config/BeautyRealConfig$TYPE;)V", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public class AEBeautyConfigModel
{
  @NotNull
  private BeautyRealConfig.TYPE a;
  @NotNull
  private String b;
  private int c;
  private int d;
  private int e;
  private int f;
  @NotNull
  private final String g;
  private boolean h;
  @NotNull
  private List<AEBeautySecondaryConfigModel> i;
  private int j;
  @NotNull
  private final BeautyItem k;
  
  public AEBeautyConfigModel(@NotNull BeautyItem paramBeautyItem)
  {
    this.k = paramBeautyItem;
    this.a = BeautyRealConfig.TYPE.NONE;
    this.b = "无";
    paramBeautyItem = this.k.getIconUrl();
    if (paramBeautyItem == null) {
      paramBeautyItem = "";
    }
    this.g = paramBeautyItem;
    this.h = true;
    this.i = ((List)new ArrayList());
    this.a = this.k.getType();
    this.b = this.k.getKey();
    this.c = this.k.getMin();
    this.d = this.k.getMax();
    this.e = this.k.getDefaultValue();
    this.f = this.k.getImageResId();
    paramBeautyItem = this.a;
    if (paramBeautyItem == BeautyItem.BASICFACE.getType())
    {
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_THIN_FACE_NATURE));
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_THIN_FACE_GIRL));
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_THIN_FACE_BOY));
      this.j = 0;
      return;
    }
    if (paramBeautyItem == BeautyItem.FACE_FEATURE_LIPS_LUT_ALPHA.getType())
    {
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_LIPSTICK_NONE));
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_LIPSTICK_MI_TAO));
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_LIPSTICK_SHAN_HU));
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_LIPSTICK_WEN_ROU));
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_LIPSTICK_FU_GU));
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_LIPSTICK_HUO_LI));
      this.j = 1;
      return;
    }
    if (paramBeautyItem == BeautyItem.FACE_FEATURE_REDCHEEK.getType())
    {
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_RED_CHEEK_NONE));
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_RED_CHEEK_JIAN_YUE));
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_RED_CHECK_CHENG_SHU));
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_RED_CHECK_HAI_XIU));
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_RED_CHECK_SHENG_XIA));
      this.j = 1;
      return;
    }
    if (paramBeautyItem == BeautyItem.FACE_FEATURE_SOFT.getType())
    {
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_LI_TI_NONE));
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_LI_TI_GUANG_MANG));
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_LI_TI_ZI_RAN));
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_LI_TI_QING_XIN));
      this.i.add(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_LI_TI_JUN_LANG));
      this.j = 1;
    }
  }
  
  @NotNull
  public final BeautyRealConfig.TYPE a()
  {
    return this.a;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  public final int e()
  {
    return this.e;
  }
  
  public final int f()
  {
    return this.f;
  }
  
  @NotNull
  public final String g()
  {
    return this.g;
  }
  
  public final boolean h()
  {
    return this.h;
  }
  
  @NotNull
  public final List<AEBeautySecondaryConfigModel> i()
  {
    return this.i;
  }
  
  public final int j()
  {
    return this.j;
  }
  
  @NotNull
  public final BeautyItem k()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyConfigModel
 * JD-Core Version:    0.7.0.1
 */