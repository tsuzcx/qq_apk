package com.tencent.aelight.camera.aeeditor.module.frame;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TYPE_FRAME", "", "value", "defaultEffect", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getDefaultEffect", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/lang/String;", "setDefaultEffect", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;)V", "frameColor", "getFrameColor", "setFrameColor", "frameDefaultColor", "getFrameDefaultColor", "setFrameDefaultColor", "aelight_impl_release"}, k=2, mv={1, 1, 16})
public final class FrameMetaMaterialKt
{
  @NotNull
  public static final String a(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$frameColor");
    return MetaMaterialKt.a(paramMetaMaterial, "frameColor");
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$frameColor");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "frameColor", paramString);
  }
  
  @NotNull
  public static final String b(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$frameDefaultColor");
    return MetaMaterialKt.a(paramMetaMaterial, "frameDefaultColor");
  }
  
  @NotNull
  public static final String c(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$defaultEffect");
    return MetaMaterialKt.a(paramMetaMaterial, "defaultEffect");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.frame.FrameMetaMaterialKt
 * JD-Core Version:    0.7.0.1
 */