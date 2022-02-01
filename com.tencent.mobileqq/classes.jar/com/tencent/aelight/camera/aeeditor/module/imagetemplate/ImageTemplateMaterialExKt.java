package com.tencent.aelight.camera.aeeditor.module.imagetemplate;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"value", "", "isImageTemplateReady", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Z", "setImageTemplateReady", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Z)V", "isImageTemplateRealReady", "setImageTemplateRealReady", "", "templateJson", "getTemplateJson", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/lang/String;", "setTemplateJson", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;)V", "aelight_impl_release"}, k=2, mv={1, 1, 16})
public final class ImageTemplateMaterialExKt
{
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$templateJson");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "templateJson", paramString);
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static final boolean a(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isImageTemplateReady");
    return MetaMaterialKt.e(paramMetaMaterial, "isImageTemplateReady") == 1;
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isImageTemplateRealReady");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorResourceManager.a().a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append(".log");
    paramMetaMaterial = new File(localStringBuilder.toString());
    if (paramBoolean)
    {
      paramMetaMaterial.createNewFile();
      return;
    }
    paramMetaMaterial.delete();
  }
  
  public static final boolean b(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isImageTemplateRealReady");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorResourceManager.a().a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append(".log");
    return new File(localStringBuilder.toString()).exists();
  }
  
  @NotNull
  public static final String c(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$templateJson");
    return MetaMaterialKt.d(paramMetaMaterial, "templateJson");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.imagetemplate.ImageTemplateMaterialExKt
 * JD-Core Version:    0.7.0.1
 */