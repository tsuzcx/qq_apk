package com.tencent.aelight.camera.aeeditor.module.filter;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"FILTER_ID_AI_PHOTO", "", "FILTER_ID_AI_VIDEO", "FILTER_ID_CYBERPUNK_A", "FILTER_ID_CYBERPUNK_B", "FILTER_ID_CYBERPUNK_VIDEO_A", "FILTER_ID_CYBERPUNK_VIDEO_B", "NONE_FILTER_INDEX", "", "SCHEME_FILTER_ID_AI", "SCHEME_FILTER_ID_CYBERPUNK_A", "SCHEME_FILTER_ID_CYBERPUNK_B", "value", "", "adjustParams", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getAdjustParams", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/util/Map;", "setAdjustParams", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/util/Map;)V", "", "defaultEffectAlpha", "getDefaultEffectAlpha", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)F", "setDefaultEffectAlpha", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;F)V", "Lcom/tencent/aelight/camera/aeeditor/module/filter/EffectType;", "effectType", "getEffectType", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Lcom/tencent/aelight/camera/aeeditor/module/filter/EffectType;", "setEffectType", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Lcom/tencent/aelight/camera/aeeditor/module/filter/EffectType;)V", "glowStrength", "getGlowStrength", "setGlowStrength", "imageShowLevel", "getImageShowLevel", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)I", "setImageShowLevel", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;I)V", "", "isDisableForImage", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Z", "setDisableForImage", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Z)V", "isDisableForVideo", "setDisableForVideo", "isEffectExtendReady", "setEffectExtendReady", "isEnableAdjustAlpha", "setEnableAdjustAlpha", "isEnableApplyAll", "setEnableApplyAll", "isFilterReady", "setFilterReady", "lutID", "getLutID", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/lang/String;", "setLutID", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;)V", "motionID", "getMotionID", "setMotionID", "netStylizeType", "getNetStylizeType", "setNetStylizeType", "uploadMaxSize", "getUploadMaxSize", "setUploadMaxSize", "videoShowLevel", "getVideoShowLevel", "setVideoShowLevel", "convertMaterialIdFromSchemeToFilterId", "materialIdFromScheme", "isImageMode", "aelight_impl_release"}, k=2, mv={1, 1, 16})
public final class FilterMetaMaterialKt
{
  @NotNull
  public static final String a(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "materialIdFromScheme");
    int i = paramString.hashCode();
    String str;
    if (i != -1891716441)
    {
      if (i != -1882585924)
      {
        if (i != 1769378573) {
          return paramString;
        }
        str = paramString;
        if (paramString.equals("effect_cyberpunkII"))
        {
          if (paramBoolean) {
            return "effect_cyberpunk_b";
          }
          return "effect_cyberpunk_video_b";
        }
      }
      else
      {
        str = paramString;
        if (paramString.equals("effect_cyberpunkI"))
        {
          if (paramBoolean) {
            return "effect_cyberpunk_a";
          }
          return "effect_cyberpunk_video_a";
        }
      }
    }
    else
    {
      str = paramString;
      if (paramString.equals("effect_aieffect"))
      {
        if (paramBoolean) {
          return "AIPhotoConfig";
        }
        str = "AIVideoConfig";
      }
    }
    return str;
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$defaultEffectAlpha");
    MetaMaterialKt.a(paramMetaMaterial, "defaultEffectAlpha", (Number)Float.valueOf(paramFloat));
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$lutID");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "lutID", paramString);
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, @Nullable Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$adjustParams");
    MetaMaterialKt.a(paramMetaMaterial, "adjustParams", paramMap);
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static final boolean a(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isFilterReady");
    return MetaMaterialKt.e(paramMetaMaterial, "exFilterReady") == 1;
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$glowStrength");
    MetaMaterialKt.a(paramMetaMaterial, "glowStrength", (Number)Float.valueOf(paramFloat));
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$motionID");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "motionID", paramString);
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static final boolean b(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isEffectExtendReady");
    return MetaMaterialKt.e(paramMetaMaterial, "isEffectExtendReady") == 1;
  }
  
  @NotNull
  public static final EffectType c(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$effectType");
    try
    {
      paramMetaMaterial = MetaMaterialKt.d(paramMetaMaterial, "effectType");
      Locale localLocale = Locale.getDefault();
      Intrinsics.checkExpressionValueIsNotNull(localLocale, "Locale.getDefault()");
      if (paramMetaMaterial != null)
      {
        paramMetaMaterial = paramMetaMaterial.toUpperCase(localLocale);
        Intrinsics.checkExpressionValueIsNotNull(paramMetaMaterial, "(this as java.lang.String).toUpperCase(locale)");
        return EffectType.valueOf(paramMetaMaterial);
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    catch (Exception paramMetaMaterial)
    {
      label54:
      break label54;
    }
    return EffectType.CLIENT;
  }
  
  public static final boolean d(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isEnableApplyAll");
    return MetaMaterialKt.e(paramMetaMaterial, "hideApplyAll") == 0;
  }
  
  public static final boolean e(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isEnableAdjustAlpha");
    return MetaMaterialKt.e(paramMetaMaterial, "hideAlphaBar") == 0;
  }
  
  public static final boolean f(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isDisableForImage");
    return MetaMaterialKt.e(paramMetaMaterial, "disableForImage") == 1;
  }
  
  public static final boolean g(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isDisableForVideo");
    return MetaMaterialKt.e(paramMetaMaterial, "disableForVideo") == 1;
  }
  
  public static final int h(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$imageShowLevel");
    return MetaMaterialKt.e(paramMetaMaterial, "imageShowLevel");
  }
  
  public static final int i(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$videoShowLevel");
    return MetaMaterialKt.e(paramMetaMaterial, "videoShowLevel");
  }
  
  public static final float j(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$defaultEffectAlpha");
    return MetaMaterialKt.f(paramMetaMaterial, "defaultEffectAlpha");
  }
  
  public static final int k(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$uploadMaxSize");
    return MetaMaterialKt.e(paramMetaMaterial, "uploadMaxSize");
  }
  
  public static final int l(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$netStylizeType");
    return MetaMaterialKt.e(paramMetaMaterial, "netStylizeType");
  }
  
  @NotNull
  public static final String m(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$lutID");
    return MetaMaterialKt.d(paramMetaMaterial, "lutID");
  }
  
  public static final float n(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$glowStrength");
    return MetaMaterialKt.f(paramMetaMaterial, "glowStrength");
  }
  
  @NotNull
  public static final String o(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$motionID");
    return MetaMaterialKt.d(paramMetaMaterial, "motionID");
  }
  
  @Nullable
  public static final Map<String, String> p(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$adjustParams");
    return MetaMaterialKt.g(paramMetaMaterial, "adjustParams");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.FilterMetaMaterialKt
 * JD-Core Version:    0.7.0.1
 */