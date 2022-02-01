package com.tencent.aelight.camera.aeeditor.module.text;

import android.content.res.Resources;
import android.graphics.Color;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/aeeditor/module/text/TextMetaMaterialHelper$Companion;", "", "()V", "newDefaultTextMaterial", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "material", "newNonTextMaterial", "materialId", "", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class TextMetaMaterialHelper$Companion
{
  @NotNull
  public final MetaMaterial a(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "material");
    MetaMaterial localMetaMaterial = new MetaMaterial();
    localMetaMaterial.id = "DEFAULT_ID";
    TextMetaMaterialKt.c(localMetaMaterial, "Font");
    Object localObject = BaseApplicationImpl.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getContext()");
    localObject = ((BaseApplication)localObject).getResources().getString(2064515196);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getC…e_editor_text_thumb_text)");
    MetaMaterialKt.c(localMetaMaterial, (String)localObject);
    TextMetaMaterialKt.a(localMetaMaterial, true);
    TextMetaMaterialKt.a(localMetaMaterial, "plain_text");
    TextMetaMaterialKt.a(localMetaMaterial, Color.parseColor("#FFFFFF"));
    paramMetaMaterial = paramMetaMaterial.additionalFields;
    if (paramMetaMaterial != null)
    {
      paramMetaMaterial = paramMetaMaterial.entrySet().iterator();
      while (paramMetaMaterial.hasNext())
      {
        localObject = (Map.Entry)paramMetaMaterial.next();
        Map localMap = localMetaMaterial.additionalFields;
        Intrinsics.checkExpressionValueIsNotNull(localMap, "default.additionalFields");
        localMap.put(((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      }
    }
    return localMetaMaterial;
  }
  
  @NotNull
  public final MetaMaterial a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "materialId");
    MetaMaterial localMetaMaterial = new MetaMaterial();
    localMetaMaterial.id = paramString;
    localMetaMaterial.thumbUrl = "thumbNon";
    TextMetaMaterialKt.a(localMetaMaterial, true);
    return localMetaMaterial;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.TextMetaMaterialHelper.Companion
 * JD-Core Version:    0.7.0.1
 */