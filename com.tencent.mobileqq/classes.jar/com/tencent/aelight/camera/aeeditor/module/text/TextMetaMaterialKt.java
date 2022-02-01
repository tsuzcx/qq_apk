package com.tencent.aelight.camera.aeeditor.module.text;

import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorPagStickerConfig;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorPagStickerConfig.FrameConfig;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorPagStickerConfig.StyleConfig;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGText;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"DEFAULT_ID", "", "FONT_PATTERN", "FONT_PATTERN_NON_ID", "FONT_STYLE", "FONT_STYLE_NON_ID", "FONT_TYPE", "KEY_NOT_INTERACTIVE", "", "TAG", "TEXT_KUOLIE_ID", "value", "", "angle", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getAngle", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)F", "setAngle", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;F)V", "backgroundColor", "getBackgroundColor", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)I", "setBackgroundColor", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;I)V", "blurTextPath", "getBlurTextPath", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/lang/String;", "setBlurTextPath", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;)V", "blurTexturePath", "getBlurTexturePath", "setBlurTexturePath", "configJsonPath", "getConfigJsonPath", "setConfigJsonPath", "content", "getContent", "setContent", "defaultColor", "getDefaultColor", "setDefaultColor", "fontId", "getFontId", "setFontId", "", "isInteractive", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Z", "setInteractive", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Z)V", "isTextReady", "setTextReady", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "pagFilePath", "getPagFilePath", "setPagFilePath", "scale", "getScale", "setScale", "textColor", "getTextColor", "setTextColor", "textStickerResourceType", "getTextStickerResourceType", "setTextStickerResourceType", "type", "getType", "setType", "initTextMaterials", "", "categoryId", "materials", "init", "", "updateTextByPagStickerConfig", "config", "Lcom/tencent/aelight/camera/aeeditor/manage/AEEditorPagStickerConfig;", "aelight_impl_release"}, k=2, mv={1, 1, 16})
public final class TextMetaMaterialKt
{
  public static final float a(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$scale");
    return MetaMaterialKt.a(paramMetaMaterial, "scale", 0.5F);
  }
  
  public static final int a(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$textColor");
    return MetaMaterialKt.a(paramMetaMaterial, "textColor");
  }
  
  @NotNull
  public static final String a(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$type");
    return MetaMaterialKt.a(paramMetaMaterial, "type");
  }
  
  @NotNull
  public static final List<MetaMaterial> a(@NotNull String paramString, @NotNull List<MetaMaterial> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "categoryId");
    Intrinsics.checkParameterIsNotNull(paramList, "materials");
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      i((MetaMaterial)localIterator.next(), paramString);
    }
    return paramList;
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$angle");
    MetaMaterialKt.a(paramMetaMaterial, "angle", (Number)Float.valueOf(paramFloat));
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$textColor");
    MetaMaterialKt.a(paramMetaMaterial, "textColor", (Number)Integer.valueOf(paramInt));
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, @NotNull AEEditorPagStickerConfig paramAEEditorPagStickerConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$updateTextByPagStickerConfig");
    Intrinsics.checkParameterIsNotNull(paramAEEditorPagStickerConfig, "config");
    if (!a(paramMetaMaterial))
    {
      if (paramAEEditorPagStickerConfig.frameConfig != null)
      {
        a(paramMetaMaterial, paramAEEditorPagStickerConfig.frameConfig.angle);
        b(paramMetaMaterial, paramAEEditorPagStickerConfig.frameConfig.scale);
        c(paramMetaMaterial, paramAEEditorPagStickerConfig.frameConfig.minScale);
        d(paramMetaMaterial, paramAEEditorPagStickerConfig.frameConfig.maxScale);
      }
      Object localObject = paramAEEditorPagStickerConfig.type;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "config.type");
      a(paramMetaMaterial, (String)localObject);
      if (TextUtils.isEmpty((CharSequence)a(paramMetaMaterial)))
      {
        a(paramMetaMaterial, "fixed_text");
      }
      else if (Intrinsics.areEqual(a(paramMetaMaterial), "blur"))
      {
        g(paramMetaMaterial, AEEditorResourceManager.a().g(paramMetaMaterial));
        h(paramMetaMaterial, AEEditorResourceManager.a().h(paramMetaMaterial));
      }
      try
      {
        if (new File(f(paramMetaMaterial)).exists())
        {
          localObject = PAGFile.Load(f(paramMetaMaterial));
        }
        else
        {
          localObject = AEEditorResourceManager.a();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "AEEditorResourceManager.getInstance()");
          localObject = PAGFile.Load(((AEEditorResourceManager)localObject).c());
        }
        if (((PAGFile)localObject).numTexts() > 0)
        {
          String str = ((PAGFile)localObject).getTextData(0).text;
          Intrinsics.checkExpressionValueIsNotNull(str, "pagFile.getTextData(0).text");
          e(paramMetaMaterial, str);
          a(paramMetaMaterial, ((PAGFile)localObject).getTextData(0).fillColor);
        }
      }
      catch (Exception localException)
      {
        AEQLog.a("TextMetaMaterial", "updateTextByPagStickerConfig", (Throwable)localException);
      }
      if ((paramAEEditorPagStickerConfig.styleConfig != null) && (!TextUtils.isEmpty((CharSequence)paramAEEditorPagStickerConfig.styleConfig.defaultColor)))
      {
        b(paramMetaMaterial, Color.parseColor(paramAEEditorPagStickerConfig.styleConfig.defaultColor));
        paramAEEditorPagStickerConfig = a(paramMetaMaterial);
        int i = paramAEEditorPagStickerConfig.hashCode();
        if (i != 1021751938)
        {
          if ((i == 1289680009) && (paramAEEditorPagStickerConfig.equals("color_text")))
          {
            c(paramMetaMaterial, b(paramMetaMaterial));
            int j = c(paramMetaMaterial);
            i = -1;
            if (j == -1) {
              i = AEEditorColorSelectorView.a;
            }
            a(paramMetaMaterial, i);
          }
        }
        else if (paramAEEditorPagStickerConfig.equals("plain_text")) {
          a(paramMetaMaterial, b(paramMetaMaterial));
        }
      }
      a(paramMetaMaterial, true);
    }
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$type");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "type", paramString);
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static final boolean a(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isTextReady");
    return MetaMaterialKt.a(paramMetaMaterial, "isTextReady") == 1;
  }
  
  public static final float b(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$minScale");
    return MetaMaterialKt.a(paramMetaMaterial, "minScale", 0.18F);
  }
  
  public static final int b(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$defaultColor");
    return MetaMaterialKt.a(paramMetaMaterial, "defaultColor");
  }
  
  @NotNull
  public static final String b(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$configJsonPath");
    return MetaMaterialKt.a(paramMetaMaterial, "configJsonPath");
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$scale");
    MetaMaterialKt.a(paramMetaMaterial, "scale", (Number)Float.valueOf(paramFloat));
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$defaultColor");
    MetaMaterialKt.a(paramMetaMaterial, "defaultColor", (Number)Integer.valueOf(paramInt));
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$configJsonPath");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "configJsonPath", paramString);
  }
  
  public static final boolean b(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isInteractive");
    return MetaMaterialKt.a(paramMetaMaterial, "interactive") > 0;
  }
  
  public static final float c(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$maxScale");
    return MetaMaterialKt.a(paramMetaMaterial, "maxScale", 1.0F);
  }
  
  public static final int c(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$backgroundColor");
    return MetaMaterialKt.a(paramMetaMaterial, "backgroundColor");
  }
  
  @NotNull
  public static final String c(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$textStickerResourceType");
    return MetaMaterialKt.a(paramMetaMaterial, "textStickerResourceType");
  }
  
  public static final void c(@NotNull MetaMaterial paramMetaMaterial, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$minScale");
    MetaMaterialKt.a(paramMetaMaterial, "minScale", (Number)Float.valueOf(paramFloat));
  }
  
  public static final void c(@NotNull MetaMaterial paramMetaMaterial, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$backgroundColor");
    MetaMaterialKt.a(paramMetaMaterial, "backgroundColor", (Number)Integer.valueOf(paramInt));
  }
  
  public static final void c(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$textStickerResourceType");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "textStickerResourceType", paramString);
  }
  
  @NotNull
  public static final String d(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$fontId");
    return MetaMaterialKt.a(paramMetaMaterial, "fontID");
  }
  
  public static final void d(@NotNull MetaMaterial paramMetaMaterial, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$maxScale");
    MetaMaterialKt.a(paramMetaMaterial, "maxScale", (Number)Float.valueOf(paramFloat));
  }
  
  public static final void d(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$fontId");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "fontID", paramString);
  }
  
  @NotNull
  public static final String e(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$content");
    return MetaMaterialKt.a(paramMetaMaterial, "content");
  }
  
  public static final void e(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$content");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "content", paramString);
  }
  
  @Nullable
  public static final String f(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$pagFilePath");
    return MetaMaterialKt.a(paramMetaMaterial, "pagFilePath");
  }
  
  public static final void f(@NotNull MetaMaterial paramMetaMaterial, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$pagFilePath");
    MetaMaterialKt.a(paramMetaMaterial, "pagFilePath", paramString);
  }
  
  @Nullable
  public static final String g(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$blurTextPath");
    return MetaMaterialKt.a(paramMetaMaterial, "blurTextPath");
  }
  
  public static final void g(@NotNull MetaMaterial paramMetaMaterial, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$blurTextPath");
    MetaMaterialKt.a(paramMetaMaterial, "blurTextPath", paramString);
  }
  
  @Nullable
  public static final String h(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$blurTexturePath");
    return MetaMaterialKt.a(paramMetaMaterial, "blurTexturePath");
  }
  
  public static final void h(@NotNull MetaMaterial paramMetaMaterial, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$blurTexturePath");
    MetaMaterialKt.a(paramMetaMaterial, "blurTexturePath", paramString);
  }
  
  public static final void i(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$init");
    Intrinsics.checkParameterIsNotNull(paramString, "categoryId");
    MetaMaterialKt.a(paramMetaMaterial, paramString);
    paramString = c(paramMetaMaterial);
    int i = paramString.hashCode();
    if (i != 2195567)
    {
      if ((i == 80227729) && (paramString.equals("Style")))
      {
        paramString = AEEditorResourceManager.a().e(paramMetaMaterial);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "AEEditorResourceManager.…tTextConfigJsonPath(this)");
        b(paramMetaMaterial, paramString);
        f(paramMetaMaterial, AEEditorResourceManager.a().f(paramMetaMaterial));
        paramString = BaseApplicationImpl.getContext();
        Intrinsics.checkExpressionValueIsNotNull(paramString, "BaseApplicationImpl.getContext()");
        paramString = paramString.getResources().getString(2064515191);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "BaseApplicationImpl.getC…tor_text_default_content)");
        e(paramMetaMaterial, paramString);
      }
    }
    else if (paramString.equals("Font"))
    {
      paramString = AEEditorResourceManager.a();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "AEEditorResourceManager.getInstance()");
      paramString = paramString.d();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "AEEditorResourceManager.…textDefaultConfigJsonPath");
      b(paramMetaMaterial, paramString);
      paramString = AEEditorResourceManager.a();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "AEEditorResourceManager.getInstance()");
      f(paramMetaMaterial, paramString.c());
      paramString = paramMetaMaterial.id;
      Intrinsics.checkExpressionValueIsNotNull(paramString, "id");
      d(paramMetaMaterial, paramString);
      paramString = BaseApplicationImpl.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "BaseApplicationImpl.getContext()");
      paramString = paramString.getResources().getString(2064515191);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "BaseApplicationImpl.getC…tor_text_default_content)");
      e(paramMetaMaterial, paramString);
      return;
    }
    paramString = AEEditorResourceManager.a().e(paramMetaMaterial);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "AEEditorResourceManager.…tTextConfigJsonPath(this)");
    b(paramMetaMaterial, paramString);
    f(paramMetaMaterial, AEEditorResourceManager.a().f(paramMetaMaterial));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.TextMetaMaterialKt
 * JD-Core Version:    0.7.0.1
 */